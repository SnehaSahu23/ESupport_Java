package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_8844033_AMER_FF_Content_PrintFunctionlaityfordifferentLevels extends BaseTest
{
	@Test
	public void validate_TC_8844033_AMER_FF_Content_PrintFunctionlaityfordifferentLevels() 
	{
		try
		{
			System.out.println("Starts TC_8844033_AMER_FF_Content_PrintFunctionlaityfordifferentLevels");
			obj_EsupportContentWorkflow.handleCookies(driver);
		

			//Validate whether the user see the Print text along with icon on the article page(s)
			
			obj_EsupportContentWorkflow.launchArticlePage(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[0]);
			obj_EsupportContentWorkflow.verifyArticlePrintLink(driver);
			
			//Scenario : Level 10 user tries to print an article and clicks on the Print button
			obj_EsupportIPSWorkflow.clickSignIn(driver);
			obj_EsupportIPSWorkflow.Emaillogin(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()).split(";")[0],TestNGCreator.TestData.get(Esupport.Password.ordinal()).split(";")[0]);
			obj_EsupportContentWorkflow.launchArticlePage(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[0]);
			obj_EsupportContentWorkflow.verifyArticlePrintLink(driver);
			obj_EsupportContentWorkflow.clickArticlePrintLink(driver);
			
			//Scenario : Level 30 user tries to print an article and clicks on the Print button
			obj_EsupportIPSWorkflow.signOut(driver);
			obj_EsupportIPSWorkflow.clickSignIn(driver);
			obj_EsupportIPSWorkflow.Emaillogin(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()).split(";")[1],TestNGCreator.TestData.get(Esupport.Password.ordinal()).split(";")[1]);
			obj_EsupportContentWorkflow.launchArticlePage(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[0]);
			obj_EsupportContentWorkflow.verifyArticlePrintLink(driver);
			obj_EsupportContentWorkflow.clickArticlePrintLink(driver);
			obj_EsupportContentWorkflow.clickArticlePrintChevronFirstOption(driver);
			
			//Scenario : Level 40 user tries to print an article and clicks on the Print button
			obj_EsupportIPSWorkflow.signOut(driver);
			obj_EsupportIPSWorkflow.clickSignIn(driver);
			obj_EsupportIPSWorkflow.Emaillogin(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()).split(";")[2],TestNGCreator.TestData.get(Esupport.Password.ordinal()).split(";")[2]);
			obj_EsupportContentWorkflow.launchArticlePage(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[0]);
			obj_EsupportContentWorkflow.verifyArticlePrintLink(driver);
			obj_EsupportContentWorkflow.clickArticlePrintLink(driver);
			obj_EsupportContentWorkflow.verifyPrintChevronOptions(driver);
			obj_EsupportContentWorkflow.clickArticlePrintChevronFirstOption(driver);
			
			//Scenario : Level 50 user tries to print an article and clicks on the Print button
			obj_EsupportIPSWorkflow.signOut(driver);
			obj_EsupportIPSWorkflow.clickSignIn(driver);
			obj_EsupportIPSWorkflow.clickSignInHereLink(driver);
			Thread.sleep(5000);
			obj_EsupportContentWorkflow.ToLogin_ValidCredentials(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()).split(";")[3],TestNGCreator.TestData.get(Esupport.Password.ordinal()).split(";")[3]);
			
			obj_EsupportContentWorkflow.launchArticlePage(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[1]);
			obj_EsupportContentWorkflow.verifyArticlePrintLink(driver);
			obj_EsupportContentWorkflow.clickArticlePrintLink(driver);
			obj_EsupportContentWorkflow.verifyPrintChevronOptions(driver);
			obj_EsupportContentWorkflow.clickArticlePrintChevronFirstOption(driver);
			
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_8844033_AMER_FF_Content_PrintFunctionlaityfordifferentLevels--------->\n  "+e);
		}
	}
}