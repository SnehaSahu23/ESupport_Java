package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_6604644_AMER_CH_LDellMnAtagged_AddNickname_Esupport extends BaseTest {
	@Test
	public void validate_TC_6604644_AMER_CH_LDellMnAtagged_AddNickname_Esupport() 
	{
		try
		{
			System.out.println("Starts TC_6604644_AMER_CH_LDellMnAtagged_AddNickname_Esupport");

			obj_EsupportIPSWorkflow.clickSignIn(driver);
			obj_EsupportIPSWorkflow.Emaillogin(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			obj_EsupportIPSWorkflow.searchServiceTag(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
			obj_EsupportIPSWorkflow.VerifyAddNewNickname(driver);
			obj_EsupportIPSWorkflow.ClickAddNewNickname(driver);
			obj_EsupportIPSWorkflow.EnterNewNickname(driver);
			obj_EsupportIPSWorkflow.EnterNewNickname50(driver);
			obj_EsupportIPSWorkflow.addNickname(driver,TestNGCreator.TestData.get(Esupport.FirstName.ordinal()).split(";")[1]);

		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_6604644_AMER_CH_LDellMnAtagged_AddNickname_Esupport--------->\n  "+e);
		}
	}
}
