package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_12234779_AMER_FF_MPS_Premier_Row_Expansion_Contact_Us extends BaseTest 
{
	@Test
	public void validate_TC_12234779_AMER_FF_MPS_Premier_Row_Expansion_Contact_Us()
	{
		try
		{
			obj_EsupportMPSWorkflow.SignInToPremierAccount(driver, TestNGCreator.TestData.get(Esupport.Username.ordinal()), TestNGCreator.TestData.get(Esupport.Password.ordinal()),
					TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()));
			obj_EsupportMPSWorkflow.clickOnExpandButtonOfFirstDisplayedRow(driver);
			obj_EsupportMPSWorkflow.clickOnPartsAndAccessoriesLink(driver);
			obj_EsupportMPSWorkflow.clickOnDocumentationLink(driver);
			obj_EsupportMPSWorkflow.clickOnDriversAndDownloadsLink(driver);
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_12234779_AMER_FF_MPS_Premier_Row_Expansion_Contact_Us--------->\n  "+e);
		}
	}
}
