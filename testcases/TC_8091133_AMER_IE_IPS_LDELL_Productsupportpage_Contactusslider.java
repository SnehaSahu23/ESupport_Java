package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_8091133_AMER_IE_IPS_LDELL_Productsupportpage_Contactusslider extends BaseTest
{
	@Test
	public void validate_TC_8091133_AMER_IE_IPS_LDELL_Productsupportpage_Contactusslider() 
	{
		try
		{
			System.out.println("Starts TC_8091133_AMER_IE_IPS_LDELL_Productsupportpage_Contactusslider");
			
			obj_EsupportIPSWorkflow.handleCookies(driver);
			Thread.sleep(3000);
			obj_EsupportIPSWorkflow.searchServiceTag(driver, TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));		
			obj_EsupportIPSWorkflow.verifyContactUsSliderLandingPage(driver);
			obj_EsupportIPSWorkflow.verifyContactUsSliderOpen(driver);			
			obj_EsupportIPSWorkflow.verifyContactUsSliderContent(driver);
			obj_EsupportIPSWorkflow.clickTechnicalSupportLink(driver);
			obj_EsupportIntegratedHomePageWorkflow.clickOrderSupportContactUsSlider(driver);
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_8091133_AMER_IE_IPS_LDELL_Productsupportpage_Contactusslider--------->\n  "+e);
		}
	}
}

