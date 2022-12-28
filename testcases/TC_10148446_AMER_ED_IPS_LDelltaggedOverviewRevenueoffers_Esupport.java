package com.dell.delta_uat_automation.esupport.testcases;

import com.dell.delta_uat_automation.utility.*;
import org.openqa.selenium.*;
import org.testng.*;
import org.testng.annotations.*;

public class TC_10148446_AMER_ED_IPS_LDelltaggedOverviewRevenueoffers_Esupport extends BaseTest
{
    @Test
    public void validate_TC_10148446_AMER_ED_IPS_LDelltaggedOverviewRevenueoffers_Esupport() {
        try {
            System.out.println("Starts TC_10148446_AMER_ED_IPS_LDelltaggedOverviewRevenueoffers_Esupport");
            this.obj_EsupportIPSWorkflow.searchServiceTag((WebDriver)TC_10148446_AMER_ED_IPS_LDelltaggedOverviewRevenueoffers_Esupport.driver, (String)TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
            this.obj_EsupportIPSWorkflow.verifyOverviewTabDetails_RevenueOffers((WebDriver)TC_10148446_AMER_ED_IPS_LDelltaggedOverviewRevenueoffers_Esupport.driver);
        }
        catch (Exception e) {
            Assert.fail("Failed in TC_10148446_AMER_ED_IPS_LDelltaggedOverviewRevenueoffers_Esupport--------->\n  " + e);
        }
    }
}