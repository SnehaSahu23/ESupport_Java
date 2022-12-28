package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_7057435_AMER_CH_Portal_IBGeoView_LocationLabels_ESUPPORT extends BaseTest
{
	@Test
	public void validate_TC_7057435_AMER_CH_Portal_IBGeoView_LocationLabels_ESUPPORT() 
	{
		try
		{
			System.out.println("Starts TC_7057435_AMER_CH_Portal_IBGeoView_LocationLabels_ESUPPORT");
				
			obj_EsupportPortalWorkflow.handleCookies(driver);
			obj_EsupportIPSWorkflow.Emaillogin(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			obj_EsupportPortalWorkflow.ClickOnInstallBaseTab(driver);
			
			obj_EsupportPortalWorkflow.ClickOnMap(driver);
			obj_EsupportPortalWorkflow.ValidateForLocationNamesForZoomOut(driver);
			obj_EsupportPortalWorkflow.DoubleClickOnMapToZoomIn(driver);
			obj_EsupportPortalWorkflow.ClickOnTabularView(driver);
			obj_EsupportPortalWorkflow.ClickOnMap(driver);
			
			obj_EsupportPortalWorkflow.ValidateForLocationNamesForZoomOut(driver);

		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_7057435_AMER_CH_Portal_IBGeoView_LocationLabels_ESUPPORT--------->\n  "+e);
		}
	}
}
