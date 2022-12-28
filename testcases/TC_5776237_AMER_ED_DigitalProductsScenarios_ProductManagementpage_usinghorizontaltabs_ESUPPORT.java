package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_5776237_AMER_ED_DigitalProductsScenarios_ProductManagementpage_usinghorizontaltabs_ESUPPORT extends BaseTest 
{
	@Test
	public void validate_TC_5776237_AMER_ED_DigitalProductsScenarios_ProductManagementpage_usinghorizontaltabs_ESUPPORT() 
	{

		try
		{
			System.out.println("Starts TC_5776237_AMER_CH_DigitalProductsScenarios_ProductManagementpage_usinghorizontaltabs_ESUPPORT");
			obj_EsupportDDLWorkflow.ClickonHomePageSignInbutton(driver);
			obj_EsupportDDLWorkflow.ToLogin_ValidCredentials(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			obj_EsupportDDLWorkflow.clickDigitalProductsTab(driver);

			obj_EsupportDDLWorkflow.VerifySoftwareProductsGrid(driver);
			obj_EsupportDDLWorkflow.verifySimpleViewElements(driver);
			obj_EsupportDDLWorkflow.clickOnSwitchToAdvanceView(driver);
			obj_EsupportDDLWorkflow.ToSelectrow_Products(driver);
			
			obj_EsupportDDLWorkflow.ToEnter_keywordsubmit(driver);
			obj_EsupportDDLWorkflow.ToClick_ProductNameLink(driver);
			obj_EsupportDDLWorkflow.ToVerify_Productsearchtabs(driver);			
			obj_EsupportDDLWorkflow.ToVerify_Avaibledownloadstab(driver);
			obj_EsupportDDLWorkflow.ToVerify_Supportlinks(driver);
			
			
			
		}
		catch(Exception e)
		{

			Assert.fail("Failed while TC_5776237_AMER_ED_DigitalProductsScenarios_ProductManagementpage_usinghorizontaltabs_ESUPPORT--------->\n  "+e);

		}

	}
}