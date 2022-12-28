package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_12234360_AMER_ED_MPS_Premier_SignIn_My_Products_Tab_Grid_View_Activity_Column extends BaseTest
{
	@Test
	public void validate_TC_12234360_AMER_ED_MPS_Premier_SignIn_My_Products_Tab_Grid_View_Activity_Column()
	{
		try
		{
			System.out.println("Starts TC_12234360_AMER_ED_MPS_Premier_SignIn_My_Products_Tab_Grid_View_Activity_Column");
			obj_EsupportMPSWorkflow.SignInToPremierAccount(driver, TestNGCreator.TestData.get(Esupport.Username.ordinal()), TestNGCreator.TestData.get(Esupport.Password.ordinal()),
					TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()));
//			obj_EsupportMPSWorkflow.ClickOnSupportMenuAndVerifyMyProductAndService(driver);
//			obj_EsupportMPSWorkflow.ClickOnMyProductAndService(driver);
			Thread.sleep(3000);
			obj_EsupportMPSWorkflow.ValidateMyProductsAndServicePage(driver);
			obj_EsupportMPSWorkflow.ValidateMyProductsTab(driver);
			obj_EsupportMPSWorkflow.ValidateMyProductsTab(driver);
			obj_EsupportMPSWorkflow.ClickOnServiceTagInMyProductsTab(driver);
			obj_EsupportMPSWorkflow.clickOnSupportServicesIconOnActiveColumn(driver);
			obj_EsupportMPSWorkflow.clickOnServiceRequestIconOnActiveColumn(driver);
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_12234360_AMER_ED_MPS_Premier_SignIn_My_Products_Tab_Grid_View_Activity_Column--------->\n  "+e);
		}
	}
}
