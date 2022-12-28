package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_7220259_AMER_CH_PORTAL_FilteroptionfunctionalityinSecurityAdvisoryPage extends BaseTest
{
	@Test
	public void validate_TC_7220259_AMER_CH_PORTAL_FilteroptionfunctionalityinSecurityAdvisoryPage() 
	{
		try
		{
			System.out.println("Starts TC_7220259_AMER_CH_PORTAL_FilteroptionfunctionalityinSecurityAdvisoryPage");
			obj_EsupportPortalWorkflow.handleCookies(driver);
			obj_EsupportIPSWorkflow.Emaillogin(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			Thread.sleep(20000);
			obj_EsupportPortalWorkflow.clickHealthAndRiskTab(driver);			
			obj_EsupportPortalWorkflow.clickSecurityAdvisoryTab(driver);
			obj_EsupportPortalWorkflow.verifyFiltersList(driver);
			obj_EsupportPortalWorkflow.selectFilter(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[0]);
			obj_EsupportPortalWorkflow.verifyApplySelectedButton(driver);
			obj_EsupportPortalWorkflow.verifyResetSelectionButton(driver);
			obj_EsupportPortalWorkflow.clickFilterOption(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[1]);
			obj_EsupportPortalWorkflow.clickApplySelectedButton(driver);
			obj_EsupportPortalWorkflow.clickFilterCloseButton(driver);
			
			obj_EsupportPortalWorkflow.verifyHealthAndRiskFilterBreadcrumb(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[0]);
			obj_EsupportPortalWorkflow.verifyFilterButtonNumber(driver);
			obj_EsupportPortalWorkflow.clickIncidentManagementSummaryViewFilterButton(driver);
			obj_EsupportPortalWorkflow.selectFilter(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[3]);
			obj_EsupportPortalWorkflow.clickFilterOption(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[4]);
			obj_EsupportPortalWorkflow.clickApplySelectedButton(driver);
			obj_EsupportPortalWorkflow.clickFilterCloseButton(driver);
			
			obj_EsupportPortalWorkflow.verifyHealthAndRiskFilterBreadcrumb(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[3]);
			obj_EsupportPortalWorkflow.verifyFilterButtonNumber(driver);
			obj_EsupportPortalWorkflow.clickSeverityBreadcrumbCrossButton(driver);
			
			obj_EsupportPortalWorkflow.clickIncidentManagementSummaryViewFilterButton(driver);
			obj_EsupportPortalWorkflow.verifyClearAllAndFilterCloseButton(driver);
			obj_EsupportPortalWorkflow.clickFilterCloseButton(driver);
			
			obj_EsupportPortalWorkflow.clickIncidentManagementClearAllButton(driver);
			obj_EsupportPortalWorkflow.verifyFilterButtonNumber(driver);
			
			obj_EsupportPortalWorkflow.clickIncidentManagementSummaryViewFilterButton(driver);
			obj_EsupportPortalWorkflow.selectFilter(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[0]);
			obj_EsupportPortalWorkflow.clickFilterOption(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[1]);
			obj_EsupportPortalWorkflow.clickApplySelectedButton(driver);
			obj_EsupportPortalWorkflow.clickFilterCloseButton(driver);
			Thread.sleep(10000);
			obj_EsupportPortalWorkflow.verifySeverityColumn(driver);
			obj_EsupportPortalWorkflow.clickIncidentManagementSummaryViewFilterButton(driver);
			obj_EsupportPortalWorkflow.selectFilter(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[0]);
			obj_EsupportPortalWorkflow.clickFilterOption(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[2]);
			obj_EsupportPortalWorkflow.verifyResetSelectionButton(driver);
			obj_EsupportPortalWorkflow.clickFilterCloseButton(driver);
			Thread.sleep(5000);
			obj_EsupportPortalWorkflow.verifySeverityColumn(driver);
			Thread.sleep(5000);
			obj_EsupportPortalWorkflow.clickIncidentManagementSummaryViewFilterButton(driver);
			obj_EsupportPortalWorkflow.selectFilter(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[0]);
			obj_EsupportPortalWorkflow.clickFilterOption(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[1]);
			obj_EsupportPortalWorkflow.clickFilterOption(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[2]);
			obj_EsupportPortalWorkflow.clickApplySelectedButton(driver);
			obj_EsupportPortalWorkflow.clickFilterCloseButton(driver);
			
			//obj_EsupportPortalWorkflow.verifyMultipleOptionsSeverityColumn(driver);
			obj_EsupportPortalWorkflow.clickIncidentManagementSummaryViewFilterButton(driver);
			obj_EsupportPortalWorkflow.selectFilter(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[3]);
			obj_EsupportPortalWorkflow.clickFilterOption(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[4]);
			obj_EsupportPortalWorkflow.clickApplySelectedButton(driver);
			obj_EsupportPortalWorkflow.clickFilterCloseButton(driver);
			
			obj_EsupportPortalWorkflow.clickIncidentManagementSummaryViewFilterButton(driver);
			obj_EsupportPortalWorkflow.clickClearAllButton(driver);
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_7220259_AMER_CH_PORTAL_FilteroptionfunctionlityinSecurityAdvisoryPage--------->\n  "+e);
		}
	}
}