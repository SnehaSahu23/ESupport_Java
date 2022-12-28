package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_10108521_AMER_CH_IPS_LEMC_SerializedHeroProductNicknameViewAddEdit_Esupport extends BaseTest
{
	@Test
	public void validate_TC_10108521_AMER_CH_IPS_LEMC_SerializedHeroProductNicknameViewAddEdit_Esupport() throws Throwable 
	{
		try
		{
			System.out.println("Starts TC_10108521_AMER_CH_IPS_LEMC_SerializedHeroProductNicknameViewAddEdit_Esupport");
			obj_EsupportIncidentsWorkflow.clickSignIn(driver);
			obj_EsupportIncidentsWorkflow.ToLogin_ValidCredentials(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			Thread.sleep(5000);
			// product have nickname
			obj_EsupportIPSWorkflow.searchServiceTag(driver, TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
	          
			obj_EsupportIPSWorkflow.verifyNickname_AlreadyAdded(driver);
			obj_EsupportIPSWorkflow.verifyEditDelete(driver);
			obj_EsupportIPSWorkflow.clickEdit(driver);
			obj_EsupportIPSWorkflow.addNickname(driver, TestNGCreator.TestData.get(Esupport.FirstName.ordinal()));
			
			// product don't have nickname
			obj_EsupportIPSWorkflow.deleteNickname(driver);
			obj_EsupportIPSWorkflow.VerifyAddNewNickname(driver);
			obj_EsupportIPSWorkflow.addNickname(driver, TestNGCreator.TestData.get(Esupport.FirstName.ordinal()));
			
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_10108521_AMER_CH_IPS_LEMC_SerializedHeroProductNicknameViewAddEdit_Esupport--------->\n  "+e);
		}
	}
}
