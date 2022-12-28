package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_7123037_AMER_ED_Contact_OpenServiceRequest_LDELL_ESUPPORT extends BaseTest 
{
	@Test
	public void validate_TC_7123037_AMER_ED_Contact_OpenServiceRequest_LDELL_ESUPPORT() 
	{

		try
		{
			System.out.println("Starts TC_7123037_AMER_ED_Contact_OpenServiceRequest_LDELL_ESUPPORT");
			
			//before sign in
			obj_EsupportIncidentsWorkflow.ToVerify_EnterServiceTag_HandledPopup(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[0]);
			
			
			obj_EsupportIncidentsWorkflow.ValidateMessageDisplayedWhenTagHasOpenServiceRequest(driver);
			
			obj_EsupportIncidentsWorkflow.ClickOnViewDetails(driver,TestNGCreator.TestData.get(Esupport.Email.ordinal()));
			
//			obj_EsupportServiceEventsWorkflow.EnterEmailAddressToSeeServiceEvents(driver,TestNGCreator.TestData.get(Esupport.Email.ordinal()));
//			obj_EsupportServiceEventsWorkflow.ValidateOnlyShowActiveEvents(driver);
			
//			obj_EsupportServiceEventsWorkflow.ClickServiceNumberHyperlinkOnServiceRequests(driver, TestNGCreator.TestData.get(Esupport.Email.ordinal()));
			
			//after sign in
			
			obj_EsupportIncidentsWorkflow.clickSignIn(driver);
			obj_EsupportIncidentsWorkflow.ToLogin_ValidCredentials(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			
			obj_EsupportIncidentsWorkflow.ToVerify_EnterServiceTag_HandledPopup(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[0]);
			
			
			obj_EsupportIncidentsWorkflow.ValidateMessageDisplayedWhenTagHasOpenServiceRequest(driver);
			
			obj_EsupportIncidentsWorkflow.ClickOnViewDetails(driver,TestNGCreator.TestData.get(Esupport.Email.ordinal()));
		}
		catch(Exception e)
		{

			Assert.fail("Failed while TC_7123037_AMER_ED_Contact_OpenServiceRequest_LDELL_ESUPPORT--------->\n  "+e);

		}

	}
}
