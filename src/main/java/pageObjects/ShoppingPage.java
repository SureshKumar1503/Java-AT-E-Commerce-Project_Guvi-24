//Class contains webelements and methods for the shopping webpage
package pageObjects;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import utilities.UtilityPgm;

public class ShoppingPage extends UtilityPgm {

	//Constructor
	public ShoppingPage(WebDriver driver) throws IOException {
		this.driver = driver;
		PageFactory.initElements(driver,this);
		InilializeActions();
		InilializeJavaScriptExecutor();
		InilializeWebDriverWait();
	}

	//Data Members
	public WebDriver driver;	

	@FindBy(xpath = "//input[@class='search-input']")
	WebElement searchElement;

	@FindBy(xpath = "//button[@title='submit search']/span")
	WebElement searchButton;

	@FindBy(xpath = "//button[@aria-label='Menu']")
	WebElement menuButton;

	@FindBys({	
		@FindBy(xpath = "//div[@data-t='header-navigation-container']/ul/li")
	}) List<WebElement> shopByDepartmentMenu;

	@FindBys({	
		@FindBy(xpath = "//div[@data-t='header-navigation-container']/ul/li")
	}) List<WebElement> appliancesSubmenu;

	@FindBys({	
		@FindBy(xpath = "//div[@data-t='header-navigation-sidecar-container']/ul/li")
	}) List<WebElement> ItemByDepartmentSubmenu;

	@FindBy(xpath = "//li/button[.='Washers & Dryers']")
	WebElement washerDryerButton;

	@FindBy(xpath = "//li/a[.='Electric Dryers']")
	WebElement electricDryersButton;

	@FindBys({		
		@FindBy(xpath="//ol[@class='sku-item-list']/li[@class='sku-item']")
	})	
	private List<WebElement> listedItems;

	@FindBys({		
		@FindBy(xpath="//ol[@class='sku-item-list']/li[@class='sku-item']/descendant::h4/a")
	})	
	private List<WebElement> SelectedItemLink;

	@FindBy(xpath = "(//div[@class='fulfillment-add-to-cart-button'])[1]")
	WebElement addToCartButton;

	@FindBy(xpath = "//button[.='Continue shopping']")
	WebElement continueShoppingButton;

	@FindBy(xpath = "//div[.='Go to Cart']/a")
	WebElement goToCartButton;

	@FindBys({		
		@FindBy(xpath="//div[@class='flex-grid']/div/div[contains(@class,'flex-grid-row-2 flex-grid')]")
	})	
	private List<WebElement> brandedItems;

	@FindBy(xpath = "//a[@title='Cart']")
	WebElement cartButton;

	@FindBy(xpath = "//button[.='Checkout']")
	WebElement checkoutButton;

	@FindBy(xpath = "//div[@class='cia-signin']/descendant::div[@class='prefilled-value']")
	WebElement EmailAddress;

	@FindBy(xpath = "//input[@type='password']")
	WebElement password;

	@FindBy(xpath = "//button[contains(.,'Sign In')]")
	WebElement signInButton;

	@FindBy(xpath = "//form[@class='address-form']/descendant::input[@id='firstName']")
	WebElement firstName;

	@FindBy(xpath = "//form[@class='address-form']/descendant::input[@id='lastName']")
	WebElement lastName;

	@FindBy(xpath = "//form[@class='address-form']/descendant::input[@id='street']")
	WebElement address;

	@FindBy(xpath = "//form[@class='address-form']/descendant::input[@id='city']")
	WebElement city;

	@FindBy(xpath = "//form[@class='address-form']/descendant::select[@id='state']")
	WebElement state;

	@FindBy(xpath = "//form[@class='address-form']/descendant::input[@id='zipcode']")
	WebElement zipcode;

	@FindBy(xpath = "//input[@id='save-for-billing-address-Map {}']")
	WebElement saveForBillingAddressCheckbox;

	@FindBy(xpath = "//button[.='Apply']")
	WebElement applyButton;

	@FindBy(xpath = "//input[@id='text-updates']")
	WebElement receivetUpdateCheckbox;

	@FindBy(xpath = "//button[.='Continue to Payment Information']")
	WebElement scheduleDeliveryButton;

	@FindBy(xpath = "//button[.='Continue as Guest']")
	WebElement GuestLoginButton;

	@FindBy(xpath = "//div[@class='checkout__container']/descendant::button[.='Switch to shipping']")
	WebElement switchToShippingLink;

	@FindBy(xpath = "//section[@class='contact-information']/descendant::input[@id='user.emailAddress']")
	WebElement eMailaddress;

	@FindBy(xpath = "//section[@class='contact-information']/descendant::input[@id='user.phone']")
	WebElement phoneNumber;

	@FindBy(xpath = "//button[.='Keep Address as Entered']")
	WebElement KeepAddressLink;

	@FindBy(xpath = "//div[@class='creditCardNumberField']/descendant::input[@id='number']")
	WebElement creitCardNumber;

	@FindBy(xpath = "//button[.='Place Your Order']")
	WebElement placeOrder;

