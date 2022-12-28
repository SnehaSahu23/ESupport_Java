package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_7045718_AMER_CH_Portal_ServiceRequests_GeoView_ExpandToFullScreenForASiteInAnOnsiteServicesContext extends BaseTest
{
	@Test
	public void validate_TC_7045718_AMER_CH_Portal_ServiceRequests_GeoView_ExpandToFullScreenForASiteInAnOnsiteServicesContext() 
	{
		try
		{
			System.out.println("Starts TC_7045718_AMER_CH_Portal_ServiceRequests_GeoView_ExpandToFullScreenForASiteInAnOnsiteServicesContext");
				
			obj_EsupportPortalWorkflow.handleCookies(driver);
			obj_EsupportIPSWorkflow.Emaillogin(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			obj_EsupportPortalWorkflow.ClickOnIncidentManagementTab(driver);
			
			obj_EsupportPortalWorkflow.ClickOnOnsiteServicesTabOnLeftMenu(driver);
			obj_EsupportPortalWorkflow.ClickOnMap(driver);
			
			obj_EsupportPortalWorkflow.ClickOnAnyWhiteSpotThatIndicatesSiteLocation(driver);
			
			
		
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_7045718_AMER_CH_Portal_ServiceRequests_GeoView_ExpandToFullScreenForASiteInAnOnsiteServicesContext--------->\n  "+e);
		}
	}
}
