/**
 * 
 */
package TestClass;

import TestBase.BaseClass;

import org.testng.annotations.Test;

import PageObjects.CheckOutPage;
/**
 * @author kpkmt942
 *
 */
public class TC_008_CheckOutPage_Test extends BaseClass{
	
	@Test
	public void CheckOutPage_Tes() throws Throwable
	{
		TC_007_ShopingCartPage_Test scp=new TC_007_ShopingCartPage_Test();
		scp.ShopingCartPage_Test();
		
		CheckOutPage cop=new CheckOutPage(driver);
		cop.CheckRedioBtn1();
		cop.SetAddress(GenRandomString(), GenRandomString(), GenRandomString(), GenRandomString(), GenRandomString());
		cop.SetAddress2(GenRandomString(), GenRandomNumber(), 5, 2);
		cop.GetfinalproductQty();
		
	}
	
			
	

}
