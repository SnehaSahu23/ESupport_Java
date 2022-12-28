package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_9834164_AMER_FF_Drivers_LDELL_Story9774038Newindicationtoexpandcollapsemanualdownloadlist_ESUPPORT extends BaseTest
{
	@Test
	public void validate_TC_9834164_AMER_FF_Drivers_LDELL_Story9774038Newindicationtoexpandcollapsemanualdownloadlist_ESUPPORT() 
	{
		try
		{
			System.out.println("Starts TC_9834164_AMER_FF_Drivers_LDELL_Story9774038Newindicationtoexpandcollapsemanualdownloadlist_ESUPPORT");

			obj_EsupportContentWorkflow.ClickSearchProduct(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
			
			obj_EsupportDriverandDownloadsWorkflow.pcfClickDriversandDownloadsTab(driver);
			
			obj_EsupportDriverandDownloadsWorkflow.VerifyDriversListIsCollapsed(driver);
			obj_EsupportDriverandDownloadsWorkflow.ClickOnCollapsedDriversList(driver);
			
			obj_EsupportDriverandDownloadsWorkflow.pcfVerifyAdditionalResourceSection(driver);
			
			obj_EsupportDriverandDownloadsWorkflow.ClickOnExpandedDriversList(driver);
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_9834164_AMER_FF_Drivers_LDELL_Story9774038Newindicationtoexpandcollapsemanualdownloadlist_ESUPPORT--------->\n  "+e);
		}
	}
}


