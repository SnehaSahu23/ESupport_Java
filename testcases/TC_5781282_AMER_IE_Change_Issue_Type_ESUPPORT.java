package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_5781282_AMER_IE_Change_Issue_Type_ESUPPORT extends BaseTest 
{
       @Test
       public void validate_TC_5781282_AMER_IE_Change_Issue_Type_ESUPPORT() 
       {

             try
             {
                    System.out.println("Starts TC_5781282_AMER_IE_Change_Issue_Type_ESUPPORT");
                    obj_EsupportIncidentsWorkflow.ToVerify_EnterServiceTag(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
                    obj_EsupportIncidentsWorkflow.Click_IssueType(driver);
                    obj_EsupportIncidentsWorkflow.Click_ChangeIssueLink(driver);
                    
                    
             }
             catch(Exception e)
             {

                    Assert.fail("Failed while TC_5781282_AMER_IE_Change_Issue_Type_ESUPPORT--------->\n  "+e);

             }

       }
}
