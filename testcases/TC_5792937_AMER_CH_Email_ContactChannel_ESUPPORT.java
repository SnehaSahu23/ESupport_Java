
package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_5792937_AMER_CH_Email_ContactChannel_ESUPPORT extends BaseTest 
{
	@Test
	public void validate_TC_5792937_AMER_CH_Email_ContactChannel_ESUPPORT() 
	{

		try
		{
			
			System.out.println("Starts TC_5792937_AMER_CH_Email_ContactChannel_ESUPPORT");
			obj_EsupportIncidentsWorkflow.ToVerify_EnterServiceTag(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[0]);
			obj_EsupportIncidentsWorkflow.ToClick_onSkipeditbutton(driver);
			obj_EsupportIncidentsWorkflow.ToClick_VerifyEmail(driver);
			obj_EsupportIncidentsWorkflow.ToClick_VerifySupportRequestFields(driver);
			obj_EsupportIncidentsWorkflow.ToClick_onSubmitButton(driver);
			obj_EsupportIncidentsWorkflow.ToVerify_Errormessage(driver);
			obj_EsupportIncidentsWorkflow.ToVerify_Privacymessage(driver);
			obj_EsupportIncidentsWorkflow.ToClick_onCancelButton(driver);
			obj_EsupportIncidentsWorkflow.ToClick_onSkipeditbutton(driver);
			obj_EsupportIncidentsWorkflow.ToClick_VerifyEmail(driver);
			obj_EsupportIncidentsWorkflow.ToEnter_VerifySupportRequestEmailFields(driver,TestNGCreator.TestData.get(Esupport.OperatingSystem.ordinal()),TestNGCreator.TestData.get(Esupport.IssueType.ordinal()),TestNGCreator.TestData.get(Esupport.Textarea.ordinal()));
			
			obj_EsupportIncidentsWorkflow.ToEnter_VerifyContactinformationFieldsSubmit(driver);
			
			



		}
		catch(Exception e)
		{

			Assert.fail("Failed while TC_5792937_AMER_CH_Email_ContactChannel_ESUPPORT--------->\n  "+e);

		}

	}
}


