package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_5776294_AMER_ED_DigitalProductsScenariosProductManagementpageusinghorizontaltabsLogoutloginasPartner_Esupport extends BaseTest
{
	@Test
	public void validate_TC_5776294_AMER_ED_DigitalProductsScenariosProductManagementpageusinghorizontaltabsLogoutloginasPartner_Esupport() 
	{

		try
		{
			System.out.println("Starts TC# 5776294_AMER_ED_DigitalProductsScenariosProductManagementpageusinghorizontaltabsLogoutloginasPartner_Esupport");

			obj_EsupportDDLWorkflow.ClickonHomePageSignInbutton(driver);
			obj_EsupportDDLWorkflow.ToLogin_ValidCredentials(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			obj_EsupportDDLWorkflow.clickDigitalProductsTab(driver);
			obj_EsupportDDLWorkflow.VerifySoftwareProductsGrid(driver);
			obj_EsupportDDLWorkflow.verifyAdvanceViewElements(driver);	
//			obj_EsupportDDLWorkflow.ToClick_Orderdetails(driver);	
					obj_EsupportDDLWorkflow.ToEnter_keywordsubmit(driver);


					obj_EsupportDDLWorkflow.ToClick_ProductNameLink(driver);
			obj_EsupportDDLWorkflow.ToVerify_Productsearchtabs(driver);
			obj_EsupportDDLWorkflow.TOverify_Productstablabels(driver);
			obj_EsupportDDLWorkflow.ToVerify_Avaibledownloadstab(driver);
			obj_EsupportDDLWorkflow.ToVerify_Supportlinks(driver);				
		}
		catch(Exception e)
		{
			Assert.fail("Failed while executing test case 5776294_AMER_ED_DigitalProductsScenariosProductManagementpageusinghorizontaltabsLogoutloginasPartner_Esupport--------->\n  "+e);
		}
	}
}
