package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddNewCategoryPage {
	//Declaration
		@FindBy(xpath="//b[text()='Add New Category']")
		private WebElement pageHeader;
		
		@FindBy(id="name")
		private WebElement nameTF;
		
		@FindBy(xpath="//button[@name='add']")//button[text()=' Save'])[2]
		private WebElement saveButton;
		
		//Initialization
		 public AddNewCategoryPage(WebDriver driver) {
		    	PageFactory.initElements( driver,this);
		    	
		 }
		//utilization
		 public String getPageHeader() {
		 return pageHeader.getText();
		 }
		
		 public void setName(String courseName) {
		    	nameTF.sendKeys(courseName);
		 }
		 public void clickSave() {
		    	saveButton.click();
		 }
		    
		

}
