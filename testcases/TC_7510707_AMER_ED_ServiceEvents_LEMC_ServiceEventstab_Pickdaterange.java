package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_7510707_AMER_ED_ServiceEvents_LEMC_ServiceEventstab_Pickdaterange extends BaseTest
{
	@Test
	public void validate_TC_7510707_AMER_ED_ServiceEvents_LEMC_ServiceEventstab_Pickdaterange() 
	{
		try
		{
			System.out.println("Starts TC_7510707_AMER_ED_ServiceEvents_LEMC_ServiceEventstab_Pickdaterange");
			obj_EsupportServiceEventsWorkflow.handleCookies(driver);
			obj_EsupportIncidentsWorkflow.clickSignIn(driver);
			obj_EsupportContentWorkflow.clickSignInHereLink(driver);
			obj_EsupportServiceEventsWorkflow.ClickSearchServiceTag(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
			obj_EsupportServiceEventsWorkflow.clickOnServiceEventsTab_LEMC(driver);
			obj_EsupportServiceEventsWorkflow.ValidateTwoDatePickerBoxDisplayedInLeftPanel(driver);
			
			obj_EsupportServiceEventsWorkflow.enterDateInTextbox(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[0], TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[1]);
			
			Thread.sleep(5000);
			obj_EsupportServiceEventsWorkflow.clickApplyFiltersButtonAndVerifyFiltersTextSETabLeftPanel_LEMC(driver);
			obj_EsupportIPSWorkflow.signOut(driver);
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_7510707_AMER_ED_ServiceEvents_LEMC_ServiceEventstab_Pickdaterange--------->\n  "+e);
		}
	}
}

