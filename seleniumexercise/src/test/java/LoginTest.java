import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;
import java.util.Objects;

public class LoginTest {

    ChromeDriver chromeDriver;

    @Given("Browser dibuka")
    public void browser_dibuka() {
        System.out.println("Step browser dibuka");
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\Desendo\\Dropbox\\[ My Data ]\\[ Studi Informatika ]\\Informatika Semester 8\\Test Engineering\\test-engineering-TI4033\\seleniumexercise\\src\\main\\resources\\webdriver\\chromedriver.exe");
//                Objects.requireNonNull(getClass().getClassLoader()
//                        .getResource("webdriver/chromedriver.exe")).getFile());
        chromeDriver = new ChromeDriver();
        chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        chromeDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
    }
    @Given("User berada di halaman login")
    public void user_berada_di_halaman_login() {
        System.out.println("User berada di halaman login");
        chromeDriver.navigate().to("https://demo.guru99.com/Agile_Project/Agi_V1/index.php");
    }
    @When("User memasukkan username dan password")
    public void user_memasukkan_username_dan_password() {
        System.out.println("User memasukkan username dan password");
        chromeDriver.findElement(By.name("uid")).sendKeys("1303");
        chromeDriver.findElement(By.name("password")).sendKeys("Guru99");
    }
    @When("Tombol login ditekan")
    public void tombol_login_ditekan() {
        System.out.println("Tombol login ditekan");
        chromeDriver.findElement(By.name("btnLogin")).click();
    }
    @Then("User redirect ke halaman utama")
    public void user_redirect_ke_halaman_utama() {
        System.out.println("Validasi jika sudah berada di halaman utama");
        List<WebElement> list = chromeDriver.findElements(
                By.xpath("//*[contains(text(), '" + "Log out" + "')]"));
        Assertions.assertTrue(list
                .size() > 0, "Text not found");
//        chromeDriver.close();
//        chromeDriver.quit();
    }

}
