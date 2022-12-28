package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_10146709_AMER_ED_IPS_LEMC_serializedoverviewContacttechnicalsupportwidget_Esupport extends BaseTest
{
	@Test
	public void validate_TC_10146709_AMER_ED_IPS_LEMC_serializedoverviewContacttechnicalsupportwidget_Esupport() 
	{
		try
		{
			System.out.println("Starts TC_10146709_AMER_ED_IPS_LEMC_serializedoverviewContacttechnicalsupportwidget_Esupport");

			
			obj_EsupportIncidentsWorkflow.clickSignIn(driver);
			obj_EsupportIncidentsWorkflow.ToLogin_ValidCredentials(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			Thread.sleep(5000);
			obj_EsupportIPSWorkflow.searchServiceTag(driver, TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
			
			obj_EsupportIPSWorkflow.ContactTechnicalSection(driver);			
			
			obj_EsupportIPSWorkflow.clickContactTechnicalSupportLink(driver);
			
			
		}
		catch(Exception e)
		{
			Assert.fail("Failed executing TC_10146709_AMER_ED_IPS_LEMC_serializedoverviewContacttechnicalsupportwidget_Esupport--------->\n  "+e);
		}
	}
}
