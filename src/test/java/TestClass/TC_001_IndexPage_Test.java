/**
 * 
 */
package TestClass;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;

import org.testng.annotations.Test;
import PageObjects.IndexPage;
import PageObjects.ProductSearchPage;
import TestBase.BaseClass;
import UtilityFile.JiraPolicy;


/**
 * @author kpkmt942
 *
 */
public class TC_001_IndexPage_Test extends BaseClass{
	
	
	 static IndexPage ip;
	 static ProductSearchPage ProductSearchPage;
	 

//		@BeforeClass
//		public static void setUp() throws Throwable {
//			Launch_Application();
//			ip = new IndexPage(driver); // Initialize the indexPage object
//		}
	 
	  
		@Test(groups="Smoke",priority=1, description="User As to Verify logo is present or not")
		public  void LogoTest()
		{
		IndexPage ip=new IndexPage(driver);
		boolean logo=ip.VerifyLogo();
		Assert.assertTrue(logo);
		}
		
		@JiraPolicy(logTicketReady=true)
		@Test(groups="Smoke",priority = 2, description="User As Check the Title of the page")
		public  static void TitleTest()
		{
		IndexPage ip=new IndexPage(driver);
		String ActualTitle=ip.GetCurrentTitle();
		String presentTitle="Your Sto";
		Assert.assertEquals(ActualTitle, presentTitle);
		}
//	
//		@Test(groups="Sanity",priority = 3)
//		public static void AccountSetuptest()
//		{
//		//IndexPage ip=new IndexPage(driver);
//		ip.Click_MyAccount();
//		ip.ClickOn_LogIn();
//		
//		
//		//Without logIn
//		ProductSearchPage=ip.ProductSearch(rb.getString("product1"));
//		
////		hp.Click_MyAccount();
//		
//		
//		}
	

}
