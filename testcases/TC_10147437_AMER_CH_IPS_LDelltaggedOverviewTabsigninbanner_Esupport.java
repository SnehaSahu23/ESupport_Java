package com.dell.delta_uat_automation.esupport.testcases;

import com.dell.delta_uat_automation.utility.*;
import org.openqa.selenium.*;
import org.testng.*;
import org.testng.annotations.*;

public class TC_10147437_AMER_CH_IPS_LDelltaggedOverviewTabsigninbanner_Esupport extends BaseTest
{
    @Test
    public void validate_TC_10147437_AMER_CH_IPS_LDelltaggedOverviewTabsigninbanner_Esupport() {
        try
        {
            System.out.println("Starts TC_10147437_AMER_CH_IPS_LDelltaggedOverviewTabsigninbanner_Esupport");
            
            obj_EsupportIPSWorkflow.searchServiceTag(driver, (String)TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
            obj_EsupportIPSWorkflow.verifyOverviewTabDetails_SignInOption(driver);
            obj_EsupportIPSWorkflow.clickOnSignInButtonInOverviewTab(driver);
        }
        catch (Exception e) {
            Assert.fail("Failed in TC_10147437_AMER_CH_IPS_LDelltaggedOverviewTabsigninbanner_Esupport--------->\n  " + e);
        }
    }
}