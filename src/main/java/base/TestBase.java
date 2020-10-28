package base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import config.TestdataConfig;

public class TestBase {
	public WebDriver driver = null;
	public TestdataConfig tdc = new TestdataConfig();

	/**
	 * Default constructor to initialize variables
	 */
	public TestBase() {
		tdc.populateConfiguration();
	}

	public void instantiateDriver() {
		try {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "/resources/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
