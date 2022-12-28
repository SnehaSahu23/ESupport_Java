package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_7222739_AMER_CH_PORTAL_PDFDownloadvisualizationinGraphViewunderTechnicalAdvisory extends BaseTest
{
	@Test
	public void validate_TC_7222739_AMER_CH_PORTAL_PDFDownloadvisualizationinGraphViewunderTechnicalAdvisory() 
	{
		try
		{
			System.out.println("Starts TC_7222739_AMER_CH_PORTAL_PDFDownloadvisualizationinGraphViewunderTechnicalAdvisory");
			obj_EsupportPortalWorkflow.handleCookies(driver);
			obj_EsupportIPSWorkflow.Emaillogin(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			Thread.sleep(20000);
			obj_EsupportPortalWorkflow.clickChangeViewLink(driver);		
			obj_EsupportPortalWorkflow.clickHealthAndRiskTab(driver);			
			obj_EsupportPortalWorkflow.clickTechnicalAdvisoryTab(driver);	
			obj_EsupportPortalWorkflow.clickHealthRiskGraphView(driver);	
			obj_EsupportPortalWorkflow.clickTechnicalAdvisoryAmerRegionAndDownloadButton(driver);	
			obj_EsupportPortalWorkflow.clickTechnicalAdvisoryRegionPopupCloseButton(driver);	
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_7222739_AMER_CH_PORTAL_PDFDownloadvisualizationinGraphViewunderTechnicalAdvisory--------->\n  "+e);
		}
	}
}