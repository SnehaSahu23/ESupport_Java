package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_5781178_AMER_CH_Issue_List_Of_product_ESUPPORT extends BaseTest 
{
	@Test
    public void validate_TC_5781178_AMER_CH_Issue_List_Of_Product_ESUPPORT() 
    {

          try
          {
                 System.out.println("Starts TC_5781178_AMER_CH_Issue_List_Of_Product_ESUPPORT");
                 obj_EsupportIncidentsWorkflow.ToVerify_EnterServiceTag(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
                 obj_EsupportIncidentsWorkflow.Click_IssueType(driver);
                 
                 
          }
          catch(Exception e)
          {

                 Assert.fail("Failed while TC_5781178_AMER_CH_Issue_List_Of_Product_ESUPPORT--------->\n  "+e);

          }

    }

}


