package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_7690205_AMER_MB_IPS_LEMC_Serialized_Map_RequestLocationChange_Customer_Esupport extends BaseTest
{
	@Test
	public void validate_TC_7690205_AMER_MB_IPS_LEMC_Serialized_Map_RequestLocationChange_Customer_Esupport() 
	{
		try
		{
			System.out.println("Starts TC_7690205_AMER_MB_IPS_LEMC_Serialized_Map_RequestLocationChange_Customer_Esupport");

			Thread.sleep(6000);
			obj_EsupportMobileWorkflow.handleCookies(driver);
			Thread.sleep(6000);
			obj_EsupportMobileWorkflow.ClickExtensionIconAndSelectDevice(driver, "Samsung_Galaxy_S6_Portrait");
            obj_EsupportMobileWorkflow.Switch_To_Mobile_window(driver);
            Thread.sleep(6000);
			
            obj_EsupportMobileWorkflow.clickSignIn(driver);
            obj_EsupportMobileWorkflow.Emaillogin(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()).split(";")[0],TestNGCreator.TestData.get(Esupport.Password.ordinal()).split(";")[0]);
			Thread.sleep(5000);
			obj_EsupportMobileWorkflow.ClickSearchServiceTag(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
			
			obj_EsupportMobileWorkflow.VerifyTheLocationOfTheProduct(driver);
			
			obj_EsupportMobileWorkflow.ClickOnViewLocationDetailsLink(driver);
			obj_EsupportMobileWorkflow.ClickOnManageSiteIDLink(driver);
			obj_EsupportMobileWorkflow.ClickOnRequestLocationChange(driver);
			obj_EsupportMobileWorkflow.ValidateEntering2CharsInSearchBox(driver);
			obj_EsupportMobileWorkflow.ValidateEntering3CharsInSearchBox(driver);
			obj_EsupportMobileWorkflow.ValidateEntering3CharsInSearchBoxAndClickOnSearchButton(driver);
			obj_EsupportMobileWorkflow.ValidateEnteringRandonAUSWhichLocationNotAvailable(driver);
			obj_EsupportMobileWorkflow.ClickOnBackToLocationDetailsLink(driver);
			obj_EsupportMobileWorkflow.ClickOnXMarkInTheModalPopUp(driver);
			obj_EsupportMobileWorkflow.signOut(driver);
		}
		catch(Exception e)
		{
			Assert.fail("Failed executing TC_7690205_AMER_MB_IPS_LEMC_Serialized_Map_RequestLocationChange_Customer_Esupport--------->\n  "+e);
		}
	}
}

