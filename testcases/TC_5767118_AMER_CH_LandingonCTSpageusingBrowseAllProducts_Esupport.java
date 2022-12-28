package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_5767118_AMER_CH_LandingonCTSpageusingBrowseAllProducts_Esupport extends BaseTest 
{
       @Test
       public void validate_TC_5767118_AMER_CH_LandingonCTSpageusingBrowseAllProducts_Esupport() 
       {
             try
             {
                    System.out.println("Starts TC_5767118_AMER_CH_LandingonCTSpageusingBrowseAllProducts_Esupport");
                    
                    obj_EsupportIncidentsWorkflow.selectProduct(driver);
             }
             catch(Exception e)
             {
                    Assert.fail("Failed in TC_5767118_AMER_CH_LandingonCTSpageusingBrowseAllProducts--------->\n  "+e);
             }
       }
}
