package executeClass;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import elementRepository.LoginPage;
import elementRepository.ManageOrdersPage;

public class ExecuteManageOrders extends BaseClass {
	LoginPage lp;
	ManageOrdersPage mop;
	SoftAssert soft = new SoftAssert();

	@Test
	public void verifyManageOrdersHighlighted() {
		lp = new LoginPage(driver);
		lp.enterUsername("admin");
		lp.enterPassword("admin");
		lp.clickSignInButton();
		mop = new ManageOrdersPage(driver);
		mop.clickManageOrder();
		soft.assertTrue(mop.isManageOrderHighlighted(), "Not highlighted..");
		soft.assertAll();
	}

	@Test
	public void verifyTheGettingPageByClickingManageOrders() {
		lp = new LoginPage(driver);
		lp.enterUsername("admin");
		lp.enterPassword("admin");
		lp.clickSignInButton();
		mop = new ManageOrdersPage(driver);
		mop.clickManageOrder();
		String actualPageTitle = mop.getTitleOfTheGettingPage();
		String expectedPageTitle = "List Orders";
		soft.assertEquals(actualPageTitle, expectedPageTitle, "Actual page title is not same as expected..");
		soft.assertAll();
	}

	@Test
	public void verifySeachButtonDisplayed() {
		lp = new LoginPage(driver);
		lp.enterUsername("admin");
		lp.enterPassword("admin");
		lp.clickSignInButton();
		mop = new ManageOrdersPage(driver);
		mop.clickManageOrder();
		soft.assertTrue(mop.isSearchbuttonDisplayed(), "Search button not displayed...");
		soft.assertAll();
	}

	@Test
	public void verifyResetButtonDisplayed() {
		lp = new LoginPage(driver);
		lp.enterUsername("admin");
		lp.enterPassword("admin");
		lp.clickSignInButton();
		mop = new ManageOrdersPage(driver);
		mop.clickManageOrder();
		soft.assertTrue(mop.isResetbuttonDisplayed(), "Reset button not displayed...");
		soft.assertAll();
	}

	@Test
	public void verifyOrderDetailsBySearchingOrderId() {
		lp = new LoginPage(driver);
		lp.enterUsername("admin");
		lp.enterPassword("admin");
		lp.clickSignInButton();
		mop = new ManageOrdersPage(driver);
		mop.clickManageOrder();
		mop.clickOnSearch();
		mop.enterOrderIdToSearch("533");
		mop.clickToSearch();
		String actualOrderIdDisplayed = mop.checkGettedOrderIdBySearch();
		String expectedOrderIdDisplayed = "533";
		soft.assertEquals(actualOrderIdDisplayed, expectedOrderIdDisplayed,
				"Actual displayed order id is not same as expected..");
		soft.assertAll();
	}

	@Test(enabled = false)
	public void verifyDeletionOfSearchedOrderDetail() {
		lp = new LoginPage(driver);
		lp.enterUsername("admin");
		lp.enterPassword("admin");
		lp.clickSignInButton();
		mop = new ManageOrdersPage(driver);
		mop.clickManageOrder();
		mop.clickOnSearch();
		mop.enterOrderIdToSearch("494");
		mop.clickToSearch();
		mop.scrollDown();
		mop.addExplicitWait();
		mop.clickDeleteOnOrderId516();
		mop.clickOkonAlert();
		String actualText = mop.getOrderDeletedSuccessfullyText();
		// System.out.println(actualText);
		Boolean actualTextDisplayed = mop.orderDeletedSuccessfullyTextIsDisplayed();
		soft.assertTrue(actualTextDisplayed, "Order deleted successfully text not displayed..");
		soft.assertAll();
	}
	@Test(enabled = false)
	public void verifyTheNavigationOfNextPageInListOrders() {
		lp = new LoginPage(driver);
		lp.enterUsername("admin");
		lp.enterPassword("admin");
		lp.clickSignInButton();
		mop = new ManageOrdersPage(driver);
		mop.clickManageOrder();
		mop.scrollToFindNext();
		mop.addExplicitWaitForNextButton();
		mop.clickOnNextButton();
		mop.scrollToFindNext();
		String actualTextOfNextButton = mop.getTextOfNextButton();
		String expectedTextOfNextButton = "2";
		soft.assertEquals(actualTextOfNextButton, expectedTextOfNextButton);
		soft.assertAll();
	}
	@Test
	public void verifyTheChangeStatus()  {
		lp = new LoginPage(driver);
		lp.enterUsername("admin");
		lp.enterPassword("admin");
		lp.clickSignInButton();
		mop = new ManageOrdersPage(driver);
		mop.clickManageOrder();
		mop.clickChangeStatus();
		mop.clickOnDropDown();
		mop.selectTextFromDropDown("UnPaid");
		mop.clickUpdate();
		mop.navigateBackToListOrder();
		String actualText = mop.getStatusText();
		String expectedText = "UNPAID";
		soft.assertEquals(actualText, expectedText,"Actual status text not same as expected..");
		soft.assertAll();
		
	}	
	@Test
	public void verifyToViewTheOrderDetails()  {
		lp = new LoginPage(driver);
		lp.enterUsername("admin");
		lp.enterPassword("admin");
		lp.clickSignInButton();
		mop = new ManageOrdersPage(driver);
		mop.clickManageOrder();
		mop.clickOnView();
		String actualOrderIdText = mop.getOrderIdText();
		System.out.println(actualOrderIdText);
		String expectedOrderIdText = "Order ID";
		soft.assertEquals(actualOrderIdText, actualOrderIdText);
		soft.assertAll();
}
}