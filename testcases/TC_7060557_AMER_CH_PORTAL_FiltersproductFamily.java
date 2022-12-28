package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_7060557_AMER_CH_PORTAL_FiltersproductFamily extends BaseTest
{
	@Test
	public void validate_TC_7060557_AMER_CH_PORTAL_FiltersproductFamily() 
	{
		try
		{
			System.out.println("Starts TC_7060557_AMER_CH_PORTAL_FiltersproductFamily");
			obj_EsupportPortalWorkflow.handleCookies(driver);
			obj_EsupportIPSWorkflow.Emaillogin(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			obj_EsupportPortalWorkflow.clickInstallBaseTab(driver);
			obj_EsupportPortalWorkflow.clickIncidentManagementSummaryViewFilterButton(driver);
			obj_EsupportPortalWorkflow.selectFilter(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[0]);
			obj_EsupportPortalWorkflow.clickFilterOption(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[1]);
			
			obj_EsupportPortalWorkflow.clickApplySelectedButton(driver);	
			obj_EsupportPortalWorkflow.verifyClearAllAndFilterCloseButton(driver);
			obj_EsupportPortalWorkflow.clickFilterCloseButton(driver);
			obj_EsupportPortalWorkflow.clickIncidentManagementSummaryViewFilterButton(driver);
			obj_EsupportPortalWorkflow.selectFilter(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[0]);
			obj_EsupportPortalWorkflow.verifyProductFamilyFilterOptions(driver);
			obj_EsupportPortalWorkflow.verifyApplySelectedButton(driver);
			obj_EsupportPortalWorkflow.verifyResetSelectionButton(driver);
			obj_EsupportPortalWorkflow.clickFilterCloseButton(driver);
			obj_EsupportPortalWorkflow.clickIncidentManagementSummaryViewFilterButton(driver);
			obj_EsupportPortalWorkflow.selectFilter(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[0]);
			obj_EsupportPortalWorkflow.clickFilterOption(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[1]);
			obj_EsupportPortalWorkflow.clickFilterOption(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[2]);
			obj_EsupportPortalWorkflow.clickApplySelectedButton(driver);
			obj_EsupportPortalWorkflow.clickFilterCloseButton(driver);
			
			obj_EsupportPortalWorkflow.verifyFilterButtonNumber(driver);
			obj_EsupportPortalWorkflow.clickIncidentManagementSummaryViewFilterButton(driver);
			
			obj_EsupportPortalWorkflow.clickClearAllButton(driver);
			
			obj_EsupportPortalWorkflow.clickIncidentManagementSummaryViewFilterButton(driver);
			
			obj_EsupportPortalWorkflow.selectFilter(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[0]);
			obj_EsupportPortalWorkflow.clickFilterOption(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[3]);
			obj_EsupportPortalWorkflow.clickApplySelectedButton(driver);
			obj_EsupportPortalWorkflow.clickFilterCloseButton(driver);
			obj_EsupportPortalWorkflow.verifyNoDataFoundMessage(driver);

			obj_EsupportPortalWorkflow.clickIncidentManagementSummaryViewFilterButton(driver);
			
			obj_EsupportPortalWorkflow.selectFilter(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[0]);
			obj_EsupportPortalWorkflow.verifyDefaultTextSearchTextbox(driver);
			
			obj_EsupportPortalWorkflow.selectFilter(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[0]);
			obj_EsupportPortalWorkflow.clickFilterOption(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[1]);
			obj_EsupportPortalWorkflow.clickFilterOption(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[2]);
			obj_EsupportPortalWorkflow.clickApplySelectedButton(driver);
			
			obj_EsupportPortalWorkflow.selectFilter(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[4]);
			obj_EsupportPortalWorkflow.clickFilterOption(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[5]);
			obj_EsupportPortalWorkflow.clickFilterOption(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[6]);
			
			obj_EsupportPortalWorkflow.verifyResetSelectionButton(driver);
			
			obj_EsupportPortalWorkflow.clickIncidentManagementSummaryViewFilterButton(driver);
			
			obj_EsupportPortalWorkflow.selectFilter(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[0]);
			obj_EsupportPortalWorkflow.clickFilterOption(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[7]);
			obj_EsupportPortalWorkflow.clickFilterOption(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[8]);
			obj_EsupportPortalWorkflow.clickApplySelectedButton(driver);
			obj_EsupportPortalWorkflow.clickFilterCloseButton(driver);
			Thread.sleep(10000);
			//obj_EsupportPortalWorkflow.clickIncidentManagementClearAllButton(driver);
			obj_EsupportPortalWorkflow.clickMapViewButton(driver);
			Thread.sleep(10000);
			obj_EsupportPortalWorkflow.clickIncidentManagementSummaryViewFilterButton(driver);
			obj_EsupportPortalWorkflow.clickClearAllButton(driver);
			
			obj_EsupportPortalWorkflow.clickIncidentManagementSummaryViewFilterButton(driver);
			obj_EsupportPortalWorkflow.selectFilter(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[0]);
			
			obj_EsupportPortalWorkflow.clickFilterOption(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[7]);
			obj_EsupportPortalWorkflow.clickFilterOption(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[8]);
			obj_EsupportPortalWorkflow.clickApplySelectedButton(driver);
			obj_EsupportPortalWorkflow.clickFilterCloseButton(driver);
			
			driver.navigate().refresh();
			Thread.sleep(10000);
			obj_EsupportPortalWorkflow.verifyFilterButtonNumber(driver);
			obj_EsupportPortalWorkflow.clickIncidentManagementSummaryViewFilterButton(driver);
			obj_EsupportPortalWorkflow.selectFilter(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[0]);
			obj_EsupportPortalWorkflow.clickFilterOption(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[7]);
			obj_EsupportPortalWorkflow.clickFilterOption(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[8]);
			obj_EsupportPortalWorkflow.clickApplySelectedButton(driver);
			obj_EsupportPortalWorkflow.clickFilterCloseButton(driver);
			Thread.sleep(5000);
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_7060557_AMER_CH_PORTAL_FiltersproductFamily--------->\n  "+e);
		}
	}
}

