package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_7221702_AMER_CH_PORTAL_DisplayaffectedproductslistwithExpandCollapseforSecurityandtechnicaladvisory extends BaseTest
{
	@Test
	public void validate_TC_7221702_AMER_CH_PORTAL_DisplayaffectedproductslistwithExpandCollapseforSecurityandtechnicaladvisory() 
	{
		try
		{
			System.out.println("Starts TC_7221702_AMER_CH_PORTAL_DisplayaffectedproductslistwithExpandCollapseforSecurityandtechnicaladvisory");
			obj_EsupportPortalWorkflow.handleCookies(driver);
			obj_EsupportIPSWorkflow.Emaillogin(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			Thread.sleep(20000);
			obj_EsupportPortalWorkflow.clickHealthAndRiskTab(driver);			
			obj_EsupportPortalWorkflow.clickSecurityAdvisoryTab(driver);		
			obj_EsupportPortalWorkflow.clickSecurityAdvisoryIDFirstRow(driver);
			obj_EsupportPortalWorkflow.verifyManageAffectedProductsColumns(driver);
			obj_EsupportPortalWorkflow.verifyAdvisoryDetailsPopupProductsDefaultView(driver);
			obj_EsupportPortalWorkflow.verifyAdvisoryDetailsPopupProductsCollapsedView(driver);
			obj_EsupportPortalWorkflow.verifyAdvisoryDetailsPopupProductsExpandedView(driver);
			obj_EsupportPortalWorkflow.clickAdvisoryDetailsPopupCloseButton(driver);
			obj_EsupportPortalWorkflow.clickTechnicalAdvisoryTab(driver);	
			obj_EsupportPortalWorkflow.clickSecurityAdvisoryIDFirstRow(driver);
			obj_EsupportPortalWorkflow.verifyManageAffectedProductsColumns(driver);
			obj_EsupportPortalWorkflow.verifyAdvisoryDetailsPopupProductsDefaultView(driver);
			obj_EsupportPortalWorkflow.verifyAdvisoryDetailsPopupProductsCollapsedView(driver);
			obj_EsupportPortalWorkflow.verifyAdvisoryDetailsPopupProductsExpandedView(driver);
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_7221702_AMER_CH_PORTAL_DisplayaffectedproductslistwithExpandCollapseforSecurityandtechnicaladvisory--------->\n  "+e);
		}
	}
}