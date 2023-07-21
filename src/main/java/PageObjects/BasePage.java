/**
 * 
 */
package PageObjects;

import java.util.ResourceBundle;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import ActionClass.Action_Class;

/** @author kpkmt942
 *Common constructor for All PageObjets and each PageObjets will extends this constructor
 *Base Constructor to achieve the PageObject Model(POM)
 *Method Reuseabality is Achieved 
 */
public class BasePage {
	
	
	public static  WebDriver driver;
	public static ResourceBundle rb;	
	
	
	static Action_Class act=new Action_Class();


	public BasePage(WebDriver driver)	{
		BasePage.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
