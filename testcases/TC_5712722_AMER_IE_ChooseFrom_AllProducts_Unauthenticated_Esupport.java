package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_5712722_AMER_IE_ChooseFrom_AllProducts_Unauthenticated_Esupport extends BaseTest{
	
	@Test
	public void validate_TC_5712722_AMER_IE_ChooseFrom_AllProducts_Unauthenticated_Esupport(){
		
		
		try
		{
			System.out.println("Starting 5712722_AMER_IE_ChooseFrom_AllProducts_Unauthenticated_Esupport..."); 
			
			System.out.println("Integrated HomePage.");
			obj_EsupportOrderHomeWorkflow.handleCookies(driver);
			
		//	obj_EsupportIntegratedHomePageWorkflow.toLoad_Productselector_HomePage(driver, TestNGCreator.TestData.get(Esupport.SupportValue.ordinal()).split(";")[0],TestNGCreator.TestData.get(Esupport.SupportValue.ordinal()).split(";")[1],TestNGCreator.TestData.get(Esupport.Product.ordinal()).split(";")[0], TestNGCreator.TestData.get(Esupport.Product.ordinal()).split(";")[1]);
			obj_EsupportIPSWorkflow.clickBrowseAllProductsLink(driver);
			obj_EsupportIPSWorkflow.SelectProductFromBrowseAll(driver);
//			obj_EsupportIPSWorkflow.clickLaptopsLink(driver);
//			obj_EsupportIPSWorkflow.clickLatitudeLink(driver);
//			
//			obj_EsupportIPSWorkflow.clickLatitudeSeries(driver,TestNGCreator.TestData.get(Esupport.SupportValue.ordinal()).split(";")[0]);
//			obj_EsupportIPSWorkflow.clickLatitudeSubProduct(driver,TestNGCreator.TestData.get(Esupport.SupportValue.ordinal()).split(";")[1]);ickLatitudeSubProduct(driver,TestNGCreator.TestData.get(Esupport.SupportValue.ordinal()).split(";")[1]);
			

		}catch(Exception e)
		{
			Assert.fail("Failed while executing test case TC_5712722_AMER_IE_ChooseFrom_AllProducts_Unauthenticated_Esupport--------->\n  "+e);
		}
	}

}
