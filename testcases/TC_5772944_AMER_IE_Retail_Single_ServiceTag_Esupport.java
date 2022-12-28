package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_5772944_AMER_IE_Retail_Single_ServiceTag_Esupport extends BaseTest
{
	@Test
	public void validate_TC_5772944_AMER_IE_Retail_Single_ServiceTag_Esupport() 
	{

		try
		{
			System.out.println("Starts TC# _5772944_AMER_IE"); 

			System.out.println("Retail");

			obj_EsupportRetailAssetWorkflow.homePage(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
			obj_EsupportOrderHomeWorkflow.handleCookies(driver);
			obj_EsupportRetailAssetWorkflow.clickOnContinue(driver); 

			obj_EsupportRetailAssetWorkflow.PreviousOwnerDetails(driver,TestNGCreator.TestData.get(Esupport.CompanyName.ordinal()),TestNGCreator.TestData.get(Esupport.FirstName.ordinal()),TestNGCreator.TestData.get(Esupport.LastName.ordinal()),TestNGCreator.TestData.get(Esupport.Email.ordinal()), 
					TestNGCreator.TestData.get(Esupport.StreetAddress.ordinal()),TestNGCreator.TestData.get(Esupport.City.ordinal()),TestNGCreator.TestData.get(Esupport.PostalCode.ordinal()),TestNGCreator.TestData.get(Esupport.PhoneNumber.ordinal()),TestNGCreator.TestData.get(Esupport.State.ordinal()),false);
			obj_EsupportRetailAssetWorkflow.selectIntendedUse(driver,"Home");
			obj_EsupportRetailAssetWorkflow.NewOwnerDetails(driver,TestNGCreator.TestData.get(Esupport.CompanyName.ordinal()),TestNGCreator.TestData.get(Esupport.FirstName.ordinal()),TestNGCreator.TestData.get(Esupport.LastName.ordinal()),TestNGCreator.TestData.get(Esupport.Email.ordinal()), 
					TestNGCreator.TestData.get(Esupport.StreetAddress.ordinal()),TestNGCreator.TestData.get(Esupport.City.ordinal()),TestNGCreator.TestData.get(Esupport.PostalCode.ordinal()),TestNGCreator.TestData.get(Esupport.PhoneNumber.ordinal()),TestNGCreator.TestData.get(Esupport.State.ordinal()),TestNGCreator.TestData.get(Esupport.Country.ordinal()));

			obj_EsupportRetailAssetWorkflow.VerifyOwnerdetails(driver);
			obj_EsupportRetailAssetWorkflow.clickOnFinalsContinue(driver);

		}catch(Exception e)
		{
			Assert.fail("Failed while executing test case TC_5772944_AMER_IE_Retail_Single_ServiceTag_Esupport--------->\n  "+e);
		}
	}
}

