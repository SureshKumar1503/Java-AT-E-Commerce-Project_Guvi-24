package testcase;

import java.io.IOException;
import java.time.Duration;
import org.testng.Assert;
import org.testng.annotations.Test;
import base.Baseclass;
import pageObjects.BestBuyURLPage;
import utilities.DataConstants;


public class NavigateBestBuyURLTest extends Baseclass{

	//To open a web browser and navigate to the Best Buy e-commerce website (https://www.bestbuy.com/).

	@Test(priority = 1)
	public void NavigateURL() throws IOException{	
		// Check the title of the website
		Assert.assertEquals(driver.getTitle(),DataConstants.urlTitle);		
	}

	//To open a Best Buy e-commerce website and select a country-US
	@Test (priority = 2)
	public static void SelectUS()  {
		
		//Creata an object and select a country US
		BestBuyURLPage bestbuyURL = new BestBuyURLPage(driver);
		
		//Select US
		bestbuyURL.SelectUS();		

		// Check the title of the website
		Assert.assertEquals(driver.getTitle(),DataConstants.urlUSTitle);	

	}

	//To open a Best Buy e-commerce website and select a country-Canada
	@Test (priority = 3)
	public void SelectCanada() throws InterruptedException, IOException {
		//Create an object and select a country Canada
		BestBuyURLPage bestbuyURL= new BestBuyURLPage(driver);
		
		//Select Canada
		bestbuyURL.SelectCanada();	
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(45));

		// Check the title of the website
		Assert.assertEquals(driver.getTitle(),DataConstants.urlCanadaTitle);	

	}
}
