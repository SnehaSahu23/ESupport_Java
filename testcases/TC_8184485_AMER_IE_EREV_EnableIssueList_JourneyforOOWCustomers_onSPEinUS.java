package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_8184485_AMER_IE_EREV_EnableIssueList_JourneyforOOWCustomers_onSPEinUS extends BaseTest
{
	@Test
	public void validate_TC_8184485_AMER_IE_EREV_EnableIssueList_JourneyforOOWCustomers_onSPEinUS() 
	{
		try
		{
			System.out.println("Starts TC_8184485_AMER_IE_EREV_EnableIssueList_JourneyforOOWCustomers_onSPEinUS");
			obj_EsupportErevenueWorkflow.handleCookies(driver);
			//obj_EsupportErevenueWorkflow.verifyIssueListInCTSPage(driver);
			
			driver.navigate().to("https://www.dell.com/support/incidents-online/us/en/19");
			Thread.sleep(5000);
			obj_EsupportErevenueWorkflow.searchServiceTagInContactTechnicalSupport(driver, TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[0]);
			Thread.sleep(10000);
			obj_EsupportErevenueWorkflow.verifyIssueListOptions(driver);
			Thread.sleep(5000);
			obj_EsupportErevenueWorkflow.selectIssueFromDropdownHardwareOffer(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[0]);
			Thread.sleep(5000);
			obj_EsupportErevenueWorkflow.verifyRecommendedBadge(driver);
			Thread.sleep(5000);
			obj_EsupportErevenueWorkflow.selectIssueFromDropdownSoftwareSupport(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[1]);
			Thread.sleep(5000);
			obj_EsupportErevenueWorkflow.verifyRecommendedBadge(driver);
			Thread.sleep(5000);
			obj_EsupportErevenueWorkflow.selectIssueFromDropdownHardwareOffer(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[2]);
			obj_EsupportErevenueWorkflow.verifyOffersNotDisplayedInCTSPage(driver);
			Thread.sleep(5000);
			obj_EsupportErevenueWorkflow.clickChangeProductLink(driver);
			Thread.sleep(5000);
			obj_EsupportErevenueWorkflow.searchServiceTagInContactTechnicalSupport(driver, TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[1]);
			Thread.sleep(5000);
			obj_EsupportErevenueWorkflow.verifyIssueListOptions(driver);
			Thread.sleep(5000);
			obj_EsupportErevenueWorkflow.selectIssueFromDropdownHardwareOffer(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[0]);
			Thread.sleep(5000);
			obj_EsupportErevenueWorkflow.verifyOffersNotDisplayedInCTSPage(driver);
			obj_EsupportErevenueWorkflow.selectIssueFromDropdownSoftwareSupport(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[1]);
			Thread.sleep(5000);
			obj_EsupportErevenueWorkflow.verifyRecommendedBadge(driver);
			Thread.sleep(5000);
			obj_EsupportErevenueWorkflow.clickChangeProductLink(driver);
			Thread.sleep(5000);
			obj_EsupportErevenueWorkflow.searchServiceTagInContactTechnicalSupport(driver, TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[2]);
			Thread.sleep(5000);
			obj_EsupportErevenueWorkflow.verifyIssueDropdownNotDisplayedInCTSPage(driver);
			
			
			Thread.sleep(5000);
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_8184485_AMER_IE_EREV_EnableIssueList_JourneyforOOWCustomers_onSPEinUS--------->\n  "+e);
		}
	}
}


