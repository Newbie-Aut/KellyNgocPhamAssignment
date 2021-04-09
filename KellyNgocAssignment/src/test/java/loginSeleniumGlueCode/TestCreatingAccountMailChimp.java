package loginSeleniumGlueCode;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class TestCreatingAccountMailChimp {
	WebDriver driver1 = null;

	RandomClass randNum = new RandomClass();

	@Given("I open Chrome and launch the application")
	public void i_open_chrome_and_launch_the_application() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\kelly\\ChromeDriver\\chromedriver.exe");
		driver1 = new ChromeDriver();

		driver1.get("https://login.mailchimp.com/signup/");

	}

	@Given("I write an {string} in  the email field")
	public void i_write_an_in_the_email_field(String email) {

		driver1.findElement(By.id("email")).sendKeys(email);

	}

	@Given("I write an {string} in the username field")
	public void i_write_an_in_the_username_field(String username) {

		driver1.findElement(By.id("new_username")).sendKeys(username);

	}

	@Given("I write an {string}+    <RandomNumber> in the username field")
	public void i_write_an_random_number_in_the_username_field(String username) {
		driver1.findElement(By.id("new_username")).sendKeys(username + randNum.RandomNumber());

	}

	@Given("I also write a {string} in the password field")
	public void i_also_write_a_in_the_password_field(String password) throws InterruptedException {

		driver1.findElement(By.id("new_password")).sendKeys(password);
		Thread.sleep(3000);

	}

	@When("I press submit button")
	public void i_press_submit_button() throws InterruptedException {
		WebElement button = driver1.findElement(By.name("password"));
		button.submit();
	}

	@Then("The {string} should show on the screen")
	public void the_should_show_on_the_screen(String status) throws InterruptedException {

		String expectedResult = "";
		String actualResult = "";

		if (status.equals("userExist")) {
			expectedResult = "Another user with this username already exists. Maybe it's your evil twin. Spooky.";
			actualResult = driver1.findElement(By.cssSelector("span[class=invalid-error]")).getText();
			Assert.assertEquals(expectedResult, actualResult);
			System.out.println("Testcase1");
		}

		else if (status.equals("longUsername")) {

			expectedResult = "Enter a value less than 100 characters long";
			actualResult = driver1.findElement(By.className("invalid-error")).getText();
			Assert.assertEquals(expectedResult, actualResult);
			System.out.println("Testcase2");
		}

		else if (status.equals("emptyEmail")) {
			expectedResult = "Please enter a value";
			actualResult = driver1.findElement(By.className("invalid-error")).getText();
			Assert.assertEquals(expectedResult, actualResult);
			System.out.println("Testcase3");
		}

		else if (status.equals("success")) {
			expectedResult = "Check your email";
			actualResult = driver1.findElement(By.xpath("//*[@id=\"signup-content\"]/div/div/div/h1")).getText();
			Assert.assertEquals(expectedResult, actualResult);
			System.out.println("Testcase4");
		}

		Thread.sleep(3000);
		driver1.quit();
	}

}
