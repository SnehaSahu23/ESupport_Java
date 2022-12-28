package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.MobileTestNGCreator;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_5837117_AMER_MB_MastHead_SearchOptions_ESUPPORT extends MobilePage
{
	@Test
	public void validate_TC_5837117_AMER_MB_MastHead_SearchOptions_ESUPPORT() 
	{

		try
		{
			System.out.println("Starts TC_5837117_AMER_MB_MastHead_SearchOptions_ESUPPORT");
			
			Thread.sleep(6000);
			obj_EsupportMobileWorkflow.handleCookies(driver);
			
			obj_EsupportMobileWorkflow.ClickExtensionsAndPinMobileView(driver);
			obj_EsupportMobileWorkflow.ClickExtensionIconAndSelectDevice(driver, "Samsung_Galaxy_S6_Portrait");
            obj_EsupportMobileWorkflow.Switch_To_Mobile_window(driver);
            Thread.sleep(6000);
			
            obj_EsupportMobileWorkflow.toVerify_MastHead_Search(driver);
//			obj_EsupportCoveoWorkflow.toVerify_DomainSelector_Dropdown(driver);
//			obj_EsupportCoveoWorkflow.toVerify_Support_Dropdown(driver);
            obj_EsupportMobileWorkflow.Select_Search_Values(driver, MobileTestNGCreator.TestData.get(Esupport.SupportValue.ordinal()).split(";")[0], "Support");
			driver.navigate().back();
			obj_EsupportMobileWorkflow.Select_Search_Values(driver, MobileTestNGCreator.TestData.get(Esupport.DellcomValue.ordinal()).split(";")[0], "All Dell.com");
			driver.navigate().back();
//			Thread.sleep(10000);
//			obj_EsupportCoveoWorkflow.selectSupportfromDropdown(driver,  "Support");
//			obj_EsupportCoveoWorkflow.clickLatitudeSuggestionsSupportPage(driver,TestNGCreator.TestData.get(Esupport.SupportValue.ordinal()).split(";")[1]);
			obj_EsupportMobileWorkflow.SearchLatiInMastHeadAndSearchAutoDisplayedResults(driver);
			
			
		}
		catch(Exception e)
		{

			Assert.fail("Failed while TC_5837117_AMER_MB_MastHead_SearchOptions_ESUPPORT--------->\n  "+e);

		}

	}
}
