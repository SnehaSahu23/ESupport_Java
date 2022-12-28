package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_7058794_AMER_CH_PORT_LookupFiltersContractDateFilter extends BaseTest
{
	@Test
	public void validate_TC_7058794_AMER_CH_PORT_LookupFiltersContractDateFilter() 
	{
		try
		{
			System.out.println("Starts TC_7058794_AMER_CH_PORT_LookupFiltersContractDateFilter");
			obj_EsupportPortalWorkflow.handleCookies(driver);
			obj_EsupportIPSWorkflow.Emaillogin(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			obj_EsupportPortalWorkflow.clickInstallBaseTab(driver);
			obj_EsupportPortalWorkflow.clickInstallBaseContractsButton(driver);
			obj_EsupportPortalWorkflow.verifyInstallBaseSpecificFilters(driver);	
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_7058794_AMER_CH_PORT_LookupFiltersContractDateFilter--------->\n  "+e);
		}
	}
}

