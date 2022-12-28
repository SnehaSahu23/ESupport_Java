package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_9021048_AMER_ED_SecurityLandingPage_Datepicker extends BaseTest
{
	@Test
	public void validate_TC_9021048_AMER_ED_SecurityLandingPage_Datepicker() 
	{
		try
		{
			System.out.println("Starts TC_9021048_AMER_ED_SecurityLandingPage_Datepicker");
			obj_EsupportSecurityLandingPageWorkflow.handleCookies(driver);
			
			obj_EsupportSecurityLandingPageWorkflow.validateDatePickerDefaultText(driver);
			obj_EsupportSecurityLandingPageWorkflow.enterFromDateAndVerifyDateTextbox(driver);
			obj_EsupportSecurityLandingPageWorkflow.verifyPublishedOptionAndUpdatedOption(driver);
			obj_EsupportSecurityLandingPageWorkflow.clickApplyFiltersAndVerifyData(driver);
			obj_EsupportSecurityLandingPageWorkflow.verifyYearOptionsInCalendar(driver);
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_9021048_AMER_ED_SecurityLandingPage_Datepicker--------->\n  "+e);
		}
	}
}