package com.dell.delta_uat_automation.esupport.testcases;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;
public class TC_D9206585_AMER_CH_DriversNotifications_Edit_Review_Subscription_Save_ESUPPORT  extends BaseTest 
{
    @Test
    public void validate_TC_D9206585_AMER_CH_DriversNotifications_Edit_Review_Subscription_Save_ESUPPORT() 
    {

            try
            {
                    System.out.println("Starts TC_D9206585_AMER_DriversNotifications_Edit_Review_Subscription_Save");
                    obj_EsupportDriverandDownloadsWorkflow.ClickSignIn(driver);
                    obj_EsupportDriverandDownloadsWorkflow.Login(driver);
                    obj_EsupportDriverandDownloadsWorkflow.handleCookies(driver);
                    obj_EsupportDriverandDownloadsWorkflow.handleCookies(driver);
                    obj_EsupportDriverandDownloadsWorkflow.clickBrowseAllProductsLink(driver);
                    obj_EsupportDriverandDownloadsWorkflow.clickLaptops(driver);
                    obj_EsupportDriverandDownloadsWorkflow.clickLatitude(driver);
                    obj_EsupportDriverandDownloadsWorkflow.clickLatitudeE4200(driver);
                    System.out.println("Clicked on Latitude E4200");                 
                    obj_EsupportDriverandDownloadsWorkflow.handleCookies(driver);
                    obj_EsupportDriverandDownloadsWorkflow.ClickDriversandDownloads_Tab(driver);
                    obj_EsupportDriverandDownloadsWorkflow.ReviewSubscription(driver);
                    



            }
            catch(Exception e)
            {

                    Assert.fail("Failed while executing TC_D9206585_AMER_CH_DriversNotifications_Edit_Review_Subscription_Save_ESUPPORT--------->\n  "+e);

            }

    }
}