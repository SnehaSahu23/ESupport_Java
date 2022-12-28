package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_5985544_AMER_FF_ContactusIntegration_SRConfirmationscreen_DELLProduct_DownloadPDFAction_Esupport extends BaseTest 
{
	@Test
	public void validate_TC_5985544_AMER_FF_ContactusIntegration_SRConfirmationscreen_DELLProduct_DownloadPDFAction_Esupport() 
	{
		try
		{
			System.out.println("Starts TC_5985544_AMER_FF_ContactusIntegration_SRConfirmationscreen_DELLProduct_DownloadPDFAction_Esupport");
			obj_EsupportIncidentsWorkflow.ToClick_VerifyContancttechsupport(driver);
			obj_EsupportIncidentsWorkflow.ToVerify_EnterServiceTagContancttechsupport(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
			

			obj_EsupportIncidentsWorkflow.ToVerify_IssueTypelink(driver);
			
			
			obj_EsupportIncidentsWorkflow.ToEnter_VerifySupportRequestEmailFields(driver,TestNGCreator.TestData.get(Esupport.OperatingSystem.ordinal()),TestNGCreator.TestData.get(Esupport.IssueType.ordinal()),TestNGCreator.TestData.get(Esupport.Textarea.ordinal()));

			obj_EsupportIncidentsWorkflow.ToEnter_VerifyContactinformationFieldsSubmit(driver);
			
			
			obj_EsupportIncidentsWorkflow.ToClick_DownloadsummaryPDF(driver);

			
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_5985544_AMER_FF_ContactusIntegration_SRConfirmationscreen_DELLProduct_DownloadPDFAction_Esupport--------->\n  "+e);
		}
	}
}
