package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_7035667_AMER_CH_UNI_CustomGroupsCreationusingProductIDforCPUsers extends BaseTest
{
	@Test
	public void validate_TC_7035667_AMER_CH_UNI_CustomGroupsCreationusingProductIDforCPUsers() 
	{
		try
		{
			System.out.println("Starts TC_7035667_AMER_CH_UNI_CustomGroupsCreationusingProductIDforCPUsers");
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
			obj_EsupportUnifiedPortalWorkflow.searchProductId(driver, TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
			Thread.sleep(10000);	
			obj_EsupportUnifiedPortalWorkflow.clickCreateCustomGroupButton(driver);
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_7035667_AMER_CH_UNI_CustomGroupsCreationusingProductIDforCPUsers--------->\n  "+e);
		}
	}
}
