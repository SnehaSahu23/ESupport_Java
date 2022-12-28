package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_9786238_AMER_IE_LBK_OpenContent_HowTo_ContactSlider_ESUPPORT extends BaseTest {


	@Test
	public void validate_TC_9786238_AMER_IE_LBK_OpenContent_HowTo_ContactSlider_ESUPPORT() 
	{
		try
		{
			System.out.println("Starts TC_9786238_AMER_IE_LBK_OpenContent_HowTo_ContactSlider_ESUPPORT()");
			
			obj_EsupportContentWorkflow.launchArticlePage(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[0]);
			obj_EsupportContentWorkflow.verifyContactUsSliderContent(driver);
			obj_EsupportContentWorkflow.clickTechnicalSupportLink(driver);
			obj_EsupportContentWorkflow.clickOrderSupportLink(driver);
			obj_EsupportContentWorkflow.verifyArticleType(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[1]);
			
			Thread.sleep(6000);
			// L30 validations
			obj_EsupportIPSWorkflow.clickSignIn(driver);
			obj_EsupportIPSWorkflow.Emaillogin(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()).split(";")[0],TestNGCreator.TestData.get(Esupport.Password.ordinal()).split(";")[0]);
			obj_EsupportContentWorkflow.launchArticlePage(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[2]);
			obj_EsupportContentWorkflow.verifyArticleType(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[1]);
			obj_EsupportContentWorkflow.verifyContactUsSliderWithAuthenticationL304050(driver);
			obj_EsupportIPSWorkflow.signOut(driver);
			Thread.sleep(6000);
			// L40 validations
//			obj_EsupportIPSWorkflow.clickSignIn(driver);
			obj_EsupportIPSWorkflow.Emaillogin(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()).split(";")[1],TestNGCreator.TestData.get(Esupport.Password.ordinal()).split(";")[1]);
			obj_EsupportContentWorkflow.launchArticlePage(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[3]);
			obj_EsupportContentWorkflow.verifyArticleType(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[1]);
			obj_EsupportContentWorkflow.verifyContactUsSliderWithAuthenticationL304050(driver);
			obj_EsupportIPSWorkflow.signOut(driver);
			Thread.sleep(6000);
			// L50 validations
//			obj_EsupportIPSWorkflow.clickSignIn(driver);
			obj_EsupportIPSWorkflow.clickSignInHereLink(driver);
			obj_EsupportContentWorkflow.launchArticlePage(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[4]);
			obj_EsupportContentWorkflow.verifyArticleType(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[1]);
			obj_EsupportContentWorkflow.verifyContactUsSliderWithAuthenticationL304050(driver);
			obj_EsupportIPSWorkflow.signOut(driver);
			Thread.sleep(6000);
			
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_9786238_AMER_IE_LBK_OpenContent_HowTo_ContactSlider_ESUPPORT()--------->\n  "+e);
		}
	}
}