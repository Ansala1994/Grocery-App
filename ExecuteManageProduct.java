package executeClass;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import elementRepository.LoginPage;
import elementRepository.ManageProductPage;

public class ExecuteManageProduct extends BaseClass {
	LoginPage lp;
	ManageProductPage mp;
	SoftAssert soft = new SoftAssert();

	@Test
	public void verifyToAddaNewProduct() throws IOException, InterruptedException, AWTException {
		lp = new LoginPage(driver);
		lp.enterUsername(lp.readUserName(0, 1));
		lp.enterPassword(lp.readPassword(1, 1));
		lp.clickSignInButton();
		mp = new ManageProductPage(driver);
		mp.clickManageProduct();
		mp.clickNewButton();
		mp.enterTitle(mp.readTitleFromExcel(3, 0));
		mp.clickOthersProductType();
		mp.selectFromCategory("Personal Care");
		mp.selectFromGroup(1);
		mp.selctSubCategory("Health");
		mp.clickPriceTypeWeight();
		mp.scrolling();
		mp.addWait();
		mp.enterWeightValue("500");
		mp.selectWeightUnit("g");
		mp.enterMaximumQuantityCanOrder("2");
		mp.enterPrice("599");
		mp.enterStockAvailability("10");
		mp.enterDescriptionOfProduct(
				"It is free of any drug, hormones, and steroids and is safe to consumer as a food product. Prohance D is a nutritionally complete and balanced formula for diabetics. It provides an appropriate distribution of calories from proteins, mixed carbohydrates, fibres and fats for an optimum glycaemic response.");
		mp.clickOnStockYes();
//		 mp.clickUploadImage();
//		 mp.addAThread();
//		 mp.addAnImage();
		mp.scrolling();
		mp.addAThread();
		mp.clickOnSaveButton();
		String actualAlertMsg = mp.getAlertMsgText();
		System.out.println(actualAlertMsg);
		String expectedAlertMsg = "Alert!";
		soft.assertEquals(actualAlertMsg, expectedAlertMsg);
		soft.assertAll();

	}

	@Test
	public void verifyToSearchAProduct() throws IOException {
		lp = new LoginPage(driver);
		lp.enterUsername(lp.readUserName(0, 1));
		lp.enterPassword(lp.readPassword(1, 1));
		lp.clickSignInButton();
		mp = new ManageProductPage(driver);
		mp.clickManageProduct();
		mp.clickOnSearch();
		mp.enterproductTitleToSearch("genteel");
		mp.clickSearch();
		String actual = mp.getProductTitle();
		String expected = "Genteel Liquid Detergent";
		soft.assertEquals(actual, expected, "Actual product name displayed is not match with expected..");
		soft.assertAll();
	}

	@Test
	public void verifyToDeleteAProduct() throws IOException {
		lp = new LoginPage(driver);
		lp.enterUsername(lp.readUserName(0, 1));
		lp.enterPassword(lp.readPassword(1, 1));
		lp.clickSignInButton();
		mp = new ManageProductPage(driver);
		mp.clickManageProduct();
		mp.addExplicitWait();
		mp.clickOnDelete();
		mp.acceptAlert();
		Boolean actual = mp.isAlertMsgDisplayedAfterDeletion();
		soft.assertTrue(actual, "Alert message not displayed ..");
		soft.assertAll();

	}

	@Test
	public void verifyTheResetButtonIsCickable() throws IOException {
		lp = new LoginPage(driver);
		lp.enterUsername(lp.readUserName(0, 1));
		lp.enterPassword(lp.readPassword(1, 1));
		lp.clickSignInButton();
		mp = new ManageProductPage(driver);
		mp.clickManageProduct();
		Boolean actual = mp.isResetEnabled();
		System.out.println(actual);
		soft.assertTrue(actual, "Reset button is not clickable..");
		soft.assertAll();
		
	}
}
