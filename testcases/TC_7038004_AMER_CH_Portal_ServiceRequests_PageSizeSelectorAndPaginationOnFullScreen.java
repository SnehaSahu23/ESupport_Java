package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_7038004_AMER_CH_Portal_ServiceRequests_PageSizeSelectorAndPaginationOnFullScreen extends BaseTest
{
	@Test
	public void validate_TC_7038004_AMER_CH_Portal_ServiceRequests_PageSizeSelectorAndPaginationOnFullScreen() 
	{
		try
		{
			System.out.println("Starts TC_7038004_AMER_CH_Portal_ServiceRequests_PageSizeSelectorAndPaginationOnFullScreen");
				
			obj_EsupportPortalWorkflow.handleCookies(driver);
			obj_EsupportIPSWorkflow.Emaillogin(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			obj_EsupportPortalWorkflow.ClickOnIncidentManagementTab(driver);
			obj_EsupportPortalWorkflow.VerifyPageNumbersDisplayingUnderPaginationSection(driver);
			obj_EsupportPortalWorkflow.ValidatePreviousWillBeGreyedOutWhenUserIsOn1stPageIfMoreThanOnePagePresent(driver);
			obj_EsupportPortalWorkflow.ValidateNextWillBeGreyedOutWhenUserIsOnLastPageIfMoreThanOnePagePresent(driver);
			
			obj_EsupportPortalWorkflow.SelectPerticularPageAndValidateBackFilledColor(driver);
			obj_EsupportPortalWorkflow.ValidatePageSizeSelectorSection(driver);
			
		
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_7038004_AMER_CH_Portal_ServiceRequests_PageSizeSelectorAndPaginationOnFullScreen--------->\n  "+e);
		}
	}
}
