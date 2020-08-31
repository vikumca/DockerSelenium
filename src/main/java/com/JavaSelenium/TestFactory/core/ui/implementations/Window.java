package com.JavaSelenium.TestFactory.core.ui.implementations;

import com.JavaSelenium.TestFactory.core.exception.FrameworkExceptions;
import com.JavaSelenium.TestFactory.core.helper.Constants;
import com.JavaSelenium.TestFactory.core.logger.Logs;
import com.JavaSelenium.TestFactory.core.ui.IWindow;
import com.JavaSelenium.TestFactory.core.utils.Waits;

public class Window extends Element implements IWindow {

    // Switch to a window after the window is in focus
    @Override
    public void switchToWindowAfterNewWindowFocused() throws FrameworkExceptions {
        try {
            String winHandleBefore = getWindowHandle();
            for (String winHandle : driver.getWindowHandles()) {
                if (!winHandle.equals(winHandleBefore))
                    switchToWindow(winHandle);
            }
        } catch (Exception fe) {
            Logs.error(Constants.FORMATTER + Constants.FAILURE_METHOD_MESSAGE + " sendKey() of TextField class");
            throw new FrameworkExceptions(Constants.FORMATTER + Constants.FAILURE_METHOD_MESSAGE + " sendKey() of TextField class." + fe);
        }
    }

    // Switch to a window
    @Override
    public void switchToWindow(String windowName) throws FrameworkExceptions {
        try {
            driver.switchTo().window(windowName);
        } catch (Exception fe) {
            Logs.error(Constants.FORMATTER + Constants.FAILURE_METHOD_MESSAGE + " switchToWindow() of TextField class");
            throw new FrameworkExceptions(Constants.FORMATTER + Constants.FAILURE_METHOD_MESSAGE + " switchToWindow() of TextField class." + fe);
        }
    }

    // Switch to a default window
    @Override
    public void switchToDefault() throws FrameworkExceptions {
        try {
            driver.switchTo().defaultContent();
        }catch (Exception fe) {
            Logs.error(Constants.FORMATTER + Constants.FAILURE_METHOD_MESSAGE + " switchToDefault() of TextField class");
            throw new FrameworkExceptions(Constants.FORMATTER + Constants.FAILURE_METHOD_MESSAGE + " switchToDefault() of TextField class." + fe);
        }
    }

    // Get Window Handle
    @Override
    public String getWindowHandle() throws FrameworkExceptions {
        try {
            return driver.getWindowHandle();
        } catch (Exception fe) {
            Logs.error(Constants.FORMATTER + Constants.FAILURE_METHOD_MESSAGE + " getWindowHandle() of TextField class");
            throw new FrameworkExceptions(Constants.FORMATTER + Constants.FAILURE_METHOD_MESSAGE + " getWindowHandle() of TextField class." + fe);
        }
    }

    //Get Window URL
    @Override
    public String getWindowURL() throws FrameworkExceptions{
        try {
            return driver.getCurrentUrl();
        } catch (Exception fe) {
            Logs.error(Constants.FORMATTER + Constants.FAILURE_METHOD_MESSAGE + " getWindowURL() of TextField class");
            throw new FrameworkExceptions(Constants.FORMATTER + Constants.FAILURE_METHOD_MESSAGE + " getWindowURL() of TextField class." + fe);
        }
    }

    // Switch to available window
    @Override
    public void switchToAvailableWindow(long waitTimeBeforeSwitch) throws FrameworkExceptions {
        try {
            Waits.explicitWait(waitTimeBeforeSwitch);
            for (String winHandle : driver.getWindowHandles()) {
                switchToWindow(winHandle);
                break;
            }
        } catch (Exception fe) {
            Logs.error(Constants.FORMATTER + Constants.FAILURE_METHOD_MESSAGE + " switchToAvailableWindow() of TextField class");
            throw new FrameworkExceptions(Constants.FORMATTER + Constants.FAILURE_METHOD_MESSAGE + " switchToAvailableWindow() of TextField class." + fe);
        }
    }
}
