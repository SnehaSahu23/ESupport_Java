package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_6706298_AMER_CH_PSILDellDriversanddownloadsreskinforuntaggedviews_Esupport extends BaseTest
{
	@Test
	public void validate_TC_6706298_AMER_CH_PSILDellDriversanddownloadsreskinforuntaggedviews_Esupport() 
	{
		try
		{
			System.out.println("Starts TC_6706298_AMER_CH_PSILDellDriversanddownloadsreskinforuntaggedviews_Esupport");


			obj_EsupportIPSWorkflow.clickBrowseAllProductsLink(driver);
			obj_EsupportIPSWorkflow.SelectProductFromBrowseAll(driver);
//			obj_EsupportIPSWorkflow.clickLaptopsLink(driver);
//			obj_EsupportIPSWorkflow.clickLatitudeLink(driver);
//			
//			obj_EsupportIPSWorkflow.clickLatitudeSeries(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[0]);
//			obj_EsupportIPSWorkflow.clickLatitudeSubProduct(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[1]);
			
			//obj_EsupportIPSWorkflow.clickLatitudeSubProduct(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()));
			obj_EsupportDriverandDownloadsWorkflow.pcfClickDriversandDownloadsTab(driver);
			obj_EsupportDriverandDownloadsWorkflow.pcfVerifyDetectDriversButton(driver);
			obj_EsupportDriverandDownloadsWorkflow.pcfVerifyFilterSection(driver);
			obj_EsupportDriverandDownloadsWorkflow.pcfVerifyDriverListSection(driver);
			obj_EsupportDriverandDownloadsWorkflow.pcfVerifySortOptionDriverList(driver);
			obj_EsupportDriverandDownloadsWorkflow.pcfVerifyAdditionalResourceHeader(driver);
//			obj_EsupportDriverandDownloadsWorkflow.pcfSelectMultipleDrivers(driver);
//			obj_EsupportDriverandDownloadsWorkflow.pcfClickDownloadListToggleButton(driver);
//			obj_EsupportDriverandDownloadsWorkflow.pcfVerifyDownloadSectionDetails(driver);
//			obj_EsupportDriverandDownloadsWorkflow.pcfDeleteDriversFromTable(driver);
//			obj_EsupportDriverandDownloadsWorkflow.pcfClickViewDetailsLink(driver);				
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_6706298_AMER_CH_PSILDellDriversanddownloadsreskinforuntaggedviews_Esupport--------->\n  "+e);
		}
	}
}


