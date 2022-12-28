package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_9327565_AMER_IE_SLP_SmokeTesting extends BaseTest
{
	@Test
	public void validate_TC_9327565_AMER_IE_SLP_SmokeTesting() 
	{
		try
		{
			System.out.println("Starts TC_9327565_AMER_IE_SLP_SmokeTesting");
			obj_EsupportSecurityLandingPageWorkflow.handleCookies(driver);
			
			obj_EsupportSecurityLandingPageWorkflow.clickCriticalFilterAndVerifyDetails(driver);
			obj_EsupportSecurityLandingPageWorkflow.searchTextAndVerifyData(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[0]);
			obj_EsupportSecurityLandingPageWorkflow.enterDateAndVerifyFilterCount(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[1], TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[2]);
			Thread.sleep(3000);
			obj_EsupportSecurityLandingPageWorkflow.removeCriticalFilterAndVerifyCount(driver);
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_9327565_AMER_IE_SLP_SmokeTesting--------->\n  "+e);
		}
	}
}