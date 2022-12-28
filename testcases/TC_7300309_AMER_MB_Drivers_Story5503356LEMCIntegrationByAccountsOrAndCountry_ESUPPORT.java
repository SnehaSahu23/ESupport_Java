package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_7300309_AMER_MB_Drivers_Story5503356LEMCIntegrationByAccountsOrAndCountry_ESUPPORT extends BaseTest
{
	@Test
	public void validate_TC_7300309_AMER_MB_Drivers_Story5503356LEMCIntegrationByAccountsOrAndCountry_ESUPPORT() 
	{
		try
		{
			System.out.println("Starts TC_7300309_AMER_MB_Drivers_Story5503356LEMCIntegrationByAccountsOrAndCountry_ESUPPORT");
			Thread.sleep(6000);
			obj_EsupportMobileWorkflow.handleCookies(driver);
			
			obj_EsupportMobileWorkflow.ClickExtensionIconAndSelectDevice(driver, "Samsung_Galaxy_S6_Portrait");
            obj_EsupportMobileWorkflow.Switch_To_Mobile_window(driver);
            Thread.sleep(6000);
            obj_EsupportMobileWorkflow.ValidateChangeCountryForCanadaInSearchHomePage(driver);
            obj_EsupportMobileWorkflow.ChangeBackToDisplayedCountryForSupportHomePage(driver);
			
            obj_EsupportMobileWorkflow.ClickSearchServiceTag(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
			
            obj_EsupportMobileWorkflow.pcfClickDriversandDownloadsTab(driver);
			
            obj_EsupportMobileWorkflow.ValidateChangeCountryForCanadaInDriversAndDownloadsPage(driver);
            obj_EsupportMobileWorkflow.ChangeBackToDisplayedCountryInDriversAndDownloadPage(driver);
			
            obj_EsupportMobileWorkflow.ToNavigate_IntegratedSupportHomePage(driver);
			//level 10 user
            obj_EsupportMobileWorkflow.clickSignIn(driver);
            obj_EsupportMobileWorkflow.Emaillogin(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()).split(";")[0],TestNGCreator.TestData.get(Esupport.Password.ordinal()).split(";")[0]);
            obj_EsupportMobileWorkflow.ValidateSupportHomePageFordifferentlogincredentials(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()).split(";")[0],TestNGCreator.TestData.get(Esupport.Password.ordinal()).split(";")[0]);
			obj_EsupportMobileWorkflow.ClickSearchServiceTag(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
			
			obj_EsupportMobileWorkflow.pcfClickDriversandDownloadsTab(driver);
			
			obj_EsupportMobileWorkflow.ValidateDriversAndDownloadPageFordifferentlogincredentials(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()).split(";")[0],TestNGCreator.TestData.get(Esupport.Password.ordinal()).split(";")[0]);
			obj_EsupportMobileWorkflow.signOut(driver);
			obj_EsupportMobileWorkflow.ToNavigate_IntegratedSupportHomePage(driver);
			//level 30 user
			obj_EsupportMobileWorkflow.clickSignIn(driver);
			obj_EsupportMobileWorkflow.Emaillogin(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()).split(";")[1],TestNGCreator.TestData.get(Esupport.Password.ordinal()).split(";")[1]);
			obj_EsupportMobileWorkflow.ValidateSupportHomePageFordifferentlogincredentials(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()).split(";")[0],TestNGCreator.TestData.get(Esupport.Password.ordinal()).split(";")[0]);
			obj_EsupportMobileWorkflow.ClickSearchServiceTag(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
			
			obj_EsupportMobileWorkflow.pcfClickDriversandDownloadsTab(driver);
			
			obj_EsupportMobileWorkflow.ValidateDriversAndDownloadPageFordifferentlogincredentials(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()).split(";")[0],TestNGCreator.TestData.get(Esupport.Password.ordinal()).split(";")[0]);
			obj_EsupportMobileWorkflow.signOut(driver);
			obj_EsupportMobileWorkflow.ToNavigate_IntegratedSupportHomePage(driver);
			//level 40 user
			obj_EsupportMobileWorkflow.clickSignIn(driver);
			obj_EsupportMobileWorkflow.Emaillogin(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()).split(";")[2],TestNGCreator.TestData.get(Esupport.Password.ordinal()).split(";")[2]);
			obj_EsupportMobileWorkflow.ValidateSupportHomePageFordifferentlogincredentials(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()).split(";")[0],TestNGCreator.TestData.get(Esupport.Password.ordinal()).split(";")[0]);
			obj_EsupportMobileWorkflow.ClickSearchServiceTag(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
			
			obj_EsupportMobileWorkflow.pcfClickDriversandDownloadsTab(driver);
			obj_EsupportMobileWorkflow.ValidateDriversAndDownloadPageFordifferentlogincredentials(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()).split(";")[0],TestNGCreator.TestData.get(Esupport.Password.ordinal()).split(";")[0]);
			
			
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_7300309_AMER_MB_Drivers_Story5503356LEMCIntegrationByAccountsOrAndCountry_ESUPPORT--------->\n  "+e);
		}
	}
}
