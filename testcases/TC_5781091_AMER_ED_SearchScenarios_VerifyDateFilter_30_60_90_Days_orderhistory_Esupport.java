package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_5781091_AMER_ED_SearchScenarios_VerifyDateFilter_30_60_90_Days_orderhistory_Esupport extends BaseTest
{
	@Test
	public void validate_TC_5781091_AMER_ED_SearchScenarios_VerifyDateFilter_30_60_90_Days_orderhistory_Esupport() 
	{

		try
		{
			System.out.println("Starts TC# _5781091_AMER_ED");

			obj_EsupportDDLWorkflow.ClickonHomePageSignInbutton(driver);
			obj_EsupportDDLWorkflow.ToLogin_ValidCredentials(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));


			obj_EsupportDDLWorkflow.ToClick_HistoryTab(driver);
			obj_EsupportDDLWorkflow.ToVerify_TablesdataALL(driver);

			obj_EsupportDDLWorkflow.ToVerify_TablesdataThiryDays(driver);
			obj_EsupportDDLWorkflow.ToVerify_TablesdataSixtyDays(driver);
			obj_EsupportDDLWorkflow.ToVerify_TablesdataNintyDays(driver);

			obj_EsupportDDLWorkflow.ToVerify_TablesdataDateRange(driver);



		}catch(Exception e)
		{
			Assert.fail("Failed while executing test case TC_5781091_AMER_ED_SearchScenarios_VerifyDateFilter_30_60_90_Days_orderhistory_Esupport--------->\n  "+e);
		}
	}
}
