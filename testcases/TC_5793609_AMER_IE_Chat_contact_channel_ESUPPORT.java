package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_5793609_AMER_IE_Chat_contact_channel_ESUPPORT extends BaseTest 
{
	@Test
	public void validate_TC_5793609_AMER_IE_Chat_contact_channel_ESUPPORT() 
	{

		try
		{
			System.out.println("Starts TC_5793609_AMER_IE_Chat_contact_channel_ESUPPORT");
			 //obj_EsupportIncidentsWorkflow.ToVerify_EnterServiceTag(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
			obj_EsupportIncidentsWorkflow.ToVerify_EnterServiceTagChat(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
			obj_EsupportIncidentsWorkflow.Click_IssueType(driver);
			obj_EsupportIncidentsWorkflow.Click_ChatLink(driver);
			//obj_EsupportIncidentsWorkflow.toValidate_privacycontent(driver);


		}
		catch(Exception e)
		{

			Assert.fail("Failed while TC_5793609_AMER_IE_Chat_contact_channel_ESUPPORT--------->\n  "+e);

		}

	}

}