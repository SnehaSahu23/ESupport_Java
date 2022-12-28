package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_6881214_AMER_IE_IPS_WarrantydetailsmodalLDellandMnAPrintandimportantinformation_Esupport extends BaseTest
{
	@Test
	public void validate_TC_6881214_AMER_IE_IPS_WarrantydetailsmodalLDellandMnAPrintandimportantinformation_Esupport() 
	{
		try
		{
			System.out.println("Starts TC_6881214_AMER_IE_IPS_WarrantydetailsmodalLDellandMnAPrintandimportantinformation_Esupport");

			obj_EsupportIPSWorkflow.searchServiceTag(driver, TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
			obj_EsupportIPSWorkflow.verifyProductHeroSectionDetails(driver);
			obj_EsupportIPSWorkflow.clickViewDetailsLink(driver);	
			obj_EsupportIPSWorkflow.verifyPrintOption(driver);

			obj_EsupportIPSWorkflow.clickWarrantyDetailsCloseButton(driver);
			obj_EsupportIPSWorkflow.clickViewDetailsLink(driver);
			obj_EsupportIPSWorkflow.verifyImportantInformation(driver);
			obj_EsupportIPSWorkflow.verifyContentLinks(driver);			
			//			obj_EsupportIPSWorkflow.clickTermsOfSaleLink(driver);
			//			driver.navigate().back();
			//			obj_EsupportIPSWorkflow.clickVIEwDetailsLink(driver);
			obj_EsupportIPSWorkflow.clickRegisterYourProductLink(driver);
//			driver.navigate().back();
			obj_EsupportIPSWorkflow.Navigatebacktopreviouspage(driver);
			obj_EsupportIPSWorkflow.clickViewDetailsLink(driver);
			obj_EsupportIPSWorkflow.clickTransferOwnershipLink(driver);	
		}
		catch(Exception e)
		{
			Assert.fail("FailIE in TC_6881214_AMER_IE_IPS_WarrantydetailsmodalLDellandMnAPrintandimportantinformation_Esupport--------->\n  "+e);
		}
	}
}
