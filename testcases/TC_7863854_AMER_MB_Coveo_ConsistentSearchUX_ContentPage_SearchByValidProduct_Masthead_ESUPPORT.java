package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.MobileTestNGCreator;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_7863854_AMER_MB_Coveo_ConsistentSearchUX_ContentPage_SearchByValidProduct_Masthead_ESUPPORT extends MobilePage
{
	@Test
	public void validate_TC_7863854_AMER_CH_Coveo_ConsistentSearchUX_ContentPage_SearchByValidProduct_Masthead_ESUPPORT() 
	{
		try
		{
			System.out.println("Starts TC_7863854_AMER_CH_Coveo_ConsistentSearchUX_ContentPage_SearchByValidProduct_Masthead_ESUPPORT");
			
			Thread.sleep(6000);
			obj_EsupportMobileWorkflow.handleCookies(driver);
			
			obj_EsupportMobileWorkflow.ClickExtensionsAndPinMobileView(driver);
			obj_EsupportMobileWorkflow.ClickExtensionIconAndSelectDevice(driver, "Samsung_Galaxy_S6_Portrait");
            obj_EsupportMobileWorkflow.Switch_To_Mobile_window(driver);
            Thread.sleep(6000);
			
            obj_EsupportMobileWorkflow.ToNavigate_ArticleHTMLPage(driver);
			
		    obj_EsupportMobileWorkflow.SearchLatiInMastHeadAndSearchAutoDisplayedResults(driver);
            obj_EsupportMobileWorkflow.ValidateSearchForKeywordLatiAndSelectFirstResultFromSearchResultsAutoDisplayedResult(driver);
			obj_EsupportMobileWorkflow.NavigateBack(driver);
			obj_EsupportMobileWorkflow.ValidateSearchForKeywordLatiAndSelectFirstResultFromAutoDisplayedResultProductSupportPage(driver, MobileTestNGCreator.TestData.get(Esupport.SearchOption.ordinal()), MobileTestNGCreator.TestData.get(Esupport.Dpid.ordinal()));
			obj_EsupportMobileWorkflow.NavigateBack(driver);
			obj_EsupportMobileWorkflow.NavigateBack(driver);
			Thread.sleep(5000);
			obj_EsupportMobileWorkflow.ValidateSearchForKeywordLatiAndClickOnViewAllResultsForAutoDisplayedResult(driver);
			
	
			obj_EsupportMobileWorkflow.ToNavigate_SupportVidoesPage(driver);
			
			
			obj_EsupportMobileWorkflow.SearchLatiInMastHeadAndSearchAutoDisplayedResults(driver);
			obj_EsupportMobileWorkflow.ValidateSearchForKeywordLatiAndSelectFirstResultFromSearchResultsAutoDisplayedResult(driver);
			obj_EsupportMobileWorkflow.NavigateBack(driver);
			obj_EsupportMobileWorkflow.ValidateSearchForKeywordLatiAndSelectFirstResultFromAutoDisplayedResultProductSupportPage(driver, MobileTestNGCreator.TestData.get(Esupport.SearchOption.ordinal()), MobileTestNGCreator.TestData.get(Esupport.Dpid.ordinal()));
			obj_EsupportMobileWorkflow.NavigateBack(driver);
			obj_EsupportMobileWorkflow.NavigateBack(driver);
			Thread.sleep(5000);
			obj_EsupportMobileWorkflow.ValidateSearchForKeywordLatiAndClickOnViewAllResultsForAutoDisplayedResult(driver);
			
			obj_EsupportMobileWorkflow.ToNavigate_AlertVulnerabilitiesPage(driver);
			
			
			obj_EsupportMobileWorkflow.SearchLatiInMastHeadAndSearchAutoDisplayedResults(driver);
			obj_EsupportMobileWorkflow.ValidateSearchForKeywordLatiAndSelectFirstResultFromSearchResultsAutoDisplayedResult(driver);
			obj_EsupportMobileWorkflow.NavigateBack(driver);
			obj_EsupportMobileWorkflow.ValidateSearchForKeywordLatiAndSelectFirstResultFromAutoDisplayedResultProductSupportPage(driver, MobileTestNGCreator.TestData.get(Esupport.SearchOption.ordinal()), MobileTestNGCreator.TestData.get(Esupport.Dpid.ordinal()));
			obj_EsupportMobileWorkflow.NavigateBack(driver);
			obj_EsupportMobileWorkflow.NavigateBack(driver);
			Thread.sleep(5000);
			obj_EsupportMobileWorkflow.ValidateSearchForKeywordLatiAndClickOnViewAllResultsForAutoDisplayedResult(driver);
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_7863854_AMER_CH_Coveo_ConsistentSearchUX_ContentPage_SearchByValidProduct_Masthead_ESUPPORT--------->\n  "+e);
		}
	}
}
