package executeClass;

import java.io.IOException;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import elementRepository.LoginPage;
import elementRepository.VerifyUserPage;

public class ExecuteVerifyUser extends BaseClass{
	
	LoginPage lp;
	VerifyUserPage vu;
	SoftAssert soft = new SoftAssert();
	
  @Test
  public void verifyToGetListUserPageByClickingVerifyUser() throws IOException {
	  lp = new LoginPage(driver);
	  lp.enterUsername(lp.readUserName(0, 1));
	  lp.enterPassword(lp.readPassword(1, 1));
	  lp.clickSignInButton();
	  vu= new VerifyUserPage(driver);
	  vu.clickOnVerifyUser();
	  String actualPageTitle = vu.getPageTitle();
	  String exp = "List Users";
	  soft.assertEquals(actualPageTitle, exp);
	  soft.assertAll();
	    
  }
  
  @Test
  public void verifyToSearchUserByTypingName() throws IOException {
	  lp = new LoginPage(driver);
	  lp.enterUsername(lp.readUserName(0, 1));
	  lp.enterPassword(lp.readPassword(1, 1));
	  lp.clickSignInButton();
	  vu= new VerifyUserPage(driver);
	  vu.clickOnVerifyUser();
	  vu.clickOnSearch();
	  vu.enterTheNameOfUser("Anoop");
	  vu.clickSearch();
	  Boolean actualName = vu.isNameDisplayed();
	  soft.assertTrue(actualName);
	  soft.assertAll();
	  
  }
  @Test
  public void verifyTheResetButtonIsWorkingAfterSearchAnUser() throws IOException {
	  lp = new LoginPage(driver);
	  lp.enterUsername(lp.readUserName(0, 1));
	  lp.enterPassword(lp.readPassword(1, 1));
	  lp.clickSignInButton();
	  vu= new VerifyUserPage(driver);
	  vu.clickOnVerifyUser();
	  vu.clickOnSearch();
	  vu.enterTheNameOfUser("Anoop");
	  vu.clickSearch();
	  vu.clickOnReset();
	  Boolean actual = vu.isListUser15TextFound();
	  soft.assertTrue(actual);
	  soft.assertAll();
	  
  }
  @Test
  public void verifyTheResetButtonIsEnabled() throws IOException {
	  lp = new LoginPage(driver);
	  lp.enterUsername(lp.readUserName(0, 1));
	  lp.enterPassword(lp.readPassword(1, 1));
	  lp.clickSignInButton();
	  vu= new VerifyUserPage(driver);
	  vu.clickOnVerifyUser();
	  Boolean actual = vu.isResetButtonEnabled();
	  soft.assertTrue(actual);
	  soft.assertAll();
  }
  @Test
  public void verifyTheDeleteFunction() throws IOException {
	  lp = new LoginPage(driver);
	  lp.enterUsername(lp.readUserName(0, 1));
	  lp.enterPassword(lp.readPassword(1, 1));
	  lp.clickSignInButton();
	  vu= new VerifyUserPage(driver);
	  vu.clickOnVerifyUser();
	  vu.clickOnDelete();
	  vu.alertHandling();
	  Boolean actual= vu.isDeletedSuccessfullyMsgDisplayed();
	  soft.assertTrue(actual);
	  soft.assertAll();
}
  }
