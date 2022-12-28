package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.MobileTestNGCreator;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_6877493_AMER_MB_Coveo_SupportSearchShowFeaturedResultBasedOnResourceType_ESUPPORT extends MobilePage
{
	@Test
	public void validate_TC_6877493_AMER_MB_Coveo_SupportSearchShowFeaturedResultBasedOnResourceType_ESUPPORT() 
	{
		try
		{
			System.out.println("Starts TC_6877493_AMER_MB_Coveo_SupportSearchShowFeaturedResultBasedOnResourceType_ESUPPORT");
//			obj_EsupportContentWorkflow.handleCookies(driver);
			
			Thread.sleep(6000);
			obj_EsupportMobileWorkflow.handleCookies(driver);
			
			obj_EsupportMobileWorkflow.ClickExtensionsAndPinMobileView(driver);
			obj_EsupportMobileWorkflow.ClickExtensionIconAndSelectDevice(driver, "Samsung_Galaxy_S6_Portrait");
            obj_EsupportMobileWorkflow.Switch_To_Mobile_window(driver);
            Thread.sleep(6000);
			
            obj_EsupportMobileWorkflow.ValidateSearchForKeyword(driver, MobileTestNGCreator.TestData.get(Esupport.SearchOption.ordinal()), MobileTestNGCreator.TestData.get(Esupport.Dpid.ordinal()));
            obj_EsupportMobileWorkflow.SelectDellSupportVideos(driver, MobileTestNGCreator.TestData.get(Esupport.Dpid.ordinal()));
            obj_EsupportMobileWorkflow.SelectKnowledgebase(driver, MobileTestNGCreator.TestData.get(Esupport.Dpid.ordinal()));
            obj_EsupportMobileWorkflow.ValidateSearchForKeyword2(driver, MobileTestNGCreator.TestData.get(Esupport.SearchOption.ordinal()), MobileTestNGCreator.TestData.get(Esupport.Dpid.ordinal()));
			
            obj_EsupportMobileWorkflow.SelectDellSupportByTopic(driver,MobileTestNGCreator.TestData.get(Esupport.Dpid.ordinal()));
            obj_EsupportMobileWorkflow.SelectKnowledgebaseForKeyword2(driver, MobileTestNGCreator.TestData.get(Esupport.Dpid.ordinal()));
            obj_EsupportMobileWorkflow.SelectManualsAndDocuments(driver, MobileTestNGCreator.TestData.get(Esupport.Dpid.ordinal()));
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_6877493_AMER_MB_Coveo_SupportSearchShowFeaturedResultBasedOnResourceType_ESUPPORT--------->\n  "+e);
		}
	}
}
