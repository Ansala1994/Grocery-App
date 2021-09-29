package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExcelReadClass;
import utilities.ExplicitWaitClass;
import utilities.GeneralUtilities;

public class ManageExpensePage extends ExplicitWaitClass {
	WebDriver driver;
	GeneralUtilities gl = new GeneralUtilities();
	
	public ManageExpensePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "(//a[@class='nav-link'])[3]")
	WebElement manageExpense;
	
	@FindBy(xpath = "//a[@href='http://groceryapp.uniqassosiates.com/admin/expense-category']")
	WebElement expenseCategory;
	
	@FindBy(xpath = "//h1[@class='m-0 text-dark']")
	WebElement expenseCategoryPageTitle;
	
	@FindBy(xpath = "(//a[@class='btn btn-sm btn btn-primary btncss'])[2]")
	WebElement editButtonOfLoanAmount;
	
	@FindBy(xpath = "//input[@id='name']")
	WebElement titleToUpdate;
	
	@FindBy(xpath  = "//button[@name='Update']")
	WebElement updateButton;
	
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']//h5")
	WebElement updateSuccessAlertMsg;
	
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement newButn;
	
	@FindBy(xpath = "//input[@id='name']")
	WebElement titleOfNewAddingExpense;
	
	@FindBy(xpath = "//button[@name='Create']")
	WebElement saveButton;
	
	@FindBy(xpath = "//table//tbody//tr[1]/td[1]")
	WebElement displayedAddedExpense;
	
	@FindBy(xpath = "(//a[contains(@href,'http://groceryapp.uniqassosiates.com/admin/Expense/cat_delete?del')])[2]")
	WebElement deleteButton;
	
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']//h5")
	WebElement messageAfterAlertAccept;
	
	public Boolean isDeleteExpenseSuccessfullyMsgDisplayed() {
		return gl.elementDisplayed(messageAfterAlertAccept);
	}
	
	public void addExplicitWaitOfAlertPresent() {
		alertIsPresent(driver, deleteButton);
	}
	
	public void alertAccepting() {
		gl.alertAccept(driver);
	}
	
	public void clickOnDelete() {
		gl.clickElement(deleteButton);
	}
	
	public Boolean isAddedExpenseDisplayed() {
		return gl.elementDisplayed(displayedAddedExpense);
	}
	
	public void clickOnSave() {
		gl.clickElement(saveButton);
	}
	
	public void clickOnManageExpense() {
		gl.clickElement(manageExpense);
	}
	public void clickOnExpenseCategory() {
		gl.clickElement(expenseCategory);
	}
	public String getTitleOfTheExpenceCategoryPage() {
		return gl.getElementText(expenseCategoryPageTitle);
	}
	public void clickOnEditButtonLoanAmount() {
		gl.clickElement(editButtonOfLoanAmount);
	}
	public void enterTitle(String tesxt) {
		titleToUpdate.clear();
		gl.enterValues(titleToUpdate, tesxt);
	}
	public void clickOnUpdate() {
		gl.clickElement(updateButton);
	}
	public String getAlertMsg() {
		return gl.getElementText(updateSuccessAlertMsg);
	}
	public void clickOnNew() {
		gl.clickElement(newButn);
	}

	public void enterTitleOfNewExpense(String name) {
		gl.enterValues(titleOfNewAddingExpense, name);
	}

}
