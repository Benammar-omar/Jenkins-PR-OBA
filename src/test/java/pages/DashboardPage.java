package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {
	WebDriver driver;
	By cursusBtn = By.xpath("//span[contains(text(),'Cursus')]");
	By candidatureBtn = By.xpath("/html[1]/body[1]/app-root[1]/app-admin[1]/p-menubar[1]/div[1]/p-menubarsub[1]/ul[1]/li[4]/a[1]/span[1]");
	
	public DashboardPage(WebDriver driver) {
		this.driver = driver;
	}
	public void clickCursusButton() {
		driver.findElement(cursusBtn).click();
	}
	public void click_Candidatures_Button() {
		driver.findElement(candidatureBtn).click();
	}
}
