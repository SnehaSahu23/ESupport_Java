package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_5836650_AMER_ED_Support_Search_IntegratedUX_Handle_alphanumeric_characters_Esupport extends BaseTest {
	@Test
	public void validate_TC_5836650_AMER_ED_Support_Search_IntegratedUX_Handle_alphanumeric_characters_Esupport() 
	{

		try
		{
			System.out.println("Starts TC# 5836650");

//			String[] username=TestNGCreator.TestData.get(Esupport.Username.ordinal()).split(";");   
//			String[] password=TestNGCreator.TestData.get(Esupport.Password.ordinal()).split(";"); 

			obj_EsupportCoveoWorkflow.handleCookies(driver);

//			obj_EsupportCoveoWorkflow.Emaillogin(driver,username[0],password[0]);
//			obj_EsupportCoveoWorkflow.handleCookies(driver);
			obj_EsupportIncidentsWorkflow.clickSignIn(driver);
			obj_EsupportIncidentsWorkflow.ToLogin_ValidCredentials(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()).split(";")[0],TestNGCreator.TestData.get(Esupport.Password.ordinal()).split(";")[0]);
			//obj_EsupportCoveoWorkflow.Select_Search_Values(driver);
			obj_EsupportCoveoWorkflow.Select_Search_Values(driver, TestNGCreator.TestData.get(Esupport.SupportValue.ordinal()).split(";")[0], TestNGCreator.TestData.get(Esupport.SupportValue.ordinal()).split(";")[1]);

			obj_EsupportCoveoWorkflow.toVerify_CountofResults(driver);
			
			obj_EsupportIPSWorkflow.signOut(driver);
			Thread.sleep(6000);
			obj_EsupportIncidentsWorkflow.clickSignIn(driver);
			obj_EsupportIncidentsWorkflow.ToLogin_ValidCredentials(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()).split(";")[1],TestNGCreator.TestData.get(Esupport.Password.ordinal()).split(";")[1]);
			obj_EsupportCoveoWorkflow.Select_Search_Values(driver, TestNGCreator.TestData.get(Esupport.SupportValue.ordinal()).split(";")[0], TestNGCreator.TestData.get(Esupport.SupportValue.ordinal()).split(";")[1]);
			obj_EsupportCoveoWorkflow.toVerify_CountofResults(driver);
			obj_EsupportCoveoWorkflow.toVerify_CountofResults_Comparision(driver);
			//obj_EsupportCoveoWorkflow.Logout(driver);
			obj_EsupportIPSWorkflow.signOut(driver);
		}
		catch(Exception e){

			Assert.fail("Failed while executing test case TC_5836650_AMER_ED_Support_Search_IntegratedUX_Handle_alphanumeric_characters_Esupport--------->\n  "+e);

		}

	}

}
