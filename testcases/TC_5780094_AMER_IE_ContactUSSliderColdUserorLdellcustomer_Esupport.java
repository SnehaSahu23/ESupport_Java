package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_5780094_AMER_IE_ContactUSSliderColdUserorLdellcustomer_Esupport extends BaseTest 
{
    @Test
    public void validate_TC_5780094_AMER_IE_ContactUSSliderColdUserorLdellcustomer_Esupport() 
    {
          try
          {
                 System.out.println("Starts TC_5780094_AMER_IE_ContactUSSliderColdUserorLdellcustomer_Esupport");
             obj_EsupportIntegratedHomePageWorkflow.handleCookies(driver);
          obj_EsupportIntegratedHomePageWorkflow.handleContactUsSlider(driver);
          }
          catch(Exception e)
          {
                 Assert.fail("Failed while TC_5780094_AMER_IE_ContactUSSliderColdUserorLdellcustomer_Esupport--------->\n  "+e);
          }
    }
}
