//Class contains webelements and methods for Menu navigation.
package pageObjects;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import utilities.UtilityPgm;

public class MenuPage extends UtilityPgm {

	//Data members
	public WebDriver driver;
	private ArrayList<String> eactualTitle = new ArrayList<String>();
	private ArrayList<String> bottomLinkactualTitle = new ArrayList<String>();

	//Constructors
	public MenuPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
		InilializeActions();
		InilializeWebDriverWait();
	}

	//Web elements
	@FindBys({		
		@FindBy(xpath="//div[@class='bottom-fluid-container ']/descendant::ul[@class='bottom-nav-left lv']/li")
	})	
	private List<WebElement> menuList;

	@FindBys({		
		@FindBy(xpath="//div[@class='flex justify-content-start']/a")
	})	
	private List<WebElement> bottomLinks;

	@FindBy(xpath="//a[.='Return to home page']")
	WebElement returnToHome;

	//Methods

	//Navigate through the menu Items
	public ArrayList<String> NavigateMenuList() throws IOException, InterruptedException {
		initializeProp();
		for(int i = 0 ; i<menuList.size() ; i++) {
			action.moveToElement(menuList.get(i)).click().build().perform();
			Thread.sleep(2000);
			getEactualTitle().add(i,driver.getTitle());		
		}
		return getEactualTitle();      
	}

	//Navigate the bottom links on the homepage.
	public ArrayList<String> NavigateBottomLink() throws IOException {
		initializeProp();
		for(int i = 0 ; i<bottomLinks.size() ; i++) {
			action.moveToElement(bottomLinks.get(i)).click().build().perform();
			System.out.println(driver.getTitle());
			getbottomLinkactualTitle().add(i,driver.getTitle());
			if(driver.getTitle().equalsIgnoreCase("Start Request - Best Buy")) {
				returnToHome.click();
			}
		}
		return getbottomLinkactualTitle();      
	}


	//Getters
	public ArrayList<String> getEactualTitle() {
		return eactualTitle;
	}

	//Getters
	public ArrayList<String> getbottomLinkactualTitle() {
		return bottomLinkactualTitle;
	}
}
