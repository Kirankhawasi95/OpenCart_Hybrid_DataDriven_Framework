/**
 * 
 */
package TestClass;


import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import PageObjects.IndexPage;
import PageObjects.LogIn_Page;
import TestBase.BaseClass;

/**
 * @author kpkmt942
 *
 */
public class TC_002_LogInPage_Test extends BaseClass{
	
	IndexPage ip;
	LogIn_Page lp;
	HomePage homepage;
//	
//	@Test
//	public void LogInPage_Test() throws InterruptedException
//	{
//		
//	}	
		
		@Test(groups="Sanity",priority=-1)
		public void LogInPage_Test()
		{
			ip=new IndexPage(driver);
			ip.Click_MyAccount();
			lp=ip.ClickOn_LogIn();
			homepage=lp.LogIntoApplication(rb.getString("Email"),rb.getString("Password"), null);
		}
		
			@Test
			public void LogInConif_Test()
			{
			boolean ActualResult=homepage.VerifyLogin();
			Assert.assertTrue(ActualResult);
			}
			
			//LogIn_Page.Clickon_logInBtn();
			
	}


