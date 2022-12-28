package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_5784237_AMER_IE_OrderHistoryScenariosOrderHistoryVerifyToolbarinHistorypage_Esupport extends BaseTest {
	@Test
	public void validate_TC_5784237_AMER_IE_OrderHistoryScenariosOrderHistoryVerifyToolbarinHistorypage_Esupport() 
	{
		try
		{
			System.out.println("Starts TC_5784237_AMER_IE_OrderHistoryScenariosOrderHistoryVerifyToolbarinHistorypage_Esupport");

			
			
			obj_EsupportDDLWorkflow.ClickonHomePageSignInbutton(driver);
			obj_EsupportDDLWorkflow.handleCookies(driver);
			obj_EsupportDDLWorkflow.validemailaddress(driver, TestNGCreator.TestData.get(Esupport.Username.ordinal()));
			obj_EsupportDDLWorkflow.validPassword(driver, TestNGCreator.TestData.get(Esupport.Password.ordinal()));

			obj_EsupportDDLWorkflow.ClickonSignInbutton(driver); 
			obj_EsupportDDLWorkflow.Click_OrderHistoryTab(driver);
			obj_EsupportDDLWorkflow.verifyActionsLabel(driver);
			obj_EsupportDDLWorkflow.verifyActionsDropdown(driver);
		}
		catch(Exception e)
		{
			Assert.fail("Failed while executing test case TC_5784237_AMER_IE_OrderHistoryScenariosOrderHistoryVerifyToolbarinHistorypage_Esupport--------->\n  "+e);
		}
	}
}

