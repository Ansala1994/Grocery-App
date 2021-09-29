package executeClass;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import elementRepository.LoginPage;

public class ExecuteLogin extends BaseClass {
	LoginPage lp;
	SoftAssert soft = new SoftAssert();

	@Test
	public void testCase1VerifyLogin() throws IOException {
		lp = new LoginPage(driver);
		lp.enterUsername(lp.readUserName(0, 1));
		lp.enterPassword(lp.readPassword(1, 1));
		lp.clickSignInButton();
		String actualUserName = lp.getuserNameText();
		String expectedUserName = "Admin";
		soft.assertEquals(actualUserName, expectedUserName);
		soft.assertAll();
		
	}

	@Test
	public void verifySignInButtonText() {
		lp = new LoginPage(driver);
		
		String actualText = lp.getSignInButtonText();
		String expectedText = "Sign In";
		soft.assertEquals(actualText, expectedText, "Text not expected..");
		soft.assertAll();
	}

	@Test
	public void verifyFontSizeOfSignIn() {
		lp = new LoginPage(driver);
		String actualFontSize = lp.getSignInFontSize();
		String expectedFontSize = "16px";
		soft.assertEquals(actualFontSize, expectedFontSize, "Font size not expected..");
		soft.assertAll();
	}
	@Test
	public void verifyRememberCheckBoxIsSelectedAfterSuccessfulLoginAndLogOut() throws IOException {
		lp = new LoginPage(driver);
		lp.enterUsername(lp.readUserName(0, 1));
		lp.enterPassword(lp.readPassword(1, 0));
		lp.clickRememberCheckBox();
		lp.clickSignInButton();
		lp.clickOnTheNameOfUser();
		lp.clickLogOut();
		Boolean actualResult = lp.isRememberCheckBoxSelected();
		soft.assertTrue(actualResult,"Remember checkbox not selected..");
		soft.assertAll();
	}

}
