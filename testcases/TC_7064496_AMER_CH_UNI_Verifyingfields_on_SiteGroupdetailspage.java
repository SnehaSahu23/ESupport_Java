package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_7064496_AMER_CH_UNI_Verifyingfields_on_SiteGroupdetailspage extends BaseTest
{
	@Test
	public void validate_TC_7064496_AMER_CH_UNI_Verifyingfields_on_SiteGroupdetailspage() 
	{
		try
		{
			System.out.println("Starts TC_7064496_AMER_CH_UNI_Verifyingfields_on_SiteGroupdetailspage");
			Thread.sleep(10000);
			obj_EsupportUnifiedPortalWorkflow.clickSignInHereLink(driver);
			obj_EsupportUnifiedPortalWorkflow.handleCookies(driver);
			obj_EsupportUnifiedPortalWorkflow.clickCustomGroups(driver);
			Thread.sleep(5000);	
			obj_EsupportUnifiedPortalWorkflow.filterCustomGroups(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()));
			Thread.sleep(10000);
			obj_EsupportUnifiedPortalWorkflow.clickSiteCustomGroupName(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()));
			Thread.sleep(5000);
			obj_EsupportUnifiedPortalWorkflow.verifyEditCustomGroupButton(driver);
			obj_EsupportUnifiedPortalWorkflow.verifySiteCustomGroupColumns(driver);
			obj_EsupportUnifiedPortalWorkflow.verifyMyCustomGroupsDownloadButton(driver);
			obj_EsupportUnifiedPortalWorkflow.verifySearchTextBoxSiteGroup(driver);
			Thread.sleep(5000);
			//obj_EsupportUnifiedPortalWorkflow.verifyActionsButtonOptions(driver);
			Thread.sleep(5000);
		//	driver.navigate().refresh();
			Thread.sleep(5000);
			obj_EsupportUnifiedPortalWorkflow.verifyDeletePopupSiteCustomGroup(driver);
			Thread.sleep(3000);
			obj_EsupportUnifiedPortalWorkflow.verifyPaginationTextSiteCustomGroup(driver);
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_7064496_AMER_CH_UNI_Verifyingfields_on_SiteGroupdetailspage--------->\n  "+e);
		}
	}
}
