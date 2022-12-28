package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.MobileTestNGCreator;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_9842589_AMER_MB_MPS_PCF_ServiceRequestsTabDownloadOptions_ESUPPORT extends MobilePage
{
	@Test
	public void validate_TC_9842589_AMER_MB_MPS_PCF_ServiceRequestsTabDownloadOptions_ESUPPORT() 
	{
		try
		{
			System.out.println("Starts TC_9842589_AMER_MB_MPS_PCF_ServiceRequestsTabDownloadOptions_ESUPPORT()");
			
			obj_EsupportMobileWorkflow.ClickExtensionsAndPinMobileView(driver);
			obj_EsupportMobileWorkflow.ClickExtensionIconAndSelectDevice(driver, "Samsung_Galaxy_S6_Portrait");
            obj_EsupportMobileWorkflow.Switch_To_Mobile_window(driver);
			
            obj_EsupportMobileWorkflow.clickSignIn(driver,MobileTestNGCreator.TestData.get(Esupport.Username.ordinal()),MobileTestNGCreator.TestData.get(Esupport.Password.ordinal()));
            obj_EsupportMobileWorkflow.clickOnServiceRequestTab(driver);
            obj_EsupportMobileWorkflow.validateDownloadButtonAboveGrid(driver);
            obj_EsupportMobileWorkflow.ClickDownloadButtonAboveGrid_Chrome_SRTab(driver);
//			obj_EsupportMobileWorkflow.deleteDownoadedFile(driver);
			
            obj_EsupportMobileWorkflow.validateFilterSection(driver,MobileTestNGCreator.TestData.get(Esupport.Dpid.ordinal()));
            obj_EsupportMobileWorkflow.ClickDownloadButtonAboveGrid_AfterFilter(driver);
			
//            obj_EsupportMobileWorkflow.deleteDownoadedFile_SRTab(driver);
			
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_9842589_AMER_MB_MPS_PCF_ServiceRequestsTabDownloadOptions_ESUPPORT()--------->\n  "+e);
		}
	}
}
