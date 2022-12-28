package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_6706292_AMER_IE_PSILDellAddfilestoMDLanddownloadMDL_Esupport extends BaseTest
{
	@Test
	public void validate_TC_6706292_AMER_IE_PSILDellAddfilestoMDLanddownloadMDL_Esupport() 
	{
		try
		{
			System.out.println("Starts TC_6706292_AMER_IE_PSILDellAddfilestoMDLanddownloadMDL_Esupport");

			
			obj_EsupportIPSWorkflow.clickBrowseAllProductsLink(driver);
//			obj_EsupportIPSWorkflow.clickLaptopsLink(driver);
//			if(TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[0].contains("G Series"))
//			{	
//		     	obj_EsupportIPSWorkflow.ClickGSeriesLink(driver);
//			}
//			else if(TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[1].contains("Latitude"))
//			{
//			   obj_EsupportIPSWorkflow.clickLatitudeLink(driver);
//			   obj_EsupportIPSWorkflow.clickLatitudeSeries(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[0]);
//			}
//			Thread.sleep(5000);
//			obj_EsupportIPSWorkflow.clickLatitudeSubProduct(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[1]);
			obj_EsupportIPSWorkflow.SelectProductFromBrowseAll(driver);
			obj_EsupportDriverandDownloadsWorkflow.pcfClickDriversandDownloadsTab(driver);
			obj_EsupportDriverandDownloadsWorkflow.pcfVerifyDriversTable(driver);
			//driver.navigate().refresh();
			obj_EsupportDriverandDownloadsWorkflow.pcfSelectDriversFromTable_IE(driver);
			obj_EsupportDriverandDownloadsWorkflow.pcfClickDownloadListToggleButton(driver);
			obj_EsupportDriverandDownloadsWorkflow.pcfDisplayDownloadListData(driver);
			obj_EsupportDriverandDownloadsWorkflow.pcfClickDownloadAllButton(driver);			
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_6706292_AMER_IE_PSILDellAddfilestoMDLanddownloadMDL_Esupport--------->\n  "+e);
		}
	}
}
