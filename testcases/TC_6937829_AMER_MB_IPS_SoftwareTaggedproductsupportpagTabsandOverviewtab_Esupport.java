package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.MobileTestNGCreator;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_6937829_AMER_MB_IPS_SoftwareTaggedproductsupportpagTabsandOverviewtab_Esupport extends MobilePage
{
	@Test
	public void validate_TC_6937829_AMER_MB_IPS_SoftwareTaggedproductsupportpagTabsandOverviewtab_Esupport() throws Throwable 
	{
		try
		{
			System.out.println("Starts TC_6937829_AMER_MB_IPS_SoftwareTaggedproductsupportpagTabsandOverviewtab_Esupport");
			Thread.sleep(6000);
			obj_EsupportMobileWorkflow.handleCookies(driver);
			obj_EsupportMobileWorkflow.ClickExtensionsAndPinMobileView(driver);
			obj_EsupportMobileWorkflow.ClickExtensionIconAndSelectDevice(driver, "Samsung_Galaxy_S6_Portrait");
            obj_EsupportMobileWorkflow.Switch_To_Mobile_window(driver);
            Thread.sleep(6000);

            obj_EsupportMobileWorkflow.searchServiceTag_LDELL(driver, MobileTestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
            obj_EsupportMobileWorkflow.verifyHeroSectionSoftwareTaggedProduct(driver);		
            obj_EsupportMobileWorkflow.verifyTabsSupportPage(driver);
			
            obj_EsupportMobileWorkflow.verifyOverviewTabDetails(driver);
			
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_6937829_AMER_MB_IPS_SoftwareTaggedproductsupportpagTabsandOverviewtab_Esupport--------->\n  "+e);
		}
	}
}
