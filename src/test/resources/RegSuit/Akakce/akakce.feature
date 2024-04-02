@regsuit @akakce
Feature: feature

  Scenario: Login to Akakce

    Given user opens the homepage
    And   user clicks the "Giriş Yap" button
    When  user into the field "email" enters the value "mozdamar90@hotmail.com" 2
    And   user into the field "password" enters the value "aGdZx9.nMiKv9zG"
    And   user clicks the 2.th "submit" button
    Then  the WebElement with label "Mümin" should be visible





