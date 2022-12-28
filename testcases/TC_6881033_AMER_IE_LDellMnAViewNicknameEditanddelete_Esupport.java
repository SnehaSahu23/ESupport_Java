package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_6881033_AMER_IE_LDellMnAViewNicknameEditanddelete_Esupport extends BaseTest{
	@Test
	public void validate_TC_6881033_AMER_IE_LDellMnAViewNicknameEditanddelete_Esupport() 
	{
		try
		{
			System.out.println("Starts TC_6881033_AMER_IE_LDellMnAViewNicknameEditanddelete_Esupport");

			obj_EsupportIncidentsWorkflow.clickSignIn(driver);
			obj_EsupportIPSWorkflow.Emaillogin(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			obj_EsupportIPSWorkflow.searchServiceTag(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
			obj_EsupportIPSWorkflow.verifyNickname(driver);
			obj_EsupportIPSWorkflow.verifyEditDelete(driver);
			obj_EsupportIPSWorkflow.clickEdit(driver);
			obj_EsupportIPSWorkflow.addNickname(driver, TestNGCreator.TestData.get(Esupport.FirstName.ordinal()));
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_6881033_AMER_IE_LDellMnAViewNicknameEditanddelete_Esupport--------->\n  "+e);
		}
	}
}
