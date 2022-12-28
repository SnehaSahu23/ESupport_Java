package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_8382610_AMER_CH_UnifiedProfile_Story7936531CreateaCustomgroupUsingProductsAssetsFilterSortingpaginationoptionsonthegridSearchbyProductoption_ESUPPORT extends BaseTest{
	@Test
	public void validate_TC_8382610_AMER_CH_UnifiedProfile_Story7936531CreateaCustomgroupUsingProductsAssetsFilterSortingpaginationoptionsonthegridSearchbyProductoption_ESUPPORT() 
	{

		try
		{
			System.out.println("Starts TC_8382610_AMER_CH_UnifiedProfile_Story7936531CreateaCustomgroupUsingProductsAssetsFilterSortingpaginationoptionsonthegridSearchbyProductoption_ESUPPORT");
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
			obj_EsupportUnifiedPortalWorkflow.validateFilterSectionInAddCustomGroupPage(driver,TestNGCreator.TestData.get(Esupport.Dpid.ordinal()));
			Thread.sleep(6000);
			obj_EsupportUnifiedPortalWorkflow.clickOnXButtonOfFilterClear(driver);
			Thread.sleep(6000);
			obj_EsupportUnifiedPortalWorkflow.SortingColumnsInGridOfAddCustomGroupPage(driver);
			Thread.sleep(6000);
			obj_EsupportUnifiedPortalWorkflow.SelectOneOrMultipleAssets(driver);
			Thread.sleep(6000);
			obj_EsupportUnifiedPortalWorkflow.VerifyPageNumbersDisplayingUnderPaginationSection(driver);
			Thread.sleep(6000);
			obj_EsupportUnifiedPortalWorkflow.ValidatePreviousWillBeGreyedOutWhenUserIsOn1stPageIfMoreThanOnePagePresent(driver);
			Thread.sleep(6000);
			obj_EsupportUnifiedPortalWorkflow.ValidateNextWillBeGreyedOutWhenUserIsOnLastPageIfMoreThanOnePagePresent(driver);
		}
		catch(Exception e){

			Assert.fail("Failed while executing test case TC_8382610_AMER_CH_UnifiedProfile_Story7936531CreateaCustomgroupUsingProductsAssetsFilterSortingpaginationoptionsonthegridSearchbyProductoption_ESUPPORT--------->\n  "+e);

		}

	}
}
