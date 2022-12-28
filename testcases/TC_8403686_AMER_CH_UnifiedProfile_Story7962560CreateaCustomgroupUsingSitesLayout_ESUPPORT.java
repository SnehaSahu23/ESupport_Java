package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_8403686_AMER_CH_UnifiedProfile_Story7962560CreateaCustomgroupUsingSitesLayout_ESUPPORT extends BaseTest{
	@Test
	public void validate_TC_8403686_AMER_CH_UnifiedProfile_Story7962560CreateaCustomgroupUsingSitesLayout_ESUPPORT() 
	{

		try
		{
			System.out.println("Starts TC_8403686_AMER_CH_UnifiedProfile_Story7962560CreateaCustomgroupUsingSitesLayout_ESUPPORT");
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
			obj_EsupportUnifiedPortalWorkflow.validateFilterSiteForSitesOrFamilies(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()));
			Thread.sleep(6000);
			obj_EsupportUnifiedPortalWorkflow.clickOnXButtonOfFilterClearInSitesOrFamiliesGrid(driver);
			
		}
		catch(Exception e){

			Assert.fail("Failed while executing test case TC_8403686_AMER_CH_UnifiedProfile_Story7962560CreateaCustomgroupUsingSitesLayout_ESUPPORT--------->\n  "+e);

		}

	}
}