package com.JavaSelenium.TestFactory.TestFactory;

import com.JavaSelenium.TestFactory.core.exception.FrameworkExceptions;
import com.JavaSelenium.TestFactory.core.logger.Logs;
import com.JavaSelenium.TestFactory.core.pages.Components;
import com.JavaSelenium.TestFactory.core.ui.IDropDown;
import com.JavaSelenium.TestFactory.core.ui.IElement;
import com.JavaSelenium.TestFactory.core.ui.ITextField;
import com.JavaSelenium.TestFactory.core.ui.IWindow;
import com.JavaSelenium.TestFactory.core.ui.implementations.DropDown;
import com.JavaSelenium.TestFactory.core.ui.implementations.Element;
import com.JavaSelenium.TestFactory.core.ui.implementations.TextField;
import com.JavaSelenium.TestFactory.core.ui.implementations.Window;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;

public class DropdownCheckboxesRadioButtonsPage extends Components{

    @FindBy(id = "dropdowm-menu-1")
    private WebElement ddFirst;

    @FindBy(id = "dropdowm-menu-2")
    private WebElement ddSecond;

    @FindBy(id = "dropdowm-menu-3")
    private WebElement ddThird;

    @FindBys(@FindBy(xpath = "//input[@type='checkbox']"))
    private List<WebElement> lstCheckboxes;

    @FindBy(xpath = "//input[@type='radio' and @value='green']")
    private WebElement rdbGreen;

    public IDropDown getFirstDD() { return getComponent(ddFirst, DropDown.class, this.getClass() );  }

    public IDropDown getSecondDD() { return getComponent(ddSecond, DropDown.class, this.getClass() );  }

    public IDropDown getThirdDD() { return getComponent(ddThird, DropDown.class, this.getClass() );  }

    public IElement getRadioGreen() { return getComponent(ddThird, Element.class, this.getClass() );  }

    public final IWindow getWindow() { return getComponent(Window.class);   }

    public void selectFirstDropDown(String dropDownValue){
        try{
            getFirstDD().selectByVisibleText(dropDownValue);
            Logs.info("Selected the value for first drop down");
        }
        catch (FrameworkExceptions fe){
            Logs.error("Failed to select the value for first drop down "+fe);
        }
    }

    public void selectSecondDropDown(String dropDownValue){
        try{
            getSecondDD().selectByVisibleText(dropDownValue);
            Logs.info("Selected the value for Second drop down");
        }
        catch (FrameworkExceptions fe){
            Logs.error("Failed to select the value for second drop down "+fe);
        }
    }

    public void selectThirdDropDown(String dropDownValue){
        try{
            getThirdDD().selectByVisibleText(dropDownValue);
            Logs.info("Selected the value for third drop down");
        }
        catch (FrameworkExceptions fe){
            Logs.error("Failed to select the value for third drop down "+fe);
        }
    }

    public void selectCheckBoxes() throws FrameworkExceptions{
        try{
            if (lstCheckboxes.size() > 0) {
                for (WebElement chkb : lstCheckboxes) {
                    if(! (chkb.isSelected())) {
                        chkb.click();
                    }
                }
            }
            else {
                Logs.error("No check boxes are there on the Page");
            }
        }
        catch (Exception fe) {
            Logs.error("Failed to select the check boxes");
        }
    }

    public void selectGreenRadioButton(){
        try{
            getRadioGreen().clickElement();
            Logs.info("Selected the value for Green Radio Button");
        }
        catch (FrameworkExceptions fe){
            Logs.error("Failed to select the value for Green Radio Button "+fe);
        }
    }

}
