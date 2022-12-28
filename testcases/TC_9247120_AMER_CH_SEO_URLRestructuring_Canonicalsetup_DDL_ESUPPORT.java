package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_9247120_AMER_CH_SEO_URLRestructuring_Canonicalsetup_DDL_ESUPPORT extends BaseTest 
{
	@Test
	public void validate_TC_9247120_AMER_CH_SEO_URLRestructuring_Canonicalsetup_DDL_ESUPPORT() 
	{

		try
		{
			System.out.println("Starts TC_9247120_AMER_CH_SEO_URLRestructuring_Canonicalsetup_DDL_ESUPPORT");
			obj_EsupportSEOWorkflow.launchUrl(driver, TestNGCreator.TestData.get(Esupport.OrderNumber.ordinal()), TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
			obj_EsupportSEOWorkflow.validateURLForCapitalization(driver);
			obj_EsupportSEOWorkflow.validateSpecialCharsBedoreQueryString(driver);
			obj_EsupportSEOWorkflow.validateSpecialCharsInURL(driver);
			//added country change
//			obj_EsupportSEOWorkflow.changeCountry(driver);
//			obj_EsupportSEOWorkflow.ValidateURLAfterCountryChange_Japan(driver);
//			obj_EsupportSEOWorkflow.ChangeBackToDisplayedCountry(driver);
			
			obj_EsupportContentWorkflow.changeCountry_New(driver);
			obj_EsupportSEOWorkflow.ValidateURLAfterCountryChange_Japan(driver);
			obj_EsupportContentWorkflow.ChangeBackToDisplayedCountry(driver);
			
			//url for US not applicable for this test case so commenting below method
//			obj_EsupportSEOWorkflow.validateLanguageCountryInURLForUS_V1(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
			obj_EsupportSEOWorkflow.PageSourceValidations_V1(driver);
			
		}
		catch(Exception e)
		{

			Assert.fail("Failed while TC_9247120_AMER_CH_SEO_URLRestructuring_Canonicalsetup_DDL_ESUPPORT--------->\n  "+e);

		}

	}
}
