# Author : Vikas Sharma
Feature: GoogleSearch

#  Scenario: This is a sample Scenario for Google Search

  @GoogleSearch
  Scenario Outline: This is a sample Scenario for Google Search
    Given Goto Google HomePage "<GoogleHomePageURL>"
    When Enter "<textToBeSearched>" in the search text field
    And Click on Search Button


    Examples:
      |GoogleHomePageURL       |textToBeSearched|
      |https://www.google.co.in|India           |
      |https://www.google.co.in|London          |
      |https://www.google.co.in|USA             |