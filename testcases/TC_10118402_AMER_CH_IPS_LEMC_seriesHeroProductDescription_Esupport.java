package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_10118402_AMER_CH_IPS_LEMC_seriesHeroProductDescription_Esupport extends BaseTest
{
	@Test
	public void validate_TC_10118402_AMER_CH_IPS_LEMC_seriesHeroProductDescription_Esupport() 
	{
		try
		{
			System.out.println("Starts TC_10118402_AMER_CH_IPS_LEMC_seriesHeroProductDescription_Esupport");

			obj_EsupportIPSWorkflow.launchUrl(driver, TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
			
			obj_EsupportIPSWorkflow.ValidateProductDescription(driver);			
			
			
		}
		catch(Exception e)
		{
			Assert.fail("Failed executing TC_10118402_AMER_CH_IPS_LEMC_seriesHeroProductDescription_Esupport--------->\n  "+e);
		}
	}
}