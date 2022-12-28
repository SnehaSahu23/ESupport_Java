package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_8749155_AMER_CH_UnifiedProfile_CustomGroups_Story8314947PEflowCreateaCustomgroupUsingSitesANDProductFamiliesShowSelectedItemstrayCustomGroupPreview_ESUPPORT extends BaseTest{
	@Test
	public void validate_TC_8749155_AMER_CH_UnifiedProfile_CustomGroups_Story8314947PEflowCreateaCustomgroupUsingSitesANDProductFamiliesShowSelectedItemstrayCustomGroupPreview_ESUPPORT() 
	{

		try
		{
			System.out.println("Starts TC_8749155_AMER_CH_UnifiedProfile_CustomGroups_Story8314947PEflowCreateaCustomgroupUsingSitesANDProductFamiliesShowSelectedItemstrayCustomGroupPreview_ESUPPORT");
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
			obj_EsupportUnifiedPortalWorkflow.verifyMessageOnRightSideBeforeSelectingSite(driver);
			Thread.sleep(6000);
			obj_EsupportUnifiedPortalWorkflow.validateDiaabledButtonEnabledOnSelectingAnyCheckBox(driver);
			Thread.sleep(6000);
			obj_EsupportUnifiedPortalWorkflow.ClickSelectProductFamilyTab(driver);
			Thread.sleep(6000);
			obj_EsupportUnifiedPortalWorkflow.verifyColumnNamesInGridOfSelectedItems_PreviewTab(driver);
			Thread.sleep(6000);
			obj_EsupportUnifiedPortalWorkflow.ClickOnShowSelectedItemsTab_SitesFamilies_PreviewTab(driver);
			Thread.sleep(6000);
			obj_EsupportUnifiedPortalWorkflow.validateFilterSection_Slectedtems_PreviewTab(driver,TestNGCreator.TestData.get(Esupport.Dpid.ordinal()));
			Thread.sleep(6000);
			obj_EsupportUnifiedPortalWorkflow.clickOnXButtonOfFilterClear_SelectedItems_SiteFamily(driver);
			Thread.sleep(6000);
			obj_EsupportUnifiedPortalWorkflow.VerifyPageNumbersDisplayingUnderPaginationSection_SitesAndFamilies_PreviewTab(driver);
			Thread.sleep(6000);
			obj_EsupportUnifiedPortalWorkflow.ValidatePreviousWillBeGreyedOutWhenUserIsOn1stPageIfMoreThanOnePagePresent_SitesAndFamilies_PreviewTab(driver);
			Thread.sleep(6000);
			obj_EsupportUnifiedPortalWorkflow.ValidateNextWillBeGreyedOutWhenUserIsOnLastPageIfMoreThanOnePagePresent_SitesAndFamilies_PreviewTab(driver);
			
			//hide custom group
			Thread.sleep(6000);
			obj_EsupportUnifiedPortalWorkflow.HideSelectedItems_SitesFamilies(driver);
			
		}
		catch(Exception e){

			Assert.fail("Failed while executing test case TC_8749155_AMER_CH_UnifiedProfile_CustomGroups_Story8314947PEflowCreateaCustomgroupUsingSitesANDProductFamiliesShowSelectedItemstrayCustomGroupPreview_ESUPPORT--------->\n  "+e);

		}

	}
}
