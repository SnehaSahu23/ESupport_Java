package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_5781370_AMER_IE_ContactChannelsPage_Esupport extends BaseTest {

      @Test
      public void validate_TC_5781370_AMER_IE_ProductDetailsOnCTSPage_Esupport() 
      {

            try
            {
                  System.out.println("Starts TC_5781370_AMER_IE_ProductDetailsOnCTSPage_Esupport");
                  
            obj_EsupportIncidentsWorkflow.ToVerify_EnterServiceTag(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
                  obj_EsupportIncidentsWorkflow.Click_IssueType(driver);
                  obj_EsupportIncidentsWorkflow.verifyContactChannels(driver);
                  
                  
            }
            catch(Exception e)
            {

                  Assert.fail("Failed while TC_5781370_AMER_IE_ProductDetailsOnCTSPage_Esupport--------->\n  "+e);

            }

      }
}
