package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_6603539_AMER_FF_LDellMnATaggedDisplayproductname_Esupport extends BaseTest
{
	@Test
	public void validate_TC_6603539_AMER_FF_LDellMnATaggedDisplayproductname_Esupport() 
	{
		try
		{
			System.out.println("Starts TC_6603539_AMER_FF_LDellMnATaggedDisplayproductname_Esupport");
			
			obj_EsupportIPSWorkflow.searchServiceTag(driver, TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
			obj_EsupportIPSWorkflow.verifyProductName(driver);	
			obj_EsupportIPSWorkflow.clickSignIn(driver);	
			obj_EsupportIPSWorkflow.Emaillogin(driver,  TestNGCreator.TestData.get(Esupport.Username.ordinal()),  TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			obj_EsupportIPSWorkflow.verifyProductName(driver);		
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_6603539_AMER_FF_LDellMnATaggedDisplayproductname_Esupport--------->\n  "+e);
		}
	}
}
