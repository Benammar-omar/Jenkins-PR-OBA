package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogiinPage {
	WebDriver driver;
	By connexion = By.xpath("//span[contains(text(),'CONNEXION')]");
	By user = By.xpath("//input[@id='email']");
	By password = By.xpath("//input[@id='password']");
	By submit = By.xpath("//span[contains(text(),\"S'identifier\")]");
	By info = By.xpath("//h1[contains(text(),'Tableau De Bord')]");

	public LogiinPage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickConnexion() {
		driver.findElement(connexion).click();
	}

	public void credentials(String email, String pass) {
		driver.findElement(user).click();
		driver.findElement(user).sendKeys(email);
		driver.findElement(password).click();
		driver.findElement(password).sendKeys(pass);
	}

	public void clickSubmit() {
		driver.findElement(submit).click();
	}

	public void checkInfoDisplayed() {
		driver.findElement(info).isDisplayed();
	}

}
