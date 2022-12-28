package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_9839169_AMER_FF_MPS_PCF_MPSRowDropdownAddProductsRemoveProductsAndContactSupport_ESUPPORT extends BaseTest {


	@Test
	public void validate_TC_9839169_AMER_FF_MPS_PCF_MPSRowDropdownAddProductsRemoveProductsAndContactSupport_ESUPPORT() 
	{
		try
		{
			System.out.println("Starts TC_9839169_AMER_FF_MPS_PCF_MPSRowDropdownAddProductsRemoveProductsAndContactSupport_ESUPPORT()");
			
//			obj_EsupportMPSWorkflow.clickSignIn(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			obj_EsupportMPSWorkflow.SignInToMyAccount(driver, TestNGCreator.TestData.get(Esupport.Username.ordinal()), TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			obj_EsupportMPSWorkflow.clickOn3DotsOfFirstDisplayedRow(driver);
			obj_EsupportMPSWorkflow.selectRemoveGroup(driver);
			obj_EsupportMPSWorkflow.clickOnRemoveButton(driver);
			
			obj_EsupportMPSWorkflow.clickOn3DotsOfFirstDisplayedRow(driver);
			obj_EsupportMPSWorkflow.selectContactTechnicalSupport(driver);
			
			obj_EsupportMPSWorkflow.clickOn3DotsOfFirstDisplayedRow(driver);
			obj_EsupportMPSWorkflow.selectAddToGroup(driver);
			
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_9839169_AMER_FF_MPS_PCF_MPSRowDropdownAddProductsRemoveProductsAndContactSupport_ESUPPORT()--------->\n  "+e);
		}
	}
}
