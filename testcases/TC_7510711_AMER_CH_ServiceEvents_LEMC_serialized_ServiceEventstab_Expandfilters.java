package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_7510711_AMER_CH_ServiceEvents_LEMC_serialized_ServiceEventstab_Expandfilters extends BaseTest
{
	@Test
	public void validate_TC_7510711_AMER_CH_ServiceEvents_LEMC_serialized_ServiceEventstab_Expandfilters() 
	{
		try
		{
			System.out.println("Starts TC_7510711_AMER_CH_ServiceEvents_LEMC_serialized_ServiceEventstab_Expandfilters");
			obj_EsupportServiceEventsWorkflow.handleCookies(driver);
			obj_EsupportIncidentsWorkflow.clickSignIn(driver);
			obj_EsupportIPSWorkflow.Emaillogin(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			obj_EsupportServiceEventsWorkflow.ClickSearchServiceTag(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
			obj_EsupportServiceEventsWorkflow.clickOnServiceEventsTab_LEMC(driver);
			obj_EsupportServiceEventsWorkflow.verifyEventTypesSETabLeftPanel_LEMC(driver);
			obj_EsupportServiceEventsWorkflow.clickExpandIconServiceRequestSETabLeftPanel_LEMC(driver);
			obj_EsupportServiceEventsWorkflow.ClickExpandAllOnLeftPanel(driver);
			Thread.sleep(10000);
			obj_EsupportServiceEventsWorkflow.ValidateForCollapseAllButtonDisplaysAfterClickingOnExpandButton(driver);
			Thread.sleep(10000);
			obj_EsupportServiceEventsWorkflow.ClickOnCollapseAllOnLeftPanel(driver);
			obj_EsupportServiceEventsWorkflow.ValidateForExpandAllButtonDisplaysAfterClickingOnCollapseAllButton(driver);
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_7510711_AMER_CH_ServiceEvents_LEMC_serialized_ServiceEventstab_Expandfilters--------->\n  "+e);
		}
	}
}

