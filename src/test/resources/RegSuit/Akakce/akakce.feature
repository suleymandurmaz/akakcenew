@regsuit @akakce
Feature: feature

  Scenario: Login to Akakce

    Given user opens the homepage
    And   user clicks the "Giriş Yap" button
    When  user into the field "email" enters the value "sdurmaz77@hotmail.com" 2
    And   user into the field "password" enters the value "iWifmmn3m-.YR9"
    And   user clicks the 2.th "submit" button
    Then  the WebElement with label "Suleyman" should be visible





