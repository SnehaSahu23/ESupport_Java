package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_8433874_AMER_MB_Drivers_Story7568846EnablingMultipleDownloadsForLEMC_ESUPPORT extends BaseTest
{
	@Test
	public void validate_TC_8433874_AMER_MB_Drivers_Story7568846EnablingMultipleDownloadsForLEMC_ESUPPORT() 
	{
		try
		{
			System.out.println("Starts TC_8433874_AMER_MB_Drivers_Story7568846EnablingMultipleDownloadsForLEMC_ESUPPORT");
				
			Thread.sleep(6000);
			obj_EsupportMobileWorkflow.handleCookies(driver);
			
			obj_EsupportMobileWorkflow.ClickExtensionIconAndSelectDevice(driver, "Samsung_Galaxy_S6_Portrait");
            obj_EsupportMobileWorkflow.Switch_To_Mobile_window(driver);
            Thread.sleep(6000);
            obj_EsupportMobileWorkflow.clickSignIn(driver);
            obj_EsupportMobileWorkflow.Emaillogin(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));

            obj_EsupportMobileWorkflow.ClickSearchServiceTag(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
			
            obj_EsupportMobileWorkflow.pcfClickDriversandDownloadsTab(driver);
			
						
            obj_EsupportMobileWorkflow.pcfSelectMultipleDrivers(driver);
			
			
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_8433874_AMER_MB_Drivers_Story7568846EnablingMultipleDownloadsForLEMC_ESUPPORT--------->\n  "+e);
		}
	}
}
