package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_8439000_AMER_ED_Content_LinktoSR_onLevel10forOverviewTab extends BaseTest {


	@Test
	public void validate_TC_8439000_AMER_ED_Content_LinktoSR_onLevel10forOverviewTab() 
	{
		try
		{
			System.out.println("Starts TC_8439000_AMER_ED_Content_LinktoSR_onLevel10forOverviewTab");
			obj_EsupportContentWorkflow.handleCookies(driver);
			obj_EsupportIPSWorkflow.clickSignIn(driver);
			obj_EsupportIPSWorkflow.Emaillogin(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()).split(";")[0],TestNGCreator.TestData.get(Esupport.Password.ordinal()).split(";")[0]);
			obj_EsupportContentWorkflow.ClickSearchServiceTag(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
			obj_EsupportContentWorkflow.ValidateTopSolutionsInOverviewTab(driver);
			obj_EsupportContentWorkflow.verifyLinkToSRIconNotDisplayed(driver);
			
			obj_EsupportIPSWorkflow.signOut(driver);
			Thread.sleep(3000);
			obj_EsupportContentWorkflow.verifyLinkToSRIconNotDisplayed(driver);
			
			obj_EsupportIPSWorkflow.clickSignIn(driver);
			obj_EsupportIPSWorkflow.Emaillogin(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()).split(";")[1],TestNGCreator.TestData.get(Esupport.Password.ordinal()).split(";")[1]);
			Thread.sleep(3000);
			obj_EsupportContentWorkflow.verifyLinkToSRIconIsDisplayed(driver);
			
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_8439000_AMER_ED_Content_LinktoSR_onLevel10forOverviewTab--------->\n  "+e);
		}
	}
}


