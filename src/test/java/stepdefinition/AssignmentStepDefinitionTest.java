package stepdefinition;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.jayway.restassured.response.Response;

import apirequests.APIRequests;
import base.TestBase;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.HomePage;

public class AssignmentStepDefinitionTest extends TestBase {
	public HomePage hp = new HomePage();
	public APIRequests apiRequests = new APIRequests();
	public String priceOfProduct = "" ;
	public int getPetId = 2450 ;

	@Given("^User is on DemoBlaze Page$")
	public void user_is_on_DemoBlaze_Page() {
		instantiateDriver();
		driver.get(tdc.url);
	}

	@Given("^Navigates through product categories$")
	public void navigates_through_product_categories() {
		try {
			hp.clickOnCategory(driver, "Phones");
			hp.clickOnCategory(driver, "Laptops");
			hp.clickOnCategory(driver, "Monitors");
			Thread.sleep(2000);
		} catch(InterruptedException ie) {
			ie.printStackTrace();
		}
	}

	@When("^Laptop is added into cart$")
	public void laptop_is_added_into_cart() {
		try {
			hp.clickOnCategory(driver, "Laptops");
			hp.clickOnProduct(driver, "Sony vaio i5");

			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Add to cart')]")));
			
			hp.verifyTextOfTargetedElement(driver, "Add to cart", 1);
			hp.addToCart(driver, "Add to cart");
			Thread.sleep(2000);
			hp.acceptPopup(driver);
			Thread.sleep(2000);
			
			hp.clickOnCategory(driver, "Home");
			Thread.sleep(2000);
			
			hp.clickOnCategory(driver, "Laptops");
			Thread.sleep(2000);
			hp.clickOnProduct(driver, "Dell i7 8gb");
			Thread.sleep(2000);
			hp.verifyTextOfTargetedElement(driver, "Add to cart", 1);
			hp.addToCart(driver, "Add to cart");
			Thread.sleep(2000);
			hp.acceptPopup(driver);
			Thread.sleep(2000);
			
			hp.clickOnCategory(driver, "Cart");
			Thread.sleep(2000);
		} catch(InterruptedException ie) {
			ie.printStackTrace();
		}
	}

	@Then("^User deletes one of the laptop$")
	public void user_deletes_one_of_the_laptop() throws Throwable {
		hp.deleteProduct(driver, "Dell i7 8gb");
		Thread.sleep(5000);
	}

	@Then("^User clicks on place order after filling form$")
	public void user_clicks_on_place_order_after_filling_form() throws Throwable {
		priceOfProduct = hp.getPrice(driver, "Sony vaio i5");
		hp.placeOrder(driver);
		Thread.sleep(3000);
		hp.fillForm(driver, "name", "TestUser");
		hp.fillForm(driver, "country", "India");
		hp.fillForm(driver, "city", "Gurgaon");
		hp.fillForm(driver, "card", "1234123412341234");
		hp.fillForm(driver, "month", "12");
		hp.fillForm(driver, "year", "2020");
	}

	@Then("^User purchases the item and validates it$")
	public void user_purchases_the_item_and_validates_it() throws Throwable {
		hp.purchaseOrder(driver);
		Thread.sleep(2000);
		hp.verifyTextOfPurchase(driver, 1);
		hp.captureScreenshot(driver);
		String orderInformation = hp.getTextFromPurchase(driver);
		String purchaseId = orderInformation.split("Id:")[1].split("Amount")[0].trim();
		String amount = orderInformation.split("Amount:")[1].split("Card")[0].trim();
		System.out.println("Purchase ID :" + purchaseId);
		System.out.println("Amount :" + amount);
		Assert.assertEquals("Price is incorrect", priceOfProduct + " USD", amount);
		hp.clickOk(driver);
		driver.quit();
	}
	
	@Given("^available pets are present$")
	public void available_pets_are_present(){
		Response response = apiRequests.getAvailablePets(tdc.apiUrl, tdc.findPetStatusApi, "available");          
        JSONArray jsonarray = new JSONArray(response.asString());
        for (int i = 0; i < jsonarray.length(); i++) {
            JSONObject jsonobject = jsonarray.getJSONObject(i);
            String status = jsonobject.getString("status");
            Assert.assertEquals("Status should be available", "available", status);
        } 
	}

	@Given("^pets can be added$")
	public void pets_can_be_added(){
		Response response = apiRequests.addAvailablePets(tdc.apiUrl, tdc.addPetApi, getPetId);
		JSONObject jsonObject = new JSONObject(response.asString());
		//System.out.println(response.asString());
		Assert.assertEquals("Status should be available", "available", jsonObject.get("status"));
	}

	@Given("^pets status can be changed to sold$")
	public void pets_status_can_be_changed_to_sold() {
		Response response = apiRequests.updatePetStatus(tdc.apiUrl, tdc.addPetApi, getPetId, "sold");
		JSONObject jsonObject = new JSONObject(response.asString());
		//System.out.println(response.asString());
		Assert.assertEquals("Status should be sold", "sold", jsonObject.get("status"));
	}

	@Given("^pets can be deleted$")
	public void pets_can_be_deleted() {
		Response response = apiRequests.deletePetInfo(tdc.apiUrl, tdc.addPetApi, getPetId);
		JSONObject jsonObject = new JSONObject(response.asString());
		//System.out.println(response.asString());
		Assert.assertEquals("Code should be 200", 200, jsonObject.get("code"));
	}
}
