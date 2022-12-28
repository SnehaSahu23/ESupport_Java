package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_8438981_AMER_FF_Content_OpenupmostofIPSfunctionalityandtakeoffauthentication_DocumentationTab extends BaseTest {


	@Test
	public void validate_TC_8438981_AMER_FF_Content_OpenupmostofIPSfunctionalityandtakeoffauthentication_DocumentationTab() 
	{
		try
		{
			System.out.println("Starts TC_8438981_AMER_FF_Content_OpenupmostofIPSfunctionalityandtakeoffauthentication_DocumentationTab");
			obj_EsupportContentWorkflow.handleCookies(driver);
			obj_EsupportIPSWorkflow.clickSignIn(driver);
			obj_EsupportIPSWorkflow.Emaillogin(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()).split(";")[0],TestNGCreator.TestData.get(Esupport.Password.ordinal()).split(";")[0]);
			obj_EsupportContentWorkflow.ClickSearchServiceTag(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
			obj_EsupportContentWorkflow.ClickDocumentationTab(driver);
			obj_EsupportContentWorkflow.verifyLinkToSRIconNotDisplayed(driver);
			
			obj_EsupportIPSWorkflow.signOut(driver);
			Thread.sleep(3000);
			obj_EsupportContentWorkflow.verifyLinkToSRIconNotDisplayed(driver);
			
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_8438981_AMER_FF_Content_OpenupmostofIPSfunctionalityandtakeoffauthentication_DocumentationTab--------->\n  "+e);
		}
	}
}