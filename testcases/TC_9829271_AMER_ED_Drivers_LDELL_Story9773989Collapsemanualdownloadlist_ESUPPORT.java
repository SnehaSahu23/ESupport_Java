package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_9829271_AMER_ED_Drivers_LDELL_Story9773989Collapsemanualdownloadlist_ESUPPORT extends BaseTest
{
	@Test
	public void validate_TC_9829271_AMER_ED_Drivers_LDELL_Story9773989Collapsemanualdownloadlist_ESUPPORT() 
	{
		try
		{
			System.out.println("Starts TC_9829271_AMER_ED_Drivers_LDELL_Story9773989Collapsemanualdownloadlist_ESUPPORT");

			obj_EsupportContentWorkflow.ClickSearchProduct(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
			
			obj_EsupportDriverandDownloadsWorkflow.pcfClickDriversandDownloadsTab(driver);
			obj_EsupportDriverandDownloadsWorkflow.VerifyDriversListIsCollapsed(driver);
			obj_EsupportDriverandDownloadsWorkflow.VerifyAdditionalResourcesSections(driver);
						
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_9829271_AMER_ED_Drivers_LDELL_Story9773989Collapsemanualdownloadlist_ESUPPORT--------->\n  "+e);
		}
	}
}
