package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_5780167_AMER_FF_FindMyDellEMCProducts_ProductSearchtab__EmployeeLogin_ESUPPORT extends BaseTest {
	@Test
	public void validate_TC_5780167_AMER_FF_FindMyDellEMCProducts_ProductSearchtab__EmployeeLogin_ESUPPORT() 
	{

		try
		{
			System.out.println("Starts TC# TC_5780167_AMER_FF_FindMyDellEMCProducts_ProductSearchtab__EmployeeLogin_ESUPPORT");
			
			
			obj_EsupportIPSWorkflow.handleCookies(driver);
			obj_EsupportIPSWorkflow.clickSignIn(driver);
			obj_EsupportIPSWorkflow.clickSignInHereLink(driver);
			Thread.sleep(10000);
			
//			obj_EsupportIPSWorkflow.employeeLogin_Firefox(driver, TestNGCreator.TestData.get(Esupport.Username.ordinal()), TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			//obj_EsupportIntegratedHomePageWorkflow.EmployeeLogin(driver, TestNGCreator.TestData.get(Esupport.Username.ordinal()).split(";")[0],TestNGCreator.TestData.get(Esupport.Password.ordinal()).split(";")[0]);
			obj_EsupportIntegratedHomePageWorkflow.ToClick_VerifyBalckCheckmarklogin(driver);
			
			obj_EsupportIntegratedHomePageWorkflow.TOclick_FindMyDellEMCProductsLink(driver);
			
			obj_EsupportIntegratedHomePageWorkflow.ToVerify_WebPartsbelowproduct(driver);
			obj_EsupportIntegratedHomePageWorkflow.ToVerify_Productfilteroptions(driver);
			
			obj_EsupportIntegratedHomePageWorkflow.TOEnter_Productnameandsearchclick(driver, TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[0]);
			obj_EsupportIntegratedHomePageWorkflow.ToVerify_WebPartsbelowproducttablesheader(driver);
			
			obj_EsupportIntegratedHomePageWorkflow.ToVerify_WebPartsbelowproducttablesheaderresultsvalues(driver);
			
			obj_EsupportIntegratedHomePageWorkflow.TOclick_Producttablesresultsresultslink(driver);
			
			obj_EsupportIntegratedHomePageWorkflow.toNavigateToIntegratedHomePage(driver);
			obj_EsupportIntegratedHomePageWorkflow.handleCookies(driver);
			obj_EsupportIntegratedHomePageWorkflow.TOclick_FindMyDellEMCProductsLink(driver);
			
			obj_EsupportIntegratedHomePageWorkflow.TOEnter_Productnameandsearchclick(driver, TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[1]);
			obj_EsupportIntegratedHomePageWorkflow.TOclick_Producttablesresultsresultslink(driver);
			obj_EsupportIntegratedHomePageWorkflow.toNavigateToIntegratedHomePage(driver);
			Thread.sleep(2000);


		}
		catch(Exception e){

			Assert.fail("Failed while executing test case TC_5780167_AMER_FF_FindMyDellEMCProducts_ProductSearchtab__EmployeeLogin_ESUPPORT--------->\n  "+e);

		}

	}

}
