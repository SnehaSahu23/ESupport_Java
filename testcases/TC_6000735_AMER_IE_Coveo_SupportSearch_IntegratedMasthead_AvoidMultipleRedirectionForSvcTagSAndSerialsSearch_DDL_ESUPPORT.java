package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_6000735_AMER_IE_Coveo_SupportSearch_IntegratedMasthead_AvoidMultipleRedirectionForSvcTagSAndSerialsSearch_DDL_ESUPPORT extends BaseTest
{
	@Test
	public void validate_TC_6000735_AMER_IE_Coveo_SupportSearch_IntegratedMasthead_AvoidMultipleRedirectionForSvcTagSAndSerialsSearch_DDL_ESUPPORT() 
	{
		try
		{
			System.out.println("Starts TC_6000735_AMER_IE_Coveo_SupportSearch_IntegratedMasthead_AvoidMultipleRedirectionForSvcTagSAndSerialsSearch_DDL_ESUPPORT");

			obj_EsupportCoveoWorkflow.ToNavigate_DDLHomePage(driver);
			//removed below steps as discussed with SMEs
//			obj_EsupportDDLWorkflow.ClickonHomePageSignInbutton(driver);
//			obj_EsupportDDLWorkflow.ToLogin_ValidCredentials(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()).split(";")[1],TestNGCreator.TestData.get(Esupport.Password.ordinal()).split(";")[1]);
			
			//Scenario 1 ; service tag and serial number search
			
			obj_EsupportCoveoWorkflow.ValidateSearchingServiceTagInMastHead(driver);
			
			obj_EsupportCoveoWorkflow.ToNavigate_DDLHomePage(driver);
			
			obj_EsupportCoveoWorkflow.ClickSearchProductForLEMC(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[1],TestNGCreator.TestData.get(Esupport.Username.ordinal()).split(";")[0],TestNGCreator.TestData.get(Esupport.Password.ordinal()).split(";")[0]);
			obj_EsupportCoveoWorkflow.Logout(driver);
			//scenario 2;product code search and keyword search from mast head
			
			obj_EsupportCoveoWorkflow.ToNavigate_DDLHomePage(driver);
			obj_EsupportCoveoWorkflow.SearchingServiceTagProductCodeSerialNumberInMastHead(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[2]);

			obj_EsupportCoveoWorkflow.ValidateSearchForKeywordWithOutDoubleQuotes(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()), TestNGCreator.TestData.get(Esupport.Dpid.ordinal()));
			
			//scenario 3; SR number validation from mast head(for authenticated and unauthenticated user)
			
			obj_EsupportCoveoWorkflow.ToNavigate_DDLHomePage(driver);
			
			obj_EsupportCoveoWorkflow.DellSRSearchFromMastHead(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[3],TestNGCreator.TestData.get(Esupport.Email.ordinal()));
			
			obj_EsupportCoveoWorkflow.ToNavigate_DDLHomePage(driver);
			obj_EsupportCoveoWorkflow.ValidateSearchingEMCSRnumber(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[4],TestNGCreator.TestData.get(Esupport.Username.ordinal()).split(";")[0],TestNGCreator.TestData.get(Esupport.Password.ordinal()).split(";")[0]);
//			obj_EsupportCoveoWorkflow.Logout(driver);
			
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_6000735_AMER_IE_Coveo_SupportSearch_IntegratedMasthead_AvoidMultipleRedirectionForSvcTagSAndSerialsSearch_DDL_ESUPPORT--------->\n  "+e);
		}
	}
}
