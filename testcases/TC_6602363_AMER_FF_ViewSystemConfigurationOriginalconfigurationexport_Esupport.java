package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_6602363_AMER_FF_ViewSystemConfigurationOriginalconfigurationexport_Esupport extends BaseTest
{
	@Test
	public void validate_TC_6602363_AMER_FF_ViewSystemConfigurationOriginalconfigurationexport_Esupport() 
	{
		try
		{
			System.out.println("Starts TC_6602363_AMER_FF_ViewSystemConfigurationOriginalconfigurationexport_Esupport");

			//Scenario 1 : L Dell service tag

			obj_EsupportIPSWorkflow.searchServiceTag(driver, TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[0]);
			obj_EsupportIPSWorkflow.clickSystemConfigurationLink(driver);	
			obj_EsupportIPSWorkflow.verifyModalPopupConfiguration(driver);	
			obj_EsupportIPSWorkflow.verifyExportOption(driver);	
			obj_EsupportIPSWorkflow.clickExportOption(driver);	

			//Scenario 2:  M & A Products

			for(int i=1;i<=2;i++)
			{
				obj_EsupportIPSWorkflow.navigateToURL(driver);
				obj_EsupportIPSWorkflow.searchServiceTag(driver, TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[i]);
				obj_EsupportIPSWorkflow.clickSystemConfigurationLink(driver);	
				obj_EsupportIPSWorkflow.verifyModalPopup(driver);	
				obj_EsupportIPSWorkflow.verifyExportOption(driver);	
				obj_EsupportIPSWorkflow.clickExportOption(driver);	
			}
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_6602363_AMER_FF_ViewSystemConfigurationOriginalconfigurationexport_Esupport--------->\n  "+e);
		}
	}
}
