package com.dell.delta_uat_automation.esupport.testcases;

import com.dell.delta_uat_automation.utility.*;
import org.openqa.selenium.*;
import org.testng.*;
import org.testng.annotations.*;

public class TC_10148367_AMER_CH_IPS_LDelltaggedoverviewMoreresourcessection_Esupport extends BaseTest
{
    @Test
    public void validate_TC_10148367_AMER_CH_IPS_LDelltaggedoverviewMoreresourcessection_Esupport() {
        try 
        {
            System.out.println("Starts TC_10148367_AMER_CH_IPS_LDelltaggedoverviewMoreresourcessection_Esupport");
            
            obj_EsupportIPSWorkflow.searchServiceTag(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
            obj_EsupportIPSWorkflow.verifyOverviewTabDetails_MoreResources(driver);
            obj_EsupportIPSWorkflow.clickWatchVideosButton(driver);
            obj_EsupportIPSWorkflow.clickVisitKnowledgeBaseButton(driver);
            obj_EsupportIPSWorkflow.clickVisitDellCommunityButton(driver);
        }
        catch (Exception e) {
            Assert.fail("Failed in TC_10148367_AMER_CH_IPS_LDelltaggedoverviewMoreresourcessection_Esupport--------->\n  " + e);
        }
    }
}