package com.JavaSelenium.TestFactory.core.ui;

import com.JavaSelenium.TestFactory.core.exception.FrameworkExceptions;

public interface IWindow extends IElement {
    void switchToWindowAfterNewWindowFocused() throws FrameworkExceptions;
    void switchToWindow(String windowName) throws  FrameworkExceptions;
    String getWindowHandle() throws FrameworkExceptions;
    void switchToDefault() throws FrameworkExceptions;
    String getWindowURL() throws FrameworkExceptions;
    void switchToAvailableWindow(long waitTimeBeforeSwitch) throws FrameworkExceptions;
}
