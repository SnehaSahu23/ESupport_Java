package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.MobileTestNGCreator;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_10645572_AMER_MB_Story_10604531_CXJ_FY22_JTSA_Contact_Channel_Layout_Recommended_Channel extends MobilePage
{
	@Test
	public void validate_TC_10645572_AMER_MB_Story_10604531_CXJ_FY22_JTSA_Contact_Channel_Layout_Recommended_Channel()
	{
		try
		{
			System.out.println("Starts validate_TC_10645572_AMER_MB_Story_10604531_CXJ_FY22_JTSA_Contact_Channel_Layout_Recommended_Channel");
			obj_EsupportMobileWorkflow.ClickExtensionsAndPinMobileView(driver);
			obj_EsupportMobileWorkflow.ClickExtensionIconAndSelectDevice(driver, "Samsung_Galaxy_S6_Portrait");
            obj_EsupportMobileWorkflow.Switch_To_Mobile_window(driver);
			
//            obj_EsupportMobileWorkflow.handleCookies(driver); 
//            obj_EsupportMobileWorkflow.ToVerify_EnterServiceTag_HandledPopup(driver,MobileTestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
//            obj_EsupportMobileWorkflow.SelectIssueFromDropDown(driver, MobileTestNGCreator.TestData.get(Esupport.SearchOption.ordinal()));
//            obj_EsupportMobileWorkflow.verifyRecommendLabelForSelfServeOption(driver);
            
          //*********** nEw Functionality****************
            obj_EsupportMobileWorkflow.clickOnEnterServiceTag(driver);
			obj_EsupportMobileWorkflow.EnterValueInServiceTagField(driver,MobileTestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
			obj_EsupportMobileWorkflow.clickOnSubmitButtonAfterEnteringServiceTag(driver);
//			obj_EsupportMobileWorkflow.clickOnNextButtonOnProductPage(driver);
			obj_EsupportMobileWorkflow.SelectIssueFromDropDown(driver, MobileTestNGCreator.TestData.get(Esupport.SearchOption.ordinal()));
			obj_EsupportMobileWorkflow.clickOnNextButton(driver);
			obj_EsupportMobileWorkflow.verifyRecommendLabelForSelfServeOption(driver);
		}
		catch(Exception e)
		{
			Assert.fail("Failed while TC_10645572_AMER_MB_Story_10604531_CXJ_FY22_JTSA_Contact_Channel_Layout_Recommended_Channel--------->\n  "+e);
		}
	}
}
