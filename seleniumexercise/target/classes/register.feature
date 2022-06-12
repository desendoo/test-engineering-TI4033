Feature: Feature to test register functionality

  Scenario Outline: Check whether the reset button exist
    Given Open the web browser
    And The user is in the register page
    And The reset button is as follow "<button_id>"
    When Is the reset button exist
    Then The reset button is "<response>"
    Examples:
      | button_id | response |
      | resetform | exist    |
      | reset     | not exist |

  Scenario Outline: Check whether the create button exist
    Given Open the web browser
    And The user is in the register page
    And The create button criteria is as follow "<button_type>" and "<button_value>"
    When Is the create button exist
    Then The create button is "<response>"
    Examples:
      | button_type | button_value | response |
      | submit      | Create       | exist    |
      |             | Create       | not exist    |
      | submit      |              | not exist    |
      | create      | Create       | not exist |