package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_7510605_AMER_FF_ServiceEvents_LEMC_Serialized_ServiceEventstabApplyFilters extends BaseTest
{
	@Test
	public void validate_TC_7510605_AMER_FF_ServiceEvents_LEMC_Serialized_ServiceEventstabApplyFilters() 
	{
		try
		{
			System.out.println("Starts TC_7510605_AMER_FF_ServiceEvents_LEMC_Serialized_ServiceEventstabApplyFilters");
			obj_EsupportServiceEventsWorkflow.handleCookies(driver);
			obj_EsupportIncidentsWorkflow.clickSignIn(driver);
			obj_EsupportIPSWorkflow.Emaillogin(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			obj_EsupportServiceEventsWorkflow.ClickSearchServiceTag(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
			obj_EsupportServiceEventsWorkflow.clickOnServiceEventsTab_LEMC(driver);
			Thread.sleep(5000);
			obj_EsupportServiceEventsWorkflow.verifyEventTypesSETabLeftPanel_LEMC(driver);
			Thread.sleep(5000);
			obj_EsupportServiceEventsWorkflow.ClickExpandAllOnLeftPanel(driver);
			Thread.sleep(5000);
			obj_EsupportServiceEventsWorkflow.SelectAllAvailableFiltersInEachEventTypes(driver);
			Thread.sleep(5000);
			obj_EsupportServiceEventsWorkflow.clickApplyFiltersButtonAndVerifyFiltersTextSETabLeftPanel_LEMC(driver);
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_7510605_AMER_FF_ServiceEvents_LEMC_Serialized_ServiceEventstabApplyFilters--------->\n  "+e);
		}
	}
}
