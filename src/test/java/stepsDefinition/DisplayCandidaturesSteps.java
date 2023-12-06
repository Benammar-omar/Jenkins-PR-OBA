package stepsDefinition;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Then;
import pages.CandidaturePage;

public class DisplayCandidaturesSteps {
	WebDriver driver = Hooks.driver;
	CandidaturePage candidature;

	@Then("a valid full name should be displayed for each candidature")
	public void a_valid_full_name_should_be_displayed_for_each_candidature() {
		candidature = new CandidaturePage(driver);
		List<String> names = candidature.getCandidatNames();
		Pattern namePattern = Pattern.compile("^[A-Z][a-z]+\\s[A-Z][a-z]+$");
		for (String name : names) {
			assertTrue("Full name is empty ", !name.isEmpty());
			assertTrue("Invalid name format ", namePattern.matcher(name).matches());
		}
	}

	@Then("a valid date format should be displayed for each candidature")
	public void a_valid_date_format_should_be_displayed_for_each_candidature() {
		List<WebElement> dateElements = candidature.getCandidatDates();
		for (WebElement dateElement : dateElements) {
			String dateText = dateElement.getText().trim();
			assertTrue("Date format is incorrect", candidature.isValidDate(dateText));
		}
	}

	@Then("a valid cursus should be displayed for each candidature")
	public void a_valid_cursus_should_be_displayed_for_each_candidature() {
		List<WebElement> cursusElements = candidature.getCandidatCursus();
		List<String> validCursus = Arrays.asList("Test et validation", "Java Angular", "PHP Symfony Angular", "Data");
		for (WebElement cursusElement : cursusElements) {
			String cursusText = cursusElement.getText().trim();
			assertTrue("Cursus is invalid", validCursus.contains(cursusText));
		}
	}

	@Then("a valid email should be displayed for each candidature")
	public void a_valid_email_should_be_displayed_for_each_candidature() {
		Pattern emailPattern = Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}$");
		List<WebElement> emails = candidature.getCandidatEmails();
		for (WebElement email : emails) {
			assertTrue("Email format is incorrect", emailPattern.matcher(email.getText()).matches());
		}
	}

	@Then("a valid phone number should be displayed for each candidature")
	public void a_valid_phone_number_should_be_displayed_for_each_candidature() {
		Pattern phonePattern = Pattern.compile("^\\d{8}$");
		List<WebElement> phones = candidature.getCandidatPhones();
		for (WebElement phone : phones) {
			assertTrue("Phone number format is incorrect", phonePattern.matcher(phone.getText()).matches());
		}
	}

	@Then("a valid status should be displayed for each candidature")
	public void a_valid_status_should_be_displayed_for_each_candidature() {
		List<WebElement> statuses = candidature.getCandidatStatuses();
		List<String> validStatuses = Arrays.asList("En-taitement", "Refusé", "Non-conforme", "Accepté");
		for (WebElement status : statuses) {
			String statusText = status.getText().trim();
//			assertTrue("Status is not one of the valid options: " + statusText, validStatuses.contains(statusText));
		}
	}

	@Then("an information button should be displayed for each candidature")
	public void an_information_button_should_be_displayed_for_each_candidature() {
		candidature = new CandidaturePage(driver);
		List<WebElement> infoButtons = candidature.getInfoButtons();
		for (WebElement button : infoButtons) {
			assertTrue("Information button is not displayed", button.isDisplayed());
		}
	}

	@Then("a download CV button should be displayed for each candidature")
	public void a_download_CV_button_should_be_displayed_for_each_candidature() {
		List<WebElement> downloadCVButtons = candidature.getDownloadCVButtons();
		for (WebElement button : downloadCVButtons) {
			assertTrue("Download CV button is not displayed", button.isDisplayed());
		}
	}

	@Then("a candidature treatment action should be displayed only for candidatures with the status Accepted or In process")
	public void a_candidature_treatment_action_should_be_displayed_only_for_candidatures_with_the_status_Accepted_or_In_process() {
		List<WebElement> treatmentDropdowns = candidature.getCandidatureTreatmentDropdowns();
		List<WebElement> statuses = candidature.getCandidatStatuses();

		for (int i = 0; i < treatmentDropdowns.size(); i++) {
			String currentStatus = statuses.get(i).getText();
			if (currentStatus.equals("Accepted") || currentStatus.equals("In process")) {
				WebElement dropdown = treatmentDropdowns.get(i);
				assertTrue("Candidature treatment dropdown is not displayed for the correct status",
						dropdown.isDisplayed());
			}
		}

	}

}
