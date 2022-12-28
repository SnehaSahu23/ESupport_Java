package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_7690205_AMER_IE_IPS_LEMC_Serialized_Map_RequestLocationChange_Customer_Esupport extends BaseTest
{
	@Test
	public void validate_TC_7690205_AMER_IE_IPS_LEMC_Serialized_Map_RequestLocationChange_Customer_Esupport() 
	{
		try
		{
			System.out.println("Starts TC_7690205_AMER_IE_IPS_LEMC_Serialized_Map_RequestLocationChange_Customer_Esupport");

			
			obj_EsupportIncidentsWorkflow.clickSignIn(driver);
			obj_EsupportIncidentsWorkflow.ToLogin_ValidCredentials(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()).split(";")[0],TestNGCreator.TestData.get(Esupport.Password.ordinal()).split(";")[0]);
			Thread.sleep(5000);
			obj_EsupportIPSWorkflow.ClickSearchServiceTag(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
			
			obj_EsupportIPSWorkflow.VerifyTheLocationOfTheProduct(driver);
			
			obj_EsupportIPSWorkflow.ClickOnViewLocationDetailsLink(driver);
			obj_EsupportIPSWorkflow.ClickOnManageSiteIDLink(driver);
			obj_EsupportIPSWorkflow.ClickOnRequestLocationChange(driver);
			obj_EsupportIPSWorkflow.ValidateEntering2CharsInSearchBox(driver);
			obj_EsupportIPSWorkflow.ValidateEntering3CharsInSearchBox(driver);
			obj_EsupportIPSWorkflow.ValidateEntering3CharsInSearchBoxAndClickOnSearchButton(driver);
			obj_EsupportIPSWorkflow.ValidateEnteringRandonAUSWhichLocationNotAvailable(driver);
			obj_EsupportIPSWorkflow.ClickOnBackToLocationDetailsLink(driver);
			obj_EsupportIPSWorkflow.ClickOnXMarkInTheModalPopUp(driver);
			obj_EsupportIPSWorkflow.signOut(driver);
		}
		catch(Exception e)
		{
			Assert.fail("Failed executing TC_7690205_AMER_IE_IPS_LEMC_Serialized_Map_RequestLocationChange_Customer_Esupport--------->\n  "+e);
		}
	}
}
