package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_6780696_AMER_MB_Coveo_VideoTutorialsForVideoSection_ESUPPORT extends MobilePage
{
	@Test
	public void validate_TC_6780696_AMER_MB_Coveo_VideoTutorialsForVideoSection_ESUPPORT() 
	{
		try
		{
			System.out.println("Starts TC_6780696_AMER_MB_Coveo_VideoTutorialsForVideoSection_ESUPPORT");
			//obj_EsupportContentWorkflow.handleCookies(driver);
			
			Thread.sleep(6000);
			obj_EsupportMobileWorkflow.handleCookies(driver);
			
			obj_EsupportMobileWorkflow.ClickExtensionsAndPinMobileView(driver);
			obj_EsupportMobileWorkflow.ClickExtensionIconAndSelectDevice(driver, "Samsung_Galaxy_S6_Portrait");
            obj_EsupportMobileWorkflow.Switch_To_Mobile_window(driver);
            Thread.sleep(6000);
			
            obj_EsupportMobileWorkflow.clickBrowseAllProductsLink(driver);
            obj_EsupportMobileWorkflow.SelectProductFromBrowseAll(driver);
//            obj_EsupportMobileWorkflow.clickLaptopsLink(driver);
//            obj_EsupportMobileWorkflow.clickLatitudeLink(driver);
//            obj_EsupportMobileWorkflow.clickLatitudeSeries(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[0]);
//            obj_EsupportMobileWorkflow.clickLatitudeSubProduct(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[1]);
            obj_EsupportMobileWorkflow.ClickDocumentationTab(driver);
            obj_EsupportMobileWorkflow.ScrollToVideos(driver);
            obj_EsupportMobileWorkflow.ValidateClickOnSeeVideoTutorials(driver);
                                                                             
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_6780696_AMER_MB_Coveo_VideoTutorialsForVideoSection_ESUPPORT--------->\n  "+e);
		}
	}
}
