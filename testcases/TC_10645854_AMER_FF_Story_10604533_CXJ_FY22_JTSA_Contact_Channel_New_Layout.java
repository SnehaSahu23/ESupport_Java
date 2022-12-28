package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_10645854_AMER_FF_Story_10604533_CXJ_FY22_JTSA_Contact_Channel_New_Layout extends BaseTest 
{
	@Test
	   public void validate_TC_10645854_AMER_FF_Story_10604533_CXJ_FY22_JTSA_Contact_Channel_New_Layout()
	   {
		   try
		   {
			   System.out.println("Starts TC_10645854_AMER_FF_Story_10604533_CXJ_FY22_JTSA_Contact_Channel_New_Layout");
//			   obj_EsupportIncidentsWorkflow.ToVerify_EnterServiceTag_HandledPopup(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(",")[0]);
//			   obj_EsupportIncidentsWorkflow.SelectIssueFromDropDown(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()));
//			   obj_EsupportIncidentsWorkflow.verifyTheChannelNewLayOutForIssueType(driver);
			   
//			   **********new functionality*************
			   
			   obj_EsupportIncidentsWorkflow.clickOnEnterServiceTag(driver);
				obj_EsupportIncidentsWorkflow.EnterValueInServiceTagField(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
				obj_EsupportIncidentsWorkflow.clickOnSubmitButtonAfterEnteringServiceTag(driver);
				obj_EsupportIncidentsWorkflow.SelectIssueFromDropDown(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()));
				obj_EsupportIncidentsWorkflow.clickOnNextButton(driver);
			   obj_EsupportIncidentsWorkflow.verifyTheChannelNewLayOutForIssueType(driver);
		   
		   }
		   catch(Exception e)
			{
				Assert.fail("Failed in TC_10645854_AMER_FF_Story_10604533_CXJ_FY22_JTSA_Contact_Channel_New_Layout--------->\n  "+e);
			}
	   }
}
