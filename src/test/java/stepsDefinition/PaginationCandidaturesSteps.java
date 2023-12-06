package stepsDefinition;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CandidaturePage;

public class PaginationCandidaturesSteps {
	WebDriver driver = Hooks.driver;
	CandidaturePage candidature = new CandidaturePage(driver);

	@When("the admin is on the second page of candidatures")
	public void the_admin_is_on_the_second_page_of_candidatures() throws Throwable {
		Thread.sleep(1000);
		candidature.secondePageCandidature();
	}

	@When("the admin clicks on the next page button")
	public void the_admin_clicks_on_the_next_page_button() {

		candidature.nextPageCandidature();
	}

	@Then("the third page of candidatures should be displayed")
	public void the_third_page_of_candidatures_should_be_displayed() throws Throwable {
		String expectedText = "11 à 15";
		String actualText = candidature.getIndexPageText();
		Thread.sleep(1000);
		assert actualText.contains(expectedText) : "The pagination index does not contain the expected text.";
	}

	@When("the admin clicks on the previous page button")
	public void the_admin_clicks_on_the_previous_page_button() {
		candidature.previousPageCandidature();
	}

	@When("the admin clicks on the first page button")
	public void the_admin_clicks_on_the_first_page_button() {
		candidature.firstPageCandidature();
	}

	@Then("the first page of candidatures should be displayed")
	public void the_first_page_of_candidatures_should_be_displayed() {
		String expectedText = "1 à 5";
		String actualText = candidature.getIndexPageText();
		assert actualText.contains(expectedText) : "The pagination index does not contain the expected text.";
	}

	@When("the admin clicks on the final page button")
	public void the_admin_clicks_on_the_final_page_button() {

		candidature.finalPageCandidature();
	}

	@Then("the last page of candidatures should be displayed")
	public void the_last_page_of_candidatures_should_be_displayed() {
		String expectedText = "771 à 772";
		String actualText = candidature.getIndexPageText();
		assert actualText.contains(expectedText) : "The pagination index does not contain the expected text.";
	}

}