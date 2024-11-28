
@tag
Feature: Login feature of Orange HRM Website

	Background:
    Given I Landed on the Orange HRM Website

  @tag2
  Scenario Outline: Positive Scenario for Login
    Given I Provide the <name> and <password>
    When I click in Login button
    Then Verify Home page is displayed

    Examples: 
      | name  | password | 
      | Admin | admin123 | 
