package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_8753205_AMER_CH_UnifiedProfile_CustomGroups_Story8253463PEuserflowCreateaCustomgroupUsingProductsAssetsShowSelectedProductssectionSearchbyProductoption_ESUPPORT extends BaseTest{
	@Test
	public void validate_TC_8753205_AMER_CH_UnifiedProfile_CustomGroups_Story8253463PEuserflowCreateaCustomgroupUsingProductsAssetsShowSelectedProductssectionSearchbyProductoption_ESUPPORT() 
	{

		try
		{
			System.out.println("Starts TC_8753205_AMER_CH_UnifiedProfile_CustomGroups_Story8253463PEuserflowCreateaCustomgroupUsingProductsAssetsShowSelectedProductssectionSearchbyProductoption_ESUPPORT");
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
			obj_EsupportUnifiedPortalWorkflow.SearchForProductCode(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()));
			Thread.sleep(6000);
			obj_EsupportUnifiedPortalWorkflow.SelectOneOrMultipleAssets(driver);
			Thread.sleep(6000);
			obj_EsupportUnifiedPortalWorkflow.ClickOnAddToGroupButton(driver);
			Thread.sleep(6000);
			//Show selected tab validation
			obj_EsupportUnifiedPortalWorkflow.ClickOnShowSelectedProductsTab(driver);
			Thread.sleep(6000);
			obj_EsupportUnifiedPortalWorkflow.verifyColumnNamesInGridOfSelectedItems(driver);
			Thread.sleep(6000);

			obj_EsupportUnifiedPortalWorkflow.SelectOneOrMultipleAssetsOnSelectedProducts(driver);
			Thread.sleep(6000);
			obj_EsupportUnifiedPortalWorkflow.ClickOnRemoveButton(driver);
			
			Thread.sleep(6000);
			//after clicking on remove from show selected
			driver.get("https://www.dell.com/support/preferences/us/en/04/mycustomgroups");
			Thread.sleep(6000);
			obj_EsupportUnifiedPortalWorkflow.validateAddCustomGroupButton(driver);
			Thread.sleep(6000);
			obj_EsupportUnifiedPortalWorkflow.clickOnAddCustomGroupButton(driver);
			Thread.sleep(6000);
			obj_EsupportUnifiedPortalWorkflow.SelectCreateByInduvidualProductsOption(driver);
			Thread.sleep(6000);
			obj_EsupportUnifiedPortalWorkflow.SearchForProductCode(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()));
			Thread.sleep(6000);
			obj_EsupportUnifiedPortalWorkflow.validateFilterSectionInAddCustomGroupPage(driver,TestNGCreator.TestData.get(Esupport.Dpid.ordinal()));
			Thread.sleep(6000);
			obj_EsupportUnifiedPortalWorkflow.clickOnXButtonOfFilterClear(driver);
			Thread.sleep(6000);
			obj_EsupportUnifiedPortalWorkflow.SortingColumnsInGridOfAddCustomGroupPage(driver);
			Thread.sleep(6000);
			obj_EsupportUnifiedPortalWorkflow.SelectOneOrMultipleAssets(driver);
			Thread.sleep(6000);
			obj_EsupportUnifiedPortalWorkflow.ClickOnAddToGroupButton(driver);
			Thread.sleep(6000);
			//cancel validation
			obj_EsupportUnifiedPortalWorkflow.ClickCancelButtonAndValidatePopUp(driver);
			Thread.sleep(6000);
			obj_EsupportUnifiedPortalWorkflow.clickOnNo(driver);
			Thread.sleep(6000);
			obj_EsupportUnifiedPortalWorkflow.ClickCancelButtonAndValidatePopUp(driver);
			Thread.sleep(6000);
			obj_EsupportUnifiedPortalWorkflow.clickOnYes(driver);
			Thread.sleep(6000);
			//create custom group validation
			obj_EsupportUnifiedPortalWorkflow.clickOnAddCustomGroupButton(driver);
			Thread.sleep(6000);
			obj_EsupportUnifiedPortalWorkflow.SelectCreateByInduvidualProductsOption(driver);
			Thread.sleep(6000);
			obj_EsupportUnifiedPortalWorkflow.SearchForProductCode(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()));
			Thread.sleep(6000);
			obj_EsupportUnifiedPortalWorkflow.SelectOneOrMultipleAssets(driver);
			Thread.sleep(6000);
			obj_EsupportUnifiedPortalWorkflow.ClickOnAddToGroupButton(driver);
			Thread.sleep(6000);
			obj_EsupportUnifiedPortalWorkflow.clickOnCreateCustomGroupButtonAndVerifyGroupCreationInGrid(driver);

		}
		catch(Exception e){

			Assert.fail("Failed while executing test case TC_8753205_AMER_CH_UnifiedProfile_CustomGroups_Story8253463PEuserflowCreateaCustomgroupUsingProductsAssetsShowSelectedProductssectionSearchbyProductoption_ESUPPORT--------->\n  "+e);

		}

	}
}
