package com.JavaSelenium.TestFactory.stepDefinitions;

import com.JavaSelenium.TestFactory.TestFactory.GoogleSearchPage;
import com.JavaSelenium.TestFactory.core.exception.FrameworkExceptions;
import com.JavaSelenium.TestFactory.core.helper.Constants;
import com.JavaSelenium.TestFactory.core.logger.Logs;
import com.JavaSelenium.TestFactory.core.pages.AllPages;
import com.JavaSelenium.TestFactory.core.utils.Assertions;
import com.JavaSelenium.TestFactory.core.utils.Config;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import com.JavaSelenium.TestFactory.core.driver.DriverSetup;
import org.openqa.selenium.WebDriver;

public class GoogleSearchSteps {
    WebDriver driver;
    Assertions assertions;
    private GoogleSearchPage googleSearchPage() {return AllPages.getPage(GoogleSearchPage.class);}

    @Given("^Goto Google HomePage \"(.*)\"$")
    public void gotoGoogleSearchPage(String url) throws Exception{
        DriverSetup.initializeDriver(Config.getConfigProperty(Constants.BROWSERTYPE));
        driver = DriverSetup.getDriver();
        driver.get(url);
        Logs.info("Navigated to url--"+url);
    }

    @When("^Enter \"(.*)\" in the search text field$")
    public void setTextToSearch(String textToBeSearched) throws Exception {
        Thread.sleep(3000);
        googleSearchPage().setSearchedText(textToBeSearched);
    }

    @And("^Click on Search Button$")
    public void clickSearchButton() throws FrameworkExceptions {
        googleSearchPage().clickSearchButton();
    }

    @After
    public void logoutAndCloseOpenedBrowsers(){
        if ( driver != null) {
            driver.close();
            driver.quit();
        }
    }
}
