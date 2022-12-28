package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_5795108_AMER_FF_NavigationtoSRSearchpagethroughdirectURL_Esupport extends BaseTest 
{
	@Test
	public void validate_TC_5795108_AMER_FF_NavigationtoSRSearchpagethroughdirectURL_Esupport() 
	{
		try
		{
			System.out.println("Starts TC_5795108_AMER_FF_NavigationtoSRSearchpagethroughdirectURL_Esupport");
			obj_EsupportIncidentsWorkflow.navigateToSRPage(driver);			
			obj_EsupportIncidentsWorkflow.verifyRecentlyViewed(driver);			
			obj_EsupportIncidentsWorkflow.verifyManageYourServiceRequestSection(driver);
			obj_EsupportIncidentsWorkflow.verifyViewAllServiceRequestButtons(driver, true);
			obj_EsupportIntegratedHomePageWorkflow.ClickSignIn(driver);
			obj_EsupportIntegratedHomePageWorkflow.Emaillogin(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			
			obj_EsupportIncidentsWorkflow.clickSignout(driver);	
			obj_EsupportIncidentsWorkflow.verifyViewAllServiceRequestButtons(driver, false);
			
			obj_EsupportIncidentsWorkflow.clickOnSignInButton(driver);	
			driver.navigate().back();
			obj_EsupportIncidentsWorkflow.clickOnContactTechSupportButton(driver);
			
		}
		
		catch(Exception e)
		{
			Assert.fail("Failed while TC_5795108_AMER_FF_NavigationtoSRSearchpagethroughdirectURL_Esupport--------->\n  "+e);
		}

	}
}
