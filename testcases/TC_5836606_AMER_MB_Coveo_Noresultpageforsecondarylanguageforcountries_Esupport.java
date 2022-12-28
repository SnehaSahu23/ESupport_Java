package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_5836606_AMER_MB_Coveo_Noresultpageforsecondarylanguageforcountries_Esupport extends MobilePage
{
	@Test
	public void validate_TC_5836606_AMER_MB_Coveo_Noresultpageforsecondarylanguageforcountries_Esupport() 
	{
		try
		{
			System.out.println("Starts TC_5836606_AMER_MB_Coveo_Noresultpageforsecondarylanguageforcountries_Esupport");
		  
		    Thread.sleep(6000);
			obj_EsupportMobileWorkflow.handleCookies(driver);
			obj_EsupportMobileWorkflow.ClickExtensionsAndPinMobileView(driver);
			obj_EsupportMobileWorkflow.ClickExtensionIconAndSelectDevice(driver, "Samsung_Galaxy_S6_Portrait");
            obj_EsupportMobileWorkflow.Switch_To_Mobile_window(driver);
            Thread.sleep(6000);
		    
            obj_EsupportMobileWorkflow.validateSupportPage(driver);
//            obj_EsupportMobileWorkflow.changeCountry_1(driver);
//			obj_EsupportCoveoWorkflow.changeCountry(driver);
            obj_EsupportMobileWorkflow.searchServiceTag(driver);
			//obj_EsupportCoveoWorkflow.handleCaptcha(driver);
		//	obj_EsupportCoveoWorkflow.handleCookies(driver);
            obj_EsupportMobileWorkflow.validateHeader(driver);
//            obj_EsupportMobileWorkflow.changeLanguage(driver);
			//obj_EsupportIncidentsWorkflow.ToVerify_EnterServiceTag(driver, TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
			
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_5836606_AMER_MB_Coveo_Noresultpageforsecondarylanguageforcountries_Esupport--------->\n  "+e);
		}
	}
}
