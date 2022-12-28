package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_12300229_AMER_CH_MPS_Premier_MFE_Support_History_Landing_Page_Layout_Grid_View_Row_Expansion extends BaseTest 
{
	@Test
    public void validate_TC_12300229_AMER_CH_MPS_Premier_MFE_Support_History_Landing_Page_Layout_Grid_View_Row_Expansion()
    {
    	try
		{
			obj_EsupportMPSWorkflow.SignInToPremierAccount(driver, TestNGCreator.TestData.get(Esupport.Username.ordinal()), TestNGCreator.TestData.get(Esupport.Password.ordinal()),
					                                               TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()));
			obj_EsupportMPSWorkflow.ValidateMyProductsAndServicePage(driver);
			obj_EsupportMPSWorkflow.clickOnServiceRequestTab(driver);
			obj_EsupportMPSWorkflow.clickMyAccount(driver);
			obj_EsupportMPSWorkflow.ChangeAccountTypeDropDown(driver);
			obj_EsupportMPSWorkflow.ClickOnSupportHistory(driver);
			obj_EsupportMPSWorkflow.VerifySupportHistoryPage(driver);
			obj_EsupportMPSWorkflow.VerifyGridOfSupportHistory(driver);
			obj_EsupportMPSWorkflow.VerifyAdditionalDetailsOfAnyRowInSupportHistory(driver);
		    
		    
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_12300229_AMER_CH_MPS_Premier_MFE_Support_History_Landing_Page_Layout_Grid_View_Row_Expansion--------->\n  "+e);
		}
    }
}
