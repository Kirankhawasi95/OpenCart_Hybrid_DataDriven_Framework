package UtilityFile;

import org.testng.ITestResult;

import testlink.api.java.client.TestLinkAPIClient;
import testlink.api.java.client.TestLinkAPIException;

public class TestLinkIntigration {
	
	//TestLinkAPIClient testlink= new TestLinkAPIClient(APIKey,TestLink_URL);
	
	
	
	
	

	public static  final String APIKey="85c0cc560f288c468d38c8b8c671cac8";
	public static  final String TestLink_URL="http://127.0.0.1/testlink/lib/api/xmlrpc/v1/xmlrpc.php";
	public static  final String TestPrpjrct_Name="OpenCart Hybrid  Project";
	public static  final String TestPlan_Name="OpenCart Test Plan";
	//public static  final String TestCase_Name="User Successfully Login with valid creational";
	public static  final String Build_Name="Build Version 01";
	//private static final TestLinkManager TestLinkManager=new TestLinkManager();
	
	
	
	TestLinkAPIClient TestLinkAPIClient;
	
	
	 public static void UpdateResult(ITestResult result, String notes, String status) throws Throwable {
	        // Your code...
		 try {
			    TestLinkAPIClient testlink = new TestLinkAPIClient(APIKey, TestLink_URL);
			    String description=result.getMethod().getDescription();
			    testlink.reportTestCaseResult(TestPrpjrct_Name, TestPlan_Name, description, Build_Name, notes, status);
			} catch (TestLinkAPIException e) {
			    e.printStackTrace();
			}
	 }

}
