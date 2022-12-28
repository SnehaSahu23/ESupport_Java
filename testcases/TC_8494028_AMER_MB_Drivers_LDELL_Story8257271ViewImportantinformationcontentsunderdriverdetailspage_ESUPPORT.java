package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.MobileTestNGCreator;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_8494028_AMER_MB_Drivers_LDELL_Story8257271ViewImportantinformationcontentsunderdriverdetailspage_ESUPPORT extends MobilePage
{
	@Test
	public void validate_TC_8494028_AMER_MB_Drivers_LDELL_Story8257271ViewImportantinformationcontentsunderdriverdetailspage_ESUPPORT() 
	{
		try
		{
			System.out.println("Starts TC_8494028_AMER_MB_Drivers_LDELL_Story8257271ViewImportantinformationcontentsunderdriverdetailspage_ESUPPORT");
			Thread.sleep(6000);
			obj_EsupportMobileWorkflow.handleCookies(driver);
			
			obj_EsupportMobileWorkflow.ClickExtensionsAndPinMobileView(driver);
			obj_EsupportMobileWorkflow.ClickExtensionIconAndSelectDevice(driver, "Samsung_Galaxy_S6_Portrait");
            obj_EsupportMobileWorkflow.Switch_To_Mobile_window(driver);
            Thread.sleep(6000);
            obj_EsupportMobileWorkflow.ClickSearchProduct(driver,MobileTestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
			
            obj_EsupportMobileWorkflow.pcfClickDriversandDownloadsTab(driver);
			
            obj_EsupportMobileWorkflow.checkForImportantInformationIcon(driver);
            obj_EsupportMobileWorkflow.ClickOnCollapseButtonOfImportInfoDriver(driver);
            obj_EsupportMobileWorkflow.ClickViewDetailsLinkForFirstDisplayedImportantInformationDriver(driver);
			
			
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_8494028_AMER_MB_Drivers_LDELL_Story8257271ViewImportantinformationcontentsunderdriverdetailspage_ESUPPORT--------->\n  "+e);
		}
	}
}
