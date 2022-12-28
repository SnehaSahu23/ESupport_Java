package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_6780718_AMER_ED_ServiceEventsTab_Noactiveservicerequests_ESUPPORT extends BaseTest {


	@Test
	public void validate_TC_6780718_AMER_ED_ServiceEventsTab_Noactiveservicerequests_ESUPPORT() 
	{
		try
		{
			System.out.println("Starts TC_6780718_AMER_ED_ServiceEventsTab_Noactiveservicerequests_ESUPPORT");
			obj_EsupportServiceEventsWorkflow.handleCookies(driver);
			obj_EsupportServiceEventsWorkflow.ClickSearchServiceTag(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));

			obj_EsupportServiceEventsWorkflow.ClickOnServiceEventsTab(driver);
			obj_EsupportServiceEventsWorkflow.EnterEmailAddressToSeeServiceEvents(driver,TestNGCreator.TestData.get(Esupport.Email.ordinal()));
			obj_EsupportServiceEventsWorkflow.ValidateOnlyShowActiveEvents(driver);
			obj_EsupportServiceEventsWorkflow.ValidateMessageDisplayedHasNoActiveSRAndNoSH(driver);
			
			
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_6780718_AMER_ED_ServiceEventsTab_Noactiveservicerequests_ESUPPORT--------->\n  "+e);
		}
	}
}
