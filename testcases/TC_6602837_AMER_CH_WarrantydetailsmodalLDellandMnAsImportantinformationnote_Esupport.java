package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_6602837_AMER_CH_WarrantydetailsmodalLDellandMnAsImportantinformationnote_Esupport  extends BaseTest
{
	@Test
	public void validate_TC_6602837_AMER_CH_WarrantydetailsmodalLDellandMnAsImportantinformationnote_Esupport() 
	{
		try
		{
			System.out.println("Starts TC_6602837_AMER_CH_WarrantydetailsmodalLDellandMnAsImportantinformationnote_Esupport");

			//	obj_EsupportIPSWorkflow.toTestDateFormat(driver);
			obj_EsupportIPSWorkflow.searchServiceTag(driver, TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
			obj_EsupportIPSWorkflow.verifyProductHeroSectionDetails(driver);
			obj_EsupportIPSWorkflow.clickViewDetailsLink(driver);
			obj_EsupportIPSWorkflow.verifyImportantInformation(driver);
			obj_EsupportIPSWorkflow.verifyContentLinks(driver);			
			obj_EsupportIPSWorkflow.clickTermsOfSaleLink(driver);
			driver.navigate().back();
			obj_EsupportIPSWorkflow.clickViewDetailsLink(driver);
			obj_EsupportIPSWorkflow.clickRegisterYourProductLink(driver);
			driver.navigate().back();
			obj_EsupportIPSWorkflow.clickViewDetailsLink(driver);
			obj_EsupportIPSWorkflow.clickTransferOwnershipLink(driver);	
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_6602837_AMER_CH_WarrantydetailsmodalLDellandMnAsImportantinformationnote_Esupport--------->\n  "+e);
		}
	}
}


