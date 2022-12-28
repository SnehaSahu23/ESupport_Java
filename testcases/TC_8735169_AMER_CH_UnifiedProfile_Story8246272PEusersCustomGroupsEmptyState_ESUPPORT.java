package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_8735169_AMER_CH_UnifiedProfile_Story8246272PEusersCustomGroupsEmptyState_ESUPPORT extends BaseTest{
	@Test
	public void validate_TC_8735169_AMER_CH_UnifiedProfile_Story8246272PEusersCustomGroupsEmptyState_ESUPPORT() 
	{

		try
		{
			System.out.println("Starts TC_8735169_AMER_CH_UnifiedProfile_Story8246272PEusersCustomGroupsEmptyState_ESUPPORT");
		
			//create custom group with empty state
//			obj_EsupportIPSWorkflow.Emaillogin(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			
			obj_EsupportIPSWorkflow.clickSignInHereLink(driver);
			
			Thread.sleep(15000);	
			obj_EsupportUnifiedPortalWorkflow.clickCustomGroups(driver);
			Thread.sleep(6000);	
			obj_EsupportUnifiedPortalWorkflow.validateCreateCustomGroupButton(driver);
			Thread.sleep(6000);

			obj_EsupportIPSWorkflow.signOut(driver);
			Thread.sleep(6000);
		}
		catch(Exception e){

			Assert.fail("Failed while executing test case TC_8735169_AMER_CH_UnifiedProfile_Story8246272PEusersCustomGroupsEmptyState_ESUPPORT--------->\n  "+e);

		}

	}
}
