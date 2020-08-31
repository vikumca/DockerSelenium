package com.JavaSelenium.TestFactory.core.ui;

import com.JavaSelenium.TestFactory.core.exception.FrameworkExceptions;
import com.JavaSelenium.TestFactory.core.ui.IElement;

public interface IHyperLink extends IElement {
    String getHref() throws FrameworkExceptions;
    void clickLink() throws FrameworkExceptions;
}
