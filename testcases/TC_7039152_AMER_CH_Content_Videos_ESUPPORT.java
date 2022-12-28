package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_7039152_AMER_CH_Content_Videos_ESUPPORT extends BaseTest {


	@Test
	public void validate_TC_7039152_AMER_CH_Content_Videos_ESUPPORT() 
	{
		try
		{
			System.out.println("Starts TC_7039152_AMER_CH_Content_Videos_ESUPPORT");
			obj_EsupportContentWorkflow.handleCookies(driver);
			obj_EsupportContentWorkflow.ClickSearchServiceTag(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));

			obj_EsupportContentWorkflow.ClickDocumentationTab(driver);
			obj_EsupportContentWorkflow.DisplaySearchBox(driver);
			obj_EsupportContentWorkflow.SearchForManuals(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()));
			obj_EsupportContentWorkflow.ClickOnBackToDocumentationTab(driver);
			
			driver.close();
			setBrowser("ES2CH");
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_7039152_AMER_CH_Content_Videos_ESUPPORT--------->\n  "+e);
		}
	}
}

