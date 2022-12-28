package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_8749239_AMER_CH_UnifiedProfile_CustomGroups_Story8315946PEflowEditCustomgroupTypeProductsAssetscontinuedPart3_ESUPPORT extends BaseTest{
	@Test
	public void validate_TC_8749239_AMER_CH_UnifiedProfile_CustomGroups_Story8315946PEflowEditCustomgroupTypeProductsAssetscontinuedPart3_ESUPPORT() 
	{

		try
		{
			System.out.println("Starts TC_8749239_AMER_CH_UnifiedProfile_CustomGroups_Story8315946PEflowEditCustomgroupTypeProductsAssetscontinuedPart3_ESUPPORT");
			Thread.sleep(6000);	
			obj_EsupportIPSWorkflow.Emaillogin(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			Thread.sleep(6000);	
			obj_EsupportUnifiedPortalWorkflow.clickCustomGroups(driver);
			Thread.sleep(6000);	
			//edit created custom group
			
			obj_EsupportUnifiedPortalWorkflow.clickOnEdit_ValidateDisplayedPage_Products(driver);
			Thread.sleep(6000);
			//select search by sites options
			obj_EsupportUnifiedPortalWorkflow.selectSearchBySites_InEditPageOfProducts(driver);
			Thread.sleep(6000);
			obj_EsupportUnifiedPortalWorkflow.SelectOneOrMultipleAssetsInSitesGrid(driver);
			Thread.sleep(6000);
			obj_EsupportUnifiedPortalWorkflow.ClickOnAddToGroupButtonInSitesGrid_Edit(driver);
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
			obj_EsupportUnifiedPortalWorkflow.clickOnEdit_ValidateDisplayedPage_Products(driver);
			Thread.sleep(6000);
			obj_EsupportUnifiedPortalWorkflow.selectSearchBySites_InEditPageOfProducts(driver);
			Thread.sleep(6000);
			obj_EsupportUnifiedPortalWorkflow.SelectOneOrMultipleAssetsInSitesGrid(driver);
			Thread.sleep(6000);
			obj_EsupportUnifiedPortalWorkflow.ClickOnAddToGroupButtonInSitesGrid_Edit(driver);
			Thread.sleep(6000);
			obj_EsupportUnifiedPortalWorkflow.clickOnSaveChangesButton_Edit(driver);
		
		}
		catch(Exception e){

			Assert.fail("Failed while executing test case TC_8749239_AMER_CH_UnifiedProfile_CustomGroups_Story8315946PEflowEditCustomgroupTypeProductsAssetscontinuedPart3_ESUPPORT--------->\n  "+e);

		}

	}
}
