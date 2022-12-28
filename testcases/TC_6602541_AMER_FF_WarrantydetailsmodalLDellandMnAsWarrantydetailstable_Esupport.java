package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_6602541_AMER_FF_WarrantydetailsmodalLDellandMnAsWarrantydetailstable_Esupport extends BaseTest
{
	@Test
	public void validate_TC_6602541_AMER_FF_WarrantydetailsmodalLDellandMnAsWarrantydetailstable_Esupport() 
	{
		try
		{
			System.out.println("Starts TC_6602541_AMER_FF_WarrantydetailsmodalLDellandMnAsWarrantydetailstable_Esupport");			
		
			obj_EsupportIPSWorkflow.searchServiceTag(driver, TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
			obj_EsupportIPSWorkflow.verifyProductHeroSectionDetails(driver);
			obj_EsupportIPSWorkflow.clickViewDetailsLink(driver);
			obj_EsupportIPSWorkflow.verifyWarrantyDetailsModalPopup(driver);
			
			obj_EsupportIPSWorkflow.verifyWarrantyTable(driver);
			obj_EsupportIPSWorkflow.verifyServiceColumn(driver);
			
			obj_EsupportIPSWorkflow.verifyStartDateFormat(driver);			
			obj_EsupportIPSWorkflow.verifyExpirationDateFormat(driver);
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_6602541_AMER_FF_WarrantydetailsmodalLDellandMnAsWarrantydetailstable_Esupport--------->\n  "+e);
		}
	}
}
