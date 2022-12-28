package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_6602498_AMER_CH_WarrantydetailsmodalLDellandMnAServicetagShipDateCountry_Esupport extends BaseTest
{
	@Test
	public void validate_TC_6602498_AMER_CH_WarrantydetailsmodalLDellandMnAServicetagShipDateCountry_Esupport() 
	{
		try
		{
			System.out.println("Starts TC_6602498_AMER_CH_WarrantydetailsmodalLDellandMnAServicetagShipDateCountry_Esupport");
			obj_EsupportIPSWorkflow.searchServiceTag(driver, TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[0]);
			obj_EsupportIPSWorkflow.verifyProductName(driver);	
			obj_EsupportIPSWorkflow.verifyProductHeroSectionDetails(driver);
			obj_EsupportIPSWorkflow.clickViewDetailsLink(driver);	
			obj_EsupportIPSWorkflow.verifyWarrantyDetailsModalPopup(driver);


			for(int i=1;i<=3;i++)
			{
				obj_EsupportIPSWorkflow.navigateToURL(driver);
				obj_EsupportIPSWorkflow.searchServiceTag(driver, TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[i]);
				obj_EsupportIPSWorkflow.verifyProductHeroSectionDetails(driver);
				obj_EsupportIPSWorkflow.clickViewDetailsLink(driver);	
				obj_EsupportIPSWorkflow.verifyWarrantyDetailsModalPopup(driver);	
			}
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_6602498_AMER_CH_WarrantydetailsmodalLDellandMnAServicetagShipDateCountry_Esupport--------->\n  "+e);
		}
	}
}

