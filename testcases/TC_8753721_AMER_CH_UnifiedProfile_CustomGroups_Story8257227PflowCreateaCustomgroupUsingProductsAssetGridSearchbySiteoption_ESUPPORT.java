package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_8753721_AMER_CH_UnifiedProfile_CustomGroups_Story8257227PflowCreateaCustomgroupUsingProductsAssetGridSearchbySiteoption_ESUPPORT extends BaseTest{
	@Test
	public void validate_TC_8753721_AMER_CH_UnifiedProfile_CustomGroups_Story8257227PflowCreateaCustomgroupUsingProductsAssetGridSearchbySiteoption_ESUPPORT() 
	{

		try
		{
			System.out.println("Starts TC_8753721_AMER_CH_UnifiedProfile_CustomGroups_Story8257227PflowCreateaCustomgroupUsingProductsAssetGridSearchbySiteoption_ESUPPORT");
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
			obj_EsupportUnifiedPortalWorkflow.validateFilterSiteForSites(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()));
			Thread.sleep(6000);
			obj_EsupportUnifiedPortalWorkflow.verifyRightHandSideDetails(driver);
			Thread.sleep(6000);
			obj_EsupportUnifiedPortalWorkflow.verifyDisplayedColumns(driver);
			Thread.sleep(6000);
			obj_EsupportUnifiedPortalWorkflow.vrifyButtonSectionButtons(driver);
			Thread.sleep(6000);
			obj_EsupportUnifiedPortalWorkflow.SelectOneOrMultipleAssetsInSitesGrid(driver);

		}
		catch(Exception e){

			Assert.fail("Failed while executing test case TC_8753721_AMER_CH_UnifiedProfile_CustomGroups_Story8257227PflowCreateaCustomgroupUsingProductsAssetGridSearchbySiteoption_ESUPPORT--------->\n  "+e);

		}

	}
}