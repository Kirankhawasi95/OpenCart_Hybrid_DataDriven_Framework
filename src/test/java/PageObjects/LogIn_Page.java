/**
 * 
 */
package PageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import ActionClass.Action_Class;



/**
 * @author kpkmt942
 *
 */
 public class LogIn_Page extends BasePage{
	
	Action_Class act=new Action_Class();
	 
	public LogIn_Page(WebDriver driver) {
		super(driver);
		
	}

	@FindBy (id="input-email")
	WebElement User_Name;
	
	@FindBy (id="input-password")
    WebElement PassWord_Nme;
	
	@FindBy (xpath="//button[@type='submit']")
    WebElement LogIn_Btn;
	
	@FindBy (xpath="//h2[normalize-space()='My Account']")
    WebElement MyAccount;
	

	
	public HomePage LogIntoApplication (String userName, String password,String exp)

	{
		act.TextSend(User_Name, userName);
		act.TextSend(PassWord_Nme, password);
		act.JavascriptExe(driver, LogIn_Btn);
		return new HomePage(driver);
	}
	
	
	public WishListPage LogIntoApplication2 (String userName, String password,String exp)

	{
		act.TextSend(User_Name, userName);
		act.TextSend(PassWord_Nme, password);
		act.JavascriptExe(driver, LogIn_Btn);
		return new WishListPage(driver);
	}
	
//	public String VerifyLogin()
//	{
//		String text=act.GetText(driver, MyAccount);
//		return text;
//	}
	
	
//	public HomePage Clickon_logInBtn()
//	{
//		act.JavascriptExe(driver, LogIn_Btn);
//		return new HomePage(driver);
//	}
	
}
	
	


