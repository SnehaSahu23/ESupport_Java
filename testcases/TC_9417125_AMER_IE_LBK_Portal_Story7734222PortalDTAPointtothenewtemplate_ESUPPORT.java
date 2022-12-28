package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_9417125_AMER_IE_LBK_Portal_Story7734222PortalDTAPointtothenewtemplate_ESUPPORT extends BaseTest
{
	@Test
	public void validate_TC_9417125_AMER_IE_LBK_Portal_Story7734222PortalDTAPointtothenewtemplate_ESUPPORT() 
	{
		try
		{
			System.out.println("Starts TC_9417125_AMER_IE_LBK_Portal_Story7734222PortalDTAPointtothenewtemplate_ESUPPORT");
				
			obj_EsupportPortalWorkflow.handleCookies(driver);
			obj_EsupportIPSWorkflow.Emaillogin(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			
			obj_EsupportPortalWorkflow.clickHealthAndRiskTab_Phase2(driver);			
			obj_EsupportPortalWorkflow.clickTechnicalAdvisoryTab_Phase2(driver);
			
			obj_EsupportPortalWorkflow.clickOnAdvisoryID_Phase2_SecurityAdv(driver);
			obj_EsupportPortalWorkflow.MouseHoverOnSeeFullAdvisoryLink_Phase2(driver);
			obj_EsupportPortalWorkflow.ClickOnSellAllAdvisory_Phase2(driver);
			obj_EsupportPortalWorkflow.MouseHoverOnDocumentsLink_Phase2(driver);
			
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_9417125_AMER_IE_LBK_Portal_Story7734222PortalDTAPointtothenewtemplate_ESUPPORT--------->\n  "+e);
		}
	}
}




