package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_5780734_AMER_IE_ProductManagementScenarios_SoftwareDetails_VerifyGetkeyusingemail_Regular_ESUPPORT extends BaseTest 
{
	@Test
	public void validate_TC_5780734_AMER_IE_ProductManagementScenarios_SoftwareDetails_VerifyGetkeyusingemail_Regular_ESUPPORT() 
	{

		try
		{
			System.out.println("Starts TC_5780734_AMER_IE_ProductManagementScenarios_SoftwareDetails_VerifyGetkeyusingemail_Regular_ESUPPORT");
			obj_EsupportDDLWorkflow.ClickonHomePageSignInbutton(driver);
			obj_EsupportDDLWorkflow.validemailaddress(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()));
			obj_EsupportDDLWorkflow.validPassword(driver,TestNGCreator.TestData.get(Esupport.Password.ordinal()));

			obj_EsupportDDLWorkflow.ClickonSignInbutton(driver);
			obj_EsupportDDLWorkflow.clickDigitalProductsTab(driver);
			
			obj_EsupportDDLWorkflow.ToEnter_keywordsubmit(driver);
			
			obj_EsupportDDLWorkflow.ToSelectrow_Products(driver);
			obj_EsupportDDLWorkflow.ToClick_ProductNameLink(driver);
			
			obj_EsupportDDLWorkflow.ToClick_getkeylink(driver);
			obj_EsupportDDLWorkflow.Toclick_Sendemail(driver);
			
			
			
		}
		catch(Exception e)
		{

			Assert.fail("Failed while TC_1862483_AMER_IE_DriversNotifications_UnabletocreateSubscription_ESUPPORT--------->\n  "+e);

		}

	}
}