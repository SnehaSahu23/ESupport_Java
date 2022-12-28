package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_9470386_AMER_ED_LBK_Portal_Story9468853PortalDSAChangethedownloadfunctionalityofthearticles_ESUPPORT extends BaseTest
{
	@Test
	public void validate_TC_9470386_AMER_ED_LBK_Portal_Story9468853PortalDSAChangethedownloadfunctionalityofthearticles_ESUPPORT() 
	{
		try
		{
			System.out.println("Starts TC_9470386_AMER_ED_LBK_Portal_Story9468853PortalDSAChangethedownloadfunctionalityofthearticles_ESUPPORT");
				
			obj_EsupportPortalWorkflow.handleCookies(driver);
			obj_EsupportIPSWorkflow.Emaillogin(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			
			obj_EsupportPortalWorkflow.clickHealthAndRiskTab_Phase2(driver);			
			obj_EsupportPortalWorkflow.clickSecurityAdvisoryTab_Phase2(driver);
			
			obj_EsupportPortalWorkflow.clickExpandButtonOfFirstAdvisory_Phase2(driver);
			obj_EsupportPortalWorkflow.clickOnAdvisoryID_Phase2(driver);
			obj_EsupportPortalWorkflow.MouseHoverOnDownloadLink_Phase2(driver);
			obj_EsupportPortalWorkflow.ClickOnDownloadOrPrintLink_Phase2(driver);
			
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_9470386_AMER_ED_LBK_Portal_Story9468853PortalDSAChangethedownloadfunctionalityofthearticles_ESUPPORT--------->\n  "+e);
		}
	}
}


