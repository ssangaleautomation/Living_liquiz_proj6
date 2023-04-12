package POMClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

///CHANGE..

//CHANGE MASTER BRANCH
//Eclipse change
	

	@FindBy (xpath="//div[contains(@class,'fs-12 text-uppercase text-alpha fw-500')]")
	private WebElement HomePageText; 
//	
//	
	@FindBy (xpath="(//a[contains(@role,'button')])[5]")
	private WebElement SPIRITS;
//	
//
	@FindBy (xpath="(//p[contains(@class,'fs-20 fw-500 text-alpha h3')])[3]")
	private WebElement SPIRISText;
	
	@FindBy (xpath="(//a[contains(text(),'Flavoured')])[4]")
	private WebElement VodkaFlavour;
	
	@FindBy (xpath="(//button[contains(text(),'ADD TO CART')])[2]")
	private WebElement MagicMovementVanillaAddToCARD;
	
	@FindBy (xpath="//a[@class='d-inline-block fs-28 text-bravo btn-cart wbr-cmp-view-cart-button']")
	private WebElement AddToCardBucket;
	
	
	
	
	
public static WebDriver driver1;
	
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver1=driver;   
	
	}
	
	
	
	public String checkTexthomepage() {
		String text=HomePageText.getText();
		return text;
				
	}
	
	public void clickonSpirits() {
		SPIRITS.click();
		
		
	}	
	public String checkTextonSpritsPage() {
		String text=SPIRISText.getText();
		return text;			
	}
	public void clickonVodkaFlavour() {
		VodkaFlavour.click();
			
	}
	public void clickonMagicMovementVanillaAddToCARD() {
		MagicMovementVanillaAddToCARD.click();
			
	}	
	
	public void clickonAddToCardBucket() {
		AddToCardBucket.click();
			
	}	
	
	
	
	
	
	
	
	
}
