package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_7704548_AMER_CH_Contactus_LEMC_SRCreate_HES_Licensing_Install_ViewEdit_ServiceRequest_ESUPPORT  extends BaseTest 
{
	@Test
	public void validate_TC_7704548_AMER_CH_Contactus_LEMC_SRCreate_HES_Licensing_Install_ViewEdit_ServiceRequest_ESUPPORT() 
	{

		try
		{
			System.out.println("Starts TC_7704548_AMER_CH_Contactus_LEMC_SRCreate_HES_Licensing_Install_ViewEdit_ServiceRequest_ESUPPORT");
			obj_EsupportProductionValidationsWorkflow.time(driver);
			obj_EsupportIncidentsWorkflow.clickSignIn(driver);
//			obj_EsupportIncidentsWorkflow.ToLogin_ValidCredentials(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			obj_EsupportIPSWorkflow.clickSignInHereLink(driver);
			
			obj_EsupportIncidentsWorkflow.ToVerify_EnterServiceTag_HandledPopup(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
			
			obj_EsupportIncidentsWorkflow.SelectIssueFromDropDown(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()));
			
			
			obj_EsupportIncidentsWorkflow.ValidateIfCreateServiceRequestChannelsEnabled(driver);
			obj_EsupportIncidentsWorkflow.ClickOnCreateServiceRequestButton(driver);
			
			obj_EsupportIncidentsWorkflow.ClickOnContinueButtonInCreateServiceRequestWindowForLEMCUser(driver);
			
			obj_EsupportIncidentsWorkflow.FillAllDetailsInForm2AndClickOnSubmitForLEMC(driver);
			
			obj_EsupportIncidentsWorkflow.ValidateDetailsInSRCreationFormTitleXButtonCollapseArrows(driver);
			obj_EsupportIncidentsWorkflow.ValidateDetailsInSRCreationFormIssueDetailsTagAndModelAndServiceCode(driver);
			
			obj_EsupportIncidentsWorkflow.ClickOnSRNumberDisplayedInSRSuccessPage(driver);
			obj_EsupportIncidentsWorkflow.ClickOnDoneButton(driver);
		
			obj_EsupportIPSWorkflow.signOut(driver);
			obj_EsupportProductionValidationsWorkflow.time(driver);
		}
		catch(Exception e)
		{

			Assert.fail("Failed while TC_7704548_AMER_CH_Contactus_LEMC_SRCreate_HES_Licensing_Install_ViewEdit_ServiceRequest_ESUPPORT--------->\n  "+e);

		}

	}
}
