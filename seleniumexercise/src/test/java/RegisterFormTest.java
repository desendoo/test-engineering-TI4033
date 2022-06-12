import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class RegisterFormTest {

    /**
     * This is a test to check whether the username (firstname and surname) is mandatory
     */
    static String firstname, surname;
    String usernamenameCheckResult;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        surname = surname;
    }

    private static Stream<Arguments> provideFirstnameAndSurname() {
        return Stream.of(
                Arguments.of("", ""),
                Arguments.of("Firstname", ""),
                Arguments.of("Firstname123", ""),
                Arguments.of("@Firstname", ""),
                Arguments.of("Firstname", "Surname"),
                Arguments.of("", "Surname"),
                Arguments.of("", "Surname123"),
                Arguments.of("", "#Surname"),
                Arguments.of("Firstname", "#Surname"),
                Arguments.of("@Firstname", "Surname"),
                Arguments.of("@Firstname", "#Surname")
        );
    }

//    @ParameterizedTest
//    @MethodSource("provideFirstnameAndSurname")
    @Given("The user name is {string} {string}")
    public void the_user_name_is(String string, String string2) {
        firstname = string;
        surname = string2;
    }
    @When("What is the firstname and surname characters length")
    public void what_is_the_firstname_and_surname_characters_length() {
        usernamenameCheckResult = Register.usernameCheckLength(firstname, surname);
    }
    @Then("The firstname length is {string}")
    public void the_firstname_length_is(String string) {
        System.out.println("Compare: " + string + " | " + usernamenameCheckResult);
        Assertions.assertEquals(string, usernamenameCheckResult);
    }

    /**
     * This is a test to check whether the password is composed of alphanumeric characters
     */
    String password, passwordCheckResult;

    @Given("The password is as follow {string}")
    public void the_password_is_as_follow(String string) {
        this.password = string;
    }
    @When("Is the password an alphanumeric")
    public void is_the_password_an_alphanumeric() {
        passwordCheckResult = Register.passwordCheckAlphanumeric(this.password);
    }
    @Then("The password is {string}")
    public void the_password_is(String string) {
        Assertions.assertEquals(string, passwordCheckResult);
    }

    /**
     * This is a test whether the password composed between eight to thirteen characters
     */
    @When("Is the password composed of eight to thirteen characters")
    public void is_the_password_composed_of_eight_to_thirteen_characters() {
        passwordCheckResult = Register.passwordCheckCharactersMinMax(this.password);
    }

}
