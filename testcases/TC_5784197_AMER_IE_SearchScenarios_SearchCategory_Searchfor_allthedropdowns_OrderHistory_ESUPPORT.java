package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_5784197_AMER_IE_SearchScenarios_SearchCategory_Searchfor_allthedropdowns_OrderHistory_ESUPPORT extends BaseTest
{	
	@Test
	public void validate_TC_5784197_AMER_IE_SearchScenarios_SearchCategory_Searchfor_allthedropdowns_OrderHistory_ESUPPORT() 
	{

		try
		{
			System.out.println("Starts TC# 5784197_AMER_IE_SearchScenarios_SearchCategory_Searchfor_allthedropdowns_OrderHistory_Esupport");

			obj_EsupportDDLWorkflow.handleCookies(driver);
			obj_EsupportDDLWorkflow.VerifySignInbutton(driver);
			obj_EsupportDDLWorkflow.ClickonHomePageSignInbutton(driver);
			obj_EsupportDDLWorkflow.validemailaddress(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()));
			obj_EsupportDDLWorkflow.validPassword(driver,TestNGCreator.TestData.get(Esupport.Password.ordinal()));

			obj_EsupportDDLWorkflow.ClickonSignInbutton(driver);
			obj_EsupportDDLWorkflow.Click_OrderHistoryTab(driver);
			obj_EsupportDDLWorkflow.SelectCriteria_Categorydropdown(driver,TestNGCreator.TestData.get(Esupport.OrderNumber.ordinal()).split(";")[0]);
			obj_EsupportDDLWorkflow.SearchBy_Value(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[0],TestNGCreator.TestData.get(Esupport.OrderNumber.ordinal()).split(";")[0]);
			obj_EsupportDDLWorkflow.SearchBy_Value(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[1],TestNGCreator.TestData.get(Esupport.OrderNumber.ordinal()).split(";")[1]);
			obj_EsupportDDLWorkflow.SearchBy_Value(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[2],TestNGCreator.TestData.get(Esupport.OrderNumber.ordinal()).split(";")[2]);

		}catch(Exception e)
		{
			Assert.fail("Failed while executing test case TC_5776403_AMER_IE_ProductManagementScenarios_ProductManagement_Getkeyusingdownload_singlefileIDasfalse_ESUPPORT--------->\n  "+e);
		}
	}
}


