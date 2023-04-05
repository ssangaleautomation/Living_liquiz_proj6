package POMClass;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchOrFilter {
	
	
	@FindBy (xpath="//input[@class='wbr-main-search']")
	private WebElement search;
	
	@FindBy (xpath="//div[@class='typeahead__result']//ul//descendant ::li[@class='typeahead__item typeahead__group-products']")
	private List<WebElement> SearchList;
	
	
	
	
public static WebDriver driver1;
	
	
	public SearchOrFilter(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver1=driver;   
	
	}
	
	
	public void sendOnSearch() {
		search.sendKeys("whiskey");
				
	}	
	
	public List<WebElement> VerifyAllTextOnSearch() {
		
		
		for(int i=0;i<SearchList.size();i++)
		{
			String listitem=SearchList.get(i).getText();
			System.out.println(listitem);
			if(listitem.contains("JIMMYS WHISKEY SOUR"))
			{
				SearchList.get(i).click();
			}
		}
		
	
				
		return SearchList;	
	
	

	}
}
