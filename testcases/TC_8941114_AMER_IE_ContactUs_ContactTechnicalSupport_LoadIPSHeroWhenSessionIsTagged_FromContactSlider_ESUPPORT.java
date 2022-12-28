package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_8941114_AMER_IE_ContactUs_ContactTechnicalSupport_LoadIPSHeroWhenSessionIsTagged_FromContactSlider_ESUPPORT extends BaseTest 
{
	@Test
	public void validate_TC_8941114_AMER_IE_ContactUs_ContactTechnicalSupport_LoadIPSHeroWhenSessionIsTagged_FromContactSlider_ESUPPORT() 
	{

		try
		{
			System.out.println("Starts TC_8941114_AMER_IE_ContactUs_ContactTechnicalSupport_LoadIPSHeroWhenSessionIsTagged_FromContactSlider_ESUPPORT");
			obj_EsupportProductionValidationsWorkflow.time(driver);
			
			driver.get("https://www.dell.com/support/home/en-us");
			obj_EsupportContentWorkflow.ClickSearchServiceTag(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
			obj_EsupportIncidentsWorkflow.ClickOnContactTechnicalSupportFromContactUsSlider(driver);
			obj_EsupportIncidentsWorkflow.ClickOnSupportAndContactSupportAndTechnicalSupportForCTSValidation(driver);
			
		}
		catch(Exception e)
		{

			Assert.fail("Failed while TC_8941114_AMER_IE_ContactUs_ContactTechnicalSupport_LoadIPSHeroWhenSessionIsTagged_FromContactSlider_ESUPPORT--------->\n  "+e);

		}

	}
}
