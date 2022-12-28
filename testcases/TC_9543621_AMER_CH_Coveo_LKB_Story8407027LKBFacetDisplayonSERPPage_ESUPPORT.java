package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_9543621_AMER_CH_Coveo_LKB_Story8407027LKBFacetDisplayonSERPPage_ESUPPORT extends BaseTest {


	@Test
	public void validate_TC_9543621_AMER_CH_Coveo_LKB_Story8407027LKBFacetDisplayonSERPPage_ESUPPORT() 
	{
		try
		{
			System.out.println("Starts TC_9543621_AMER_CH_Coveo_LKB_Story8407027LKBFacetDisplayonSERPPage_ESUPPORT()");
			
			obj_EsupportCoveoWorkflow.ToNavigate_SearchSupportPage(driver);
			obj_EsupportCoveoWorkflow.ValidateSearchForKeywordWithOutDoubleQuotes_Keyword(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()), TestNGCreator.TestData.get(Esupport.Dpid.ordinal()));
			obj_EsupportCoveoWorkflow.SelectKnowledgebaseResouce_ValidateArticleTypeStatusOtherDetails(driver, TestNGCreator.TestData.get(Esupport.Dpid.ordinal()));
			
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_9543621_AMER_CH_Coveo_LKB_Story8407027LKBFacetDisplayonSERPPage_ESUPPORT()--------->\n  "+e);
		}
	}
}
