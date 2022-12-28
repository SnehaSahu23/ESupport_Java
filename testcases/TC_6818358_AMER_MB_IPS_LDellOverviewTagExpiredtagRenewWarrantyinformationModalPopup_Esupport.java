package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_6818358_AMER_MB_IPS_LDellOverviewTagExpiredtagRenewWarrantyinformationModalPopup_Esupport extends BaseTest
{
	@Test
	public void validate_TC_6818358_AMER_MB_IPS_LDellOverviewTagExpiredtagRenewWarrantyinformationModalPopup_Esupport() 
	{
		try
		{
			System.out.println("Starts TC_6818358_AMER_MB_IPS_LDellOverviewTagExpiredtagRenewWarrantyinformationModalPopup_Esupport");

			Thread.sleep(6000);
			obj_EsupportMobileWorkflow.handleCookies(driver);
			
			obj_EsupportMobileWorkflow.ClickExtensionIconAndSelectDevice(driver, "Samsung_Galaxy_S6_Portrait");
            obj_EsupportMobileWorkflow.Switch_To_Mobile_window(driver);
            Thread.sleep(6000);
            obj_EsupportMobileWorkflow.searchServiceTag_LDELL(driver, TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
            obj_EsupportMobileWorkflow.verifyOverviewTabDetails_SystemAtAGlance_Renew(driver);
			
            obj_EsupportMobileWorkflow.clickOnRenewButton(driver);
            obj_EsupportMobileWorkflow.clickViewDetailsLink(driver);
            obj_EsupportMobileWorkflow.verifyWarrantyDetailsModalPopup(driver);
            obj_EsupportMobileWorkflow.verifyPrintOption(driver);
			
            obj_EsupportMobileWorkflow.clickWarrantyDetailsCloseButton(driver);
            obj_EsupportMobileWorkflow.clickViewDetailsLink(driver);
            obj_EsupportMobileWorkflow.verifyImportantInformation(driver);
            obj_EsupportMobileWorkflow.verifyContentLinks(driver);			
			//			obj_EsupportIPSWorkflow.clickTermsOfSaleLink(driver);
			//			driver.navigate().back();
			//			obj_EsupportIPSWorkflow.clickViewDetailsLink(driver);
            obj_EsupportMobileWorkflow.clickRegisterYourProductLink(driver);
            obj_EsupportMobileWorkflow.Navigatebacktopreviouspage(driver);
//			driver.navigate().back();//create new method
//			driver.navigate().back();
//			Thread.sleep(5000);
            obj_EsupportMobileWorkflow.clickViewDetailsLink(driver);
            obj_EsupportMobileWorkflow.clickTransferOwnershipLink(driver);	
            obj_EsupportMobileWorkflow.Navigatebacktopreviouspage(driver);
            obj_EsupportMobileWorkflow.clickViewDetailsLink(driver);
            obj_EsupportMobileWorkflow.clickDDLLink(driver);	
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_6818358_AMER_MB_IPS_LDellOverviewTagExpiredtagRenewWarrantyinformationModalPopup_Esupport--------->\n  "+e);
		}
	}
}