package com.JavaSelenium.TestFactory.core.ui;

import com.JavaSelenium.TestFactory.core.exception.FrameworkExceptions;

public interface ILabel extends IElement {
    String getLabel() throws FrameworkExceptions;
    boolean hasMandatoryMarker() throws FrameworkExceptions;
}
