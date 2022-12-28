package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_7038125_AMER_CH_Portal_UpdatedSearchServiceRequestData extends BaseTest
{
	@Test
	public void validate_TC_7038125_AMER_CH_Portal_UpdatedSearchServiceRequestData() 
	{
		try
		{
			System.out.println("Starts TC_7038125_AMER_CH_Portal_UpdatedSearchServiceRequestData");
			obj_EsupportPortalWorkflow.handleCookies(driver);
			obj_EsupportIPSWorkflow.Emaillogin(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			obj_EsupportPortalWorkflow.ClickOnIncidentManagementTab(driver);
			obj_EsupportPortalWorkflow.VerifySearchBoxSearchingAnyCharacters(driver);
			obj_EsupportPortalWorkflow.VerifySearchBoxSearchingAnyCharacters_ExpandedView_IMTab(driver);
			
		
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_7038125_AMER_CH_Portal_UpdatedSearchServiceRequestData--------->\n  "+e);
		}
	}
}
