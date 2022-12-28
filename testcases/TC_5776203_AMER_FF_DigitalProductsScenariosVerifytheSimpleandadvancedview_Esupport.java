package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_5776203_AMER_FF_DigitalProductsScenariosVerifytheSimpleandadvancedview_Esupport extends BaseTest {
	@Test
	public void validate_TC_5776203_AMER_FF_DigitalProductsScenariosVerifytheSimpleandadvancedview_Esupport() 
	{
		try
		{
			System.out.println("Starts TC_5776203_AMER_FF_DigitalProductsScenariosVerifytheSimpleandadvancedview_Esupport");

			//obj_EsupportDDLWorkflow.handleCookies(driver);

			obj_EsupportDDLWorkflow.ClickonHomePageSignInbutton(driver);

			obj_EsupportDDLWorkflow.validemailaddress(driver, TestNGCreator.TestData.get(Esupport.Username.ordinal()));
			obj_EsupportDDLWorkflow.validPassword(driver, TestNGCreator.TestData.get(Esupport.Password.ordinal()));

			obj_EsupportDDLWorkflow.ClickonSignInbutton(driver); 
			obj_EsupportDDLWorkflow.clickDigitalProductsTab(driver);
			obj_EsupportDDLWorkflow.VerifySoftwareProductsGrid(driver);
			obj_EsupportDDLWorkflow.clickOnSwitchToSimpleView(driver);
			obj_EsupportDDLWorkflow.verifySimpleViewElements(driver);			
			obj_EsupportDDLWorkflow.clickOnSwitchToAdvanceView(driver);			
			obj_EsupportDDLWorkflow.verifyAdvanceViewElements(driver);			
			obj_EsupportDDLWorkflow.verifySimpleViewLink(driver);
		}
		catch(Exception e)
		{
			Assert.fail("Failed while executing test case TC_5776203_AMER_FF_DigitalProductsScenariosVerifytheSimpleandadvancedview_Esupport--------->\n  "+e);
		}
	}
}
