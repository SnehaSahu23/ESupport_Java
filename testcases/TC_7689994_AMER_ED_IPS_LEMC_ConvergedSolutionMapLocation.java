package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_7689994_AMER_ED_IPS_LEMC_ConvergedSolutionMapLocation extends BaseTest
{
	@Test
	public void validate_TC_7689994_AMER_ED_IPS_LEMC_ConvergedSolutionMapLocation() 
	{
		try
		{
			System.out.println("Starts TC_7689994_AMER_ED_IPS_LEMC_ConvergedSolutionMapLocation");

			
			obj_EsupportIncidentsWorkflow.clickSignIn(driver);
			obj_EsupportIPSWorkflow.clickSignInHereLink(driver);
			Thread.sleep(5000);
			obj_EsupportIPSWorkflow.searchServiceTag(driver, TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
			obj_EsupportIPSWorkflow.VerifyTheLocationOfTheProduct(driver);
			obj_EsupportIPSWorkflow.ClickOnViewLocationDetailsLink(driver);
			obj_EsupportIPSWorkflow.verifyRequestLocationChangeButton(driver);
			obj_EsupportIPSWorkflow.ClickOnXMarkInTheModalPopUp(driver);
			obj_EsupportIPSWorkflow.ClickOnExpandButtonOnGeoLocation(driver);
			obj_EsupportIPSWorkflow.ClickOnXMarkInTheModalPopUp(driver);
		}
		catch(Exception e)
		{
			Assert.fail("Failed executing TC_7689994_AMER_ED_IPS_LEMC_ConvergedSolutionMapLocation--------->\n  "+e);
		}
	}
}