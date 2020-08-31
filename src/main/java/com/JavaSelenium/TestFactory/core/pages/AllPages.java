package com.JavaSelenium.TestFactory.core.pages;

import com.JavaSelenium.TestFactory.core.driver.DriverSetup;
import org.openqa.selenium.support.PageFactory;

public class AllPages {

    private AllPages(){}

    public static <T> T getPage(Class<T> clazz) {
        return PageFactory.initElements(DriverSetup.getDriver(), clazz);
    }
}
