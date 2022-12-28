package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.MobileTestNGCreator;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_6780682_AMER_MB_Coveo_AbilityToRemoveSearchFiltersForDriversAndAdvisories_ESUPPORT extends MobilePage
{
	@Test
	public void validate_TC_6780682_AMER_MB_Coveo_AbilityToRemoveSearchFiltersForDriversAndAdvisories_ESUPPORT_ESUPPORT() 
	{
		try
		{
			System.out.println("Starts TC_6780682_AMER_MB_Coveo_AbilityToRemoveSearchFiltersForDriversAndAdvisories_ESUPPORT");
			
			Thread.sleep(6000);
			obj_EsupportMobileWorkflow.handleCookies(driver);
			
			obj_EsupportMobileWorkflow.ClickExtensionsAndPinMobileView(driver);
			obj_EsupportMobileWorkflow.ClickExtensionIconAndSelectDevice(driver, "Samsung_Galaxy_S6_Portrait");
            obj_EsupportMobileWorkflow.Switch_To_Mobile_window(driver);
            Thread.sleep(6000);
			
            obj_EsupportMobileWorkflow.ClickSearchServiceTag(driver,MobileTestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));

            obj_EsupportMobileWorkflow.ClickDocumentationTab(driver);
            obj_EsupportMobileWorkflow.DisplaySearchBox(driver);
            obj_EsupportMobileWorkflow.SearchForManuals(driver,MobileTestNGCreator.TestData.get(Esupport.SearchOption.ordinal()));
            obj_EsupportMobileWorkflow.ClickOnBackToDocumentationTab(driver);
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_6780682_AMER_MB_Coveo_AbilityToRemoveSearchFiltersForDriversAndAdvisories_ESUPPORT--------->\n  "+e);
		}
	}
}
