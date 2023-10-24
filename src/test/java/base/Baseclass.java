//This class contains functions which has to be executed Aftermethod and BeforeMethod
package base;

import java.io.IOException;
import java.time.Duration;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utilities.UtilityPgm;

public class Baseclass extends UtilityPgm{

	@BeforeMethod	
	public void startup() throws IOException {
		//Initialize the driver
		driver=initializeDriver();

		//Load the URL
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(45));
	}

	@AfterMethod
	public void close() {
			driver.quit();
	}
}
