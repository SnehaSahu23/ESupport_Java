package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_9267620_AMER_CH_Drivers_LEMC_SmokeTesting extends BaseTest
{
	@Test
	public void validate_TC_9267620_AMER_CH_Drivers_LEMC_SmokeTesting() 
	{
		try
		{
			System.out.println("Starts TC_9267620_AMER_CH_Drivers_LEMC_SmokeTesting");
				
			
			obj_EsupportIPSWorkflow.ClickSignInButton(driver);
			obj_EsupportIPSWorkflow.Emaillogin(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));

			obj_EsupportContentWorkflow.ClickSearchServiceTag(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
			
			obj_EsupportDriverandDownloadsWorkflow.pcfClickDriversandDownloadsTab(driver);
			
			obj_EsupportDriverandDownloadsWorkflow.ValidateVersionsDisplayed(driver);
			
			obj_EsupportDriverandDownloadsWorkflow.ClickOnAnyVersionAndVerifyDriversGrid(driver);
			
			
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_9267620_AMER_CH_Drivers_LEMC_SmokeTesting--------->\n  "+e);
		}
	}
}
