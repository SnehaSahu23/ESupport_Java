package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_6608704_AMER_FF_LDellMnApartsandaccessoriestab_Esupport extends BaseTest
{
	@Test
	public void validate_TC_6608704_AMER_FF_LDellMnApartsandaccessoriestab_Esupport() 
	{
		try
		{
			System.out.println("Starts TC_6608704_AMER_FF_LDellMnApartsandaccessoriestab_Esupport");

			//Scenario 1 :  Parts and accessories available for the service tag

			obj_EsupportIPSWorkflow.searchServiceTag(driver, TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[0]);
			obj_EsupportIPSWorkflow.verifyPartsAccessoriesTab(driver);
			
			obj_EsupportIPSWorkflow.clickPartsAccessoriesTab(driver);
			
			//Scenario 4 : No parts and accessories for the service tag
			obj_EsupportIPSWorkflow.navigateToURL(driver);
			obj_EsupportIPSWorkflow.searchServiceTag(driver, TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[1]);
			obj_EsupportIPSWorkflow.verifyPartsAccessoriesTab(driver);			
			obj_EsupportIPSWorkflow.verifyNoAccessoriesMessage(driver);
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_6608704_AMER_FF_LDellMnApartsandaccessoriestab_Esupport--------->\n  "+e);
		}
	}
}
