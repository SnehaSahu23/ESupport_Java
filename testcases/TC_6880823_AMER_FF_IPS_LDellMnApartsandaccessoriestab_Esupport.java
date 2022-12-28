package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_6880823_AMER_FF_IPS_LDellMnApartsandaccessoriestab_Esupport extends BaseTest
{
	@Test
	public void validate_TC_6880823_AMER_FF_IPS_LDellMnApartsandaccessoriestab_Esupport() 
	{
		try
		{
			System.out.println("Starts TC_6880823_AMER_FF_IPS_LDellMnApartsandaccessoriestab_Esupport");

			obj_EsupportIPSWorkflow.searchServiceTag(driver, TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
			obj_EsupportIPSWorkflow.verifyPartsAccessoriesTab(driver);			
			obj_EsupportIPSWorkflow.clickPartsAccessoriesTab(driver);	
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_6880823_AMER_FF_IPS_LDellMnApartsandaccessoriestab_Esupport--------->\n  "+e);
		}
	}
}
