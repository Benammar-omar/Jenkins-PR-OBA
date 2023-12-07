package pages;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class CandidaturePage {
	WebDriver driver;

	By candidatNames = By.cssSelector("tbody.p-datatable-tbody > tr > td:nth-child(2)");
	By candidatDates = By.cssSelector("tbody.p-datatable-tbody > tr > td:nth-child(3)");
	By candidatCursus = By.cssSelector("tbody.p-datatable-tbody > tr > td:nth-child(4)");
	By candidatEmails = By.cssSelector("tbody.p-datatable-tbody > tr > td:nth-child(5)");
	By candidatPhones = By.cssSelector("tbody.p-datatable-tbody > tr > td:nth-child(6)");
	By candidatStatuses = By.cssSelector("tbody.p-datatable-tbody > tr > td:nth-child(7)");

	By nextPageBtn = By.cssSelector("p-paginator .p-paginator-next");
	By previousPageBtn = By.xpath("//button[contains(@class, 'p-paginator-prev')]");
	By finalPageBtn = By.cssSelector("p-paginator .p-paginator-last");
	By firstPageBtn = By.xpath("//button[contains(@class, 'p-paginator-first')]");
	By secondePageBtn = By.xpath("//button[normalize-space()='2']");
	By indexPage = By.xpath("//p-paginator//span[contains(@class, 'p-paginator-current')]");
	By searchField = By.xpath("//input[contains(@class, 'p-inputtext') and @placeholder='Recherche']");
	By noResultsMessage = By.xpath("//td[contains(text(),'Pas de candidatures trouvées.')]");

	By exportButton = By.cssSelector("button.p-button.p-component");

	public CandidaturePage(WebDriver driver) {
		this.driver = driver;
	}

	public void secondePageCandidature() {
		driver.findElement(secondePageBtn).click();
	}

	public void nextPageCandidature() {
		Actions action = new Actions(driver);
		action.sendKeys(Keys.DOWN);
		driver.findElement(nextPageBtn).click();
	}

	public void previousPageCandidature() {
		driver.findElement(previousPageBtn).click();
	}

	public void finalPageCandidature() {
		driver.findElement(finalPageBtn).click();
	}

	public void firstPageCandidature() {
		driver.findElement(firstPageBtn).click();
	}

	public String getIndexPageText() {
		return driver.findElement(indexPage).getText();
	}

	public void typeInSearchField(String text) {
		driver.findElement(searchField).sendKeys(text);
	}

	public boolean isNoResultsMessageDisplayed() {
		try {
			return driver.findElement(noResultsMessage).isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public List<String> getCandidatNames() {
		List<WebElement> nameElements = driver.findElements(candidatNames);
		List<String> names = new ArrayList<String>();
		for (WebElement nameElement : nameElements) {
			names.add(nameElement.getText().trim());
		}
		return names;
	}

	public List<WebElement> getCandidatDates() {
		return driver.findElements(candidatDates);
	}

	public boolean isValidDate(String dateString) {
		SimpleDateFormat format = new SimpleDateFormat("dd MMMM yyyy", Locale.FRENCH);
		try {
			format.parse(dateString);
			return true;
		} catch (ParseException e) {
			return false;
		}
	}

	public List<WebElement> getCandidatCursus() {
		return driver.findElements(candidatCursus);
	}

	public List<WebElement> getCandidatEmails() {
		return driver.findElements(candidatEmails);
	}

	public List<WebElement> getCandidatPhones() {
		return driver.findElements(candidatPhones);
	}

	public List<WebElement> getCandidatStatuses() {
		return driver.findElements(candidatStatuses);
	}

	public List<WebElement> getInfoButtons() {
		return driver.findElements(By.xpath("//tbody/tr/td[8]/div/button[contains(@class, 'pi-info')]"));
	}

	public List<WebElement> getDownloadCVButtons() {
		return driver.findElements(By.xpath("//tbody/tr/td[8]/div/button[contains(@class, 'pi-download')]"));
	}

	public List<WebElement> getCandidatureTreatmentDropdowns() {
		return driver.findElements(By.xpath("//tbody/tr/td[8]/div/div/p-dropdown/div/span"));
	}

	public void clickOnExportButton() {
		
		driver.findElement(exportButton).click();
	}

	public boolean isNextPageAvailable() {
		try {
			return driver.findElement(nextPageBtn).isEnabled();
		} catch (NoSuchElementException e) {
			return false;
		}
	}
	

	public void goToNextPage() {
		driver.findElement(nextPageBtn).click();
	}

}
