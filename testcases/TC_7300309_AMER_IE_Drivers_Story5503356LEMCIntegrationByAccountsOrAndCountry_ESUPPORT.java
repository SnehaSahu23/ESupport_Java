package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_7300309_AMER_IE_Drivers_Story5503356LEMCIntegrationByAccountsOrAndCountry_ESUPPORT extends BaseTest
{
	@Test
	public void validate_TC_7300309_AMER_IE_Drivers_Story5503356LEMCIntegrationByAccountsOrAndCountry_ESUPPORT() 
	{
		try
		{
			System.out.println("Starts TC_7300309_AMER_IE_Drivers_Story5503356LEMCIntegrationByAccountsOrAndCountry_ESUPPORT");
				
//			obj_EsupportDriverandDownloadsWorkflow.ValidateChangeCountryForCanadaInSearchHomePage(driver);
//			obj_EsupportDriverandDownloadsWorkflow.ChangeBackToDisplayedCountryForSupportHomePage(driver);
			
			obj_EsupportContentWorkflow.ClickSearchServiceTag(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
			
			obj_EsupportDriverandDownloadsWorkflow.pcfClickDriversandDownloadsTab(driver);
			
			obj_EsupportDriverandDownloadsWorkflow.ValidateChangeCountryForCanadaInDriversAndDownloadsPage(driver);
			obj_EsupportDriverandDownloadsWorkflow.ChangeBackToDisplayedCountryInDriversAndDownloadPage(driver);
			
			obj_EsupportCoveoWorkflow.ToNavigate_IntegratedSupportHomePage(driver);
			//level 10 user
			obj_EsupportIncidentsWorkflow.clickSignIn(driver);
			obj_EsupportIPSWorkflow.Emaillogin(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()).split(";")[0],TestNGCreator.TestData.get(Esupport.Password.ordinal()).split(";")[0]);
			obj_EsupportDriverandDownloadsWorkflow.ValidateSupportHomePageFordifferentlogincredentials(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()).split(";")[0],TestNGCreator.TestData.get(Esupport.Password.ordinal()).split(";")[0]);
			obj_EsupportContentWorkflow.ClickSearchServiceTag(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
			
			obj_EsupportDriverandDownloadsWorkflow.pcfClickDriversandDownloadsTab(driver);
			obj_EsupportDriverandDownloadsWorkflow.ValidateDriversAndDownloadPageFordifferentlogincredentials(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()).split(";")[0],TestNGCreator.TestData.get(Esupport.Password.ordinal()).split(";")[0]);
			obj_EsupportProductionValidationsWorkflow.signOut(driver);
			obj_EsupportCoveoWorkflow.ToNavigate_IntegratedSupportHomePage(driver);
			//level 30 user
			obj_EsupportIncidentsWorkflow.clickSignIn(driver);
			obj_EsupportIPSWorkflow.Emaillogin(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()).split(";")[1],TestNGCreator.TestData.get(Esupport.Password.ordinal()).split(";")[1]);
			obj_EsupportDriverandDownloadsWorkflow.ValidateSupportHomePageFordifferentlogincredentials(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()).split(";")[0],TestNGCreator.TestData.get(Esupport.Password.ordinal()).split(";")[0]);
			obj_EsupportContentWorkflow.ClickSearchServiceTag(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
			
			obj_EsupportDriverandDownloadsWorkflow.pcfClickDriversandDownloadsTab(driver);
			obj_EsupportDriverandDownloadsWorkflow.ValidateDriversAndDownloadPageFordifferentlogincredentials(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()).split(";")[0],TestNGCreator.TestData.get(Esupport.Password.ordinal()).split(";")[0]);
			obj_EsupportProductionValidationsWorkflow.signOut(driver);
			obj_EsupportCoveoWorkflow.ToNavigate_IntegratedSupportHomePage(driver);
			//level 40 user
			obj_EsupportIncidentsWorkflow.clickSignIn(driver);
			obj_EsupportIPSWorkflow.Emaillogin(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()).split(";")[2],TestNGCreator.TestData.get(Esupport.Password.ordinal()).split(";")[2]);
			obj_EsupportDriverandDownloadsWorkflow.ValidateSupportHomePageFordifferentlogincredentials(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()).split(";")[0],TestNGCreator.TestData.get(Esupport.Password.ordinal()).split(";")[0]);
			obj_EsupportContentWorkflow.ClickSearchServiceTag(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
			
			obj_EsupportDriverandDownloadsWorkflow.pcfClickDriversandDownloadsTab(driver);
			obj_EsupportDriverandDownloadsWorkflow.ValidateDriversAndDownloadPageFordifferentlogincredentials(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()).split(";")[0],TestNGCreator.TestData.get(Esupport.Password.ordinal()).split(";")[0]);
			
			
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_7300309_AMER_IE_Drivers_Story5503356LEMCIntegrationByAccountsOrAndCountry_ESUPPORT--------->\n  "+e);
		}
	}
}
