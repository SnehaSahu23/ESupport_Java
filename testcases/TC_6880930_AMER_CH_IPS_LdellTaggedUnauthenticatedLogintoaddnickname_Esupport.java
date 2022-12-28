package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_6880930_AMER_CH_IPS_LdellTaggedUnauthenticatedLogintoaddnickname_Esupport extends BaseTest
{
	@Test
	public void validate_TC_6880930_AMER_CH_IPS_LdellTaggedUnauthenticatedLogintoaddnickname_Esupport() 
	{
		try
		{
			System.out.println("Starts TC_6880930_AMER_CH_IPS_LdellTaggedUnauthenticatedLogintoaddnickname_Esupport");

			obj_EsupportIPSWorkflow.searchServiceTag(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
			obj_EsupportIPSWorkflow.VerifyLogInToAddNewNickname(driver);
			obj_EsupportIPSWorkflow.ClickAddNewNickname(driver);
			obj_EsupportIncidentsWorkflow.ToLogin_ValidCredentials_SigninPage(driver, TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			obj_EsupportIPSWorkflow.VerifyAddNewNickname(driver);
		
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_6880930_AMER_CH_IPS_LdellTaggedUnauthenticatedLogintoaddnickname_Esupport--------->\n  "+e);
		}
	}
}

