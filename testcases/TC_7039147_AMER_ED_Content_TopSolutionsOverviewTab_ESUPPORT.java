package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_7039147_AMER_ED_Content_TopSolutionsOverviewTab_ESUPPORT extends BaseTest {


	@Test
	public void validate_TC_7039147_AMER_ED_Content_TopSolutionsOverviewTab_ESUPPORT() 
	{
		try
		{
			System.out.println("Starts TC_7039147_AMER_ED_Content_TopSolutionsOverviewTab_ESUPPORT");
			obj_EsupportContentWorkflow.handleCookies(driver);
			obj_EsupportContentWorkflow.ClickSearchProduct(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[0]);
			//obj_EsupportContentWorkflow.NavigateBack(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[1]);
			//obj_EsupportContentWorkflow.SelectServiceTagORProductFromRecentlyViewed(driver);
			obj_EsupportContentWorkflow.ValidateTopSolutionsInOverviewTab(driver);
			obj_EsupportContentWorkflow.ValidateTopSolutionsSection(driver);
			obj_EsupportContentWorkflow.ClickReadMoreHyperlink(driver);
			obj_EsupportContentWorkflow.ClickViewAll(driver);
			
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_7039147_AMER_ED_Content_TopSolutionsOverviewTab_ESUPPORT--------->\n  "+e);
		}
	}
}
