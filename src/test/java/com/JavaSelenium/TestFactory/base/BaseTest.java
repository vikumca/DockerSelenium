package com.JavaSelenium.TestFactory.base;

import com.JavaSelenium.TestFactory.core.driver.DriverSetup;
import com.JavaSelenium.TestFactory.core.exception.FrameworkExceptions;
import com.JavaSelenium.TestFactory.core.helper.Constants;
import com.JavaSelenium.TestFactory.core.logger.Logs;
import com.JavaSelenium.TestFactory.core.utils.Config;
import com.JavaSelenium.TestFactory.core.utils.Waits;
import com.jacob.com.LibraryLoader;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import com.JavaSelenium.TestFactory.core.utils.Assertions;

import java.io.File;

public class BaseTest {

    protected Assertions Assertions;
    protected WebDriver driver;
    protected String strUsername;
    protected String strPassword;
    protected String baseURL;

    @BeforeClass(alwaysRun = true)
    public void init() {
        try {
            Assertions = new Assertions();
            Logs.info("================================ TEST STARTS NOW  =========================================");
        } catch (Exception e) {
            System.out.println("Exceptions:  " + e);
        }
    }

    @BeforeClass(alwaysRun = true)
    public void startingMethodPreReq() {
        try {
            File file = new File("src\\main\\resources\\", "jacob-1.15-M4-x64.dll"); //path to the jacob dll
            System.setProperty(LibraryLoader.JACOB_DLL_PATH, file.getAbsolutePath());

            String browserEnvironmentVariable = System.getenv("BROWSER");
            String browser;
            if (browserEnvironmentVariable == null || browserEnvironmentVariable.equalsIgnoreCase("null")) {
                browser = Config.getConfigProperty(Constants.BROWSERTYPE);
            } else {
                browser = browserEnvironmentVariable;
            }
            DriverSetup.initializeDriver(browser);
            driver = DriverSetup.getDriver();
            driver.manage().window().maximize();
            baseURL = Config.getConfigProperty(Constants.APPURL);
            Logs.info(baseURL);
            Logs.info("================================ TEST METHOD STARTS  =========================================");
            gotoUrl(baseURL);
            Waits.waitForPageLoadJS();
            Waits.explicitWait();
        } catch (final Exception e) {
            Logs.error("Failed to start the scenario"+ e);
        }
    }

    @AfterClass(alwaysRun = true)
    public void logoutAndCloseOpenedBrowsers() throws FrameworkExceptions {
        try {
            if (DriverSetup.browserInitialized && driver != null) {
                driver.close();
                driver.quit();
            }
            Logs.info("================================ TEST METHOD ENDS  =========================================");
        }
        catch (Exception fe)
        {
            driver.quit();
            throw new FrameworkExceptions("Failed to Close the Opened browsers"+fe);
        }
    }

    // Login to TP Application
    protected void gotoUrl(String url) {
        driver.get(url);
        Waits.waitForPageLoadJS();
        Logs.info("Navigated to " + url + " link");
    }
}
