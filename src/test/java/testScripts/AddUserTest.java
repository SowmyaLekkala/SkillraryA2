package testScripts;

import java.util.Map;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericUtilities.BaseClass;

public class AddUserTest extends BaseClass{
	
	@Test
	public void addUserTest() throws InterruptedException {
		SoftAssert soft =new SoftAssert();
		home.clickUsersTab();
		soft.assertTrue(users.getPageHeader().contains("Users"));
		users.clickNewButton();
		Thread.sleep(2000);
		soft.assertEquals(addUser.getPageHeader(), "Add New User");
		
		Map<String,String>map=excel.readFromExcel("Add User");//this is comparing the string key value as Add User from excel
		addUser.setEmail(map.get("Email"));
		addUser.setPassword(map.get("Password"));
		addUser.setFirstname(map.get("Firstname"));
		addUser.setLastname(map.get("Lastname"));
		addUser.setAddresss(map.get("Address"));
		addUser.setContactInfo(map.get("Contact Info"));
		addUser.uploadPhoto(map.get("Photo"));
		addUser.clickSave();
		
		soft.assertEquals(users.getSuccessMessage(),"Success!");
		soft.assertAll();
	}

}
