Feature: Adidas API and UI Problem

Scenario: Add/delete product on cart and purchase using UI automation

Given User is on DemoBlaze Page
And Navigates through product categories
When Laptop is added into cart
Then User deletes one of the laptop
And User clicks on place order after filling form
And User purchases the item and validates it

Scenario: Add/Update/Delete pet records using API automation

Given available pets are present
And pets can be added
And pets status can be changed to sold
And pets can be deleted