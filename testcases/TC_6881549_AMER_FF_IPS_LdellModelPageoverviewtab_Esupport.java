package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_6881549_AMER_FF_IPS_LdellModelPageoverviewtab_Esupport extends BaseTest
{
	@Test
	public void validate_TC_6881549_AMER_FF_IPS_LdellModelPageoverviewtab_Esupport() 
	{
		try
		{
			System.out.println("Starts TC_6881549_AMER_FF_IPS_LdellModelPageoverviewtab_Esupport");


			obj_EsupportIPSWorkflow.clickBrowseAllProductsLink(driver);
//			obj_EsupportIPSWorkflow.clickLaptopsLink(driver);
//			obj_EsupportIPSWorkflow.clickLatitudeLink(driver);
//			obj_EsupportIPSWorkflow.clickLatitudeSeries(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[0]);
//			obj_EsupportIPSWorkflow.clickLatitudeSubProduct(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[1]);
			obj_EsupportIPSWorkflow.SelectProductFromBrowseAll(driver);
			obj_EsupportIPSWorkflow.verifyOverviewTabDetails_EnterServiceTag(driver);
			obj_EsupportIPSWorkflow.clickEnterServiceTagLink(driver);
			obj_EsupportIPSWorkflow.enterServiceTagModalPopup(driver, TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
			obj_EsupportIPSWorkflow.verifyOverviewTabDetails_SignIn(driver);
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_6881549_AMER_FF_IPS_LdellModelPageoverviewtab_Esupport--------->\n  "+e);
		}
	}
}
