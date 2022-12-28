package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_5836539_AMER_MB_SupportSearch_Integrated_UX_FilterFacetimplementation_Esupport extends MobilePage{
	@Test
	public void validate_TC_5836539_AMER_MB_SupportSearch_Integrated_UX_FilterFacetimplementation_Esupport() 
	{

		try
		{
			System.out.println("Starts TC_5836539_AMER_MB_SupportSearch_Integrated_UX_FilterFacetimplementation_Esupport");
			
			Thread.sleep(6000);
			obj_EsupportMobileWorkflow.handleCookies(driver);
			
			obj_EsupportMobileWorkflow.ClickExtensionIconAndSelectDevice(driver, "Samsung_Galaxy_S6_Portrait");
            obj_EsupportMobileWorkflow.Switch_To_Mobile_window(driver);
            Thread.sleep(6000);
            
            obj_EsupportMobileWorkflow.Show_ProductCategory(driver);
            obj_EsupportMobileWorkflow.SupportCheck(driver);
            obj_EsupportMobileWorkflow.change_Language(driver);
            obj_EsupportMobileWorkflow.check_dates(driver);

			
            obj_EsupportMobileWorkflow.ToNavigate_IntegratedSupportHomePage(driver);
			
//			obj_EsupportCoveoWorkflow.Emaillogin(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal())); 
            obj_EsupportMobileWorkflow.clickSignIn(driver);
            obj_EsupportMobileWorkflow.Emaillogin(driver,  TestNGCreator.TestData.get(Esupport.Username.ordinal()),  TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			
            obj_EsupportMobileWorkflow.Show_ProductCategory(driver);
            obj_EsupportMobileWorkflow.SupportCheck(driver);
            obj_EsupportMobileWorkflow.change_Language(driver);
            obj_EsupportMobileWorkflow.check_dates(driver);


		}
		catch(Exception e){

			Assert.fail("Failed while executing test case TC_5836539_AMER_MB_SupportSearch_Integrated_UX_FilterFacetimplementation_Esupport--------->\n  "+e);

		}

	}
}
