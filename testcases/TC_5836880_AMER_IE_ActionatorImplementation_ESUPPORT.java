
package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_5836880_AMER_IE_ActionatorImplementation_ESUPPORT extends BaseTest 
{
	@Test
	public void validate_TC_5836880_AMER_IE_ActionatorImplementation_ESUPPORT() 
	{

		try
		{
			//scenario1
            System.out.println("Starts TC_5836880_AMER_IE_ActionatorImplementation_ESUPPORT");
            obj_EsupportCoveoWorkflow.handleCookies(driver);
			obj_EsupportCoveoWorkflow.Select_Search_Values(driver, TestNGCreator.TestData.get(Esupport.SupportValue.ordinal()).split(";")[0], "Support");
			Thread.sleep(30000);
			//            obj_EsupportCoveoWorkflow.handleCaptcha(driver);
			//            Thread.sleep(30000);
			//            Thread.sleep(30000);
			//            Thread.sleep(30000);
			obj_EsupportCoveoWorkflow.handleCookies(driver);
			obj_EsupportCoveoWorkflow.select_actionatorLink(driver,"Dell");
//			driver.navigate().back();
			obj_EsupportCoveoWorkflow.Select_Search_Values(driver, TestNGCreator.TestData.get(Esupport.SupportValue.ordinal()).split(";")[2], "Support");
			obj_EsupportCoveoWorkflow.handleCookies(driver);
			obj_EsupportCoveoWorkflow.select_actionatorLink(driver,"EMC");
			//scenario2
//			obj_EsupportCoveoWorkflow.ClickSignIn(driver);
			
			obj_EsupportCoveoWorkflow.EmployeeLogin(driver, TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			obj_EsupportCoveoWorkflow.Select_Search_Values(driver, TestNGCreator.TestData.get(Esupport.SupportValue.ordinal()).split(";")[1], "Support");
			obj_EsupportCoveoWorkflow.handleCookies(driver);
			obj_EsupportCoveoWorkflow.select_actionatorLink(driver,"EMC");
//			driver.navigate().back();
			obj_EsupportCoveoWorkflow.Select_Search_Values(driver, TestNGCreator.TestData.get(Esupport.SupportValue.ordinal()).split(";")[2], "Support");
			obj_EsupportCoveoWorkflow.handleCookies(driver);
			obj_EsupportCoveoWorkflow.select_actionatorLink(driver,"Dell");
			obj_EsupportIPSWorkflow.signOut(driver);
		}
		catch(Exception e)
		{

			Assert.fail("Failed while TC_5836880_AMER_IE_ActionatorImplementation_ESUPPORT--------->\n  "+e);

		}

	}
}


