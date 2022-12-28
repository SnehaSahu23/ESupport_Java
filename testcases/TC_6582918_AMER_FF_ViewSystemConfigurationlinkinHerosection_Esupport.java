package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_6582918_AMER_FF_ViewSystemConfigurationlinkinHerosection_Esupport extends BaseTest
{
	@Test
	public void validate_TC_6582918_AMER_FF_ViewSystemConfigurationlinkinHerosection_Esupport() 
	{
		try
		{
			System.out.println("Starts TC_6582918_AMER_FF_ViewSystemConfigurationlinkinHerosection_Esupport");
			obj_EsupportIPSWorkflow.searchServiceTag(driver, TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[0]);
			obj_EsupportIPSWorkflow.clickSystemConfigurationLink(driver);	
			obj_EsupportIPSWorkflow.verifyModalPopupConfiguration(driver);	
			obj_EsupportIPSWorkflow.navigateToURL(driver);
			obj_EsupportIPSWorkflow.searchServiceTag(driver, TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[1]);
			obj_EsupportIPSWorkflow.clickSystemConfigurationLink(driver);	
			obj_EsupportIPSWorkflow.verifyModalPopupConfiguration(driver);
			obj_EsupportIPSWorkflow.navigateToURL(driver);
			obj_EsupportIPSWorkflow.searchServiceTag(driver, TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[2]);
			obj_EsupportIPSWorkflow.clickSystemConfigurationLink(driver);	
			obj_EsupportIPSWorkflow.verifyModalPopupConfiguration(driver);
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_6582918_AMER_FF_ViewSystemConfigurationlinkinHerosection_Esupport--------->\n  "+e);
		}
	}
}