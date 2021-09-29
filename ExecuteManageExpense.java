package executeClass;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import elementRepository.LoginPage;
import elementRepository.ManageExpensePage;

public class ExecuteManageExpense extends BaseClass{
	
	LoginPage lp;
	ManageExpensePage mep;
	SoftAssert soft = new SoftAssert();
	
  @Test
  public void verifyThePageWillGetByClickingExpenseCategoryUnderManageExpense() throws IOException {
	  lp = new LoginPage(driver);
	  lp.enterUsername(lp.readUserName(0, 1));
	  lp.enterPassword(lp.readPassword(1, 1));
	  lp.clickSignInButton();
	  mep = new ManageExpensePage(driver);
	  mep.clickOnManageExpense();
	  mep.clickOnExpenseCategory();
	  String actualPageTitle = mep.getTitleOfTheExpenceCategoryPage();
	  String expectedPageTitle = "Expense Category";
	  soft.assertEquals(actualPageTitle, expectedPageTitle,"Actual page title is not same as expected..");
	  soft.assertAll();
	  
  }
  @Test
  public void verifyTheUpdateButtonIsWorkingInTheEditOptionOfLoanAmount() throws IOException {
	  lp = new LoginPage(driver);
	  lp.enterUsername(lp.readUserName(0, 1));
	  lp.enterPassword(lp.readPassword(1, 1));
	  lp.clickSignInButton();
	  mep = new ManageExpensePage(driver);
	  mep.clickOnManageExpense();
	  mep.clickOnExpenseCategory();
	  mep.clickOnEditButtonLoanAmount();
	  mep.enterTitle("Salary Expense");
	  mep.clickOnUpdate();
	 String actual = mep.getAlertMsg();
	 System.out.println(actual);
	 String exp = "Alert!";
	 soft.assertEquals(actual, exp);
	 soft.assertAll();
	  
  }
  @Test
  public void verifyToAddNewExpenseInTheCategory() throws IOException {
	  lp = new LoginPage(driver);
	  lp.enterUsername(lp.readUserName(0, 1));
	  lp.enterPassword(lp.readPassword(1, 1));
	  lp.clickSignInButton();
	  mep = new ManageExpensePage(driver);
	  mep.clickOnManageExpense();
	  mep.clickOnExpenseCategory();
	  mep.clickOnNew();
	  mep.enterTitleOfNewExpense("Loan Expense");
	  mep.clickOnSave();
	  Boolean actual = mep.isAddedExpenseDisplayed();
	  soft.assertTrue(actual);
	  soft.assertAll();
	  
	  
  }
  @Test
  public void verifyToDeleteAnyExpenseFromTheCategory() throws IOException {
	  lp = new LoginPage(driver);
	  lp.enterUsername(lp.readUserName(0, 1));
	  lp.enterPassword(lp.readPassword(1, 1));
	  lp.clickSignInButton();
	  mep = new ManageExpensePage(driver);
	  mep.clickOnManageExpense();
	  mep.clickOnExpenseCategory();
	  mep.clickOnDelete();
	  mep.alertAccepting();
	  Boolean actual = mep.isDeleteExpenseSuccessfullyMsgDisplayed();
	  soft.assertTrue(actual);
	  soft.assertAll();
	  
  }
}
