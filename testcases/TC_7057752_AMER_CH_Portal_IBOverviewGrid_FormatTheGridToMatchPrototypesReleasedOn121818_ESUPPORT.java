package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_7057752_AMER_CH_Portal_IBOverviewGrid_FormatTheGridToMatchPrototypesReleasedOn121818_ESUPPORT extends BaseTest
{
	@Test
	public void validate_TC_7057752_AMER_CH_Portal_IBOverviewGrid_FormatTheGridToMatchPrototypesReleasedOn121818_ESUPPORT() 
	{
		try
		{
			System.out.println("Starts TC_7057752_AMER_CH_Portal_IBOverviewGrid_FormatTheGridToMatchPrototypesReleasedOn121818_ESUPPORT");
				
			obj_EsupportPortalWorkflow.handleCookies(driver);
			obj_EsupportIPSWorkflow.Emaillogin(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			obj_EsupportPortalWorkflow.ValidateTabsInPortalView(driver);
			obj_EsupportPortalWorkflow.ClickOnInstallBaseTab(driver);
			
			obj_EsupportPortalWorkflow.ValidateGridColumnsWhenUserSelectedAssetsMenu(driver);
			obj_EsupportPortalWorkflow.ValidateGridColumnsWhenUserSelectedConnectivityFromLeftMenu(driver);
			obj_EsupportPortalWorkflow.ValidateGridColumnsWhenUserSelectedCodeLevelsFromLeftMenu(driver);
			obj_EsupportPortalWorkflow.ValidateGridColumnsWhenUserSelectedContractsFromLeftMenu(driver);
			
			obj_EsupportPortalWorkflow.ValidateTopViewMenuOnTheGrid(driver);
			obj_EsupportPortalWorkflow.ValidateLeftMentOnInstallBase(driver);
			obj_EsupportPortalWorkflow.VerifySearchBoxOnLeftLowerSideOfTheGrid(driver);
			
			
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_7057752_AMER_CH_Portal_IBOverviewGrid_FormatTheGridToMatchPrototypesReleasedOn121818_ESUPPORT--------->\n  "+e);
		}
	}
}
