package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_8402819_AMER_CH_UnifiedProfile_Story7952549CreateaCustomgroupUsingProductsAssetsShowSelectedProductssectionSearchbySiteoption_ESUPPORT extends BaseTest{
	@Test
	public void validate_TC_8402819_AMER_CH_UnifiedProfile_Story7952549CreateaCustomgroupUsingProductsAssetsShowSelectedProductssectionSearchbySiteoption_ESUPPORT() 
	{

		try
		{
			System.out.println("Starts TC_8402819_AMER_CH_UnifiedProfile_Story7952549CreateaCustomgroupUsingProductsAssetsShowSelectedProductssectionSearchbySiteoption_ESUPPORT");
			Thread.sleep(6000);	
			obj_EsupportIPSWorkflow.Emaillogin(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			Thread.sleep(6000);	
			obj_EsupportUnifiedPortalWorkflow.clickCustomGroups(driver);
			Thread.sleep(6000);	
			obj_EsupportUnifiedPortalWorkflow.validateAddCustomGroupButton(driver);
			Thread.sleep(6000);
			obj_EsupportUnifiedPortalWorkflow.clickOnAddCustomGroupButton(driver);
			Thread.sleep(6000);
			obj_EsupportUnifiedPortalWorkflow.SelectCreateByInduvidualProductsOption(driver);
			Thread.sleep(6000);
			obj_EsupportUnifiedPortalWorkflow.selectSearchBySites(driver);
			Thread.sleep(6000);
			obj_EsupportUnifiedPortalWorkflow.searchForMetaData(driver);
			Thread.sleep(6000);
			obj_EsupportUnifiedPortalWorkflow.SelectOneOrMultipleAssetsInSitesGrid(driver);
			Thread.sleep(6000);
			obj_EsupportUnifiedPortalWorkflow.ClickOnAddToGroupButtonInSitesGrid(driver);
			Thread.sleep(6000);
			obj_EsupportUnifiedPortalWorkflow.ClickOnShowSelectedProductsTab(driver);
			Thread.sleep(6000);
			obj_EsupportUnifiedPortalWorkflow.verifyColumnNamesInGridOfSelectedItems(driver);
			Thread.sleep(6000);
			obj_EsupportUnifiedPortalWorkflow.SortingColumnsAssertId(driver);
			Thread.sleep(6000);
			obj_EsupportUnifiedPortalWorkflow.validateFilterSection(driver,TestNGCreator.TestData.get(Esupport.Dpid.ordinal()));
			Thread.sleep(6000);
			obj_EsupportUnifiedPortalWorkflow.SelectOneOrMultipleAssetsOnSelectedProducts(driver);
			Thread.sleep(6000);
			obj_EsupportUnifiedPortalWorkflow.ClickOnRemoveButton(driver);
		}
		catch(Exception e){

			Assert.fail("Failed while executing test case TC_8402819_AMER_CH_UnifiedProfile_Story7952549CreateaCustomgroupUsingProductsAssetsShowSelectedProductssectionSearchbySiteoption_ESUPPORT--------->\n  "+e);

		}

	}
}
