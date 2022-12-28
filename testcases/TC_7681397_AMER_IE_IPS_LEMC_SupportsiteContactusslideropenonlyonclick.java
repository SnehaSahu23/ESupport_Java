package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_7681397_AMER_IE_IPS_LEMC_SupportsiteContactusslideropenonlyonclick extends BaseTest
{
	@Test
	public void validate_TC_7681397_AMER_IE_IPS_LEMC_SupportsiteContactusslideropenonlyonclick() 
	{
		try
		{
			System.out.println("Starts TC_7681397_AMER_IE_IPS_LEMC_SupportsiteContactusslideropenonlyonclick");
				
			obj_EsupportIncidentsWorkflow.clickSignIn(driver);
			obj_EsupportIPSWorkflow.Emaillogin(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			
			obj_EsupportIPSWorkflow.searchServiceTag(driver, TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));		
			obj_EsupportIPSWorkflow.verifyContactUsSlider(driver);
			obj_EsupportIPSWorkflow.verifyContactUsSliderClosed(driver);
			obj_EsupportIPSWorkflow.signOut(driver);
			obj_EsupportIncidentsWorkflow.clickChangeProductLink(driver);
			driver.get("https://www.dell.com/support/home/en-us");
			Thread.sleep(10000);
			
			obj_EsupportIncidentsWorkflow.clickSignIn(driver);
			obj_EsupportIPSWorkflow.Emaillogin(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			
			obj_EsupportIPSWorkflow.searchServiceTag(driver, TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));		
			obj_EsupportIPSWorkflow.verifyContactUsSlider(driver);
			obj_EsupportIPSWorkflow.clickInsideSupportPage(driver);
			Thread.sleep(10000);
			obj_EsupportIPSWorkflow.verifyContactUsSliderOpen(driver);
			Thread.sleep(10000);
			obj_EsupportIPSWorkflow.verifyContactSupportPageProductID(driver);
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_7681397_AMER_IE_IPS_LEMC_SupportsiteContactusslideropenonlyonclick--------->\n  "+e);
		}
	}
}




