package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.MobileTestNGCreator;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_7863878_AMER_MB_Coveo_ConsistentSearchUX_HandleBlankKeywordOnMastheadSearch_ESUPPORT extends MobilePage
{
	@Test
	public void validate_TC_7863878_AMER_MB_Coveo_ConsistentSearchUX_HandleBlankKeywordOnMastheadSearch_ESUPPORT() 
	{
		try
		{
			System.out.println("Starts TC_7863878_AMER_MB_Coveo_ConsistentSearchUX_HandleBlankKeywordOnMastheadSearch_ESUPPORT");
			
			Thread.sleep(6000);
			obj_EsupportMobileWorkflow.handleCookies(driver);
			
			obj_EsupportMobileWorkflow.ClickExtensionsAndPinMobileView(driver);
			obj_EsupportMobileWorkflow.ClickExtensionIconAndSelectDevice(driver, "Samsung_Galaxy_S6_Portrait");
            obj_EsupportMobileWorkflow.Switch_To_Mobile_window(driver);
            Thread.sleep(6000);
			
            obj_EsupportMobileWorkflow.ToNavigate_SearchSupportPage(driver);
			
            obj_EsupportMobileWorkflow.ValidateSearchPageWithOutEnteringKeywordInMastHeadAndClickOnSearchButton(driver);
            obj_EsupportMobileWorkflow.ValidateSearchPageWithEnteringSpaceInMastHeadAndClickOnSearchButton(driver);
			
            obj_EsupportMobileWorkflow.ValidateSearchForKeywordWithOutDoubleQuotes(driver, MobileTestNGCreator.TestData.get(Esupport.SearchOption.ordinal()), MobileTestNGCreator.TestData.get(Esupport.Dpid.ordinal()));
			
            obj_EsupportMobileWorkflow.SelectKnowledgebaseResouceTypeWithOutClearingFilterAtEnd(driver, MobileTestNGCreator.TestData.get(Esupport.Dpid.ordinal()));
			
            obj_EsupportMobileWorkflow.ValidateClickOnCrossLinkXOnCoveoSearchBox(driver, MobileTestNGCreator.TestData.get(Esupport.Dpid.ordinal()));
			
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_7863878_AMER_MB_Coveo_ConsistentSearchUX_HandleBlankKeywordOnMastheadSearch_ESUPPORT--------->\n  "+e);
		}
	}
}
