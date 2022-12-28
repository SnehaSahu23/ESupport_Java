package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_6000752_AMER_CH_Coveo_SupportSearch_IntegratedMasthead_AvoidMultipleRedirectionForSvcTagSAndSerialsSearch_Diagnostics_ESUPPORT extends BaseTest
{
	@Test
	public void validate_TC_6000752_AMER_CH_Coveo_SupportSearch_IntegratedMasthead_AvoidMultipleRedirectionForSvcTagSAndSerialsSearch_Diagnostics_ESUPPORT() 
	{
		try
		{
			System.out.println("Starts TC_6000752_AMER_CH_Coveo_SupportSearch_IntegratedMasthead_AvoidMultipleRedirectionForSvcTagSAndSerialsSearch_Diagnostics_ESUPPORT");
			//1. DiagnosticAndTool page
			//Scenario 1 ; service tag and serial number search
			
			obj_EsupportCoveoWorkflow.ToNavigate_DiagnosticsAndToolsHomePage(driver);
			
			obj_EsupportCoveoWorkflow.ValidateSearchingServiceTagInMastHead(driver);
			
			obj_EsupportCoveoWorkflow.ToNavigate_DiagnosticsAndToolsHomePage(driver);
			
			obj_EsupportCoveoWorkflow.ClickSearchProductForLEMC(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[1],TestNGCreator.TestData.get(Esupport.Username.ordinal()).split(";")[0],TestNGCreator.TestData.get(Esupport.Password.ordinal()).split(";")[0]);
			obj_EsupportCoveoWorkflow.Logout(driver);
			//scenario 2;product code search and keyword search from mast head
			
			obj_EsupportCoveoWorkflow.ToNavigate_DiagnosticsAndToolsHomePage(driver);
			obj_EsupportCoveoWorkflow.SearchingServiceTagProductCodeSerialNumberInMastHead(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[2]);
			
			obj_EsupportCoveoWorkflow.ToNavigate_DiagnosticsAndToolsHomePage(driver);
			obj_EsupportCoveoWorkflow.ValidateSearchForKeywordWithOutDoubleQuotes(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()), TestNGCreator.TestData.get(Esupport.Dpid.ordinal()));
			
			//scenario 3; SR number validation
			
			obj_EsupportCoveoWorkflow.ToNavigate_DiagnosticsAndToolsHomePage(driver);
			
			obj_EsupportCoveoWorkflow.DellSRSearchFromMastHead(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[3],TestNGCreator.TestData.get(Esupport.Email.ordinal()));
			
			obj_EsupportCoveoWorkflow.ToNavigate_DiagnosticsAndToolsHomePage(driver);
			obj_EsupportCoveoWorkflow.ValidateSearchingEMCSRnumber(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[4],TestNGCreator.TestData.get(Esupport.Username.ordinal()).split(";")[0],TestNGCreator.TestData.get(Esupport.Password.ordinal()).split(";")[0]);
//			obj_EsupportCoveoWorkflow.Logout(driver);
			
			//2. pre boot analysis page
			//Scenario 1 ; service tag and serial number search
			
			obj_EsupportCoveoWorkflow.ToNavigate_PreBootAnalysis(driver);
			
			obj_EsupportCoveoWorkflow.ValidateSearchingServiceTagInMastHead(driver);
			
			obj_EsupportCoveoWorkflow.ToNavigate_PreBootAnalysis(driver);
			
			obj_EsupportCoveoWorkflow.ClickSearchProductForLEMC(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[1],TestNGCreator.TestData.get(Esupport.Username.ordinal()).split(";")[0],TestNGCreator.TestData.get(Esupport.Password.ordinal()).split(";")[0]);
			obj_EsupportCoveoWorkflow.Logout(driver);
			//scenario 2;product code search and keyword search from mast head
			
			obj_EsupportCoveoWorkflow.ToNavigate_PreBootAnalysis(driver);
			obj_EsupportCoveoWorkflow.SearchingServiceTagProductCodeSerialNumberInMastHead(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[2]);
			
			obj_EsupportCoveoWorkflow.ToNavigate_PreBootAnalysis(driver);
			obj_EsupportCoveoWorkflow.ValidateSearchForKeywordWithOutDoubleQuotes(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()), TestNGCreator.TestData.get(Esupport.Dpid.ordinal()));
			
			//scenario 3; SR number validation
			
			obj_EsupportCoveoWorkflow.ToNavigate_PreBootAnalysis(driver);
			
			obj_EsupportCoveoWorkflow.DellSRSearchFromMastHead(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[3],TestNGCreator.TestData.get(Esupport.Email.ordinal()));
			
			obj_EsupportCoveoWorkflow.ToNavigate_PreBootAnalysis(driver);
			obj_EsupportCoveoWorkflow.ValidateSearchingEMCSRnumber(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[4],TestNGCreator.TestData.get(Esupport.Username.ordinal()).split(";")[0],TestNGCreator.TestData.get(Esupport.Password.ordinal()).split(";")[0]);
//			obj_EsupportCoveoWorkflow.Logout(driver);
			
			//1. CIS Customer Facing Tool
			
			//Scenario 1 ; service tag and serial number search
			
			obj_EsupportCoveoWorkflow.ToNavigate_CISCustomerFacingTool(driver);
			
			obj_EsupportCoveoWorkflow.ValidateSearchingServiceTagInMastHead(driver);
			
			obj_EsupportCoveoWorkflow.ToNavigate_CISCustomerFacingTool(driver);
			
			obj_EsupportCoveoWorkflow.ClickSearchProductForLEMC(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[1],TestNGCreator.TestData.get(Esupport.Username.ordinal()).split(";")[0],TestNGCreator.TestData.get(Esupport.Password.ordinal()).split(";")[0]);
			obj_EsupportCoveoWorkflow.Logout(driver);
			//scenario 2;product code search and keyword search from mast head
			
			obj_EsupportCoveoWorkflow.ToNavigate_CISCustomerFacingTool(driver);
			obj_EsupportCoveoWorkflow.SearchingServiceTagProductCodeSerialNumberInMastHead(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[2]);
			
			obj_EsupportCoveoWorkflow.ToNavigate_CISCustomerFacingTool(driver);
			obj_EsupportCoveoWorkflow.ValidateSearchForKeywordWithOutDoubleQuotes(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()), TestNGCreator.TestData.get(Esupport.Dpid.ordinal()));
			
			//scenario 3; SR number validation
			
			obj_EsupportCoveoWorkflow.ToNavigate_CISCustomerFacingTool(driver);
			
			obj_EsupportCoveoWorkflow.DellSRSearchFromMastHead(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[3],TestNGCreator.TestData.get(Esupport.Email.ordinal()));
			
			obj_EsupportCoveoWorkflow.ToNavigate_CISCustomerFacingTool(driver);
			obj_EsupportCoveoWorkflow.ValidateSearchingEMCSRnumber(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[4],TestNGCreator.TestData.get(Esupport.Username.ordinal()).split(";")[0],TestNGCreator.TestData.get(Esupport.Password.ordinal()).split(";")[0]);
//			obj_EsupportCoveoWorkflow.Logout(driver);
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_6000752_AMER_CH_Coveo_SupportSearch_IntegratedMasthead_AvoidMultipleRedirectionForSvcTagSAndSerialsSearch_Diagnostics_ESUPPORT--------->\n  "+e);
		}
	}
}
