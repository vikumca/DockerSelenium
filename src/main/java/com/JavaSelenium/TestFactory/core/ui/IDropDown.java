package com.JavaSelenium.TestFactory.core.ui;

import com.JavaSelenium.TestFactory.core.exception.FrameworkExceptions;

public interface IDropDown extends IElement {
    void selectByValue(String text) throws FrameworkExceptions;
    void selectByVisibleText(String text) throws FrameworkExceptions;
    void selectByIndex(int index) throws FrameworkExceptions;
    void selectByIgnoringSpecialCharacters(String text) throws FrameworkExceptions;
}
