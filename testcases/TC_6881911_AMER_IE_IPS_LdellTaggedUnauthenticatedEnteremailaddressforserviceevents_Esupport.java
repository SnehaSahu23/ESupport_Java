package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_6881911_AMER_IE_IPS_LdellTaggedUnauthenticatedEnteremailaddressforserviceevents_Esupport extends BaseTest
{
	@Test
	public void validate_TC_6881911_AMER_IE_IPS_LdellTaggedUnauthenticatedEnteremailaddressforserviceevents_Esupport() 
	{
		try
		{
			System.out.println("Starts TC_6881911_AMER_IE_IPS_LdellTaggedUnauthenticatedEnteremailaddressforserviceevents_Esupport");

			obj_EsupportIPSWorkflow.searchServiceTag(driver, TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));		
			obj_EsupportIPSWorkflow.clickServiceEventsTab(driver);			
			obj_EsupportIPSWorkflow.verifyServiceEventsTabwithEmail(driver);			
			obj_EsupportIPSWorkflow.enterEmailServiceEvents(driver, TestNGCreator.TestData.get(Esupport.Email.ordinal()));
			obj_EsupportIPSWorkflow.clickOverviewTab(driver);
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_6881911_AMER_IE_IPS_LdellTaggedUnauthenticatedEnteremailaddressforserviceevents_Esupport--------->\n  "+e);
		}
	}
}


