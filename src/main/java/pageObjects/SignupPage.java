//Contains web elements and methods for SignUp and Login Pages
package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utilities.UtilityPgm;

public class SignupPage extends UtilityPgm {

	//Data members
	public WebDriver driver;

	//Constructor
	public SignupPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
		InilializeActions();
		InilializeWebDriverWait();
	}

	//Web Elements

	@FindBy(xpath = "//div[@class='shop-account-menu']/descendant::button[.='Account']")
	WebElement account;

	@FindBy(xpath = "//a[.='Create Account']")
	WebElement createAccount;

	@FindBy(xpath = "//input[@id='firstName']")
	WebElement firstName;

	@FindBy(xpath = "//input[@id='lastName']")
	WebElement lastName;

	@FindBy(xpath = "//input[@id='email']")
	WebElement eMail;

	@FindBy(xpath = "//input[@id='fld-p1']")
	WebElement password;

	@FindBy(xpath = "//input[@id='reenterPassword']")
	WebElement confirmPassword;

	@FindBy(xpath = "//input[@id='phone']")
	WebElement mobilePoneNumber;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement submitButton;

	@FindBy(xpath = "	//a[.='Sign In']")
	WebElement signInButton;

	@FindBy(xpath = "//input[@type='email']")
	WebElement signIneMailAddress;

	@FindBy(xpath = "//input[@type='password']")
	WebElement signInpassword;

	@FindBy(xpath = "//button[.='Sign In']")
	WebElement signIn;

	@FindBy(xpath = "//button[@id='account-menu-account-button']/span")
	WebElement validateLogin;

	@FindBy(xpath = "//div[@role='alert']/div")
	WebElement alertSignInMsg;

	//Getters 

	public WebElement getValidateLogin() {
		return validateLogin;
	}

	public WebElement getalertSignInMsg() {
		return alertSignInMsg;
	}

	//Methods

	//SignIn to the account 
	public void LoginAccount(String Email, String Password) {
		signIneMailAddress.sendKeys(Email);
		signInpassword.sendKeys(Password);
		signIn.click();
	}

	//Get the text value of the element 
	public void GetTextValue(WebElement webElement) {
		webElement.getText();
	}

	//Click on account link
	public void AccountClick() {
		//	InilializeJavaScriptExecutor();
		wait.until(ExpectedConditions.elementToBeClickable(account));
		account.click();
		wait.until(ExpectedConditions.visibilityOf(createAccount));
	}

	//Click on createAccount Link
	public void CreateAccountClick() {
		createAccount.click();
		wait.until(ExpectedConditions.visibilityOf(firstName));
	}

	//Click on SignIn Link
	public void SignInClick() {
		signInButton.click();
		wait.until(ExpectedConditions.visibilityOf(signIneMailAddress));
	}

	//Enter the firstname
	public void EnterFirstName(String FirstName) {
		firstName.sendKeys(FirstName);
	}

	//Enter the LastName
	public void EnterLastName(String LastName) {
		wait.until(ExpectedConditions.elementToBeClickable(lastName));
		lastName.sendKeys(LastName);
	}

	//Enter the Email
	public void EnterEmail(String Email) {
		wait.until(ExpectedConditions.elementToBeClickable(eMail));
		eMail.sendKeys(Email);
	}

	//Enter the Password
	public void EnterPassword(String Password) {
		wait.until(ExpectedConditions.elementToBeClickable(password));
		password.sendKeys(Password);
	}

	//Enter the ConfirmPassword
	public void EnterConfirmPassword(String ConfirmPassword) {
		wait.until(ExpectedConditions.elementToBeClickable(confirmPassword));
		confirmPassword.sendKeys(ConfirmPassword);
	}

	//Enter the MobilePoneNumber
	public void EnterMobilePoneNumber(String MobilePoneNumber) {
		wait.until(ExpectedConditions.elementToBeClickable(mobilePoneNumber));
		mobilePoneNumber.sendKeys(MobilePoneNumber);
	}
}
