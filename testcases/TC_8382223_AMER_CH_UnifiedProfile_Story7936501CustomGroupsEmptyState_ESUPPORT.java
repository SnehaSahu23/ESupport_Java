package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_8382223_AMER_CH_UnifiedProfile_Story7936501CustomGroupsEmptyState_ESUPPORT extends BaseTest{
	@Test
	public void validate_TC_8382223_AMER_CH_UnifiedProfile_Story7936501CustomGroupsEmptyState_ESUPPORT() 
	{

		try
		{
			System.out.println("Starts TC_8382223_AMER_CH_UnifiedProfile_Story7936501CustomGroupsEmptyState_ESUPPORT");
		
			//create custom group with empty state
			obj_EsupportIPSWorkflow.Emaillogin(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			Thread.sleep(15000);	
			obj_EsupportUnifiedPortalWorkflow.clickCustomGroups(driver);
			Thread.sleep(6000);	
			obj_EsupportUnifiedPortalWorkflow.validateCreateCustomGroupButton(driver);
			Thread.sleep(6000);

			obj_EsupportIPSWorkflow.signOut(driver);
			Thread.sleep(6000);
		}
		catch(Exception e){

			Assert.fail("Failed while executing test case TC_8382223_AMER_CH_UnifiedProfile_Story7936501CustomGroupsEmptyState_ESUPPORT--------->\n  "+e);

		}

	}
}
