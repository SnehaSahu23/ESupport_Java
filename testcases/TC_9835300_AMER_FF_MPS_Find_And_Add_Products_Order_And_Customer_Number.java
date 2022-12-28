package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_9835300_AMER_FF_MPS_Find_And_Add_Products_Order_And_Customer_Number extends BaseTest 
{
	@Test
	   public void validate_TC_9835300_AMER_FF_MPS_Find_And_Add_Products_Order_And_Customer_Number()
	   {
		   try
		   {
			   obj_EsupportMPSWorkflow.SignInToMyAccount(driver, TestNGCreator.TestData.get(Esupport.Username.ordinal()), TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			   obj_EsupportMPSWorkflow.ClickOnAddProduct(driver);
			   obj_EsupportMPSWorkflow.VerifyAddProductHeaderText(driver);
			   obj_EsupportMPSWorkflow.AddCustomerOrderNumberPostalCode(driver, TestNGCreator.TestData.get(Esupport.CustomerNumber.ordinal()),
					                                                            TestNGCreator.TestData.get(Esupport.OrderNumber.ordinal()),
					                                                            TestNGCreator.TestData.get(Esupport.PostalCode.ordinal()));
			   obj_EsupportMPSWorkflow.ClickOnFindProductsButton(driver);
		   
		   }
		   catch(Exception e)
			{
				Assert.fail("Failed in TC_9835300_AMER_FF_MPS_Find_And_Add_Products_Order_And_Customer_Number()--------->\n  "+e);
			}
	   }
}
