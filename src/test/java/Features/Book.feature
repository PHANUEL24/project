Feature: Hotel Booking
  A feature to book for a hotel

  Background:
    Given a user is on the home page
    When  a user navigates to the Login page using "https://adactinhotelapp.com/"
    And a user enter "Phanuel24" and "12345678"
    And a user clicks the login button

  Scenario Outline: Booking
    And a user fill in search form with details including "<checkInDate>" and "<checkOutDate>"
    And a user clicks the search button
    And a user select hotel
    And a user clicks the continue button
    And a user enters Booking details"<firstname>", "<lastname>", "<address>", "<cardNumber>", "<cardType>", "<expiryMonth>", "<expiryYear>", "<cvvNumber>"
    And a user clicks the book now button
    Then a user booking is "<status>"

    Examples:
      | firstname | lastname | address | cardNumber       | cardType | expiryMonth | expiryYear | cvvNumber | checkInDate | checkOutDate | status       |
      | Peter     | dayne    | Tembisa | 4578196783548219 | VISA     | March       | 2022       | 978       | 06/03/2022  | 08/03/2022   | successful   |
      | John      | dervin   | Soweto  | 57819678354      | VISA     | March       | 2022       | 978       | 06/03/2022  | 08/03/2022   | unsuccessful |
