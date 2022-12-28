package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_8752361_AMER_CH_UnifiedProfile_CustomGroups_Story8416725CustomgroupcreationNameandDescriptionfieldchanges_ESUPPORT extends BaseTest{
	@Test
	public void validate_TC_8752361_AMER_CH_UnifiedProfile_CustomGroups_Story8416725CustomgroupcreationNameandDescriptionfieldchanges_ESUPPORT() 
	{

		try
		{
			System.out.println("Starts TC_8752361_AMER_CH_UnifiedProfile_CustomGroups_Story8416725CustomgroupcreationNameandDescriptionfieldchanges_ESUPPORT");
			Thread.sleep(6000);	
			//verifying using employee login
			obj_EsupportIPSWorkflow.clickSignInHereLink(driver);
			Thread.sleep(6000);	
			obj_EsupportUnifiedPortalWorkflow.clickCustomGroups(driver);
			Thread.sleep(6000);	
			obj_EsupportUnifiedPortalWorkflow.validateAddCustomGroupButton(driver);
			Thread.sleep(6000);
			obj_EsupportUnifiedPortalWorkflow.clickOnAddCustomGroupButton(driver);
			Thread.sleep(6000);
			obj_EsupportUnifiedPortalWorkflow.SelectCreateByInduvidualProductsOption(driver);
			Thread.sleep(6000);
			obj_EsupportUnifiedPortalWorkflow.EnterValuesInNameAndDescription(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()));
			
		}
		catch(Exception e){

			Assert.fail("Failed while executing test case TC_8752361_AMER_CH_UnifiedProfile_CustomGroups_Story8416725CustomgroupcreationNameandDescriptionfieldchanges_ESUPPORT--------->\n  "+e);

		}

	}
}

