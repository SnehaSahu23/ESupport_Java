package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_8754384_AMER_CH_UnifiedProfile_CustomGroups_Story8261895EflowCreateaCustomgroupUsingSitesLayout_ESUPPORT extends BaseTest{
	@Test
	public void validate_TC_8754384_AMER_CH_UnifiedProfile_CustomGroups_Story8261895EflowCreateaCustomgroupUsingSitesLayout_ESUPPORT() 
	{

		try
		{
			System.out.println("Starts TC_8754384_AMER_CH_UnifiedProfile_CustomGroups_Story8261895EflowCreateaCustomgroupUsingSitesLayout_ESUPPORT");
			Thread.sleep(6000);	
			obj_EsupportIPSWorkflow.clickSignInHereLink(driver);
			Thread.sleep(6000);	
			obj_EsupportUnifiedPortalWorkflow.clickCustomGroups(driver);
			Thread.sleep(6000);	
			obj_EsupportUnifiedPortalWorkflow.validateAddCustomGroupButton(driver);
			Thread.sleep(6000);
			obj_EsupportUnifiedPortalWorkflow.clickOnAddCustomGroupButton(driver);
			Thread.sleep(6000);
			obj_EsupportUnifiedPortalWorkflow.SelectCreateBySitesAndOrProductFamilies(driver);
			Thread.sleep(6000);
			obj_EsupportUnifiedPortalWorkflow.SelectProductFamilyDisabled(driver);
			Thread.sleep(6000);
			obj_EsupportUnifiedPortalWorkflow.ClickOnToolTip(driver);
			Thread.sleep(6000);
//			obj_EsupportUnifiedPortalWorkflow.SelectAllListBox(driver);
//			Thread.sleep(6000);
//			obj_EsupportUnifiedPortalWorkflow.verifySitesAvailableInSitesOrFamilies_DefaultDisplayed(driver);
//			Thread.sleep(6000);
//			obj_EsupportUnifiedPortalWorkflow.verifyMessageOnRightSideBeforeSelectingSite(driver);
//			Thread.sleep(6000);
			obj_EsupportUnifiedPortalWorkflow.PreviewSectionAtBottom(driver);
			
		}
		catch(Exception e){

			Assert.fail("Failed while executing test case TC_8754384_AMER_CH_UnifiedProfile_CustomGroups_Story8261895EflowCreateaCustomgroupUsingSitesLayout_ESUPPORT--------->\n  "+e);

		}

	}
}