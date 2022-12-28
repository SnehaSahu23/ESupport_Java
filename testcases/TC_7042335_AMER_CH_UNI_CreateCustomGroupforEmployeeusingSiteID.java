package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_7042335_AMER_CH_UNI_CreateCustomGroupforEmployeeusingSiteID extends BaseTest
{
	@Test
	public void validate_TC_7042335_AMER_CH_UNI_CreateCustomGroupforEmployeeusingSiteID() 
	{
		try
		{
			System.out.println("Starts TC_7042335_AMER_CH_UNI_CreateCustomGroupforEmployeeusingSiteID");
			Thread.sleep(10000);
			obj_EsupportUnifiedPortalWorkflow.clickSignInHereLink(driver);
			obj_EsupportUnifiedPortalWorkflow.handleCookies(driver);
			obj_EsupportUnifiedPortalWorkflow.clickCustomGroups(driver);
			Thread.sleep(5000);	
			obj_EsupportUnifiedPortalWorkflow.createProductGroup(driver);
			Thread.sleep(10000);	
			obj_EsupportUnifiedPortalWorkflow.enterProductGroupDetails(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[0],TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[1],TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[2]);
			Thread.sleep(10000);	
			obj_EsupportUnifiedPortalWorkflow.searchSiteId(driver, TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
			Thread.sleep(10000);	
			
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_7042335_AMER_CH_UNI_CreateCustomGroupforEmployeeusingSiteID--------->\n  "+e);
		}
	}
}






