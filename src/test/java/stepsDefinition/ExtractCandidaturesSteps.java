package stepsDefinition;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CandidaturePage;
import pages.FileChecker;

public class ExtractCandidaturesSteps {
	WebDriver driver = Hooks.driver;
	CandidaturePage candidature;

	@When("the admin download data from multiple pages")
	public void the_admin_download_data_from_multiple_pages() {
		candidature = new CandidaturePage(driver);
		candidature.clickOnExportButton();
		candidature.secondePageCandidature();
		while (candidature.isNextPageAvailable()) {
			candidature.clickOnExportButton();
			candidature.goToNextPage();
		}
		candidature.clickOnExportButton();
	}

	@Then("data of all candidatures should be extracted")
	public void data_of_all_candidatures_should_be_extracted() {
		String directoryPath = "C:\\Users\\obenammar\\Downloads";
		String searchName = "applications-2023";

		FileChecker fileChecker = new FileChecker();
		boolean fileExists = fileChecker.checkFileContains(directoryPath, searchName);

		Assert.assertTrue("Aucun fichier ne contient '" + searchName + "' dans le nom.", fileExists);
	}
}
