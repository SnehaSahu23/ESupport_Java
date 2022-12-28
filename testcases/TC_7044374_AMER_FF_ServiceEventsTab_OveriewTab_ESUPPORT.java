package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_7044374_AMER_FF_ServiceEventsTab_OveriewTab_ESUPPORT extends BaseTest {


	@Test
	public void validate_TC_7044374_AMER_FF_ServiceEventsTab_OveriewTab_ESUPPORT() 
	{
		try
		{
			System.out.println("Starts TC_7044374_AMER_FF_ServiceEventsTab_OveriewTab_ESUPPORT");
			obj_EsupportServiceEventsWorkflow.handleCookies(driver);
			obj_EsupportServiceEventsWorkflow.ClickSearchServiceTag(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));

			obj_EsupportServiceEventsWorkflow.SearchForEmailSection(driver);
			obj_EsupportServiceEventsWorkflow.EnterEmailAddressToSeeServiceEventsInOverviewTab(driver,TestNGCreator.TestData.get(Esupport.Email.ordinal()));
			obj_EsupportServiceEventsWorkflow.ValidateDisplayedServiceEventsInOverViewTab(driver);
			obj_EsupportServiceEventsWorkflow.ValidateOnlyShowActiveEvents(driver);
			
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_7044374_AMER_FF_ServiceEventsTab_OveriewTab_ESUPPORT--------->\n  "+e);
		}
	}
}
