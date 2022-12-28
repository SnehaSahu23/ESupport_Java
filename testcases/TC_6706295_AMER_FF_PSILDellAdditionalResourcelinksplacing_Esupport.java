package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_6706295_AMER_FF_PSILDellAdditionalResourcelinksplacing_Esupport extends BaseTest
{
	@Test
	public void validate_TC_6706295_AMER_FF_PSILDellAdditionalResourcelinksplacing_Esupport() 
	{
		try
		{
			System.out.println("Starts TC_6706295_AMER_FF_PSILDellAdditionalResourcelinksplacing_Esupport");


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
//			
//			//obj_EsupportIPSWorkflow.clickLatitudeSubProduct(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()));
			
			obj_EsupportIPSWorkflow.SelectProductFromBrowseAll(driver);
			obj_EsupportDriverandDownloadsWorkflow.pcfClickDriversandDownloadsTab(driver);
			obj_EsupportDriverandDownloadsWorkflow.pcfVerifyAdditionalResourceHeader(driver);
			obj_EsupportDriverandDownloadsWorkflow.pcfVerifyAdditionalResourceSection(driver);
			obj_EsupportDriverandDownloadsWorkflow.pcfClickAdditionalResourceLinks(driver);
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_6706295_AMER_FF_PSILDellAdditionalResourcelinksplacing_Esupport--------->\n  "+e);
		}
	}
}





