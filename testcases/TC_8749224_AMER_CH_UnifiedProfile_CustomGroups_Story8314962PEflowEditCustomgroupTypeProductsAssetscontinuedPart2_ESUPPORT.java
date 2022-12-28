package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_8749224_AMER_CH_UnifiedProfile_CustomGroups_Story8314962PEflowEditCustomgroupTypeProductsAssetscontinuedPart2_ESUPPORT extends BaseTest{
	@Test
	public void validate_TC_8749224_AMER_CH_UnifiedProfile_CustomGroups_Story8314962PEflowEditCustomgroupTypeProductsAssetscontinuedPart2_ESUPPORT() 
	{

		try
		{
			System.out.println("Starts TC_8749224_AMER_CH_UnifiedProfile_CustomGroups_Story8314962PEflowEditCustomgroupTypeProductsAssetscontinuedPart2_ESUPPORT");
			Thread.sleep(6000);	
			obj_EsupportIPSWorkflow.Emaillogin(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			Thread.sleep(6000);	
			obj_EsupportUnifiedPortalWorkflow.clickCustomGroups(driver);
			Thread.sleep(6000);	
			//edit created custom group
			
			obj_EsupportUnifiedPortalWorkflow.clickOnEdit_ValidateDisplayedPage_Products(driver);
			
			}
		catch(Exception e){

			Assert.fail("Failed while executing test case TC_8749224_AMER_CH_UnifiedProfile_CustomGroups_Story8314962PEflowEditCustomgroupTypeProductsAssetscontinuedPart2_ESUPPORT--------->\n  "+e);

		}

	}
}



