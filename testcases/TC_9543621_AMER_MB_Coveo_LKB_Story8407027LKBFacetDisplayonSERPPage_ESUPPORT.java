package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.MobileTestNGCreator;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_9543621_AMER_MB_Coveo_LKB_Story8407027LKBFacetDisplayonSERPPage_ESUPPORT extends MobilePage
{
	@Test
	public void validate_TC_9543621_AMER_MB_Coveo_LKB_Story8407027LKBFacetDisplayonSERPPage_ESUPPORT() 
	{
		try
		{
			System.out.println("Starts TC_9543621_AMER_MB_Coveo_LKB_Story8407027LKBFacetDisplayonSERPPage_ESUPPORT()");
			
			obj_EsupportMobileWorkflow.handleCookies(driver);
			obj_EsupportMobileWorkflow.ClickExtensionsAndPinMobileView(driver);
			obj_EsupportMobileWorkflow.ClickExtensionIconAndSelectDevice(driver, "Samsung_Galaxy_S6_Portrait");
            
			obj_EsupportMobileWorkflow.Switch_To_Mobile_window(driver);
			
			obj_EsupportMobileWorkflow.ToNavigate_SearchSupportPage(driver);
			obj_EsupportMobileWorkflow.ValidateSearchForKeywordWithOutDoubleQuotes_Keyword(driver, MobileTestNGCreator.TestData.get(Esupport.SearchOption.ordinal()), MobileTestNGCreator.TestData.get(Esupport.Dpid.ordinal()));
			obj_EsupportMobileWorkflow.SelectKnowledgebaseResouce_ValidateArticleTypeStatusOtherDetails(driver, MobileTestNGCreator.TestData.get(Esupport.Dpid.ordinal()));
			
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_9543621_AMER_MB_Coveo_LKB_Story8407027LKBFacetDisplayonSERPPage_ESUPPORT()--------->\n  "+e);
		}
	}
}
