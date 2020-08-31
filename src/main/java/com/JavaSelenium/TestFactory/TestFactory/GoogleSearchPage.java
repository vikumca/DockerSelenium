package com.JavaSelenium.TestFactory.TestFactory;

import com.JavaSelenium.TestFactory.core.exception.FrameworkExceptions;
import com.JavaSelenium.TestFactory.core.pages.Components;
import com.JavaSelenium.TestFactory.core.ui.IButton;
import com.JavaSelenium.TestFactory.core.ui.ITextField;
import com.JavaSelenium.TestFactory.core.ui.implementations.Button;
import com.JavaSelenium.TestFactory.core.ui.implementations.TextField;
import com.JavaSelenium.TestFactory.core.utils.Waits;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleSearchPage extends Components {

    @FindBy(xpath = "//input[@name='q']")
    private WebElement txtSearch;

    @FindBy(xpath = "//input[@value='Google Search']")
    private WebElement btnGoogleSearch;

    public final ITextField getTextSearch() {return getComponent(txtSearch, TextField.class, this.getClass());    }

    public final IButton getButtonGoogleSearch() {return getComponent(btnGoogleSearch, Button.class, this.getClass());    }

    public GoogleSearchPage setSearchedText(String textToBeSearched) throws FrameworkExceptions {

        getTextSearch().setText(textToBeSearched);
        return this;
    }



    public GoogleSearchPage clickSearchButton() throws FrameworkExceptions{
        Waits.explicitWait();
        getButtonGoogleSearch().click();
        return this;
    }
}
