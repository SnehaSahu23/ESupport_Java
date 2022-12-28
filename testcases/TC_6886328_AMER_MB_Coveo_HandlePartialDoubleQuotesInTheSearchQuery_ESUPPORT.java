package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_6886328_AMER_MB_Coveo_HandlePartialDoubleQuotesInTheSearchQuery_ESUPPORT extends MobilePage
{
	@Test
	public void validate_TC_6886328_AMER_MB_Coveo_HandlePartialDoubleQuotesInTheSearchQuery_ESUPPORT() 
	{
		try
		{
			System.out.println("Starts TC_6886328_AMER_MB_Coveo_HandlePartialDoubleQuotesInTheSearchQuery_ESUPPORT");
			Thread.sleep(6000);
			obj_EsupportMobileWorkflow.handleCookies(driver);
			
			obj_EsupportMobileWorkflow.ClickExtensionsAndPinMobileView(driver);
			obj_EsupportMobileWorkflow.ClickExtensionIconAndSelectDevice(driver, "Samsung_Galaxy_S6_Portrait");
            obj_EsupportMobileWorkflow.Switch_To_Mobile_window(driver);
            Thread.sleep(6000);
			
			
            obj_EsupportMobileWorkflow.ValidateSearchForKeywordCommandCenterWithDoublequotes(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()));
            obj_EsupportMobileWorkflow.ValidateSearchForKeywordBluetoothDriverWithDoublequotes(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()));
            obj_EsupportMobileWorkflow.ValidateSearchForKeywordAvamarCrashSymptomsWithDoublequotes(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()));
//			obj_EsupportCoveoWorkflow.ValidateSearchForVNXfailuremodeanalysisWithDoublequotes(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()));
//			obj_EsupportCoveoWorkflow.ValidateSearchForLatitudelatestDriverupdatesWithDoublequotes(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()));
//			obj_EsupportCoveoWorkflow.ValidateSearchForHardDiscReplicationsoftwareWithDoublequotes(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()));
//			obj_EsupportCoveoWorkflow.ValidateSearchFor038003816vnxWithDoublequotes(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()));
			
//			obj_EsupportContentWorkflow.ValidateChangeCountryForCoveoSearchResult(driver);
//            obj_EsupportMobileWorkflow.changeCountry_1(driver);
//            obj_EsupportMobileWorkflow.ChangeBackToDisplayedCountry(driver);
			
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_6886328_AMER_MB_Coveo_HandlePartialDoubleQuotesInTheSearchQuery_ESUPPORT--------->\n  "+e);
		}
	}
}
