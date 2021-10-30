package Pages;

import DriverWrapper.Web;
import Utils.DateMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class HomePage extends WebCommands {

    int totalGuestValue = 0;
    int totalRoomValue = 0;

    // Locator for elements on Home page
    By guestBoxLocator = By.xpath("//span[text()='Guests']");
    By adultsPlusIconLocator = By.xpath("(//button[@aria-label='plus'])[1]");
    By childrenPlusIconLocator = By.xpath("(//button[@aria-label='plus'])[2]");
    By roomCountLocator = By.xpath("//h2[starts-with(text(), 'Room')]");
    By adultsCountValueLocator = By.xpath("//select[@name='q-room-0-adults']/following-sibling::span");
    By childrenCountValueLocator = By.xpath("//select[@name='q-room-0-children']/following-sibling::span");
    By totalGuestCountValueLocator = By.xpath("//*[@class='_1sygyM']");
    By applyButtonLocator = By.xpath("//button[@aria-label='Apply']");
    By searchButtonLocator = By.xpath("//button[text()='Search']");
    By destinationInputLocator = By.name("q-destination");
    By searchGuestDisplayLocator = By.xpath("//span[text()='Guests']/following-sibling::span");
    By signInBoxLocator = By.xpath("//span[text()='Sign in']");
    By emailInputLocator = By.xpath("//input[@name='email']");
    By passwordInputLocator = By.xpath("//input[@name='password']");
    By signInButtonLocator = By.xpath("//*[@id='sign-in-button']");
    By invalidCredentialsErrorMessageLocator = By.xpath("(//div[@class='sica-form-cont']/descendant::div)[1]");
    By childAgeUpdateLocator = By.xpath("//select[@data-item-index='0']");
    By child2AgeUpdateLocator = By.xpath("//select[@data-item-index='1']");
    By signUpLocator = By.xpath("//*[@class='create-acct-switch']");
    By tcLinkLocator = By.xpath("//*[@id='sign-up-tc']");
    By privacyLinkLocator = By.xpath("//*[@id='sign-up-privacy']");
    By checkInLocator = By.xpath("//span[@class='_2qpRyR' and contains(text(), 'Check in')]");
    By checkOutLocator = By.xpath("//span[text()='Check out']");
    By monthAllDatesLocator = By.xpath("//h2[text()='October 2021']/following-sibling::table//button[@disabled]");
    By nextButtonLocator = By.xpath("//button[@aria-label='Next']");
    By allDecemberDatesLocator = By.xpath("//h2[text()='December 2021']/following-sibling::table//button[not(@disabled)]");
    By backCalendarButtonLocator = By.xpath("//button[@aria-label='Previous' and @disabled]");
    By destinationSuggestionLocator = By.xpath("//div[contains(@class, 'typeahead')]//span[not(@class)]");
    By changeDatesButtonLocator = By.xpath("//button[@aria-label='Change dates']");


    //Methods to interact with Elements on Home page
    public void clickGuestField() {
        clickThis(guestBoxLocator);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void clickPlusIcon(By locator) {
        clickThis(locator);
    }

    public void adultPlusToClick(int count) {
        for(int i=0; i<count;++i) {
            clickPlusIcon(adultsPlusIconLocator);
            Web.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }
    }

    public void childPlusToClick(int count) {
        for(int i=0; i<count;++i) {
            clickPlusIcon(childrenPlusIconLocator);
            Web.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }
    }

    public int guestRoomCount() {
        String roomCount = getWebElementText(roomCountLocator);
        String[] roomNumberArray = roomCount.split(" ");
        return Integer.parseInt(roomNumberArray[1].trim());
    }

    public int adultsGuestCount() {
        return Integer.parseInt(getWebElementText(adultsCountValueLocator));
    }

    public int childrenGuestCount() {
        return Integer.parseInt(getWebElementText(childrenCountValueLocator));
    }

    public int totalRoomCount() {
        String totalGuestCount = getWebElementText(totalGuestCountValueLocator);
        String[] totalCountArray = totalGuestCount.split("\n");
        return Integer.parseInt(totalCountArray[0].substring(0,2).trim());
    }

    public int totalAdultsCount() {
        String totalGuestCount = getWebElementText(totalGuestCountValueLocator);
        String[] totalCountArray = totalGuestCount.split("\n");
        String[] guestCountArray = totalCountArray[1].split(",");
        return Integer.parseInt(guestCountArray[0].substring(0,2).trim());
    }

    public int totalChildrenCount() {
        String totalGuestCount = getWebElementText(totalGuestCountValueLocator);
        String[] totalCountArray = totalGuestCount.split("\n");
        String[] guestCountArray = totalCountArray[1].split(",");
        return Integer.parseInt(guestCountArray[1].substring(1,3).trim());
    }

    public int totalGuestCount() {
        return totalAdultsCount() + totalChildrenCount();
    }

    public int searchRoomCountValue() {
        String searchDisplayCount = getWebElementText(searchGuestDisplayLocator);
        String[] searchCountDisplayArray = searchDisplayCount.split(",");
        return Integer.parseInt(searchCountDisplayArray[0].substring(0,2).trim());
    }

    public int searchGuestCountValue() {
        String searchDisplayCount = getWebElementText(searchGuestDisplayLocator);
        String[] searchCountDisplayArray = searchDisplayCount.split(",");
        return Integer.parseInt(searchCountDisplayArray[1].substring(1,3).trim());
    }

    public void clickApplyButton() {
        clickThis(applyButtonLocator);
    }

    public void clickSearchButton() {
        clickThis(searchButtonLocator);
    }

    public void typeDestination(String data) {
        type(data, destinationInputLocator);
    }

    public void clickSignIn() {
        clickThis(signInBoxLocator);
    }

    public void typeEmailAddress(String email) {
        type(email, emailInputLocator);
    }

    public void typePassword(String password) {
        type(password, passwordInputLocator);
    }

    public void clickSignInButton() {
        clickThis(signInButtonLocator);
    }

    public String InvalidCredentialsErrorMessage() {
        return Web.getDriver().findElement(invalidCredentialsErrorMessageLocator).getText();
    }

    public boolean isInvalidCredentialsErrorMessageDisplayed() {
        return isWebElementDisplayed(invalidCredentialsErrorMessageLocator);
    }

    public void updateFirstChildAge(String age) {
        WebElement childAge = Web.getDriver().findElement(childAgeUpdateLocator);
        childAge.click();
        Select childAgeSelect = new Select(childAge);
        childAgeSelect.selectByVisibleText(age);
    }

    public void updateSecondChildAge(String age) {
        WebElement childAge = Web.getDriver().findElement(child2AgeUpdateLocator);
        childAge.click();
        Select childAgeSelect = new Select(childAge);
        childAgeSelect.selectByVisibleText(age);
    }

    public void clickSignUp() {
        clickThis(signUpLocator);
    }

    public String getCurrentWindowHandle() {
        return Web.getDriver().getWindowHandle();
    }

    public void clickTCLink() {
        clickThis(tcLinkLocator);
    }

    public boolean isDifferentWindowHandles() {
        String newWindowHandle = getCurrentWindowHandle();
        Set<String> allWindowHandles = Web.getDriver().getWindowHandles();
        for(String handle: allWindowHandles) {
            if(!handle.equals(newWindowHandle)) {
                Web.getDriver().switchTo().window(handle);
                break;
            }
        }
        String currentWindowHandle = getCurrentWindowHandle();
        boolean isDifferentWindowHandle = false;

        if(!newWindowHandle.equals(currentWindowHandle)) {
            isDifferentWindowHandle = true;
        }
        return isDifferentWindowHandle;
    }

    public void closeCurrentWindow() {
        String thisWindow = getCurrentWindowHandle();
        Set<String> allWindowHandles = Web.getDriver().getWindowHandles();
        for(String handle: allWindowHandles) {
            if (handle.equals(thisWindow)) {
                Web.getDriver().close();
            }
        }

        Set<String> WindowHandles = Web.getDriver().getWindowHandles();

        for(String handle: WindowHandles) {
            Web.getDriver().switchTo().window(handle);
        }
    }

    public void clickPrivacyStatementLink() {
        clickThis(privacyLinkLocator);
    }

    public void clickCheckInField() {
        clickThis(checkInLocator);
    }

    public void clickCheckOutField() {
        clickThis(checkOutLocator);
    }

    public boolean isPastDatesDisabled() {
        int today = Integer.parseInt(DateMethods.getCurrentDate_d());
        List<WebElement> dates = Web.getDriver().findElements(monthAllDatesLocator);

        boolean isAllPastDatesDisabled = false;
        for(WebElement date:dates) {
            if(date.getText().contains("Disabled")) {
                if(Integer.parseInt(date.getText().substring(0,2).trim()) < today) {
                    isAllPastDatesDisabled = true;
                }
            }
        }
        return isAllPastDatesDisabled;
    }

    public boolean isBackButtonDisabled() {
        boolean isBackButtonDisabled = false;
        if(Web.getDriver().findElement(backCalendarButtonLocator).getAttribute("disabled") != null) {
            isBackButtonDisabled = true;
        }
        return isBackButtonDisabled;
    }

    public void clickNext() {
        clickThis(nextButtonLocator);
    }

    public void selectDesiredDestination(String desiredDestination) {
        List<WebElement> suggestions = Web.getDriver().findElements(destinationSuggestionLocator);

        for (WebElement suggestion : suggestions) {
            if (suggestion.getText().equalsIgnoreCase(desiredDestination)) {
                WebDriverWait wait = new WebDriverWait(Web.getDriver(),10);
                wait.until(ExpectedConditions.elementToBeClickable(suggestion));
                break;
            }
        }
    }

    public void selectDesiredDate(String date) {
        List<WebElement> checkInDates = Web.getDriver().findElements(allDecemberDatesLocator);
        for (WebElement checkInDate : checkInDates) {
            if (checkInDate.getText().equalsIgnoreCase(date)) {
                checkInDate.click();
                break;
            }
        }
    }

    public boolean isChangeDatesDisplayed() {
        for(int i=0; i<20;i++) {
            JavascriptExecutor js = (JavascriptExecutor) Web.getDriver();
            js.executeScript("window.scrollBy(0,450)", "");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return isWebElementDisplayed(changeDatesButtonLocator);
    }

    public boolean isChangeDatesEnabled() {
        return isWebElementEnabled(changeDatesButtonLocator);
    }
}