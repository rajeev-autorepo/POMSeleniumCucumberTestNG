@AddTeriffPlansPage
Feature: Add Teriff Plans feature test 

Scenario: Validate add teriff plans functionality 

	Given user opens the browser
	When click on left three bars icon
	Then user click on Add Teriff plans menu item
	Then Enter char value into monthly rental and validate error message
	Then enter number into monthly rental and char value into local free minutes and validate the error message
	Then enter alpha numeric value with special char into monthly rental and validate error message 
	Then click on Reset button to validate it
    Then enter valid numeric value in each fields and save and validate the success message
    |112 | 10 | 23 | 25| 30 | 40 | 100|
    Then close the browser here