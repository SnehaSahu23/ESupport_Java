package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.MobileTestNGCreator;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_10645854_AMER_MB_Story_10604533_CXJ_FY22_JTSA_Contact_Channel_New_Layout extends MobilePage
{
	@Test
	   public void validate_TC_10645854_AMER_CH_Story_10604533_CXJ_FY22_JTSA_Contact_Channel_New_Layout()
	   {
		   try
		   {
			   System.out.println("Starts TC_10645854_AMER_MB_Story_10604533_CXJ_FY22_JTSA_Contact_Channel_New_Layout");
			   obj_EsupportMobileWorkflow.ClickExtensionsAndPinMobileView(driver);
				obj_EsupportMobileWorkflow.ClickExtensionIconAndSelectDevice(driver, "Samsung_Galaxy_S6_Portrait");
	            obj_EsupportMobileWorkflow.Switch_To_Mobile_window(driver);
			   
//	            obj_EsupportMobileWorkflow.ToVerify_EnterServiceTag_HandledPopup(driver,MobileTestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(",")[0]);
//	            obj_EsupportMobileWorkflow.SelectIssueFromDropDown(driver, MobileTestNGCreator.TestData.get(Esupport.SearchOption.ordinal()));
//	            obj_EsupportMobileWorkflow.verifyTheChannelNewLayOutForIssueType(driver);
	          
	            obj_EsupportMobileWorkflow.clickOnEnterServiceTag(driver);
	            obj_EsupportMobileWorkflow.EnterValueInServiceTagField(driver,MobileTestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
	            obj_EsupportMobileWorkflow.clickOnSubmitButtonAfterEnteringServiceTag(driver);
	            obj_EsupportMobileWorkflow.SelectIssueFromDropDown(driver, MobileTestNGCreator.TestData.get(Esupport.SearchOption.ordinal()));
	            obj_EsupportMobileWorkflow.clickOnNextButton(driver);
	            obj_EsupportMobileWorkflow.verifyTheChannelNewLayOutForIssueType(driver);
	            
		   }
		   catch(Exception e)
			{
				Assert.fail("Failed in TC_10645854_AMER_MB_Story_10604533_CXJ_FY22_JTSA_Contact_Channel_New_Layout--------->\n  "+e);
			}
	   }
}
