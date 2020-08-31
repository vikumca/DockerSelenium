package com.JavaSelenium.TestFactory.core.ui;

import com.JavaSelenium.TestFactory.core.exception.FrameworkExceptions;

public interface IAlert extends IElement{
    void clickAlert() throws FrameworkExceptions;
    String getAlertText() throws FrameworkExceptions;
    void acceptAlert() throws FrameworkExceptions;
    boolean isAlertPresent() throws FrameworkExceptions;
    void waitForAlert() throws FrameworkExceptions;
}
