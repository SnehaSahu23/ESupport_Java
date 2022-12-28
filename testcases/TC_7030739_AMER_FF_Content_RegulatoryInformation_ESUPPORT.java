package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_7030739_AMER_FF_Content_RegulatoryInformation_ESUPPORT extends BaseTest {


	@Test
	public void validate_TC_7030739_AMER_FF_Content_RegulatoryInformation_ESUPPORT() 
	{
		try
		{
			System.out.println("Starts TC_7030739_AMER_FF_Content_RegulatoryInformation_ESUPPORT()");
			obj_EsupportContentWorkflow.handleCookies(driver);
			obj_EsupportContentWorkflow.ClickSearchServiceTag(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
			obj_EsupportContentWorkflow.ClickDocumentationTab(driver);
			obj_EsupportContentWorkflow.ValidateDetailsOnLeftRail(driver);
			
			obj_EsupportContentWorkflow.ScrollToRegulatoryInformation(driver);
			
			obj_EsupportContentWorkflow.ValidateRegulatoryInformationDisplayTitleViewPDF(driver);
			
			obj_EsupportContentWorkflow.ClickOnLearnMore(driver);
			
			obj_EsupportContentWorkflow.ClickViewPDFHyperLink(driver);
		
			obj_EsupportContentWorkflow.ValidateChangeCountry(driver);
			obj_EsupportContentWorkflow.ChangeBackToDisplayedCountry(driver);
			
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_7030739_AMER_FF_Content_RegulatoryInformation_ESUPPORT()--------->\n  "+e);
		}
	}
}
