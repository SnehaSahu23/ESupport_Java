package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_7681006_AMER_ED_IPS_LEMCLiteusersshouldbeabletoaccessgenericmodelpages extends BaseTest{
	@Test
	public void validate_TC_7681006_AMER_ED_IPS_LEMCLiteusersshouldbeabletoaccessgenericmodelpages() 
	{
		try
		{
			System.out.println("Starts TC_7681006_AMER_ED_IPS_LEMCLiteusersshouldbeabletoaccessgenericmodelpages");

//Level 10 User
			
			obj_EsupportIncidentsWorkflow.clickSignIn(driver);
			obj_EsupportIPSWorkflow.Emaillogin(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()).split(";")[0],TestNGCreator.TestData.get(Esupport.Password.ordinal()).split(";")[0]);
			obj_EsupportIPSWorkflow.selectProductModel(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[0]);
			obj_EsupportIPSWorkflow.signOut(driver);
			obj_EsupportIncidentsWorkflow.clickChangeProductLink(driver);
			driver.get("https://www.dell.com/support/home/en-us");
			Thread.sleep(10000);
			
			//Level 30 User
			obj_EsupportIncidentsWorkflow.clickSignIn(driver);
			obj_EsupportIPSWorkflow.Emaillogin(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()).split(";")[1],TestNGCreator.TestData.get(Esupport.Password.ordinal()).split(";")[1]);
			obj_EsupportIPSWorkflow.selectProductModel(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[0]);
			obj_EsupportIPSWorkflow.signOut(driver);
			obj_EsupportIncidentsWorkflow.clickChangeProductLink(driver);
			driver.get("https://www.dell.com/support/home/en-us");
			Thread.sleep(10000);
			//LDell User
			obj_EsupportIncidentsWorkflow.clickSignIn(driver);
			obj_EsupportIPSWorkflow.Emaillogin(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()).split(";")[2],TestNGCreator.TestData.get(Esupport.Password.ordinal()).split(";")[2]);
		//	obj_EsupportIPSWorkflow.verifyLdellPermissionMessage(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[0]);
			obj_EsupportIPSWorkflow.selectProductModel(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[0]);
			obj_EsupportIPSWorkflow.signOut(driver);
			obj_EsupportIncidentsWorkflow.clickChangeProductLink(driver);
			driver.get("https://www.dell.com/support/home/en-us");
			Thread.sleep(10000);
			//Lite User
			obj_EsupportIncidentsWorkflow.clickSignIn(driver);
			obj_EsupportIPSWorkflow.Emaillogin(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()).split(";")[3],TestNGCreator.TestData.get(Esupport.Password.ordinal()).split(";")[3]);
			obj_EsupportIPSWorkflow.clickBrowseAllProductsLink(driver);
			obj_EsupportIPSWorkflow.selectVmaxProductFromBrowseAll(driver);
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_7681006_AMER_ED_IPS_LEMCLiteusersshouldbeabletoaccessgenericmodelpages--------->\n  "+e);
		}
	}
}

