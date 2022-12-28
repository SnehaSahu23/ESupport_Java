package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_7775845_AMER_CH_Portal_MustHave_Portal_Breadcrumbs_Zone2Section2_ESUPPORT extends BaseTest
{
	@Test
	public void validate_TC_7775845_AMER_CH_Portal_MustHave_Portal_Breadcrumbs_Zone2Section2_ESUPPORT() 
	{
		try
		{
			System.out.println("Starts TC_7775845_AMER_CH_Portal_MustHave_Portal_Breadcrumbs_Zone2Section2_ESUPPORT");
				
			obj_EsupportPortalWorkflow.handleCookies(driver);
			obj_EsupportIPSWorkflow.Emaillogin(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			
			obj_EsupportPortalWorkflow.ValidateBreadcrumbDisplayedInHUDHomeIconSupportMyService360(driver);
			
			obj_EsupportPortalWorkflow.ClickOnInstallBaseTab(driver);
			obj_EsupportPortalWorkflow.ValidateBreadcrumbDisplayedInHUDHomeIconSupportMyService360(driver);
			
			obj_EsupportPortalWorkflow.clickHealthAndRiskTab(driver);
			obj_EsupportPortalWorkflow.ValidateBreadcrumbDisplayedInHUDHomeIconSupportMyService360(driver);
			
			obj_EsupportPortalWorkflow.ClickOnIncidentManagementTab(driver);
			obj_EsupportPortalWorkflow.ValidateBreadcrumbDisplayedInHUDHomeIconSupportMyService360(driver);
			
			obj_EsupportPortalWorkflow.ClickOnSummaryTab(driver);
			
			obj_EsupportPortalWorkflow.ValidateMyService360Link(driver);
			obj_EsupportPortalWorkflow.ValidateClickingOnSupportLinkFromBreadscrumb(driver);
			driver.navigate().back();
			Thread.sleep(10000);
			obj_EsupportPortalWorkflow.ValidateClickingOnHomeIconFromBreadscrumb(driver);
			

		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_7775845_AMER_CH_Portal_MustHave_Portal_Breadcrumbs_Zone2Section2_ESUPPORT--------->\n  "+e);
		}
	}
}
