package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_8702420_AMER_CH_UnifiedProfile_CustomGroups_Story8018400CreateaCustomGroupUsingSitesANDProductFamiliesLayout_ESUPPORT extends BaseTest{
	@Test
	public void validate_TC_8702420_AMER_CH_UnifiedProfile_CustomGroups_Story8018400CreateaCustomGroupUsingSitesANDProductFamiliesLayout_ESUPPORT() 
	{

		try
		{
			System.out.println("Starts TC_8702420_AMER_CH_UnifiedProfile_CustomGroups_Story8018400CreateaCustomGroupUsingSitesANDProductFamiliesLayout_ESUPPORT");
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
			obj_EsupportUnifiedPortalWorkflow.validateFilterSection_PreviewTab(driver,TestNGCreator.TestData.get(Esupport.Dpid.ordinal()));
			Thread.sleep(6000);
			obj_EsupportUnifiedPortalWorkflow.clickOnXButtonOfFilterClear_SiteFamily(driver);
			Thread.sleep(6000);
			obj_EsupportUnifiedPortalWorkflow.ClickOnProductFamilyCheckBox(driver);
			
			//scenario click on different site and validate message displayed
			obj_EsupportUnifiedPortalWorkflow.validateChangeSiteSelectionAfterSelectingProductFamily_SiteFamily(driver);
			
			}
		catch(Exception e){

			Assert.fail("Failed while executing test case TC_8702420_AMER_CH_UnifiedProfile_CustomGroups_Story8018400CreateaCustomGroupUsingSitesANDProductFamiliesLayout_ESUPPORT--------->\n  "+e);

		}

	}
}