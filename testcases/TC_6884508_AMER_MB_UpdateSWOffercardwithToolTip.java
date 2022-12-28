package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_6884508_AMER_MB_UpdateSWOffercardwithToolTip extends BaseTest
{
	@Test
	public void validate_TC_6884508_AMER_MB_UpdateSWOffercardwithToolTip() 
	{
		try
		{
			System.out.println("Starts TC_6884508_AMER_MB_UpdateSWOffercardwithToolTip");
			
			Thread.sleep(6000);
			obj_EsupportMobileWorkflow.handleCookies(driver);
			
			obj_EsupportMobileWorkflow.ClickExtensionIconAndSelectDevice(driver, "Samsung_Galaxy_S6_Portrait");
            obj_EsupportMobileWorkflow.Switch_To_Mobile_window(driver);
            Thread.sleep(6000);
			
            obj_EsupportMobileWorkflow.searchServiceTag(driver, TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
			obj_EsupportMobileWorkflow.verifyTooltipSoftwareSection(driver);
            obj_EsupportMobileWorkflow.clickTooltipSoftwareSection(driver);
            obj_EsupportMobileWorkflow.verifyTooltipTextDisabled(driver);
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_6884508_AMER_MB_UpdateSWOffercardwithToolTip--------->\n  "+e);
		}
	}
}
