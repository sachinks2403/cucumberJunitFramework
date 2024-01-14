Feature: Verify product checkout

@Checkout
Scenario Outline: Search for product and place order


Given user is on GreenCart landing page
When user search for short name <productKey> and extract actual name of the product
And user adds "3" items to the cart
When user proceeds to checkout 
Then validates <productKey> item in the checkoutpage
And user verifies that he has ability to apply promocode and place order 

Examples:
|productKey|
|Tom|

