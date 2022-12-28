package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.MobileTestNGCreator;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_6880930_AMER_MB_IPS_LdellTaggedUnauthenticatedLogintoaddnickname_Esupport extends MobilePage
{
	@Test
	public void validate_TC_6880930_AMER_MB_IPS_LdellTaggedUnauthenticatedLogintoaddnickname_Esupport() 
	{
		try
		{
			System.out.println("Starts TC_6880930_AMER_MB_IPS_LdellTaggedUnauthenticatedLogintoaddnickname_Esupport");
			Thread.sleep(6000);
			obj_EsupportMobileWorkflow.handleCookies(driver);
			obj_EsupportMobileWorkflow.ClickExtensionsAndPinMobileView(driver);
			obj_EsupportMobileWorkflow.ClickExtensionIconAndSelectDevice(driver, "Samsung_Galaxy_S6_Portrait");
            obj_EsupportMobileWorkflow.Switch_To_Mobile_window(driver);
            Thread.sleep(6000);
            obj_EsupportMobileWorkflow.searchServiceTag_LDELL(driver,MobileTestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
            obj_EsupportMobileWorkflow.VerifyLogInToAddNewNickname(driver);
            obj_EsupportMobileWorkflow.ClickAddNewNickname(driver);
            obj_EsupportMobileWorkflow.ToLogin_ValidCredentials(driver,MobileTestNGCreator.TestData.get(Esupport.Username.ordinal()),MobileTestNGCreator.TestData.get(Esupport.Password.ordinal()));
//            obj_EsupportMobileWorkflow.ToLogin_ValidCredentials_SigninPage(driver, MobileTestNGCreator.TestData.get(Esupport.Username.ordinal()),MobileTestNGCreator.TestData.get(Esupport.Password.ordinal()));
            obj_EsupportMobileWorkflow.VerifyAddNewNickname(driver);
		
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_6880930_AMER_MB_IPS_LdellTaggedUnauthenticatedLogintoaddnickname_Esupport--------->\n  "+e);
		}
	}
}
