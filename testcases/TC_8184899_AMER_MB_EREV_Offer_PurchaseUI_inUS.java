package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_8184899_AMER_MB_EREV_Offer_PurchaseUI_inUS extends BaseTest
{
	@Test
	public void validate_TC_8184899_AMER_MB_EREV_Offer_PurchaseUI_inUS() 
	{
		try
		{
			System.out.println("Starts TC_8184899_AMER_MB_EREV_Offer_PurchaseUI_inUS");
			
			Thread.sleep(6000);
			obj_EsupportMobileWorkflow.handleCookies(driver);
			
			obj_EsupportMobileWorkflow.ClickExtensionIconAndSelectDevice(driver, "Samsung_Galaxy_S6_Portrait");
            obj_EsupportMobileWorkflow.Switch_To_Mobile_window(driver);
            Thread.sleep(6000);
		
			driver.navigate().to("https://www.dell.com/support/home");
			Thread.sleep(5000);
			obj_EsupportMobileWorkflow.searchServiceTag(driver, TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
			obj_EsupportMobileWorkflow.selectIssueAndSubIssueFromDropdownOverviewTab(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[2], TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[3]);
			obj_EsupportMobileWorkflow.verifyHardwareOfferTile(driver);
			obj_EsupportMobileWorkflow.clickBuyStandardButton(driver);
			obj_EsupportMobileWorkflow.enterTextInTextboxAndClickNextButton(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[1]);
			obj_EsupportMobileWorkflow.selectCheckBoxForIAgreeHardwareOffer(driver);
			Thread.sleep(5000);
			obj_EsupportMobileWorkflow.ClickOnXMarkAtTheTopOfPopUp(driver);
			Thread.sleep(5000);
			obj_EsupportMobileWorkflow.clickResetButtonOverviewTab(driver);
			Thread.sleep(10000);
			obj_EsupportMobileWorkflow.clickBuyStandardButton(driver);
			obj_EsupportMobileWorkflow.enterTextInTextboxAndClickNextButton(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[1]);
			obj_EsupportMobileWorkflow.selectCheckBoxForIAgreeHardwareOffer(driver);
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_8184899_AMER_MB_EREV_Offer_PurchaseUI_inUS--------->\n  "+e);
		}
	}
}
