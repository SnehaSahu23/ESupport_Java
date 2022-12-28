package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_8724974_AMER_CH_UnifiedProfile_Story7828076AsanyCustomeruserIshouldbeabletoviewlistofmyCustomGroupsFilterOptions_ESUPPORT extends BaseTest{
	@Test
	public void validate_TC_8724974_AMER_CH_UnifiedProfile_Story7828076AsanyCustomeruserIshouldbeabletoviewlistofmyCustomGroupsFilterOptions_ESUPPORT() 
	{

		try
		{
			System.out.println("Starts TC_8724974_AMER_CH_UnifiedProfile_Story7828076AsanyCustomeruserIshouldbeabletoviewlistofmyCustomGroupsFilterOptions_ESUPPORT");
			Thread.sleep(6000);	
			obj_EsupportIPSWorkflow.Emaillogin(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			Thread.sleep(6000);	
			obj_EsupportUnifiedPortalWorkflow.clickCustomGroups(driver);
			Thread.sleep(6000);	
			obj_EsupportUnifiedPortalWorkflow.validateFilterSectionInCustomGroupGrid(driver,TestNGCreator.TestData.get(Esupport.Dpid.ordinal()));
			Thread.sleep(6000);
			obj_EsupportUnifiedPortalWorkflow.clickOnXButtonOfFilterClearInCustomGrid(driver);
			
		}
		catch(Exception e){

			Assert.fail("Failed while executing test case TC_8724974_AMER_CH_UnifiedProfile_Story7828076AsanyCustomeruserIshouldbeabletoviewlistofmyCustomGroupsFilterOptions_ESUPPORT--------->\n  "+e);

		}

	}
}
