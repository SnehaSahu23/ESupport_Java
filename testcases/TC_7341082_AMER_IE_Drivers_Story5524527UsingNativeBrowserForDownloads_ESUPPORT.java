package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_7341082_AMER_IE_Drivers_Story5524527UsingNativeBrowserForDownloads_ESUPPORT extends BaseTest
{
	@Test
	public void validate_TC_7341082_AMER_IE_Drivers_Story5524527UsingNativeBrowserForDownloads_ESUPPORT() 
	{
		try
		{
			System.out.println("Starts TC_7341082_AMER_IE_Drivers_Story5524527UsingNativeBrowserForDownloads_ESUPPORT");
				
			
			obj_EsupportIncidentsWorkflow.clickSignIn(driver);
			obj_EsupportIPSWorkflow.Emaillogin(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));

			obj_EsupportContentWorkflow.ClickSearchServiceTag(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
			
			obj_EsupportDriverandDownloadsWorkflow.pcfClickDriversandDownloadsTab(driver);
			
			obj_EsupportDriverandDownloadsWorkflow.ClickDownloadButtonForLEMCProduct(driver);
			
			
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_7341082_AMER_IE_Drivers_Story5524527UsingNativeBrowserForDownloads_ESUPPORT--------->\n  "+e);
		}
	}
}
