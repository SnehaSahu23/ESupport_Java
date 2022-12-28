package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_8381856_AMER_CH_UnifiedProfile_CustomFroups_Story7936498CreateaCustomgroupOptionspage_ESUPPORT extends BaseTest{
	@Test
	public void validate_TC_8381856_AMER_CH_UnifiedProfile_CustomFroups_Story7936498CreateaCustomgroupOptionspage_ESUPPORT() 
	{

		try
		{
			System.out.println("Starts TC_8381856_AMER_CH_UnifiedProfile_CustomFroups_Story7936498CreateaCustomgroupOptionspage_ESUPPORT");
		
			obj_EsupportUnifiedPortalWorkflow.handleCookies(driver);
			obj_EsupportIPSWorkflow.Emaillogin(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()).split(";")[0],TestNGCreator.TestData.get(Esupport.Password.ordinal()).split(";")[0]);
			Thread.sleep(6000);	
			obj_EsupportUnifiedPortalWorkflow.clickCustomGroups(driver);
			Thread.sleep(6000);	
			
			//Scenario 1 Add custom group with out empty state
			obj_EsupportUnifiedPortalWorkflow.validateAddCustomGroupButton(driver);
			Thread.sleep(6000);
			obj_EsupportUnifiedPortalWorkflow.clickOnAddCustomGroupButton(driver);
			
			Thread.sleep(6000);
			obj_EsupportIPSWorkflow.signOut(driver);
			Thread.sleep(6000);
			driver.get("https://www.dell.com/support/preferences/us/en/04/mycustomgroups");
			Thread.sleep(6000);
			//Scenario 1 create custom group with empty state
			obj_EsupportIPSWorkflow.Emaillogin(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()).split(";")[1],TestNGCreator.TestData.get(Esupport.Password.ordinal()).split(";")[1]);
			Thread.sleep(15000);	
			obj_EsupportUnifiedPortalWorkflow.validateCreateCustomGroupButton(driver);
			Thread.sleep(6000);
			obj_EsupportUnifiedPortalWorkflow.clickOnCreateCustomGroupButton(driver);
			Thread.sleep(6000);
			obj_EsupportIPSWorkflow.signOut(driver);
			Thread.sleep(6000);
		}
		catch(Exception e){

			Assert.fail("Failed while executing test case TC_8381856_AMER_CH_UnifiedProfile_CustomFroups_Story7936498CreateaCustomgroupOptionspage_ESUPPORT--------->\n  "+e);

		}

	}
}
