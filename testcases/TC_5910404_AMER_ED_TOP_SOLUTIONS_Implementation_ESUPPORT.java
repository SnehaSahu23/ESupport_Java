
package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_5910404_AMER_ED_TOP_SOLUTIONS_Implementation_ESUPPORT extends BaseTest 
{
	@Test
	public void validate_TC_5910404_AMER_ED_TOP_SOLUTIONS_Implementation_ESUPPORT() 
	{

		try
		{
			System.out.println("Starts TC_5836926_AMER_ED_TOP_SOLUTIONS_Implementation_ESUPPORT");
			//scenario1
			obj_EsupportCoveoWorkflow.handleCookies(driver);
			obj_EsupportCoveoWorkflow.toLoad_Productselector_HomePage(driver,TestNGCreator.TestData.get(Esupport.SupportValue.ordinal()).split(";")[0],TestNGCreator.TestData.get(Esupport.Product.ordinal()).split(";")[0], TestNGCreator.TestData.get(Esupport.Product.ordinal()).split(";")[1],TestNGCreator.TestData.get(Esupport.Product.ordinal()).split(";")[2]);
			obj_EsupportCoveoWorkflow.select_product(driver, TestNGCreator.TestData.get(Esupport.SupportValue.ordinal()).split(";")[0]);
			obj_EsupportCoveoWorkflow.toLoad_SupportTopicsArticles(driver);
			obj_EsupportCoveoWorkflow.DisplayTopSolutionsLists(driver);
		
			//scenario2
			driver.get(obj_property.getProperty("cov4url"));
			obj_EsupportCoveoWorkflow.handleCookies(driver);
			obj_EsupportCoveoWorkflow.toSearch_Value_HomeSupport(driver, TestNGCreator.TestData.get(Esupport.SupportValue.ordinal()).split(";")[1]);
			obj_EsupportCoveoWorkflow.handleCookies(driver);
			obj_EsupportCoveoWorkflow.select_product(driver, TestNGCreator.TestData.get(Esupport.SupportValue.ordinal()).split(";")[1]);
			obj_EsupportCoveoWorkflow.handleCookies(driver);
			obj_EsupportCoveoWorkflow.toLoad_SupportTopicsArticles(driver);
			
			obj_EsupportCoveoWorkflow.Select_country_language(driver,TestNGCreator.TestData.get(Esupport.Country.ordinal()),"English");
			Thread.sleep(10000);
			obj_EsupportCoveoWorkflow.toLoad_SupportTopicsArticles(driver);
			obj_EsupportCoveoWorkflow.handleCookies(driver);
			obj_EsupportCoveoWorkflow.Select_country_language(driver,TestNGCreator.TestData.get(Esupport.Country.ordinal()),"Français");
			Thread.sleep(10000);
			obj_EsupportCoveoWorkflow.toLoad_SupportTopicsArticles(driver);
		}
		catch(Exception e)
		{

			Assert.fail("Failed while TC_TC_5910404_AMER_ED_TOP_SOLUTIONS_Implementation_ESUPPORT--------->\n  "+e);

		}

	}
}


