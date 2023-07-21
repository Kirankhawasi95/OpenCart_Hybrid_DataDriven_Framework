/**
 * 
 */
package TestBase;

import java.io.File;
import java.io.IOException;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ResourceBundle;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;




/**
 * @author kpkmt942
 *
 */
public class BaseClass {
	
	
	

	public static   WebDriver driver;
	
	public static  ResourceBundle rb;
	
	//static Action_Class act=new Action_Class();

	
	
	
	@Parameters({"Browser"})
	@BeforeClass(groups={"Sanity","Smoke","Regression"})
	public static void Launch_Application(String br) throws Throwable  
	{
		
	rb=ResourceBundle.getBundle("Config");
		
		if(br.equals("Chrome"))
		{
			driver =new ChromeDriver();
			
		}else if(br.equals("Edge"))
		
		{
			driver =new EdgeDriver();
			
		}
	
//		pro=new Properties();
//		FileInputStream reader=new FileInputStream(System.getProperty("user.dir") + "\\Config\\");
//		pro.load(reader);
		
		//driver =new ChromeDriver();
		 driver.get(rb.getString("BaseURL"));
		 
		 driver.manage().window().maximize();
		 Thread.sleep(3000);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
		
			
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	
	
	
	@AfterClass(groups={"Sanity","Smoke","Regression"})
	public static void Application_Close()
	{
		driver.quit();
	}
	
	
	//Method Generate the random string for Newaccount Reg (Fname,Lname,Email,Password)
		//To generate this add a (org.apache) library in POM.xml file
	
	public String GenRandomString()
	{
		String RandomString=RandomStringUtils.randomAlphanumeric(5);
		return RandomString;
	}
	
	public String GenRandomNumber()
	{
		String Randomnumber=RandomStringUtils.randomNumeric(4);
		return Randomnumber;
	}
	
	public String GenRandomEmail()
	{
		String str=RandomStringUtils.randomAlphanumeric(2);
		String number=RandomStringUtils.randomNumeric(3);
		return str+number;
	}
	
	
	//take a Screenshot for Test_case Failure with time stamp and attach to Extent report
	
		public String CapctureScreen(String Tname) throws IOException
		{
			//SimpleDateFormat sp= new SimpleDateFormat("yyyymmddhhss");
			//Date db= new Date();
			
			//String timestamp=sp.format(db);
			
			String TimeStamp= new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
			
			
			TakesScreenshot ScreenShoot = (TakesScreenshot) driver;
			File srcfile = ScreenShoot.getScreenshotAs(OutputType.FILE);
			String destfile = System.getProperty("user.dir") + "\\Screenshoot\\" + Tname + "_" + TimeStamp + ".Png";
			
			try {
			FileUtils.copyFile(srcfile,new File(destfile));
			
			}catch(Exception e)
			
			{
				e.getMessage();
			}
			//return destfile;
			
			String newImageString = "http://localhost:8089/job/MyStoreProject/ws/MyStoreProject/ScreenShots/" + Tname + "_"
					+ TimeStamp + ".png";
			return newImageString;
					
		}

}
