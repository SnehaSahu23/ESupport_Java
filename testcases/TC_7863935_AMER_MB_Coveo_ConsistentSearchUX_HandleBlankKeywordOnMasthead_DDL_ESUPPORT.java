package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_7863935_AMER_MB_Coveo_ConsistentSearchUX_HandleBlankKeywordOnMasthead_DDL_ESUPPORT extends MobilePage
{
	@Test
	public void validate_TC_7863935_AMER_MB_Coveo_ConsistentSearchUX_HandleBlankKeywordOnMasthead_DDL_ESUPPORT() 
	{
		try
		{
			System.out.println("Starts TC_7863935_AMER_MB_Coveo_ConsistentSearchUX_HandleBlankKeywordOnMasthead_DDL_ESUPPORT");
			
			Thread.sleep(6000);
			obj_EsupportMobileWorkflow.handleCookies(driver);
			
			obj_EsupportMobileWorkflow.ClickExtensionsAndPinMobileView(driver);
			obj_EsupportMobileWorkflow.ClickExtensionIconAndSelectDevice(driver, "Samsung_Galaxy_S6_Portrait");
            obj_EsupportMobileWorkflow.Switch_To_Mobile_window(driver);
            Thread.sleep(6000);
			
            obj_EsupportMobileWorkflow.ToNavigate_DDLHomePage(driver);
			
			
            obj_EsupportMobileWorkflow.ValidateSearchPageWithOutEnteringKeywordInMastHeadAndClickOnSearchButtonInDDLPageBeforeSignIn(driver);
            obj_EsupportMobileWorkflow.ValidateSearchPageWithEnteringSpaceInMastHeadAndClickOnSearchButtonInDDLPageBeforeSignIn(driver);
			
//            obj_EsupportMobileWorkflow.ClickonHomePageSignInbutton(driver);  need to  add method
            obj_EsupportMobileWorkflow.ToLogin_ValidCredentials(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			
            obj_EsupportMobileWorkflow.ValidateSearchPageWithOutEnteringKeywordInMastHeadAndClickOnSearchButtonInDDLPageAfterSignIn(driver);
            obj_EsupportMobileWorkflow.ValidateSearchPageWithEnteringSpaceInMastHeadAndClickOnSearchButtonInDDLPageAfterSignIn(driver);
			
            obj_EsupportMobileWorkflow.ValidateSearchForKeywordWithOutDoubleQuotes(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()), TestNGCreator.TestData.get(Esupport.Dpid.ordinal()));
			
            obj_EsupportMobileWorkflow.SelectKnowledgebaseResouceTypeWithOutClearingFilterAtEnd(driver, TestNGCreator.TestData.get(Esupport.Dpid.ordinal()));
			
            obj_EsupportMobileWorkflow.ValidateClickOnCrossLinkXOnCoveoSearchBox(driver, TestNGCreator.TestData.get(Esupport.Dpid.ordinal()));
			
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_7863935_AMER_MB_Coveo_ConsistentSearchUX_HandleBlankKeywordOnMasthead_DDL_ESUPPORT--------->\n  "+e);
		}
	}
}
