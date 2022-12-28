package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.MobileTestNGCreator;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_6938038_AMER_MB_IPS_SoftwareuntaggedproductsupportpageOverviewtab_Esupport extends MobilePage
{
	@Test
	public void validate_TC_6938038_AMER_MB_IPS_SoftwareuntaggedproductsupportpageOverviewtab_Esupport() throws Throwable 
	{
		try
		{
			System.out.println("Starts TC_6938038_AMER_MB_IPS_SoftwareuntaggedproductsupportpageOverviewtab_Esupport");
			Thread.sleep(6000);
			obj_EsupportMobileWorkflow.handleCookies(driver);
			obj_EsupportMobileWorkflow.ClickExtensionsAndPinMobileView(driver);
			obj_EsupportMobileWorkflow.ClickExtensionIconAndSelectDevice(driver, "Samsung_Galaxy_S6_Portrait");
            obj_EsupportMobileWorkflow.Switch_To_Mobile_window(driver);
            Thread.sleep(6000);

            obj_EsupportMobileWorkflow.clickBrowseAllProductsLink(driver);
//            obj_EsupportMobileWorkflow.clickSoftwareLink(driver);
//            obj_EsupportMobileWorkflow.clickUtilitiesLink(driver);
//			
//			obj_EsupportMobileWorkflow.clickLatitudeSubProduct(driver,MobileTestNGCreator.TestData.get(Esupport.SearchOption.ordinal()));
			obj_EsupportMobileWorkflow.SelectProductFromBrowseAll(driver);
			Thread.sleep(20000);
			obj_EsupportMobileWorkflow.verifyHeroSectionSoftwareTaggedProduct_two(driver);	
			
			obj_EsupportMobileWorkflow.verifyOverviewTabDetails_EnterServiceTag(driver);
			obj_EsupportMobileWorkflow.verifyEnterServiceTagLink(driver);
			obj_EsupportMobileWorkflow.verifyChangeProductLink(driver);
			
			obj_EsupportMobileWorkflow.clickEnterServiceTagLink(driver);
			obj_EsupportMobileWorkflow.clickEnterServiceTagPopupCloseButton(driver);			
			
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_6938038_AMER_MB_IPS_SoftwareuntaggedproductsupportpageOverviewtab_Esupport--------->\n  "+e);
		}
	}
}
