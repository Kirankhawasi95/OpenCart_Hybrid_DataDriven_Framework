/**
 * 
 */
package TestClass;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import PageObjects.IndexPage;
import PageObjects.LogIn_Page;
import TestBase.BaseClass;
import UtilityFile.DataProviders;
/**
 * @author kpkmt942
 *
 */
public class TC_0010_LogInDDT_Test extends BaseClass{
	
	public WebDriver driver;
	
	
	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class)
	public void Test_login_DDT  (String email, String Psw, String exp)
	
	{
		IndexPage ip=new IndexPage(BaseClass.driver);
		ip.Click_MyAccount();
		ip.ClickOn_LogIn();
		
		LogIn_Page lip=new LogIn_Page(BaseClass.driver);
		 
		lip.LogIntoApplication(email,Psw,exp);
		 
		
		HomePage hp=new HomePage(BaseClass.driver);
		 
		boolean verify= hp.VerifyLogin();
		 
		 try {
		 if (exp.equals("Valid")) 
		 {
				if (verify == true)
				{
					Assert.assertTrue(true);
					hp.Clickon_LogOut();
					
				} else 
				{
					Assert.assertTrue(false);
				}
			}

			if (exp.equals("Invalid")) 
			{
				if (verify == true) {
					HomePage hp1=new HomePage(driver);
					hp1.Clickon_LogOut();
					Assert.assertTrue(false);
				} else {
					Assert.assertTrue(true);
				}
			}

		} catch (Exception e) {
			Assert.fail();
	}
		 
}

}
