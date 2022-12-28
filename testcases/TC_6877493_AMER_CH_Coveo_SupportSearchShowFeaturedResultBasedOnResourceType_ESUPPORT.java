package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_6877493_AMER_CH_Coveo_SupportSearchShowFeaturedResultBasedOnResourceType_ESUPPORT extends BaseTest
{
	@Test
	public void validate_TC_6877493_AMER_CH_Coveo_SupportSearchShowFeaturedResultBasedOnResourceType_ESUPPORT() 
	{
		try
		{
			System.out.println("Starts TC_6877493_AMER_CH_Coveo_SupportSearchShowFeaturedResultBasedOnResourceType_ESUPPORT");
//			obj_EsupportContentWorkflow.handleCookies(driver);
			obj_EsupportCoveoWorkflow.ValidateSearchForKeyword(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()), TestNGCreator.TestData.get(Esupport.Dpid.ordinal()));
//			obj_EsupportCoveoWorkflow.SelectDellSupportVideos(driver, TestNGCreator.TestData.get(Esupport.Dpid.ordinal()));
			obj_EsupportCoveoWorkflow.SelectKnowledgebase(driver, TestNGCreator.TestData.get(Esupport.Dpid.ordinal()));
			obj_EsupportCoveoWorkflow.ValidateSearchForKeyword2(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()), TestNGCreator.TestData.get(Esupport.Dpid.ordinal()));
			
			obj_EsupportCoveoWorkflow.SelectDellSupportByTopic(driver,TestNGCreator.TestData.get(Esupport.Dpid.ordinal()));
			obj_EsupportCoveoWorkflow.SelectKnowledgebaseForKeyword2(driver, TestNGCreator.TestData.get(Esupport.Dpid.ordinal()));
			obj_EsupportCoveoWorkflow.SelectManualsAndDocuments(driver, TestNGCreator.TestData.get(Esupport.Dpid.ordinal()));
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_6877493_AMER_CH_Coveo_SupportSearchShowFeaturedResultBasedOnResourceType_ESUPPORT--------->\n  "+e);
		}
	}
}
