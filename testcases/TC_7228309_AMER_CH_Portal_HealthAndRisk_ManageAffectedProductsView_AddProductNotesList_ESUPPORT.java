package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_7228309_AMER_CH_Portal_HealthAndRisk_ManageAffectedProductsView_AddProductNotesList_ESUPPORT extends BaseTest
{
	@Test
	public void validate_TC_7228309_AMER_CH_Portal_HealthAndRisk_ManageAffectedProductsView_AddProductNotesList_ESUPPORT() 
	{
		try
		{
			System.out.println("Starts TC_7228309_AMER_CH_Portal_HealthAndRisk_ManageAffectedProductsView_AddProductNotesList_ESUPPORT");
				
			obj_EsupportPortalWorkflow.handleCookies(driver);
			obj_EsupportIPSWorkflow.Emaillogin(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			
			obj_EsupportPortalWorkflow.clickHealthAndRiskTab(driver);			
			obj_EsupportPortalWorkflow.clickSecurityAdvisoryTab(driver);
			
			obj_EsupportPortalWorkflow.ValidateForLocationNamesForZoomOut(driver);
			obj_EsupportPortalWorkflow.DoubleClickOnMapToZoomIn(driver);
			obj_EsupportPortalWorkflow.ClickOnTabularView(driver);
			obj_EsupportPortalWorkflow.ClickOnMap(driver);
			
			obj_EsupportPortalWorkflow.ValidateForLocationNamesForZoomOut(driver);

		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_7228309_AMER_CH_Portal_HealthAndRisk_ManageAffectedProductsView_AddProductNotesList_ESUPPORT--------->\n  "+e);
		}
	}
}
