package testcase;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.Baseclass;
import pageObjects.SignupPage;

public class SignupTest extends Baseclass{

	//To do Sign-Up functionality
	@Test(priority = 1)
	public void Signup() throws InterruptedException {
		//create an object of SignUpPage class
		NavigateBestBuyURLTest.SelectUS();
		SignupPage signUp=new SignupPage(driver);

		//Click on Account Link
		signUp.AccountClick();
		SwitchWindow();

		//Click on create account link
		signUp.CreateAccountClick();

		//Fill the details

		signUp.EnterFirstName(prop.getProperty("FirstName"));
		signUp.EnterLastName(prop.getProperty("LastName"));
		signUp.EnterEmail(prop.getProperty("EMail"));
		Thread.sleep(2000);
		signUp.EnterPassword(prop.getProperty("Password"));
		signUp.EnterConfirmPassword(prop.getProperty("ConfirmPassword"));
		signUp.EnterMobilePoneNumber(prop.getProperty("MobileNumber"));				
	}

	//Login with valid credentials
	@Test(priority = 2)
	public void Login() {
		//create an object of SignUpPage class
		NavigateBestBuyURLTest.SelectUS();
		SignupPage signUp=new SignupPage(driver);

		//Click on Account Link
		signUp.AccountClick();

		//Click SignIn link
		signUp.SignInClick();

		//Enter the valid credentials
		signUp.LoginAccount(prop.getProperty("EMail"), prop.getProperty("Password"));

		//Validate the Login
		//	String actualValue=signUp.getValidateLogin().getText();
		//	String expectedValue="Hi"+(prop.getProperty("FirstName"));
		//	Assert.assertEquals(actualValue,expectedValue);
	}

	//Login with valid Invalid Email and valid password
	@Test(priority = 3)
	public void LoginInvalidEmail() {
		//create an object of SignUpPage class
		NavigateBestBuyURLTest.SelectUS();
		SignupPage signUp=new SignupPage(driver);

		//Click on Account Link
		signUp.AccountClick();

		//Click SignIn link
		signUp.SignInClick();

		//Enter the valid credentials
		signUp.LoginAccount(prop.getProperty("InvalidEmail"), prop.getProperty("Password"));

		//Validate the Login
		String actualValue=signUp.getalertSignInMsg().getText();
		//String expectedValue1="Oops! The email or password did not match our records. Please try again.";
		String expectedValue2="Sorry, something went wrong. Please try again.";
		Assert.assertEquals(actualValue,expectedValue2);
	}

	//Login with valid Invalid Password and valid Email
	@Test(priority = 4)
	public void LoginInvalidPassword() {
		//create an object of SignUpPage class
		NavigateBestBuyURLTest.SelectUS();
		SignupPage signUp=new SignupPage(driver);

		//Click on Account Link
		signUp.AccountClick();

		//Click SignIn link
		signUp.SignInClick();

		//Enter the valid credentials
		signUp.LoginAccount(prop.getProperty("EMail"), prop.getProperty("InvalidPassword"));

		//Validate the Login
		String actualValue=signUp.getalertSignInMsg().getText();
		//	String expectedValue1="Oops! The email or password did not match our records. Please try again.";
		String expectedValue2="Sorry, something went wrong. Please try again.";
		Assert.assertEquals(actualValue,expectedValue2);
	}


	//Login with valid Invalid Password and invalid Email
	@Test(priority = 5)
	public void LoginInvalidInvalidPassword() {
		//create an object of SignUpPage class
		NavigateBestBuyURLTest.SelectUS();
		SignupPage signUp=new SignupPage(driver);

		//Click on Account Link
		signUp.AccountClick();

		//Click SignIn link
		signUp.SignInClick();

		//Enter the valid credentials
		signUp.LoginAccount(prop.getProperty("InvalidEmail"), prop.getProperty("InvalidPassword"));

		//Validate the Login
		String actualValue=signUp.getalertSignInMsg().getText();
		//	String expectedValue1="Oops! The email or password did not match our records. Please try again.";
		String expectedValue2="Sorry, something went wrong. Please try again.";
		Assert.assertEquals(actualValue,expectedValue2);
	}
	@Test(priority = 6)
	public void LoginwithValidCredentials() {
	
	}
}

