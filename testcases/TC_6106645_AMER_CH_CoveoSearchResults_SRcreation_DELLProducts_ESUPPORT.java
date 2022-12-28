package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_6106645_AMER_CH_CoveoSearchResults_SRcreation_DELLProducts_ESUPPORT extends BaseTest 
{
	@Test
	public void validate_TC_6106645_AMER_CH_CoveoSearchResults_SRcreation_DELLProducts_ESUPPORT() 
	{

		try
		{
			
			System.out.println("Starts TC_6106645_AMER_CH_CoveoSearchResults_SRcreation_DELLProducts_ESUPPORT");
			obj_EsupportIncidentsWorkflow.ToVerify_EnterServiceTag(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
			obj_EsupportIncidentsWorkflow.ToClick_onSkipeditbutton(driver);
			obj_EsupportIncidentsWorkflow.ToClick_VerifyEmail(driver);
			obj_EsupportIncidentsWorkflow.ToEnter_IssueDescription(driver,TestNGCreator.TestData.get(Esupport.Textarea.ordinal()));
			obj_EsupportIncidentsWorkflow.Click_Viewallrecommendations(driver);
			obj_EsupportIncidentsWorkflow.searchResult(driver);
		

		}
		catch(Exception e)
		{

			Assert.fail("Failed while TC_6106645_AMER_CH_CoveoSearchResults_SRcreation_DELLProducts_ESUPPORT--------->\n  "+e);

		}

	}
}


