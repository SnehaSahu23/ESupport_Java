package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_5785282_AMER_IE_CategoryPages_ESUPPORT extends BaseTest 
{
	@Test
	public void validate_TC_5785282_AMER_IE_CategoryPages_ESUPPORT() 
	{

		try
		{
			System.out.println("Starts TC_5785282_AMER_IE_CategoryPages_ESUPPORT");
			obj_EsupportContentWorkflow.clickMastheadProductLink(driver);
			obj_EsupportContentWorkflow.clickSupportLibrary(driver);
			obj_EsupportContentWorkflow.clickSoftwareSecuirtyLink(driver);
			obj_EsupportContentWorkflow.changeCountry(driver);
			obj_EsupportContentWorkflow.validateSecurityHeader(driver);			
		}
		catch(Exception e)
		{
			Assert.fail("Failed while TC_5785282_AMER_IE_CategoryPages_ESUPPORT--------->\n  "+e);

		}

	}
}


