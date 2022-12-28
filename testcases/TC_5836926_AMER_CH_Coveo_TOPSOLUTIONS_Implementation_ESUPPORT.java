package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_5836926_AMER_CH_Coveo_TOPSOLUTIONS_Implementation_ESUPPORT extends BaseTest
{
	@Test
	public void validate_TC_5836926_AMER_CH_Coveo_TOPSOLUTIONS_Implementation_ESUPPORT() 
	{
		try
		{
			System.out.println("Starts TC_5836926_AMER_CH_Coveo_TOPSOLUTIONS_Implementation_ESUPPORT");

			obj_EsupportIPSWorkflow.clickBrowseAllProductsLink(driver);
			obj_EsupportIPSWorkflow.SelectProductFromBrowseAll(driver);
//			obj_EsupportIPSWorkflow.clickLaptopsLink(driver);
//			obj_EsupportIPSWorkflow.clickLatitudeLink(driver);
//			obj_EsupportIPSWorkflow.clickLatitudeSeries(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[0]);
//			obj_EsupportIPSWorkflow.clickLatitudeSubProduct(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[1]);
			//Scenario 1
//			obj_EsupportContentWorkflow.ValidateTopSolutionsInOverviewTab(driver);
//			obj_EsupportContentWorkflow.ValidateTopSolutionsSection(driver);
			//scenario 2
//			obj_EsupportContentWorkflow.CheckForViewAllAvailabilityAndClickOnIt(driver);
			
			
			//scenario 3
			driver.navigate().to("https://www.dell.com/support/home/us/en/19/");
			obj_EsupportContentWorkflow.ClickSearchServiceTag(driver, TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
			obj_EsupportContentWorkflow.ClickDocumentationTab(driver);
			obj_EsupportContentWorkflow.ValidateDetailsOnLeftRail(driver);
			
			obj_EsupportContentWorkflow.ScrollToManualsAndDocuments(driver);
//			obj_EsupportContentWorkflow.ValidateChangeCountryForCanada(driver);
//			obj_EsupportContentWorkflow.ChangeBackToDisplayedCountry(driver);
//			obj_EsupportContentWorkflow.changeCountry_1(driver);
//			obj_EsupportContentWorkflow.ChangeBackToDisplayedCountry(driver);
			
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_5836926_AMER_CH_Coveo_TOPSOLUTIONS_Implementation_ESUPPORT--------->\n  "+e);
		}
	}
}
