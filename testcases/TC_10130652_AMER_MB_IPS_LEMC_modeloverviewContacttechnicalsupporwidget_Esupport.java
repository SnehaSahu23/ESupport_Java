package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_10130652_AMER_MB_IPS_LEMC_modeloverviewContacttechnicalsupporwidget_Esupport extends BaseTest
{
	@Test
	public void validate_TC_10130652_AMER_MB_IPS_LEMC_modeloverviewContacttechnicalsupporwidget_Esupport() 
	{
		try
		{
			System.out.println("Starts TC_10130652_AMER_MB_IPS_LEMC_modeloverviewContacttechnicalsupporwidget_Esupport");
			Thread.sleep(6000);
			obj_EsupportMobileWorkflow.handleCookies(driver);
			
			obj_EsupportMobileWorkflow.ClickExtensionIconAndSelectDevice(driver, "Samsung_Galaxy_S6_Portrait");
            obj_EsupportMobileWorkflow.Switch_To_Mobile_window(driver);
            Thread.sleep(6000);
			
            obj_EsupportMobileWorkflow.clickSignIn(driver);
            obj_EsupportMobileWorkflow.Emaillogin(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			Thread.sleep(5000);
			obj_EsupportMobileWorkflow.launchUrl(driver, TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
			
			obj_EsupportMobileWorkflow.ContactTechnicalSection(driver);			
			
			obj_EsupportMobileWorkflow.clickContactTechnicalSupportLink(driver);
			
			
		}
		catch(Exception e)
		{
			Assert.fail("Failed executing TC_10130652_AMER_MB_IPS_LEMC_modeloverviewContacttechnicalsupporwidget_Esupport--------->\n  "+e);
		}
	}
}
