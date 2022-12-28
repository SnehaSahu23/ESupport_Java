package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_7690247_AMER_IE_IPS_LEMC_Serialized_Map_DisplayGeomap_Esupport extends BaseTest
{
	@Test
	public void validate_TC_7690247_AMER_IE_IPS_LEMC_Serialized_Map_DisplayGeomap_Esupport() 
	{
		try
		{
			System.out.println("Starts TC_7690247_AMER_IE_IPS_LEMC_Serialized_Map_DisplayGeomap_Esupport");

			
			obj_EsupportIncidentsWorkflow.clickSignIn(driver);
			obj_EsupportIPSWorkflow.Emaillogin(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			Thread.sleep(5000);
			obj_EsupportIPSWorkflow.ClickSearchServiceTag(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
			
			obj_EsupportIPSWorkflow.VerifyTheLocationOfTheProduct(driver);
			obj_EsupportIPSWorkflow.ClickOnExpandButtonOnGeoLocation(driver);
			
		}
		catch(Exception e)
		{
			Assert.fail("Failed executing TC_7690247_AMER_IE_IPS_LEMC_Serialized_Map_DisplayGeomap_Esupport--------->\n  "+e);
		}
	}
}
