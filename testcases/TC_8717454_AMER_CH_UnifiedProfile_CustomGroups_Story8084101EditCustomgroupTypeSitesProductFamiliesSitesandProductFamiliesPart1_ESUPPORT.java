package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_8717454_AMER_CH_UnifiedProfile_CustomGroups_Story8084101EditCustomgroupTypeSitesProductFamiliesSitesandProductFamiliesPart1_ESUPPORT extends BaseTest{
	@Test
	public void validate_TC_8717454_AMER_CH_UnifiedProfile_CustomGroups_Story8084101EditCustomgroupTypeSitesProductFamiliesSitesandProductFamiliesPart1_ESUPPORT() 
	{

		try
		{
			System.out.println("Starts TC_8717454_AMER_CH_UnifiedProfile_CustomGroups_Story8084101EditCustomgroupTypeSitesProductFamiliesSitesandProductFamiliesPart1_ESUPPORT");
			Thread.sleep(6000);	
			//Edit sites and family
			obj_EsupportIPSWorkflow.Emaillogin(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			Thread.sleep(6000);	
			obj_EsupportUnifiedPortalWorkflow.clickCustomGroups(driver);
			Thread.sleep(6000);	
			obj_EsupportUnifiedPortalWorkflow.clickOnEdit_ValidateDisplayedPage_SitesAndFamilies(driver);
			Thread.sleep(6000);
			obj_EsupportUnifiedPortalWorkflow.ClickOnShowSelectedItemsTab_SitesFamilies(driver);
			Thread.sleep(6000);
			obj_EsupportUnifiedPortalWorkflow.ClickCancelButtonAndValidatePopUp(driver);
			Thread.sleep(6000);
			obj_EsupportUnifiedPortalWorkflow.clickOnYes(driver);
			//Edit sites
			Thread.sleep(6000);
			obj_EsupportUnifiedPortalWorkflow.clickOnEdit_ValidateDisplayedPage_Sites(driver);
			Thread.sleep(6000);
			obj_EsupportUnifiedPortalWorkflow.ClickOnShowSelectedItemsTab_SitesFamilies(driver);
			
			Thread.sleep(6000);
			obj_EsupportUnifiedPortalWorkflow.ClickCancelButtonAndValidatePopUp(driver);
			Thread.sleep(6000);
			obj_EsupportUnifiedPortalWorkflow.clickOnYes(driver);
			//Edit Products
			
			Thread.sleep(6000);
			obj_EsupportUnifiedPortalWorkflow.edit_CustomGroup_Products(driver);
			
			}
		catch(Exception e){

			Assert.fail("Failed while executing test case TC_8717454_AMER_CH_UnifiedProfile_CustomGroups_Story8084101EditCustomgroupTypeSitesProductFamiliesSitesandProductFamiliesPart1_ESUPPORT--------->\n  "+e);

		}

	}
}
