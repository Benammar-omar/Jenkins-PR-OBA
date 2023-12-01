package stepsDefinition;

import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LogiinPage;

public class LogAdminSteps {
	WebDriver driver = Hooks.driver;
	LogiinPage logiin;

	@Given("the admin is on the home page")
	public void the_admin_is_on_the_home_page() {
		driver.get("http://10.4.1.137/frontend/");

	}

	@When("the admin clicks on connexion")
	public void the_admin_clicks_on_connexion() {
		logiin = new LogiinPage(driver);
		logiin.clickConnexion();
	}

	@When("^the admin enters (.*) and (.*)$")
	public void the_admin_enters_email_and_password(String email, String password) {
		logiin.credentials(email, password);
	}

	@When("the admin clicks on login button")
	public void the_admin_clicks_on_login_button() {
		logiin.clickSubmit();
	}

	@Then("the admin is on the dashboard page")
	public void the_admin_is_on_the_dashboard_page() {
		logiin.checkInfoDisplayed();
	}
}
