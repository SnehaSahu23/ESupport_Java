package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_12281452_AMER_FF_MPS_Premier_Service_Requests_Tab_Grid_View_SR_Number_Expansion_View extends BaseTest
{
    @Test
    public void validate_TC_12281452_AMER_FF_MPS_Premier_Service_Requests_Tab_Grid_View_SR_Number_Expansion_View()
    {
    	try
		{
			obj_EsupportMPSWorkflow.SignInToPremierAccount(driver, TestNGCreator.TestData.get(Esupport.Username.ordinal()), TestNGCreator.TestData.get(Esupport.Password.ordinal()),
					                                               TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()));
		    obj_EsupportMPSWorkflow.clickOnServiceRequestTab(driver);
		    obj_EsupportMPSWorkflow.ValidateServiceRequestTab(driver);
		    obj_EsupportMPSWorkflow.ClickOnServiceTagInServiceRequestTab(driver);
		    obj_EsupportMPSWorkflow.ClickOnSRNumberInServiceRequestTab(driver);
		    obj_EsupportMPSWorkflow.clickOnExpandButtonOfFirstDisplayedRow_SRTab(driver);
		    
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_12281452_AMER_FF_MPS_Premier_Service_Requests_Tab_Grid_View_SR_Number_Expansion_View--------->\n  "+e);
		}
    }
}