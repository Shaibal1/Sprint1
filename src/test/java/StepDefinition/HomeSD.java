package StepDefinition;

import DriverWrapper.Web;
import Pages.HomePage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

public class HomeSD extends Web {

    HomePage home = new HomePage();

    @Given("I am on Homepage")
    public void launchWebpage() {
        openWebpage();
    }

    @When("I click on Sign in link")
    public void clickSignIn() {
        home.clickSignIn();
    }

    @When("I enter 'test@abc.com' email")
    public void typeEmailAddress() {
        home.typeEmailAddress("test@abc.com");
    }

    @When("I enter '1234' password")
    public void typePassword() {
        home.typePassword("1234");
    }

    @When("I click on \"Sign in\" button")
    public void clickSignInButton() {
        home.clickSignInButton();
    }

    @Then("I verify error message is displayed")
    public void isInvalidCredentialsErrorMessageDisplayed() {
        Assert.assertTrue(home.isInvalidCredentialsErrorMessageDisplayed(),"The error message is not as expected");
    }

    @Then("I quit the webpage")
    public void closeWebpage() {
        quitWebpage();
    }

    @When("I click on Guests field")
    public void clickGuestField() {
        home.clickGuestField();
    }

    @When("I add 2 adults")
    public void adultPlusToClick() {
        home.adultPlusToClick(2);
    }

    @When("I add 2 children")
    public void childPlusToClick() {
        home.childPlusToClick(2);
    }

    @When("I select the first child age as 4")
    public void updateFirstChildAge() {
        home.updateFirstChildAge("4");
    }

    @When("I select the second child age as <1")
    public void updateSecondChildAge() {
        home.updateSecondChildAge("<1");
    }

    @Then("I verify on rooms pop-up the number of adults and children match the number I selected")
    public void verifySumNumMatch() {
        Assert.assertEquals(home.totalAdultsCount(),home.adultsGuestCount(),"The total adults count does not match the count entered in guest section");
        Assert.assertEquals(home.totalChildrenCount(),home.childrenGuestCount(),"The total children count does not match the count entered in guest section");
    }

    @When("I click on Apply button")
    public void clickApplyButton() {
        home.clickApplyButton();
    }

    @Then("I verify the total number of guests in sum of adults and children match the number I selected")
    public void totalSumNumMatch() {
        home.clickGuestField();
        Assert.assertEquals(home.searchGuestCountValue(),home.totalGuestCount(),"The search guest count does not match the total guest count");
    }

    @When("I click on Sign up link")
    public void clickSignUp() {
        home.clickSignUp();
    }

    @When("I click on Terms and Conditions link")
    public void clickTCLink() {
        home.clickTCLink();
    }

    @Then("I verify Terms and Conditions page opens in new tab")
    public void verifyTCOpensOnNewTab() {
        Assert.assertTrue(home.isDifferentWindowHandles(), "“Terms and Conditions” page does not open in new tab");
    }

    @When("I close Terms and Conditions page and switch to Home page")
    public void closeCurrentWindow() {
        home.closeCurrentWindow();
    }

    @When("I click on Privacy Statement link")
    public void clickPrivacyStatementLink() {
        home.clickPrivacyStatementLink();
    }

    @Then("I verify Privacy Statement page opens in new tab")
    public void verifyPrivacyLinkOpensOnNewTab() {
        Assert.assertTrue(home.isDifferentWindowHandles(), "“Privacy Statement” page does not open in new tab");
    }

    @When("I click on Check In Calendar")
    public void clickCheckInField() {
        home.clickCheckInField();
    }

    @Then("I verify past dates are disabled")
    public void verifyPastDatesDisabled() {
        Assert.assertTrue(home.isPastDatesDisabled(),"The past dates are not disabled");
    }

    @Then("Back button on current month is disabled")
    public void verifyBackButtonDisabled() {
        Assert.assertTrue(home.isBackButtonDisabled(),"The Back Button on current month is not disabled");
    }

    @When("I enter \"bora\" in destination")
    public void typeDestination() {
        home.typeDestination("bora");
    }

    @When("I select “Bora Bora, Leeward Islands, French Polynesia” from auto suggestion")
    public void selectDesiredDestination() {
        home.selectDesiredDestination("Bora Bora, Leeward Islands, French Polynesia");
    }

    @When("I click Next button to select December month")
    public void clickNext() {
        home.clickNext();
    }

    @When("I select December 1,2021 as Check-In")
    public void selectCheckInDate() {
        home.selectDesiredDate("1");
    }

    @When("I click on Check Out Calendar")
    public void clickCheckOutField() {
        home.clickCheckOutField();
    }

    @When("I select December 16,2021 as Check-Out")
    public void selectCheckOutDate() {
        home.selectDesiredDate("16");
    }

    @When("I click on Search button")
    public void clickSearchButton() {
        home.clickSearchButton();
    }

    @Then("I verify at the end of search results, Change Dates button is displayed")
    public void verifyChangeDatesButtonDisplayed() {
        Assert.assertTrue(home.isChangeDatesDisplayed(), "The change dates button is not displayed");
    }

    @Then("I verify Change Dates button is enabled")
    public void verifyChangeDatesButtonEnabled() {
        Assert.assertTrue(home.isChangeDatesEnabled(), "The change dates button is not enabled");
    }
}
