package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.MobileTestNGCreator;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_9410530_AMER_MB_LBK_Coveo_Story8400924LKBArticlemetadataonsearchpageMoresection_ESUPPORT extends MobilePage
{
	@Test
	public void validate_TC_9410530_AMER_MB_LBK_Coveo_Story8400924LKBArticlemetadataonsearchpageMoresection_ESUPPORT() 
	{
		try
		{
			System.out.println("Starts TC_9410530_AMER_MB_LBK_Coveo_Story8400924LKBArticlemetadataonsearchpageMoresection_ESUPPORT()");
			
			obj_EsupportMobileWorkflow.handleCookies(driver);
			obj_EsupportMobileWorkflow.ClickExtensionsAndPinMobileView(driver);
			obj_EsupportMobileWorkflow.ClickExtensionIconAndSelectDevice(driver, "Samsung_Galaxy_S6_Portrait");
            obj_EsupportMobileWorkflow.Switch_To_Mobile_window(driver);
			
            obj_EsupportMobileWorkflow.ToNavigate_SearchSupportPage(driver);
            obj_EsupportMobileWorkflow.ValidateSearchForKeywordWithOutDoubleQuotes_Keyword(driver, MobileTestNGCreator.TestData.get(Esupport.SearchOption.ordinal()), MobileTestNGCreator.TestData.get(Esupport.Dpid.ordinal()));
            obj_EsupportMobileWorkflow.SelectKnowledgebaseResouceTypeWithOutClearingFilterAtEnd(driver, MobileTestNGCreator.TestData.get(Esupport.Dpid.ordinal()));
//            obj_EsupportMobileWorkflow.ClickOnMoreAndValidateDetails(driver);
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_9410530_AMER_MB_LBK_Coveo_Story8400924LKBArticlemetadataonsearchpageMoresection_ESUPPORT()--------->\n  "+e);
		}
	}
}
