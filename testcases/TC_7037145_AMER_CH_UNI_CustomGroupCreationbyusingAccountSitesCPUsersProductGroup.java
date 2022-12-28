package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_7037145_AMER_CH_UNI_CustomGroupCreationbyusingAccountSitesCPUsersProductGroup extends BaseTest
{
	@Test
	public void validate_TC_7037145_AMER_CH_UNI_CustomGroupCreationbyusingAccountSitesCPUsersProductGroup() 
	{
		try
		{
			System.out.println("Starts TC_7037145_AMER_CH_UNI_CustomGroupCreationbyusingAccountSitesCPUsersProductGroup");
			Thread.sleep(10000);	
			obj_EsupportUnifiedPortalWorkflow.handleCookies(driver);
			obj_EsupportIPSWorkflow.Emaillogin(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			Thread.sleep(5000);	
			obj_EsupportUnifiedPortalWorkflow.clickCustomGroups(driver);
			Thread.sleep(5000);	
			obj_EsupportUnifiedPortalWorkflow.createProductGroup(driver);
			Thread.sleep(10000);	
			obj_EsupportUnifiedPortalWorkflow.enterProductGroupDetails(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[0],TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[1],TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[2]);
			Thread.sleep(10000);	
			obj_EsupportUnifiedPortalWorkflow.searchAccountSitesAndClickFilterButton(driver, TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
			Thread.sleep(10000);
			obj_EsupportUnifiedPortalWorkflow.verifyAddToGroupButtonEnabled(driver);
			obj_EsupportUnifiedPortalWorkflow.clickAddToGroupButtonVerifySecondGrid(driver);
			obj_EsupportUnifiedPortalWorkflow.clickCreateCustomGroupButton(driver);
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_7037145_AMER_CH_UNI_CustomGroupCreationbyusingAccountSitesCPUsersProductGroup--------->\n  "+e);
		}
	}
}



