package com.JavaSelenium.TestFactory.core.ui.implementations;

import com.JavaSelenium.TestFactory.core.driver.DriverSetup;
import com.JavaSelenium.TestFactory.core.exception.FrameworkExceptions;
import com.JavaSelenium.TestFactory.core.helper.Constants;
import com.JavaSelenium.TestFactory.core.logger.Logs;
import com.JavaSelenium.TestFactory.core.ui.IAlert;
import com.JavaSelenium.TestFactory.core.utils.Config;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Alert extends Element implements IAlert {

    public Alert()
    {
        driver = DriverSetup.getDriver();
    }

    public Alert(WebElement element, String elementName) {
        super(element, elementName);
    }

    // clickAlert Method for alert dialog
    @Override
    public void clickAlert() throws FrameworkExceptions {
        try {
            new WebDriverWait(driver, Integer.parseInt(Config.getConfigProperty(Constants.ELEMENTWAITTIME)))
                    .ignoring(NoAlertPresentException.class)
                    .until(ExpectedConditions.alertIsPresent());
            org.openqa.selenium.Alert alert = driver.switchTo().alert();
            alert.accept();

        } catch (NoAlertPresentException nape) {
            Logs.error(Constants.FORMATTER + Constants.FAILURE_METHOD_MESSAGE + "clickAlert() of Alert class, alert not present." );
            throw new FrameworkExceptions(Constants.FORMATTER + Constants.FAILURE_METHOD_MESSAGE + "clickAlert() of Alert class, alert not present." + nape);
        } catch (Exception fe) {
            Logs.error(Constants.FORMATTER + Constants.FAILURE_METHOD_MESSAGE + "clickAlert() of Alert class.");
            throw new FrameworkExceptions(Constants.FORMATTER + Constants.FAILURE_METHOD_MESSAGE + "clickAlert() of Alert class." + fe);
        }

    }

    //dismissAlert Method for alert dialog
    public void dismissAlert() throws FrameworkExceptions {
        try {
            if (isAlertPresent()) {
                driver.switchTo().alert().dismiss();
            }
        } catch (Exception fe) {
            Logs.error(Constants.FORMATTER + Constants.FAILURE_METHOD_MESSAGE + "dismissAlert() of Alert class");
            throw new FrameworkExceptions(Constants.FORMATTER + Constants.FAILURE_METHOD_MESSAGE + "dismissAlert() of Alert class." + fe);
        }
    }

    // Accept Alert
    @Override
    public void acceptAlert() throws FrameworkExceptions {
        try{
            if(isAlertPresent()){
                driver.switchTo().alert().accept();
                Logs.info("Clicked on the alert Pop-up");
            }
        } catch (NoAlertPresentException nape) {
            Logs.info("Alert does not exist");
        } catch (Exception fe) {
            Logs.error(Constants.FORMATTER + Constants.FAILURE_METHOD_MESSAGE + "acceptAlert() of Alert class");
            throw new FrameworkExceptions(Constants.FORMATTER + Constants.FAILURE_METHOD_MESSAGE + "acceptAlert() of Alert class." + fe);
        }

    }

    //Verify the Alert is Present
    @Override
    public boolean isAlertPresent() throws FrameworkExceptions {
        try{
            driver.switchTo().alert();
            return true;
        } catch(NoAlertPresentException nape){
            Logs.info("Alert does not exist");
            return false;
        } catch (Exception fe) {
            Logs.error(Constants.FORMATTER + Constants.FAILURE_METHOD_MESSAGE + "isAlertPresent() of Alert class.");
            return false;
        }
    }

    // Get the text from Alert dialog
    @Override
    public String getAlertText() throws FrameworkExceptions {
        String strAlertText = "";
        try {
            if (isAlertPresent()) {
                strAlertText = driver.switchTo().alert().getText();
            }
        } catch (Exception fe) {
            Logs.error(Constants.FORMATTER + Constants.FAILURE_METHOD_MESSAGE + "getAlertText() of Alert class.");
            throw new FrameworkExceptions(Constants.FORMATTER + Constants.FAILURE_METHOD_MESSAGE + "getAlertText() of Alert class." + fe);
        }
        return strAlertText;
    }

    /**
     * To Wait for Alert dialogue
     */
    // WaitForAlert Method for alert dialog
    public void waitForAlert() throws FrameworkExceptions {
        try {
            new WebDriverWait(driver, Integer.parseInt(Config.getConfigProperty(Constants.ELEMENTWAITTIME)))
                    .ignoring(NoAlertPresentException.class)
                    .until(ExpectedConditions.alertIsPresent());

        } catch (Exception fe) {
            Logs.error(Constants.FORMATTER + Constants.FAILURE_METHOD_MESSAGE + "waitForAlert() of Alert class.");
            throw new FrameworkExceptions(Constants.FORMATTER + Constants.FAILURE_METHOD_MESSAGE + "waitForAlert() of Alert class." + fe);
        }
    }
}
