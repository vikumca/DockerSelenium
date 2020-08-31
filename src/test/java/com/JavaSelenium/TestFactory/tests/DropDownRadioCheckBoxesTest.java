package com.JavaSelenium.TestFactory.tests;

import com.JavaSelenium.TestFactory.TestFactory.DropdownCheckboxesRadioButtonsPage;
import com.JavaSelenium.TestFactory.TestFactory.HomePage;
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
public class DropDownRadioCheckBoxesTest extends BaseTest{

    private HomePage getHomePage() {return AllPages.getPage(HomePage.class);}
    private DropdownCheckboxesRadioButtonsPage getDDRaChBoxPage() {return AllPages.getPage(DropdownCheckboxesRadioButtonsPage.class);}
    String TestCaseID="";

    @Test
    public void loginTest(ITestContext testContext) throws FrameworkExceptions {
        TestCaseID="TC11574";
        testContext.setAttribute("WebDriver", driver);
        Assertions.setSoftAssert(new SoftAssert());

        getHomePage().clickDropDownRadioCheckBoxesLink();
        Assertions.logInformation("Navigated to Dropdown-Checkboxes-RadioButtons Page");
        Waits.waitForPageLoadJS();
        String windowName = driver.getWindowHandle();
        getDDRaChBoxPage().getWindow().switchToWindowAfterNewWindowFocused();

        getDDRaChBoxPage().selectFirstDropDown("JAVA");
        Assertions.logInformation("Selected the value of first Drop Down");
        getDDRaChBoxPage().selectFirstDropDown("Eclipse");
        Assertions.logInformation("Selected the value of second Drop Down");
        getDDRaChBoxPage().selectThirdDropDown("CSS");
        Assertions.logInformation("Selected the value of third Drop Down");

        getDDRaChBoxPage().selectCheckBoxes();
        Assertions.logInformation("Selected all the checkboxes");

        getDDRaChBoxPage().selectGreenRadioButton();
        Assertions.logInformation("Selected Green Radio Button");

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
