package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_10136349_AMER_CH_IPS_TridenttaggedOverviewTabMoreresources_Esupport extends BaseTest
{
	@Test
	public void validate_TC_10136349_AMER_CH_IPS_TridenttaggedOverviewTabMoreresources_Esupport() throws Throwable 
	{
		try
		{
			System.out.println("Starts TC_10136349_AMER_CH_IPS_TridenttaggedOverviewTabMoreresources_Esupport");


			obj_EsupportIPSWorkflow.searchServiceTag(driver, TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
			obj_EsupportIPSWorkflow.verifyOverviewTabDetails_MoreResources(driver);		
			obj_EsupportIPSWorkflow.clickWatchVideosButton(driver);
			
			obj_EsupportIPSWorkflow.clickVisitKnowledgeBaseButton(driver);
			obj_EsupportIPSWorkflow.clickVisitDellCommunityButton(driver);
			
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_10136349_AMER_CH_IPS_TridenttaggedOverviewTabMoreresources_Esupport--------->\n  "+e);
		}
	}
}
