package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_10645518_AMER_ED_Story_10604530_CXJ_FY22_JTSA_Contact_Channel_Layout_Grayed_Out_Channels extends BaseTest
{
	@Test
	public void validate_TC_10645518_AMER_ED_Story_10604530_CXJ_FY22_JTSA_Contact_Channel_Layout_Grayed_Out_Channels()
	{
		try 
		{
			System.out.println("Starts TC_10645518_AMER_ED_Story_10604530_CXJ_FY22_JTSA_Contact_Channel_Layout_Grayed_Out_Channels");
//			obj_EsupportIncidentsWorkflow.ToVerify_EnterServiceTag_HandledPopup(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
//			obj_EsupportIncidentsWorkflow.SelectIssueFromDropDown(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()));
//			obj_EsupportIncidentsWorkflow.verifyTheGrayedOutChannelsForSelectedIssue(driver);
			
			//New functionality
			obj_EsupportIncidentsWorkflow.clickOnEnterServiceTag(driver);
			obj_EsupportIncidentsWorkflow.EnterValueInServiceTagField(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
			obj_EsupportIncidentsWorkflow.clickOnSubmitButtonAfterEnteringServiceTag(driver);
//			obj_EsupportIncidentsWorkflow.clickOnNextButtonOnProductPage(driver);
			obj_EsupportIncidentsWorkflow.SelectIssueFromDropDown(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()));
			obj_EsupportIncidentsWorkflow.clickOnNextButton(driver);
			obj_EsupportIncidentsWorkflow.verifyTheGrayedOutChannelsForSelectedIssue(driver);
		}
		catch(Exception e)
		{
			Assert.fail("Failed while TC_10645518_AMER_ED_Story_10604530_CXJ_FY22_JTSA_Contact_Channel_Layout_Grayed_Out_Channels--------->\n  "+e);
		}
	}
}
