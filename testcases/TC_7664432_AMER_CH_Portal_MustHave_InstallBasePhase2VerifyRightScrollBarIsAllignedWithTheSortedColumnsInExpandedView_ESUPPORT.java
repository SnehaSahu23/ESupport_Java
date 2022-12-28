package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_7664432_AMER_CH_Portal_MustHave_InstallBasePhase2VerifyRightScrollBarIsAllignedWithTheSortedColumnsInExpandedView_ESUPPORT extends BaseTest
{
	@Test
	public void validate_TC_7664432_AMER_CH_Portal_MustHave_InstallBasePhase2VerifyRightScrollBarIsAllignedWithTheSortedColumnsInExpandedView_ESUPPORT() 
	{
		try
		{
			System.out.println("Starts TC_7664432_AMER_CH_Portal_MustHave_InstallBasePhase2VerifyRightScrollBarIsAllignedWithTheSortedColumnsInExpandedView_ESUPPORT");
				
			obj_EsupportPortalWorkflow.handleCookies(driver);
			obj_EsupportIPSWorkflow.Emaillogin(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			obj_EsupportPortalWorkflow.ClickOnInstallBaseTab(driver);
			
			obj_EsupportPortalWorkflow.ClickOnConnectivityFromLeftMenuInInstallBase(driver);
			obj_EsupportPortalWorkflow.ClickOnGraphUnderConnectivityContext(driver);
			
			obj_EsupportPortalWorkflow.ClickOnProductFamilyLink(driver);

			
			obj_EsupportPortalWorkflow.ClickOnAnyOfGraphBarAndValidateForExpandViewForIBPageUnderContractsContext(driver);

			
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_7664432_AMER_CH_Portal_MustHave_InstallBasePhase2VerifyRightScrollBarIsAllignedWithTheSortedColumnsInExpandedView_ESUPPORT--------->\n  "+e);
		}
	}
}
