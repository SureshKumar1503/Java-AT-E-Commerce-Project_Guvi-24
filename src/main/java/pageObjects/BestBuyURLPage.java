package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.UtilityPgm;

public class BestBuyURLPage extends UtilityPgm {

	//Data members
	public WebDriver driver;

	//Constructor
	public BestBuyURLPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}

	//Web elements
	
	@FindBy(xpath = "//a[@class='us-link']")
	WebElement USSelectionLink;


	@FindBy(xpath = "//a[@class='canada-link']")
	WebElement CanadaSelectionLink;

	//Methods
	//Select a country - US
	public void SelectUS() {
		USSelectionLink.click();
	}

	//Select a country - Canada
	public void SelectCanada() {
		CanadaSelectionLink.click();
	}
}
