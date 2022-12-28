package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_5869571_AMER_ED_ContactUSslider_Webparts_ESUPPORT extends BaseTest {
	@Test
	public void validate_TC_5869571_AMER_ED_ContactUSslider_Webparts_ESUPPORT() 
	{

		try
		{
			System.out.println("Starts TC# 5869571_AMER_ED_ContactUSslider_Webparts_ESUPPORT");
			
			
			obj_EsupportIntegratedHomePageWorkflow.ClickSignIn(driver);
			obj_EsupportIntegratedHomePageWorkflow.EmployeeLogin(driver, TestNGCreator.TestData.get(Esupport.Username.ordinal()).split(";")[0],TestNGCreator.TestData.get(Esupport.Password.ordinal()).split(";")[0]);
			obj_EsupportIntegratedHomePageWorkflow.ToClick_VerifyBalckCheckmarklogin(driver);
			obj_EsupportIntegratedHomePageWorkflow.ToClick_Verifycontactusfields(driver);
			obj_EsupportIntegratedHomePageWorkflow.TOVerify_contanctuschatwithsupport(driver);
			obj_EsupportIntegratedHomePageWorkflow.toNavigateToIntegratedHomePage(driver);
			obj_EsupportIntegratedHomePageWorkflow.TOVerify_contanctusCreateServiceRequest(driver);
			obj_EsupportIntegratedHomePageWorkflow.toNavigateToIntegratedHomePage(driver);
			obj_EsupportIntegratedHomePageWorkflow.ToVerify_WebPartsbelowProductSelector(driver);
			
			
			
			
			
			Thread.sleep(4000);

		}
		catch(Exception e){

			Assert.fail("Failed while executing test case TC_5869571_AMER_ED_ContactUSslider_Webparts_ESUPPORT--------->\n  "+e);

		}

	}

}





