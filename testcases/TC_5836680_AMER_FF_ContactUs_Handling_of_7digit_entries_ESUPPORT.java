package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_5836680_AMER_FF_ContactUs_Handling_of_7digit_entries_ESUPPORT extends BaseTest {
	@Test
	public void validate_TC_5836680_AMER_FF_ContactUs_Handling_of_7digit_entries_ESUPPORT() 
	{

		try
		{
			System.out.println("Starts TC_5836680_AMER_FF_ContactUs_Handling_of_7digit_entries_ESUPPORT");

            

			obj_EsupportCoveoWorkflow.handleCookies(driver);

//			obj_EsupportCoveoWorkflow.Emaillogin(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			obj_EsupportIncidentsWorkflow.clickSignIn(driver);
			obj_EsupportIncidentsWorkflow.ToLogin_ValidCredentials(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()).split(";")[0],TestNGCreator.TestData.get(Esupport.Password.ordinal()).split(";")[0]);
			
			//obj_EsupportCoveoWorkflow.handleCookies(driver);
			obj_EsupportCoveoWorkflow.Search_Values_7digitEntries(driver, TestNGCreator.TestData.get(Esupport.SupportValue.ordinal()).split(";")[0],"Support");
			Thread.sleep(10000);
			obj_EsupportCoveoWorkflow.toVerify_CoveoResults_7digitEntries(driver,"1");
			Thread.sleep(10000);
//			driver.navigate().back();
			obj_EsupportCoveoWorkflow.Search_Values_7digitEntries(driver, TestNGCreator.TestData.get(Esupport.SupportValue.ordinal()).split(";")[1],"Support");
			Thread.sleep(10000);
			obj_EsupportCoveoWorkflow.toVerify_CoveoResults_7digitEntries(driver,"2");
			Thread.sleep(10000);
//			driver.navigate().back();

			obj_EsupportCoveoWorkflow.Search_Values_7digitEntries(driver, TestNGCreator.TestData.get(Esupport.SupportValue.ordinal()).split(";")[2],"Support");
			Thread.sleep(10000);
			obj_EsupportCoveoWorkflow.toVerify_CoveoResults_7digitEntries(driver,"3");

			obj_EsupportIPSWorkflow.signOut(driver);
			
		}
		catch(Exception e){

			Assert.fail("Failed while executing test case TC_5836680_AMER_FF_ContactUs_Handling_of_7digit_entries_ESUPPORT--------->\n  "+e);

		}

	}

}
