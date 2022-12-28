package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_6602301_AMER_CH_ViewSystemConfigurationOriginalConfiguration_Esupport extends BaseTest
{
	@Test
	public void validate_TC_6602301_AMER_CH_ViewSystemConfigurationOriginalConfiguration_Esupport() 
	{
		try
		{
			System.out.println("Starts TC_6602301_AMER_CH_ViewSystemConfigurationOriginalConfiguration_Esupport");

			//Scenario 1 : L Dell service tag

			obj_EsupportIPSWorkflow.searchServiceTag(driver, TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[0]);
			obj_EsupportIPSWorkflow.clickSystemConfigurationLink(driver);	
			obj_EsupportIPSWorkflow.verifyModalPopupConfiguration(driver);	
			obj_EsupportIPSWorkflow.verifyConfigurationTable(driver);				
			obj_EsupportIPSWorkflow.verifyComponentColumn(driver);
			obj_EsupportIPSWorkflow.verifyPartNumberColumn(driver);
			obj_EsupportIPSWorkflow.verifyDescriptionColumn(driver);
			
			obj_EsupportIPSWorkflow.verifyModalPopupCloseButton(driver);
			
			obj_EsupportIPSWorkflow.clickModalPopupCloseButton(driver);	
			
			//Scenario 2 :  Long Part number 
			
			obj_EsupportIPSWorkflow.clickSystemConfigurationLink(driver);	
			
			obj_EsupportIPSWorkflow.verifyScrollbar(driver);			
			obj_EsupportIPSWorkflow.scrolldownPopup(driver);
			Thread.sleep(5000);
		
			//Scenario 3: M & A 
			for(int i=1; i<=2;i++)
			{
				obj_EsupportIPSWorkflow.navigateToURL(driver);
				obj_EsupportIPSWorkflow.searchServiceTag(driver, TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[i]);
				obj_EsupportIPSWorkflow.clickSystemConfigurationLink(driver);	
				obj_EsupportIPSWorkflow.verifyModalPopup(driver);	
			}
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_6602301_AMER_CH_ViewSystemConfigurationOriginalConfiguration_Esupport--------->\n  "+e);
		}
	}
}


