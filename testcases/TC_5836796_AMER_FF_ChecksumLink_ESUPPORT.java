package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_5836796_AMER_FF_ChecksumLink_ESUPPORT extends BaseTest {
    @Test
    public void validate_TC_5836796_AMER_FF_ChecksumLink_ESUPPORT() 
    {

            try
            {
                    System.out.println("Starts TC# TC_5836796_AMER_FF_ChecksumLink_ESUPPORT");
                    
//                    obj_EsupportCoveoWorkflow.ClickSignIn(driver);
                    obj_EsupportCoveoWorkflow.EmployeeLogin(driver, TestNGCreator.TestData.get(Esupport.Username.ordinal()).split(";")[0],TestNGCreator.TestData.get(Esupport.Password.ordinal()).split(";")[0]);
                    
                    obj_EsupportCoveoWorkflow.ToVerify_EnterServiceTagsonly(driver, TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
                    obj_EsupportCoveoWorkflow.ToVerify_clickDriverDownloads(driver);
                
                    Thread.sleep(3000);
                    obj_EsupportIPSWorkflow.signOut(driver);

            }
            catch(Exception e){

                    Assert.fail("Failed while executing test case TC_5836796_AMER_FF_ChecksumLink_ESUPPORT--------->\n  "+e);

            }

    }

}
