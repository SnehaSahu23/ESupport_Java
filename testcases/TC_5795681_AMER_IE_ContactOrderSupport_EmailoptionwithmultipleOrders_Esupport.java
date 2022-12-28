package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_5795681_AMER_IE_ContactOrderSupport_EmailoptionwithmultipleOrders_Esupport extends BaseTest
{
        @Test
        public void validate_TC_5795681_AMER_IE_ContactOrderSupport_EmailoptionwithmultipleOrders_Esupport() 
        {
                try
                {
                        System.out.println("Starts TC_5795681_AMER_IE_ContactOrderSupport_EmailoptionwithmultipleOrders_Esupport");
                        
                        obj_EsupportIncidentsWorkflow.ToVerify_ContactOrderSupport(driver);
                        obj_EsupportIncidentsWorkflow.search_OrderNumber(driver, TestNGCreator.TestData.get(Esupport.OrderNumber.ordinal()));
                        obj_EsupportIncidentsWorkflow.handleCookies(driver);
                      obj_EsupportIncidentsWorkflow.toCheck_ContactChannelsavailability(driver);
                        obj_EsupportIncidentsWorkflow.cancelEmailForm(driver);
                        obj_EsupportIncidentsWorkflow.fillEmailForm(driver);
                        Thread.sleep(6000);
                }
                catch(Exception e)
                {
                        Assert.fail("Failed in TC_5795681_AMER_IE_ContactOrderSupport_EmailoptionwithmultipleOrders_Esupport --------->\n  "+e);
                }
        }

}
