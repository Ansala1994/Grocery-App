package executeClass;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import elementRepository.AdminUserPage;
import elementRepository.LoginPage;

public class ExecuteAdminUser extends BaseClass {
	
	LoginPage lp;
	AdminUserPage ap;
	SoftAssert soft = new SoftAssert();
	
  @Test
  public void verifyToGetThePageByClickOnAdminUser() throws IOException {
	  lp = new LoginPage(driver);
	  lp.enterUsername(lp.readUserName(0, 1));
	  lp.enterPassword(lp.readPassword(1, 1));
	  lp.clickSignInButton();
	  ap = new AdminUserPage(driver);
	  ap.clickAdminUser();
	  String actual = ap.getPageTitleOfAdminUser();
	  String exp = "Admin Users";
	  soft.assertEquals(actual, exp);
	  soft.assertAll();
  }
  @Test
  public void verifyToAddANewAdminUser() throws IOException, InterruptedException {
	  lp = new LoginPage(driver);
	  lp.enterUsername(lp.readUserName(0, 1));
	  lp.enterPassword(lp.readPassword(1, 1));
	  lp.clickSignInButton();
	  ap = new AdminUserPage(driver);
	  ap.clickAdminUser();
	  ap.clickOnNew();
	  ap.enterAdminUserName("anu");
	  ap.enterAdminPassword("anu");
	  ap.elementToBeClick();
	  ap.userTypeDropDownSelection("Partner");
	  ap.clickOnSave();
	  String actual = ap.getMsgAfterSave();
	  String exp = "Alert!";
	  soft.assertEquals(actual, exp);
	  soft.assertAll();
  }
}
