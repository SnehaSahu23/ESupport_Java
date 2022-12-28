package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_8195067_AMER_ED_IntergrationHomePage_ProductionValidation_ESUPPORT extends BaseTest {
	@Test
	public void validate_TC_8195067_AMER_ED_IntergrationHomePage_ProductionValidation_ESUPPORT() 
	{

		try
		{
			System.out.println("Starts TC_8195067_AMER_ED_IntergrationHomePage_ProductionValidation_ESUPPORT");

			//			test case id 5712719
			obj_EsupportProductionValidationsWorkflow.time(driver);
			obj_EsupportProductionValidationsWorkflow.ToVerify_EnterServiceTags(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[0]);

			//			test case id 5712722
			
			//navigate to integration home page
			driver.navigate().to("https://www.dell.com/support/home/us/en/19");
	//	obj_EsupportProductionValidationsWorkflow.toLoad_Productselector_HomePage(driver, TestNGCreator.TestData.get(Esupport.SupportValue.ordinal()).split(";")[0],TestNGCreator.TestData.get(Esupport.SupportValue.ordinal()).split(";")[1],TestNGCreator.TestData.get(Esupport.Product.ordinal()).split(";")[0], TestNGCreator.TestData.get(Esupport.Product.ordinal()).split(";")[1]);
			obj_EsupportProductionValidationsWorkflow.clickBrowseAllProductsLink(driver);
			obj_EsupportProductionValidationsWorkflow.clickLaptopsLink(driver);
			obj_EsupportProductionValidationsWorkflow.clickLatitudeLink(driver);

			obj_EsupportProductionValidationsWorkflow.clickLatitudeSeries(driver,TestNGCreator.TestData.get(Esupport.SupportValue.ordinal()).split(";")[1]);
			obj_EsupportProductionValidationsWorkflow.clickLatitudeSubProduct(driver,TestNGCreator.TestData.get(Esupport.SupportValue.ordinal()).split(";")[2]);
			
			//navigate to integration home page
			driver.navigate().to("https://www.dell.com/support/home/us/en/19");

			//			test case id 5735414
			
			obj_EsupportProductionValidationsWorkflow.verifyIntegratedSupportHomePage(driver);
			
			obj_EsupportProductionValidationsWorkflow.verifyMastheadLinks(driver);
			
//			obj_EsupportProductionValidationsWorkflow.ToVerify_EnterServiceTags(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[0]);
			obj_EsupportProductionValidationsWorkflow.ToVerify_WebPartsbelowProductSelector(driver);
			obj_EsupportProductionValidationsWorkflow.ToVerify_ClickLefticonWindowsicon(driver);
			obj_EsupportProductionValidationsWorkflow.ToVerify_clickonSoftwareLicence(driver);
			driver.navigate().back();
			
			obj_EsupportProductionValidationsWorkflow.verifyWarrantyContracts(driver);
			driver.navigate().back();
			
			obj_EsupportProductionValidationsWorkflow.verifyDriversDownloads(driver);
			driver.navigate().back();

			obj_EsupportProductionValidationsWorkflow.verifyDiagnosticsTools(driver);
			obj_EsupportProductionValidationsWorkflow.toNavigateToIntegratedHomePage(driver);

			obj_EsupportProductionValidationsWorkflow.toClickDellLogo(driver);
			obj_EsupportProductionValidationsWorkflow.toNavigateToIntegratedHomePage(driver);

			obj_EsupportProductionValidationsWorkflow.clickDellTechnologies(driver);
			
			//navigate to integration home page
			driver.navigate().to("https://www.dell.com/support/home/us/en/19");

			//			test case id 5774880

			obj_EsupportProductionValidationsWorkflow.toVerifyLockIconInFindMyDellEMCProductLink(driver);
			obj_EsupportProductionValidationsWorkflow.clickOnFindMyDellEMCProductsLink(driver);

			//navigate to integration home page
			driver.navigate().to("https://www.dell.com/support/home/us/en/19");
			//			test case id 5774883

			obj_EsupportProductionValidationsWorkflow.ToVerify_EnterServiceTage(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[0]);

			//navigate to integration home page
			driver.navigate().to("https://www.dell.com/support/home/us/en/19");
			
			//			test case id 5774887
			obj_EsupportProductionValidationsWorkflow.ToVerify_EnterLEMCSerialNumber(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[1]);

			obj_EsupportProductionValidationsWorkflow.EmailloginEMCSerialnumber(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()).split(";")[0],TestNGCreator.TestData.get(Esupport.Password.ordinal()).split(";")[0]);
			obj_EsupportProductionValidationsWorkflow.TOVerify_DellEMCProductSupportPage(driver);
//			obj_EsupportProductionValidationsWorkflow.signOut(driver);

			//navigate to integration home page
			driver.navigate().to("https://www.dell.com/support/home/us/en/19");
			//			test case id 5775013
			obj_EsupportProductionValidationsWorkflow.ToVerify_EnterLEMCSerialNumber(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[3]);
//			obj_EsupportProductionValidationsWorkflow.EmailloginEMCSerialnumber(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()).split(";")[0],TestNGCreator.TestData.get(Esupport.Password.ordinal()).split(";")[0]);
			obj_EsupportProductionValidationsWorkflow.TOVerify_DellEMCProductSupportPage(driver);
			obj_EsupportProductionValidationsWorkflow.signOut(driver);

			//navigate to integration home page
			driver.navigate().to("https://www.dell.com/support/home/us/en/19");
			//			test case id 5775064
			
			obj_EsupportProductionValidationsWorkflow.SearchValues_ProductSupport_CharacterByCharacter(driver, TestNGCreator.TestData.get(Esupport.Product.ordinal()).split(";")[2]);
			obj_EsupportProductionValidationsWorkflow.toVerify_ProdutSupportResultPage(driver,TestNGCreator.TestData.get(Esupport.Product.ordinal()).split(";")[2]); 

			//navigate to integration home page
			driver.navigate().to("https://www.dell.com/support/home/us/en/19");
			//			test case id 5775092
			
			obj_EsupportProductionValidationsWorkflow.SearchValues_ProductSupport_CharacterByCharacter(driver, TestNGCreator.TestData.get(Esupport.Product.ordinal()).split(";")[4]);
			obj_EsupportProductionValidationsWorkflow.toVerify_CoveoResultPage(driver,TestNGCreator.TestData.get(Esupport.Product.ordinal()).split(";")[4]);
			
			//navigate to integration home page
			driver.navigate().to("https://www.dell.com/support/home/us/en/19");

			//			test case id 5775226
			obj_EsupportProductionValidationsWorkflow.clickBrowseAllProductsLink(driver);
			obj_EsupportProductionValidationsWorkflow.clickLaptopsLink(driver);
			obj_EsupportProductionValidationsWorkflow.clickLatitudeLink(driver);

			obj_EsupportProductionValidationsWorkflow.clickLatitudeSeries(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[0]);
			obj_EsupportProductionValidationsWorkflow.clickLatitudeSubProduct(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[1]);

			obj_EsupportProductionValidationsWorkflow.toNavigateToIntegratedHomePage(driver);
			obj_EsupportProductionValidationsWorkflow.clickBrowseAllProductsLink(driver);
			obj_EsupportProductionValidationsWorkflow.clickLaptopsLink(driver);
			obj_EsupportProductionValidationsWorkflow.clickLatitudeLink(driver);

			obj_EsupportProductionValidationsWorkflow.clickLatitudeSeries(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[2]);
			obj_EsupportProductionValidationsWorkflow.clickLatitudeSubProduct(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[3]);
			
			obj_EsupportProductionValidationsWorkflow.toNavigateToIntegratedHomePage(driver);
			obj_EsupportProductionValidationsWorkflow.ToClick_VerifyRecentlyviewedproducts(driver);
			obj_EsupportProductionValidationsWorkflow.ToVerify_ClickRighticon(driver);
			obj_EsupportProductionValidationsWorkflow.ToVerify_ClickLefticon(driver);
			obj_EsupportProductionValidationsWorkflow.ToVerify_DeleteProductIcon(driver);

			//navigate to integration home page
			driver.navigate().to("https://www.dell.com/support/home/us/en/19");
			
			//			test case id 5775324
			
			obj_EsupportProductionValidationsWorkflow.verifyQuickLinks(driver);
			obj_EsupportProductionValidationsWorkflow.ToVerify_WebPartsbelowProductSelector(driver);
			obj_EsupportProductionValidationsWorkflow.ToVerify_clickonSoftwareLicence(driver);
			driver.navigate().back();
			
			obj_EsupportProductionValidationsWorkflow.verifyWarrantyContracts(driver);
			driver.navigate().back();
			
			obj_EsupportProductionValidationsWorkflow.verifyDriversDownloads(driver);
			driver.navigate().back();
			
			obj_EsupportProductionValidationsWorkflow.verifyDiagnosticsTools(driver);

			//navigate to integration home page
			driver.navigate().to("https://www.dell.com/support/home/us/en/19");
			//			test case id 5775778


			obj_EsupportProductionValidationsWorkflow.verifyIntegratedSupportHomePage(driver);
			obj_EsupportProductionValidationsWorkflow.verifyCriticalLinks(driver);
			obj_EsupportProductionValidationsWorkflow.clickOnTechDirectLink(driver);
			//navigate to integration home page
			driver.navigate().to("https://www.dell.com/support/home/us/en/19");
		
			obj_EsupportProductionValidationsWorkflow.clickOnMS360Link(driver);

			//navigate to integration home page
			driver.navigate().to("https://www.dell.com/support/home/us/en/19");
			
			//			test case id 5775820
	
			obj_EsupportProductionValidationsWorkflow.verifyIntegratedSupportHomePage(driver);
			obj_EsupportProductionValidationsWorkflow.verifyMastheadLinks(driver);

			obj_EsupportProductionValidationsWorkflow.clickOnTechDirectLink(driver);
			obj_EsupportProductionValidationsWorkflow.toNavigateToIntegratedHomePage(driver);


			obj_EsupportProductionValidationsWorkflow.clickOnProductSupportLink(driver);
			obj_EsupportProductionValidationsWorkflow.toNavigateToIntegratedHomePage(driver);


			obj_EsupportProductionValidationsWorkflow.clickOnKnowledgdeBaseLink(driver);
			obj_EsupportProductionValidationsWorkflow.toNavigateToIntegratedHomePage(driver);


			obj_EsupportProductionValidationsWorkflow.clickOnServiceRequestsLink(driver);
			obj_EsupportProductionValidationsWorkflow.toNavigateToIntegratedHomePage(driver);


			obj_EsupportProductionValidationsWorkflow.clickOnOrderSupportLink(driver);
			obj_EsupportProductionValidationsWorkflow.toNavigateToIntegratedHomePage(driver);


			obj_EsupportProductionValidationsWorkflow.clickOnContactSupportLink(driver);
			obj_EsupportProductionValidationsWorkflow.toNavigateToIntegratedHomePage(driver);


			//navigate to integration home page
			driver.navigate().to("https://www.dell.com/support/home/us/en/19");
			
			//			test case id 5775867
			obj_EsupportProductionValidationsWorkflow.clickSignIn(driver);
			obj_EsupportProductionValidationsWorkflow.Emaillogin(driver,  TestNGCreator.TestData.get(Esupport.Username.ordinal()).split(";")[0],  TestNGCreator.TestData.get(Esupport.Password.ordinal()).split(";")[0]);

			obj_EsupportProductionValidationsWorkflow.verifyMastheadLinks(driver);
			obj_EsupportProductionValidationsWorkflow.clickOnProductSupportLink(driver);
			obj_EsupportProductionValidationsWorkflow.verifyproductsupportpageLinks(driver);

			//navigate to integration home page
			driver.navigate().to("https://www.dell.com/support/home/us/en/19");
			
			obj_EsupportProductionValidationsWorkflow.clickOnKnowledgdeBaseLink(driver);
			obj_EsupportProductionValidationsWorkflow.verifyKnowledgebasejumppage(driver);
			obj_EsupportProductionValidationsWorkflow.Select_Search_Values(driver, TestNGCreator.TestData.get(Esupport.SupportValue.ordinal()).split(";")[0], "Support");
			//navigate to integration home page
			driver.navigate().to("https://www.dell.com/support/home/us/en/19");
			
			obj_EsupportProductionValidationsWorkflow.clickOnServiceRequestsLink(driver);
			obj_EsupportProductionValidationsWorkflow.verifyServiceRequestjumppage(driver);
			//navigate to integration home page
			driver.navigate().to("https://www.dell.com/support/home/us/en/19");
			
			obj_EsupportProductionValidationsWorkflow.clickOnOrderSupportLink(driver);
			
			//navigate to integration home page
			driver.navigate().to("https://www.dell.com/support/home/us/en/19");
			//	obj_EsupportProductionValidationsWorkflow.clickOnContactSupportLink_LEMC(driver);
			obj_EsupportProductionValidationsWorkflow.ClickOnSupportAndContactSupportAndTechnicalSupport(driver);
			//	obj_EsupportProductionValidationsWorkflow.verifyContactsupportjumppageForLEMCUser(driver);
			//obj_EsupportProductionValidationsWorkflow.handleCookies(driver);
			//	obj_EsupportProductionValidationsWorkflow.toClick_FindMyDellEMCProducts(driver);
			//					obj_EsupportProductionValidationsWorkflow.toSearch_In_productSearch_FindMyDellEMCProductcontanct(driver, TestNGCreator.TestData.get(Esupport.Product.ordinal()));
			//					obj_EsupportProductionValidationsWorkflow.ToVerify_allcontactchannels(driver);
			//	obj_EsupportProductionValidationsWorkflow.ToVerify_EnterServiceTag_HandledPopup(driver, TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));

			
			//navigate to integration home page
			driver.navigate().to("https://www.dell.com/support/home/us/en/19");
//			test case id 5780144

			//					obj_EsupportProductionValidationsWorkflow.ClickSignIn(driver);
//			obj_EsupportProductionValidationsWorkflow.clickSignIn(driver);
//			obj_EsupportProductionValidationsWorkflow.Emaillogin(driver,  TestNGCreator.TestData.get(Esupport.Username.ordinal()),  TestNGCreator.TestData.get(Esupport.Password.ordinal()));


			obj_EsupportProductionValidationsWorkflow.toClick_FindMyDellEMCProducts(driver);
			obj_EsupportProductionValidationsWorkflow.toVerify_FindMyDellEMCProductsTabs(driver);
			obj_EsupportProductionValidationsWorkflow.toSearch_In_productSearch_FindMyDellEMCProduct(driver, TestNGCreator.TestData.get(Esupport.Product.ordinal()).split(";")[0]);
			//scenario2
			//					Thread.sleep(10000);
			driver.navigate().to("https://www.dell.com/support/home/us/en/19");

			obj_EsupportProductionValidationsWorkflow.toClick_FindMyDellEMCProducts(driver);
			obj_EsupportProductionValidationsWorkflow.toSearch_In_MyCustomGroups_FindMyDellEMCProduct(driver, TestNGCreator.TestData.get(Esupport.Product.ordinal()).split(";")[0],"Site Group");
			//scenario3
			driver.navigate().to("https://www.dell.com/support/home/us/en/19");

			obj_EsupportProductionValidationsWorkflow.toClick_FindMyDellEMCProducts(driver);
			obj_EsupportProductionValidationsWorkflow.clickOnAccountSitesTab(driver);
			obj_EsupportProductionValidationsWorkflow.handleSiteSearchTextbox(driver, TestNGCreator.TestData.get(Esupport.City.ordinal()));
			obj_EsupportProductionValidationsWorkflow.ToClick_AccountlistTab(driver);
			obj_EsupportProductionValidationsWorkflow.ToClick_AnyselectProduct(driver);
			obj_EsupportProductionValidationsWorkflow.TOVerify_DellEMCProductSupportPage(driver);
			
			//navigate to integration home page
			driver.navigate().to("https://www.dell.com/support/home/us/en/19");
			//			test case id 8091009
//			obj_EsupportProductionValidationsWorkflow.clickSignIn(driver);
//			obj_EsupportProductionValidationsWorkflow.Emaillogin(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			obj_EsupportProductionValidationsWorkflow.ToClick_VerifyBalckCheckmarklogin(driver);
			obj_EsupportProductionValidationsWorkflow.verifyContactUsSlider(driver);
			obj_EsupportProductionValidationsWorkflow.verifyContactUsSliderContent(driver);
			obj_EsupportProductionValidationsWorkflow.clickChatWithSupportOptionContactSlider(driver);
			obj_EsupportProductionValidationsWorkflow.clickCreateServiceRequestContactSlider(driver);

			obj_EsupportProductionValidationsWorkflow.signOut(driver);
			
			//navigate to integration home page
			driver.navigate().to("https://www.dell.com/support/home/us/en/19");
			
			//			test case id 5780116
			obj_EsupportProductionValidationsWorkflow.clickSignIn(driver);
			obj_EsupportProductionValidationsWorkflow.clickSignInHereLink(driver);
			obj_EsupportProductionValidationsWorkflow.ToVerify_blackCheckOnUsername(driver);
			obj_EsupportProductionValidationsWorkflow.toVerifyLockIconInFindMyDellEMCProductLink1(driver);
			obj_EsupportProductionValidationsWorkflow.TOVerify_FindMyDellEMCProductsLink(driver);
			obj_EsupportProductionValidationsWorkflow.EnterLEMCSerailNumberSearch(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[0]);
			//obj_EsupportProductionValidationsWorkflow.EnterLEMCServiceRequestSearch(driver, TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[1]); 


			
			//navigate to integration home page
			driver.navigate().to("https://www.dell.com/support/home/us/en/19");
			
			//			test case id 5780167
//			obj_EsupportProductionValidationsWorkflow.ClickSignIn(driver);
//			obj_EsupportProductionValidationsWorkflow.clickSignInHereLink(driver);
			//	obj_EsupportProductionValidationsWorkflow.EmployeeLogin(driver, TestNGCreator.TestData.get(Esupport.Username.ordinal()).split(";")[0],TestNGCreator.TestData.get(Esupport.Password.ordinal()).split(";")[0]);
			obj_EsupportProductionValidationsWorkflow.ToClick_VerifyBalckCheckmarklogin(driver);
			Thread.sleep(3000);
			obj_EsupportProductionValidationsWorkflow.TOclick_FindMyDellEMCProductsLink(driver);

			obj_EsupportProductionValidationsWorkflow.ToVerify_WebPartsbelowproduct(driver);
			obj_EsupportProductionValidationsWorkflow.ToVerify_Productfilteroptions(driver);

			obj_EsupportProductionValidationsWorkflow.TOEnter_Productnameandsearchclick(driver, TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[0]);
			obj_EsupportProductionValidationsWorkflow.ToVerify_WebPartsbelowproducttablesheader(driver);

			obj_EsupportProductionValidationsWorkflow.ToVerify_WebPartsbelowproducttablesheaderresultsvalues(driver);

			obj_EsupportProductionValidationsWorkflow.TOclick_Producttablesresultsresultslink(driver);

			obj_EsupportProductionValidationsWorkflow.toNavigateToIntegratedHomePage(driver);

			obj_EsupportProductionValidationsWorkflow.TOclick_FindMyDellEMCProductsLink(driver);

			obj_EsupportProductionValidationsWorkflow.TOEnter_Productnameandsearchclick(driver, TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[1]);
			obj_EsupportProductionValidationsWorkflow.TOclick_Producttablesresultsresultslink(driver);
			obj_EsupportProductionValidationsWorkflow.toNavigateToIntegratedHomePage(driver);
			
			
			
			Thread.sleep(2000);

			//navigate to integration home page
			driver.navigate().to("https://www.dell.com/support/home/us/en/19");
			
			//			test case id 5780256
//			obj_EsupportProductionValidationsWorkflow.clickSignIn(driver);
//			obj_EsupportProductionValidationsWorkflow.clickSignInHereLink(driver);
			//  obj_EsupportProductionValidationsWorkflow.EmployeeLogin(driver, TestNGCreator.TestData.get(Esupport.Username.ordinal()).split(";")[0],TestNGCreator.TestData.get(Esupport.Password.ordinal()).split(";")[0]);
			//  obj_EsupportProductionValidationsWorkflow.handleCookies(driver);
			obj_EsupportProductionValidationsWorkflow.TOclick_FindMyDellEMCProductsLink(driver);
			obj_EsupportProductionValidationsWorkflow.clickOnAccountSitesTab(driver);
			obj_EsupportProductionValidationsWorkflow.validateSearchIcon(driver);
			obj_EsupportProductionValidationsWorkflow.handleSiteSearchTextbox(driver, TestNGCreator.TestData.get(Esupport.Textarea.ordinal()));
			driver.navigate().refresh();

			obj_EsupportProductionValidationsWorkflow.TOclick_FindMyDellEMCProductsLink(driver);
			obj_EsupportProductionValidationsWorkflow.clickOnAccountSitesTab(driver);
			obj_EsupportProductionValidationsWorkflow.handleSiteSearchTextbox(driver, TestNGCreator.TestData.get(Esupport.Country.ordinal()));
			driver.navigate().refresh();
			obj_EsupportProductionValidationsWorkflow.handleCookies(driver);
			obj_EsupportProductionValidationsWorkflow.TOclick_FindMyDellEMCProductsLink(driver);
			obj_EsupportProductionValidationsWorkflow.clickOnAccountSitesTab(driver);
			obj_EsupportProductionValidationsWorkflow.handleSiteSearchTextbox(driver, TestNGCreator.TestData.get(Esupport.PostalCode.ordinal()));

			//navigate to integration home page
			driver.navigate().to("https://www.dell.com/support/home/us/en/19");
			//			test case id 5780325

			obj_EsupportProductionValidationsWorkflow.to_Scrolldownthepage(driver);
			obj_EsupportProductionValidationsWorkflow.to_CheckCountrySelector(driver);
			obj_EsupportProductionValidationsWorkflow.to_ClickCountrySelector_Arrow(driver);
			obj_EsupportProductionValidationsWorkflow.to_KeyPressing(driver);
			obj_EsupportProductionValidationsWorkflow.to_PressDownArrow(driver);
			obj_EsupportProductionValidationsWorkflow.to_PressUPArrow(driver);
			obj_EsupportProductionValidationsWorkflow.changeCountry(driver);

			//navigate to integration home page
			driver.navigate().to("https://www.dell.com/support/home/us/en/19");
			//			test case id 8090990

			Thread.sleep(3000);
			obj_EsupportProductionValidationsWorkflow.verifyContactUsSliderLandingPage(driver);
			obj_EsupportProductionValidationsWorkflow.verifyContactUsSliderOpen(driver);			
			obj_EsupportProductionValidationsWorkflow.verifyContactUsSliderContent(driver);
			obj_EsupportProductionValidationsWorkflow.clickTechnicalSupportLink(driver);
			obj_EsupportProductionValidationsWorkflow.clickOrderSupportContactUsSlider(driver);
			obj_EsupportProductionValidationsWorkflow.signOut(driver);
			
			//navigate to integration home page
			driver.navigate().to("https://www.dell.com/support/home/us/en/19");

			//			test case id 5775916
			obj_EsupportProductionValidationsWorkflow.clickSignIn(driver);
			obj_EsupportProductionValidationsWorkflow.Emaillogin(driver,  TestNGCreator.TestData.get(Esupport.Username.ordinal()).split(";")[2],  TestNGCreator.TestData.get(Esupport.Password.ordinal()).split(";")[2]);
			//					obj_EsupportProductionValidationsWorkflow.handleCookies(driver);
			obj_EsupportProductionValidationsWorkflow.verifyMastheadLinks(driver);

			obj_EsupportProductionValidationsWorkflow.clickOnProductSupportLink(driver);
			obj_EsupportProductionValidationsWorkflow.toVerifyLockIconInFindMyDellEMCProductLink(driver);
			obj_EsupportProductionValidationsWorkflow.clickOnFindMyDellEMCProducts_RequestLink(driver);
			//obj_EsupportProductionValidationsWorkflow.clickOnFindMyDellEMCProductsLink(driver);

			obj_EsupportProductionValidationsWorkflow.Click_anyproduct_underrecentviewedsection(driver);
			//					driver.navigate().back();
			obj_EsupportProductionValidationsWorkflow.ClickChangeProduct(driver);


			//					driver.navigate().back();
			obj_EsupportProductionValidationsWorkflow.clickOnKnowledgdeBaseLink(driver);
			obj_EsupportProductionValidationsWorkflow.verifyKnowledgebasejumppage(driver);
			//obj_EsupportProductionValidationsWorkflow.toVerifyLockIconInFindMyDellEMCProductLink(driver);
			//obj_EsupportProductionValidationsWorkflow.clickOnFindMyDellEMCProductsLink(driver);
			obj_EsupportProductionValidationsWorkflow.Select_Search_Values(driver, TestNGCreator.TestData.get(Esupport.SupportValue.ordinal()).split(";")[0], "Support");
			
			//navigate to integration home page
			driver.navigate().to("https://www.dell.com/support/home/us/en/19");
			
			//					driver.navigate().back();
			//					obj_EsupportProductionValidationsWorkflow.handleCookies(driver);
			//					obj_EsupportProductionValidationsWorkflow.ClickChangeProduct(driver);

			obj_EsupportProductionValidationsWorkflow.clickOnServiceRequestsLink(driver);
			obj_EsupportProductionValidationsWorkflow.verifyServiceRequestjumppage(driver);
			
			//navigate to integration home page
			driver.navigate().to("https://www.dell.com/support/home/us/en/19");

			obj_EsupportProductionValidationsWorkflow.clickOnOrderSupportLink(driver);
			
			//navigate to integration home page
			driver.navigate().to("https://www.dell.com/support/home/us/en/19");


			obj_EsupportProductionValidationsWorkflow.clickOnContactSupportLink_employee(driver);
			//	obj_EsupportProductionValidationsWorkflow.ClickOnSupportAndContactSupportAndTechnicalSupport(driver);
			obj_EsupportProductionValidationsWorkflow.verifyContactsupportjumppage(driver);
			
			obj_EsupportProductionValidationsWorkflow.signOut(driver);
			
			obj_EsupportProductionValidationsWorkflow.time(driver);
		}
		catch(Exception e){

			Assert.fail("Failed while executing test case TC_8195067_AMER_ED_IntergrationHomePage_ProductionValidation_ESUPPORT--------->\n  "+e);

		}

	}

}
