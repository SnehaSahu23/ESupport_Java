package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_12304393_AMER_ED_Retail_Bulk_Registration extends BaseTest
{
	@Test
    public void validate_TC_12304393_AMER_ED_Retail_Bulk_Registration()
    {
	   try
	   {
		   System.out.println("Starts TC_12304393_AMER_ED_Retail_Bulk_Registration");
		   
		   obj_EsupportOrderHomeWorkflow.handleCookies(driver);  
		   obj_EsupportRetailAssetWorkflow.VerifyBulkTransferPage(driver);
		   obj_EsupportRetailAssetWorkflow.ClickOnDownloadCSVTemplateButton(driver);
		   obj_EsupportRetailAssetWorkflow.ClickOnChooseFileButton(driver);
		   obj_EsupportRetailAssetWorkflow.UploadFileThroughRobot(driver, "C:\\Users\\Snehamayee_Sahu.ASIA-PACIFIC\\Downloads\\bulk_transfer_template_v1.csv");
		   obj_EsupportRetailAssetWorkflow.VerifyFileHasAttachedOrNot(driver);
		   obj_EsupportRetailAssetWorkflow.ClickOnUploadCompletedCSVTemplateButton(driver);
	   }
	   catch(Exception e)
	   {
		   Assert.fail("Failed in TC_12302719_AMER_ED_Retail_Ownership_Transfer--------->\n  "+e);
	   }
    }
}
