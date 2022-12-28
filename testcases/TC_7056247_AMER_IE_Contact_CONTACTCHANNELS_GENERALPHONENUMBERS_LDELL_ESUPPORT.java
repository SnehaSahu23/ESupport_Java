package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_7056247_AMER_IE_Contact_CONTACTCHANNELS_GENERALPHONENUMBERS_LDELL_ESUPPORT extends BaseTest 
{
	@Test
	public void validate_TC_7056247_AMER_IE_Contact_CONTACTCHANNELS_GENERALPHONENUMBERS_LDELL_ESUPPORT() 
	{

		try
		{
			System.out.println("Starts TC_7056247_AMER_IE_Contact_CONTACTCHANNELS_GENERALPHONENUMBERS_LDELL_ESUPPORT");
			obj_EsupportIncidentsWorkflow.handleCookies(driver);
			obj_EsupportIncidentsWorkflow.ValidateGeneralSupportPhoneNumbersIsDisplayed(driver);
			obj_EsupportIncidentsWorkflow.ClickOnViewPhoneNumberlink(driver);
			
			
			obj_EsupportIncidentsWorkflow.ToVerify_EnterServiceTag_HandledPopup(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[0]);
			
			obj_EsupportIncidentsWorkflow.ValidateGeneralSupportPhoneNumbersNotDisplyed(driver);
			obj_EsupportIncidentsWorkflow.clickChangeProductLink(driver);
			obj_EsupportIncidentsWorkflow.ValidateGeneralSupportPhoneNumbersIsDisplayed(driver);
		
			obj_EsupportIncidentsWorkflow.clickBrowseAllProductsLink(driver);
			obj_EsupportIPSWorkflow.SelectProductFromBrowseAll(driver);
//			obj_EsupportIPSWorkflow.clickLaptopsLink(driver);
//			obj_EsupportIPSWorkflow.clickLatitudeLink(driver);
//			obj_EsupportIPSWorkflow.clickLatitudeSeries(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[0]);
//			obj_EsupportIPSWorkflow.clickLatitudeSubProduct(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[1]);

			obj_EsupportIncidentsWorkflow.ValidateGeneralSupportPhoneNumbersNotDisplyed(driver);
			obj_EsupportIncidentsWorkflow.clickChangeProductLink(driver);
			obj_EsupportIncidentsWorkflow.ValidateGeneralSupportPhoneNumbersIsDisplayed(driver);

			
			obj_EsupportIncidentsWorkflow.clickOnSignInButton(driver);
			obj_EsupportIncidentsWorkflow.ToLogin_ValidCredentials(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			driver.get("https://www.dell.com/support/incidents-online/en-us/contactus/Dynamic");
			obj_EsupportIncidentsWorkflow.ValidateGeneralSupportPhoneNumbersIsDisplayed(driver);
			obj_EsupportIncidentsWorkflow.ClickOnViewPhoneNumberlink(driver);
			
			
			obj_EsupportIncidentsWorkflow.ToVerify_EnterServiceTag_HandledPopup(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[0]);
			
			obj_EsupportIncidentsWorkflow.ValidateGeneralSupportPhoneNumbersNotDisplyed(driver);
			obj_EsupportIncidentsWorkflow.clickChangeProductLink(driver);
			obj_EsupportIncidentsWorkflow.ValidateGeneralSupportPhoneNumbersIsDisplayed(driver);
			
			obj_EsupportIncidentsWorkflow.clickBrowseAllProductsLink(driver);
			obj_EsupportIPSWorkflow.SelectProductFromBrowseAll(driver);
//			obj_EsupportIPSWorkflow.clickLaptopsLink(driver);
//			obj_EsupportIPSWorkflow.clickLatitudeLink(driver);
//			obj_EsupportIPSWorkflow.clickLatitudeSeries(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[0]);
//			obj_EsupportIPSWorkflow.clickLatitudeSubProduct(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[1]);

			obj_EsupportIncidentsWorkflow.ValidateGeneralSupportPhoneNumbersNotDisplyed(driver);
			obj_EsupportIncidentsWorkflow.clickChangeProductLink(driver);
			obj_EsupportIncidentsWorkflow.ValidateGeneralSupportPhoneNumbersIsDisplayed(driver);
			
			obj_EsupportIncidentsWorkflow.SearchForProductCodeAndSelectFromSearchDropDown(driver);
			obj_EsupportIncidentsWorkflow.ValidateGeneralSupportPhoneNumbersNotDisplyed(driver);
			obj_EsupportIncidentsWorkflow.clickChangeProductLink(driver);
			
			obj_EsupportIPSWorkflow.signOut(driver);
		}
		catch(Exception e)
		{

			Assert.fail("Failed while TC_7056247_AMER_IE_Contact_CONTACTCHANNELS_GENERALPHONENUMBERS_LDELL_ESUPPORT--------->\n  "+e);

		}

	}
}
