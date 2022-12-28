package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_7671408_AMER_CH_Portal_FilterBy_AwaitingActionsShouldBeDisplayedInTheFilterByAsASeparateFilter_ESUPPORT extends BaseTest
{
	@Test
	public void validate_TC_7671408_AMER_CH_Portal_FilterBy_AwaitingActionsShouldBeDisplayedInTheFilterByAsASeparateFilter_ESUPPORT() 
	{
		try
		{
			System.out.println("Starts TC_7671408_AMER_CH_Portal_FilterBy_AwaitingActionsShouldBeDisplayedInTheFilterByAsASeparateFilter_ESUPPORT");
				
			obj_EsupportPortalWorkflow.handleCookies(driver);
			obj_EsupportIPSWorkflow.Emaillogin(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			obj_EsupportPortalWorkflow.ClickOnIncidentManagementTab(driver);
			
			obj_EsupportPortalWorkflow.ClickOnGraph(driver);
			
			obj_EsupportPortalWorkflow.ValidateDefaultDisplayedGraphView(driver);
			
			
			obj_EsupportPortalWorkflow.ClickOnAnyOfGraphBarAndValidateForExpandView(driver);
			
			obj_EsupportPortalWorkflow.ValidateIfSeverityS4AndS7DisplayIfCountIsNotZero(driver);
			obj_EsupportPortalWorkflow.ClickOnFilterAndApplyAnyFilterAndValidateSameFiltersAppliedToTabularAndMapView(driver);
			obj_EsupportPortalWorkflow.ClickOnXButtonOfSRStatusInBreadScrumbAndValidateGraphView(driver);
			obj_EsupportPortalWorkflow.ValidateGraphViewAfterRemovalOfSRStatusFilter(driver);
		
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_7671408_AMER_CH_Portal_FilterBy_AwaitingActionsShouldBeDisplayedInTheFilterByAsASeparateFilter_ESUPPORT--------->\n  "+e);
		}
	}
}
