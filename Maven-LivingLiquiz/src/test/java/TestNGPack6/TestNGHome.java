package TestNGPack6;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import BrowserSetup.Base;
import POMClass.HomePage;
import Utils.Utility;



public class TestNGHome extends Base {
	
	WebDriver driver;
	HomePage homepage;
	SoftAssert soft;
	String TESTID;
	
	@Parameters("browser")
	
	@BeforeTest
	public void OpenBrowser(String BrowserName) {
//		System.out.println("Before Test-1");
//		if(BrowserName.equals("Chrome"))
//		{
//			System.setProperty("webdriver.chrome.driver", "D:\\Selenium New file\\chromedriver_win32 (3)\\chromedriver.exe");
//	
//			driver = new ChromeDriver();
//		}
		
		if(BrowserName.equals("Firefox"))
	    {
			System.setProperty("webdriver.gecko.driver", "D:\\Selenium New file\\geckodriver-v0.32.2-win32\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		if(BrowserName.equals("Edge"))
	    {
			System.setProperty("webdriver.edge.driver", "D:\\Selenium New file\\edgedriver_win64\\msedgedriver.exe");
			driver = new EdgeDriver();
		}
		
	    driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
	}
	
	@BeforeClass
	public void createPOMObject() {
		System.out.println("Before Class-1");
		homepage=new HomePage(driver);
		
	}
	

	
	@BeforeMethod
	public void beforeMethod() throws InterruptedException {
		System.out.println("Before Method-1");
		driver.get("https://livingliquidz.com/");
			Thread.sleep(20000);
		soft=new SoftAssert();
		
	}
	@Test(priority=1)
	public void VerifyHomePageTEXT() {
		
		
		String actualText=homepage.checkTexthomepage();
		String expectedText="WE NEVER ASK FOR ADVANCE PAYMENT. MAKE PAYMENT ONLY AFTER DELIVERY VIA CASH/CARD. FOR QUERY CALL @ 7700000770";
		
	
		soft.assertEquals(actualText, expectedText,"Text Is Wrong");
		
		soft.assertAll();
	}
	
	
	@Test(priority=2)
	public void VerifytheTextOfSpiritsPage() {
		System.out.println("Test-1");
		homepage.clickonSpirits();
		
		String actualText=homepage.checkTextonSpritsPage();
		String expectedText="SINGLE MALTS";
		
	
		soft.assertEquals(actualText, expectedText,"Text Is Wrong");
		
		soft.assertAll();
	
	}	
	@Test(priority=3)
	public void VerifyUserIsAbleClickOnVodkaFlavouredTab() throws InterruptedException {
		System.out.println("Test-1");
		
         homepage.clickonSpirits();
         homepage.clickonVodkaFlavour();
		
		String actualURL=driver.getCurrentUrl();
		String expectedURL="https://livingliquidz.com/products/vodka/flavoured/356";
		
		String actualTitle=driver.getTitle();
		String expectedTitle="FLAVOURED";
		
		
		soft.assertEquals(actualURL, expectedURL,"URL Is Wrong");
		soft.assertEquals(actualTitle, expectedTitle,"Title Is Wrong");
		
		soft.assertAll();
				
	}
	@Test(priority=4)
	public void VerifyUserIsNotAbleWithoutLoginGoOnPaymentPage() throws InterruptedException {
		System.out.println("Test-1");
		
		homepage.clickonSpirits();
		homepage.clickonVodkaFlavour();
        homepage.clickonMagicMovementVanillaAddToCARD();
        Thread.sleep(3000);
        homepage.clickonAddToCardBucket();
        Thread.sleep(3000);
		
		String actualURL=driver.getCurrentUrl();
		String expectedURL="https://livingliquidz.com/Account/Login?ReturnUrl=%2FCart";
		
		String actualTitle=driver.getTitle();
		String expectedTitle="Log in";
		
		
		soft.assertEquals(actualURL, expectedURL,"URL Is Wrong");
		soft.assertEquals(actualTitle, expectedTitle,"Title Is Wrong");
		
		soft.assertAll();
				
	}
	
	
	
	
//		
//
//		
//
//		 JavascriptExecutor js=(JavascriptExecutor)driver;
//			js.executeScript("window.scrollBy(0,300)");
//		
//		Thread.sleep(2000);
//		
//		
//		homepage.ClickonAllWineTab();
//		
//		String ActualURL=driver.getCurrentUrl();
//		String ExpectedURL="https://www.thewinepark.com/Category/All-Wines?pageno=1&PageView=grid";
//		soft.assertEquals(ActualURL, ExpectedURL,"URL Is Wrong");
//		
//		soft.assertAll();
//	
//	}	
//	
//	@Test(priority=3)
//	public void VerifyCheninBlancTab() throws InterruptedException {
//		System.out.println("Test-3");
//		
//
//		
//
//		 JavascriptExecutor js=(JavascriptExecutor)driver;
//			js.executeScript("window.scrollBy(0,300)");
//		
//		Thread.sleep(2000);
//		
//		
//		homepage.ClickonAllWineTab();
//		Thread.sleep(6000);
//		
//	
//		
//		
//	//	homepage.ClickonCheninBlanc();
//		
//		String ActualURL=driver.getCurrentUrl();
//		String ExpectedURL="https://www.thewinepark.com/category/chenin-blanc?pageno=1&PageView=grid";
//		soft.assertEquals(ActualURL, ExpectedURL,"URL Is Wrong");
//		
//		soft.assertAll();
//	
//	}	
	
	
	
	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException, InterruptedException {
		if(ITestResult.FAILURE==result.getStatus())
		{
			Utility.captureScreenshot(driver, TESTID);
		}
		System.out.println("After Method-1");
	}
	
	@AfterClass
	public void clearObject() {
		System.out.println("After class-1");
		homepage=null;
	}
		
	
	@AfterTest
	public void afterTest() {
		System.out.println("After Test-1");
		driver.quit();
		driver=null;
		System.gc();
	}
	

}
