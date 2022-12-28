package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_9922198_AMER_IE_Drivers_LDELL_Story9911898Downloadcountandtableformatfordownloads_ESUPPORT extends BaseTest
{
	@Test
	public void validate_TC_9922198_AMER_IE_Drivers_LDELL_Story9911898Downloadcountandtableformatfordownloads_ESUPPORT() 
	{
		try
		{
			System.out.println("Starts TC_9922198_AMER_IE_Drivers_LDELL_Story9911898Downloadcountandtableformatfordownloads_ESUPPORT");


			obj_EsupportContentWorkflow.ClickSearchProduct(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
		
			obj_EsupportDriverandDownloadsWorkflow.pcfClickDriversandDownloadsTab(driver);
			
			obj_EsupportDriverandDownloadsWorkflow.verifyNoDriversFoundMessage(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[0]);
			
			obj_EsupportDriverandDownloadsWorkflow.verifyDownloadsForSearchedKeyword(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[1]);
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_9922198_AMER_IE_Drivers_LDELL_Story9911898Downloadcountandtableformatfordownloads_ESUPPORT--------->\n  "+e);
		}
	}
}
