package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_5836639_AMER_IE_Employee_Login_Esupport extends BaseTest {
	@Test
	public void validate_TC_5836639_AMER_IE_Employee_Login_Esupport() 
	{

		try
			{
				System.out.println("Starts TC_5836639");



				obj_EsupportCoveoWorkflow.handleCookies(driver);
//				obj_EsupportCoveoWorkflow.ClickSignIn(driver);
//			    obj_EsupportCoveoWorkflow.EmployeeLogin(driver, TestNGCreator.TestData.get(Esupport.Username.ordinal()).split(";")[0],TestNGCreator.TestData.get(Esupport.Password.ordinal()).split(";")[0]);
				obj_EsupportIncidentsWorkflow.clickSignIn(driver);
				obj_EsupportIntegratedHomePageWorkflow.Emaillogin(driver,  TestNGCreator.TestData.get(Esupport.Username.ordinal()),  TestNGCreator.TestData.get(Esupport.Password.ordinal()));
				
				
				//obj_EsupportCoveoWorkflow.handleCookies(driver);
				obj_EsupportCoveoWorkflow.Select_Search_Values(driver, TestNGCreator.TestData.get(Esupport.SupportValue.ordinal()).split(";")[0], "Support");
				obj_EsupportCoveoWorkflow.toVerify_ArticleID(driver);

				//driver.navigate().back();



	}
		catch(Exception e){

			Assert.fail("Failed while executing test case TC_5836639_AMER_IE_Employee_Login_Esupport--------->\n  "+e);

		}

	}
}



