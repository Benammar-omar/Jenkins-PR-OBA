package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ModulePage {
	WebDriver driver;
	By editModuleBtn = By.xpath("//tbody/tr[1]/td[5]/em[1]");
	By lessonTitle = By.xpath("//input[@id='description']");
	By lessonStatus = By.xpath("//input[@id='status']");
	By addLessonBtn = By
			.xpath("//p-dialog[.//span[contains(text(),'Ajouter')]]//button[span[contains(text(),'Ajouter')]]");
	By infoModuleBtn = By.xpath("//td/button/span");
	By interfaceAddLesson = By.cssSelector("#pr_id_10-label");

	public ModulePage(WebDriver driver) {
		this.driver = driver;
	}
	public void waitForAddLessonInterface() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(interfaceAddLesson));
	}
	public boolean isAddButtonEnabled() {
		return driver.findElement(addLessonBtn).isEnabled();
	}
	public void clicksAddButton() {
		driver.findElement(addLessonBtn).click();
	}
	public boolean isLessonDisplayed(String lessonTitle) {
		return driver.findElements(By.xpath("//td[contains(text(),'" + lessonTitle + "')]")).size() > 0;
	}
	public void typeLessonTitle(String title) {
		driver.findElement(lessonTitle).click();
		driver.findElement(lessonTitle).clear();
		driver.findElement(lessonTitle).sendKeys(title);
	}
	public void typeLessonStatus(String status) {
		driver.findElement(lessonStatus).click();
		driver.findElement(lessonStatus).clear();
		driver.findElement(lessonStatus).sendKeys(status);
	}
	public void clicksEditModuleButton() {
		driver.findElement(editModuleBtn).click();
	}
	public void enterModule() {
		driver.findElement(infoModuleBtn).click();
	}
	public boolean isModuleButtonPresent() {
        try {
            return driver.findElement(editModuleBtn).isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException | org.openqa.selenium.TimeoutException e) {
        	 System.out.println("There is no module in this Course.");
        	return false;
        }
    }
}
