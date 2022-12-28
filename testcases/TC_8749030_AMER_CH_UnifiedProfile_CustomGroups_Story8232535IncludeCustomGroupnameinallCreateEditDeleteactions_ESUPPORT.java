package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_8749030_AMER_CH_UnifiedProfile_CustomGroups_Story8232535IncludeCustomGroupnameinallCreateEditDeleteactions_ESUPPORT extends BaseTest{
	@Test
	public void validate_TC_8749030_AMER_CH_UnifiedProfile_CustomGroups_Story8232535IncludeCustomGroupnameinallCreateEditDeleteactions_ESUPPORT() 
	{

		try
		{
			System.out.println("Starts TC_8749030_AMER_CH_UnifiedProfile_CustomGroups_Story8232535IncludeCustomGroupnameinallCreateEditDeleteactions_ESUPPORT");
			Thread.sleep(6000);	
			obj_EsupportIPSWorkflow.Emaillogin(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			Thread.sleep(6000);	
			obj_EsupportUnifiedPortalWorkflow.clickCustomGroups(driver);
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
			
			//create custom group validation
			
			obj_EsupportUnifiedPortalWorkflow.clickOnCreateCustomGroupButtonAndVerifyGroupCreationInGrid_OnlyCreate(driver);
			
			//edit created custom group
			
			obj_EsupportUnifiedPortalWorkflow.edit_CustomGroup(driver);
			
			//delete created custom group
			
			obj_EsupportUnifiedPortalWorkflow.deleteCustomGroup(driver);
		}
		catch(Exception e){

			Assert.fail("Failed while executing test case TC_8749030_AMER_CH_UnifiedProfile_CustomGroups_Story8232535IncludeCustomGroupnameinallCreateEditDeleteactions_ESUPPORT--------->\n  "+e);

		}

	}
}


