/**
 * 
 */
package TestClass;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.CheckOutPage;
import PageObjects.HomePage;
import PageObjects.IndexPage;
import PageObjects.LogIn_Page;
import PageObjects.ProductSearchPage;
import PageObjects.ShopingCartPage;
import PageObjects.WishListPage;
import TestBase.BaseClass;

/**
 * @author kpkmt942
 *
 */
public class TC_009_EndToEnd_Test extends BaseClass{
	
	IndexPage ip;
	LogIn_Page lp;
	HomePage hp;
	ProductSearchPage ps;
	WishListPage wi;
	ShopingCartPage ShopingCartPage;
	CheckOutPage CheckOutPage;


		@Test(priority = 1)
		public void IndexPage_Test()
		{
		IndexPage ip=new IndexPage(driver);
		
		boolean logo=ip.VerifyLogo();
		Assert.assertTrue(logo);
		
		String ActualTitle=ip.GetCurrentTitle();
		String presentTitle="Your Store";
		Assert.assertEquals(ActualTitle, presentTitle);
		
		ps=ip.ProductSearch(rb.getString("product1"));
		
//		ip.Click_MyAccount();
//		lp=ip.ClickOn_LogIn();
		
		}
		
		@Test(priority = 2)
		public void ProductSearchPage_Test()
		{
		
			lp=ps.ClickOn_Wishlist2();
			wi=lp.LogIntoApplication2(rb.getString("Email"),rb.getString("Password"), null);
		
		
			wi.VerifySameProduct();
			String product=wi.VerifySameProduct();
			Assert.assertEquals(product, "HTC Touch HD");
			
			String result2=wi.verifyCartMsg();
			Assert.assertEquals(result2, "Success: You have added HTC Touch HD to your shopping cart!");
			ShopingCartPage=wi.ClickOn_cart();
		
		}
		
		@Test(priority = 3)
		public void ShopingCartPage_Test()
		{
			double UnitPrice=ShopingCartPage.GetUnitPrice("2");
			double TotalPrice=ShopingCartPage.GetSubTotalPrice();
			System.out.println(TotalPrice);
			double ExpectedPrice=(UnitPrice*2)*2;
			Assert.assertEquals(TotalPrice, ExpectedPrice);
			CheckOutPage=ShopingCartPage.ClickOnCheckOut();
			
			CheckOutPage.CheckRedioBtn1();
			CheckOutPage.CheckRedioBtn1();
			CheckOutPage.SetAddress(GenRandomString(), GenRandomString(), GenRandomString(), GenRandomString(), GenRandomString());
			CheckOutPage.SetAddress2(GenRandomString(), GenRandomNumber(), 5, 2);
			CheckOutPage.GetfinalproductQty();
			
		}

	}


