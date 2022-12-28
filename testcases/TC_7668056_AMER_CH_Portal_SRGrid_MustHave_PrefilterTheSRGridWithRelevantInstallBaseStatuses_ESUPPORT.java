package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_7668056_AMER_CH_Portal_SRGrid_MustHave_PrefilterTheSRGridWithRelevantInstallBaseStatuses_ESUPPORT extends BaseTest
{
	@Test
	public void validate_TC_7668056_AMER_CH_Portal_SRGrid_MustHave_PrefilterTheSRGridWithRelevantInstallBaseStatuses_ESUPPORT() 
	{
		try
		{
			System.out.println("Starts TC_7668056_AMER_CH_Portal_SRGrid_MustHave_PrefilterTheSRGridWithRelevantInstallBaseStatuses_ESUPPORT");
				
			obj_EsupportPortalWorkflow.handleCookies(driver);
			obj_EsupportIPSWorkflow.Emaillogin(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			
			obj_EsupportPortalWorkflow.ClickOnIncidentManagementTab(driver);
			
			obj_EsupportPortalWorkflow.ValidateDefaultFilterInTabularViewInIMTabUnderTotalSRs(driver);
			
			obj_EsupportPortalWorkflow.ClickOnFilterAndValidateIBStatusDefaultSelectedOptionsDisplayedInInstallBasePage(driver);
			obj_EsupportPortalWorkflow.ClickOnFilterAndValidateIBStatusDefaultNotSelectedOptionsDisplayedInInstallBasePage(driver);
			
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_7668056_AMER_CH_Portal_SRGrid_MustHave_PrefilterTheSRGridWithRelevantInstallBaseStatuses_ESUPPORT--------->\n  "+e);
		}
	}
}
