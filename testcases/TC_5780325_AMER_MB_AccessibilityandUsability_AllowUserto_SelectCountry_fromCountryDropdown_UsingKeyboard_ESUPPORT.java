package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_5780325_AMER_MB_AccessibilityandUsability_AllowUserto_SelectCountry_fromCountryDropdown_UsingKeyboard_ESUPPORT extends MobilePage {
	@Test
	public void validate_TC_5780325_AMER_MB_AccessibilityandUsability_AllowUserto_SelectCountry_fromCountryDropdown_UsingKeyboard_ESUPPORT() 
	{

		try
		{
			System.out.println("Starts TC# TC_5780325_AMER_MB_AccessibilityandUsability_AllowUserto_SelectCountry_fromCountryDropdown_UsingKeyboard_ESUPPORT");
			
			Thread.sleep(6000);
			obj_EsupportMobileWorkflow.handleCookies(driver);
			obj_EsupportMobileWorkflow.ClickExtensionsAndPinMobileView(driver);
			obj_EsupportMobileWorkflow.ClickExtensionIconAndSelectDevice(driver, "Samsung_Galaxy_S6_Portrait");
            obj_EsupportMobileWorkflow.Switch_To_Mobile_window(driver);
            Thread.sleep(6000);
			
            obj_EsupportMobileWorkflow.to_Scrolldownthepage(driver);
            obj_EsupportMobileWorkflow.to_CheckCountrySelector(driver);
            obj_EsupportMobileWorkflow.to_ClickCountrySelector_Arrow(driver);
            obj_EsupportMobileWorkflow.to_KeyPressing(driver);
            obj_EsupportMobileWorkflow.to_PressDownArrow(driver);
            obj_EsupportMobileWorkflow.to_PressUPArrow(driver);
            obj_EsupportMobileWorkflow.changeCountry(driver);




		}
		catch(Exception e){

			Assert.fail("Failed while executing test case TC_5780325_AMER_MB_AccessibilityandUsability_AllowUserto_SelectCountry_fromCountryDropdown_UsingKeyboard_ESUPPORT--------->\n  "+e);

		}

	}

}
