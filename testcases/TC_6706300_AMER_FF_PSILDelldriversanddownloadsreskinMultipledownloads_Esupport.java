package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.MobileTestNGCreator;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_6706300_AMER_FF_PSILDelldriversanddownloadsreskinMultipledownloads_Esupport extends BaseTest
{
	@Test
	public void validate_TC_6706300_AMER_FF_PSILDelldriversanddownloadsreskinMultipledownloads_Esupport() 
	{
		try
		{
			System.out.println("Starts TC_6706300_AMER_FF_PSILDelldriversanddownloadsreskinMultipledownloads_Esupport");


			obj_EsupportIPSWorkflow.clickBrowseAllProductsLink(driver);
//			obj_EsupportIPSWorkflow.clickLaptopsLink(driver);
//			if(MobileTestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[0].contains("G Series"))
//			{	
//            	obj_EsupportMobileWorkflow.ClickGSeriesLink(driver);
//			}
//			else if(MobileTestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[1].contains("Latitude"))
//			{
//				obj_EsupportMobileWorkflow.clickLatitudeLink(driver);
//				obj_EsupportMobileWorkflow.clickLatitudeSeries(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[0]);
//			}
//			Thread.sleep(3000);
//			obj_EsupportIPSWorkflow.clickLatitudeSubProduct(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[1]);
//			
//			//obj_EsupportIPSWorkflow.clickLatitudeSubProduct(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()));
			obj_EsupportIPSWorkflow.SelectProductFromBrowseAll(driver);
			obj_EsupportDriverandDownloadsWorkflow.pcfClickDriversandDownloadsTab(driver);
			
			obj_EsupportDriverandDownloadsWorkflow.pcfSelectMultipleDrivers(driver);
			obj_EsupportDriverandDownloadsWorkflow.pcfClickDownloadListToggleButton(driver);
			obj_EsupportDriverandDownloadsWorkflow.pcfVerifyDownloadSectionDetails(driver);
			obj_EsupportDriverandDownloadsWorkflow.pcfDeleteDriversFromTable(driver);
//			obj_EsupportDriverandDownloadsWorkflow.pcfClickViewDetailsLink(driver);				
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_6706300_AMER_FF_PSILDelldriversanddownloadsreskinMultipledownloads_Esupport--------->\n  "+e);
		}
	}
}
