package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExplicitWaitClass;
import utilities.GeneralUtilities;

public class PushNotificationPage {
	
	WebDriver driver;
	GeneralUtilities gl =new GeneralUtilities();
	ExplicitWaitClass ewait = new ExplicitWaitClass();
	
	public PushNotificationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "(//a[@href='http://groceryapp.uniqassosiates.com/admin/list-notifications'])[1]")
	WebElement pushNotification;
	
	@FindBy(xpath = "//h1")
	WebElement pageTitle;
	
	@FindBy(id = "title")
	WebElement title;
	
	@FindBy(id = "description")
	WebElement description;
	
	@FindBy(xpath = "//button[@class='btn btn-block-sm btn-info']")
	WebElement send;
	
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement sendSuccessfulMsg;
	
	public Boolean isSendSuccessfulMsgDisplayed() {
		return gl.elementDisplayed(sendSuccessfulMsg);
	}
	
	public void clickOnSend() {
		gl.clickElement(send);
	}
	
	public void enterDescription(String desc) {
		gl.enterValues(description, desc);
	}
	
	public void enterTitle(String text) {
		gl.enterValues(title, text);
	}
	
	public String getPageTitle() {
		return gl.getElementText(pageTitle);
	}
	
	public void clickOnPushNotification() {
		gl.clickElement(pushNotification);
	}

}
