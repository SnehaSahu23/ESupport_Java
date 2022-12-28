package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.MobileTestNGCreator;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_6881874_AMER_MB_IPS_ServiceeventsuntaggedunauthEnterservicetagemaildetectPC_Esupport extends MobilePage
{
	@Test
	public void validate_TC_6881874_AMER_MB_IPS_ServiceeventsuntaggedunauthEnterservicetagemaildetectPC_Esupport() 
	{
		try
		{
			System.out.println("Starts TC_6881874_AMER_MB_IPS_ServiceeventsuntaggedunauthEnterservicetagemaildetectPC_Esupport");
			Thread.sleep(6000);
			obj_EsupportMobileWorkflow.handleCookies(driver);
			obj_EsupportMobileWorkflow.ClickExtensionsAndPinMobileView(driver);
			obj_EsupportMobileWorkflow.ClickExtensionIconAndSelectDevice(driver, "Samsung_Galaxy_S6_Portrait");
            obj_EsupportMobileWorkflow.Switch_To_Mobile_window(driver);
            Thread.sleep(6000);
            obj_EsupportMobileWorkflow.clickBrowseAllProductsLink(driver);
//            obj_EsupportMobileWorkflow.clickLaptopsLink(driver);
//            obj_EsupportMobileWorkflow.clickLatitudeLink(driver);
//            obj_EsupportMobileWorkflow.clickLatitudeSeries(driver,MobileTestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[0]);
//            obj_EsupportMobileWorkflow.clickLatitudeSubProduct(driver,MobileTestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[1]);
            obj_EsupportMobileWorkflow.SelectProductFromBrowseAll(driver);
            obj_EsupportMobileWorkflow.clickServiceEventsTab(driver);
			
			obj_EsupportMobileWorkflow.verifyServiceEventsTab(driver);
			obj_EsupportMobileWorkflow.enterServiceTagEmailServiceEvents(driver, MobileTestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()), MobileTestNGCreator.TestData.get(Esupport.Email.ordinal()));
			obj_EsupportMobileWorkflow.clickSubmitButtonServiceEvents(driver);
	
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_6881874_AMER_MB_IPS_ServiceeventsuntaggedunauthEnterservicetagemaildetectPC_Esupport--------->\n  "+e);
		}
	}
}