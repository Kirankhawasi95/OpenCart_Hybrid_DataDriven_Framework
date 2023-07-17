/**
 * 
 */
package TestClass;

import org.testng.annotations.Test;

import PageObjects.IndexPage;
import PageObjects.NewAccountReg_Page;
import TestBase.BaseClass;

/**
 * @author kpkmt942
 *
 */
public class TC_003_AccountReg_Test extends BaseClass{
	
	
	@Test(groups="Sanity")
	public void AccountReg_Test() throws InterruptedException
	{
		IndexPage ip=new IndexPage(driver);
		ip.Click_MyAccount();
		ip.Click_RegBtn();
		
		NewAccountReg_Page nap=new NewAccountReg_Page(driver);
		nap.SetUpNewReg(GenRandomString(), GenRandomString(), GenRandomEmail()+"@"+"gmail.com", GenRandomNumber());
		nap.Get_Confration_msg();
	}
	
	

}
