package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_5784234_AMER_FF_OrderHistoryScenarios_VerifyDetailsGrid_orderdetailspage_Esupport extends BaseTest
{
	@Test
	public void validate_TC_5784234_AMER_FF_OrderHistoryScenarios_VerifyDetailsGrid_orderdetailspage_Esupport() 
	{

		try
		{
			System.out.println("Starts TC# TC_5784234_AMER_FF_OrderHistoryScenarios_VerifyDetailsGrid_orderdetailspage_Esupport");

			obj_EsupportDDLWorkflow.ClickonHomePageSignInbutton(driver);
			obj_EsupportDDLWorkflow.ToLogin_ValidCredentials(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));

			obj_EsupportDDLWorkflow.ToClick_HistoryTab(driver);

			obj_EsupportDDLWorkflow.ToClick_Orderdetails(driver);

			obj_EsupportDDLWorkflow.ToVerify_OrderSupportLinkTablesdata(driver);





		}catch(Exception e)
		{
			Assert.fail("Failed while executing test case TC_5784234_AMER_FF_OrderHistoryScenarios_VerifyDetailsGrid_orderdetailspage_Esupport--------->\n  "+e);
		}
	}
}
