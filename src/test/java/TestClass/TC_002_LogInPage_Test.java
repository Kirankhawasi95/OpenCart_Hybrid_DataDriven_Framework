/**
 * 
 */
package TestClass;


import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import PageObjects.HomePage;
import PageObjects.IndexPage;
import PageObjects.LogIn_Page;
import TestBase.BaseClass;
import UtilityFile.JiraPolicy;

/**
 * @author kpkmt942
 *
 */
public class TC_002_LogInPage_Test extends BaseClass{
	
	IndexPage ip;
	LogIn_Page lp;
	HomePage homepage;
	
	SoftAssert soft=new SoftAssert();
//	
//	@Test
//	public void LogInPage_Test() throws InterruptedException
//	{
//		
//	}	
		
		@Test(groups="Sanity",priority=-1, description = "User Successfully Login with valid creational"
				+ "")
		public void LogInPage_Test()
		{
			ip=new IndexPage(driver);
			ip.Click_MyAccount();
			lp=ip.ClickOn_LogIn();
			homepage=lp.LogIntoApplication(rb.getString("Email"),rb.getString("Password"), null);
			boolean ActualResult=homepage.VerifyLogin();
			Assert.assertTrue(ActualResult);
			homepage.Clickon_LogOut();
		}
		
		
		
			@JiraPolicy(logTicketReady=true)
			@Test(groups="Sanity", priority=1)
			public void LogInTest2()
			{
				ip=new IndexPage(driver);
				ip.Click_MyAccount();
				lp=ip.ClickOn_LogIn();
				homepage=lp.LogIntoApplication(rb.getString("Email"),rb.getString("Password1"), null);
				
				boolean ActualResult=homepage.VerifyLogin();
				
				if(ActualResult==true)
				{
					
					Assert.assertTrue(true);
					homepage.Clickon_LogOut();
					
					System.out.println("test case is pass");
					
					
				}else
				{

					
					System.out.println("test case is fail");
					Assert.assertTrue(false);
				}
					
				
				
			}
			
			
			
			
	}


