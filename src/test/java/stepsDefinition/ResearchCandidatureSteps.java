package stepsDefinition;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CandidaturePage;
import pages.DashboardPage;

public class ResearchCandidatureSteps {
	WebDriver driver = Hooks.driver;
	DashboardPage dashboard;
	CandidaturePage candidature;

	@When("the admin navigates to the candidature section")
	public void the_admin_navigates_to_the_candidature_section() {
		dashboard = new DashboardPage(driver);
		dashboard.click_Candidatures_Button();
	}

	@When("the admin types {string} in the search field")
	public void the_admin_types_in_the_search_field(String searchText) {
		candidature = new CandidaturePage(driver);
		candidature.typeInSearchField(searchText);
	}

	@Then("the data of the candidat should appear")
	public void the_data_of_the_candidat_should_appear() {
		assertFalse("No results message should be displayed", candidature.isNoResultsMessageDisplayed());
	}

	@Then("no candidat data should appear")
	public void no_candidat_data_should_appear() {
		assertTrue("No results message should be displayed", candidature.isNoResultsMessageDisplayed());
	}
}
