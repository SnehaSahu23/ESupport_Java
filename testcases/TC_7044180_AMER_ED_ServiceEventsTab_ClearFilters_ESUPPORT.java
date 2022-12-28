package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_7044180_AMER_ED_ServiceEventsTab_ClearFilters_ESUPPORT extends BaseTest {


	@Test
	public void validate_TC_7044180_AMER_ED_ServiceEventsTab_ClearFilters_ESUPPORT() 
	{
		try
		{
			System.out.println("Starts TC_7044180_AMER_ED_ServiceEventsTab_ClearFilters_ESUPPORT");
			obj_EsupportServiceEventsWorkflow.handleCookies(driver);
			obj_EsupportServiceEventsWorkflow.ClickSearchServiceTag(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));

			obj_EsupportServiceEventsWorkflow.ClickOnServiceEventsTab(driver);
			obj_EsupportServiceEventsWorkflow.EnterEmailAddressToSeeServiceEvents(driver,TestNGCreator.TestData.get(Esupport.Email.ordinal()));
			
			obj_EsupportServiceEventsWorkflow.ValidateEventTypesOnLeftPanel(driver);
			obj_EsupportServiceEventsWorkflow.ClickExpandAllOnLeftPanel(driver);
			obj_EsupportServiceEventsWorkflow.SelectAllAvailableFiltersInEachEventTypes(driver);
			obj_EsupportServiceEventsWorkflow.ClickOnApplyFilters(driver);
			
			obj_EsupportServiceEventsWorkflow.ClickOnClearFilterInLeftPanel(driver);
			obj_EsupportServiceEventsWorkflow.ClickExpandAllOnLeftPanel(driver);
			obj_EsupportServiceEventsWorkflow.SelectAllAvailableFiltersInEachEventTypes(driver);
			obj_EsupportServiceEventsWorkflow.ClickOnApplyFilters(driver);
			obj_EsupportServiceEventsWorkflow.ClickOnXInEachFilterBoxInLeftPanel(driver);

			
			
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_7044180_AMER_ED_ServiceEventsTab_ClearFilters_ESUPPORT--------->\n  "+e);
		}
	}
}
