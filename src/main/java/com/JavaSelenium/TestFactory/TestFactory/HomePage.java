package com.JavaSelenium.TestFactory.TestFactory;

import com.JavaSelenium.TestFactory.core.exception.FrameworkExceptions;
import com.JavaSelenium.TestFactory.core.logger.Logs;
import com.JavaSelenium.TestFactory.core.pages.Components;
import com.JavaSelenium.TestFactory.core.ui.IElement;
import com.JavaSelenium.TestFactory.core.ui.IHyperLink;
import com.JavaSelenium.TestFactory.core.ui.implementations.Element;
import com.JavaSelenium.TestFactory.core.ui.implementations.HyperLink;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends Components{

    @FindBy(xpath = "//*[@id='login-portal']/div/div[1]/h1")
    private WebElement lnkLoginPortal;

    @FindBy(xpath = "//*[@id='button-clicks']/div/div[1]/h1")
    private WebElement lnkButtonClicks;

    @FindBy(xpath = "//*[@id='to-do-list']/div/div[1]/h1")
    private WebElement lnkToDoList;

    @FindBy(xpath = "//*[@id='dropdown-checkboxes-radiobuttons']/div/div[1]/h1")
    private WebElement lnkDropDownRadioCheckBox;

    @FindBy(xpath = "//*[@id='popup-alerts']/div/div[1]/h1")
    private WebElement lnkAlerts;

    @FindBy(xpath = "//*[@id='actions']/div/div[1]/h1")
    private WebElement lnkActions;

    public IElement getLoginPortalLink() { return getComponent(lnkLoginPortal, Element.class, this.getClass() );  }

    public IHyperLink getButtonClicksLink() { return getComponent(lnkButtonClicks, HyperLink.class, this.getClass() );  }

    public IHyperLink getToDoListLink() { return getComponent(lnkToDoList, HyperLink.class, this.getClass() );  }

    public IHyperLink getDropDownRadioCheckLink() { return getComponent(lnkDropDownRadioCheckBox, HyperLink.class, this.getClass() );  }

    public IHyperLink getAlertsLink() { return getComponent(lnkAlerts, HyperLink.class, this.getClass() );  }

    public IHyperLink getActionsLink() { return getComponent(lnkActions, HyperLink.class, this.getClass() );  }


    public void clickLoginPortal() throws FrameworkExceptions{
        try{
            getLoginPortalLink().jsClick();
            Logs.info("Clicked on Login Portal Link");
        }
        catch (Exception fe){
            Logs.error("Failed to Click on the Login Portal Link "+fe);
        }
    }

    public void clickButtonClicksLink(){
        try{
            getButtonClicksLink().clickLink();
            Logs.info("Clicked on Button Clicks Link");
        }
        catch (FrameworkExceptions fe){
            Logs.error("Failed to Click on the Button Clicks Link "+fe);
        }
    }

    public void clickToDoListLink(){
        try{
            getToDoListLink().clickLink();
            Logs.info("Clicked on Button Clicks Link");
        }
        catch (FrameworkExceptions fe){
            Logs.error("Failed to Click on the Button Clicks Link "+fe);
        }
    }

    public void clickDropDownRadioCheckBoxesLink(){
        try{
            getDropDownRadioCheckLink().clickLink();
            Logs.info("Clicked on Drop Down, Radio and Check boxes Link");
        }
        catch (FrameworkExceptions fe){
            Logs.error("Failed to Click on the Drop Down, Radio and Check boxes Link "+fe);
        }
    }

    public void clickAlertsLink(){
        try{
            getAlertsLink().clickLink();
            Logs.info("Clicked on Alerts Link");
        }
        catch (FrameworkExceptions fe){
            Logs.error("Failed to Click Alerts Link "+fe);
        }
    }

    public void clickActionsLink(){
        try{
            getActionsLink().clickLink();
            Logs.info("Clicked on Actions Link");
        }
        catch (FrameworkExceptions fe){
            Logs.error("Failed to Click on the Actions Link "+fe);
        }
    }

}
