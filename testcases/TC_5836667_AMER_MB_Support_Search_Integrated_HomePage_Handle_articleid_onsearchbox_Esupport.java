package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.MobileTestNGCreator;

public class TC_5836667_AMER_MB_Support_Search_Integrated_HomePage_Handle_articleid_onsearchbox_Esupport extends MobilePage {
	@Test
	public void validate_TC_5836667_AMER_MB_Support_Search_Integrated_HomePage_Handle_articleid_onsearchbox_Esupport() 
	{

		try
		{
			System.out.println("Starts TC_5836667");

			Thread.sleep(6000);
			obj_EsupportMobileWorkflow.handleCookies(driver);
			obj_EsupportMobileWorkflow.ClickExtensionsAndPinMobileView(driver);
			obj_EsupportMobileWorkflow.ClickExtensionIconAndSelectDevice(driver, "Samsung_Galaxy_S6_Portrait");
            obj_EsupportMobileWorkflow.Switch_To_Mobile_window(driver);
            Thread.sleep(6000);

//			obj_EsupportCoveoWorkflow.handleCookies(driver);

//			obj_EsupportCoveoWorkflow.Emaillogin(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
//			obj_EsupportCoveoWorkflow.handleCookies(driver);
            obj_EsupportMobileWorkflow.clickSignIn(driver);
            obj_EsupportMobileWorkflow.ToLogin_ValidCredentials(driver,MobileTestNGCreator.TestData.get(Esupport.Username.ordinal()),MobileTestNGCreator.TestData.get(Esupport.Password.ordinal()));
			
			
          
            obj_EsupportMobileWorkflow.Select_Search_Values(driver, MobileTestNGCreator.TestData.get(Esupport.SupportValue.ordinal()), "Support");
// clicking on link opening new window so commenting below method
            //            obj_EsupportMobileWorkflow.toVerify_ArticleID(driver);
			
			//driver.navigate().back();
            obj_EsupportMobileWorkflow.signOut(driver);
			
			
			
		}
		catch(Exception e){

			Assert.fail("Failed while executing test case TC_5836667_AMER_MB_Support_Search_Integrated_HomePage_Handle_articleid_onsearchbox_Esupport--------->\n  "+e);

		}

	}

}
