package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_6082211_AMER_IE_FlexBillingBillingHistorySubscriptionamountandTotalamountupdate_Esupport extends BaseTest 
{
	@Test
	public void validate_TC_6082211_AMER_IE_FlexBillingBillingHistorySubscriptionamountandTotalamountupdate_Esupport() 
	{
		try
		{
			System.out.println("Starts TC_6082211_AMER_IE_FlexBillingBillingHistorySubscriptionamountandTotalamountupdate_Esupport");

			
			
			obj_EsupportDDLWorkflow.ClickonHomePageSignInbutton(driver);
			obj_EsupportDDLWorkflow.handleCookies(driver);
			obj_EsupportDDLWorkflow.validemailaddress(driver, TestNGCreator.TestData.get(Esupport.Username.ordinal()));
			obj_EsupportDDLWorkflow.validPassword(driver, TestNGCreator.TestData.get(Esupport.Password.ordinal()));

			obj_EsupportDDLWorkflow.ClickonSignInbutton(driver); 
			obj_EsupportDDLWorkflow.clickBillingAccountTab(driver);
			
			obj_EsupportDDLWorkflow.clickOfferNameData(driver, TestNGCreator.TestData.get(Esupport.Textarea.ordinal()));
			
			obj_EsupportDDLWorkflow.clickSelectAllOfferNameCheckboxAndBillHistoryLink(driver, TestNGCreator.TestData.get(Esupport.Textarea.ordinal()));
			
			obj_EsupportDDLWorkflow.displayAmountColumnData(driver);
			
			obj_EsupportDDLWorkflow.displayUnitChargeAmountColumnData(driver);
			
			obj_EsupportDDLWorkflow.clickViewDetailsLink(driver);
			
			obj_EsupportDDLWorkflow.verifyTotalAmount(driver);
		}
		catch(Exception e)
		{
			Assert.fail("Failed while executing test case TC_6082211_AMER_IE_FlexBillingBillingHistorySubscriptionamountandTotalamountupdate_Esupport--------->\n  "+e);
		}
	}
}

