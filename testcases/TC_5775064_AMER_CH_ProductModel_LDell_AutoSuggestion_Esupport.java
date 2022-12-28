package com.dell.delta_uat_automation.esupport.testcases;



import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_5775064_AMER_CH_ProductModel_LDell_AutoSuggestion_Esupport extends BaseTest 
{
	@Test
	public void validate_TC_5775064_AMER_CH_ProductModel_LDell_AutoSuggestion_Esupport() 
	{

		try
		{
			System.out.println("Starts TC_5775064_AMER_CH_ProductModel_LDell_AutoSuggestion_Esupport");
			obj_EsupportCoveoWorkflow.handleCookies(driver);
			obj_EsupportIntegratedHomePageWorkflow.SearchValues_ProductSupport_CharacterByCharacter(driver, TestNGCreator.TestData.get(Esupport.Product.ordinal()));
			obj_EsupportIntegratedHomePageWorkflow.toVerify_ProdutSupportResultPage(driver,TestNGCreator.TestData.get(Esupport.Product.ordinal())); 
		
		}
		catch(Exception e)
		{

			Assert.fail("Failed while TC_5775064_AMER_CH_ProductModel_LDell_AutoSuggestion_Esupport--------->\n  "+e);

		}

	}
}

