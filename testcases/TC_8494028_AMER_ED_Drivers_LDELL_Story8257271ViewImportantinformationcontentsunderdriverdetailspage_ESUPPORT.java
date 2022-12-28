package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_8494028_AMER_ED_Drivers_LDELL_Story8257271ViewImportantinformationcontentsunderdriverdetailspage_ESUPPORT extends BaseTest
{
	@Test
	public void validate_TC_8494028_AMER_ED_Drivers_LDELL_Story8257271ViewImportantinformationcontentsunderdriverdetailspage_ESUPPORT() 
	{
		try
		{
			System.out.println("Starts TC_8494028_AMER_ED_Drivers_LDELL_Story8257271ViewImportantinformationcontentsunderdriverdetailspage_ESUPPORT");

			obj_EsupportContentWorkflow.ClickSearchProduct(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
			
			obj_EsupportDriverandDownloadsWorkflow.pcfClickDriversandDownloadsTab(driver);
			
			obj_EsupportDriverandDownloadsWorkflow.checkForImportantInformationIcon(driver);
			obj_EsupportDriverandDownloadsWorkflow.ClickOnCollapseButtonOfImportInfoDriver(driver);
			obj_EsupportDriverandDownloadsWorkflow.ClickViewDetailsLinkForFirstDisplayedImportantInformationDriver(driver);
			
			
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_8494028_AMER_ED_Drivers_LDELL_Story8257271ViewImportantinformationcontentsunderdriverdetailspage_ESUPPORT--------->\n  "+e);
		}
	}
}

