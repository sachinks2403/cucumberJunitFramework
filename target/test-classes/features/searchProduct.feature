Feature: Validate top deals

@Search
Scenario Outline: Search for product in both home and offer page


Given user is on GreenCart landing page
When user search for short name <productKey> and extract actual name of the product
Then user search for short name <productKey> in offers page to check if product exists

Examples:
|productKey|
|Tom|
|Beet|
 
