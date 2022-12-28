package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_6877603_AMER_FF_Contact_ConsumeRecentlyViewedProductsService_LDELL_ESUPPORT extends BaseTest 
{
	@Test
	public void validate_TC_6877603_AMER_FF_Contact_ConsumeRecentlyViewedProductsService_LDELL_ESUPPORT() 
	{

		try
		{
			System.out.println("Starts TC_6877603_AMER_FF_Contact_ConsumeRecentlyViewedProductsService_LDELL_ESUPPORT");
			//because of issue in login 0602, removing sign in part
//			obj_EsupportIncidentsWorkflow.clickOnSignInButton(driver);
//			obj_EsupportIncidentsWorkflow.ToLogin_ValidCredentials(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			obj_EsupportIncidentsWorkflow.ToVerify_EnterServiceTag_HandledPopup(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
			obj_EsupportIncidentsWorkflow.clickChangeProductLink(driver);
			
			obj_EsupportIncidentsWorkflow.RecentlyViewed(driver);
			obj_EsupportIncidentsWorkflow.ClickOnProductImageOfRecentlyViewed(driver);
			obj_EsupportIncidentsWorkflow.clickChangeProductLink(driver);
			
			obj_EsupportIncidentsWorkflow.clickBrowseAllProductsLink(driver);
			obj_EsupportIPSWorkflow.clickLaptopsLink(driver);
			obj_EsupportIPSWorkflow.clickLatitudeLink(driver);
			obj_EsupportIPSWorkflow.clickLatitudeSeries(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[0]);
			obj_EsupportIPSWorkflow.clickLatitudeSubProduct(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[1]);
			obj_EsupportIncidentsWorkflow.clickChangeProductLink(driver);
			
			obj_EsupportIncidentsWorkflow.RecentlyViewed(driver);
			obj_EsupportIncidentsWorkflow.ClickOnProductImageOfRecentlyViewed(driver);
			obj_EsupportIncidentsWorkflow.clickChangeProductLink(driver);
			
//			obj_EsupportIncidentsWorkflow.SearchForProductCodeAndSelectFromSearchDropDown(driver);
//			obj_EsupportIncidentsWorkflow.clickChangeProductLink(driver);
			
			obj_EsupportIncidentsWorkflow.RecentlyViewed(driver);
			obj_EsupportIncidentsWorkflow.ClickOnProductImageOfRecentlyViewed(driver);
			obj_EsupportIncidentsWorkflow.clickChangeProductLink(driver);
//			obj_EsupportIPSWorkflow.signOut(driver);
			
//			obj_EsupportIncidentsWorkflow.ToVerify_EnterServiceTag_HandledPopup(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
//			obj_EsupportIncidentsWorkflow.clickChangeProductLink(driver);
//			
//			obj_EsupportIncidentsWorkflow.RecentlyViewed(driver);
//			obj_EsupportIncidentsWorkflow.ClickOnProductImageOfRecentlyViewed(driver);
//			obj_EsupportIncidentsWorkflow.clickChangeProductLink(driver);
//			
//			obj_EsupportIncidentsWorkflow.clickBrowseAllProductsLink(driver);
//			obj_EsupportIPSWorkflow.clickLaptopsLink(driver);
//			obj_EsupportIPSWorkflow.clickLatitudeLink(driver);
//			obj_EsupportIPSWorkflow.clickLatitudeSeries(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[0]);
//			obj_EsupportIPSWorkflow.clickLatitudeSubProduct(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[1]);
//			obj_EsupportIncidentsWorkflow.clickChangeProductLink(driver);
//			
//			obj_EsupportIncidentsWorkflow.RecentlyViewed(driver);
//			obj_EsupportIncidentsWorkflow.ClickOnProductImageOfRecentlyViewed(driver);
//			obj_EsupportIncidentsWorkflow.clickChangeProductLink(driver);
		}
		catch(Exception e)
		{

			Assert.fail("Failed while TC_6877603_AMER_FF_Contact_ConsumeRecentlyViewedProductsService_LDELL_ESUPPORT--------->\n  "+e);

		}

	}
}
