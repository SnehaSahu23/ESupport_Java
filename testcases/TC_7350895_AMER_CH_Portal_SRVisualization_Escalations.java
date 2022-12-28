package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_7350895_AMER_CH_Portal_SRVisualization_Escalations extends BaseTest
{
	@Test
	public void validate_TC_7350895_AMER_CH_Portal_SRVisualization_Escalations() 
	{
		try
		{
			System.out.println("Starts TC_7350895_AMER_CH_Portal_SRVisualization_Escalations");
				
			obj_EsupportPortalWorkflow.handleCookies(driver);
			obj_EsupportIPSWorkflow.Emaillogin(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			obj_EsupportPortalWorkflow.ClickOnIncidentManagementTab(driver);
			
			obj_EsupportPortalWorkflow.ClickOnEscalations(driver);
			obj_EsupportPortalWorkflow.ClickOnGraphViewInTheEscalationsContext(driver);
			
			obj_EsupportPortalWorkflow.ClickOnFilterAndApplyAnyFilterAndValidateSameFiltersAppliedToTabularAndMapViewInTheEscalationsContext(driver);
			obj_EsupportPortalWorkflow.ClickOnXButtonOfProductNameInBreadScrumbAndValidateGraphView(driver);
			
		
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_7350895_AMER_CH_Portal_SRVisualization_Escalations--------->\n  "+e);
		}
	}
}
