package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_8145376_AMER_IE_Coveo_ConsistentSearchUX_Content_RedirectionImprovementTo_ServiceTag_SRnumber_SerialNumber_search_ESUPPORT extends BaseTest
{
	@Test
	public void validate_TC_8145376_AMER_IE_Coveo_ConsistentSearchUX_Content_RedirectionImprovementTo_ServiceTag_SRnumber_SerialNumber_search_ESUPPORT() 
	{
		try
		{
			System.out.println("Starts TC_8145376_AMER_IE_Coveo_ConsistentSearchUX_Content_RedirectionImprovementTo_ServiceTag_SRnumber_SerialNumber_search_ESUPPORT");

			//Scenario 1 ; service tag and serial number search
			
			obj_EsupportCoveoWorkflow.ToNavigate_IntegratedSupportHomePage(driver);
			
			obj_EsupportCoveoWorkflow.ValidateSearchingServiceTagInMastHead(driver);
			
			obj_EsupportCoveoWorkflow.ToNavigate_IntegratedSupportHomePage(driver);
			
			obj_EsupportCoveoWorkflow.ClickSearchProductForLEMC(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[1],TestNGCreator.TestData.get(Esupport.Username.ordinal()).split(";")[0],TestNGCreator.TestData.get(Esupport.Password.ordinal()).split(";")[0]);
//			obj_EsupportCoveoWorkflow.Logout(driver);
			obj_EsupportIPSWorkflow.signOut(driver);
			
			//scenario 2;product code search and keyword search from mast head
			
			obj_EsupportCoveoWorkflow.ToNavigate_IntegratedSupportHomePage(driver);
			obj_EsupportCoveoWorkflow.SearchingServiceTagProductCodeSerialNumberInMastHead(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[2]);
			
			
			//scenario 3; SR number validation
			
//			obj_EsupportCoveoWorkflow.ToNavigate_IntegratedSupportHomePage(driver);
//			
//			obj_EsupportCoveoWorkflow.DellSRSearchFromMastHead(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[3],TestNGCreator.TestData.get(Esupport.Email.ordinal()));
			
			//Scenario 4; Express service code verification
			obj_EsupportCoveoWorkflow.ToNavigate_IntegratedSupportHomePage(driver);
			obj_EsupportCoveoWorkflow.ValidateSearchingExpressServiceCodeInMastHead(driver);
			
			obj_EsupportCoveoWorkflow.ToNavigate_IntegratedSupportHomePage(driver);
//			obj_EsupportCoveoWorkflow.ValidateSearchingEMCSRnumber(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[4],TestNGCreator.TestData.get(Esupport.Username.ordinal()).split(";")[0],TestNGCreator.TestData.get(Esupport.Password.ordinal()).split(";")[0]);
//			obj_EsupportCoveoWorkflow.Logout(driver);
			
			
			
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_8145376_AMER_IE_Coveo_ConsistentSearchUX_Content_RedirectionImprovementTo_ServiceTag_SRnumber_SerialNumber_search_ESUPPORT--------->\n  "+e);
		}
	}
}
