package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_5775226_AMER_IE_Recentlyviewed_productpages_ESUPPORT extends BaseTest {
	@Test
	public void validate_TC_5775226_AMER_IE_Recentlyviewed_productpages_ESUPPORT() 
	{

		try
		{
			System.out.println("Starts TC_5775226_AMER_IE_Recentlyviewed_productpages_ESUPPORT");


			obj_EsupportIPSWorkflow.clickBrowseAllProductsLink(driver);
			obj_EsupportIPSWorkflow.SelectProductFromBrowseAll(driver);
//			obj_EsupportIPSWorkflow.clickLaptopsLink(driver);
//			obj_EsupportIPSWorkflow.clickLatitudeLink(driver);
//			
//			obj_EsupportIPSWorkflow.clickLatitudeSeries(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[0]);
//			obj_EsupportIPSWorkflow.clickLatitudeSubProduct(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[1]);
			
			obj_EsupportIntegratedHomePageWorkflow.toNavigateToIntegratedHomePage(driver);
			obj_EsupportIPSWorkflow.clickBrowseAllProductsLink(driver);
			obj_EsupportIPSWorkflow.SelectProductFromBrowseAll(driver);
//			obj_EsupportIPSWorkflow.clickLaptopsLink(driver);
//			obj_EsupportIPSWorkflow.clickLatitudeLink(driver);
//			
//			obj_EsupportIPSWorkflow.clickLatitudeSeries(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[2]);
//			obj_EsupportIPSWorkflow.clickLatitudeSubProduct(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[3]);
//			obj_EsupportIntegratedHomePageWorkflow.ClickLaptops_Tab(driver);
//			obj_EsupportIntegratedHomePageWorkflow.ClickLattitude_Tab(driver);
//			obj_EsupportIntegratedHomePageWorkflow.ClickLaptops_Tab(driver);
//			obj_EsupportIntegratedHomePageWorkflow.ClickLattitude_Tabone(driver);
//			obj_EsupportIntegratedHomePageWorkflow.ClickLaptops_Tab(driver);
//			obj_EsupportIntegratedHomePageWorkflow.ClickLattitude_TabSecond(driver);
			obj_EsupportIntegratedHomePageWorkflow.toNavigateToIntegratedHomePage(driver);
			obj_EsupportIntegratedHomePageWorkflow.ToClick_VerifyRecentlyviewedproducts(driver);
//			obj_EsupportIntegratedHomePageWorkflow.ToVerify_ClickRighticon(driver);
//			Thread.sleep(5000);
//			obj_EsupportIntegratedHomePageWorkflow.ToVerify_ClickLefticon(driver);
			obj_EsupportIntegratedHomePageWorkflow.ToVerify_DeleteProductIcon(driver);

		}
		catch(Exception e){

			Assert.fail("Failed while executing test case TC_5775226_AMER_IE_Recentlyviewed_productpages_ESUPPORT--------->\n  "+e);

		}

	}

}
