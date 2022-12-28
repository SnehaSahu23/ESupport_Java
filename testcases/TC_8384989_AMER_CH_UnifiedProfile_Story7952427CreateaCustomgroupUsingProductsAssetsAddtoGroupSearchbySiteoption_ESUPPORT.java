package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_8384989_AMER_CH_UnifiedProfile_Story7952427CreateaCustomgroupUsingProductsAssetsAddtoGroupSearchbySiteoption_ESUPPORT extends BaseTest{
	@Test
	public void validate_TC_8384989_AMER_CH_UnifiedProfile_Story7952427CreateaCustomgroupUsingProductsAssetsAddtoGroupSearchbySiteoption_ESUPPORT() 
	{

		try
		{
			System.out.println("Starts TC_8384989_AMER_CH_UnifiedProfile_Story7952427CreateaCustomgroupUsingProductsAssetsAddtoGroupSearchbySiteoption_ESUPPORT");
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
			obj_EsupportUnifiedPortalWorkflow.SelectOneOrMultipleAssetsInSitesGrid(driver);
			Thread.sleep(6000);
			obj_EsupportUnifiedPortalWorkflow.ClickOnAddToGroupButtonInSitesGrid(driver);
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
			Thread.sleep(6000);
			obj_EsupportUnifiedPortalWorkflow.selectSearchBySites(driver);
			Thread.sleep(6000);
			
			obj_EsupportUnifiedPortalWorkflow.SelectOneOrMultipleAssetsInSitesGrid(driver);
			Thread.sleep(6000);
			obj_EsupportUnifiedPortalWorkflow.ClickOnAddToGroupButtonInSitesGrid(driver);
			Thread.sleep(6000);
			obj_EsupportUnifiedPortalWorkflow.clickOnCreateCustomGroupButtonAndVerifyGroupCreationInGrid(driver);

		}
		catch(Exception e){

			Assert.fail("Failed while executing test case TC_8384989_AMER_CH_UnifiedProfile_Story7952427CreateaCustomgroupUsingProductsAssetsAddtoGroupSearchbySiteoption_ESUPPORT--------->\n  "+e);

		}

	}
}
