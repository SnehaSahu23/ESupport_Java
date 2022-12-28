package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_5780129_AMER_ED_ProductManagementScenariosProductManagementGetkeyusingemailsinglefileID_Esupport extends BaseTest
{
	@Test
	public void validate_TC_5780129_AMER_ED_ProductManagementScenariosProductManagementGetkeyusingemailsinglefileID_Esupport() 
	{

		try
		{
			System.out.println("Starts TC# 5780129_AMER_ED_ProductManagementScenariosProductManagementGetkeyusingemailsinglefileID_Esupport");

			obj_EsupportDDLWorkflow.ClickonHomePageSignInbutton(driver);
			obj_EsupportDDLWorkflow.ToLogin_ValidCredentials(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			obj_EsupportDDLWorkflow.clickDigitalProductsTab(driver);
			obj_EsupportDDLWorkflow.VerifySoftwareProductsGrid(driver);
			obj_EsupportDDLWorkflow.ToEnter_keywordsubmit(driver);


			obj_EsupportDDLWorkflow.ToClick_Orderdetails(driver);
			obj_EsupportDDLWorkflow.ToVerify_Productsearchtabs(driver);

			obj_EsupportDDLWorkflow.ToClick_getkeylink(driver);

			obj_EsupportDDLWorkflow.Toclick_Sendemail(driver);
			Thread.sleep(10000);



		}catch(Exception e)
		{
			Assert.fail("Failed while executing test case TC_5780129_AMER_ED_ProductManagementScenariosProductManagementGetkeyusingemailsinglefileID_Esupport--------->\n  "+e);
		}
	}
}