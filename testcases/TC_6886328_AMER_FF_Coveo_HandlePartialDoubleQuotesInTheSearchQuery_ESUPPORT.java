package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_6886328_AMER_FF_Coveo_HandlePartialDoubleQuotesInTheSearchQuery_ESUPPORT extends BaseTest
{
	@Test
	public void validate_TC_6886328_AMER_FF_Coveo_HandlePartialDoubleQuotesInTheSearchQuery_ESUPPORT() 
	{
		try
		{
			System.out.println("Starts TC_6886328_AMER_FF_Coveo_HandlePartialDoubleQuotesInTheSearchQuery_ESUPPORT");
			obj_EsupportContentWorkflow.handleCookies(driver);
			obj_EsupportCoveoWorkflow.ValidateSearchForKeywordCommandCenterWithDoublequotes(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()));
			obj_EsupportCoveoWorkflow.ValidateSearchForKeywordBluetoothDriverWithDoublequotes(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()));
			obj_EsupportCoveoWorkflow.ValidateSearchForKeywordAvamarCrashSymptomsWithDoublequotes(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()));
//			obj_EsupportCoveoWorkflow.ValidateSearchForVNXfailuremodeanalysisWithDoublequotes(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()));
//			obj_EsupportCoveoWorkflow.ValidateSearchForLatitudelatestDriverupdatesWithDoublequotes(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()));
//			obj_EsupportCoveoWorkflow.ValidateSearchForHardDiscReplicationsoftwareWithDoublequotes(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()));
//			obj_EsupportCoveoWorkflow.ValidateSearchFor038003816vnxWithDoublequotes(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()));
			
//			obj_EsupportContentWorkflow.changeCountry_1(driver);
//			obj_EsupportContentWorkflow.ValidateChangeCountryForCoveoSearchResult(driver);
//			obj_EsupportContentWorkflow.ChangeBackToDisplayedCountry(driver);
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_6886328_AMER_FF_Coveo_HandlePartialDoubleQuotesInTheSearchQuery_ESUPPORT--------->\n  "+e);
		}
	}
}
