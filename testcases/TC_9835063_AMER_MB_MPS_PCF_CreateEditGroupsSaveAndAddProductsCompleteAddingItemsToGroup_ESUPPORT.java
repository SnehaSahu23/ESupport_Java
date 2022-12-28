package com.dell.delta_uat_automation.esupport.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.MobileTestNGCreator;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_9835063_AMER_MB_MPS_PCF_CreateEditGroupsSaveAndAddProductsCompleteAddingItemsToGroup_ESUPPORT extends MobilePage
{
	@Test
	public void validate_TC_9835063_AMER_MB_MPS_PCF_CreateEditGroupsSaveAndAddProductsCompleteAddingItemsToGroup_ESUPPORT() 
	{
		try
		{
			System.out.println("Starts TC_9835063_AMER_MB_MPS_PCF_CreateEditGroupsSaveAndAddProductsCompleteAddingItemsToGroup_ESUPPORT()");
			
			obj_EsupportMobileWorkflow.ClickExtensionsAndPinMobileView(driver);
			obj_EsupportMobileWorkflow.ClickExtensionIconAndSelectDevice(driver, "Samsung_Galaxy_S6_Portrait");
            obj_EsupportMobileWorkflow.Switch_To_Mobile_window(driver);
			
//			obj_EsupportMobileWorkflow.clickSignIn(driver,MobileTestNGCreator.TestData.get(Esupport.Username.ordinal()),MobileTestNGCreator.TestData.get(Esupport.Password.ordinal()));
		    obj_EsupportMobileWorkflow.SignInToMyAccount(driver, MobileTestNGCreator.TestData.get(Esupport.Username.ordinal()), MobileTestNGCreator.TestData.get(Esupport.Password.ordinal()));
			obj_EsupportMobileWorkflow.verifyCreateOrEditGroupsLink(driver);
			obj_EsupportMobileWorkflow.clickOnCreateOrEditGroupsLink(driver,MobileTestNGCreator.TestData.get(Esupport.SearchOption.ordinal()));
			obj_EsupportMobileWorkflow.clickOnSaveAndAddProductButton(driver);
			
			obj_EsupportMobileWorkflow.selectProductsFromGrid(driver);
//			obj_EsupportMobileWorkflow.clickOnSaveGroup(driver);
			
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_9835063_AMER_MB_MPS_PCF_CreateEditGroupsSaveAndAddProductsCompleteAddingItemsToGroup_ESUPPORT()--------->\n  "+e);
		}
	}
}
