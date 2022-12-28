package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_5785269_AMER_ED_PartsandAccessories_ESUPPORT extends BaseTest 
{
	@Test
	public void validate_TC_5785269_AMER_ED_PartsandAccessories_ESUPPORT() 
	{

		try
		{
			System.out.println("Starts TC_5785269_AMER_ED_PartsandAccessories_ESUPPORT");
			obj_EsupportContentWorkflow.handleCookies(driver);
			obj_EsupportDriverandDownloadsWorkflow.ToVerify_EnterServiceTage(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
			obj_EsupportContentWorkflow.TOVerify_NavigationTabs(driver);
			obj_EsupportContentWorkflow.handleCookies(driver);
			obj_EsupportContentWorkflow.clickPartsAccessoriesTab(driver);	
			obj_EsupportContentWorkflow.handlePartsAccessoriesList(driver);
		}
		catch(Exception e)
		{

			Assert.fail("Failed while TC_5785269_AMER_ED_PartsandAccessories_ESUPPORT--------->\n  "+e);

		}

	}
}


