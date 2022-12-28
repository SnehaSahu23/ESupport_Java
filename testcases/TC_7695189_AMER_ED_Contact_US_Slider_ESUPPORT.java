package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_7695189_AMER_ED_Contact_US_Slider_ESUPPORT extends BaseTest 
{
	@Test
	public void validate_TC_7695189_AMER_ED_Contact_US_Slider_ESUPPORT() 
	{

		try
		{
			System.out.println("Starts TC_7695189_AMER_ED_Contact_US_Slider_ESUPPORT");
//			driver.get("https://www.dell.com/support/home/in/en/indhs1?app=products&~ck=mn");
			obj_EsupportIncidentsWorkflow.ToVerifyURL(driver);
			obj_EsupportIncidentsWorkflow.ClickOnSupportAndContactSupportAndTechnicalSupport(driver);

		}
		catch(Exception e)
		{

			Assert.fail("Failed while executing TC_7695189_AMER_ED_Contact_US_Slider_ESUPPORT--------->\n  "+e);

		}

	}
}
