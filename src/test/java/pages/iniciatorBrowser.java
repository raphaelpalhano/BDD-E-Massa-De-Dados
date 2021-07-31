package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

public class iniciatorBrowser {
	
	private WebDriver driver;

	public iniciatorBrowser() {
		this.driver = new selectBrowser().createWebDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	

	public WebDriver getDriver() {
		return driver;
	}

}
