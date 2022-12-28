package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.MobileTestNGCreator;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_7056471_AMER_MB_ContactUSSPENexttellusthenatureoftherequesttextandissuedropdownboxLDELL extends MobilePage
{
	@Test
	public void validate_TC_7056471_AMER_MB_ContactUSSPENexttellusthenatureoftherequesttextandissuedropdownboxLDELL() 
	{
		try
		{
			System.out.println("Starts 7056471_AMER_MB_ContactUSSPENexttellusthenatureoftherequesttextandissuedropdownboxLDELL");
			
            obj_EsupportMobileWorkflow.handleCookies(driver);
            
            obj_EsupportMobileWorkflow.ClickExtensionsAndPinMobileView(driver);
			obj_EsupportMobileWorkflow.ClickExtensionIconAndSelectDevice(driver, "Samsung_Galaxy_S6_Portrait");
            obj_EsupportMobileWorkflow.Switch_To_Mobile_window(driver);
			
			obj_EsupportMobileWorkflow.validateCtsHomePage(driver);	
			
			obj_EsupportMobileWorkflow.clickOnSignInButton(driver);
			obj_EsupportMobileWorkflow.ToLogin_ValidCredentials(driver,MobileTestNGCreator.TestData.get(Esupport.Username.ordinal()),MobileTestNGCreator.TestData.get(Esupport.Password.ordinal()));
			driver.get("https://www.dell.com/support/incidents-online/en-us/contactus/Dynamic");
			obj_EsupportMobileWorkflow.validateNatureofRequestandIssueListDropdown(driver);
			obj_EsupportMobileWorkflow.ToVerify_EnterServiceTag_HandledPopup(driver,MobileTestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
			
			//obj_EsupportMobileWorkflow.signOut(driver);
			Thread.sleep(10000);
//			obj_EsupportIncidentsWorkflow.enterDataSearchTextbox(driver, TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));			
		}
		
		catch(Exception e)
		{
			Assert.fail("Failed while executing 7056471_AMER_MB_ContactUSSPENexttellusthenatureoftherequesttextandissuedropdownboxLDELL--------->\n  "+e);
		}

	}
}
