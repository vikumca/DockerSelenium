package com.JavaSelenium.TestFactory.core.ui.implementations;

import com.JavaSelenium.TestFactory.core.exception.FrameworkExceptions;
import com.JavaSelenium.TestFactory.core.helper.Constants;
import com.JavaSelenium.TestFactory.core.logger.Logs;
import com.JavaSelenium.TestFactory.core.ui.ILabel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Label extends Element implements ILabel {
    public Label() {
        super();
    }

    public Label(WebElement element, String elementName) {
        super(element, elementName);
    }

    // Get the Label from an element
    @Override
    public String getLabel() throws FrameworkExceptions {
        try {
            if (isLoaded()) {
                String text = element.getText();
                Logs.info("Label Element: " + elementOriginalName + " returned label");
                return text;
            } else {
                Logs.error(Constants.FORMATTER + " Label Element: " + elementOriginalName + " label not found");
                throw new FrameworkExceptions("Label Element " + elementOriginalName + " not loaded");
            }
        }
        catch (Exception e) {
            Logs.error(Constants.FORMATTER + " Label Element: " + elementOriginalName + " label not found");
            throw new FrameworkExceptions("Label Element: " + elementOriginalName + " not loaded"+e);
        }
    }

    // Get Mandatory attribute of an element
    @Override
    public boolean hasMandatoryMarker() throws FrameworkExceptions {
        try{
            return (element.findElement(By.cssSelector("[mandatory]")).getAttribute("mandatory")).contains("true");
        }
        catch (Exception e)
        {
            Logs.error("Failed in hasMandatoryMarker method"+e);
            return false;
        }
    }
}
