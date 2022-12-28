package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_6604695_AMER_CH_LDellMnAtagged_EditNickname_Esupport extends BaseTest{
	@Test
	public void validate_TC_6604695_AMER_CH_LDellMnAtagged_EditNickname_Esupport() 
	{
		try
		{
			System.out.println("Starts TC_6604695_AMER_CH_LDellMnAtagged_EditNickname_Esupport");

			obj_EsupportIPSWorkflow.clickSignIn(driver);
			obj_EsupportIPSWorkflow.Emaillogin(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			obj_EsupportIPSWorkflow.searchServiceTag(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
			obj_EsupportIPSWorkflow.verifyNickname(driver);
			obj_EsupportIPSWorkflow.verifyEditDelete(driver);
			obj_EsupportIPSWorkflow.clickEdit(driver);
			obj_EsupportIPSWorkflow.addNickname(driver, TestNGCreator.TestData.get(Esupport.FirstName.ordinal()));
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_6604695_AMER_CH_LDellMnAtagged_EditNickname_Esupport--------->\n  "+e);
		}
	}
}

