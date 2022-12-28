package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_7044017_AMER_CH_ServiceEventsTab_ServiceRequest_ESUPPORT extends BaseTest {


	@Test
	public void validate_TC_7044017_AMER_CH_ServiceEventsTab_ServiceRequest_ESUPPORT() 
	{
		try
		{
			System.out.println("Starts TC_7044017_AMER_CH_ServiceEventsTab_ServiceRequest_ESUPPORT");
			obj_EsupportServiceEventsWorkflow.handleCookies(driver);
			obj_EsupportServiceEventsWorkflow.ClickSearchServiceTag(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));

			obj_EsupportServiceEventsWorkflow.ClickOnServiceEventsTab(driver);
			obj_EsupportServiceEventsWorkflow.EnterEmailAddressToSeeServiceEvents(driver,TestNGCreator.TestData.get(Esupport.Email.ordinal()));
			
			obj_EsupportServiceEventsWorkflow.AnyActiveServiceRequestShouldDisplayByDefault(driver);

			obj_EsupportServiceEventsWorkflow.ValidateForActiveFilterUnderServiceRequestsIsSelectedByDefault(driver);
			
			obj_EsupportServiceEventsWorkflow.ValidateSelectingInactiveServiceRequests(driver);
			obj_EsupportServiceEventsWorkflow.ValidateDetailsOfServiceRequestssDisplayedInContentSection(driver);
			
			obj_EsupportServiceEventsWorkflow.ClickOnExpandIconOfServiceRequests(driver);
			obj_EsupportServiceEventsWorkflow.ClickServiceNumberHyperlinkOnServiceRequests(driver, TestNGCreator.TestData.get(Esupport.Email.ordinal()));
			
			
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_7044017_AMER_CH_ServiceEventsTab_ServiceRequest_ESUPPORT--------->\n  "+e);
		}
	}
}

