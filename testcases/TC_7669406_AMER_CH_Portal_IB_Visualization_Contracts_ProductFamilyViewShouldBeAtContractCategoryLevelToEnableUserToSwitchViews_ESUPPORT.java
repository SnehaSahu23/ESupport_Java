package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_7669406_AMER_CH_Portal_IB_Visualization_Contracts_ProductFamilyViewShouldBeAtContractCategoryLevelToEnableUserToSwitchViews_ESUPPORT extends BaseTest
{
	@Test
	public void validate_TC_7669406_AMER_CH_Portal_IB_Visualization_Contracts_ProductFamilyViewShouldBeAtContractCategoryLevelToEnableUserToSwitchViews_ESUPPORT() 
	{
		try
		{
			System.out.println("Starts TC_7669406_AMER_CH_Portal_IB_Visualization_Contracts_ProductFamilyViewShouldBeAtContractCategoryLevelToEnableUserToSwitchViews_ESUPPORT");
				
			obj_EsupportPortalWorkflow.handleCookies(driver);
			obj_EsupportIPSWorkflow.Emaillogin(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			obj_EsupportPortalWorkflow.ClickOnInstallBaseTab(driver);
			
			obj_EsupportPortalWorkflow.ClickOnContractsFromLeftMenuInInstallBase(driver);
			obj_EsupportPortalWorkflow.ClickOnGraphUnderContractsContext(driver);
			
			obj_EsupportPortalWorkflow.ClickOnProductFamilyLink(driver);
			obj_EsupportPortalWorkflow.ValidateContractByProductFamilyPage(driver);
			
			obj_EsupportPortalWorkflow.ClickOnAnyOfGraphBarAndValidateForExpandViewForIBPageUnderContractsContext(driver);
			obj_EsupportPortalWorkflow.ClickOnFirstDisplayedProductFamilyNameAndValidateForExpandViewForIBPageUnderContractsContext(driver);
			
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_7669406_AMER_CH_Portal_IB_Visualization_Contracts_ProductFamilyViewShouldBeAtContractCategoryLevelToEnableUserToSwitchViews_ESUPPORT--------->\n  "+e);
		}
	}
}
