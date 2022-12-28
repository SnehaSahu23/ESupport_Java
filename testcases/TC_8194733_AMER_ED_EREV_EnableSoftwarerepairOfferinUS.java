package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_8194733_AMER_ED_EREV_EnableSoftwarerepairOfferinUS extends BaseTest
{
	@Test
	public void validate_TC_8194733_AMER_ED_EREV_EnableSoftwarerepairOfferinUS() 
	{
		try
		{
			System.out.println("Starts TC_8194733_AMER_ED_EREV_EnableSoftwarerepairOfferinUS");
			obj_EsupportErevenueWorkflow.handleCookies(driver);
		//	obj_EsupportErevenueWorkflow.verifySoftwareSupportOfferInContactTechnicalSupport(driver);
			
			Thread.sleep(5000);
		//	driver.navigate().to("https://www.dell.com/support/home");
			Thread.sleep(5000);
			obj_EsupportIPSWorkflow.searchServiceTag(driver, TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
			obj_EsupportErevenueWorkflow.selectIssueAndSubIssueFromDropdownOverviewTab(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[1], TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[2]);
			obj_EsupportErevenueWorkflow.clickOnBuySoftwareSupport(driver);
			obj_EsupportErevenueWorkflow.selectPaymentMethodAndClickNextButton(driver);
			Thread.sleep(5000);
			obj_EsupportErevenueWorkflow.ClickOnXMarkAtTheTopOfPopUp(driver);
			obj_EsupportErevenueWorkflow.clickResetButtonOverviewTab(driver);
			Thread.sleep(5000);
			obj_EsupportErevenueWorkflow.clickOnBuySoftwareSupport(driver);
			obj_EsupportErevenueWorkflow.selectPaymentMethodAndClickNextButton(driver);
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_8194733_AMER_ED_EREV_EnableSoftwarerepairOfferinUS--------->\n  "+e);
		}
	}
}
