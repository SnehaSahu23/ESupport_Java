package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_5780094_AMER_CH_ContactUSSliderColdUserorLdellcustomer_Esupport extends BaseTest 
{
       @Test
       public void validate_TC_5780094_AMER_CH_ContactUSSliderColdUserorLdellcustomer_Esupport() 
       {
             try
             {
                    System.out.println("Starts TC_5780094_AMER_CH_ContactUSSliderColdUserorLdellcustomer_Esupport");
                obj_EsupportIntegratedHomePageWorkflow.handleCookies(driver);
             obj_EsupportIntegratedHomePageWorkflow.handleContactUsSlider(driver);
             }
             catch(Exception e)
             {
                    Assert.fail("Failed while TC_5780094_AMER_CH_ContactUSSliderColdUserorLdellcustomer_Esupport--------->\n  "+e);
             }
       }
}
