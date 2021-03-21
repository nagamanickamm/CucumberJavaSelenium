Feature: Change my preference on Automation practice

  Scenario: Change my preference
    Given Iam logged into AutomationPractice with username "nagamanickam.uk@gmail.com" password "Welcome1-2"
    When I go to My personal information page
    Then Im at My personal informational page
    When I change my firstname "nagamanickam" "Welcome1-2"
    Then My firstName is changed