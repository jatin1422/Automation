
@tag
Feature: Order a product
  I want to use this template for my feature file

 Background: 
 Given: I landed on the Ecommerce page with this "https://rahulshettyacademy.com/client/"

  @tag2
  Scenario Outline: Positive test of purchase a product
    Given I login with <name> and <password>
    When I add a <product> to cart.
    And check out
    Then I got the "THANKYOU FOR THE ORDER." confirmation message

    Examples: 
      |name            |password |product    |
      |hello7@gmail.com|Angel@123|ZARA COAT 3|
      