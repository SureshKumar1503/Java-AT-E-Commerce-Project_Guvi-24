package testcase;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import base.Baseclass;
import pageObjects.MenuPage;
import utilities.DataConstants;

public class NavigateMenuItemsTest extends Baseclass {

	//navigate all Menu and validation of title in each page.
	@Test
	public void NavigateMenuItems() throws InterruptedException, IOException {
		//create an object 
		NavigateBestBuyURLTest.SelectUS();
		MenuPage menu=new MenuPage(driver);		
		
		//Navigate through the Menus
		menu.NavigateMenuList();
		
		//Validate the title of each page
		for(int i = 0 ; i<menu.getEactualTitle().size() ; i++) {
			Assert.assertEquals(menu.getEactualTitle().get(i),DataConstants.expTitle.get(i));
		}			
	}
	
	
	//navigate all bottom links and do validation 
		@Test
		public void NavigateBottomLinks() throws InterruptedException, IOException {
			//create an object 
			NavigateBestBuyURLTest.SelectUS();
			MenuPage menu=new MenuPage(driver);		
			
			//Navigate through the Menus
			menu.NavigateBottomLink();
			
			//Validate the title of each page
			for(int i = 0 ; i<menu.getbottomLinkactualTitle().size() ; i++) {
				Assert.assertEquals(menu.getbottomLinkactualTitle().get(i),DataConstants.bottomLinkexpTitle.get(i));
			}			
		}
}
