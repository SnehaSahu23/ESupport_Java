package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_6082142_AMER_CH_FlexBillingGlobalcountryselector_Esupport extends BaseTest 
{
	@Test
	public void validate_TC_6082142_AMER_CH_FlexBillingGlobalcountryselector_Esupport() 
	{
		try
		{
			System.out.println("Starts TC_6082142_AMER_CH_FlexBillingGlobalcountryselector_Esupport");

			
			
			obj_EsupportDDLWorkflow.ClickonHomePageSignInbutton(driver);
			obj_EsupportDDLWorkflow.handleCookies(driver);
			obj_EsupportDDLWorkflow.validemailaddress(driver, TestNGCreator.TestData.get(Esupport.Username.ordinal()));
			obj_EsupportDDLWorkflow.validPassword(driver, TestNGCreator.TestData.get(Esupport.Password.ordinal()));

			obj_EsupportDDLWorkflow.ClickonSignInbutton(driver); 
			obj_EsupportDDLWorkflow.clickBillingAccountTab(driver);
			
			obj_EsupportDDLWorkflow.clickServiceWarrantyLink(driver);
			
			obj_EsupportDDLWorkflow.clickManagePaymentMethodLink(driver);
			
			obj_EsupportDDLWorkflow.clickChangePaymentButton(driver);
			
			obj_EsupportDDLWorkflow.enterPaymentDetails(driver);
			Thread.sleep(10000);
		}
		catch(Exception e)
		{
			Assert.fail("Failed while executing test case TC_6082142_AMER_CH_FlexBillingGlobalcountryselector_Esupport--------->\n  "+e);
		}
	}
}


