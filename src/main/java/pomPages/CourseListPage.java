package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.WebdriverUtility;

public class CourseListPage {

	// Declaration
	@FindBy(xpath = "//h1[normalize-space(text())='Course List']")
	private WebElement pageHeader;

	@FindBy(xpath = "//a[text()=' New']")
	private WebElement newButton;

	private String deletePath = "//td[text()='%s']/ancestor::tr/descendant::button[text()='Delete']";

	@FindBy(xpath = "delete")
	private WebElement deleteButton;

	@FindBy(xpath = "//h4[text()=' Success!']")
	private WebElement successMessage;

	// Initialization
	public CourseListPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Utilization
	public String getPageHeader() {
		return pageHeader.getText();
	}

	public void clickNewButton() {
		newButton.click();
	}

	public void deleteCourse(WebdriverUtility web, String courseName) {
		web.convertPathToElement(deletePath, courseName).click();
		deleteButton.click();
	}

	public String getSuccessMessage() {
		return successMessage.getText();
	}
}
