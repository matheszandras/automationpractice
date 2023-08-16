Feature: Register and delete new user account

  Scenario: Register new user

    Given The user is on the website
    When The user clicks on the Signup/Login button
    And The user fills name and email address fields
    And The user clicks on Signup button
    And The user fills the registration form
      | type     | selector                                   | value                 |
      | input    | input[value='Mr']                          |                       |
      | input    | input#password                             | password              |
      | select   | select#days                                |                       |
      | select   | select#days option[value='11']             |                       |
      | select   | select#months option[value='8']            |                       |
      | select   | select#years                               |                       |
      | select   | select#years option[value='1988']          |                       |
      | checkbox | input#newsletter                           |                       |
      | checkbox | input#optin                                |                       |
      | input    | input#first_name                           | Test                  |
      | input    | input#last_name                            | User                  |
      | input    | input#company                              | Lockheed Martin Corp. |
      | input    | input#address1                             | 6801 Rockledge Drive  |
      | input    | input#address2                             | ----                  |
      | select   | select#country                             |                       |
      | select   | select#country option[value='New Zealand'] |                       |
      | input    | input#state                                | Maryland              |
      | input    | input#city                                 | Bethesda              |
      | input    | input#zipcode                              | 20817                 |
      | input    | input#mobile_number                        | 0123456789            |
    And The user clicks on Create Account button
    Then The user clicks on the delete account button
