package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_8004020_AMER_ED_Drivers_LDELL_SmokeTesting extends BaseTest
{
	@Test
	public void validate_TC_8004020_AMER_ED_Drivers_LDELL_SmokeTesting() 
	{
		try
		{
			System.out.println("Starts TC_8004020_AMER_ED_Drivers_LDELL_SmokeTesting");


			obj_EsupportIPSWorkflow.clickBrowseAllProductsLink(driver);
			obj_EsupportIPSWorkflow.clickLaptopsLink(driver);
			obj_EsupportIPSWorkflow.clickLatitudeLink(driver);
			
			obj_EsupportIPSWorkflow.clickLatitudeSeries(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[0]);
			Thread.sleep(5000);
			//obj_EsupportIPSWorkflow.clickLatitudeSubProduct(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[1]);
			
			//obj_EsupportIPSWorkflow.clickLatitudeSubProduct(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()));
			obj_EsupportDriverandDownloadsWorkflow.pcfClickDriversandDownloadsTab(driver);
		
			obj_EsupportDriverandDownloadsWorkflow.pcfVerifyDetectDriversButton(driver);
			obj_EsupportDriverandDownloadsWorkflow.pcfVerifyFilterSection(driver);
			obj_EsupportDriverandDownloadsWorkflow.pcfVerifyDriverListSection(driver);
			obj_EsupportDriverandDownloadsWorkflow.pcfVerifySortOptionDriverList(driver);
			obj_EsupportDriverandDownloadsWorkflow.pcfVerifyAdditionalResourceHeader(driver);
			obj_EsupportDriverandDownloadsWorkflow.pcfVerifyAdditionalResourceSection(driver);
			obj_EsupportDriverandDownloadsWorkflow.pcfVerifyDriversTable(driver);
			//driver.navigate().refresh();
			obj_EsupportDriverandDownloadsWorkflow.pcfSelectDriversFromTable(driver);
			obj_EsupportDriverandDownloadsWorkflow.pcfClickDownloadListToggleButton(driver);
			obj_EsupportDriverandDownloadsWorkflow.pcfDisplayDownloadListData(driver);
			obj_EsupportDriverandDownloadsWorkflow.pcfClickDownloadAllButton(driver);		
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_8004020_AMER_ED_Drivers_LDELL_SmokeTesting--------->\n  "+e);
		}
	}
}
