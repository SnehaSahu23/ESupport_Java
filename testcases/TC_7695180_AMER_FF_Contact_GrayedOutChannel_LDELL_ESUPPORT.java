package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_7695180_AMER_FF_Contact_GrayedOutChannel_LDELL_ESUPPORT extends BaseTest 
{
	@Test
	public void validate_TC_7695180_AMER_FF_Contact_GrayedOutChannel_LDELL_ESUPPORT() 
	{

		try
		{
			System.out.println("Starts TC_7695180_AMER_FF_Contact_GrayedOutChannel_LDELL_ESUPPORT");
			//driver.get("https://www.dell.com/support/incidents-online/us/en/04/ContactUs/");
			obj_EsupportIncidentsWorkflow.ClickOnAnyOFContactChannelsBeforeSearchingForProductOrTag(driver);
			
			obj_EsupportIncidentsWorkflow.ToVerify_EnterServiceTag_HandledPopup(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
			
			obj_EsupportIncidentsWorkflow.ClickOnAnyOFContactChannelsAfterSearchingForProductOrTag(driver);
			
			
			obj_EsupportIncidentsWorkflow.SelectIssueFromDropDown(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()));
			
			obj_EsupportIncidentsWorkflow.ClickOnAnyOFContactChannelsAfterSelectingIssueFromDropDown(driver);
			
			
		}
		catch(Exception e)
		{

			Assert.fail("Failed while TC_7695180_AMER_FF_Contact_GrayedOutChannel_LDELL_ESUPPORT--------->\n  "+e);

		}

	}
}
