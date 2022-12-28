package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_9256870_AMER_CH_SEO_URLRestructuring_Canonicalsetup_CoveoSearch_ESUPPORT extends BaseTest 
{
	@Test
	public void validate_TC_9256870_AMER_CH_SEO_URLRestructuring_Canonicalsetup_CoveoSearch_ESUPPORT() 
	{

		try
		{
			System.out.println("Starts TC_9256870_AMER_CH_SEO_URLRestructuring_Canonicalsetup_CoveoSearch_ESUPPORT");
			obj_EsupportSEOWorkflow.launchUrl(driver, TestNGCreator.TestData.get(Esupport.OrderNumber.ordinal()), TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
			obj_EsupportSEOWorkflow.validateURLForCapitalization(driver);
			obj_EsupportSEOWorkflow.validateSpecialCharsBedoreQueryString(driver);
			obj_EsupportSEOWorkflow.validateSpecialCharsInURL(driver);
			obj_EsupportSEOWorkflow.validateLanguageCountryInURLForUS_V1(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
			Thread.sleep(6000);
			obj_EsupportSEOWorkflow.PageSourceValidations_V1(driver);
			
		}
		catch(Exception e)
		{

			Assert.fail("Failed while TC_9256870_AMER_CH_SEO_URLRestructuring_Canonicalsetup_CoveoSearch_ESUPPORT--------->\n  "+e);

		}

	}
}
