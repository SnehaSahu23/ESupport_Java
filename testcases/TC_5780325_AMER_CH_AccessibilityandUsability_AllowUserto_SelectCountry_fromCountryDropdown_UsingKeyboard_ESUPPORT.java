package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_5780325_AMER_CH_AccessibilityandUsability_AllowUserto_SelectCountry_fromCountryDropdown_UsingKeyboard_ESUPPORT extends BaseTest {
	@Test
	public void validate_TC_5780325_AMER_CH_AccessibilityandUsability_AllowUserto_SelectCountry_fromCountryDropdown_UsingKeyboard_ESUPPORT() 
	{

		try
		{
			System.out.println("Starts TC# 5780325_AMER_CH_AccessibilityandUsability_AllowUserto_SelectCountry_fromCountryDropdown_UsingKeyboard_ESUPPORT");
			// Thread.sleep(1000000);
			obj_EsupportIntegratedHomePageWorkflow.handleCookies(driver);
//			obj_EsupportIntegratedHomePageWorkflow.to_Scrolldownthepage(driver);
//			obj_EsupportIntegratedHomePageWorkflow.to_CheckCountrySelector(driver);
//			obj_EsupportIntegratedHomePageWorkflow.to_ClickCountrySelector_Arrow(driver);
//			obj_EsupportIntegratedHomePageWorkflow.to_KeyPressing(driver);
//			obj_EsupportIntegratedHomePageWorkflow.to_PressDownArrow(driver);
//			obj_EsupportIntegratedHomePageWorkflow.to_PressUPArrow(driver);
//			obj_EsupportIntegratedHomePageWorkflow.changeCountry(driver);
			obj_EsupportContentWorkflow.changeCountry_New(driver);




		}
		catch(Exception e){

			Assert.fail("Failed while executing test case TC_5780325_AMER_CH_AccessibilityandUsability_AllowUserto_SelectCountry_fromCountryDropdown_UsingKeyboard_ESUPPORT--------->\n  "+e);

		}

	}

}
