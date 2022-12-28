package com.dell.delta_uat_automation.esupport.testcases;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;
public class TC_5775823_AMER_CH_DigitalProductsScenarios_VerifyItemsperpage_Productspage_Esupport extends BaseTest
{
	@Test
	public void validate_TC_5775823_AMER_CH_DigitalProductsScenarios_VerifyItemsperpage_Productspage_Esupport() 
	{

		try
		{
			System.out.println("Starts TC# _5775823_AMER_CH");

			obj_EsupportDDLWorkflow.ClickonHomePageSignInbutton(driver);
			obj_EsupportDDLWorkflow.ToLogin_ValidCredentials(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			Thread.sleep(6000);
			obj_EsupportDDLWorkflow.ToVerify_Paginations(driver);


			obj_EsupportDDLWorkflow.ToVerify_TablesdataTen(driver,TestNGCreator.TestData.get(Esupport.ActionOption.ordinal()).split(";")[0]);
			obj_EsupportDDLWorkflow.ToVerify_TablesdataTen(driver,TestNGCreator.TestData.get(Esupport.ActionOption.ordinal()).split(";")[1]);
			obj_EsupportDDLWorkflow.ToVerify_TablesdataTen(driver,TestNGCreator.TestData.get(Esupport.ActionOption.ordinal()).split(";")[2]);
			obj_EsupportDDLWorkflow.ToVerify_TablesdataTen(driver,TestNGCreator.TestData.get(Esupport.ActionOption.ordinal()).split(";")[3]);


		}catch(Exception e)
		{
			Assert.fail("Failed while executing test case TC_5775823_AMER_CH_DigitalProductsScenarios_VerifyItemsperpage_Productspage_Esupport--------->\n  "+e);
		}
	}
}

