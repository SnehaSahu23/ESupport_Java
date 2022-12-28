package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_7056471_AMER_IE_ContactUSSPENexttellusthenatureoftherequesttextandissuedropdownboxLDELL extends BaseTest 
{
	@Test
	public void validate_TC_7056471_AMER_IE_ContactUSSPENexttellusthenatureoftherequesttextandissuedropdownboxLDELL() 
	{
		try
		{
			System.out.println("Starts TC_7056471_AMER_IE_ContactUSSPENexttellusthenatureoftherequesttextandissuedropdownboxLDELL");
			
			obj_EsupportIncidentsWorkflow.validateCtsHomePage(driver);	
			
			obj_EsupportIncidentsWorkflow.clickOnSignInButton(driver);
			obj_EsupportIncidentsWorkflow.ToLogin_ValidCredentials(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			
			obj_EsupportIncidentsWorkflow.validateNatureofRequestandIssueListDropdown(driver);
			obj_EsupportIncidentsWorkflow.ToVerify_EnterServiceTag_HandledPopup(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
			
			obj_EsupportIPSWorkflow.signOut(driver);
			Thread.sleep(10000);
//			obj_EsupportIncidentsWorkflow.enterDataSearchTextbox(driver, TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));			
		}
		
		catch(Exception e)
		{
			Assert.fail("Failed while executing TC_7056471_AMER_IE_ContactUSSPENexttellusthenatureoftherequesttextandissuedropdownboxLDELL--------->\n  "+e);
		}

	}
}
