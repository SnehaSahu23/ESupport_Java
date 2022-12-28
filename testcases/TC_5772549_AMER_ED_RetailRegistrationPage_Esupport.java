package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_5772549_AMER_ED_RetailRegistrationPage_Esupport extends BaseTest {
	@Test
	public void validate_TC_5772549_AMER_ED_RetailRegistrationPage_Esupport() 
	{

		try
		{
			System.out.println("Starts TC# _5772549_AMER_ED");

			System.out.println("Retail");
			obj_EsupportRetailAssetWorkflow.homePage_ServiceTag(driver, TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
			obj_EsupportRetailAssetWorkflow.retailContinue(driver);
			obj_EsupportRetailAssetWorkflow.retailInformation(driver,
					TestNGCreator.TestData.get(Esupport.FirstName.ordinal()),
					TestNGCreator.TestData.get(Esupport.LastName.ordinal()),
					TestNGCreator.TestData.get(Esupport.Email.ordinal()),
					TestNGCreator.TestData.get(Esupport.StreetAddress.ordinal()),
					TestNGCreator.TestData.get(Esupport.Optional.ordinal()),
					TestNGCreator.TestData.get(Esupport.City.ordinal()),
					TestNGCreator.TestData.get(Esupport.PostalCode.ordinal()),
					TestNGCreator.TestData.get(Esupport.AreaCode.ordinal()),
					TestNGCreator.TestData.get(Esupport.PhoneNumber.ordinal()));
			obj_EsupportRetailAssetWorkflow.addressVerification(driver);
			obj_EsupportRetailAssetWorkflow.privacyStatement_IEone(driver);

		}
		catch(Exception e){

			Assert.fail("Failed while executing test case TC_5772549_AMER_ED_RetailRegistrationPage_Esupport--------->\n  "+e);

		}

	}
}


