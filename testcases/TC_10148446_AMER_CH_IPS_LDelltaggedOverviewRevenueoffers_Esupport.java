package com.dell.delta_uat_automation.esupport.testcases;

import com.dell.delta_uat_automation.utility.*;
import org.openqa.selenium.*;
import org.testng.*;
import org.testng.annotations.*;

public class TC_10148446_AMER_CH_IPS_LDelltaggedOverviewRevenueoffers_Esupport extends BaseTest
{
    @Test
    public void validate_TC_10148446_AMER_CH_IPS_LDelltaggedOverviewRevenueoffers_Esupport() {
        try {
            System.out.println("Starts TC_10148446_AMER_CH_IPS_LDelltaggedOverviewRevenueoffers_Esupport");
            obj_EsupportIPSWorkflow.searchServiceTag(driver, TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
            obj_EsupportIPSWorkflow.verifyOverviewTabDetails_RevenueOffers(driver);
        }
        catch (Exception e) {
            Assert.fail("Failed in TC_10148446_AMER_CH_IPS_LDelltaggedOverviewRevenueoffers_Esupport--------->\n  " + e);
        }
    }
}