package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.MobileTestNGCreator;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_10147437_AMER_MB_IPS_LDelltaggedOverviewTabsigninbanner_Esupport extends MobilePage
{
    @Test
    public void validate_TC_10147437_AMER_MB_IPS_LDelltaggedOverviewTabsigninbanner_Esupport() {
        try
        {
            System.out.println("Starts TC_10147437_AMER_MB_IPS_LDelltaggedOverviewTabsigninbanner_Esupport");
            
            Thread.sleep(6000);
			obj_EsupportMobileWorkflow.handleCookies(driver);
			
			obj_EsupportMobileWorkflow.ClickExtensionsAndPinMobileView(driver);
			obj_EsupportMobileWorkflow.ClickExtensionIconAndSelectDevice(driver, "Samsung_Galaxy_S6_Portrait");
            obj_EsupportMobileWorkflow.Switch_To_Mobile_window(driver);
            Thread.sleep(6000);
            obj_EsupportMobileWorkflow.searchServiceTag_LDELL(driver, (String)MobileTestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
            obj_EsupportMobileWorkflow.verifyOverviewTabDetails_SignInOption(driver);
            obj_EsupportMobileWorkflow.clickOnSignInButtonInOverviewTab(driver);
        }
        catch (Exception e) {
            Assert.fail("Failed in TC_10147437_AMER_MB_IPS_LDelltaggedOverviewTabsigninbanner_Esupport--------->\n  " + e);
        }
    }
}