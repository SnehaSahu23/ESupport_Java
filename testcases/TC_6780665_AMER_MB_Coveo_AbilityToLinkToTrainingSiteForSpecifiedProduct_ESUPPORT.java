package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.MobileTestNGCreator;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_6780665_AMER_MB_Coveo_AbilityToLinkToTrainingSiteForSpecifiedProduct_ESUPPORT extends MobilePage
{
	@Test
	public void validate_TC_6780665_AMER_MB_Coveo_AbilityToLinkToTrainingSiteForSpecifiedProduct_ESUPPORT() 
	{
		try
		{
			System.out.println("Starts TC_6780665_AMER_MB_Coveo_AbilityToLinkToTrainingSiteForSpecifiedProduct_ESUPPORT()");
			
			obj_EsupportMobileWorkflow.handleCookies(driver);
			
			obj_EsupportMobileWorkflow.ClickExtensionsAndPinMobileView(driver);
			obj_EsupportMobileWorkflow.ClickExtensionIconAndSelectDevice(driver, "Samsung_Galaxy_S6_Portrait");
            obj_EsupportMobileWorkflow.Switch_To_Mobile_window(driver);
            Thread.sleep(6000);
			
            obj_EsupportMobileWorkflow.clickSignIn(driver);
            obj_EsupportMobileWorkflow.ToLogin_ValidCredentials(driver,MobileTestNGCreator.TestData.get(Esupport.Username.ordinal()),MobileTestNGCreator.TestData.get(Esupport.Password.ordinal()));
			
            obj_EsupportMobileWorkflow.ClickSearchServiceTag(driver,MobileTestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
            obj_EsupportMobileWorkflow.ClickDocumentationTab(driver);
            obj_EsupportMobileWorkflow.ValidateDetailsOnLeftRail(driver);
			
            obj_EsupportMobileWorkflow.TrainingLinkValidationInDocumentationTab(driver);
            obj_EsupportMobileWorkflow.signOut(driver);
		
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_6780665_AMER_MB_Coveo_AbilityToLinkToTrainingSiteForSpecifiedProduct_ESUPPORT()--------->\n  "+e);
		}
	}
}
