package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_6082233_AMER_IE_MoveGetalltextbasedkeystotopofpage_Esupport extends BaseTest
{
	@Test
	public void validate_TC_6082233_AMER_IE_MoveGetalltextbasedkeystotopofpage_Esupport() 
	{
		try
		{
			System.out.println("Starts TC_6082233_AMER_IE_MoveGetalltextbasedkeystotopofpage_Esupport");

			
			
			obj_EsupportDDLWorkflow.ClickonHomePageSignInbutton(driver);
			obj_EsupportDDLWorkflow.handleCookies(driver);
			obj_EsupportDDLWorkflow.validemailaddress(driver, TestNGCreator.TestData.get(Esupport.Username.ordinal()));
			obj_EsupportDDLWorkflow.validPassword(driver, TestNGCreator.TestData.get(Esupport.Password.ordinal()));

			obj_EsupportDDLWorkflow.ClickonSignInbutton(driver); 
			obj_EsupportDDLWorkflow.Click_OrderHistoryTab(driver);
			obj_EsupportDDLWorkflow.Enterkeyword_Keywordsearcheditbox(driver,TestNGCreator.TestData.get(Esupport.OrderNumber.ordinal()));
			obj_EsupportDDLWorkflow.ToClick_Orderdetails(driver);			
			obj_EsupportDDLWorkflow.verifyGetAllTextBasedKeys(driver);
		}
		catch(Exception e)
		{
			Assert.fail("Failed while executing test case TC_6082233_AMER_IE_MoveGetalltextbasedkeystotopofpage_Esupport--------->\n  "+e);
		}
	}
}
