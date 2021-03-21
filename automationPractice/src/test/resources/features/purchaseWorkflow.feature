Feature: Customer purchase and order workflow

  Scenario: Order a T-shirt from AutomationPractice
    Given Iam logged into AutomationPractice with username "nagamanickam.uk@gmail.com" password "Welcome1-2"
    When I go to TShirts Section
    And Order a TShirt
    Then Item Added to Cart
      | Product successfully added to your shopping cart |
      | Faded Short Sleeve T-shirts                      |
      | Orange, S                                        |
      | 1                                                |
      | $16.51                                           |
      | $16.51                                           |
      | $2.00                                            |
      | $18.51                                           |
    When I Proceed with Checkout
    Then Im on Order Summary Page named "01. Summary"
      # Order Details
      | Faded...                        |
      | In stock                        |
      | 1                               |
      | $16.51                          |
      | $16.51                          |
      # Total
      | $16.51                          |
      | $2.00                           |
      | $16.51                          |
      | $18.51                          |
      # Delivery address
      | DELIVERY ADDRESS (TEST ADDRESS) |
      | Nagamanickam Mani               |
      | 5574 Greenoak Dr                |
      | San Jose, California 95129      |
      | +14082578902                    |
      | 7778707446                      |
      # Billing address
      | INVOICE ADDRESS (TEST ADDRESS) |
      | Nagamanickam Mani               |
      | 5574 Greenoak Dr                |
      | San Jose, California 95129      |
      | +14082578902                    |
      | 7778707446                      |
    When I Proceed to Address Page
    Then Im on Order Address Page named "03. Address"
      | Test Address               |
      | 1                          |
      | YOUR DELIVERY ADDRESS      |
      | Nagamanickam Mani          |
      | 5574 Greenoak Dr           |
      | San Jose, California 95129 |
      | United States              |
      | +14082578902               |
      | 7778707446                 |
      | YOUR BILLING ADDRESS       |
      | Nagamanickam Mani          |
      | 5574 Greenoak Dr           |
      | San Jose, California 95129 |
      | United States              |
      | +14082578902               |
      | 7778707446                 |
    When I Proceed to Shipping Page
    Then Im on Order Shipping Page named "04. Shipping"
      | $2.00                         |
      | My carrier Delivery next day! |
    When I Proceed to Payments Page
    Then Im on Order Payments Page named "05. Payment"
      | Faded Short Sleeve T-shirts |
      | In stock                    |
      | 1                           |
      | $16.51                      |
      | $16.51                      |
      # Final Total
      | $16.51                      |
      | $2.00                       |
      | $18.51                      |
    When I complete the Payment
    Then Im on Order Acknowledgement Page
      | Your order on My Store is complete. |
      | $18.51                              |
    When I go back to MyAccounts
    And  I go to My Order History
    Then I see my Recent Order Details for "$18.51" and status "On backorder"