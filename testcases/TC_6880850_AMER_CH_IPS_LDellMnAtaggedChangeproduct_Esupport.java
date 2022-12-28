package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_6880850_AMER_CH_IPS_LDellMnAtaggedChangeproduct_Esupport extends BaseTest
{
	@Test
	public void validate_TC_6880850_AMER_CH_IPS_LDellMnAtaggedChangeproduct_Esupport() 
	{
		try
		{
			System.out.println("Starts TC_6880850_AMER_CH_IPS_LDellMnAtaggedChangeproduct_Esupport");

			obj_EsupportIPSWorkflow.searchServiceTag(driver, TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
			obj_EsupportIPSWorkflow.verifyChangeProductLink(driver);			
			obj_EsupportIPSWorkflow.clickChangeProductLink(driver);

		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_6880850_AMER_CH_IPS_LDellMnAtaggedChangeproduct_Esupport--------->\n  "+e);
		}
	}
}


