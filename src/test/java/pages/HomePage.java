package pages;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import base.TestBase;

public class HomePage extends TestBase {
	
	/**
	 * This will click on category
	 * @param driver - webdriver instance
	 * @param categoryName - category name
	 */
	public void clickOnCategory(WebDriver driver, String categoryName) {
		driver.findElement(By.xpath("//a[contains(text(),'" + categoryName + "')]")).click();
	}
	
	/**
	 * This will click on product
	 * @param driver - webdriver instance
	 * @param productName - product name
	 */
	public void clickOnProduct(WebDriver driver, String productName) {
		driver.findElement(By.xpath("//a[contains(text(),'" + productName + "')]")).click();
	}
	
	/**
	 * This will verify target element
	 * @param driver - webdriver instance
	 * @param message - message to verify
	 * @param expectedMatchingXPathCount - no of elements matching
	 */
	public void verifyTextOfTargetedElement(WebDriver driver, String message, int expectedMatchingXPathCount) {
		int iCount = 0;
		iCount = driver.findElements(By.xpath("//a[contains(text(),'" + message + "')]")).size();
		Assert.assertEquals(iCount, expectedMatchingXPathCount);
	}
	
	/**
	 * This will get price of product
	 * @param driver - webdriver instance
	 * @param productName - product name
	 */
	public String getPrice(WebDriver driver, String productName) {
		String price = driver.findElement(By.xpath("//td[contains(text(), '" + 
				productName + "')]/following-sibling::td[1]")).getText();
		return price;
	}
	
	/**
	 * This will add product to cart
	 * @param driver - webdriver instance
	 * @param elementName - product name
	 */
	public void addToCart(WebDriver driver, String elementName) {
		driver.findElement(By.xpath("//a[contains(text(),'" + elementName + "')]")).click();
	}
	
	/**
	 * This will accept pop up that product has been added to cart
	 * @param driver - WebDriver instance
	 */
	public void acceptPopup(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	
	/**
	 * This will delete product from cart
	 * @param driver - Webdriver instance
	 * @param productName - product name
	 */
	public void deleteProduct(WebDriver driver, String productName) {
		driver.findElement(By.xpath("//td[contains(text(), '" + productName + 
				"')]/following-sibling::td[2]/a[contains(text(), 'Delete')]")).click();
	}
	
	/**
	 * This will place order
	 * @param driver - Webdriver instance
	 */
	public void placeOrder(WebDriver driver) {
		driver.findElement(By.xpath("//button[contains(text(),'Place Order')]")).click();
	}
	
	/**
	 * This will fill form to buy the product
	 * @param driver - Webdriver instance
	 * @param elementName - form element name
	 * @param name - form element value
	 */
	public void fillForm(WebDriver driver, String elementName, String name) {
		driver.findElement(By.xpath("//input[@id='" + elementName + "']")).clear();
		driver.findElement(By.xpath("//input[@id='" + elementName + "']")).sendKeys(name);
	}
	
	/**
	 * This will click on purchase button
	 * @param driver - Webdriver instance
	 */
	public void purchaseOrder(WebDriver driver) {
		driver.findElement(By.xpath("//button[contains(text(),'Purchase')]")).click();
	}
	
	/**
	 * This will verify contents of purchased order
	 * @param driver - Webdriver instance
	 * @param expectedMatchingXPathCount - element matching xpath
	 */
	public void verifyTextOfPurchase(WebDriver driver, int expectedMatchingXPathCount) {
		int iCount = 0;
		iCount = driver.findElements(By.xpath("//h2[contains(text(),'Thank you for your purchase!')]")).size();
		Assert.assertEquals(iCount, expectedMatchingXPathCount);
	}
	
	/**
	 * This will verify purchase has been done successfully or not
	 * @param driver - Webdriver instance
	 * @return - returns text of successful order
	 */
	public String getTextFromPurchase(WebDriver driver) {
		String text = driver.findElement(By.xpath("//p[contains(@class, 'lead text-muted')]")).getText();
		return text;
	}
	
	/**
	 * This will capture screenshot for the page
	 * @param driver - Webdriver instance
	 */
	public void captureScreenshot(WebDriver driver) {
		try {
			TakesScreenshot scrShot =((TakesScreenshot)driver);
			//Call getScreenshotAs method to create image file
			File srcFile=scrShot.getScreenshotAs(OutputType.FILE);
			//Move image file to new destination
			File destFile=new File(System.getProperty("user.dir") + "/screenshots/purchaseOrder.png");
			//Copy file at destination
			FileUtils.copyFile(srcFile, destFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * This will click on ok button
	 * @param driver - Webdriver instance
	 */
	public void clickOk(WebDriver driver) {
		driver.findElement(By.xpath("//button[contains(text(),'OK')]")).click();
	}
}
