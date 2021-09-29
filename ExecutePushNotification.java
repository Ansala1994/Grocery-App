package executeClass;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import elementRepository.LoginPage;
import elementRepository.PushNotificationPage;

public class ExecutePushNotification extends BaseClass{
	
	LoginPage lp;
	PushNotificationPage pn;
	SoftAssert soft = new SoftAssert();
	
  @Test
  public void verifyToGetPushNotificationPageByClickingPushNotification() throws IOException {
	  lp = new LoginPage(driver);
	  lp.enterUsername(lp.readUserName(0, 1));
	  lp.enterPassword(lp.readPassword(1, 1));
	  lp.clickSignInButton();
	  pn = new PushNotificationPage(driver);
	  pn.clickOnPushNotification();
	  String actual = pn.getPageTitle();
	  String exp = "Push Notifications";
	  soft.assertEquals(actual, exp);
	  soft.assertAll();
  }
  @Test
  public void verifyToSendPushNotification() throws IOException {
	  lp = new LoginPage(driver);
	  lp.enterUsername(lp.readUserName(0, 1));
	  lp.enterPassword(lp.readPassword(1, 1));
	  lp.clickSignInButton();
	  pn = new PushNotificationPage(driver);
	  pn.clickOnPushNotification();
	  pn.enterTitle("Order delivery");
	  pn.enterDescription("Your order will deliver today");
	  pn.clickOnSend();
	  Boolean actual = pn.isSendSuccessfulMsgDisplayed();
	  soft.assertTrue(actual);
	  soft.assertAll();
  }
}
