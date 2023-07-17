/**
 * 
 */
package PageObjects;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



/**
 * @author kpkmt942
 *
 */
public class ProductSearchPage extends BasePage{
	
	
	public ProductSearchPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy (xpath="//button[@aria-label='Add to Wish List']")
	WebElement AddTo_WishList;
	
	@FindBy (xpath="//div[@class=\"alert alert-success alert-dismissible\"]")
	WebElement Get_Msg;
	
	@FindBy (id="wishlist-total")
	WebElement WishList;
	
	@FindBy (xpath="//div[@id=\"product-list\"]//h4")
	List<WebElement> ProductName;

	
	public String AddToWishList() 
	{
		
		act.JavascriptExe(driver, AddTo_WishList);
		String result=act.GetText(driver, Get_Msg);
		return result;
		
	}
	
	public WishListPage ClickOn_Wishlist()
	{
		//act.JavascriptExe(driver, WishList);
		return new WishListPage(driver);
		
	}
	
	public LogIn_Page ClickOn_Wishlist2()
	{
		act.JavascriptExe(driver, WishList);
		return new LogIn_Page(driver);
		
	}
	
	
	
//	public void GetAllproduct() throws InterruptedException
//	{
//		for(WebElement epname:ProductName)
//		{
//			String text=epname.getText();
//			System.out.println(text);
//			
//			if(text.equals("iPhone"))
//			{
//				//epname.click();
////				Thread.sleep(3000);
////				JavascriptExecutor js = (JavascriptExecutor) driver;
//				//js.executeScript("arguments[0].click();", epname);
//				act.JavascriptExe(driver, epname);
//			}
//			
//		}
//	}
}
 	