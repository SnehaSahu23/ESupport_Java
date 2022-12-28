package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.MobileTestNGCreator;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_6095584_AMER_MB_Coveo_SupportSearch_ShowCommunityDataFromLithiumOnSERP_ESUPPORT extends MobilePage
{
	@Test
	public void validate_TC_6095584_AMER_MB_Coveo_SupportSearch_ShowCommunityDataFromLithiumOnSERP_ESUPPORT() 
	{
		try
		{
			System.out.println("Starts TC_6095584_AMER_MB_Coveo_SupportSearch_ShowCommunityDataFromLithiumOnSERP_ESUPPORT");
			
			Thread.sleep(6000);
			obj_EsupportMobileWorkflow.handleCookies(driver);
			
			obj_EsupportMobileWorkflow.ClickExtensionsAndPinMobileView(driver);
			obj_EsupportMobileWorkflow.ClickExtensionIconAndSelectDevice(driver, "Samsung_Galaxy_S6_Portrait");
            obj_EsupportMobileWorkflow.Switch_To_Mobile_window(driver);
            Thread.sleep(6000);
			
            obj_EsupportMobileWorkflow.ValidateSearchForKeyword1WithOutDoubleQuotes(driver, MobileTestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[0], MobileTestNGCreator.TestData.get(Esupport.Dpid.ordinal()));
			
            obj_EsupportMobileWorkflow.SelectForumClickFirstDiplayedResultWhichHaveForumIcon(driver, MobileTestNGCreator.TestData.get(Esupport.Dpid.ordinal()));
			
            obj_EsupportMobileWorkflow.ValidateSearchForKeyword2WithOutDoubleQuotes(driver, MobileTestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[1], MobileTestNGCreator.TestData.get(Esupport.Dpid.ordinal()));
            obj_EsupportMobileWorkflow.SelectForumClickFirstDiplayedResultWhichHaveForumIcon(driver, MobileTestNGCreator.TestData.get(Esupport.Dpid.ordinal()));
			
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_6095584_AMER_MB_Coveo_SupportSearch_ShowCommunityDataFromLithiumOnSERP_ESUPPORT--------->\n  "+e);
		}
	}
}
