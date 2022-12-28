package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_8594430_AMER_CH_UnifiedProfile_CustomGroups_ProductionAutomation extends BaseTest
{
	@Test
	public void validate_TC_8594430_AMER_CH_UnifiedProfile_CustomGroups_ProductionAutomation()
	{
		try
		{
			System.out.println("Starts TC_8594430_AMER_CH_UnifiedProfile_CustomGroups_ProductionAutomation");
			
			Thread.sleep(10000);	
			obj_EsupportProductionValidationsWorkflow.handleCookies(driver);
			obj_EsupportProductionValidationsWorkflow.Emaillogin(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			Thread.sleep(5000);	
			
			
			//Starts TC_7035662_AMER_CH_UNI_CustomGroupCreationforCPusingAccountSitesSiteGroup");
			Thread.sleep(10000);	
			obj_EsupportProductionValidationsWorkflow.handleCookies(driver);
			obj_EsupportProductionValidationsWorkflow.Emaillogin(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			Thread.sleep(5000);	
			obj_EsupportProductionValidationsWorkflow.clickCustomGroups(driver);
			Thread.sleep(5000);	
			obj_EsupportProductionValidationsWorkflow.createProductGroup(driver);
			Thread.sleep(10000);	
			obj_EsupportProductionValidationsWorkflow.enterProductGroupDetails(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[0],TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[1],TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[2]);
			Thread.sleep(10000);
			
			obj_EsupportProductionValidationsWorkflow.verifyAccountSitesCount(driver);
			
			obj_EsupportProductionValidationsWorkflow.searchAccountSitesAndClickFilterButton(driver, TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
			Thread.sleep(10000);	
			obj_EsupportProductionValidationsWorkflow.selectSiteAndAddToGroup(driver);
			
			System.out.println("Starts TC_7035667_AMER_CH_UNI_CustomGroupsCreationusingProductIDforCPUsers");
			Thread.sleep(10000);	
			obj_EsupportProductionValidationsWorkflow.handleCookies(driver);
			obj_EsupportProductionValidationsWorkflow.Emaillogin(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			Thread.sleep(5000);	
			obj_EsupportProductionValidationsWorkflow.clickCustomGroups(driver);
			Thread.sleep(5000);	
			obj_EsupportProductionValidationsWorkflow.createProductGroup(driver);
			Thread.sleep(10000);	
			obj_EsupportProductionValidationsWorkflow.verifyCreateProductGroupFields(driver);
			Thread.sleep(5000);	
			obj_EsupportProductionValidationsWorkflow.enterProductGroupDetails(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[0],TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[1],TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[2]);
			Thread.sleep(10000);	
			obj_EsupportProductionValidationsWorkflow.searchProductId(driver, TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
			Thread.sleep(10000);	
			obj_EsupportProductionValidationsWorkflow.verifyRemoveFromGroup(driver);
			Thread.sleep(5000);	
			obj_EsupportProductionValidationsWorkflow.clickCreateCustomGroupButton(driver);
			
			
			//Starts TC_7035996_AMER_CH_UNI_CustomGroupsCreationCountforNoOfSites - covered in previous steps
//			Thread.sleep(10000);	
//			obj_EsupportProductionValidationsWorkflow.handleCookies(driver);
//			obj_EsupportProductionValidationsWorkflow.Emaillogin(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
//			Thread.sleep(5000);	
//		//	driver.navigate().refresh();
//			obj_EsupportProductionValidationsWorkflow.clickCustomGroups(driver);
//			Thread.sleep(5000);	
//			obj_EsupportProductionValidationsWorkflow.createProductGroup(driver);
//			Thread.sleep(10000);	
//			obj_EsupportProductionValidationsWorkflow.enterProductGroupDetails(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[0],TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[1],TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[2]);
//			Thread.sleep(10000);	
//			obj_EsupportProductionValidationsWorkflow.verifyAccountSitesCount(driver);
			
			//Starts TC_7036023_AMER_CH_UNI_CreateCustomGroupVerifyNameDescriptionFindProductsbyFieldsareMandatory
//			Thread.sleep(10000);	
//			obj_EsupportProductionValidationsWorkflow.handleCookies(driver);
//			obj_EsupportProductionValidationsWorkflow.Emaillogin(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
//			Thread.sleep(5000);	
//			obj_EsupportProductionValidationsWorkflow.clickCustomGroups(driver);
//			Thread.sleep(5000);	
//			obj_EsupportProductionValidationsWorkflow.createProductGroup(driver);
//			Thread.sleep(10000);	
//			obj_EsupportUnifiedPortalWorkflow.verifyCreateProductGroupFields(driver);
			
			//Starts TC_7036113_AMER_CH_UNI_CreateCustomGroupRemoveProductSitefromGroup - covered in previous steps
//			Thread.sleep(10000);	
//			obj_EsupportProductionValidationsWorkflow.handleCookies(driver);
//			obj_EsupportProductionValidationsWorkflow.Emaillogin(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
//			Thread.sleep(5000);	
//			obj_EsupportProductionValidationsWorkflow.clickCustomGroups(driver);
//			Thread.sleep(5000);	
//			obj_EsupportProductionValidationsWorkflow.createProductGroup(driver);
//			Thread.sleep(10000);	
//			obj_EsupportProductionValidationsWorkflow.enterProductGroupDetails(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[0],TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[1],TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[2]);
//			obj_EsupportProductionValidationsWorkflow.searchProductId(driver, TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
//			Thread.sleep(10000);	
//			obj_EsupportProductionValidationsWorkflow.verifyRemoveFromGroup(driver);
			
			System.out.println("Starts TC_7036188_AMER_CH_UNI_CreateCustomGroupAccountsettingsClearSearchtext");
			Thread.sleep(10000);	
			obj_EsupportProductionValidationsWorkflow.handleCookies(driver);
			obj_EsupportProductionValidationsWorkflow.Emaillogin(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			Thread.sleep(5000);	
			obj_EsupportProductionValidationsWorkflow.clickCustomGroups(driver);
			Thread.sleep(5000);	
			obj_EsupportProductionValidationsWorkflow.createProductGroup(driver);
			Thread.sleep(10000);	
			obj_EsupportProductionValidationsWorkflow.enterProductGroupDetails(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[0],TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[1],TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[2]);
			obj_EsupportProductionValidationsWorkflow.searchAccountSites(driver, TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()) );
			
			System.out.println("Starts TC_7036709_AMER_CH_UnifiedPortal_CustomGroupCreationforCPusingProductGroups");
			Thread.sleep(10000);	
			obj_EsupportProductionValidationsWorkflow.handleCookies(driver);
			obj_EsupportProductionValidationsWorkflow.Emaillogin(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			Thread.sleep(5000);	
			obj_EsupportProductionValidationsWorkflow.clickCustomGroups(driver);
			Thread.sleep(5000);	
			obj_EsupportProductionValidationsWorkflow.createProductGroup(driver);
			Thread.sleep(10000);	
			obj_EsupportProductionValidationsWorkflow.enterProductGroupDetails(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[0],TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[1],TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[2]);
			Thread.sleep(10000);	
			obj_EsupportProductionValidationsWorkflow.searchAccountSitesAndClickFilterButton(driver, TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
			Thread.sleep(10000);	
			obj_EsupportProductionValidationsWorkflow.selectProductAndAddToGroup(driver);
			
			System.out.println("Starts TC_7037106_AMER_CH_UnifiedPortal_CustomGroupsCreationMyProductGroupsCount");
			Thread.sleep(10000);	
			obj_EsupportProductionValidationsWorkflow.handleCookies(driver);
			obj_EsupportProductionValidationsWorkflow.Emaillogin(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			Thread.sleep(5000);	
			obj_EsupportProductionValidationsWorkflow.clickCustomGroups(driver);
			Thread.sleep(5000);	
			obj_EsupportProductionValidationsWorkflow.createProductGroup(driver);
			Thread.sleep(10000);	
			obj_EsupportProductionValidationsWorkflow.enterProductGroupDetails(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[0],TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[1],TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[2]);
			Thread.sleep(10000);	
			obj_EsupportProductionValidationsWorkflow.verifyProductsCount(driver);
			
			System.out.println("Starts TC_7037145_AMER_CH_UNI_CustomGroupCreationbyusingAccountSitesCPUsersProductGroup");
			Thread.sleep(10000);	
			obj_EsupportProductionValidationsWorkflow.handleCookies(driver);
			obj_EsupportIPSWorkflow.Emaillogin(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			Thread.sleep(5000);	
			obj_EsupportProductionValidationsWorkflow.clickCustomGroups(driver);
			Thread.sleep(5000);	
			obj_EsupportProductionValidationsWorkflow.createProductGroup(driver);
			Thread.sleep(10000);	
			obj_EsupportProductionValidationsWorkflow.enterProductGroupDetails(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[0],TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[1],TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[2]);
			Thread.sleep(10000);	
			obj_EsupportProductionValidationsWorkflow.searchAccountSitesAndClickFilterButton(driver, TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
			Thread.sleep(10000);
			obj_EsupportProductionValidationsWorkflow.verifyAddToGroupButtonEnabled(driver);
			obj_EsupportProductionValidationsWorkflow.clickAddToGroupButtonVerifySecondGrid(driver);
			obj_EsupportProductionValidationsWorkflow.clickCreateCustomGroupButton(driver);
			
			System.out.println("Starts TC_7042335_AMER_CH_UNI_CreateCustomGroupforEmployeeusingSiteID");
			Thread.sleep(10000);
			obj_EsupportProductionValidationsWorkflow.clickSignInHereLink(driver);
			obj_EsupportProductionValidationsWorkflow.handleCookies(driver);
			obj_EsupportProductionValidationsWorkflow.clickCustomGroups(driver);
			Thread.sleep(5000);	
			obj_EsupportProductionValidationsWorkflow.createProductGroup(driver);
			Thread.sleep(10000);	
			obj_EsupportProductionValidationsWorkflow.enterProductGroupDetails(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[0],TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[1],TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[2]);
			Thread.sleep(10000);	
			obj_EsupportProductionValidationsWorkflow.searchSiteId(driver, TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
			Thread.sleep(10000);	
			
			System.out.println("Starts TC_7064496_AMER_CH_UNI_Verifyingfields_on_SiteGroupdetailspage");
			Thread.sleep(10000);
			obj_EsupportProductionValidationsWorkflow.clickSignInHereLink(driver);
			obj_EsupportProductionValidationsWorkflow.handleCookies(driver);
			obj_EsupportProductionValidationsWorkflow.clickCustomGroups(driver);
			Thread.sleep(5000);	
			obj_EsupportProductionValidationsWorkflow.filterCustomGroups(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()));
			Thread.sleep(10000);
			obj_EsupportProductionValidationsWorkflow.clickSiteCustomGroupName(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()));
			Thread.sleep(5000);
			obj_EsupportProductionValidationsWorkflow.verifyEditCustomGroupButton(driver);
			obj_EsupportProductionValidationsWorkflow.verifySiteCustomGroupColumns(driver);
			obj_EsupportProductionValidationsWorkflow.verifyMyCustomGroupsDownloadButton(driver);
			obj_EsupportProductionValidationsWorkflow.verifySearchTextBoxSiteGroup(driver);
			Thread.sleep(5000);
			//obj_EsupportProductionValidationsWorkflow.verifyActionsButtonOptions(driver);
			Thread.sleep(5000);
		//	driver.navigate().refresh();
			Thread.sleep(5000);
			obj_EsupportProductionValidationsWorkflow.verifyDeletePopupSiteCustomGroup(driver);
			Thread.sleep(3000);
			obj_EsupportProductionValidationsWorkflow.verifyPaginationTextSiteCustomGroup(driver);
			
			System.out.println("Starts TC_7064680_AMER_CH_UNI_ShowproductsfunctionalityinSiteGroupsCustomerPartnerUser");
			Thread.sleep(10000);	
			obj_EsupportProductionValidationsWorkflow.handleCookies(driver);
			obj_EsupportIPSWorkflow.Emaillogin(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			Thread.sleep(5000);	
			obj_EsupportProductionValidationsWorkflow.clickCustomGroups(driver);
			Thread.sleep(5000);	
			obj_EsupportProductionValidationsWorkflow.createSiteGroup(driver);
			Thread.sleep(10000);	
			obj_EsupportProductionValidationsWorkflow.enterSiteGroupDetails(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[0],TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[1],TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[2]);
			Thread.sleep(10000);	
			obj_EsupportProductionValidationsWorkflow.searchSiteIdInCreateSiteGroupAndClickFilterButton(driver, TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
			Thread.sleep(10000);
			obj_EsupportProductionValidationsWorkflow.verifyShowProductsLink(driver);
			Thread.sleep(5000);
			obj_EsupportProductionValidationsWorkflow.verifySiteGridDetails(driver);
			
			System.out.println("Starts TC_7064735_AMER_CH_UNI_RemoveDeleteCustomGroupsUI");
			Thread.sleep(10000);	
			obj_EsupportProductionValidationsWorkflow.handleCookies(driver);
			obj_EsupportIPSWorkflow.Emaillogin(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			Thread.sleep(5000);	
			obj_EsupportProductionValidationsWorkflow.clickCustomGroups(driver);
			Thread.sleep(5000);	
			obj_EsupportProductionValidationsWorkflow.searchCustomGroup(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()));
			
			obj_EsupportProductionValidationsWorkflow.clickDeleteCustomGroup(driver);
			obj_EsupportProductionValidationsWorkflow.clickCustomGroupPopupConfirmButton(driver);
			Thread.sleep(10000);
			obj_EsupportProductionValidationsWorkflow.clickDeleteCustomGroup(driver);
			obj_EsupportProductionValidationsWorkflow.clickCustomGroupPopupCancelButton(driver);
			
			System.out.println("Starts TC_7064847_AMER_CH_UNI_ItemsAssociatedinCustomgroupslandingpage");
			Thread.sleep(10000);	
			obj_EsupportProductionValidationsWorkflow.handleCookies(driver);
			obj_EsupportIPSWorkflow.Emaillogin(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			Thread.sleep(5000);	
			obj_EsupportProductionValidationsWorkflow.clickCustomGroups(driver);
			Thread.sleep(5000);	
			obj_EsupportProductionValidationsWorkflow.clickAnyItemLinkCustomGroup(driver);
			obj_EsupportProductionValidationsWorkflow.clickItemLinkSitesCustomGroup(driver);
			obj_EsupportProductionValidationsWorkflow.clickItemsPopupCloseButton(driver);
			obj_EsupportProductionValidationsWorkflow.clickItemLinkProductsCustomGroup(driver);
			
			System.out.println("Starts TC_7066310_AMER_CH_UNI_CustomgroupsViewpage");
			Thread.sleep(10000);	
			obj_EsupportProductionValidationsWorkflow.handleCookies(driver);
			obj_EsupportIPSWorkflow.Emaillogin(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			Thread.sleep(5000);	
			obj_EsupportProductionValidationsWorkflow.clickCustomGroups(driver);
			Thread.sleep(5000);	
			obj_EsupportProductionValidationsWorkflow.verifyMyCustomGroupsColumns(driver);
			Thread.sleep(10000);	
			obj_EsupportProductionValidationsWorkflow.filterCustomGroups(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()));
			Thread.sleep(10000);
			obj_EsupportProductionValidationsWorkflow.clickMyCustomGroupsClearButton(driver);
			obj_EsupportProductionValidationsWorkflow.verifyMyCustomGroupsDownloadButton(driver);
			obj_EsupportProductionValidationsWorkflow.verifySortingOptionColumns(driver);
			obj_EsupportProductionValidationsWorkflow.verifyDeleteCustomGroupOption(driver);
			obj_EsupportProductionValidationsWorkflow.verifyPaginationServiceRequestEvents(driver);
			
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_8594430_AMER_CH_UnifiedProfile_CustomGroups_ProductionAutomation--------->\n  "+e);
		}
	}
}