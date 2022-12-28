package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.MobileTestNGCreator;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_5836585_AMER_MB_SupportSearchIntegratedUXSearchboxImplementation_Esupport extends MobilePage
{
	@Test
	public void validate_TC_5836585_AMER_MB_SupportSearchIntegratedUXSearchboxImplementation_Esupport() 
	{

		try
		{
			System.out.println("Starts TC_5836585_AMER_MB_SupportSearchIntegratedUXSearchboxImplementation_Esupport");

			
			Thread.sleep(6000);
			obj_EsupportMobileWorkflow.handleCookies(driver);
			obj_EsupportMobileWorkflow.ClickExtensionsAndPinMobileView(driver);
			obj_EsupportMobileWorkflow.ClickExtensionIconAndSelectDevice(driver, "Samsung_Galaxy_S6_Portrait");
            obj_EsupportMobileWorkflow.Switch_To_Mobile_window(driver);
            Thread.sleep(6000);
            obj_EsupportMobileWorkflow.validateSearch(driver);
            obj_EsupportMobileWorkflow.handleSearchTextbox(driver, MobileTestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[0], "Driver ID");
//			obj_EsupportIncidentsWorkflow.ToLogin_ValidCredentials(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			Thread.sleep(5000);
//			obj_EsupportCoveoWorkflow.handleCookies(driver);
			obj_EsupportMobileWorkflow.validateSearchHeader_DriverID(driver,MobileTestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[0]);
//			driver.navigate().back();
			obj_EsupportMobileWorkflow.validateSearch(driver);
			obj_EsupportMobileWorkflow.handleSearchTextbox(driver, MobileTestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[1], "Article ID");
			Thread.sleep(5000); 
			obj_EsupportMobileWorkflow.handleCookies(driver);
			obj_EsupportMobileWorkflow.validateSearchHeader_ArticleID(driver,MobileTestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[1]);
//			driver.navigate().back();
			Thread.sleep(6000);
			obj_EsupportMobileWorkflow.validateSearch(driver);
//			Thread.sleep(6000);
			obj_EsupportMobileWorkflow.handleSearchTextbox(driver, MobileTestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[2], "Service Tag");
			Thread.sleep(5000);
			//obj_EsupportCoveoWorkflow.handleCookies(driver);
//			obj_EsupportMobileWorkflow.validateSupportHeader_ServiceTag(driver,MobileTestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[2]);

		}
		catch(Exception e){

			Assert.fail("Failed while executing test case TC_5836585_AMER_MB_SupportSearchIntegratedUXSearchboxImplementation_Esupport--------->\n  "+e);

		}

	}
}

