package testcase;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import base.Baseclass;
import pageObjects.ShoppingPage;

public class AddItemTest extends Baseclass{

	//Search for and add an item to the shopping cart.
	@Test(priority = 1)
	public void SearchAndAddItem() throws InterruptedException, IOException {

		//Open the URL
		NavigateBestBuyURLTest.SelectUS();

		//Create an object for the shopping page
		ShoppingPage shopping=new ShoppingPage(driver);

		//Enter the Item to search 
		shopping.enterSearchItem(prop.getProperty("SearchItem"));

		//Click Search button
		shopping.searchButtonClick();

		//Check weather the search Item is displayed.
		shopping.SelectItem(prop.getProperty("SearchItemNumber"));
         System.out.println(shopping.getItemPagetitle().getText());
		Assert.assertTrue(shopping.getItemPagetitle().getText().contains("Panasonic - 1.6 Cu. Ft. 1250 Watt SN77HS Microwave with Cyclonic Inverter - Stainless Steel/silver"));
		//	Assert.assertEquals(shopping.getTitle(driver), "Panasonic - 1.6 Cu. Ft. 1250 Watt SN77HS Microwave with Cyclonic Inverter - Stainless Steel/silver");

		//Add the search Item to the cart
		shopping.clickAddToCart();

		//Click on continue shopping button.
		//	shopping.clickContinueShoppingButton();

	}	

	//Select and add an item from a Menu - Shop by Department).
	@Test(priority = 2)
	public void AddItemByDepartment() throws IOException {
		//Open the URL
		NavigateBestBuyURLTest.SelectUS();

		//Create an object for the shopping page
		ShoppingPage shopping=new ShoppingPage(driver);

		//Click on MainMenu 
		shopping.MenuClick();

		//Click on Menu Item under ShopByDepartment 
		shopping.ClickMenuItem(prop.getProperty("MenuItem"));

		//Select a Submenu 
		shopping.ClcikSubmenu(prop.getProperty("Submenu"));
		shopping.ClcikItemSubMenu(prop.getProperty("ItemByDepartment"));

		//Check wheather the search Item is displayed.
		shopping.SelectItem(prop.getProperty("ItemToSelect"));
		Assert.assertEquals(shopping.getTitle(driver), "Electric Dryers: Electric Clothes Dryer - Best Buy");

		//Add the search Item to the cart
		shopping.clickAddToCart();

		//Click on continue shopping button.
		//shopping.clickContinueShoppingButton();
	}	

	@Test (priority = 3)
	public void AddItemByBrand() throws InterruptedException, IOException {

		//Open the URL
		NavigateBestBuyURLTest.SelectUS();

		//Create an object for the shopping page
		ShoppingPage shopping=new ShoppingPage(driver);

		//Click on MainMenu
		shopping.MenuClick();

		//Click on Brands Menu
		shopping.ClickMenuItem(prop.getProperty("BrandsMenu"));

		//Click on Brand Name
		shopping.ClcikItemSubMenu(prop.getProperty("BrandName"));

		//Check wheather the Items belongs to the given brand page is displayed 
		Assert.assertEquals(shopping.getTitle(driver),"Sony Store: Sony Electronics & Entertainment - Best Buy");

		//Select on branded Itemcateogary
		shopping.ChooseFrombrandedItems(prop.getProperty("brandedItem"));

		//Check wheather the search Item is displayed.
		shopping.SelectItem(prop.getProperty("brandedItemToSelect"));
		Assert.assertEquals(shopping.getTitle(driver), "Sony ZV-1 20.1-Megapixel Digital Camera for Content Creators and Vloggers Black DCZV1/B - Best Buy");

		//Click on Add to Cart and Continue shopping
		shopping.clickAddToCart();
		shopping.clickContinueShoppingButton();

		//Click on cart
		shopping.cartButtonClick();

		//click on checkout button
		shopping.checkoutButtonClick();

		//GuestLogin
		shopping.LoginAsGuest();

		//switch To Shipping option
		shopping.switchToShipping();

		//Fill the delivery address form
		shopping.fillDeliveryAddressForm();

		//Fill the Payment form
		shopping.FillPaymentInformation();

		//Place an order
		shopping.PlaceOrder();
	}
}
