package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_7908803_AMER_CH_PORTAL_ColumnOrderinginExpandedviewacrosstabs extends BaseTest
{
	@Test
	public void validate_TC_7908803_AMER_CH_PORTAL_ColumnOrderinginExpandedviewacrosstabs() 
	{
		try
		{
			System.out.println("Starts TC_7908803_AMER_CH_PORTAL_ColumnOrderinginExpandedviewacrosstabs");
			obj_EsupportPortalWorkflow.handleCookies(driver);
			obj_EsupportIPSWorkflow.Emaillogin(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			Thread.sleep(20000);
			obj_EsupportPortalWorkflow.clickInstallBaseTab(driver);
			obj_EsupportPortalWorkflow.clickIncidentManagementExpandButton(driver);
			Thread.sleep(10000);
			obj_EsupportPortalWorkflow.verifyInstallBaseTotalAssetsColumnsOrderExpandedView(driver);
			obj_EsupportPortalWorkflow.closeExpandedView(driver);
			
			Thread.sleep(10000);
			obj_EsupportPortalWorkflow.clickIncidentManagementTab(driver);
			obj_EsupportPortalWorkflow.clickIncidentManagementExpandButton(driver);
			Thread.sleep(10000);
			obj_EsupportPortalWorkflow.verifyIncidentManagementTotalSRColumnsOrderExpandedView(driver);
			obj_EsupportPortalWorkflow.closeExpandedView(driver);
			Thread.sleep(10000);
			
			obj_EsupportPortalWorkflow.clickIncidentManagementEscalationsButton(driver);
			obj_EsupportPortalWorkflow.clickIncidentManagementExpandButton(driver);
			Thread.sleep(10000);
			obj_EsupportPortalWorkflow.verifyIncidentManagementEscalationsColumnsOrderExpandedView(driver);
			obj_EsupportPortalWorkflow.closeExpandedView(driver);
			Thread.sleep(10000);
			
			obj_EsupportPortalWorkflow.clickIncidentManagementOnsiteServiceButton(driver);
			obj_EsupportPortalWorkflow.clickIncidentManagementExpandButton(driver);
			Thread.sleep(10000);
			obj_EsupportPortalWorkflow.verifyIncidentManagementOnsiteServicesColumnsOrderExpandedView(driver);
			obj_EsupportPortalWorkflow.closeExpandedView(driver);
			Thread.sleep(10000);
			
			obj_EsupportPortalWorkflow.clickHealthAndRiskTab(driver);
			obj_EsupportPortalWorkflow.clickIncidentManagementExpandButton(driver);
			Thread.sleep(10000);
			obj_EsupportPortalWorkflow.verifyHealthAndRiskFCOColumnsOrderExpandedView(driver);
			obj_EsupportPortalWorkflow.closeExpandedView(driver);
			Thread.sleep(10000);
			
			obj_EsupportPortalWorkflow.clickTrackableServiceEventsTab(driver);
			obj_EsupportPortalWorkflow.clickIncidentManagementExpandButton(driver);
			Thread.sleep(10000);
			obj_EsupportPortalWorkflow.verifyHealthAndRiskTrackableServiceEventsColumnsOrderExpandedView(driver);
			obj_EsupportPortalWorkflow.closeExpandedView(driver);
			Thread.sleep(10000);

		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_7908803_AMER_CH_PORTAL_ColumnOrderinginExpandedviewacrosstabs--------->\n  "+e);
		}
	}
}

