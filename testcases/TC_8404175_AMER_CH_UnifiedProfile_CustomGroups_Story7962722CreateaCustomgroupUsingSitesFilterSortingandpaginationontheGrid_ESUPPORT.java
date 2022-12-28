package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_8404175_AMER_CH_UnifiedProfile_CustomGroups_Story7962722CreateaCustomgroupUsingSitesFilterSortingandpaginationontheGrid_ESUPPORT extends BaseTest{
	@Test
	public void validate_TC_8404175_AMER_CH_UnifiedProfile_CustomGroups_Story7962722CreateaCustomgroupUsingSitesFilterSortingandpaginationontheGrid_ESUPPORT() 
	{

		try
		{
			System.out.println("Starts TC_8404175_AMER_CH_UnifiedProfile_CustomGroups_Story7962722CreateaCustomgroupUsingSitesFilterSortingandpaginationontheGrid_ESUPPORT");
			Thread.sleep(6000);	
			obj_EsupportIPSWorkflow.Emaillogin(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			Thread.sleep(6000);	
			obj_EsupportUnifiedPortalWorkflow.clickCustomGroups(driver);
			Thread.sleep(6000);	
			obj_EsupportUnifiedPortalWorkflow.validateAddCustomGroupButton(driver);
			Thread.sleep(6000);
			obj_EsupportUnifiedPortalWorkflow.clickOnAddCustomGroupButton(driver);
			Thread.sleep(6000);
			obj_EsupportUnifiedPortalWorkflow.SelectCreateBySitesAndOrProductFamilies(driver);
			Thread.sleep(6000);
			obj_EsupportUnifiedPortalWorkflow.verifyListOfSitesAvailable(driver);
			Thread.sleep(6000);
			obj_EsupportUnifiedPortalWorkflow.verifyRightHandSideDetailsForSitesOrFamilies(driver);
			Thread.sleep(6000);
			obj_EsupportUnifiedPortalWorkflow.verifyDisplayedColumns(driver);
			Thread.sleep(6000);
			obj_EsupportUnifiedPortalWorkflow.validateFilterSectionInSitesGrid(driver,TestNGCreator.TestData.get(Esupport.Dpid.ordinal()));
			Thread.sleep(6000);
			obj_EsupportUnifiedPortalWorkflow.clickOnXButtonOfFilterClearInSitesGrid(driver);
			Thread.sleep(6000);
			obj_EsupportUnifiedPortalWorkflow.SortingColumnsInGridOfSitesPage(driver);
			Thread.sleep(6000);
			obj_EsupportUnifiedPortalWorkflow.VerifyPageNumbersDisplayingUnderPaginationSection(driver);
			Thread.sleep(6000);
			obj_EsupportUnifiedPortalWorkflow.ValidatePreviousWillBeGreyedOutWhenUserIsOn1stPageIfMoreThanOnePagePresent(driver);
			Thread.sleep(6000);
			obj_EsupportUnifiedPortalWorkflow.ValidateNextWillBeGreyedOutWhenUserIsOnLastPageIfMoreThanOnePagePresent(driver);
			Thread.sleep(6000);
			obj_EsupportUnifiedPortalWorkflow.validateDiaabledButtonEnabledOnSelectingAnyCheckBox(driver);
			
		}
		catch(Exception e){

			Assert.fail("Failed while executing test case TC_8404175_AMER_CH_UnifiedProfile_CustomGroups_Story7962722CreateaCustomgroupUsingSitesFilterSortingandpaginationontheGrid_ESUPPORT--------->\n  "+e);

		}

	}
}
