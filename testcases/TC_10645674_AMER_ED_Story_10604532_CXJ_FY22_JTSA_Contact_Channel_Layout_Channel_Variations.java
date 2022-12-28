package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_10645674_AMER_ED_Story_10604532_CXJ_FY22_JTSA_Contact_Channel_Layout_Channel_Variations extends BaseTest
{
	@Test
	   public void Validate_TC_10645674_AMER_ED_Story_10604532_CXJ_FY22_JTSA_Contact_Channel_Layout_Channel_Variations()
	   {
		   try
		   {
			   System.out.println("Starts Validate_TC_10645674_AMER_ED_Story_10604532_CXJ_FY22_JTSA_Contact_Channel_Layout_Channel_Variations");
//			   obj_EsupportIncidentsWorkflow.ToVerify_EnterServiceTag_HandledPopup(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
//			    obj_EsupportIncidentsWorkflow.SelectIssueFromDropDown(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()));
//				obj_EsupportIncidentsWorkflow.verifyTheChannelNewLayOutForIssueType(driver);
				
			
				   obj_EsupportIncidentsWorkflow.clickOnEnterServiceTag(driver);
					obj_EsupportIncidentsWorkflow.EnterValueInServiceTagField(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
					obj_EsupportIncidentsWorkflow.clickOnSubmitButtonAfterEnteringServiceTag(driver);
					obj_EsupportIncidentsWorkflow.SelectIssueFromDropDown(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()));
					obj_EsupportIncidentsWorkflow.clickOnNextButton(driver);
					obj_EsupportIncidentsWorkflow.verifyTheChannelNewLayOutForIssueType(driver);		   
				}
		   catch(Exception e)
		   {
			   Assert.fail("Failed while TC_10645674_AMER_ED_Story_10604532_CXJ_FY22_JTSA_Contact_Channel_Layout_Channel_Variations--------->\n  "+e);
		   }
	   }
}
