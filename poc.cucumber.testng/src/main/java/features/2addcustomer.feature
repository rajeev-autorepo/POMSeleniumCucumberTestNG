@AddCustomer 
Feature: Validate Add Customers features 

Scenario: Validate add customers into the system test 

Given user logs into the system 
Then user lands on Add Customer page
Then user select Pending option and invalid details and submit
|Kumar |Rawal  |ak@yopmail.com   |  $$kl          | 	8989090909|

Then dismiss the alert 
Then user select Done option and valid details and submit
|Rajeev |Singh  |valid@yopmail.com   |  Hinjawadi Pune| 	6545656560|

Then save the generated customer id 
Then close the opened browser
