package com.JavaSelenium.TestFactory.core.ui;

import com.JavaSelenium.TestFactory.core.exception.FrameworkExceptions;

public interface ICheckBox extends IElement {
    void check() throws FrameworkExceptions;
    boolean isChecked() throws FrameworkExceptions;
}
