package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_9619919_AMER_CH_UnifiedProfile_LKB_Story9590357AdvisoryAlertsMessagingrelatedtochangingpreferredemailaddress_ESUPPORT extends BaseTest 
{
	@Test
	public void validate_TC_9619919_AMER_CH_UnifiedProfile_LKB_Story9590357AdvisoryAlertsMessagingrelatedtochangingpreferredemailaddress_ESUPPORT() 
	{

		try
		{
			System.out.println("Starts TC_9619919_AMER_CH_UnifiedProfile_LKB_Story9590357AdvisoryAlertsMessagingrelatedtochangingpreferredemailaddress_ESUPPORT");
			
//			obj_EsupportIncidentsWorkflow.clickSignIn(driver);
			obj_EsupportIncidentsWorkflow.ToLogin_ValidCredentials(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			
			obj_EsupportUnifiedPortalWorkflow.ClickOnNotificationAndAlertsTab(driver);
			obj_EsupportUnifiedPortalWorkflow.ClickOnProductAdvisories(driver);
			obj_EsupportUnifiedPortalWorkflow.ChangeEmailInProductAdvisoryAndValidatePopUp(driver);

		}
		catch(Exception e)
		{

			Assert.fail("Failed while TC_9619919_AMER_CH_UnifiedProfile_LKB_Story9590357AdvisoryAlertsMessagingrelatedtochangingpreferredemailaddress_ESUPPORT--------->\n  "+e);

		}

	}
}
