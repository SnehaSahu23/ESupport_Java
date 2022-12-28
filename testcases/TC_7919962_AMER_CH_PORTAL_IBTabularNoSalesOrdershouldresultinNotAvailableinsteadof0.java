package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_7919962_AMER_CH_PORTAL_IBTabularNoSalesOrdershouldresultinNotAvailableinsteadof0 extends BaseTest
{
	@Test
	public void validate_TC_7919962_AMER_CH_PORTAL_IBTabularNoSalesOrdershouldresultinNotAvailableinsteadof0() 
	{
		try
		{
			System.out.println("Starts TC_7919962_AMER_CH_PORTAL_IBTabularNoSalesOrdershouldresultinNotAvailableinsteadof0");
			obj_EsupportPortalWorkflow.handleCookies(driver);
			obj_EsupportIPSWorkflow.Emaillogin(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			obj_EsupportPortalWorkflow.clickInstallBaseTab(driver);
			obj_EsupportPortalWorkflow.searchServiceTagAndValidateSalesOrderNumber(driver, TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_7919962_AMER_CH_PORTAL_IBTabularNoSalesOrdershouldresultinNotAvailableinsteadof0--------->\n  "+e);
		}
	}
}
