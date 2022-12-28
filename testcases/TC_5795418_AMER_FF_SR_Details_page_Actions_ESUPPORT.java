package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_5795418_AMER_FF_SR_Details_page_Actions_ESUPPORT extends BaseTest 
{
	@Test
	public void validate_TC_5795418_AMER_FF_SR_Details_page_Actions_ESUPPORT() 
	{

		try
		{
			obj_EsupportIncidentsWorkflow.navigateToSRPage(driver);
			obj_EsupportIncidentsWorkflow.toEnter_ServiceTag(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()),TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()),TestNGCreator.TestData.get(Esupport.Email.ordinal()));
		
		
			obj_EsupportIncidentsWorkflow.Verify_DispathDetails(driver);
		}
		catch(Exception e)
		{

			Assert.fail("Failed while TC_5795418_AMER_FF_SR_Details_page_Actions_ESUPPORT--------->\n  "+e);

		}

	}
}
