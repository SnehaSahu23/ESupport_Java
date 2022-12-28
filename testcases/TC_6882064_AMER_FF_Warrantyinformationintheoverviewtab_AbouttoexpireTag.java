package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_6882064_AMER_FF_Warrantyinformationintheoverviewtab_AbouttoexpireTag extends BaseTest
{
	@Test
	public void validate_TC_6882064_AMER_FF_Warrantyinformationintheoverviewtab_AbouttoexpireTag() 
	{
		try
		{
			System.out.println("Starts TC_6882064_AMER_FF_Warrantyinformationintheoverviewtab_AbouttoexpireTag");
			
			obj_EsupportIPSWorkflow.searchServiceTag(driver, TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
			obj_EsupportIPSWorkflow.verifyAlertOverviewTab(driver);
			obj_EsupportIPSWorkflow.clickViewDetailsLink(driver);
			obj_EsupportIPSWorkflow.clickWarrantyDetailsCloseButton(driver);
			obj_EsupportIPSWorkflow.clickExtendUpgradeLinkOverviewTab(driver);
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_6882064_AMER_FF_Warrantyinformationintheoverviewtab_AbouttoexpireTag--------->\n  "+e);
		}
	}
}
