package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_9410530_AMER_IE_LBK_Coveo_Story8400924LKBArticlemetadataonsearchpageMoresection_ESUPPORT extends BaseTest {


	@Test
	public void validate_TC_9410530_AMER_IE_LBK_Coveo_Story8400924LKBArticlemetadataonsearchpageMoresection_ESUPPORT() 
	{
		try
		{
			System.out.println("Starts TC_9410530_AMER_IE_LBK_Coveo_Story8400924LKBArticlemetadataonsearchpageMoresection_ESUPPORT()");
			
			obj_EsupportCoveoWorkflow.ToNavigate_SearchSupportPage(driver);
			obj_EsupportCoveoWorkflow.ValidateSearchForKeywordWithOutDoubleQuotes_Keyword(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()), TestNGCreator.TestData.get(Esupport.Dpid.ordinal()));
			obj_EsupportCoveoWorkflow.SelectKnowledgebaseResouceTypeWithOutClearingFilterAtEnd(driver, TestNGCreator.TestData.get(Esupport.Dpid.ordinal()));
//			obj_EsupportCoveoWorkflow.ClickOnMoreAndValidateDetails(driver);
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_9410530_AMER_IE_LBK_Coveo_Story8400924LKBArticlemetadataonsearchpageMoresection_ESUPPORT()--------->\n  "+e);
		}
	}
}
