package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_10646570_AMER_FF_Story_10604613_CXJ_FY22_JTSA_Contact_Channel_Responsive_Layout extends BaseTest
{
	@Test
	public void validate_TC_10646570_AMER_FF_Story_10604613_CXJ_FY22_JTSA_Contact_Channel_Responsive_Layout()
	{
		try
		{
			System.out.println("Starts TC_10646570_AMER_FF_Story_10604613_CXJ_FY22_JTSA_Contact_Channel_Responsive_Layout");
//			obj_EsupportIncidentsWorkflow.handleCookies(driver);
//			obj_EsupportIncidentsWorkflow.ToVerify_EnterServiceTag_HandledPopup(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(",")[0]);
//			obj_EsupportIncidentsWorkflow.SelectIssueFromDropDown(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()));
//			obj_EsupportIncidentsWorkflow.verifyTheChannelNewLayOutForIssueType(driver);
			
		    obj_EsupportIncidentsWorkflow.clickOnEnterServiceTag(driver);
        	obj_EsupportIncidentsWorkflow.EnterValueInServiceTagField(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
			obj_EsupportIncidentsWorkflow.clickOnSubmitButtonAfterEnteringServiceTag(driver);
			obj_EsupportIncidentsWorkflow.SelectIssueFromDropDown(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()));
			obj_EsupportIncidentsWorkflow.clickOnNextButton(driver);
			obj_EsupportIncidentsWorkflow.verifyTheChannelNewLayOutForIssueType(driver);
        }
		catch(Exception e)
		{
			Assert.fail("Failed in TC_10646570_AMER_FF_Story_10604613_CXJ_FY22_JTSA_Contact_Channel_Responsive_Layout--------->\n  "+e);
		}
	}
}
