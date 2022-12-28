package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_9835063_AMER_ED_MPS_PCF_CreateEditGroupsSaveAndAddProductsCompleteAddingItemsToGroup_ESUPPORT extends BaseTest {


	@Test
	public void validate_TC_9835063_AMER_ED_MPS_PCF_CreateEditGroupsSaveAndAddProductsCompleteAddingItemsToGroup_ESUPPORT() 
	{
		try
		{
			System.out.println("Starts TC_9835063_AMER_ED_MPS_PCF_CreateEditGroupsSaveAndAddProductsCompleteAddingItemsToGroup_ESUPPORT()");
			
//			obj_EsupportMPSWorkflow.clickSignIn(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			obj_EsupportMPSWorkflow.SignInToMyAccount(driver, TestNGCreator.TestData.get(Esupport.Username.ordinal()), TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			obj_EsupportMPSWorkflow.verifyCreateOrEditGroupsLink(driver);
			obj_EsupportMPSWorkflow.clickOnCreateOrEditGroupsLink(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()));
			obj_EsupportMPSWorkflow.clickOnSaveAndAddProductButton(driver);
			
			obj_EsupportMPSWorkflow.selectProductsFromGrid(driver);
//			obj_EsupportMPSWorkflow.clickOnSaveGroup(driver);
			
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_9835063_AMER_ED_MPS_PCF_CreateEditGroupsSaveAndAddProductsCompleteAddingItemsToGroup_ESUPPORT()--------->\n  "+e);
		}
	}
}
