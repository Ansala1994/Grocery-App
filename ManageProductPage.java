package elementRepository;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExcelReadClass;
import utilities.ExplicitWaitClass;
import utilities.GeneralUtilities;

public class ManageProductPage extends ExcelReadClass {
	
	WebDriver driver;
	GeneralUtilities gl = new GeneralUtilities();
	ExplicitWaitClass ew = new ExplicitWaitClass();

	public ManageProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "(//a[@href='http://groceryapp.uniqassosiates.com/admin/list-product'])[1]")
	WebElement manageProduct;
	
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement newButton;
	
	@FindBy(xpath = "//input[@id='title']")
	WebElement title;
	
	@FindBy(xpath = "//input[@value='Others']")
	WebElement productTypeOthersRadioButn;
	
	@FindBy(id = "cat_id")
	WebElement category;
	
	@FindBy(id = "grp_id")
	WebElement group;
	
	@FindBy(xpath = "//select[@name='sub_id']")
	WebElement subCategory;
	
	@FindBy(id = "purpose")
	WebElement priceTypeWeight;
	
	
	@FindBy(id = "m_weight")
	WebElement weightValue;
	
	@FindBy(xpath = "//select[@name='w_unit']")
	WebElement  weightUnit;
	
	@FindBy(id = "max_weight")
	WebElement maximumQuantityCanOrder;
	
	@FindBy(id = "w_price")
	WebElement price;
	
	@FindBy(id = "w_stock")
	WebElement stockAvailability;
	
	@FindBy(xpath = "//div[@class='note-editable card-block']")
	WebElement description;
	
	@FindBy(xpath = "(//input[@name='stock'])[1]")
	WebElement stockYes ;
	
	@FindBy(xpath = "//div[@class=' form-group']//input[@id='main_img']")
	WebElement image;
	
	@FindBy(xpath = "//div[@class='card-footer']//button[@name='create']")
	WebElement saveButn;
	
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']//h5")
	WebElement alertmsg;
	
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	WebElement searchBtn;
	
	@FindBy(xpath = "(//input[@class='form-control'])[1]")
	WebElement titleToSearch;
	
	@FindBy(xpath = "//button[@name='Search']")
	WebElement searchButtonToSearch;
	
	@FindBy(xpath = "//table//tbody//tr[1]//td[1]")
	WebElement productTitleDisplayed;
	
	@FindBy(xpath = "//a[contains(@href,'http://groceryapp.uniqassosiates.com/admin/Product/delete?del=743')]")
	WebElement deleteAProduct;
	
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']//h5")
	WebElement alertMsgFromDelete;
	
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-warning']")
	WebElement resetButton;
	
	public Boolean isResetEnabled() {
		return gl.buttonIsEnabled(resetButton);
	}
	
	public Boolean isAlertMsgDisplayedAfterDeletion() {
		return gl.elementDisplayed(alertMsgFromDelete);
	}
	
	public void clickOnDelete() {
		gl.clickElement(deleteAProduct);
	}
	public void addExplicitWait() {
		ew.elementToBeClicked(driver, deleteAProduct);
	}
	public void acceptAlert() {
		gl.alertAccept(driver);
	}
	public String getProductTitle() {
		return gl.getElementText(productTitleDisplayed);
	}
	public void clickSearch() {
		gl.clickElement(searchButtonToSearch);
	}
	
	public void enterproductTitleToSearch(String titleText) {
		gl.enterValues(titleToSearch, titleText);
	}
	
	public void clickOnSearch() {
		gl.clickElement(searchBtn);
	}
	
	public String getAlertMsgText() {
		return gl.getElementText(alertmsg);
	}
	
	public void clickOnSaveButton() {
		gl.clickElement(saveButn);
	}
	
	public void enterPrice(String priceValue) {
		gl.enterValues(price, priceValue);
	}
	
	public void enterStockAvailability(String value) {
		gl.enterValues(stockAvailability, value);
	}
	public void enterDescriptionOfProduct(String value) {
		gl.enterValues(description, value);
	}
	public void clickOnStockYes() {
		gl.clickElement(stockYes);
		
	}
	public void clickUploadImage() {
		gl.clickElement(image);
		
	}
	public void addAnImage() throws AWTException {
		StringSelection stringSelection = new StringSelection("C:\\Users\\Ansala\\eclipse-workspace\\com.groceryAppProject\\src\\main\\resources\\prohanceD.jpg");
		   Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

		   Robot robot = new Robot();
	
         robot.keyPress(KeyEvent.VK_CONTROL);
         robot.keyPress(KeyEvent.VK_V);
         robot.keyRelease(KeyEvent.VK_V);
         robot.keyRelease(KeyEvent.VK_CONTROL);
         robot.keyPress(KeyEvent.VK_ENTER);
         robot.keyRelease(KeyEvent.VK_ENTER);

	}
	public void enterMaximumQuantityCanOrder(String value) {
		gl.enterValues(maximumQuantityCanOrder, value);
	}
	
	public void selectWeightUnit(String unit) {
		gl.dropDownSelectByText(weightUnit, unit);
	}
	
	public void enterWeightValue(String value) {
		gl.enterValues(weightValue, value);
	}
	
	public void clickManageProduct() {
		gl.clickElement(manageProduct);
	}
	public void clickNewButton() {
		gl.clickElement(newButton);
	}
	public void enterTitle(String text) {
		gl.enterValues(title,text);
	}
	public String readTitleFromExcel(int r, int c) throws IOException {
		return ExcelReadClass.readStringData(r, c);
	}
	public void clickOthersProductType() {
		gl.clickElement(productTypeOthersRadioButn);
	}
	public void selectFromCategory(String text) {
		gl.dropDownSelectByText(category,text);
	}
	public void selectFromGroup(int value) {
		gl.dropDownSelectByIndex(group,value);
	}
	public void selctSubCategory(String text) {
		gl.dropDownSelectByText(subCategory, text);
	}
	public void clickPriceTypeWeight() {
		gl.clickElement(priceTypeWeight);
	}
	public void scrolling() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1000)");
	}
	public void addWait() {
		gl.addImplicitWait(driver);
	}
	public void scrollDown() {
		gl.scrollToFindElement(driver,saveButn);
	}
	public void addAThread() throws InterruptedException {
		gl.addThreadSleep();
	}

}
