package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_5836539_AMER_ED_SupportSearch_Integrated_UX_FilterFacetimplementation_Esupport extends BaseTest{
	@Test
	public void validate_TC_5836539_AMER_ED_SupportSearch_Integrated_UX_FilterFacetimplementation_Esupport() 
	{

		try
		{
			System.out.println("Starts TC_5836539_AMER_ED_SupportSearch_Integrated_UX_FilterFacetimplementation_Esupport");
			obj_EsupportCoveoWorkflow.Show_ProductCategory(driver);
			obj_EsupportCoveoWorkflow.SupportCheck(driver);
			obj_EsupportCoveoWorkflow.change_Language(driver);
			obj_EsupportCoveoWorkflow.check_dates(driver);
			driver.navigate().back();
			obj_EsupportCoveoWorkflow.ToNavigate_IntegratedSupportHomePage(driver);
			
//			obj_EsupportCoveoWorkflow.Emaillogin(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal())); 
			obj_EsupportIncidentsWorkflow.clickSignIn(driver);
			obj_EsupportIntegratedHomePageWorkflow.Emaillogin(driver,  TestNGCreator.TestData.get(Esupport.Username.ordinal()),  TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			
			
			obj_EsupportCoveoWorkflow.Show_ProductCategory(driver);
			obj_EsupportCoveoWorkflow.SupportCheck(driver);
			obj_EsupportCoveoWorkflow.change_Language(driver);
			obj_EsupportCoveoWorkflow.check_dates(driver);


		}
		catch(Exception e){

			Assert.fail("Failed while executing test case TC_5836539_AMER_ED_SupportSearch_Integrated_UX_FilterFacetimplementation_Esupport--------->\n  "+e);

		}

	}
}
