package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_12300227_AMER_FF_MPS_Premier_Service_Requests_Tab_Export_Table_Search_Box extends BaseTest
{
	@Test
    public void validate_TC_12300227_AMER_FF_MPS_Premier_Service_Requests_Tab_Export_Table_Search_Box()
    {
    	try
		{
			obj_EsupportMPSWorkflow.SignInToPremierAccount(driver, TestNGCreator.TestData.get(Esupport.Username.ordinal()), TestNGCreator.TestData.get(Esupport.Password.ordinal()),
					                                               TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()));
			obj_EsupportMPSWorkflow.ValidateMyProductsAndServicePage(driver);
			obj_EsupportMPSWorkflow.clickOnServiceRequestTab(driver);
			obj_EsupportMPSWorkflow.clickOnExportTableButton(driver);
			 obj_EsupportMPSWorkflow.validateFilterSection(driver);
			
		    
		    
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_12300227_AMER_FF_MPS_Premier_Service_Requests_Tab_Export_Table_Search_Box--------->\n  "+e);
		}
    }
	
	
}

