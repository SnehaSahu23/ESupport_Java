package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_7030922_AMER_FF_Content_PARTSANDACCESSORIES_ESUPPORT extends BaseTest {


	@Test
	public void validate_TC_7030922_AMER_FF_Content_PARTSANDACCESSORIES_ESUPPORT() 
	{
		try
		{
			System.out.println("Starts TC_7030922_AMER_FF_Content_PARTSANDACCESSORIES_ESUPPORT");
			obj_EsupportContentWorkflow.handleCookies(driver);
			obj_EsupportContentWorkflow.ClickSearchProduct(driver,TestNGCreator.TestData.get(Esupport.Product.ordinal()));

			obj_EsupportContentWorkflow.ClickPartsAndAccessoriesTab(driver);
			
			obj_EsupportContentWorkflow.PartsAndAccessoriesValidation(driver);
			
			obj_EsupportContentWorkflow.ClickOnPartsAndAccessoriesUpgrades(driver);
			obj_EsupportContentWorkflow.ClickShopAllPartsAndAccessories(driver);
			
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_7030922_AMER_FF_Content_PARTSANDACCESSORIES_ESUPPORT--------->\n  "+e);
		}
	}
}
