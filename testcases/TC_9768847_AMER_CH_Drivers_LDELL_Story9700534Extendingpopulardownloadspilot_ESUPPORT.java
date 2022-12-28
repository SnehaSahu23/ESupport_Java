package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_9768847_AMER_CH_Drivers_LDELL_Story9700534Extendingpopulardownloadspilot_ESUPPORT extends BaseTest
{
	@Test
	public void validate_TC_9768847_AMER_CH_Drivers_LDELL_Story9700534Extendingpopulardownloadspilot_ESUPPORT() 
	{
		try
		{
			System.out.println("Starts TC_9768847_AMER_CH_Drivers_LDELL_Story9700534Extendingpopulardownloadspilot_ESUPPORT");


			obj_EsupportContentWorkflow.ClickSearchProduct(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
		
			obj_EsupportDriverandDownloadsWorkflow.pcfClickDriversandDownloadsTab(driver);
			obj_EsupportDriverandDownloadsWorkflow.validateSortByDropdown(driver);
			obj_EsupportDriverandDownloadsWorkflow.verifyPopularOption(driver);
			
			obj_EsupportDriverandDownloadsWorkflow.SelectPopularOptionAndValidateGrid(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()));
			
			
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_9768847_AMER_CH_Drivers_LDELL_Story9700534Extendingpopulardownloadspilot_ESUPPORT--------->\n  "+e);
		}
	}
}