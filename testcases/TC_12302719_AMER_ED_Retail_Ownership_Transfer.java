package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_12302719_AMER_ED_Retail_Ownership_Transfer extends BaseTest
{
	@Test
    public void validate_TC_12302719_AMER_ED_Retail_Ownership_Transfer() 
    {
    	try 
    	{
    		System.out.println("Starts TC_12302719_AMER_ED_Retail_Ownership_Transfer");
    		
    		obj_EsupportOrderHomeWorkflow.handleCookies(driver);
    		obj_EsupportRetailAssetWorkflow.VerifyOwnershipTransferPage(driver);
    		obj_EsupportRetailAssetWorkflow.SelectSingleProductRadioButton(driver);
    		obj_EsupportRetailAssetWorkflow.ClickOnDetectPC(driver);
    		obj_EsupportRetailAssetWorkflow.ClickOnContinueButton(driver);
    		obj_EsupportRetailAssetWorkflow.FillPreviousOwnerDetails(driver);
    		obj_EsupportRetailAssetWorkflow.FillNewOwnerDetailsPage(driver, TestNGCreator.TestData.get(Esupport.IssueType.ordinal()),
    				TestNGCreator.TestData.get(Esupport.IssueType.ordinal()),
    				TestNGCreator.TestData.get(Esupport.Gstid.ordinal()));
    		obj_EsupportRetailAssetWorkflow.VerifyCoverageAndAvailabilityNoticePopUp(driver);
    		obj_EsupportRetailAssetWorkflow.VerifyReviewPage(driver);
    		obj_EsupportRetailAssetWorkflow.VerifyTransferReqSubmittedOrNot(driver);
    	}
    	catch(Exception e)
		{
			Assert.fail("Failed in TC_12302719_AMER_ED_Retail_Ownership_Transfer--------->\n  "+e);
		}
    }
}
