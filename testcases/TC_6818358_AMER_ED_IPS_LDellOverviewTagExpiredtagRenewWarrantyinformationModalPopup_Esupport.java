package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_6818358_AMER_ED_IPS_LDellOverviewTagExpiredtagRenewWarrantyinformationModalPopup_Esupport extends BaseTest
{
	@Test
	public void validate_TC_6818358_AMER_ED_IPS_LDellOverviewTagExpiredtagRenewWarrantyinformationModalPopup_Esupport() 
	{
		try
		{
			System.out.println("Starts TC_6818358_AMER_ED_IPS_LDellOverviewTagExpiredtagRenewWarrantyinformationModalPopup_Esupport");

			obj_EsupportIPSWorkflow.searchServiceTag(driver, TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
			obj_EsupportIPSWorkflow.verifyOverviewTabDetails_SystemAtAGlance_Renew(driver);
			
			obj_EsupportIPSWorkflow.clickOnRenewButton(driver);
			obj_EsupportIPSWorkflow.clickViewDetailsLink(driver);
			obj_EsupportIPSWorkflow.verifyWarrantyDetailsModalPopup(driver);
			obj_EsupportIPSWorkflow.verifyPrintOption(driver);
			
			obj_EsupportIPSWorkflow.clickWarrantyDetailsCloseButton(driver);
			obj_EsupportIPSWorkflow.clickViewDetailsLink(driver);
			obj_EsupportIPSWorkflow.verifyImportantInformation(driver);
			obj_EsupportIPSWorkflow.verifyContentLinks(driver);			
			//			obj_EsupportIPSWorkflow.clickTermsOfSaleLink(driver);
			//			driver.navigate().back();
			//			obj_EsupportIPSWorkflow.clickViewDetailsLink(driver);
			obj_EsupportIPSWorkflow.clickRegisterYourProductLink(driver);
			obj_EsupportIPSWorkflow.Navigatebacktopreviouspage(driver);
//			driver.navigate().back();//create new method
//			driver.navigate().back();
//			Thread.sleep(5000);
			obj_EsupportIPSWorkflow.clickViewDetailsLink(driver);
			obj_EsupportIPSWorkflow.clickTransferOwnershipLink(driver);
			obj_EsupportIPSWorkflow.Navigatebacktopreviouspage(driver);
			obj_EsupportIPSWorkflow.clickViewDetailsLink(driver);
			obj_EsupportIPSWorkflow.clickDDLLink(driver);	

		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_6818358_AMER_ED_IPS_LDellOverviewTagExpiredtagRenewWarrantyinformationModalPopup_Esupport--------->\n  "+e);
		}
	}
}
