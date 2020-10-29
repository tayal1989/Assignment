$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Feature/Assignment.feature");
formatter.feature({
  "line": 1,
  "name": "Adidas API and UI Problem",
  "description": "",
  "id": "adidas-api-and-ui-problem",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 3,
  "name": "Add/delete product on cart and purchase using UI automation",
  "description": "",
  "id": "adidas-api-and-ui-problem;add/delete-product-on-cart-and-purchase-using-ui-automation",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 5,
  "name": "User is on DemoBlaze Page",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "Navigates through product categories",
  "keyword": "And "
});
formatter.step({
  "line": 7,
  "name": "Laptop is added into cart",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "User deletes one of the laptop",
  "keyword": "Then "
});
formatter.step({
  "line": 9,
  "name": "User clicks on place order after filling form",
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "User purchases the item and validates it",
  "keyword": "And "
});
formatter.match({
  "location": "AssignmentStepDefinitionTest.user_is_on_DemoBlaze_Page()"
});
formatter.result({
  "duration": 8797564878,
  "status": "passed"
});
formatter.match({
  "location": "AssignmentStepDefinitionTest.navigates_through_product_categories()"
});
formatter.result({
  "duration": 2172149258,
  "status": "passed"
});
formatter.match({
  "location": "AssignmentStepDefinitionTest.laptop_is_added_into_cart()"
});
formatter.result({
  "duration": 62321296148,
  "status": "passed"
});
formatter.match({
  "location": "AssignmentStepDefinitionTest.user_deletes_one_of_the_laptop()"
});
formatter.result({
  "duration": 6724875170,
  "status": "passed"
});
formatter.match({
  "location": "AssignmentStepDefinitionTest.user_clicks_on_place_order_after_filling_form()"
});
formatter.result({
  "duration": 33674079773,
  "status": "passed"
});
formatter.match({
  "location": "AssignmentStepDefinitionTest.user_purchases_the_item_and_validates_it()"
});
formatter.result({
  "duration": 9046807652,
  "status": "passed"
});
formatter.scenario({
  "line": 12,
  "name": "Add/Update/Delete pet records using API automation",
  "description": "",
  "id": "adidas-api-and-ui-problem;add/update/delete-pet-records-using-api-automation",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 14,
  "name": "available pets are present",
  "keyword": "Given "
});
formatter.step({
  "line": 15,
  "name": "pets can be added",
  "keyword": "And "
});
formatter.step({
  "line": 16,
  "name": "pets status can be changed to sold",
  "keyword": "And "
});
formatter.step({
  "line": 17,
  "name": "pets can be deleted",
  "keyword": "And "
});
formatter.match({
  "location": "AssignmentStepDefinitionTest.available_pets_are_present()"
});
formatter.result({
  "duration": 4245527010,
  "status": "passed"
});
formatter.match({
  "location": "AssignmentStepDefinitionTest.pets_can_be_added()"
});
formatter.result({
  "duration": 1345112485,
  "status": "passed"
});
formatter.match({
  "location": "AssignmentStepDefinitionTest.pets_status_can_be_changed_to_sold()"
});
formatter.result({
  "duration": 1739675856,
  "status": "passed"
});
formatter.match({
  "location": "AssignmentStepDefinitionTest.pets_can_be_deleted()"
});
formatter.result({
  "duration": 1348514030,
  "status": "passed"
});
});