package base;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import config.TestdataConfig;

public class TestBase {
	public WebDriver driver = null;
	public TestdataConfig tdc = new TestdataConfig();
	public static final Logger log = Logger.getLogger(TestBase.class);

	/**
	 * Default constructor to initialize variables
	 */
	public TestBase() {
		tdc.populateConfiguration();
	}

	/**
	 * This will open chrome driver and has set 30 seconds for each webelement
	 * to load
	 */
	public void instantiateDriver() {
		try {
			BasicConfigurator.configure();
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
