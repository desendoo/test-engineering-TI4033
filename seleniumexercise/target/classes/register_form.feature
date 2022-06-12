Feature: Feature to test register functionality

  Scenario Outline: Check username is mandatory
    Given The user name is "<firstname>" "<surname>"
    When What is the firstname and surname characters length
    Then The firstname length is "<response>"
    Examples:
      | firstname | surname | response |
      |           |         | zero     |
      | Firstname |         | less than 64 characters and is an alphanumeric |
      | Firstname123 |      | less than 64 characters and is an alphanumeric |
      | @Firstname |        | less than 64 characters and is not an alphanumeric |
      | Firstname | Surname | less than 64 characters and is an alphanumeric |
      |           | Surname | less than 64 characters and is an alphanumeric |
      |           | Surname123 | less than 64 characters and is an alphanumeric |
      |           | #Surname | less than 64 characters and is not an alphanumeric |
      | o99CUkCg1A35rfzGS8pa62R9MexcH806OTfbGzFJH7w7FrY39Pd5mTYvXHSsmLtqk | | more than 64 characters and is an alphanumeric |
      | @@@o99CUkCg1A35rfzGS8pa62R9MexcH806OTfbGzFJH7w7FrY39Pd5mTYvXHSsmLtqk | | more than 64 characters and is not an alphanumeric |
      |           | o99CUkCg1A35rfzGS8pa62R9MexcH806OTfbGzFJH7w7FrY39Pd5mTYvXHSsmLtqk | more than 64 characters and is an alphanumeric |
      |           | @@@o99CUkCg1A35rfzGS8pa62R9MexcH806OTfbGzFJH7w7FrY39Pd5mTYvXHSsmLtqk | more than 64 characters and is not an alphanumeric |

  Scenario Outline: Check password is an alphanumeric
    Given The password is as follow "<password>"
    When Is the password an alphanumeric
    Then The password is "<response>"
    Examples:
      | password | response |
      | Password | an alphanumeric |
      | Password123 | an alphanumeric |
      | Password123# | not an alphanumeric |
      | Password123@ | not an alphanumeric |
      | Password123% | not an alphanumeric |
      | Password123. | not an alphanumeric |

  Scenario Outline: Check password is composed between eight to thirteen characters
    Given The password is as follow "<password>"
    When Is the password composed of eight to thirteen characters
    Then The password is "<response>"
    Examples:
      | password | response |
      |          | less than 8 characters |
      | Pass     | less than 8 characters |
      | Password123 | valid |
      | Password123% | valid |
      | Password123. | valid |
      | Password123456 | more than 13 characters |
      | Password1234567890 | more than 13 characters |