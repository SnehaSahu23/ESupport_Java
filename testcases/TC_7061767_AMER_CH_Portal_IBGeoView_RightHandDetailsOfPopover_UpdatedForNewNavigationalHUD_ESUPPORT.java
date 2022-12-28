package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_7061767_AMER_CH_Portal_IBGeoView_RightHandDetailsOfPopover_UpdatedForNewNavigationalHUD_ESUPPORT extends BaseTest
{
	@Test
	public void validate_TC_7061767_AMER_CH_Portal_IBGeoView_RightHandDetailsOfPopover_UpdatedForNewNavigationalHUD_ESUPPORT() 
	{
		try
		{
			System.out.println("Starts TC_7061767_AMER_CH_Portal_IBGeoView_RightHandDetailsOfPopover_UpdatedForNewNavigationalHUD_ESUPPORT");
				
			obj_EsupportPortalWorkflow.handleCookies(driver);
			obj_EsupportIPSWorkflow.Emaillogin(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			obj_EsupportPortalWorkflow.ClickOnInstallBaseTab(driver);
			
			obj_EsupportPortalWorkflow.ClickOnMap(driver);
			obj_EsupportPortalWorkflow.ClickOnAnyWhiteSpotThatIndicatesSiteLocation(driver);
			obj_EsupportPortalWorkflow.ClickOnAnyWhiteSpotThatIndicatesSiteLocationUnderConnectivityContextValidate(driver);
			obj_EsupportPortalWorkflow.ClickOnAnyWhiteSpotThatIndicatesSiteLocationUnderCodeLevelsContextValidate(driver);
			obj_EsupportPortalWorkflow.ClickOnAnyWhiteSpotThatIndicatesSiteLocationUnderContractsContextValidate(driver);
			
			
			obj_EsupportPortalWorkflow.ClickOnConnectivityFromLeftMenuInInstallBase(driver);
			obj_EsupportPortalWorkflow.ClickOnFilterAndValidateOptionsUnderConnectivity(driver);
			obj_EsupportPortalWorkflow.ValidateFilterConnectedAppliedInMapViewUnderConnectivityContextAndValidateHUDInWhiteSpotPopUpHUD(driver);
			
			obj_EsupportPortalWorkflow.ClickOnClearAllAtBreadScrumb(driver);
			
			obj_EsupportPortalWorkflow.ClickOnFilterAndApplyAnyFilterWhichRsultsInConnectedAssetsZeroAndValidateSameInHUDInPopUp(driver);
			
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_7061767_AMER_CH_Portal_IBGeoView_RightHandDetailsOfPopover_UpdatedForNewNavigationalHUD_ESUPPORT--------->\n  "+e);
		}
	}
}
