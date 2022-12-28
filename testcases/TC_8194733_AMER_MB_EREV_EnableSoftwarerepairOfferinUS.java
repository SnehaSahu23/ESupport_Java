package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_8194733_AMER_MB_EREV_EnableSoftwarerepairOfferinUS extends BaseTest
{
	@Test
	public void validate_TC_8194733_AMER_MB_EREV_EnableSoftwarerepairOfferinUS() 
	{
		try
		{
			System.out.println("Starts TC_8194733_AMER_MB_EREV_EnableSoftwarerepairOfferinUS");
			Thread.sleep(6000);
			obj_EsupportMobileWorkflow.handleCookies(driver);
			
			obj_EsupportMobileWorkflow.ClickExtensionIconAndSelectDevice(driver, "Samsung_Galaxy_S6_Portrait");
            obj_EsupportMobileWorkflow.Switch_To_Mobile_window(driver);
            Thread.sleep(6000);
			
//            obj_EsupportMobileWorkflow.verifySoftwareSupportOfferInContactTechnicalSupport(driver);
            obj_EsupportMobileWorkflow.verifyContactSupportInMenu(driver);
            obj_EsupportMobileWorkflow.ClickOnContactSupportInMenu(driver);
            
			Thread.sleep(5000);
			driver.navigate().to("https://www.dell.com/support/home");
			Thread.sleep(5000);
			obj_EsupportMobileWorkflow.searchServiceTag(driver, TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
			obj_EsupportMobileWorkflow.selectIssueAndSubIssueFromDropdownOverviewTab(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[1], TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[2]);
			obj_EsupportMobileWorkflow.clickOnBuySoftwareSupport(driver);
			obj_EsupportMobileWorkflow.selectPaymentMethodAndClickNextButton(driver);
			Thread.sleep(5000);
			obj_EsupportMobileWorkflow.ClickOnXMarkAtTheTopOfPopUp(driver);
			obj_EsupportMobileWorkflow.clickResetButtonOverviewTab(driver);
			Thread.sleep(5000);
			obj_EsupportMobileWorkflow.clickOnBuySoftwareSupport(driver);
			obj_EsupportMobileWorkflow.selectPaymentMethodAndClickNextButton(driver);
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_8194733_AMER_MB_EREV_EnableSoftwarerepairOfferinUS--------->\n  "+e);
		}
	}
}
