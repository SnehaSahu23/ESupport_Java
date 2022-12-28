package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_5784193_AMER_ED_SystemConfigurationCurrentConfiguration_ESUPPORT extends BaseTest 
{
	@Test
	public void validate_TC_5784193_AMER_ED_SystemConfigurationCurrentConfiguration_ESUPPORT() 
	{

		try
		{
			System.out.println("Starts TC_5784193_AMER_ED_SystemConfigurationCurrentConfiguration_ESUPPORT");
			obj_EsupportDriverandDownloadsWorkflow.ToVerify_EnterServiceTage(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));

			obj_EsupportContentWorkflow.TOVerify_NavigationTabs(driver);
			obj_EsupportContentWorkflow.clickSystemConfiguration_Tab(driver);
			obj_EsupportContentWorkflow.verifyCurrentConfiguration(driver);
			obj_EsupportContentWorkflow.clickDetectPCButton(driver);
		}
		catch(Exception e)
		{

			Assert.fail("Failed while TC_5784193_AMER_ED_SystemConfigurationCurrentConfiguration_ESUPPORT--------->\n  "+e);

		}

	}
}

