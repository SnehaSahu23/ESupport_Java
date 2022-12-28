package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_7984138_AMER_IE_ContentLEMC_SerializedView_TrainingLink_ESUPPORT extends BaseTest {


	@Test
	public void validate_TC_7984138_AMER_IE_ContentLEMC_SerializedView_TrainingLink_ESUPPORT() 
	{
		try
		{
			System.out.println("Starts TC_7984138_AMER_IE_ContentLEMC_SerializedView_TrainingLink_ESUPPORT()");
			obj_EsupportContentWorkflow.handleCookies(driver);
			obj_EsupportIncidentsWorkflow.clickSignIn(driver);
			obj_EsupportIPSWorkflow.clickSignInHereLink(driver);
//			obj_EsupportIncidentsWorkflow.ToLogin_ValidCredentials(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			
			obj_EsupportContentWorkflow.ClickSearchProductForLEMC(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[0]);
			
//			obj_EsupportIncidentsWorkflow.ToLogin_ValidCredentials(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
//			obj_EsupportIPSWorkflow.clickSignInHereLink(driver);
//			obj_EsupportContentWorkflow.ClickSearchServiceTag(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[0]);
			obj_EsupportContentWorkflow.ClickDocumentationTab(driver);
			obj_EsupportContentWorkflow.ValidateDetailsOnLeftRail(driver);
			
			obj_EsupportCoveoWorkflow.VerifyTrainingLinkNotFoundInDocumentationTab(driver);
			
			obj_EsupportIPSWorkflow.clickChangeProductLink(driver);
//			obj_EsupportContentWorkflow.ClickOnXButtonAfterClickingOnChangeProductForLEMCUser(driver);
			
			obj_EsupportContentWorkflow.ClickSearchServiceTagOnProductHomePageAfterClickingOnChangeProduct(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[1]);
			
			obj_EsupportContentWorkflow.ClickDocumentationTab(driver);
			obj_EsupportCoveoWorkflow.TrainingLinkValidationInDocumentationTab(driver);
			obj_EsupportCoveoWorkflow.ClickOnTrainingLink(driver);
			
		
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_7984138_AMER_IE_ContentLEMC_SerializedView_TrainingLink_ESUPPORT()--------->\n  "+e);
		}
	}
}
