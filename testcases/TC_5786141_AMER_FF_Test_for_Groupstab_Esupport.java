package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_5786141_AMER_FF_Test_for_Groupstab_Esupport extends BaseTest {


	@Test
	public void validate_TC_5786141_AMER_FF_Test_for_Groupstab_Esupport() 
	{
		try
		{
			System.out.println("Starts TC# 5786141_AMER_FF");  
			obj_EsupportMPSWorkflow.handleCookies(driver);
			obj_EsupportMPSWorkflow.toClick_SignIn(driver);
			obj_EsupportMPSWorkflow.handleCookies(driver);
			obj_EsupportMPSWorkflow.Login(driver);
			obj_EsupportMPSWorkflow.handleCookies(driver);
			obj_EsupportMPSWorkflow.toClick_GroupsTab(driver);
			obj_EsupportMPSWorkflow.toClick_CreateNewGroup(driver);
			obj_EsupportMPSWorkflow.toGive_GroupName(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()));
			obj_EsupportMPSWorkflow.toClick_AddProducts(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()));
			obj_EsupportMPSWorkflow.toSelect_AddProducts(driver);
			obj_EsupportMPSWorkflow.toVerify_Links(driver);
			obj_EsupportMPSWorkflow.toClick_RemoveProducts(driver);
		}
		catch(Exception e)
		{
			Assert.fail("Failed while executing test case TC_5786141_AMER_FF_Test_for_Groupstab_Esupport--------->\n  "+e);
		}
	}

}
