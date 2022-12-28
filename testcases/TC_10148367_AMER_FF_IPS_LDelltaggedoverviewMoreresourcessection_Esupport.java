package com.dell.delta_uat_automation.esupport.testcases;

import com.dell.delta_uat_automation.utility.*;
import org.openqa.selenium.*;
import org.testng.*;
import org.testng.annotations.*;

public class TC_10148367_AMER_FF_IPS_LDelltaggedoverviewMoreresourcessection_Esupport extends BaseTest
{
    @Test
    public void validate_TC_10148367_AMER_FF_IPS_LDelltaggedoverviewMoreresourcessection_Esupport() {
        try {
            System.out.println("Starts TC_10148367_AMER_FF_IPS_LDelltaggedoverviewMoreresourcessection_Esupport");
            this.obj_EsupportIPSWorkflow.searchServiceTag((WebDriver)TC_10148367_AMER_FF_IPS_LDelltaggedoverviewMoreresourcessection_Esupport.driver, (String)TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
            this.obj_EsupportIPSWorkflow.verifyOverviewTabDetails_MoreResources((WebDriver)TC_10148367_AMER_FF_IPS_LDelltaggedoverviewMoreresourcessection_Esupport.driver);
            this.obj_EsupportIPSWorkflow.clickWatchVideosButton((WebDriver)TC_10148367_AMER_FF_IPS_LDelltaggedoverviewMoreresourcessection_Esupport.driver);
            this.obj_EsupportIPSWorkflow.clickVisitKnowledgeBaseButton((WebDriver)TC_10148367_AMER_FF_IPS_LDelltaggedoverviewMoreresourcessection_Esupport.driver);
            this.obj_EsupportIPSWorkflow.clickVisitDellCommunityButton((WebDriver)TC_10148367_AMER_FF_IPS_LDelltaggedoverviewMoreresourcessection_Esupport.driver);
        }
        catch (Exception e) {
            Assert.fail("Failed in TC_10148367_AMER_FF_IPS_LDelltaggedoverviewMoreresourcessection_Esupport--------->\n  " + e);
        }
    }
}