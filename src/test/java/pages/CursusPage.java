package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CursusPage {
	WebDriver driver;
	By editCursusBtn = By.xpath("//tbody/tr[1]/td[6]/em[1]");
	
	
	public CursusPage(WebDriver driver) {
		this.driver = driver;
	}

	public void clicksEditCursusButton () {
		driver.findElement(editCursusBtn).click();
	}
}
