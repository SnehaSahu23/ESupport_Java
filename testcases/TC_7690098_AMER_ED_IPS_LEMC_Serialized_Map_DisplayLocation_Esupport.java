package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_7690098_AMER_ED_IPS_LEMC_Serialized_Map_DisplayLocation_Esupport extends BaseTest
{
	@Test
	public void validate_TC_7690098_AMER_ED_IPS_LEMC_Serialized_Map_DisplayLocation_Esupport() 
	{
		try
		{
			System.out.println("Starts TC_7690098_AMER_ED_IPS_LEMC_Serialized_Map_DisplayLocation_Esupport");

			
			obj_EsupportIncidentsWorkflow.clickSignIn(driver);
			obj_EsupportIncidentsWorkflow.ToLogin_ValidCredentials(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			Thread.sleep(5000);
			obj_EsupportIPSWorkflow.ClickSearchServiceTag(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
			
			obj_EsupportIPSWorkflow.VerifyTheLocationOfTheProduct(driver);
			obj_EsupportIPSWorkflow.signOut(driver);
		}
		catch(Exception e)
		{
			Assert.fail("Failed executing TC_7690098_AMER_ED_IPS_LEMC_Serialized_Map_DisplayLocation_Esupport--------->\n  "+e);
		}
	}
}
