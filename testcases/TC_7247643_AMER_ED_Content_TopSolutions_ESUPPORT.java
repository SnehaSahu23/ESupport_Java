package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_7247643_AMER_ED_Content_TopSolutions_ESUPPORT extends BaseTest {


	@Test
	public void validate_TC_7247643_AMER_ED_Content_TopSolutions_ESUPPORT() 
	{
		try
		{
			System.out.println("Starts TC_7247643_AMER_ED_Content_TopSolutions_ESUPPORT()");
			obj_EsupportContentWorkflow.handleCookies(driver);
			obj_EsupportContentWorkflow.ClickSearchServiceTag(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
			obj_EsupportContentWorkflow.ClickDocumentationTab(driver);
			obj_EsupportContentWorkflow.ValidateDetailsOnLeftRail(driver);
			obj_EsupportContentWorkflow.ScrollToTopSolutions(driver);
			obj_EsupportContentWorkflow.ValidateTopSolutionsDisplayTitleViewPageCollapseIcon(driver);
			obj_EsupportContentWorkflow.ClickCollapseIconValidateText(driver);
			obj_EsupportContentWorkflow.ClickCollapseIconToValidateExpandIcon(driver);
			obj_EsupportContentWorkflow.ClickExpandIconToValidateCollapseIcon(driver);
			obj_EsupportContentWorkflow.ClickViewPageHyperLink(driver);
			obj_EsupportContentWorkflow.ValidateAvailableTopSolutionsCount(driver);
			obj_EsupportContentWorkflow.ClickSeeAllButton(driver);
			obj_EsupportContentWorkflow.ClickOnBackToDocumentationTab(driver);
			
			obj_EsupportContentWorkflow.ValidateChangeCountry(driver);
			obj_EsupportContentWorkflow.ChangeBackToDisplayedCountry(driver);
			
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_7247643_AMER_ED_Content_TopSolutions_ESUPPORT()--------->\n  "+e);
		}
	}
}
