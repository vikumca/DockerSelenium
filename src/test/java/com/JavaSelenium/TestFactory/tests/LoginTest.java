package com.JavaSelenium.TestFactory.tests;

import com.JavaSelenium.TestFactory.TestFactory.HomePage;
import com.JavaSelenium.TestFactory.TestFactory.LoginPage;
import com.JavaSelenium.TestFactory.base.BaseTest;
import com.JavaSelenium.TestFactory.core.exception.FrameworkExceptions;
import com.JavaSelenium.TestFactory.core.logger.Logs;
import com.JavaSelenium.TestFactory.core.pages.AllPages;
import com.JavaSelenium.TestFactory.core.ui.implementations.Alert;
import com.JavaSelenium.TestFactory.core.utils.ListenerClass;
import com.JavaSelenium.TestFactory.core.utils.RallyIntegration;
import com.JavaSelenium.TestFactory.core.utils.Waits;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Listeners({ ListenerClass.class })
public class LoginTest extends BaseTest{

    private HomePage getHomePage() {return AllPages.getPage(HomePage.class);}
    private LoginPage getLoginPage() {return AllPages.getPage(LoginPage.class);}
    private Alert getAlert() {return AllPages.getPage(Alert.class);}
    private String TestCaseID = "";

    @Test(enabled = false)
    public void loginTest(ITestContext testContext) throws FrameworkExceptions{
        TestCaseID="TC11573";
        testContext.setAttribute("WebDriver", driver);
        Assertions.setSoftAssert(new SoftAssert());
        Alert getAlert = getAlert();

        getHomePage().clickLoginPortal();
        Assertions.logInformation("Navigated to Login Portal Page");
        Waits.waitForPageLoadJS();
        String windowName = driver.getWindowHandle();
        getLoginPage().getWindow().switchToWindowAfterNewWindowFocused();

        getLoginPage().enterUserName("TestFactory");
        Assertions.logInformation("Entered the user name");
        getLoginPage().enterPassord("TestFactoryPassword");
        Assertions.logInformation("Entered the password");
        getLoginPage().clickLogin();
        Assertions.logInformation("Clicked on the Login button");
        getAlert.waitForAlert();

        //Verify Past date Alert Message
        String strAlertMsg = getAlert.getAlertText();
        Assertions.softAssertEquals(strAlertMsg, "validation failed", "Alert message appears ");
        getAlert.clickAlert();

        //Close the lookup window & switch control to main page
        driver.close();
        driver.switchTo().window(windowName);

        Assertions.assertAll();

    }

    @AfterMethod(alwaysRun = true)
    public void updateTestCaseStatus(ITestResult result) throws FrameworkExceptions,Exception{
        if(result.getStatus() == ITestResult.SUCCESS ){
            RallyIntegration.updatedTestCaseStatusInRally(TestCaseID,result.getStatus(),"Hackthon 1.0","Automated features");
        }
        else if(result.getStatus() == ITestResult.FAILURE){
            result.getMethod();
            RallyIntegration.updatedTestCaseStatusInRally(TestCaseID,result.getStatus(),"Hackthon 1.0","Automated features");
        }
        else{
            Logs.error("Exception Occurred");
        }
    }


}
