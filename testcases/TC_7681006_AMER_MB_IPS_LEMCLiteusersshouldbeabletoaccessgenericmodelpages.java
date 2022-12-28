package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.MobileTestNGCreator;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_7681006_AMER_MB_IPS_LEMCLiteusersshouldbeabletoaccessgenericmodelpages extends MobilePage{
	@Test
	public void validate_TC_7681006_AMER_MB_IPS_LEMCLiteusersshouldbeabletoaccessgenericmodelpages() 
	{
		try
		{
			System.out.println("Starts TC_7681006_AMER_MB_IPS_LEMCLiteusersshouldbeabletoaccessgenericmodelpages");

			Thread.sleep(6000);
			obj_EsupportMobileWorkflow.handleCookies(driver);
			Thread.sleep(6000);
			
			obj_EsupportMobileWorkflow.clickSignIn(driver);
            obj_EsupportMobileWorkflow.Emaillogin(driver,MobileTestNGCreator.TestData.get(Esupport.Username.ordinal()).split(";")[0],MobileTestNGCreator.TestData.get(Esupport.Password.ordinal()).split(";")[0]);
            
			obj_EsupportMobileWorkflow.ClickExtensionsAndPinMobileView(driver);
			obj_EsupportMobileWorkflow.ClickExtensionIconAndSelectDevice(driver, "Samsung_Galaxy_S6_Portrait");
            obj_EsupportMobileWorkflow.Switch_To_Mobile_window(driver);
            Thread.sleep(6000);
            
			//Level 10 User
			
            obj_EsupportMobileWorkflow.selectProductModel(driver,MobileTestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[0]);
			obj_EsupportMobileWorkflow.signOut(driver);
			obj_EsupportMobileWorkflow.clickChangeProductLink(driver);
			driver.get("https://www.dell.com/support/home/en-us");
			Thread.sleep(10000);
			
			//Level 30 User
			obj_EsupportMobileWorkflow.clickSignIn(driver);
			obj_EsupportMobileWorkflow.Emaillogin(driver,MobileTestNGCreator.TestData.get(Esupport.Username.ordinal()).split(";")[1],MobileTestNGCreator.TestData.get(Esupport.Password.ordinal()).split(";")[1]);
			obj_EsupportMobileWorkflow.selectProductModel(driver,MobileTestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[0]);
			obj_EsupportMobileWorkflow.signOut(driver);
			obj_EsupportMobileWorkflow.clickChangeProductLink(driver);
			driver.get("https://www.dell.com/support/home/en-us");
			Thread.sleep(10000);
			//LDell User
			obj_EsupportMobileWorkflow.clickSignIn(driver);
			obj_EsupportMobileWorkflow.Emaillogin(driver,MobileTestNGCreator.TestData.get(Esupport.Username.ordinal()).split(";")[2],MobileTestNGCreator.TestData.get(Esupport.Password.ordinal()).split(";")[2]);
		//	obj_EsupportIPSWorkflow.verifyLdellPermissionMessage(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[0]);
			obj_EsupportMobileWorkflow.selectProductModel(driver,MobileTestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[0]);
			obj_EsupportMobileWorkflow.signOut(driver);
			obj_EsupportMobileWorkflow.clickChangeProductLink(driver);
			driver.get("https://www.dell.com/support/home/en-us");
			Thread.sleep(10000);
			//Lite User
//			obj_EsupportMobileWorkflow.clickSignIn(driver);
//			obj_EsupportMobileWorkflow.Emaillogin(driver,MobileTestNGCreator.TestData.get(Esupport.Username.ordinal()).split(";")[3],MobileTestNGCreator.TestData.get(Esupport.Password.ordinal()).split(";")[3]);
//			obj_EsupportMobileWorkflow.clickBrowseAllProductsLink(driver);
//			obj_EsupportMobileWorkflow.SelectProductFromBrowseAll(driver);
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_7681006_AMER_MB_IPS_LEMCLiteusersshouldbeabletoaccessgenericmodelpage--------->\n  "+e);
		}
	}
}

