package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_6706303_AMER_ED_PSILDellDriversanddownloadsreskinAdditionalfeatures extends BaseTest
{
	@Test
	public void validate_TC_6706303_AMER_ED_PSILDellDriversanddownloadsreskinAdditionalfeatures() 
	{
		try
		{
			System.out.println("Starts TC_6706303_AMER_ED_PSILDellDriversanddownloadsreskinAdditionalfeatures");


			obj_EsupportDriverandDownloadsWorkflow.clickDriversandDownloadsLink(driver);
			obj_EsupportDriverandDownloadsWorkflow.validateOSdropdownDisabled(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[0]);
			obj_EsupportDriverandDownloadsWorkflow.verifyNoDriversFoundMessage(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[1]);
			obj_EsupportDriverandDownloadsWorkflow.verifyOtherFormatsandDownloadLink(driver);
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_6706303_AMER_ED_PSILDellDriversanddownloadsreskinAdditionalfeatures--------->\n  "+e);
		}
	}
}


