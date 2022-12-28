package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_7199685_AMER_CH_PORT_Useofdateformatacrosstheportal extends BaseTest
{
	@Test
	public void validate_TC_7199685_AMER_CH_PORT_Useofdateformatacrosstheportal() 
	{
		try
		{
			System.out.println("Starts TC_7199685_AMER_CH_PORT_Useofdateformatacrosstheportal");
			obj_EsupportPortalWorkflow.handleCookies(driver);
			obj_EsupportIPSWorkflow.Emaillogin(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			Thread.sleep(20000);
			obj_EsupportPortalWorkflow.clickIncidentManagementTab(driver);
			obj_EsupportPortalWorkflow.clickIncidentManagementExpandButton(driver);
			obj_EsupportPortalWorkflow.verifyExpandViewDateRange(driver);
			obj_EsupportPortalWorkflow.verifyDateRangeFormat(driver);
			obj_EsupportPortalWorkflow.verifyLastUpdatedDateFormat(driver);
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_7199685_AMER_CH_PORT_Useofdateformatacrosstheportal--------->\n  "+e);
		}
	}
}

