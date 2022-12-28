package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_7046493_AMER_CH_Portal_SRGeo_DefaultViewForAllStateVersusSpecificDataSetState_ESUPPORT extends BaseTest
{
	@Test
	public void validate_TC_7046493_AMER_CH_Portal_SRGeo_DefaultViewForAllStateVersusSpecificDataSetState_ESUPPORT() 
	{
		try
		{
			System.out.println("Starts TC_7046493_AMER_CH_Portal_SRGeo_DefaultViewForAllStateVersusSpecificDataSetState_ESUPPORT");
				
			obj_EsupportPortalWorkflow.handleCookies(driver);
			
			obj_EsupportIPSWorkflow.Emaillogin(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			obj_EsupportPortalWorkflow.ClickOnIncidentManagementTab(driver);
			
			obj_EsupportPortalWorkflow.ClickOnMap(driver);
			
			obj_EsupportPortalWorkflow.ClickOnAnyWhiteSpotThatIndicatesSiteLocation(driver);
			
			
			obj_EsupportPortalWorkflow.ClickOnPartsReplaced(driver);
			
			obj_EsupportPortalWorkflow.ClickOnAnyWhiteSpotThatIndicatesSiteLocation(driver);
			//work on below test case
			obj_EsupportPortalWorkflow.ValidateHUDAndCircleInPopUpOnRightSide(driver);
			
			obj_EsupportPortalWorkflow.ClickOnAnyWhiteSpotThatIndicatesSiteLocation(driver);
			obj_EsupportPortalWorkflow.ClickOnAnyWhiteSpotThatIndicatesSiteLocation(driver);
			obj_EsupportPortalWorkflow.ClickOnAnyWhiteSpotThatIndicatesSiteLocation(driver);
			
		
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_7046493_AMER_CH_Portal_SRGeo_DefaultViewForAllStateVersusSpecificDataSetState_ESUPPORT--------->\n  "+e);
		}
	}
}
