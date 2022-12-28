
package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_5836827_AMER_IE_DirectContent_ESUPPORT extends BaseTest 
{
	@Test
	public void validate_TC_5836827_AMER_IE_DirectContent_ESUPPORT() 
	{

		try
		{
			System.out.println("Starts TC_5836827_AMER_IE_DirectContent_ESUPPORT");
			//Thread.sleep(20000);
			System.out.println("Starts TC_5836827_AMER_CH_DirectContent_ESUPPORT");
			//obj_EsupportCoveoWorkflow.handleCookies(driver);
			obj_EsupportCoveoWorkflow.Select_Search_Values_DirectContent(driver, TestNGCreator.TestData.get(Esupport.SupportValue.ordinal()).split(";")[0], "Support");
			driver.navigate().back();
			//obj_EsupportCoveoWorkflow.handleCookies(driver);
			obj_EsupportCoveoWorkflow.Select_Search_Values_DirectContent(driver, TestNGCreator.TestData.get(Esupport.SupportValue.ordinal()).split(";")[1], "Support");
			driver.navigate().back();
			//obj_EsupportCoveoWorkflow.handleCookies(driver);
			obj_EsupportCoveoWorkflow.Select_Search_Values_DirectContent(driver, TestNGCreator.TestData.get(Esupport.SupportValue.ordinal()).split(";")[2], "Support");
			driver.navigate().back();
			//obj_EsupportCoveoWorkflow.handleCookies(driver);
			obj_EsupportCoveoWorkflow.Select_Search_Values_DirectContent(driver, TestNGCreator.TestData.get(Esupport.SupportValue.ordinal()).split(";")[3], "Support");
			driver.navigate().back();
			//obj_EsupportCoveoWorkflow.handleCookies(driver);
			
			
			
			obj_EsupportCoveoWorkflow.Select_Search_Values_DirectContent(driver, TestNGCreator.TestData.get(Esupport.SupportValue.ordinal()).split(";")[5], "Support");
			driver.navigate().back();
			
			obj_EsupportCoveoWorkflow.Select_Search_Values_DirectContent(driver, TestNGCreator.TestData.get(Esupport.SupportValue.ordinal()).split(";")[4], "Support");
			driver.navigate().back();
			//obj_EsupportCoveoWorkflow.handleCookies(driver);
			
			//Scanario2
//			obj_EsupportCoveoWorkflow.ClickSignIn(driver);
			
            obj_EsupportCoveoWorkflow.EmployeeLogin(driver, TestNGCreator.TestData.get(Esupport.Username.ordinal()).split(";")[0],TestNGCreator.TestData.get(Esupport.Password.ordinal()).split(";")[0]);
            obj_EsupportCoveoWorkflow.Select_Search_Values(driver, TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()),"Support");
            Thread.sleep(3000);
            obj_EsupportIPSWorkflow.signOut(driver);
//            obj_EsupportCoveoWorkflow.Logout(driver);
//            Thread.sleep(3000);
//          
//            //obj_EsupportCoveoWorkflow.ClickSignIn(driver);
//            obj_EsupportCoveoWorkflow.Emaillogin(driver, TestNGCreator.TestData.get(Esupport.Username.ordinal()).split(";")[1],TestNGCreator.TestData.get(Esupport.Password.ordinal()).split(";")[1]);
//            Thread.sleep(3000);
//            obj_EsupportCoveoWorkflow.Select_Search_Values(driver, TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()),"Support");
		}
		catch(Exception e)
		{

			Assert.fail("Failed while TC_5836827_AMER_IE_DirectContent_ESUPPORT--------->\n  "+e);

		}

	}
}


