package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_6881911_AMER_MB_IPS_LdellTaggedUnauthenticatedEnteremailaddressforserviceevents_Esupport extends BaseTest
{
	@Test
	public void validate_TC_6881911_AMER_MB_IPS_LdellTaggedUnauthenticatedEnteremailaddressforserviceevents_Esupport() 
	{
		try
		{
			System.out.println("Starts TC_6881911_AMER_MB_IPS_LdellTaggedUnauthenticatedEnteremailaddressforserviceevents_Esupport");
			Thread.sleep(6000);
			obj_EsupportMobileWorkflow.handleCookies(driver);
			
			obj_EsupportMobileWorkflow.ClickExtensionIconAndSelectDevice(driver, "Samsung_Galaxy_S6_Portrait");
            obj_EsupportMobileWorkflow.Switch_To_Mobile_window(driver);
            Thread.sleep(6000);
            obj_EsupportMobileWorkflow.searchServiceTag_LDELL(driver, TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));		
            obj_EsupportMobileWorkflow.clickServiceEventsTab(driver);			
            obj_EsupportMobileWorkflow.verifyServiceEventsTabwithEmail(driver);			
            obj_EsupportMobileWorkflow.enterEmailServiceEvents(driver, TestNGCreator.TestData.get(Esupport.Email.ordinal()));
            obj_EsupportMobileWorkflow.clickOverviewTab(driver);
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_6881911_AMER_MB_IPS_LdellTaggedUnauthenticatedEnteremailaddressforserviceevents_Esupport--------->\n  "+e);
		}
	}
}
