package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_6780658_AMER_IE_Coveo_AbilityToChangeLanguageForDell_ESUPPORT extends BaseTest
{
	@Test
	public void validate_TC_6780658_AMER_IE_Coveo_AbilityToChangeLanguageForDell_ESUPPORT() 
	{
		try
		{
			System.out.println("Starts TC_6780658_AMER_IE_Coveo_AbilityToChangeLanguageForDell_ESUPPORT");
			obj_EsupportContentWorkflow.handleCookies(driver);
			obj_EsupportContentWorkflow.ClickSearchServiceTag(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
			obj_EsupportContentWorkflow.ClickDocumentationTab(driver);
			obj_EsupportContentWorkflow.ScrollToManualsAndDocuments(driver);
//			obj_EsupportContentWorkflow.ClickViewPageHyperLinkForManualsAndDocuments(driver);
			obj_EsupportContentWorkflow.ValidateLanguageDropDownInManualsAndDocuments(driver);
//			obj_EsupportContentWorkflow.ValidateChangingLanguageFromDropDown(driver);
			

		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_6780658_AMER_IE_Coveo_AbilityToChangeLanguageForDell_ESUPPORT--------->\n  "+e);
		}
	}
}
