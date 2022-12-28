package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_10136742_AMER_ED_IPS_TridenttaggedOverviewTab_Esupport extends BaseTest
{
	@Test
	public void validate_TC_10136742_AMER_ED_IPS_TridenttaggedOverviewTab_Esupport() throws Throwable 
	{
		try
		{
			System.out.println("Starts TC_10136742_AMER_ED_IPS_TridenttaggedOverviewTab_Esupport");


			obj_EsupportIPSWorkflow.searchServiceTag(driver, TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
			obj_EsupportIPSWorkflow.verifyOverviewTabDetails_SignInOption(driver);		
			obj_EsupportIPSWorkflow.verifyOverviewTabDetails_SystemAtAGlance(driver);
			
			obj_EsupportIPSWorkflow.verifyOverviewTabDetails_QuickLinks(driver);
			obj_EsupportIPSWorkflow.ContactTechnicalSection(driver);
			obj_EsupportIPSWorkflow.clickContactTechnicalSupportLink(driver);
			
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_10136742_AMER_ED_IPS_TridenttaggedOverviewTab_Esupport--------->\n  "+e);
		}
	}
}
