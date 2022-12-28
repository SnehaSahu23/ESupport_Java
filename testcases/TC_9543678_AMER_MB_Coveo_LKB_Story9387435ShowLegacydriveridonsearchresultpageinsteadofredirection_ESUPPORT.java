package com.dell.delta_uat_automation.esupport.testcases;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.MobileTestNGCreator;
import com.dell.delta_uat_automation.utility.TestNGCreator;
public class TC_9543678_AMER_MB_Coveo_LKB_Story9387435ShowLegacydriveridonsearchresultpageinsteadofredirection_ESUPPORT extends MobilePage {
	


		@Test
		public void validate_TC_9543678_AMER_MB_Coveo_LKB_Story9387435ShowLegacydriveridonsearchresultpageinsteadofredirection_ESUPPORT() 
		{
			try
			{
				System.out.println("Starts TC_9543678_AMER_MB_Coveo_LKB_Story9387435ShowLegacydriveridonsearchresultpageinsteadofredirection_ESUPPORT()");
				Thread.sleep(2000);
				obj_EsupportMobileWorkflow.handleCookies(driver);
				obj_EsupportMobileWorkflow.ClickExtensionsAndPinMobileView(driver);
				obj_EsupportMobileWorkflow.ClickExtensionIconAndSelectDevice(driver, "Samsung_Galaxy_S6_Portrait");
	            
				obj_EsupportMobileWorkflow.Switch_To_Mobile_window(driver);
		     	Thread.sleep(6000);
				//Scenario 1
				obj_EsupportMobileWorkflow.ToNavigate_SearchSupportPage(driver);
				obj_EsupportMobileWorkflow.ValidateSearchForKeywordWithOutDoubleQuotes_Keyword(driver, MobileTestNGCreator.TestData.get(Esupport.SearchOption.ordinal()), MobileTestNGCreator.TestData.get(Esupport.Dpid.ordinal()));
				obj_EsupportMobileWorkflow.ClickOnMoreLinkAndValidateDriverIDSearchResults(driver);
				
				//Scenario 2
				obj_EsupportMobileWorkflow.ToNavigate_IPShomepage(driver);
				obj_EsupportMobileWorkflow.ValidateSearchForKeywordWithOutDoubleQuotes_Keyword(driver, MobileTestNGCreator.TestData.get(Esupport.SearchOption.ordinal()), MobileTestNGCreator.TestData.get(Esupport.Dpid.ordinal()));
				obj_EsupportMobileWorkflow.ClickOnMoreLinkAndValidateDriverIDSearchResults(driver);
				
				//Scenario 3
				obj_EsupportMobileWorkflow.ToNavigate_IPShomepage(driver);
				obj_EsupportMobileWorkflow.searchServiceTag_CoveoSearch(driver, MobileTestNGCreator.TestData.get(Esupport.SearchOption.ordinal()));
				obj_EsupportMobileWorkflow.ClickOnMoreLinkAndValidateDriverIDSearchResults(driver);
				
			}
			catch(Exception e)
			{
				Assert.fail("Failed in TC_9543678_AMER_MB_Coveo_LKB_Story9387435ShowLegacydriveridonsearchresultpageinsteadofredirection_ESUPPORT()--------->\n  "+e);
			}
		}
	}



