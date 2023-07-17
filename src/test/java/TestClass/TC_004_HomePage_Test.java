/**
 * 
 */
package TestClass;



import org.testng.annotations.Test;
import PageObjects.HomePage;
import PageObjects.IndexPage;
import PageObjects.LogIn_Page;
import PageObjects.ProductSearchPage;
import TestBase.BaseClass;

/**
 * @author kpkmt942
 *
 */
public class TC_004_HomePage_Test extends BaseClass{
	
	IndexPage ip;
	LogIn_Page lp;
	HomePage hp;
	ProductSearchPage ProductSearchPage;
	
	
	@Test(groups="Smoke")
	public void HomePage_Test() throws Throwable 
	{
		
//		TC_002_LogInPage_Test lip=new TC_002_LogInPage_Test();
//		lip.LogInPage()
		
		new IndexPage(driver);
		ip=new IndexPage(driver);
		ip.Click_MyAccount();
		
		lp=ip.ClickOn_LogIn();
		hp=lp.LogIntoApplication(rb.getString("Email"),rb.getString("Password"), null);
		
	}
		
	@Test
		public void Verify_DisplayMsg()
		{
		hp.GetDiplayedText();
		ProductSearchPage=hp.SearchProduct(rb.getString("product1"));
		
		}

		
//		hp.GetDiplayedText();
//		hp.Clickon_LogOut();
//		hp.SearchProduct(rb.getString("product1"));
//		
		//hp.ClickonProductType();
		
		
		
	}


