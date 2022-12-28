package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_5836606_AMER_CH_Coveo_Noresultpageforsecondarylanguageforcountries_Esupport extends BaseTest
{
	@Test
	public void validate_TC_5836606_AMER_CH_Coveo_Noresultpageforsecondarylanguageforcountries_Esupport() 
	{
		try
		{
			System.out.println("Starts TC_5836606_AMER_CH_Coveo_Noresultpageforsecondarylanguageforcountries_Esupport");
			obj_EsupportCoveoWorkflow.handleCookies(driver);
			obj_EsupportCoveoWorkflow.validateSupportPage(driver);
//			obj_EsupportContentWorkflow.changeCountry_1(driver);
//			obj_EsupportCoveoWorkflow.changeCountry(driver);
			obj_EsupportCoveoWorkflow.searchServiceTag(driver);
			//obj_EsupportCoveoWorkflow.handleCaptcha(driver);
		//	obj_EsupportCoveoWorkflow.handleCookies(driver);
			obj_EsupportCoveoWorkflow.validateHeader(driver);
			obj_EsupportCoveoWorkflow.changeLanguage(driver);
			//obj_EsupportIncidentsWorkflow.ToVerify_EnterServiceTag(driver, TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
			
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_5836606_AMER_CH_Coveo_Noresultpageforsecondarylanguageforcountries_Esupport--------->\n  "+e);
		}
	}
}
