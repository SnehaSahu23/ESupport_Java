package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_8195082_AMER_ED_IPS_LDELL_ProductionValidation_ESUPPORT extends BaseTest
{
	@Test
	public void validate_TC_8195082_AMER_ED_IPS_LDELL_ProductionValidation_ESUPPORT() 
	{
		try
		{
			System.out.println("Starts TC_8195082_AMER_ED_IPS_LDELL_ProductionValidation_ESUPPORT");

			//			 test case ID 6818358
			obj_EsupportProductionValidationsWorkflow.time(driver);
			//navigate to integrated home page
			driver.navigate().to("https://www.dell.com/support/home/us/en/19");

			//	Scenario 1: Service tag ( in warranty , having pro support type and expires in 91 days or more ) 
			obj_EsupportProductionValidationsWorkflow.searchServiceTag(driver, TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[0]);
			obj_EsupportProductionValidationsWorkflow.verifyServiceTagHeroSection(driver);
			obj_EsupportProductionValidationsWorkflow.verifyProductImageHeroSection(driver);

			//navigate to integrated home page
			driver.navigate().to("https://www.dell.com/support/home/us/en/19");

			obj_EsupportProductionValidationsWorkflow.searchServiceTag(driver, TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[0]);
			obj_EsupportProductionValidationsWorkflow.verifySystemConfigurationLink(driver);	
			obj_EsupportProductionValidationsWorkflow.clickSystemConfigurationLink(driver);	
			obj_EsupportProductionValidationsWorkflow.verifyModalPopupConfiguration(driver);	
			obj_EsupportProductionValidationsWorkflow.verifyConfigurationTable(driver);	
			obj_EsupportProductionValidationsWorkflow.verifyExportOption(driver);	
//			obj_EsupportProductionValidationsWorkflow.clickExportOption(driver);	
			obj_EsupportProductionValidationsWorkflow.clickCurrentConfigurationTab(driver);	
			obj_EsupportProductionValidationsWorkflow.verifyRunSupportAssistButton(driver);	
			obj_EsupportProductionValidationsWorkflow.clickModalPopupCloseButton(driver);	
			
			obj_EsupportProductionValidationsWorkflow.verifyDocumentationTab(driver);	
			obj_EsupportProductionValidationsWorkflow.clickDocumentationTab(driver);
			
			obj_EsupportProductionValidationsWorkflow.verifyPartsAccessoriesTab(driver);			
			obj_EsupportProductionValidationsWorkflow.clickPartsAccessoriesTab(driver);

			
			//			test case id 6881214
			//navigate to integrated home page
			driver.navigate().to("https://www.dell.com/support/home/us/en/19");
			
			obj_EsupportProductionValidationsWorkflow.searchServiceTag(driver, TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[0]);
			obj_EsupportProductionValidationsWorkflow.verifyProductHeroSectionDetails(driver);
			obj_EsupportProductionValidationsWorkflow.clickViewDetailsLink(driver);	
			obj_EsupportProductionValidationsWorkflow.verifyPrintOption(driver);

			obj_EsupportProductionValidationsWorkflow.clickWarrantyDetailsCloseButton(driver);
			obj_EsupportProductionValidationsWorkflow.clickViewDetailsLink(driver);
			obj_EsupportProductionValidationsWorkflow.verifyImportantInformation(driver);
			obj_EsupportProductionValidationsWorkflow.verifyContentLinks(driver);			
			//			obj_EsupportIPSWorkflow.clickTermsOfSaleLink(driver);
			//			driver.navigate().back();
			//			obj_EsupportIPSWorkflow.clickViewDetailsLink(driver);
			obj_EsupportProductionValidationsWorkflow.clickRegisterYourProductLink(driver);
//			driver.navigate().back();
			driver.navigate().to("https://www.dell.com/support/home/us/en/19");
			obj_EsupportProductionValidationsWorkflow.searchServiceTag(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[0]);
			obj_EsupportProductionValidationsWorkflow.clickViewDetailsLink(driver);
			obj_EsupportProductionValidationsWorkflow.clickTransferOwnershipLink(driver);	
//			driver.navigate().back();
			
//			test case id 6882064
			//navigate to integrated home page
			driver.navigate().to("https://www.dell.com/support/home/us/en/19");
			
			obj_EsupportProductionValidationsWorkflow.searchServiceTag(driver, TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[0]);
			obj_EsupportProductionValidationsWorkflow.verifyAlertOverviewTab(driver);
			obj_EsupportProductionValidationsWorkflow.clickViewDetailsLink(driver);
			obj_EsupportProductionValidationsWorkflow.clickWarrantyDetailsCloseButton(driver);
			obj_EsupportProductionValidationsWorkflow.clickExtendUpgradeLinkOverviewTab(driver);
			obj_EsupportProductionValidationsWorkflow.searchServiceTag(driver, TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[0]);
			obj_EsupportProductionValidationsWorkflow.verifyOverviewTabServiceTag(driver);
			obj_EsupportProductionValidationsWorkflow.verifyTopSolutionsServiceTag(driver);
			obj_EsupportProductionValidationsWorkflow.clickReadMoreLink(driver);
			obj_EsupportProductionValidationsWorkflow.clickViewAllLink(driver);




			//			test case id 6881325
			//navigate to integrated home page
			driver.navigate().to("https://www.dell.com/support/home/us/en/19");
			
			obj_EsupportProductionValidationsWorkflow.clickBrowseAllProductsLink(driver);
			obj_EsupportProductionValidationsWorkflow.clickLaptopsLink(driver);
			obj_EsupportProductionValidationsWorkflow.clickLatitudeLink(driver);
			obj_EsupportProductionValidationsWorkflow.clickLatitudeSeries(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[0]);
			obj_EsupportProductionValidationsWorkflow.clickLatitudeSubProduct(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[1]);
			obj_EsupportProductionValidationsWorkflow.verifyProductImageHeroSection(driver);
			obj_EsupportProductionValidationsWorkflow.verifyEnterServiceTagLink(driver);
			obj_EsupportProductionValidationsWorkflow.verifyChangeProductLink(driver);
			obj_EsupportProductionValidationsWorkflow.clickEnterServiceTagLink(driver);
			obj_EsupportProductionValidationsWorkflow.clickEnterServiceTagPopupCloseButton(driver);
			obj_EsupportProductionValidationsWorkflow.clickEnterServiceTagLink(driver);			
			obj_EsupportProductionValidationsWorkflow.enterServiceTagModalPopup(driver, TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[0]);	

//			test case id 6938038
			//navigate to integrated home page
			driver.navigate().to("https://www.dell.com/support/home/us/en/19");
			
			obj_EsupportProductionValidationsWorkflow.clickBrowseAllProductsLink(driver);
			obj_EsupportProductionValidationsWorkflow.clickSoftwareLink(driver);
			obj_EsupportProductionValidationsWorkflow.clickUtilitiesLink(driver);
//			obj_EsupportProductionValidationsWorkflow.clickLatitudeSeries(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[0]);
			obj_EsupportProductionValidationsWorkflow.clickLatitudeSubProduct(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[2]);
//			obj_EsupportIPSWorkflow.clickLatitudeSubProduct(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()));

			obj_EsupportProductionValidationsWorkflow.verifyEnterServiceTagLink(driver);
			obj_EsupportProductionValidationsWorkflow.verifyChangeProductLink(driver);
			obj_EsupportProductionValidationsWorkflow.clickEnterServiceTagLink(driver);
			obj_EsupportProductionValidationsWorkflow.clickEnterServiceTagPopupCloseButton(driver);		
			try {
				obj_EsupportProductionValidationsWorkflow.verifyTabsSupportPage(driver);
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			obj_EsupportProductionValidationsWorkflow.verifyOverviewTab(driver);
			obj_EsupportProductionValidationsWorkflow.enterServiceTagOverviewTab(driver, TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[0]);



			//			test case id 6881549
			//navigate to integrated home page
			driver.navigate().to("https://www.dell.com/support/home/us/en/19");
			
			obj_EsupportProductionValidationsWorkflow.clickBrowseAllProductsLink(driver);
			obj_EsupportProductionValidationsWorkflow.clickLaptopsLink(driver);
			obj_EsupportProductionValidationsWorkflow.clickLatitudeLink(driver);
			obj_EsupportProductionValidationsWorkflow.clickLatitudeSeries(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[0]);
			obj_EsupportProductionValidationsWorkflow.clickLatitudeSubProduct(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[1]);
//			obj_EsupportIPSWorkflow.clickLatitudeSubProduct(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()));
			obj_EsupportProductionValidationsWorkflow.verifyOverviewTabProductPage(driver);
			obj_EsupportProductionValidationsWorkflow.verifyTopSolutions(driver);
			obj_EsupportProductionValidationsWorkflow.clickViewAllLink(driver);

			
			//			test case id 8091133
			
			//navigate to integrated home page
			driver.navigate().to("https://www.dell.com/support/home/us/en/19");
			
			obj_EsupportProductionValidationsWorkflow.handleCookies(driver);
			Thread.sleep(3000);
			obj_EsupportProductionValidationsWorkflow.searchServiceTag(driver, TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[0]);
			obj_EsupportProductionValidationsWorkflow.verifyContactUsSliderLandingPage(driver);
			obj_EsupportProductionValidationsWorkflow.verifyContactUsSliderOpen(driver);
			obj_EsupportProductionValidationsWorkflow.verifyContactUsSliderContent(driver);
			obj_EsupportProductionValidationsWorkflow.clickTechnicalSupportLink(driver);
			obj_EsupportProductionValidationsWorkflow.clickOrderSupportContactUsSlider(driver);
			

			
//			test case id 6937829
			//navigate to integrated home page
			driver.navigate().to("https://www.dell.com/support/home/us/en/19");
			
			obj_EsupportProductionValidationsWorkflow.searchServiceTag(driver, TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[1]);

			obj_EsupportProductionValidationsWorkflow.verifyHeroSectionSoftwareTaggedProduct(driver);		
			obj_EsupportProductionValidationsWorkflow.clickLogintoAddNickname(driver);
			obj_EsupportProductionValidationsWorkflow.clickBrowserBackButton(driver);
			obj_EsupportProductionValidationsWorkflow.searchServiceTag(driver, TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[1]);

			obj_EsupportProductionValidationsWorkflow.clickViewDetailsLink(driver);
			obj_EsupportProductionValidationsWorkflow.verifyWarrantyDetailsModalPopup(driver);
			obj_EsupportProductionValidationsWorkflow.verifyWarrantyTable(driver);
			obj_EsupportProductionValidationsWorkflow.clickWarrantyDetailsCloseButton(driver);
			obj_EsupportProductionValidationsWorkflow.clickChangeProductLink(driver);
			obj_EsupportProductionValidationsWorkflow.searchServiceTag(driver, TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[0]);

			try {
				obj_EsupportProductionValidationsWorkflow.verifyTabsSupportPage(driver);
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			obj_EsupportProductionValidationsWorkflow.clickReadMoreLink(driver);
			obj_EsupportProductionValidationsWorkflow.clickViewAllLink(driver);
			
//			test case id 6881033
			//navigate to integrated home page
			driver.navigate().to("https://www.dell.com/support/home/us/en/19");
			
			obj_EsupportProductionValidationsWorkflow.clickSignIn(driver);
			obj_EsupportProductionValidationsWorkflow.Emaillogin(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			obj_EsupportProductionValidationsWorkflow.searchServiceTag(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[0]);
			obj_EsupportProductionValidationsWorkflow.verifyDeleteButton(driver);
			obj_EsupportProductionValidationsWorkflow.VerifyAddNewNickname(driver);
//			obj_EsupportProductionValidationsWorkflow.ClickAddNewNickname(driver);
			obj_EsupportProductionValidationsWorkflow.verifyNickname(driver);
			obj_EsupportProductionValidationsWorkflow.verifyEditDelete(driver);
			obj_EsupportProductionValidationsWorkflow.clickEdit(driver);
			obj_EsupportProductionValidationsWorkflow.addNickname(driver, TestNGCreator.TestData.get(Esupport.FirstName.ordinal()));
			obj_EsupportProductionValidationsWorkflow.verifyDeleteButton(driver);
			obj_EsupportProductionValidationsWorkflow.signOut(driver);
			
			obj_EsupportProductionValidationsWorkflow.time(driver);
//			//			test case id 6881229(added in another test case)
//			//navigate to integrated home page
//			driver.navigate().to("https://www.dell.com/support/home/us/en/19");
//			
//			obj_EsupportProductionValidationsWorkflow.searchServiceTag(driver, TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[0]);
//
//			obj_EsupportProductionValidationsWorkflow.verifyDocumentationTab(driver);	
//			obj_EsupportProductionValidationsWorkflow.clickDocumentationTab(driver);
			

			
//			test case id 6880850(repeated in other test cases)
			//navigate to integrated home page
//			driver.navigate().to("https://www.dell.com/support/home/us/en/19");
//			obj_EsupportIPSWorkflow.searchServiceTag(driver, TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[0]);
//			obj_EsupportProductionValidationsWorkflow.verifyChangeProductLink(driver);			
//			obj_EsupportProductionValidationsWorkflow.clickChangeProductLink(driver);
			
//			//			test case id 6881266 (added to other test case)
//			//navigate to integrated home page
//			driver.navigate().to("https://www.dell.com/support/home/us/en/19");
//			
//			obj_EsupportProductionValidationsWorkflow.searchServiceTag(driver, TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[0]);
//			obj_EsupportProductionValidationsWorkflow.verifyOverviewTabServiceTag(driver);
//			obj_EsupportProductionValidationsWorkflow.verifyTopSolutionsServiceTag(driver);
//			obj_EsupportProductionValidationsWorkflow.clickReadMoreLink(driver);
//			obj_EsupportProductionValidationsWorkflow.clickViewAllLink(driver);
			
//			test case id 6880823(added to other test case)
			//navigate to integrated home page
//			driver.navigate().to("https://www.dell.com/support/home/us/en/19");
//			obj_EsupportIPSWorkflow.searchServiceTag(driver, TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[0]);
//			obj_EsupportProductionValidationsWorkflow.verifyPartsAccessoriesTab(driver);			
//			obj_EsupportProductionValidationsWorkflow.clickPartsAccessoriesTab(driver);
			
////		test case id 6880930(added to other test case)
//		//navigate to integrated home page
//		driver.navigate().to("https://www.dell.com/support/home/us/en/19");
//		
//		obj_EsupportProductionValidationsWorkflow.searchServiceTag(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[0]);
//		obj_EsupportProductionValidationsWorkflow.VerifyAddNewNickname(driver);
//		obj_EsupportProductionValidationsWorkflow.ClickAddNewNickname(driver);
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_8195082_AMER_ED_IPS_LDELL_ProductionValidation_ESUPPORT--------->\n  "+e);
		}
	}
}