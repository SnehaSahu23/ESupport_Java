package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_7057409_EMEA_MB_Contact_MobileTesting_SPEContactUS_OOW_SelfHelpOptions_ESUPPORT extends BaseTest
{
	@Test
	public void validate_TC_7057409_EMEA_MB_Contact_MobileTesting_SPEContactUS_OOW_SelfHelpOptions_ESUPPORT() 
	{
		try
		{
			System.out.println("Starts TC_7057409_EMEA_MB_Contact_MobileTesting_SPEContactUS_OOW_SelfHelpOptions_ESUPPORT");
				
			Thread.sleep(3000);
			
			obj_EsupportMobileWorkflow.ClickExtensionIconAndSelectDevice(driver, "Samsung_Galaxy_S6_Portrait");
            obj_EsupportMobileWorkflow.Switch_To_Mobile_window(driver);
			
            obj_EsupportIncidentsWorkflow.ToVerify_EnterServiceTag_HandledPopup(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[0]);
			obj_EsupportIncidentsWorkflow.ValidationTellusTheNatureOfTheRequestAndDropdownEnabledAfterProductIdentification(driver);
			obj_EsupportIncidentsWorkflow.SelectIssueFromDropDown(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[2]);
			
			obj_EsupportIncidentsWorkflow.ValidateSelfHelpOptionDisplayedUnderLookingToTroubleshootSection(driver);
			obj_EsupportIncidentsWorkflow.VerifyIfSelfHelpOptionIsRecommended(driver);
			
			obj_EsupportIncidentsWorkflow.VerifyOnlineSupportResourcesSelfHelpOption(driver);
			
			
			obj_EsupportIncidentsWorkflow.ClickSearchSupportLink(driver);
//			driver.navigate().back();
			
			driver.get("https://www.dell.com/support/incidents-online/en-us/contactus");
//			obj_EsupportIncidentsWorkflow.ClickOnSupportAndContactSupportAndTechnicalSupport(driver);
			obj_EsupportIncidentsWorkflow.clickChangeProductLink(driver);
			obj_EsupportIncidentsWorkflow.clickBrowseAllProductsLink(driver);
			obj_EsupportIPSWorkflow.clickLaptopsLink(driver);
			obj_EsupportIPSWorkflow.clickLatitudeLink(driver);
			obj_EsupportIPSWorkflow.clickLatitudeSeries(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[0]);
			obj_EsupportIPSWorkflow.clickLatitudeSubProduct(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[1]);
			obj_EsupportIncidentsWorkflow.SelectIssueFromDropDown(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[2]);
			
			obj_EsupportIncidentsWorkflow.ValidateSelfHelpOptionDisplayedUnderLookingToTroubleshootSection(driver);
			obj_EsupportIncidentsWorkflow.VerifyIfSelfHelpOptionIsRecommended(driver);
			
			obj_EsupportIncidentsWorkflow.VerifyOnlineSupportResourcesSelfHelpOption(driver);
			obj_EsupportIncidentsWorkflow.ClickSearchSupportLink(driver);
//			driver.navigate().back();
			
			driver.get("https://www.dell.com/support/incidents-online/en-us/contactus");
//			obj_EsupportIncidentsWorkflow.ClickOnSupportAndContactSupportAndTechnicalSupport(driver);
			obj_EsupportIncidentsWorkflow.clickChangeProductLink(driver);
			
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_7057409_EMEA_MB_Contact_MobileTesting_SPEContactUS_OOW_SelfHelpOptions_ESUPPORT--------->\n  "+e);
		}
	}
}
