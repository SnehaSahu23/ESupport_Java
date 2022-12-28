package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.MobileTestNGCreator;

public class TC_5836796_AMER_MB_ChecksumLink_ESUPPORT extends MobilePage {
    @Test
    public void validate_TC_5836796_AMER_CH_ChecksumLink_ESUPPORT() 
    {

            try
            {
                    System.out.println("Starts TC# 5836796");
                    Thread.sleep(6000);
        			obj_EsupportMobileWorkflow.handleCookies(driver);
        			obj_EsupportMobileWorkflow.ClickExtensionsAndPinMobileView(driver);
        			obj_EsupportMobileWorkflow.ClickExtensionIconAndSelectDevice(driver, "Samsung_Galaxy_S6_Portrait");
                    obj_EsupportMobileWorkflow.Switch_To_Mobile_window(driver);
                    Thread.sleep(6000);
                    obj_EsupportMobileWorkflow.clickSignIn(driver);

                    obj_EsupportMobileWorkflow.ToLogin_ValidCredentials(driver,MobileTestNGCreator.TestData.get(Esupport.Username.ordinal()),MobileTestNGCreator.TestData.get(Esupport.Password.ordinal()));
                    
                    obj_EsupportMobileWorkflow.ToVerify_EnterServiceTagsonly(driver, MobileTestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
                    obj_EsupportMobileWorkflow.ToVerify_clickDriverDownloads(driver);
                
                    Thread.sleep(3000);
                    obj_EsupportMobileWorkflow.signOut(driver);

            }
            catch(Exception e){

                    Assert.fail("Failed while executing test case TC_5836796_AMER_CH_ChecksumLink_ESUPPORT--------->\n  "+e);

            }

    }

}
