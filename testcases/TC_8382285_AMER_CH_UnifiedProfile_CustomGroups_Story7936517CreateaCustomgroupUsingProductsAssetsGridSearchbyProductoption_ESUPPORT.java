package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_8382285_AMER_CH_UnifiedProfile_CustomGroups_Story7936517CreateaCustomgroupUsingProductsAssetsGridSearchbyProductoption_ESUPPORT extends BaseTest{
	@Test
	public void validate_TC_8382285_AMER_CH_UnifiedProfile_CustomGroups_Story7936517CreateaCustomgroupUsingProductsAssetsGridSearchbyProductoption_ESUPPORT() 
	{

		try
		{
			System.out.println("Starts TC_8382285_AMER_CH_UnifiedProfile_CustomGroups_Story7936517CreateaCustomgroupUsingProductsAssetsGridSearchbyProductoption_ESUPPORT");
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
			
		}
		catch(Exception e){

			Assert.fail("Failed while executing test case TC_8382285_AMER_CH_UnifiedProfile_CustomGroups_Story7936517CreateaCustomgroupUsingProductsAssetsGridSearchbyProductoption_ESUPPORT--------->\n  "+e);

		}

	}
}
