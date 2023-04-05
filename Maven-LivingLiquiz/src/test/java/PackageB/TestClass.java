package PackageB;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import POMClass.HomePage;
import POMClass.SearchOrFilter;

public class TestClass {
	
	public static void main(String[] args) throws InterruptedException {
		
		
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium New file\\chromedriver_win32 (3)\\chromedriver.exe");
		
		ChromeOptions ops=new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		
			WebDriver driver = new ChromeDriver(ops);
		
//		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(20000));
		driver.manage().window().maximize();
//		driver.get("https://www.thewinepark.com/");
		
		driver.get("https://omayo.blogspot.com/");
		
	HomePage homepage=new HomePage(driver);
homepage.checkTexthomepage();
homepage.clickonSpirits();
homepage.checkTextonSpritsPage();
homepage.clickonVodkaFlavour();
homepage.clickonMagicMovementVanillaAddToCARD();
homepage.clickonAddToCardBucket();



SearchOrFilter filter=new SearchOrFilter(driver);
filter.sendOnSearch();
filter.VerifyAllTextOnSearch();

}
}