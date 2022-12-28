package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_7510704_AMER_CH_ServiceEvents_LEMC_ServiceEventstabMorefilters extends BaseTest
{
	@Test
	public void validate_TC_7510704_AMER_CH_ServiceEvents_LEMC_ServiceEventstabMorefilters() 
	{
		try
		{
			System.out.println("Starts TC_7510704_AMER_CH_ServiceEvents_LEMC_ServiceEventstabMorefilters");
			obj_EsupportServiceEventsWorkflow.handleCookies(driver);
			obj_EsupportIncidentsWorkflow.clickSignIn(driver);
			obj_EsupportIPSWorkflow.clickSignInHereLink(driver);
			obj_EsupportServiceEventsWorkflow.ClickSearchServiceTag(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
			obj_EsupportServiceEventsWorkflow.clickOnServiceEventsTab_LEMC(driver);
			Thread.sleep(5000);
			obj_EsupportServiceEventsWorkflow.verifyEventTypesSETabLeftPanel_LEMC(driver);
			Thread.sleep(5000);
			obj_EsupportServiceEventsWorkflow.ClickExpandAllOnLeftPanel(driver);
			Thread.sleep(5000);
			obj_EsupportServiceEventsWorkflow.SelectAllAvailableFiltersInEachEventTypes(driver);
			obj_EsupportIPSWorkflow.signOut(driver);
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_7510704_AMER_CH_ServiceEvents_LEMC_ServiceEventstabMorefilters--------->\n  "+e);
		}
	}
}
