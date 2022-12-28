

package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_5776280_AMER_ED_DigitalProductsScenarios_ProductManagementpage_horizontaltabs_AdvancedView_ESUPPORT extends BaseTest
{
	@Test
	public void validate_TC_5776280_AMER_ED_DigitalProductsScenarios_ProductManagementpage_horizontaltabs_AdvancedView_ESUPPORT() 
	{

		try
		{
			System.out.println("Starts TC# _5776280_AMER_ED");

			obj_EsupportDDLWorkflow.ClickonHomePageSignInbutton(driver);
			obj_EsupportDDLWorkflow.ToLogin_ValidCredentials(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			obj_EsupportDDLWorkflow.clickDigitalProductsTab(driver);
			obj_EsupportDDLWorkflow.VerifySoftwareProductsGrid(driver);
			obj_EsupportDDLWorkflow.verifyAdvanceViewElements(driver);	
			//obj_EsupportDDLWorkflow.ToClick_Orderdetails(driver);	
			obj_EsupportDDLWorkflow.ToEnter_keywordsubmit(driver);
			obj_EsupportDDLWorkflow.ToClick_ProductNameLink(driver);
			
			obj_EsupportDDLWorkflow.ToVerify_Productsearchtabs(driver);
			obj_EsupportDDLWorkflow.TOverify_Productstablabels(driver);
			obj_EsupportDDLWorkflow.ToVerify_Avaibledownloadstab(driver);
			obj_EsupportDDLWorkflow.ToVerify_Supportlinks(driver);
			
			
			
		//Thread.sleep(500000);
			
			
		}catch(Exception e)
		{
			Assert.fail("Failed while executing test case TC_5776280_AMER_ED_DigitalProductsScenarios_ProductManagementpage_horizontaltabs_AdvancedView_ESUPPORT--------->\n  "+e);
		}
	}
}