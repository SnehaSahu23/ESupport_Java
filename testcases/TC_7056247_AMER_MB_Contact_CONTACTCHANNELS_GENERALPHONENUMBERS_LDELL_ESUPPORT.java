package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.MobileTestNGCreator;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_7056247_AMER_MB_Contact_CONTACTCHANNELS_GENERALPHONENUMBERS_LDELL_ESUPPORT extends MobilePage
{
	@Test
	public void validate_TC_7056247_AMER_MB_Contact_CONTACTCHANNELS_GENERALPHONENUMBERS_LDELL_ESUPPORT() 
	{

		try
		{
			System.out.println("Starts TC_7056247_AMER_MB_Contact_CONTACTCHANNELS_GENERALPHONENUMBERS_LDELL_ESUPPORT");

			obj_EsupportMobileWorkflow.ClickExtensionsAndPinMobileView(driver);
			obj_EsupportMobileWorkflow.ClickExtensionIconAndSelectDevice(driver, "Samsung_Galaxy_S6_Portrait");
            obj_EsupportMobileWorkflow.Switch_To_Mobile_window(driver);
			
			obj_EsupportMobileWorkflow.handleCookies(driver);
			obj_EsupportMobileWorkflow.ValidateGeneralSupportPhoneNumbersIsDisplayed(driver);
			obj_EsupportMobileWorkflow.ClickOnViewPhoneNumberlink(driver);
			
			
			obj_EsupportMobileWorkflow.ToVerify_EnterServiceTag_HandledPopup(driver,MobileTestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[0]);
			
			obj_EsupportMobileWorkflow.ValidateGeneralSupportPhoneNumbersNotDisplyed(driver);
			obj_EsupportMobileWorkflow.clickChangeProductLink(driver);
			obj_EsupportMobileWorkflow.ValidateGeneralSupportPhoneNumbersIsDisplayed(driver);
		
			obj_EsupportMobileWorkflow.clickBrowseAllProductsLink(driver);
			obj_EsupportMobileWorkflow.clickLaptopsLink(driver);
			obj_EsupportMobileWorkflow.clickLatitudeLink(driver);
			obj_EsupportMobileWorkflow.clickLatitudeSeries(driver,MobileTestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[0]);
			obj_EsupportMobileWorkflow.clickLatitudeSubProduct(driver,MobileTestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[1]);

			obj_EsupportMobileWorkflow.ValidateGeneralSupportPhoneNumbersNotDisplyed(driver);
			obj_EsupportMobileWorkflow.clickChangeProductLink(driver);
			obj_EsupportMobileWorkflow.ValidateGeneralSupportPhoneNumbersIsDisplayed(driver);

			
			obj_EsupportMobileWorkflow.clickOnSignInButton(driver);
			obj_EsupportMobileWorkflow.ToLogin_ValidCredentials(driver,MobileTestNGCreator.TestData.get(Esupport.Username.ordinal()),MobileTestNGCreator.TestData.get(Esupport.Password.ordinal()));
			driver.get("https://www.dell.com/support/incidents-online/en-us/contactus/Dynamic");
			obj_EsupportMobileWorkflow.ValidateGeneralSupportPhoneNumbersIsDisplayed(driver);
			obj_EsupportMobileWorkflow.ClickOnViewPhoneNumberlink(driver);
			
			
			obj_EsupportMobileWorkflow.ToVerify_EnterServiceTag_HandledPopup(driver,MobileTestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[0]);
			
			obj_EsupportMobileWorkflow.ValidateGeneralSupportPhoneNumbersNotDisplyed(driver);
			obj_EsupportMobileWorkflow.clickChangeProductLink(driver);
			obj_EsupportMobileWorkflow.ValidateGeneralSupportPhoneNumbersIsDisplayed(driver);
			
			obj_EsupportMobileWorkflow.clickBrowseAllProductsLink(driver);
			obj_EsupportMobileWorkflow.clickLaptopsLink(driver);
			obj_EsupportMobileWorkflow.clickLatitudeLink(driver);
			obj_EsupportMobileWorkflow.clickLatitudeSeries(driver,MobileTestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[0]);
			obj_EsupportMobileWorkflow.clickLatitudeSubProduct(driver,MobileTestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[1]);

			obj_EsupportMobileWorkflow.ValidateGeneralSupportPhoneNumbersNotDisplyed(driver);
			obj_EsupportMobileWorkflow.clickChangeProductLink(driver);
			obj_EsupportMobileWorkflow.ValidateGeneralSupportPhoneNumbersIsDisplayed(driver);
			
			obj_EsupportMobileWorkflow.SearchForProductCodeAndSelectFromSearchDropDown(driver);
			obj_EsupportMobileWorkflow.ValidateGeneralSupportPhoneNumbersNotDisplyed(driver);
			obj_EsupportMobileWorkflow.clickChangeProductLink(driver);
			
			obj_EsupportMobileWorkflow.signOut(driver);
		}
		catch(Exception e)
		{

			Assert.fail("Failed while TC_7056247_AMER_MB_Contact_CONTACTCHANNELS_GENERALPHONENUMBERS_LDELL_ESUPPORT--------->\n  "+e);

		}

	}
}
