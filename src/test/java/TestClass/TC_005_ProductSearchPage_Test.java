/**
 * 
 */
package TestClass;


import org.testng.Assert;
import org.testng.annotations.Test;

import TestBase.BaseClass;
import PageObjects.HomePage;
import PageObjects.IndexPage;
import PageObjects.LogIn_Page;
import PageObjects.ProductSearchPage;
import PageObjects.WishListPage;
/**
 * @author kpkmt942
 *
 */
public class TC_005_ProductSearchPage_Test extends BaseClass{
	
	IndexPage ip;
	LogIn_Page lp;
	HomePage hp;
	ProductSearchPage ps;
	WishListPage WishListPage;
	
	
	
	@Test(groups="Sanity")
	public void ProductPage_Test() throws Throwable
	{
		
//		TC_004_HomePage_Test hp=new TC_004_HomePage_Test();
//		hp.HomePage_Test();
		
		new IndexPage(driver);
		ip=new IndexPage(driver);
		ip.Click_MyAccount();
		
		lp=ip.ClickOn_LogIn();
		hp=lp.LogIntoApplication(rb.getString("Email"),rb.getString("Password"), null);
		
	}
		@Test
		public void Search_Product()
		{
		ps=hp.SearchProduct(rb.getString("product1"));
		String expresult=ps.AddToWishList();
		String presentresult="Success: You have added HTC Touch HD to your wish list!";
		Assert.assertEquals(expresult,presentresult);
		
		WishListPage=ps.ClickOn_Wishlist();

		}
		
//		IndexPage ip=new IndexPage(driver);
//		
//		ip.Click_MyAccount();
//		ip.ClickOn_LogIn();
//		
//		
//		//ip.ProductSearch(rb.getString("product1"));
//		
//		LogIn_Page lip=new LogIn_Page(driver);
//		lip.LogIntoApplication(rb.getString("Email"),rb.getString("Password"), null);
//		
//		HomePage hp=new HomePage(driver);
//		hp.SearchProduct(rb.getString("product1"));
		
		
//		ProductSearchPage psp=new ProductSearchPage(driver);
//		
//		String expresult=psp.AddToWishList();
//		String presentresult="Success: You have added HTC Touch HD to your wish list!";
//	
//		Assert.assertEquals(expresult,presentresult);
//		
		
		//psp.GetAllproduct();
		
		
		
		
		//psp.GetAllproduct();
		
	} 



