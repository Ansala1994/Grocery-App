package elementRepository;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExcelReadClass;
import utilities.GeneralUtilities;

public class LoginPage {
	
	WebDriver driver;
	GeneralUtilities gl = new GeneralUtilities();
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "username")
	WebElement username;

	@FindBy(name = "password")
	WebElement password;
	
	@FindBy(xpath = "//label[@for='remember']")
	WebElement rememberCheckBox;

	@FindBy(xpath = "//button[text()='Sign In']")
	WebElement signInButton;

	@FindBy(xpath = "//li[@class='nav-item dropdown']//a[@class='nav-link']")
	WebElement nameOfUser;
	
	@FindBy(xpath = "(//a[@href='http://groceryapp.uniqassosiates.com/admin/logout'])[1]")
	WebElement logOut;

	public void enterUsername(String name) {
		gl.enterValues(username, name);
	}

	public void enterPassword(String pass) {
		gl.enterValues(password, pass);
	}

	public void clickSignInButton() {
		gl.clickElement(signInButton);
	}

	public String getuserNameText() {
		return gl.getElementText(nameOfUser);
	}

	public String getSignInButtonText() {
		return gl.getElementText(signInButton);
	}

	public String getSignInFontSize() {
		return gl.getElementFontSize(signInButton);
	}
	public Boolean isRememberCheckBoxSelected() {
		return gl.ElementIsSelected(rememberCheckBox);
	}
	public void clickRememberCheckBox() {
		gl.clickElement(rememberCheckBox);
	}
	public void clickOnTheNameOfUser() {
		gl.clickElement(nameOfUser);
	}
	public void clickLogOut() {
		gl.clickElement(logOut);
	}
	public String readUserName(int r,int c) throws IOException {
		return ExcelReadClass.readStringData(r,c);
		
	}
	public String readPassword(int r,int c) throws IOException {
		return ExcelReadClass.readStringData(r, c);
	}
	
}
