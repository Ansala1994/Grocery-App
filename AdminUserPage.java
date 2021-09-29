package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExplicitWaitClass;
import utilities.GeneralUtilities;

public class AdminUserPage {
	
	WebDriver driver;
	GeneralUtilities gl = new GeneralUtilities();
	ExplicitWaitClass ewait = new ExplicitWaitClass();
	
	public AdminUserPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "(//a[@href='http://groceryapp.uniqassosiates.com/admin/list-admin'])[1]")
	WebElement adminUser;
	
	@FindBy(xpath = "//h1")
	WebElement pagetitle;
	
	@FindBy(xpath = "(//a[@href='javascript:void(0)'])[1]")
	WebElement newBtn;
	
	@FindBy(id = "username")
	WebElement username;
	
	@FindBy(id = "password")
	WebElement pass;
	
	@FindBy(xpath = "//div[@class='form-group']//select[@class='form-control']")
	WebElement userTypeDropDown;
	
	@FindBy(xpath = "(//button[@class='btn btn-block-sm btn-danger'])[2]")
	WebElement save;
	
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']//h5")
	WebElement msgAfterSave;
	
	public void addimplicitWait() {
		gl.addImplicitWait(driver);
	}
	
	public void elementToBeClick() {
		ewait.elementToBeClicked(driver, userTypeDropDown);
	}
	
	public String getMsgAfterSave() {
		return gl.getElementText(msgAfterSave);
	}
	
	public void clickOnSave() {
		gl.clickElement(save);
	}
	public void enterAdminUserName(String name) {
		gl.enterValues(username, name);
	}
	public void enterAdminPassword(String passwd) {
		gl.enterValues(pass, passwd);
	}
	public void userTypeDropDownSelection(String text) {
		gl.dropDownSelectByText(userTypeDropDown, text );
	}
	
	public void clickOnNew() {
		gl.clickElement(newBtn);
	}
	
	public String getPageTitleOfAdminUser() {
		return gl.getElementText(pagetitle);
	}
	
	public void clickAdminUser() {
		gl.scrollDown(driver);
		gl.clickElement(adminUser);
	}
	

}
