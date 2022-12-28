package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.MobileTestNGCreator;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_5836926_AMER_MB_Coveo_TOPSOLUTIONS_Implementation_ESUPPORT extends MobilePage
{
	@Test
	public void validate_TC_5836926_AMER_MB_Coveo_TOPSOLUTIONS_Implementation_ESUPPORT() 
	{
		try
		{
			System.out.println("Starts TC_5836926_AMER_MB_Coveo_TOPSOLUTIONS_Implementation_ESUPPORT");

			Thread.sleep(6000);
			obj_EsupportMobileWorkflow.handleCookies(driver);
			
			obj_EsupportMobileWorkflow.ClickExtensionsAndPinMobileView(driver);
			obj_EsupportMobileWorkflow.ClickExtensionIconAndSelectDevice(driver, "Samsung_Galaxy_S6_Portrait");
            obj_EsupportMobileWorkflow.Switch_To_Mobile_window(driver);
            Thread.sleep(6000);
			
            obj_EsupportMobileWorkflow.clickBrowseAllProductsLink(driver);
            obj_EsupportMobileWorkflow.SelectProductFromBrowseAll(driver);
//            obj_EsupportMobileWorkflow.clickLaptopsLink(driver);
//            obj_EsupportMobileWorkflow.clickLatitudeLink(driver);
//            obj_EsupportMobileWorkflow.clickLatitudeSeries(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[0]);
//            obj_EsupportMobileWorkflow.clickLatitudeSubProduct(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[1]);
			//Scenario 1
//			obj_EsupportContentWorkflow.ValidateTopSolutionsInOverviewTab(driver);
//			obj_EsupportContentWorkflow.ValidateTopSolutionsSection(driver);
			//scenario 2
//			obj_EsupportContentWorkflow.CheckForViewAllAvailabilityAndClickOnIt(driver);
			
			
			//scenario 3
			driver.navigate().to("https://www.dell.com/support/home/us/en/19/");
			obj_EsupportMobileWorkflow.ClickSearchServiceTag(driver, MobileTestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
			obj_EsupportMobileWorkflow.ClickDocumentationTab(driver);
			obj_EsupportMobileWorkflow.ValidateDetailsOnLeftRail(driver);
			
			obj_EsupportMobileWorkflow.ScrollToManualsAndDocuments(driver);
//			obj_EsupportContentWorkflow.ValidateChangeCountryForCanada(driver);
//			obj_EsupportContentWorkflow.ChangeBackToDisplayedCountry(driver);
//			obj_EsupportMobileWorkflow.changeCountry_1(driver);
//			obj_EsupportMobileWorkflow.ChangeBackToDisplayedCountry(driver);
			
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_5836926_AMER_MB_Coveo_TOPSOLUTIONS_Implementation_ESUPPORT--------->\n  "+e);
		}
	}
}
