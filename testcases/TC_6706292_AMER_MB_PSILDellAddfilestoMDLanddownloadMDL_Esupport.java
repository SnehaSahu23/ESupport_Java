package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.MobileTestNGCreator;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_6706292_AMER_MB_PSILDellAddfilestoMDLanddownloadMDL_Esupport extends MobilePage
{
	@Test
	public void validate_TC_6706292_AMER_MB_PSILDellAddfilestoMDLanddownloadMDL_Esupport() 
	{
		try
		{
			System.out.println("Starts TC_6706292_AMER_MB_PSILDellAddfilestoMDLanddownloadMDL_Esupport");
			Thread.sleep(6000);
			obj_EsupportMobileWorkflow.handleCookies(driver);
			
			obj_EsupportMobileWorkflow.ClickExtensionsAndPinMobileView(driver);
			obj_EsupportMobileWorkflow.ClickExtensionIconAndSelectDevice(driver, "Samsung_Galaxy_S6_Portrait");
            obj_EsupportMobileWorkflow.Switch_To_Mobile_window(driver);
            Thread.sleep(6000);

            obj_EsupportMobileWorkflow.clickBrowseAllProductsLink(driver);
           
//            obj_EsupportMobileWorkflow.clickLaptopsLink(driver);
//            if(MobileTestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[0].contains("G Series"))
//			{	
//            	obj_EsupportMobileWorkflow.ClickGSeriesLink(driver);
//			}
//			else if(MobileTestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[1].contains("Latitude"))
//			{
//				obj_EsupportMobileWorkflow.clickLatitudeLink(driver);
//				obj_EsupportMobileWorkflow.clickLatitudeSeries(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[0]);
//			}
//			Thread.sleep(5000);
//			obj_EsupportMobileWorkflow.clickLatitudeSubProduct(driver, MobileTestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[1]);
			
			//obj_EsupportIPSWorkflow.clickLatitudeSubProduct(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()));
            obj_EsupportMobileWorkflow.SelectProductFromBrowseAll(driver);
            obj_EsupportMobileWorkflow.pcfClickDriversandDownloadsTab(driver);
			obj_EsupportMobileWorkflow.pcfVerifyDriversTable(driver);
			//driver.navigate().refresh();
			obj_EsupportMobileWorkflow.pcfSelectDriversFromTable(driver);
			obj_EsupportMobileWorkflow.pcfClickDownloadListToggleButton(driver);
			obj_EsupportMobileWorkflow.pcfDisplayDownloadListData(driver);
			obj_EsupportMobileWorkflow.pcfClickDownloadAllButton(driver);			
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_6706292_AMER_MB_PSILDellAddfilestoMDLanddownloadMDL_Esupport--------->\n  "+e);
		}
	}
}

