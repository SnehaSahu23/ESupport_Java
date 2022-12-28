package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_7066310_AMER_CH_UNI_CustomgroupsViewpage extends BaseTest
{
	@Test
	public void validate_TC_7066310_AMER_CH_UNI_CustomgroupsViewpage() 
	{
		try
		{
			System.out.println("Starts TC_7066310_AMER_CH_UNI_CustomgroupsViewpage");
			Thread.sleep(10000);	
			obj_EsupportUnifiedPortalWorkflow.handleCookies(driver);
			obj_EsupportIPSWorkflow.Emaillogin(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			Thread.sleep(5000);	
			obj_EsupportUnifiedPortalWorkflow.clickCustomGroups(driver);
			Thread.sleep(5000);	
			obj_EsupportUnifiedPortalWorkflow.verifyMyCustomGroupsColumns(driver);
			Thread.sleep(10000);	
			obj_EsupportUnifiedPortalWorkflow.filterCustomGroups(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()));
			Thread.sleep(10000);
			obj_EsupportUnifiedPortalWorkflow.clickMyCustomGroupsClearButton(driver);
			obj_EsupportUnifiedPortalWorkflow.verifyMyCustomGroupsDownloadButton(driver);
			obj_EsupportUnifiedPortalWorkflow.verifySortingOptionColumns(driver);
			obj_EsupportUnifiedPortalWorkflow.verifyDeleteCustomGroupOption(driver);
			obj_EsupportUnifiedPortalWorkflow.verifyPaginationServiceRequestEvents(driver);
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_7066310_AMER_CH_UNI_CustomgroupsViewpage--------->\n  "+e);
		}
	}
}