package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_9620032_AMER_FF_UnifiedProfile_LKB_Story9590435EditUserSettingsMessagingrelatedtochangingpreferredemailaddress_ESUPPORT extends BaseTest
{
	@Test
	public void validate_TC_9620032_AMER_FF_UnifiedProfile_LKB_Story9590435EditUserSettingsMessagingrelatedtochangingpreferredemailaddress_ESUPPORT() 
	{
		try
		{
			System.out.println("Starts TC_9620032_AMER_FF_UnifiedProfile_LKB_Story9590435EditUserSettingsMessagingrelatedtochangingpreferredemailaddress_ESUPPORT");
			Thread.sleep(10000);	
			obj_EsupportUnifiedPortalWorkflow.handleCookies(driver);
			obj_EsupportIPSWorkflow.Emaillogin(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			Thread.sleep(6000);	
			obj_EsupportUnifiedPortalWorkflow.clickUserSettingsTab(driver);
			Thread.sleep(6000);	
			obj_EsupportUnifiedPortalWorkflow.editPersonalPreferenceAlternateEmail_ValidatePopUp(driver, TestNGCreator.TestData.get(Esupport.Email.ordinal()));
			
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_9620032_AMER_FF_UnifiedProfile_LKB_Story9590435EditUserSettingsMessagingrelatedtochangingpreferredemailaddress_ESUPPORT--------->\n  "+e);
		}
	}
}
