

package com.dell.delta_uat_automation.esupport.testcases;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;


public class TC_5784080_AMER_CH_WarrantyTabs_ESUPPORT extends BaseTest 
{
	@Test
	public void validate_TC_5784080_AMER_CH_WarrantyTabs_ESUPPORT() 
	{

		try
		{
			System.out.println("Starts TC_5784080_AMER_CH_WarrantyTabs_ESUPPORT");
			obj_EsupportDriverandDownloadsWorkflow.handleCookies(driver);
			obj_EsupportDriverandDownloadsWorkflow.clickBrowseAllProductsLink(driver);
			obj_EsupportDriverandDownloadsWorkflow.clickLaptops(driver);
			obj_EsupportDriverandDownloadsWorkflow.clickLatitude(driver);
			obj_EsupportDriverandDownloadsWorkflow.clickLatitudeE4200(driver);
			System.out.println("Clicked on Latitude E4200");                 
			obj_EsupportDriverandDownloadsWorkflow.handleCookies(driver);
			obj_EsupportContentWorkflow.ToVerify_Productpageheder(driver);
			//obj_EsupportContentWorkflow.ToVerify_ByDefaultdiagnostics(driver);
			obj_EsupportContentWorkflow.TOVerify_NavigationTabs(driver);
			obj_EsupportContentWorkflow.ClickWarrenty_Tab(driver);
			obj_EsupportContentWorkflow.ToVerify_WarrentyserviceTag(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
			
			driver.navigate().to("https://www.dell.com/support/home");
			
			obj_EsupportDriverandDownloadsWorkflow.ToVerify_EnterServiceTage(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
			obj_EsupportContentWorkflow.ToClick_SupportArticlesTab(driver);
			obj_EsupportContentWorkflow.ToVerify_SupportArticlesPageview(driver);
			obj_EsupportContentWorkflow.ToClick_TopicSolutionslink(driver);
			obj_EsupportContentWorkflow.ToClick_AdditionalResourceSubTitleAllLink(driver);
			
			
			
			
			
		}
		catch(Exception e)
		{

			Assert.fail("Failed while TC_5784080_AMER_CH_WarrantyTabs_ESUPPORT--------->\n  "+e);

		}

	}
}


