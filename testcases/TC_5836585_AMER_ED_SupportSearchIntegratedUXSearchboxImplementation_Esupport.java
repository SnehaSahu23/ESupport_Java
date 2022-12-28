package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_5836585_AMER_ED_SupportSearchIntegratedUXSearchboxImplementation_Esupport extends BaseTest
{
	@Test
	public void validate_TC_5836585_AMER_ED_SupportSearchIntegratedUXSearchboxImplementation_Esupport() 
	{

		try
		{
			System.out.println("Starts TC_5836585_AMER_ED_SupportSearchIntegratedUXSearchboxImplementation_Esupport");
			obj_EsupportCoveoWorkflow.handleCookies(driver);

			
			obj_EsupportCoveoWorkflow.handleSearchTextbox(driver, TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[0], "Driver ID");
//			obj_EsupportIncidentsWorkflow.ToLogin_ValidCredentials(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			Thread.sleep(5000);
//			obj_EsupportCoveoWorkflow.handleCookies(driver);
			obj_EsupportCoveoWorkflow.validateSearchHeader_DriverID(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[0]);
//			driver.navigate().back();
			obj_EsupportCoveoWorkflow.handleSearchTextbox(driver, TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[1], "Article ID");
			Thread.sleep(5000); 
			obj_EsupportCoveoWorkflow.handleCookies(driver);
			obj_EsupportCoveoWorkflow.validateSearchHeader_ArticleID(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[1]);
//			driver.navigate().back();
			obj_EsupportCoveoWorkflow.handleSearchTextbox(driver, TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[2], "Service Tag");
			Thread.sleep(5000);
			//obj_EsupportCoveoWorkflow.handleCookies(driver);
//			obj_EsupportCoveoWorkflow.validateSupportHeader_ServiceTag(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[2]);



		}
		catch(Exception e){

			Assert.fail("Failed while executing test case TC_5836585_AMER_ED_SupportSearchIntegratedUXSearchboxImplementation_Esupport--------->\n  "+e);

		}

	}

}
