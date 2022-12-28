package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_5783688_AMER_FF_ChangeCountryonHTMLformatofManuals_ESUPPORT extends BaseTest 
{
	@Test
	public void validate_TC_5783688_AMER_FF_ChangeCountryonHTMLformatofManuals_ESUPPORT() 
	{

		try
		{
			System.out.println("Starts TC_5783688_AMER_FF_ChangeCountryonHTMLformatofManuals_ESUPPORT");
			obj_EsupportDriverandDownloadsWorkflow.ToVerify_EnterServiceTage(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));

			obj_EsupportContentWorkflow.ClickManualsandDocument_Tab(driver);
			obj_EsupportContentWorkflow.ToVerify_RegulatoryHeader(driver);
			obj_EsupportContentWorkflow.handleHtmlManual(driver);
			//obj_EsupportContentWorkflow.changeCountry(driver);
			Thread.sleep(10000);

		}
		catch(Exception e)
		{

			Assert.fail("Failed while TC_5783688_AMER_FF_ChangeCountryonHTMLformatofManuals_ESUPPORT--------->\n  "+e);

		}

	}
}
