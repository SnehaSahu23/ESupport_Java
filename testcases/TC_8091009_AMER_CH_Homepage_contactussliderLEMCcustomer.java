package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_8091009_AMER_CH_Homepage_contactussliderLEMCcustomer extends BaseTest
{
	@Test
	public void validate_TC_8091009_AMER_CH_Homepage_contactussliderLEMCcustomer() 
	{
		try
		{
			System.out.println("Starts TC_8091009_AMER_CH_Homepage_contactussliderLEMCcustomer");
				
			obj_EsupportIPSWorkflow.clickSignIn(driver);
			obj_EsupportIPSWorkflow.Emaillogin(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
//			obj_EsupportIPSWorkflow.clickSignInHereLink(driver);
//			obj_EsupportIntegratedHomePageWorkflow.ToClick_VerifyBalckCheckmarklogin(driver);
			Thread.sleep(5000);
			obj_EsupportIPSWorkflow.verifyContactUsSlider(driver);
			obj_EsupportIPSWorkflow.verifyContactUsSliderContent(driver);
			obj_EsupportIntegratedHomePageWorkflow.clickChatWithSupportOptionContactSlider(driver);
//			obj_EsupportIntegratedHomePageWorkflow.clickCreateServiceRequestContactSlider(driver);
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_8091009_AMER_CH_Homepage_contactussliderLEMCcustomer--------->\n  "+e);
		}
	}
}
