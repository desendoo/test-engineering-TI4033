import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class RegisterTest {

    ChromeDriver chromeDriver;

    @Given("Open the web browser")
    public void open_the_web_browser() {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\Desendo\\Dropbox\\[ My Data ]\\[ Studi Informatika ]\\Informatika Semester 8\\Test Engineering\\test-engineering-TI4033\\seleniumexercise\\src\\main\\resources\\webdriver\\chromedriver.exe");
//                Objects.requireNonNull(getClass().getClassLoader()
//                        .getResource("webdriver/chromedriver.exe")).getFile());
        chromeDriver = new ChromeDriver();
        chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        chromeDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
    }
    @Given("The user is in the register page")
    public void the_user_is_in_the_register_page() {
        chromeDriver.navigate().to("https://demo.guru99.com/insurance/v1/register.php");
    }

    /**
     * Check whether the reset button exist
     */
    String buttonId, buttonStatusCheckResult;

    @Given("The reset button is as follow {string}")
    public void the_reset_button_is_as_follow(String string) {
        this.buttonId = string;
    }
    @When("Is the reset button exist")
    public void is_the_reset_button_exist() {
        List<WebElement> list = chromeDriver.findElements(
                By.id(this.buttonId));

        if (list.size() > 0) {
            this.buttonStatusCheckResult = "exist";
        } else {
            this.buttonStatusCheckResult = "not exist";
        }

    }
    @Then("The reset button is {string}")
    public void the_reset_button_is(String string) {
        Assertions.assertEquals(string, this.buttonStatusCheckResult);
        chromeDriver.close();
        chromeDriver.quit();
    }

    /**
     * Check whether the create button exist
     */
    String buttonType, buttonValue;

    @Given("The create button criteria is as follow {string} and {string}")
    public void the_create_button_criteria_is_as_follow(String string, String string2) {
        this.buttonType = string;
        this.buttonValue = string2;
    }
    @When("Is the create button exist")
    public void is_the_create_button_exist() {
        List<WebElement> list = chromeDriver.findElements(
                By.xpath("//input[@type='" + this.buttonType + "' and @value='" + this.buttonValue + "']"));

        if (list.size() > 0) {
            this.buttonStatusCheckResult = "exist";
        } else {
            this.buttonStatusCheckResult = "not exist";
        }
    }
    @Then("The create button is {string}")
    public void the_create_button_is(String string) {
        Assertions.assertEquals(string, this.buttonStatusCheckResult);
        chromeDriver.close();
        chromeDriver.quit();
    }

    /**
     * This is a test case to input the username into the form
     */
    String firstname, surname, password;
    @Given("The user name to be entered {string} {string}")
    public void the_user_name_to_be_entered(String string, String string2) {
        this.firstname = string;
        this.surname = string2;
    }
    @When("Input the username into the form")
    public void input_the_username_into_the_form() {
        chromeDriver.findElement(By.id("user_firstname")).sendKeys(this.firstname);
        chromeDriver.findElement(By.id("user_surname")).sendKeys(this.surname);
    }
    @Given("The password to be entered {string}")
    public void the_password_to_be_entered(String string) {
        this.password = string;
    }
    @When("Input the password into the form")
    public void input_the_password_into_the_form() {
        chromeDriver.findElement(By.id("user_user_detail_attributes_password")).sendKeys(this.password);
        chromeDriver.findElement(By.id("user_user_detail_attributes_password_confirmation")).sendKeys(this.password);
    }

}
