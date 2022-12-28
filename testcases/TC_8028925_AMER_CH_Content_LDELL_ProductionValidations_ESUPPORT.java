package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_8028925_AMER_CH_Content_LDELL_ProductionValidations_ESUPPORT extends BaseTest {


	@Test
	public void validate_TC_8028925_AMER_CH_Content_LDELL_ProductionValidations_ESUPPORT() 
	{
		try
		{
			System.out.println("Starts TC_8028925_AMER_CH_Content_LDELL_ProductionValidations_ESUPPORT");
			obj_EsupportProductionValidationsWorkflow.handleCookies(driver);
			//Test case ID 7039147

			obj_EsupportProductionValidationsWorkflow.ClickSearchProduct(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[0]);
			obj_EsupportProductionValidationsWorkflow.NavigateBack(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[1]);
			
			obj_EsupportProductionValidationsWorkflow.SelectServiceTagORProductFromRecentlyViewed(driver);
			obj_EsupportProductionValidationsWorkflow.ValidateTopSolutionsInOverviewTab(driver);
			obj_EsupportProductionValidationsWorkflow.ValidateTopSolutionsSection(driver);
			obj_EsupportProductionValidationsWorkflow.ClickReadMoreHyperlink(driver);
			obj_EsupportProductionValidationsWorkflow.ClickViewAll(driver);
			
			obj_EsupportProductionValidationsWorkflow.NavigateBack(driver);
			//test case ID 7062899

			obj_EsupportProductionValidationsWorkflow.ClickDocumentationTab(driver);
			obj_EsupportProductionValidationsWorkflow.DisplaySearchBox(driver);
			obj_EsupportProductionValidationsWorkflow.SearchForManuals(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()));
			obj_EsupportProductionValidationsWorkflow.ClickOnBackToDocumentationTab(driver);
			//Test case ID 7247643
			
			obj_EsupportProductionValidationsWorkflow.ValidateDetailsOnLeftRail(driver);
			
			obj_EsupportProductionValidationsWorkflow.ScrollToTopSolutions(driver);
			obj_EsupportProductionValidationsWorkflow.ValidateTopSolutionsDisplayTitleViewPageCollapseIcon(driver);
			obj_EsupportProductionValidationsWorkflow.ClickCollapseIconValidateText(driver);
			obj_EsupportProductionValidationsWorkflow.ClickCollapseIconToValidateExpandIcon(driver);
			obj_EsupportProductionValidationsWorkflow.ClickExpandIconToValidateCollapseIcon(driver);
			obj_EsupportProductionValidationsWorkflow.ClickViewPageHyperLink(driver);
			obj_EsupportProductionValidationsWorkflow.ValidateAvailableTopSolutionsCount(driver);
			obj_EsupportProductionValidationsWorkflow.ClickSeeAllButton(driver);
			obj_EsupportProductionValidationsWorkflow.ClickOnBackToDocumentationTab(driver);
			
			// Test Case ID 7030739
			obj_EsupportProductionValidationsWorkflow.ScrollToRegulatoryInformation(driver);
			
			obj_EsupportProductionValidationsWorkflow.ValidateRegulatoryInformationDisplayTitleViewPDF(driver);
			
			obj_EsupportProductionValidationsWorkflow.ClickOnLearnMore(driver);
			
			obj_EsupportProductionValidationsWorkflow.ClickViewPDFHyperLink(driver);
		
			obj_EsupportProductionValidationsWorkflow.ValidateChangeCountry(driver);
			obj_EsupportProductionValidationsWorkflow.ChangeBackToDisplayedCountry(driver);
			
			//test case ID 7030544

			obj_EsupportProductionValidationsWorkflow.ScrollToManualsAndDocuments(driver);
			
			obj_EsupportProductionValidationsWorkflow.ValidateManualsAndDocumentsDisplayTitleViewPageViewPDFCollapseIcon(driver);
			
			obj_EsupportProductionValidationsWorkflow.ClickCollapseIconValidateTextForManualsAndDocumentsArticle(driver);
			
			obj_EsupportProductionValidationsWorkflow.ClickCollapseIconToValidateExpandIconForManualsAndDocuments(driver);
			
			obj_EsupportProductionValidationsWorkflow.ClickExpandIconToValidateCollapseIconForManualAndDocuments(driver);
			
			obj_EsupportProductionValidationsWorkflow.ClickViewPageHyperLinkForManualsAndDocuments(driver);
			
			obj_EsupportProductionValidationsWorkflow.ClickViewPDFHyperLinkForManualsAndDocuments(driver);
			
			obj_EsupportProductionValidationsWorkflow.ValidateLanguageDropDownInManualsAndDocuments(driver);
			
			obj_EsupportProductionValidationsWorkflow.ValidateChangeCountry(driver);
			obj_EsupportProductionValidationsWorkflow.ChangeBackToDisplayedCountry(driver);
			
			obj_EsupportProductionValidationsWorkflow.ValidateChangingLanguageFromDropDown(driver);
			
			//test case ID 7030922

			obj_EsupportProductionValidationsWorkflow.ClickPartsAndAccessoriesTab(driver);
			
			obj_EsupportProductionValidationsWorkflow.PartsAndAccessoriesValidation(driver);
			
			obj_EsupportProductionValidationsWorkflow.ClickOnPartsAndAccessoriesUpgrades(driver);
			obj_EsupportProductionValidationsWorkflow.ClickShopAllPartsAndAccessories(driver);
			
			
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_8028925_AMER_CH_Content_LDELL_ProductionValidations_ESUPPORT--------->\n  "+e);
		}
	}
}
