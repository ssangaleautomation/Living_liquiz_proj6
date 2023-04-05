package TestNGPack6;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
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

import POMClass.HomePage;
import POMClass.SearchOrFilter;
import Utils.Utility;

public class TestNGSearch {
	
	
	WebDriver driver;
	SearchOrFilter filter;
	SoftAssert soft;
	String TESTID;
	
	@Parameters("browser")
	
	@BeforeTest
	public void OpenBrowser(String BrowserName) {

		
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
		System.out.println("Before Class-2");
		filter=new SearchOrFilter(driver);
		
	}
	

	
	@BeforeMethod
	public void beforeMethod() throws InterruptedException {
		System.out.println("Before Method-2");
		driver.get("https://livingliquidz.com/");
			Thread.sleep(20000);
		soft=new SoftAssert();
		
	}
	@Test(priority=1)
	public void VerifyUserIsPassWhiskeyThenAllText() {
		filter.sendOnSearch();
		
		
		List<WebElement> AllTEXT=filter.VerifyAllTextOnSearch();
		System.out.println(AllTEXT);
		String actualURL=driver.getCurrentUrl();
		String expectedURL="https://livingliquidz.com/product/jimmys-whiskey-sour/1076";
		
	
		soft.assertEquals(actualURL, expectedURL,"URL Is Wrong");
		
		soft.assertAll();
	}
	
	
	
	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException, InterruptedException {
		if(ITestResult.FAILURE==result.getStatus())
		{
			Utility.captureScreenshot(driver, TESTID);
		}
		System.out.println("After Method-2");
	}
	
	@AfterClass
	public void clearObject() {
		System.out.println("After class-2");
		filter=null;
	}
		
	
	@AfterTest
	public void afterTest() {
		System.out.println("After Test-2");
		driver.quit();
		driver=null;
		System.gc();
	}
	

}


