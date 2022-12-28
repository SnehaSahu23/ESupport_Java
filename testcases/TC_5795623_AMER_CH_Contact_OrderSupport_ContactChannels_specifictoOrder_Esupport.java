package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_5795623_AMER_CH_Contact_OrderSupport_ContactChannels_specifictoOrder_Esupport extends BaseTest {


              @Test
              public void validate_TC_5795623_AMER_CH_Contact_OrderSupport_ContactChannels_specifictoOrder_Esupport() 
              {
                             try
                             {
                                           System.out.println("Starts TC# 5795623");                         
                                           
                                           obj_EsupportIncidentsWorkflow.ToVerify_ContanctOrderSupport(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
                                           obj_EsupportOrderHomeWorkflow.handleCookies(driver);
                                           obj_EsupportIncidentsWorkflow.enterOrderNumber(driver, TestNGCreator.TestData.get(Esupport.OrderNumber.ordinal()));
                                           obj_EsupportOrderHomeWorkflow.handleCookies(driver);
                                           obj_EsupportIncidentsWorkflow.toCheck_ContanctChannelsavailability(driver);
                                           obj_EsupportIncidentsWorkflow.toVerify_OnlineActionsLinks(driver);
                                           obj_EsupportIncidentsWorkflow.to_OnlineActions_Links(driver);
                                           
                             }
                             catch(Exception e)
                             {
                                           Assert.fail("Failed while executing test case TC_5795623_AMER_CH_Contact_OrderSupport_ContactChannels_specifictoOrder_Esupport--------->\n  "+e);
                             }
              }

}
