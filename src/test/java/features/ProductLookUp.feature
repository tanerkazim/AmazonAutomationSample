Feature: Amazon Product Look Up


  Scenario: Search for given product, find first result and log product details
    Given Go to "https://www.amazon.com.tr/"
    When Search "iPhone13"
    Then Check that the results are listed
    And Click iPhone 13 at the top of the list
    Then Log the product details for each size