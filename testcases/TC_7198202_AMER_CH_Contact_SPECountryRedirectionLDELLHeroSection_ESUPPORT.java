package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_7198202_AMER_CH_Contact_SPECountryRedirectionLDELLHeroSection_ESUPPORT extends BaseTest
{
	@Test
	public void validate_TC_7198202_AMER_CH_Contact_SPECountryRedirectionLDELLHeroSection_ESUPPORT() 
	{
		try
		{
			System.out.println("Starts TC_7198202_AMER_CH_Contact_SPECountryRedirectionLDELLHeroSection_ESUPPORT");
			
			//for guest user
//			obj_EsupportIncidentsWorkflow.ToVerify_EnterServiceTag_HandledPopup(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[0]);
//			obj_EsupportIPSWorkflow.verifyProductImageHeroSection(driver);
//			obj_EsupportIPSWorkflow.verifyEnterServiceTagLink(driver);
//			obj_EsupportIPSWorkflow.verifyChangeProductLink(driver);
//			obj_EsupportIPSWorkflow.clickEnterServiceTagLink(driver);
//			obj_EsupportIPSWorkflow.clickEnterServiceTagPopupCloseButton(driver);
//			obj_EsupportIPSWorkflow.clickEnterServiceTagLink(driver);			
//			obj_EsupportIncidentsWorkflow.enterServiceTagModalPopup(driver, TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[1]);	
//			
//			obj_EsupportIPSWorkflow.clickChangeProductLink(driver);
			
			obj_EsupportIncidentsWorkflow.ToVerify_EnterServiceTag_HandledPopup(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[1]);
			obj_EsupportIPSWorkflow.verifyServiceTagHeroSection(driver);
			//added method as part of 0702
			obj_EsupportIPSWorkflow.verifyServiceTagHyperlinkAndClickOnServiceTagLink(driver);
//			driver.get("https://www.dell.com/support/incidents-online/en-us/contactus/");
			Thread.sleep(5000);
//			obj_EsupportIncidentsWorkflow.ToVerify_EnterServiceTag_HandledPopup(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[1]);
			obj_EsupportIncidentsWorkflow.ToHandle_POpUp(driver);
			obj_EsupportIPSWorkflow.verifyProductImageHeroSection(driver);
			obj_EsupportIPSWorkflow.verifyProductHeroSectionDetails(driver);
			
			obj_EsupportIncidentsWorkflow.verifyChangeProductLink(driver);
			obj_EsupportIncidentsWorkflow.verifySystemConfigurationLink(driver);	
			obj_EsupportIncidentsWorkflow.VerifyExtendOrUpgradelink(driver);
			
			//click on add nickname before sign in
			obj_EsupportIPSWorkflow.ClickAddNewNickname(driver);
			obj_EsupportIncidentsWorkflow.ToLogin_ValidCredentials_SigninPage(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			obj_EsupportIPSWorkflow.VerifyAddNewNickname(driver);
			obj_EsupportIPSWorkflow.signOut(driver);
			obj_EsupportIncidentsWorkflow.clickChangeProductLink(driver);
//			
//			
//			// for authenticated user
//			
//			obj_EsupportIncidentsWorkflow.clickOnSignInButton(driver);
//			obj_EsupportIncidentsWorkflow.ToLogin_ValidCredentials(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
//			Thread.sleep(5000);
//			obj_EsupportIncidentsWorkflow.ToVerify_EnterServiceTag_HandledPopup(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[0]);
//			obj_EsupportIncidentsWorkflow.verifyProductImageHeroSection_AfterSignIn(driver);
//			obj_EsupportIPSWorkflow.verifyEnterServiceTagLink(driver);
//			obj_EsupportIncidentsWorkflow.verifyChangeProductLink(driver);
//			obj_EsupportIPSWorkflow.clickEnterServiceTagLink(driver);
//			obj_EsupportIPSWorkflow.clickEnterServiceTagPopupCloseButton(driver);
//			obj_EsupportIPSWorkflow.clickEnterServiceTagLink(driver);			
//			obj_EsupportIncidentsWorkflow.enterServiceTagModalPopup(driver, TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[1]);	
//			
//			obj_EsupportIncidentsWorkflow.clickChangeProductLink(driver);
//			
			obj_EsupportIncidentsWorkflow.ToVerify_EnterServiceTag_HandledPopup(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[1]);
			
//			//after clicking on change product
//			obj_EsupportIPSWorkflow.verifyServiceTagHeroSection(driver);
//			obj_EsupportIncidentsWorkflow.verifyProductImageHeroSection_AfterSignIn(driver);
//			obj_EsupportIPSWorkflow.verifyProductHeroSectionDetails(driver);
//			obj_EsupportIncidentsWorkflow.VerifyAddNewNickname_Aftersignin(driver);
//			obj_EsupportIncidentsWorkflow.verifyChangeProductLink(driver);
//			obj_EsupportIncidentsWorkflow.verifySystemConfigurationLink(driver);	
//			obj_EsupportIncidentsWorkflow.VerifyExtendOrUpgradelink(driver);
//			
//			// click add nick name after sign in
//			obj_EsupportIncidentsWorkflow.ClickAddNewNickname_AfterSignin(driver);
//			obj_EsupportIncidentsWorkflow.EnterNewNickname_AfterLogin(driver);
			
			//click view details link
			obj_EsupportIncidentsWorkflow.clickViewDetailsLink(driver);
			obj_EsupportIncidentsWorkflow.VerifyClickingXButtonOnWarrantyPage(driver);
		
			

			//configuration link validation
			
			obj_EsupportIncidentsWorkflow.verifySystemConfigurationLink(driver);	
			obj_EsupportIncidentsWorkflow.clickSystemConfigurationLink(driver);	
			obj_EsupportIPSWorkflow.verifyModalPopupConfiguration(driver);	
			obj_EsupportIPSWorkflow.verifyConfigurationTable(driver);	
			obj_EsupportIPSWorkflow.verifyExportOption(driver);	
			obj_EsupportIPSWorkflow.clickExportOption(driver);	
			obj_EsupportIPSWorkflow.clickCurrentConfigurationTab(driver);	
			obj_EsupportIPSWorkflow.verifyRunSupportAssistButton(driver);	
			obj_EsupportIPSWorkflow.clickModalPopupCloseButton(driver);	
			
			//click extend or upgrade link
			obj_EsupportIncidentsWorkflow.ClickExtendOrUpgradelink(driver);
			driver.get("https://www.dell.com/support/incidents-online/en-us/contactus");
			obj_EsupportIncidentsWorkflow.clickOnSignInButton(driver);
			obj_EsupportIncidentsWorkflow.ToLogin_ValidCredentials(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			Thread.sleep(5000);
			
			obj_EsupportIncidentsWorkflow.ToVerify_EnterServiceTag_HandledPopup(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[1]);
			obj_EsupportIPSWorkflow.verifyServiceTagHeroSection(driver);
			//added method as part of 0702
			obj_EsupportIPSWorkflow.verifyServiceTagHyperlinkAndClickOnServiceTagLink(driver);
//			driver.get("https://www.dell.com/support/incidents-online/en-us/contactus/");
			Thread.sleep(5000);
//			obj_EsupportIncidentsWorkflow.ToVerify_EnterServiceTag_HandledPopup(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[1]);
			obj_EsupportIncidentsWorkflow.ToHandle_POpUp(driver);
			obj_EsupportIPSWorkflow.verifyProductImageHeroSection(driver);
			obj_EsupportIPSWorkflow.verifyProductHeroSectionDetails(driver);
			
			obj_EsupportIncidentsWorkflow.verifyChangeProductLink(driver);
			obj_EsupportIncidentsWorkflow.verifySystemConfigurationLink(driver);	
			obj_EsupportIncidentsWorkflow.VerifyExtendOrUpgradelink(driver);
			
			//click on add nickname before sign in
//			obj_EsupportIPSWorkflow.ClickAddNewNickname(driver);
//			obj_EsupportIncidentsWorkflow.ToLogin_ValidCredentials_SigninPage(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			obj_EsupportIPSWorkflow.VerifyAddNewNickname(driver);
//			obj_EsupportIPSWorkflow.signOut(driver);
			obj_EsupportIncidentsWorkflow.clickChangeProductLink(driver);
			obj_EsupportIncidentsWorkflow.ToVerify_EnterServiceTag_HandledPopup(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[1]);
			//click view details link
			obj_EsupportIncidentsWorkflow.clickViewDetailsLink(driver);
			obj_EsupportIncidentsWorkflow.VerifyClickingXButtonOnWarrantyPage(driver);
		
			

			//configuration link validation
			
			obj_EsupportIncidentsWorkflow.verifySystemConfigurationLink(driver);	
			obj_EsupportIncidentsWorkflow.clickSystemConfigurationLink(driver);	
			obj_EsupportIPSWorkflow.verifyModalPopupConfiguration(driver);	
			obj_EsupportIPSWorkflow.verifyConfigurationTable(driver);	
			obj_EsupportIPSWorkflow.verifyExportOption(driver);	
			obj_EsupportIPSWorkflow.clickExportOption(driver);	
			obj_EsupportIPSWorkflow.clickCurrentConfigurationTab(driver);	
			obj_EsupportIPSWorkflow.verifyRunSupportAssistButton(driver);	
			obj_EsupportIPSWorkflow.clickModalPopupCloseButton(driver);	
			
			//click extend or upgrade link
			obj_EsupportIncidentsWorkflow.ClickExtendOrUpgradelink(driver);
			
			obj_EsupportIPSWorkflow.signOut(driver);
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_7198202_AMER_CH_Contact_SPECountryRedirectionLDELLHeroSection_ESUPPORT--------->\n  "+e);
		}
	}
}
