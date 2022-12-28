package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_5773037_AMER_ED_Ownership_Transfer_Multi_Product extends BaseTest 
{
	@Test
	public void validate_TC_5773037_AMER_ED_Ownership_Transfer_Multi_Product() 
	{

		try
		{
			System.out.println("Starts TC_5773037_AMER_ED_Ownership_Transfer_Multi_Product"); 

			System.out.println("Retail");
			obj_EsupportOrderHomeWorkflow.handleCookies(driver);
			obj_EsupportRetailAssetWorkflow.clickOwnershipTransfer(driver);
			obj_EsupportOrderHomeWorkflow.handleCookies(driver);
			obj_EsupportRetailAssetWorkflow.validateElementsDisplayed(driver);
			obj_EsupportOrderHomeWorkflow.handleCookies(driver);
			obj_EsupportRetailAssetWorkflow.clickMutlipleRadioButton(driver);
			obj_EsupportOrderHomeWorkflow.handleCookies(driver);
			obj_EsupportRetailAssetWorkflow.enterTag1(driver, TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(",")[0]);
			obj_EsupportRetailAssetWorkflow.enterTag2(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(",")[1]);
			obj_EsupportRetailAssetWorkflow.enterTag3(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(",")[2]);
			obj_EsupportRetailAssetWorkflow.enterTag4(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(",")[3]);
			obj_EsupportRetailAssetWorkflow.enterTag5(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(",")[4]);
			obj_EsupportRetailAssetWorkflow.checkAddAnotherButton(driver);
			obj_EsupportOrderHomeWorkflow.handleCookies(driver);
			obj_EsupportRetailAssetWorkflow.clickOnContinue(driver);
		//	obj_EsupportRetailAssetWorkflow.validatePrivacyStatementLink(driver);
			obj_EsupportOrderHomeWorkflow.handleCookies(driver);
			obj_EsupportRetailAssetWorkflow.PreviousOwnerDetails(driver,TestNGCreator.TestData.get(Esupport.CompanyName.ordinal()),TestNGCreator.TestData.get(Esupport.FirstName.ordinal()),TestNGCreator.TestData.get(Esupport.LastName.ordinal()),TestNGCreator.TestData.get(Esupport.Email.ordinal()), 
					TestNGCreator.TestData.get(Esupport.StreetAddress.ordinal()),TestNGCreator.TestData.get(Esupport.City.ordinal()),TestNGCreator.TestData.get(Esupport.PostalCode.ordinal()),TestNGCreator.TestData.get(Esupport.PhoneNumber.ordinal()),TestNGCreator.TestData.get(Esupport.State.ordinal()),false);
			obj_EsupportRetailAssetWorkflow.selectIntendedUse(driver,"Home");
			obj_EsupportRetailAssetWorkflow.NewOwnerDetails(driver,TestNGCreator.TestData.get(Esupport.CompanyName.ordinal()),TestNGCreator.TestData.get(Esupport.FirstName.ordinal()),TestNGCreator.TestData.get(Esupport.LastName.ordinal()),TestNGCreator.TestData.get(Esupport.Email.ordinal()), 
					TestNGCreator.TestData.get(Esupport.StreetAddress.ordinal()),TestNGCreator.TestData.get(Esupport.City.ordinal()),TestNGCreator.TestData.get(Esupport.PostalCode.ordinal()),TestNGCreator.TestData.get(Esupport.PhoneNumber.ordinal()), TestNGCreator.TestData.get(Esupport.State.ordinal()),TestNGCreator.TestData.get(Esupport.Country.ordinal()));

			obj_EsupportRetailAssetWorkflow.VerifyOwnerdetails(driver);
			obj_EsupportRetailAssetWorkflow.clickOnFinalsContinue(driver);

		}catch(Exception e)
		{
			Assert.fail("Failed while executing test case TC_5773037_AMER_ED_Ownership_Transfer_Multi_Product--------->\n  "+e);
		}
	}
}




