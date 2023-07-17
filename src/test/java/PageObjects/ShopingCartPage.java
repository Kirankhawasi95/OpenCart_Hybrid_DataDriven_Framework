/**
 * 
 */
package PageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import ActionClass.Action_Class;

/**
 * @author kpkmt942
 *
 */
public class ShopingCartPage extends BasePage{

	Action_Class act=new Action_Class();
	public ShopingCartPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy (xpath="(//td[@class=\"text-start\"]//input)[1]")
	WebElement Quantity;
	
	@FindBy (xpath="(//table[@class='table table-bordered']//tr)[2]//td[5]")
	WebElement UnitPrice;
	
	@FindBy (xpath="//main//tr[2]//td[2]")
	WebElement SubTotalPrice;
	
	@FindBy (xpath="//a[@class='btn btn-primary']")
	WebElement CheckOut;
	
	
	public double GetUnitPrice(String Qty)
	{
		//Quantity.sendKeys(Qty,Keys.ENTER);
		act.TextSend(Quantity, Qty);
		Quantity.clear();
		Quantity.sendKeys(Qty,Keys.ENTER);
		
		//act.Click(driver, Quantity);
		String RemDol=UnitPrice.getText();
		String EmtyCht=RemDol.replaceAll("[^a-zA-Z0-9]", "");
		double IndianRupi=Double.parseDouble(EmtyCht);
		return IndianRupi/100;		
	}
	
	public double GetSubTotalPrice()
	{
		
		String RemDol=SubTotalPrice.getText();
		String EmtyCht=RemDol.replaceAll("[^a-zA-Z0-9]", "");
		double IndianRupi=Double.parseDouble(EmtyCht);
		return IndianRupi/100;		
	}
	
	public CheckOutPage ClickOnCheckOut()
	{
		act.JavascriptExe(driver, CheckOut);
		return new CheckOutPage(driver);
	}

}


