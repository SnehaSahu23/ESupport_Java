package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_5783674_AMER_FF_Content_Manuals_nonenglish_country_ESUPPORT extends BaseTest 
{
	@Test
	public void validate_TC_5783674_AMER_FF_Content_Manuals_nonenglish_country_ESUPPORT() 
	{

		try
		{
			System.out.println("Starts TC_5783674_AMER_FF_Content_Manuals_nonenglish_country_ESUPPORT");
			
			obj_EsupportDriverandDownloadsWorkflow.ToVerify_EnterServiceTage(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
			obj_EsupportContentWorkflow.ClickManualsandDocument_Tab(driver);
			//obj_EsupportContentWorkflow.TOVerify_IconsDocument(driver);
			obj_EsupportContentWorkflow.ToVerify_RegulatoryHeader(driver);
			obj_EsupportContentWorkflow.clickPdfLink(driver);
			obj_EsupportContentWorkflow.TOclick_HtmlLink(driver);
			obj_EsupportContentWorkflow.changeCountry(driver);
			obj_EsupportContentWorkflow.ToVerify_ENIcon(driver);
			obj_EsupportContentWorkflow.ToClick_Lang(driver);
			obj_EsupportContentWorkflow.clickPdfLink(driver);
			obj_EsupportContentWorkflow.TOclick_HtmlLink(driver);
			
			
			
			
			
		}
		catch(Exception e)
		{

			Assert.fail("Failed while TC_5783674_AMER_FF_Content_Manuals_nonenglish_country_ESUPPORT--------->\n  "+e);

		}

	}
}
