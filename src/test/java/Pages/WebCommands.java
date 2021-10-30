package Pages;

import DriverWrapper.Web;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class WebCommands {
    public WebElement getWebElement(By locator) {
        return Web.getDriver().findElement(locator);
    }

    public void clickThis(By locator) {
        getWebElement(locator).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void type(String data, By locator) {
        getWebElement(locator).sendKeys(data);
    }

    public boolean isWebElementEnabled(By locator) {
        return getWebElement(locator).isEnabled();
    }

    public boolean isWebElementSelected(By locator) {
        return getWebElement(locator).isSelected();
    }

    public boolean isWebElementDisplayed(By locator) {
        return getWebElement(locator).isDisplayed();
    }

    public void scrollToPageBottom() {
        JavascriptExecutor jse = (JavascriptExecutor) Web.getDriver();
        jse.executeScript("scroll(0, 450)");
    }

    public void scrollToViewWebElement(By locator) {
        JavascriptExecutor jse = (JavascriptExecutor) Web.getDriver();
        jse.executeScript("arguments[0].scrollIntoView()", getWebElement(locator));
    }

    public void scrollTillEndPage() {
        JavascriptExecutor jse = (JavascriptExecutor) Web.getDriver();
        jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public String getWebElementText(By locator) {
        return getWebElement(locator).getText();
    }

}
