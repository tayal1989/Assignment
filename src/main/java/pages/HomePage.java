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
	
	public void clickOnCategory(WebDriver driver, String categoryName) {
		driver.findElement(By.xpath("//a[contains(text(),'" + categoryName + "')]")).click();
	}
	
	public void clickOnProduct(WebDriver driver, String productName) {
		driver.findElement(By.xpath("//a[contains(text(),'" + productName + "')]")).click();
	}
	
	public void verifyTextOfTargetedElement(WebDriver driver, String message, int expectedMatchingXPathCount) {
		int iCount = 0;
		iCount = driver.findElements(By.xpath("//a[contains(text(),'" + message + "')]")).size();
		Assert.assertEquals(iCount, expectedMatchingXPathCount);
	}
	
	public String getPrice(WebDriver driver, String productName) {
		String price = driver.findElement(By.xpath("//td[contains(text(), '" + 
				productName + "')]/following-sibling::td[1]")).getText();
		return price;
	}
	
	public void addToCart(WebDriver driver, String elementName) {
		driver.findElement(By.xpath("//a[contains(text(),'" + elementName + "')]")).click();
	}
	
	public void acceptPopup(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	
	public void deleteProduct(WebDriver driver, String productName) {
		driver.findElement(By.xpath("//td[contains(text(), '" + productName + 
				"')]/following-sibling::td[2]/a[contains(text(), 'Delete')]")).click();
	}
	
	public void placeOrder(WebDriver driver) {
		driver.findElement(By.xpath("//button[contains(text(),'Place Order')]")).click();
	}
	
	public void fillForm(WebDriver driver, String elementName, String name) {
		driver.findElement(By.xpath("//input[@id='" + elementName + "']")).clear();
		driver.findElement(By.xpath("//input[@id='" + elementName + "']")).sendKeys(name);
	}
	
	public void purchaseOrder(WebDriver driver) {
		driver.findElement(By.xpath("//button[contains(text(),'Purchase')]")).click();
	}
	
	public void verifyTextOfPurchase(WebDriver driver, int expectedMatchingXPathCount) {
		int iCount = 0;
		iCount = driver.findElements(By.xpath("//h2[contains(text(),'Thank you for your purchase!')]")).size();
		Assert.assertEquals(iCount, expectedMatchingXPathCount);
	}
	
	public String getTextFromPurchase(WebDriver driver) {
		String text = driver.findElement(By.xpath("//p[contains(@class, 'lead text-muted')]")).getText();
		return text;
	}
	
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
	
	public void clickOk(WebDriver driver) {
		driver.findElement(By.xpath("//button[contains(text(),'OK')]")).click();
	}
}
