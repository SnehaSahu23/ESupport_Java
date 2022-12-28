package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_5786143_AMER_CH_Checkforthe_FAQstab_Esupport extends BaseTest {
	@Test
	public void validate_TC_5786143_AMER_CH_Checkforthe_FAQstab_Esupport() 
	{

		try
		{
			System.out.println("Starts TC# 5786143_AMER_CH");
			Thread.sleep(10000);
			obj_EsupportMPSWorkflow.toClick_SignIn(driver);
			
			
			obj_EsupportMPSWorkflow.Login(driver);
			obj_EsupportMPSWorkflow.clickFaqs(driver);


			Thread.sleep(3000);


		}
		catch(Exception e){

			Assert.fail("Failed while executing test case TC_5786143_AMER_CH_Checkforthe_FAQstab_Esupport--------->\n  "+e);

		}

	}

}

