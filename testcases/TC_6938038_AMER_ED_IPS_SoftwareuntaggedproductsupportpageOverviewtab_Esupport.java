package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_6938038_AMER_ED_IPS_SoftwareuntaggedproductsupportpageOverviewtab_Esupport extends BaseTest
{
	@Test
	public void validate_TC_6938038_AMER_ED_IPS_SoftwareuntaggedproductsupportpageOverviewtab_Esupport() throws Throwable 
	{
		try
		{
			System.out.println("Starts TC_6938038_AMER_ED_IPS_SoftwareuntaggedproductsupportpageOverviewtab_Esupport");


			obj_EsupportIPSWorkflow.clickBrowseAllProductsLink(driver);
//			obj_EsupportIPSWorkflow.clickSoftwareLink(driver);
//			obj_EsupportIPSWorkflow.clickUtilitiesLink(driver);
//			
//			obj_EsupportIPSWorkflow.clickLatitudeSubProduct(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()));
			obj_EsupportIPSWorkflow.SelectProductFromBrowseAll(driver);
			obj_EsupportIPSWorkflow.verifyHeroSectionSoftwareTaggedProduct_two(driver);	
			
			obj_EsupportIPSWorkflow.verifyOverviewTabDetails_EnterServiceTag(driver);
			obj_EsupportIPSWorkflow.verifyEnterServiceTagLink(driver);
			obj_EsupportIPSWorkflow.verifyChangeProductLink(driver);
			
			obj_EsupportIPSWorkflow.clickEnterServiceTagLink(driver);
			obj_EsupportIPSWorkflow.clickEnterServiceTagPopupCloseButton(driver);	
			
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_6938038_AMER_ED_IPS_SoftwareuntaggedproductsupportpageOverviewtab_Esupport--------->\n  "+e);
		}
	}
}
