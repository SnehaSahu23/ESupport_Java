package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.MobileTestNGCreator;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_10108521_AMER_MB_IPS_LEMC_SerializedHeroProductNicknameViewAddEdit_Esupport extends MobilePage
{
	@Test
	public void validate_TC_10108521_AMER_CH_IPS_LEMC_SerializedHeroProductNicknameViewAddEdit_Esupport() throws Throwable 
	{
		try
		{
			System.out.println("Starts TC_10108521_AMER_CH_IPS_LEMC_SerializedHeroProductNicknameViewAddEdit_Esupport");
			
			 obj_EsupportMobileWorkflow.clickSignIn(driver);
	         obj_EsupportMobileWorkflow.ToLogin_ValidCredentials(driver,MobileTestNGCreator.TestData.get(Esupport.Username.ordinal()),MobileTestNGCreator.TestData.get(Esupport.Password.ordinal()));
		 	Thread.sleep(5000);
			
			obj_EsupportMobileWorkflow.ClickExtensionsAndPinMobileView(driver);
			obj_EsupportMobileWorkflow.ClickExtensionIconAndSelectDevice(driver, "Samsung_Galaxy_S6_Portrait");
            obj_EsupportMobileWorkflow.Switch_To_Mobile_window(driver);
			
           
			// product have nickname
			obj_EsupportMobileWorkflow.searchServiceTag(driver, MobileTestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
	          
			//obj_EsupportMobileWorkflow.verifyNickname_AlreadyAdded(driver);
			Thread.sleep(20000);
			obj_EsupportMobileWorkflow.verifyEditDelete(driver);
			obj_EsupportMobileWorkflow.clickEdit(driver);
			obj_EsupportMobileWorkflow.addNickname(driver, MobileTestNGCreator.TestData.get(Esupport.FirstName.ordinal()));
			
			// product don't have nickname
			obj_EsupportMobileWorkflow.deleteNickname(driver);
			obj_EsupportMobileWorkflow.VerifyAddNewNickname(driver);
			obj_EsupportMobileWorkflow.addNickname(driver, MobileTestNGCreator.TestData.get(Esupport.FirstName.ordinal()));
			
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_10108521_AMER_CH_IPS_LEMC_SerializedHeroProductNicknameViewAddEdit_Esupport--------->\n  "+e);
		}
	}
}
