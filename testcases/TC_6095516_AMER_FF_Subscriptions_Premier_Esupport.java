package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_6095516_AMER_FF_Subscriptions_Premier_Esupport extends BaseTest {

	
    @Test
     public void validate_TC_6095516_AMER_FF_Subscriptions_Premier_Esupport() 
     {

             try
             {
                     System.out.println("Starts TC_6095516_AMER_FF_Subscriptions_Premier_Esupport");
                     
                     System.out.println("Subscription Page.");
                     
                     obj_EsupportSubscriptionWorkflow.handleCookies(driver);
                     obj_EsupportSubscriptionWorkflow.ClickPremierSignIn(driver);
             obj_EsupportSubscriptionWorkflow.premierLogin(driver,TestNGCreator.TestData.get(Esupport.Account.ordinal()));
                     
                     

             
                     
                     

             }
             catch(Exception e){

                     Assert.fail("Failed while executing test case TC_6095516_AMER_FF_Subscriptions_Premier_Esupport--------->\n  "+e);

             }

     }
}
