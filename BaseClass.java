package executeClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import utilities.ScreenshotClass;
public class BaseClass {
	WebDriver driver;
	ScreenshotClass sh;
	public static Properties property;
	
	public static void readProperty() throws IOException {
		property = new Properties();
		FileInputStream fs = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\Config.properties");
		property.load(fs);
	}
	
	@BeforeMethod()
	@Parameters("browser")
	
	public void beforeMethod(String browserValue) throws IOException {
		readProperty();
		if(browserValue.equalsIgnoreCase("chrome")) {
			System.setProperty(property.getProperty("ChromeSystemProperty"),System.getProperty("user.dir")+property.getProperty("ChromeDriverPath"));
			driver = new ChromeDriver();
		}
		else if(browserValue.equalsIgnoreCase("firefox")) {
			System.setProperty(property.getProperty("FirefoxSystemProperty"),System.getProperty("user.dir")+property.getProperty("FirefoxDriverPath"));
			driver = new FirefoxDriver();
		}
		driver.get(property.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@AfterMethod()
	public void afterMethod(ITestResult itestResult) throws IOException {
		if (itestResult.getStatus() == ITestResult.FAILURE) {
			sh = new ScreenshotClass();
			sh.takeScreenshot(driver, itestResult.getName());
		}
		driver.close();
	}
}
