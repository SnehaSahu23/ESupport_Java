package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_7044138_AMER_CH_ServiceEventsTab_Translations_ESUPPORT extends BaseTest {


	@Test
	public void validate_TC_7044138_AMER_CH_ServiceEventsTab_Translations_ESUPPORT() 
	{
		try
		{
			System.out.println("Starts TC_7044138_AMER_CH_ServiceEventsTab_Translations_ESUPPORT");
			obj_EsupportServiceEventsWorkflow.handleCookies(driver);
			obj_EsupportServiceEventsWorkflow.ClickSearchServiceTag(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));

			obj_EsupportServiceEventsWorkflow.ClickOnServiceEventsTab(driver);
			obj_EsupportServiceEventsWorkflow.EnterEmailAddressToSeeServiceEvents(driver,TestNGCreator.TestData.get(Esupport.Email.ordinal()));
			
			obj_EsupportServiceEventsWorkflow.ValidateChangeCountry(driver);
			
			obj_EsupportServiceEventsWorkflow.ChangeBackToDisplayedCountry(driver);
			
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_7044138_AMER_CH_ServiceEventsTab_Translations_ESUPPORT--------->\n  "+e);
		}
	}
}
