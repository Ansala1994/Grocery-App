package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.google.errorprone.annotations.FormatMethod;

import utilities.ExplicitWaitClass;
import utilities.GeneralUtilities;

public class VerifyUserPage {
	
	WebDriver driver;
	LoginPage lp;
	GeneralUtilities gl = new GeneralUtilities();
	ExplicitWaitClass ewait = new ExplicitWaitClass();
	
	public VerifyUserPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "(//a[@href='http://groceryapp.uniqassosiates.com/admin/verify-users'])[1]")
	WebElement verifyUser;
	
	@FindBy(xpath = "//h1[@class='m-0 text-dark']")
	WebElement pageTitle;
	
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	WebElement searchButton;
	
	@FindBy(xpath = "//input[@id='un']")
	WebElement nameOfUser;
	
	@FindBy(xpath = "//button[@name='Search']")
	WebElement searchToSearch;
	
	@FindBy(xpath = "//table//tbody//tr[1]//td[1]")
	WebElement nameDisplayed;
	
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-warning']")
	WebElement reset;
	
	@FindBy(xpath = "(//h4[@class='card-title'])[2]")
	WebElement getTextOfListUser15;
	
	@FindBy(xpath = "//a[@href='http://groceryapp.uniqassosiates.com/admin/Users/Unverify_delete?del=147&page_ad=1']")
	WebElement delete;
	
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']//h5")
	WebElement msgAfterDelete;
	
	public Boolean isDeletedSuccessfullyMsgDisplayed() {
		return gl.elementDisplayed(msgAfterDelete);
	}
	
	public void clickOnDelete() {
		gl.clickElement(delete);
	}
	public void alertHandling() {
		ewait.alertIsPresent(driver, delete);
		gl.alertAccept(driver);
	}
	
	public Boolean isListUser15TextFound() {
		return gl.elementDisplayed(getTextOfListUser15);
	}
	
	public Boolean isResetButtonEnabled() {
		return gl.buttonIsEnabled(reset);
	}
	public void clickOnReset() {
		gl.clickElement(reset);
	}
	
	public boolean isNameDisplayed() {
		return gl.elementDisplayed(nameDisplayed);
	}
	
	public void clickSearch() {
		gl.clickElement(searchToSearch);
	}
	
	public void enterTheNameOfUser(String name) {
		gl.enterValues(nameOfUser, name);
	}
	public void clickOnSearch() {
		gl.clickElement(searchButton);
	}
	public String getPageTitle() {
		return gl.getElementText(pageTitle);
	}
	
	public void clickOnVerifyUser() {
		gl.clickElement(verifyUser);
	}

}
