package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_6881266_AMER_FF_IPS_LDellMnAOverviewtabTopSolutions_Esupport extends BaseTest
{
	@Test
	public void validate_TC_6881266_AMER_FF_IPS_LDellMnAOverviewtabTopSolutions_Esupport() 
	{
		try
		{
			System.out.println("Starts TC_6881266_AMER_FF_IPS_LDellMnAOverviewtabTopSolutions_Esupport");
			
			obj_EsupportIPSWorkflow.searchServiceTag(driver, TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
			obj_EsupportIPSWorkflow.verifyOverviewTabServiceTag(driver);
			obj_EsupportIPSWorkflow.verifyTopSolutionsServiceTag(driver);
			obj_EsupportIPSWorkflow.clickReadMoreLink(driver);
			obj_EsupportIPSWorkflow.clickViewAllLink(driver);
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_6881266_AMER_FF_IPS_LDellMnAOverviewtabTopSolutions_Esupport--------->\n  "+e);
		}
	}
}
