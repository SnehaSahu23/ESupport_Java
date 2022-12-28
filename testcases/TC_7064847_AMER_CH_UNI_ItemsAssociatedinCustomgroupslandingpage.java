package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_7064847_AMER_CH_UNI_ItemsAssociatedinCustomgroupslandingpage extends BaseTest
{
	@Test
	public void validate_TC_7064847_AMER_CH_UNI_ItemsAssociatedinCustomgroupslandingpage() 
	{
		try
		{
			System.out.println("Starts TC_7064847_AMER_CH_UNI_ItemsAssociatedinCustomgroupslandingpage");
			Thread.sleep(10000);	
			obj_EsupportUnifiedPortalWorkflow.handleCookies(driver);
			obj_EsupportIPSWorkflow.Emaillogin(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			Thread.sleep(5000);	
			obj_EsupportUnifiedPortalWorkflow.clickCustomGroups(driver);
			Thread.sleep(5000);	
			obj_EsupportUnifiedPortalWorkflow.clickAnyItemLinkCustomGroup(driver);
			obj_EsupportUnifiedPortalWorkflow.clickItemLinkSitesCustomGroup(driver);
			obj_EsupportUnifiedPortalWorkflow.clickItemsPopupCloseButton(driver);
			obj_EsupportUnifiedPortalWorkflow.clickItemLinkProductsCustomGroup(driver);
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_7064847_AMER_CH_UNI_ItemsAssociatedinCustomgroupslandingpage--------->\n  "+e);
		}
	}
}
