/**
 * 
 */
package PageObjects;




import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;




/**
 * @author kpkmt942
 *
 */
public class HomePage extends BasePage{
	
	 
	public HomePage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(xpath = "//input[@placeholder='Search']")
	WebElement Searchbox;
	
	@FindBy(xpath = "//div[@id=\"content\"]//h2")
	List<WebElement> dislayedText;
	
	@FindBy(xpath = "//a[@class='nav-link'][normalize-space()='Phones & PDAs']")
	WebElement productType;
	
	@FindBy (xpath="//h2[normalize-space()='My Account']")
    WebElement MyAccount;
	
	@FindBy(xpath = "(//a[text()=\"Logout\"])[2]")
	WebElement LogOut;
	

	
	
	 public ProductSearchPage SearchProduct(String productName) 
	   
	 {
		 try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		 Searchbox.sendKeys(productName,Keys.ENTER);
		 return new ProductSearchPage(driver);
		 
	    }
	 
	 
	 public void GetDiplayedText() 
	 
	    {
		
		 try 
		 {
			Thread.sleep(3000);
			
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		} 
		 
		 for(WebElement data:dislayedText)
		 System.out.println(data.getText());
	    }
	 
	 
	
	 public boolean VerifyLogin()
		{
		 
		 boolean text=act.Isdisplayed(driver, MyAccount);
			return text;
		}
	 
	 
	 public void Clickon_LogOut() {
	
			//act.Click(driver, LogOut);
		 act.JavascriptExe(driver, LogOut);
		}
	 
	 
	 
//	 public  void ClickonProductType()
//	 {
//		
//		 act.Click(driver, productType);
//	 }


	



}
