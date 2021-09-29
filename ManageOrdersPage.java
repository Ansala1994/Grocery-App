package elementRepository;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExplicitWaitClass;
import utilities.GeneralUtilities;

public class ManageOrdersPage {
	WebDriver driver;
	GeneralUtilities gl = new GeneralUtilities();
	ExplicitWaitClass ew = new ExplicitWaitClass();

	public ManageOrdersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//a[@href='http://groceryapp.uniqassosiates.com/admin/list-order'])[1]")
	WebElement manageOrder;

	@FindBy(xpath = "//h1[@class='m-0 text-dark']")
	WebElement gettingPage;

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	WebElement searchButton;

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-warning']")
	WebElement resetButton;

	@FindBy(id = "od")
	WebElement orderId;

	@FindBy(xpath = "//button[@name='Search']")
	WebElement buttonToSearch;

	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tr//td[1]")
	WebElement displayedOrderId;

	@FindBy(xpath = "//a[contains(@href,'http://groceryapp.uniqassosiates.com/admin/Order/delete?del')]")
	WebElement deleteButtonOrderId517;

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement orderDeleteSuccessfullyText;
	
	@FindBy(xpath = "(//a[@href='http://groceryapp.uniqassosiates.com/admin/list-order?page_ad=2'])[2]")
	WebElement nextButton;
	
	@FindBy(xpath = "//a[@href='http://groceryapp.uniqassosiates.com/admin/list-order?page_ad=2']")
	WebElement secondNextPage;
	
	@FindBy(xpath = "//a[contains(text(),'Change Status')]")
	WebElement changeStatus;
	
	@FindBy(xpath = "(//select[@id='status'])[1]")
	WebElement dropDown;
	
	@FindBy(xpath = "(//button[@name='Update_st'])[1]")
	WebElement updateButton;
	
	@FindBy(xpath = "//span[text()='UnPaid']")
	WebElement statusText;
	
	@FindBy(xpath = "(//a[text()='View'])[1]")
	WebElement view;
	
	@FindBy(xpath = "(//div[@class='col text-left']//b)[1]")
	WebElement orderIdText;

	public void clickManageOrder() {
		gl.clickElement(manageOrder);
	}

	public Boolean isManageOrderHighlighted() {
		return gl.getElementAttributeValue(manageOrder, "class", "active");
	}

	public String getTitleOfTheGettingPage() {
		return gl.getElementText(gettingPage);
	}

	public Boolean isSearchbuttonDisplayed() {
		return gl.elementDisplayed(searchButton);
	}

	public Boolean isResetbuttonDisplayed() {
		return gl.elementDisplayed(resetButton);
	}

	public void clickOnSearch() {
		gl.clickElement(searchButton);
	}

	public void enterOrderIdToSearch(String id) {
		gl.enterValues(orderId, id);
	}

	public void clickToSearch() {
		gl.clickElement(buttonToSearch);
	}

	public String checkGettedOrderIdBySearch() {
		return gl.getElementText(displayedOrderId);
	}

	public void clickOnReset() {
		gl.clickElement(resetButton);
	}

	public void scrollDown() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)");
	}

	public void addExplicitWait() {
		ew.elementToBeClicked(driver, deleteButtonOrderId517);
	}

	public void clickDeleteOnOrderId516() {
		gl.clickElement(deleteButtonOrderId517);
	}

	public void clickOkonAlert() {
		gl.alertAccept(driver);
	}

	public String getOrderDeletedSuccessfullyText() {
		return gl.getElementText(orderDeleteSuccessfullyText);
	}

	public Boolean orderDeletedSuccessfullyTextIsDisplayed() {
		return gl.elementDisplayed(orderDeleteSuccessfullyText);
	}
	public void scrollToFindNext() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,5000)");
	}
	public void clickOnNextButton() {
		gl.clickElement(nextButton);
		
	}
	public String getTextOfNextButton() {
		return gl.getElementText(secondNextPage);
	}
	public void addExplicitWaitForNextButton() {
		ew.presenceOfElementLocated(driver, nextButton);
	}
	public void clickChangeStatus() {
		gl.clickElement(changeStatus);
	}
	public void clickOnDropDown() {
		gl.clickElement(dropDown);
	}
	public void selectTextFromDropDown(String text) {
		gl.dropDownSelectByText(dropDown, text);
	}
	public void clickUpdate() {
		gl.clickElement(updateButton);
	}
	public String getStatusText() {
		return gl.getElementText(statusText);
	}
	public void navigateBackToListOrder() {
		gl.navigateBack(driver);
	}
	public void clickOnView() {
		gl.clickElement(view);
	}
	
	public String getOrderIdText() {
		return gl.getElementText(orderIdText);
	}

}
