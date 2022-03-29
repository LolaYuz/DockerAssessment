Feature: Docker Web App Functionality

  Background:
    Given user is on "https://www.docker.com/"

  Scenario: Validate Docker Header Menu
    And user should see header options as below
      | empty      |
      | Products   |
      | Developers |
      | Pricing    |
      | Blog       |
      | About Us   |
      | Partners   |


  Scenario: Validate Search
    When user clicks on search icon
    And user should see search input box
    And user searches for "AWS"
    Then user should see "AWS" as the first search result


  Scenario: Validate Sign In
    Given user is on "https://www.docker.com/"
    When user clicks on "Sign In" button
    And user clicks on "Sign Up" button
    Then user should see "Create a Docker ID." form


  Scenario Outline: Validate Login
    When user clicks on "Sign In" button
    And user enters his "<username>"
    And user clicks on "Continue" button
    And user enters invalid "<password>"
    And user clicks on "Continue" button
    Then user should see a message starts with "<message>"
    Examples:
      | username | password            | message                              |
      | johndoe  | 12345               | Incorrect authentication credentials |
      | tomsmith | superSecretPassword | Incorrect authentication credentials |

  Scenario: Validate Developers dropdown
    When user hover over Developers option in the header
    Then user should see developer options are listed in the dropdown as below
      | Docs | Getting started | Community | Open Source | Preview Program |