	@FindBys({		
		@FindBy(xpath="//div[@id='card-list']/div[@class='credit-card-banner__card']")
	})	
	private List<WebElement> paymentOptions;

	@FindBy(xpath = "//div[@itemprop='name']")
	WebElement itemPagetitle;


	//Methods

	public WebElement getItemPagetitle() {
		return itemPagetitle;
	}

	//Select the payment option
	public void FillPaymentInformation() {
		creitCardNumber.sendKeys(prop.getProperty("cardNumber"));
		for(int i = 0 ; i<paymentOptions.size(); i++) {
			if (paymentOptions.get(i).getText().contains(prop.getProperty("paymentOption"))) {
				action.moveToElement(paymentOptions.get(i)).click().build().perform();
			}
		}
	}

	//Click on place order
	public void PlaceOrder() {
		placeOrder.click();
	}

	// Login as Guest
	public void LoginAsGuest() {
		GuestLoginButton.click();
	}

	//Switch to shipping option
	public void switchToShipping() {
		if(switchToShippingLink.isEnabled()) {
			switchToShippingLink.click();
		}
	}

	//Fill the Delivery Address Form
	public void fillDeliveryAddressForm() throws IOException {
		initializeProp();
		firstName.sendKeys(prop.getProperty("FirstName"));
		lastName.sendKeys(prop.getProperty("LastName"));
		address.sendKeys(prop.getProperty("StreetName"));
		city.sendKeys(prop.getProperty("city"));
		select=new Select(state);
		select.selectByValue(prop.getProperty("countryState"));
		zipcode.sendKeys(prop.getProperty("zipcode"));
		if(!(saveForBillingAddressCheckbox.isSelected())){
			saveForBillingAddressCheckbox.click();
		}
		applyButton.click();
		eMailaddress.sendKeys(prop.getProperty("EMail"));
		phoneNumber.sendKeys(prop.getProperty("MobileNumber"));
		scheduleDeliveryButton.click();
		if(KeepAddressLink.isDisplayed()) {
			KeepAddressLink.click();
			scheduleDeliveryButton.click();
		}
	}



	//Click on Cart button
	public void cartButtonClick() {
		cartButton.click();
	}

	//Click on Checkout button
	public void checkoutButtonClick() {
		checkoutButton.click();
	}

	//Enter the Item to be searched in the search box
	public void enterSearchItem(String SearchItem) {
		searchElement.sendKeys(SearchItem);	
	}

	//Click on search button
	public void searchButtonClick() {
		searchButton.click();
	}

	//Click on Menu button
	public void MenuClick() {
		menuButton.click();
	}

	//Click on MenuItem 
	public void ClickMenuItem(String MenuItem) {
		for(int i = 0 ; i<shopByDepartmentMenu.size(); i++) {
			if (shopByDepartmentMenu.get(i).getText().equalsIgnoreCase(MenuItem)) {
				action.moveToElement(shopByDepartmentMenu.get(i)).click().build().perform();
			}
		}
	}

	//Click on first submenu
	public void ClcikSubmenu(String Submenu) {
		for(int i = 0 ; i<appliancesSubmenu.size(); i++) {
			if (appliancesSubmenu.get(i).getText().equalsIgnoreCase(Submenu)) {
				action.moveToElement(appliancesSubmenu.get(i)).click().build().perform();
			}
		}
	}

	//Click on second submenu
	public void ClcikItemSubMenu(String Item) {
		for(int i = 0 ; i<ItemByDepartmentSubmenu.size(); i++) {
			System.out.println(ItemByDepartmentSubmenu.get(i).getText());
			if (ItemByDepartmentSubmenu.get(i).getText().equalsIgnoreCase(Item)) {
				action.moveToElement(ItemByDepartmentSubmenu.get(i)).click().build().perform();
			}
		}
	}

	//Check wheather the search Item is getting displayed or not
	public void SelectItem(String ItemToSelect){		

		for(int i = 0 ; i<listedItems.size(); i++) {			
			if (listedItems.get(i).getText().contains(ItemToSelect)) {
				wait.until(ExpectedConditions.visibilityOf(listedItems.get(i)));
				action.scrollToElement(listedItems.get(i));
				action.scrollToElement(SelectedItemLink.get(i));
				wait.until(ExpectedConditions.elementToBeClickable(SelectedItemLink.get(i)));
				SelectedItemLink.get(i).click();	
			}
		}
	}


	//Display the title of the page
	public String getTitle(WebDriver driver) {
		String title = driver.getTitle();
		return title;
	}

	//Add an Item to the cart
	public void clickAddToCart() {
		InilializeJavaScriptExecutor();
		addToCartButton.click();	
	}

	//Click on GoToCart button
	public void clickGoToCart() {
		goToCartButton.click();	
	}

	//Click on Continue shopping
	public void clickContinueShoppingButton() {
		continueShoppingButton.click();	
	}

	//Select an Itemcateogary
	public void ChooseFrombrandedItems(String brandedItem){
		for(int i = 0 ; i<brandedItems.size(); i++) {
			if (brandedItems.get(i).getText().contains(brandedItem)) {
				action.moveToElement(brandedItems.get(i)).click().build().perform();
			}
		}
	}

}
