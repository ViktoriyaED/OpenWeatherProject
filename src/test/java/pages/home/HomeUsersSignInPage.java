package pages.home;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;
import pages.base_abstract.FooterMenuPage;

public class HomeUsersSignInPage extends FooterMenuPage {

    @FindBy(id = "user_email")
    private WebElement userEmail;

    @FindBy(id = "user_password")
    private WebElement userPassword;

    @FindBy(name = "commit")
    private WebElement submitButton;

    @FindBy(xpath = "//a[@href='/users/sign_up']")
    private WebElement createAccountLink;

    @FindBy(xpath = "//a[@href='#']")
    private WebElement clickHereToRecoverLink;

    @FindBy(xpath = "//h3")
    private WebElement h3Header;

    @FindBy(xpath = "//div[@class = 'panel-body']")
    WebElement notification;

    public HomeUsersSignInPage(WebDriver driver) {
        super(driver);
    }

    public String getNotification() {

        return getText(notification);
    }

    public String getWelcomeMessage() {

        return getText(h3Header);
    }

    public HomeUsersSignInPage clickClearInputRegularUserEmail() {
        click(userEmail);
        userEmail.clear();
        String email = "jka59433@xcoxc.com";
        input(email, userEmail);

        return this;
    }

    public HomeUsersSignInPage clickClearInputRegularUserPassword() {
        click(userPassword);
        userPassword.clear();
        String password = "Tester12#";
        input(password, userPassword);

        return this;
    }

    public void clickSubmitButton() {
        click(submitButton);
    }

    public HomePage signInAsRegularUser() {
        clickClearInputRegularUserEmail();
        clickClearInputRegularUserPassword();
        clickSubmitButton();
        Reporter.log("DO NOT FORGET SIGN OUT", true);

        return new HomePage(getDriver());
    }

    public HomeUsersSignUpPage clickCreateAnAccountLink() {
        click(createAccountLink);

        return new HomeUsersSignUpPage(getDriver());
    }
}
