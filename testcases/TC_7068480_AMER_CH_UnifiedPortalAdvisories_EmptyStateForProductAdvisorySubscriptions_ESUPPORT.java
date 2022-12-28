package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_7068480_AMER_CH_UnifiedPortalAdvisories_EmptyStateForProductAdvisorySubscriptions_ESUPPORT extends BaseTest 
{
	@Test
	public void validate_TC_7068480_AMER_CH_UnifiedPortalAdvisories_EmptyStateForProductAdvisorySubscriptions_ESUPPORT() 
	{

		try
		{
			System.out.println("Starts TC_7068480_AMER_CH_UnifiedPortalAdvisories_EmptyStateForProductAdvisorySubscriptions_ESUPPORT");
			
//			obj_EsupportIncidentsWorkflow.clickSignIn(driver);
			obj_EsupportIncidentsWorkflow.ToLogin_ValidCredentials(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			
			obj_EsupportUnifiedPortalWorkflow.ClickOnNotificationAndAlertsTab(driver);
			obj_EsupportUnifiedPortalWorkflow.ClickOnProductAdvisories(driver);
			obj_EsupportUnifiedPortalWorkflow.VerifyForAddAlert(driver);

		}
		catch(Exception e)
		{

			Assert.fail("Failed while TC_7068480_AMER_CH_UnifiedPortalAdvisories_EmptyStateForProductAdvisorySubscriptions_ESUPPORT--------->\n  "+e);

		}

	}
}
