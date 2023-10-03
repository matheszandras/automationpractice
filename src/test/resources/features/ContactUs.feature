Feature: Contact Us

  Scenario: Find, fill and submit successfully the Contact Us form.

    Given The user is on the website
    When The user clicks on the Contact Us button
    And The user fills the form
      | type  | selector                    | value                                                                                                                                                                              |
      | input | input[data-qa='name']       | Teszt                                                                                                                                                                              |
      | input | input[data-qa='email']      | test@test.com                                                                                                                                                                      |
      | input | input[data-qa='subject'   ] | Crocodilopolis                                                                                                                                                                     |
      | input | textarea[data-qa='message'] | It was the most significant centre of the cult of the crocodile god Sobek. In consequence, the Greeks called it "Crocodile City", which was borrowed into Latin as Crocodilopolis. |
    And The user uploads a file
    Then The user returns to the Homepage
