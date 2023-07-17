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
import PageObjects.CheckOutPage;
/**
 * @author kpkmt942
 *
 */
public class TC_007_ShopingCartPage_Test extends BaseClass{
	
	IndexPage ip;
	LogIn_Page lp;
	HomePage hp;
	ProductSearchPage ps;
	WishListPage wi;
	ShopingCartPage ShopingCartPage;
	CheckOutPage CheckOutPage;
	
	
	@Test(groups="Regression",priority=3)
	public void ShopingCartPage_Test() throws Throwable
	{
//		TC_006_WishListPage_Test spt=new TC_006_WishListPage_Test();
//		spt.WishListPage_Test();
//		spt.ProductTest();
		
		new IndexPage(driver);
		ip=new IndexPage(driver);
		ip.Click_MyAccount();
		
		lp=ip.ClickOn_LogIn();
		hp=lp.LogIntoApplication(rb.getString("Email"),rb.getString("Password"), null);
		
		ps=hp.SearchProduct(rb.getString("product1"));
		ps.AddToWishList();
		wi=ps.ClickOn_Wishlist();
		

		wi.VerifySameProduct();
		String product=wi.VerifySameProduct();
		Assert.assertEquals(product, "HTC Touch HD");
		
		String result2=wi.verifyCartMsg();
		Assert.assertEquals(result2, "Success: You have added HTC Touch HD to your shopping cart!");
		ShopingCartPage=wi.ClickOn_cart();
		
		
		double UnitPrice=ShopingCartPage.GetUnitPrice("2");
		double TotalPrice=ShopingCartPage.GetSubTotalPrice();
		double ExpectedPrice=(UnitPrice*2)*1;
		System.out.println(TotalPrice);
		System.out.println(ExpectedPrice);
		Assert.assertEquals(TotalPrice, ExpectedPrice);
		
		
		CheckOutPage=ShopingCartPage.ClickOnCheckOut();
	
	}

}
