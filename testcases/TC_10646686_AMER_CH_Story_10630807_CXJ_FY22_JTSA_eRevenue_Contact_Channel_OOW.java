package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_10646686_AMER_CH_Story_10630807_CXJ_FY22_JTSA_eRevenue_Contact_Channel_OOW extends BaseTest
{
    @Test
    public void validate_TC_10646686_AMER_CH_Story_10630807_CXJ_FY22_JTSA_eRevenue_Contact_Channel_OOW()
    {
    	try
    	{
    		System.out.println("Starts TC_10646686_AMER_CH_Story_10630807_CXJ_FY22_JTSA_eRevenue_Contact_Channel_OOW extends");
// 		    obj_EsupportIncidentsWorkflow.ToVerify_EnterServiceTag_HandledPopup(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(",")[0]);
// 		    obj_EsupportIncidentsWorkflow.SelectIssueFromDropDown(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()));
// 		    obj_EsupportIncidentsWorkflow.verifyHardWareSoftwareChannelInNewLayOut(driver);
    		
//    		**************new functionality **************
    		obj_EsupportIncidentsWorkflow.clickOnEnterServiceTag(driver);
         	obj_EsupportIncidentsWorkflow.EnterValueInServiceTagField(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
 			obj_EsupportIncidentsWorkflow.clickOnSubmitButtonAfterEnteringServiceTag(driver);
 			obj_EsupportIncidentsWorkflow.clickOnNextButtonOnProductPage(driver);
 			obj_EsupportIncidentsWorkflow.SelectIssueFromDropDown(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()));
 			obj_EsupportIncidentsWorkflow.clickOnNextButton(driver);
 			obj_EsupportIncidentsWorkflow.verifyTheChannelNewLayOutForIssueType(driver);
    	}
    	catch(Exception e)
		{
			Assert.fail("Failed in TC_10646686_AMER_CH_Story_10630807_CXJ_FY22_JTSA_eRevenue_Contact_Channel_OOW--------->\n  "+e);
		}
    }
}
