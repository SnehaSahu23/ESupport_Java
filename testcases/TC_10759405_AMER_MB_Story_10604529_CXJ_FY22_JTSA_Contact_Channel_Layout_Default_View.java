package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.MobileTestNGCreator;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_10759405_AMER_MB_Story_10604529_CXJ_FY22_JTSA_Contact_Channel_Layout_Default_View extends MobilePage
{
	@Test
	public void Validate_TC_10759405_AMER_MB_Story_10604529_CXJ_FY22_JTSA_Contact_Channel_Layout_Default_View()
	{
		try
		{
			System.out.println("Starts Validate_TC_10759405_AMER_MB_Story_10604529_CXJ_FY22_JTSA_Contact_Channel_Layout_Default_View");
			
			obj_EsupportMobileWorkflow.ClickExtensionsAndPinMobileView(driver);
			obj_EsupportMobileWorkflow.ClickExtensionIconAndSelectDevice(driver, "Samsung_Galaxy_S6_Portrait");
            obj_EsupportMobileWorkflow.Switch_To_Mobile_window(driver);
			
            obj_EsupportMobileWorkflow.ToVerify_EnterServiceTag_HandledPopup(driver,MobileTestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
            obj_EsupportMobileWorkflow.verifyTheChannelNewLayOutForIssueType(driver);
		}
		catch(Exception e)
		{
			Assert.fail("Failed while TC_10759405_AMER_MB_Story_10604529_CXJ_FY22_JTSA_Contact_Channel_Layout_Default_View--------->\n  "+e);
		}
	}
}
