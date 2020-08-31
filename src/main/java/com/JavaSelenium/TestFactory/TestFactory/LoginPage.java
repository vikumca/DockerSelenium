package com.JavaSelenium.TestFactory.TestFactory;

import com.JavaSelenium.TestFactory.core.exception.FrameworkExceptions;
import com.JavaSelenium.TestFactory.core.logger.Logs;
import com.JavaSelenium.TestFactory.core.pages.Components;
import com.JavaSelenium.TestFactory.core.ui.IButton;
import com.JavaSelenium.TestFactory.core.ui.IHyperLink;
import com.JavaSelenium.TestFactory.core.ui.ITextField;
import com.JavaSelenium.TestFactory.core.ui.IWindow;
import com.JavaSelenium.TestFactory.core.ui.implementations.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends Components {

    @FindBy(id = "text")
    private WebElement btnUserName;

    @FindBy(id = "password")
    private WebElement btnPassword;

    @FindBy(id = "login-button")
    private WebElement btnLogin;

    //public ITextField getUserNameButton() { return getComponent(btnUserName, TextField.class, this.getClass() );  }

    public ITextField getUserNameButton() { return getComponent(btnUserName,TextField.class,this.getClass());}


    public ITextField getPasswordButton() { return getComponent(btnPassword, TextField.class, this.getClass() );  }

    public IButton getLoginButton() { return getComponent(btnLogin, Button.class, this.getClass() );  }

    public final IWindow getWindow() { return getComponent(Window.class);   }

    public void enterUserName(String userName){
        try{
            getUserNameButton().setText(userName);
            Logs.info("Entered the user name");
        }
        catch (FrameworkExceptions fe){
            Logs.error("Failed to set the user name text "+fe);
        }
    }

    public void enterPassord(String password){
        try{
            getPasswordButton().setText(password);
            Logs.info("Entered the password");
        }
        catch (FrameworkExceptions fe){
            Logs.error("Failed to set the password text "+fe);
        }
    }

    public void clickLogin(){
        try{
            getLoginButton().click();
            Logs.info("Clicked on the login button ");
        }
        catch (FrameworkExceptions fe){
            Logs.error("Failed to click on the login "+fe);
        }
    }
}
