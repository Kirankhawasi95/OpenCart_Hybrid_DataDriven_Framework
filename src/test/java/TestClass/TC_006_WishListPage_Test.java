/**
 * 
 */
package TestClass;

import TestBase.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import PageObjects.IndexPage;
import PageObjects.LogIn_Page;
import PageObjects.ProductSearchPage;
import PageObjects.ShopingCartPage;
import PageObjects.WishListPage;

/**
 * @author kpkmt942
 *
 */
public class TC_006_WishListPage_Test extends BaseClass{
	
	
	
	IndexPage ip;
	LogIn_Page lp;
	HomePage hp;
	ProductSearchPage ps;
	WishListPage wi;
	ShopingCartPage ShopingCartPage;
	
	@Test(groups="Sanity",priority=1)
	public void WishListPage_Test() throws Throwable 
	{
		
		
//		TC_005_ProductSearchPage_Test psp=new TC_005_ProductSearchPage_Test();
//		psp.ProductPage_Test();
//		
		new IndexPage(driver);
		ip=new IndexPage(driver);
		ip.Click_MyAccount();
		
		lp=ip.ClickOn_LogIn();
		hp=lp.LogIntoApplication(rb.getString("Email"),rb.getString("Password"), null);
		
		ps=hp.SearchProduct(rb.getString("product1"));
		ps.AddToWishList();
		wi=ps.ClickOn_Wishlist();
		
	
	}
		
		@Test(priority=2)
		public void ProductTest()
		{
			
			wi.VerifySameProduct();
			String product=wi.VerifySameProduct();
			Assert.assertEquals(product, "HTC Touch HD");
			
			String result2=wi.verifyCartMsg();
			Assert.assertEquals(result2, "Success: You have added HTC Touch HD to your shopping cart!");
			ShopingCartPage=wi.ClickOn_cart();
			
		
		}
		
//
//		IndexPage ip=new IndexPage(driver);
//		
//		ip.Click_MyAccount();
//		ip.ClickOn_LogIn();
//		//ip.ProductSearch(rb.getString("product1"));
//		
//		
//		LogIn_Page lip=new LogIn_Page(driver);
//		lip.LogIntoApplication(rb.getString("Email"),rb.getString("Password"), null);
//		
//		HomePage hp=new HomePage(driver);
//		hp.SearchProduct(rb.getString("product1"));
//		
//		
//		ProductSearchPage psp=new ProductSearchPage(driver);
//		
//		String expresult=psp.AddToWishList();
//		String presentresult="Success: You have added HTC Touch HD to your wish list!";
//	
//		Assert.assertEquals(expresult,presentresult);
//		
//		
//		WishListPage wi=new WishListPage(driver);
//		
//		String product=wi.VerifySameProduct();
//		Assert.assertEquals(product, "HTC Touch HD");
//		
//		String result2=wi.verifyCartMsg();
//		Assert.assertEquals(result2, "Success: You have added HTC Touch HD to your shopping cart!");
//		
//		
//	}
}

