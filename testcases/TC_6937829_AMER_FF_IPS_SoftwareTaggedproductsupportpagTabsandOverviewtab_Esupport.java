package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_6937829_AMER_FF_IPS_SoftwareTaggedproductsupportpagTabsandOverviewtab_Esupport extends BaseTest
{
	@Test
	public void validate_TC_6937829_AMER_FF_IPS_VerifytheHerosectionSoftwareTaggedproductsupportpage_Esupport() throws Throwable 
	{
		try
		{
			System.out.println("Starts TC_6937829_AMER_FF_IPS_SoftwareTaggedproductsupportpagTabsandOverviewtab_Esupport");


			obj_EsupportIPSWorkflow.searchServiceTag(driver, TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
			obj_EsupportIPSWorkflow.verifyHeroSectionSoftwareTaggedProduct(driver);		
			obj_EsupportIPSWorkflow.verifyTabsSupportPage(driver);
			
			obj_EsupportIPSWorkflow.verifyOverviewTabDetails(driver);
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_6937829_AMER_FF_IPS_SoftwareTaggedproductsupportpagTabsandOverviewtab_Esupport--------->\n  "+e);
		}
	}
}
