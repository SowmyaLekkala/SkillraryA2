package genericUtilities;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import pomPages.AddNewCategoryPage;
import pomPages.AddNewCoursePage;
import pomPages.AddNewUserPage;
import pomPages.CategoryPage;
import pomPages.CourseListPage;
import pomPages.Homepage;
import pomPages.LoginPage;
import pomPages.UsersPage;

public class BaseClass {
	protected WebDriver driver;
	protected PropertiesUtilities property;
	protected JavaUtility jutil;
	protected WebdriverUtility web;
	protected ExcelUtility excel;
	protected LoginPage login;
	protected Homepage home;
	protected UsersPage users;
	protected CourseListPage courseList;
	protected CategoryPage category;
	protected AddNewUserPage addUser;
	protected AddNewCoursePage addCourse;
	protected AddNewCategoryPage addCategory;
	
	public static WebDriver sdriver;
	public static JavaUtility sjutil;
	//@BeforeSuite
	//@BeforeTest
	@BeforeClass
	public void classSetup() {
		web=new WebdriverUtility();
		jutil=new JavaUtility();
		property=new PropertiesUtilities();
		excel=new ExcelUtility();
		property.propertiesInit(IConstantPath.PROPERTIES_FILE_PATH);
		driver=web.launchBrowserAndMaximize(property.readFromProperties("browser"));
		web.waitTillElementFound(Long.parseLong(property.readFromProperties("timeout")));
		sdriver=driver;
		sjutil=jutil;
		
	}
	@BeforeMethod
	public void methodSetup() {
		login=new LoginPage(driver);
		home=new Homepage(driver);
		users=new UsersPage(driver);
	    courseList=new CourseListPage(driver);
	    category=new CategoryPage(driver);
	    addUser=new AddNewUserPage(driver);
	    addCourse=new AddNewCoursePage(driver);
	    addCategory=new AddNewCategoryPage(driver);
	    excel.excelInit(IConstantPath.EXCEL_PATH,"Sheet1");
	    web.navigateToApp(property.readFromProperties("url"));
	    Assert.assertEquals(login.getPageHeader(),"Login");
	    login.loginToApp(property.readFromProperties("username"),
	    property.readFromProperties("password"));
	    Assert.assertEquals(home.getPageHeader(),"Home");   
	}
	@AfterMethod
	public void methodTearDown() {
		excel.closeExcel();
		home.signOutOfApp();
		
	
	}
	
	@AfterClass 
	public void classTearDown(){
		
		
	}
	
	//@AfterTest
	//@AfterSuite

}
