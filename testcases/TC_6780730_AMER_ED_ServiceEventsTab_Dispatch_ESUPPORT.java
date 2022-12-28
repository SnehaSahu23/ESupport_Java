package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_6780730_AMER_ED_ServiceEventsTab_Dispatch_ESUPPORT extends BaseTest {


	@Test
	public void validate_TC_6780730_AMER_ED_ServiceEventsTab_Dispatch_ESUPPORT() 
	{
		try
		{
			System.out.println("Starts TC_6780730_AMER_ED_ServiceEventsTab_Dispatch_ESUPPORT");
			obj_EsupportServiceEventsWorkflow.handleCookies(driver);
			obj_EsupportServiceEventsWorkflow.ClickSearchServiceTag(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));

			obj_EsupportServiceEventsWorkflow.ClickOnServiceEventsTab(driver);
			obj_EsupportServiceEventsWorkflow.EnterEmailAddressToSeeServiceEvents(driver,TestNGCreator.TestData.get(Esupport.Email.ordinal()));
			
			obj_EsupportServiceEventsWorkflow.AnyActiveDispatchesShouldDisplayByDefault(driver);

			obj_EsupportServiceEventsWorkflow.ValidateForActiveFilterUnderDispatchesIsSelectedByDefault(driver);
			
			obj_EsupportServiceEventsWorkflow.ValidateSelectingInactiveDispatches(driver);
			obj_EsupportServiceEventsWorkflow.ValidateDetailsOfDispatchesDisplayedInContentSection(driver);
			
			obj_EsupportServiceEventsWorkflow.ClickOnExpandIconOfDispatches(driver);
			obj_EsupportServiceEventsWorkflow.ClickServiceNumberHyperlinkOnDispatches(driver, TestNGCreator.TestData.get(Esupport.Email.ordinal()));
			obj_EsupportServiceEventsWorkflow.ClickDispatchNumberHyperlinkOnDispatches(driver, TestNGCreator.TestData.get(Esupport.Email.ordinal()));
			
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_6780730_AMER_ED_ServiceEventsTab_Dispatch_ESUPPORT--------->\n  "+e);
		}
	}
}
