package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_7510587_AMER_ED_ServiceEvents_LEMC_Overviewtab_DisplayActiveServiceEventsInfo_FieldChangeOrder extends BaseTest
{
	@Test
	public void validate_TC_7510587_AMER_ED_ServiceEvents_LEMC_Overviewtab_DisplayActiveServiceEventsInfo_FieldChangeOrder() 
	{
		try
		{
			System.out.println("Starts TC_7510587_AMER_ED_ServiceEvents_LEMC_Overviewtab_DisplayActiveServiceEventsInfo_FieldChangeOrder");
			obj_EsupportServiceEventsWorkflow.handleCookies(driver);
			obj_EsupportIncidentsWorkflow.clickSignIn(driver);
			obj_EsupportIPSWorkflow.Emaillogin(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			obj_EsupportServiceEventsWorkflow.ClickSearchServiceTag(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
			obj_EsupportServiceEventsWorkflow.verifyFCODetailsInOverviewTab(driver);
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_7510587_AMER_ED_ServiceEvents_LEMC_Overviewtab_DisplayActiveServiceEventsInfo_FieldChangeOrder--------->\n  "+e);
		}
	}
}
