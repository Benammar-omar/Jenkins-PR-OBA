package stepsDefinition;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CursusPage;
import pages.DashboardPage;
import pages.ModulePage;

public class AddLessonSteps {

	WebDriver driver = Hooks.driver;
	DashboardPage dashboard;
	CursusPage cursus;
	ModulePage module;

	@When("the admin clicks on cursus button")
	public void the_admin_clicks_on_cursus_button() {
		dashboard = new DashboardPage(driver);
		dashboard.clickCursusButton();
	}
	@When("the admin clicks on edit cursus button")
	public void the_admin_clicks_on_edit_cursus_button() {
		cursus = new CursusPage(driver);
		cursus.clicksEditCursusButton();
	}
	@When("the admin clicks on edit module button")
	public void the_admin_clicks_on_edit_module_button() {
		module = new ModulePage(driver);
		module.clicksEditModuleButton();
	}
	@When("the interface for adding a lesson appears")
	public void the_interface_for_adding_a_lesson_appears() {
		module.waitForAddLessonInterface();
	}
	@When("the admin types {string} and {string} as title and status of the lesson")
	public void the_admin_types_and_as_title_and_status_of_the_lesson(String title, String status) {
		module.typeLessonTitle(title);
		module.typeLessonStatus(status);
	}
	@Then("the add button becomes enabled")
	public void the_add_button_becomes_enabled() {
		assertTrue(module.isAddButtonEnabled());
		module.clicksAddButton();
	}
	@When("the admin types {string} and Test00 of the lesson")
	public void the_admin_types_and_test00_of_the_lesson(String title) {
		module.typeLessonTitle(title);
		module.typeLessonStatus("Test00");
	}
	@Then("the add button does not become enabled")
	public void the_add_button_does_not_become_enabled() {
		assertFalse(module.isAddButtonEnabled());
	}
	@When("the admin types LeconTest and {string} of the lesson")
	public void the_admin_types_lecon_test_and_of_the_lesson(String status) {
		module.typeLessonTitle("LeconTest");
		module.typeLessonStatus(status);
	}
	@When("the admin types {string} and {string} of the lesson")
	public void the_admin_types_and_of_the_lesson(String title, String status) {
		module.typeLessonTitle(title);
		module.typeLessonStatus(status);
	}
	@When("the admin enters the module info")
	public void the_admin_enters_the_module_info() {
		module = new ModulePage(driver);
		module.enterModule();
	}
	@Then("the lesson has been added")
	public void the_lesson_has_been_added() {
		assertTrue(module.isLessonDisplayed("LeconTest"));
	}
}
