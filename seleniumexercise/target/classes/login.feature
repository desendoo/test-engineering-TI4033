Feature: Feature to test login functionality
  Scenario: Periksa login dengan akun yang benar
    Given Browser dibuka
    And User berada di halaman login
    When User memasukkan username dan password
    And Tombol login ditekan
    Then User redirect ke halaman utama



