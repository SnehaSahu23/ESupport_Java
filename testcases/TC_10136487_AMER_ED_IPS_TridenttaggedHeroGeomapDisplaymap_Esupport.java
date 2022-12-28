package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_10136487_AMER_ED_IPS_TridenttaggedHeroGeomapDisplaymap_Esupport extends BaseTest
{
	@Test
	public void validate_TC_10136487_AMER_ED_IPS_TridenttaggedHeroGeomapDisplaymap_Esupport() throws Throwable 
	{
		try
		{
			System.out.println("Starts TC_10136487_AMER_ED_IPS_TridenttaggedHeroGeomapDisplaymap_Esupport");

			obj_EsupportIncidentsWorkflow.clickSignIn(driver);
			obj_EsupportIPSWorkflow.clickSignInHereLink(driver);
			
			obj_EsupportIPSWorkflow.searchServiceTag(driver, TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
			obj_EsupportIPSWorkflow.VerifyTheLocationOfTheProduct(driver);		
			obj_EsupportIPSWorkflow.ClickOnViewLocationDetailsLink(driver);
			
			obj_EsupportIPSWorkflow.verifyRequestLocationChangeButton(driver);
			obj_EsupportIPSWorkflow.ClickOnXMarkInTheModalPopUp(driver);
			obj_EsupportIPSWorkflow.ClickOnExpandButtonOnGeoLocation(driver);
			
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_10136487_AMER_ED_IPS_TridenttaggedHeroGeomapDisplaymap_Esupport--------->\n  "+e);
		}
	}
}