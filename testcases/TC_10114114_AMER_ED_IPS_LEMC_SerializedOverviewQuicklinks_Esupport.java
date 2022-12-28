package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_10114114_AMER_ED_IPS_LEMC_SerializedOverviewQuicklinks_Esupport extends BaseTest
{
	@Test
	public void validate_TC_10114114_AMER_ED_IPS_LEMC_SerializedOverviewQuicklinks_Esupport() throws Throwable 
	{
		try
		{
			System.out.println("Starts TC_10114114_AMER_ED_IPS_LEMC_SerializedOverviewQuicklinks_Esupport");
			obj_EsupportIncidentsWorkflow.clickSignIn(driver);
			obj_EsupportIncidentsWorkflow.ToLogin_ValidCredentials(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			Thread.sleep(5000);
			obj_EsupportIPSWorkflow.ClickSearchServiceTag(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[0]);
			
			obj_EsupportIPSWorkflow.verifyOverviewTabDetails_QuickLinks_2(driver);
			
			obj_EsupportIPSWorkflow.VerifyLinkForRequestEquipmentRefresh(driver);
			obj_EsupportIPSWorkflow.ClickOnLinkForRequestEquipmentRefresh(driver);
			obj_EsupportIPSWorkflow.ClickOnCancelButtonInRequestEquipmentRequest(driver);
			obj_EsupportIPSWorkflow.ClickOnAddToCustomGroups(driver);
			obj_EsupportIPSWorkflow.ClickOnViewAllAssets(driver);
			
			obj_EsupportIPSWorkflow.clickGetSupportNotificationLink(driver);
			
			// after submitting  request equiment refresh
			obj_EsupportIPSWorkflow.clickChangeProductLink(driver);
			obj_EsupportIPSWorkflow.ClickSearchServiceTag(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[1]);
						
			obj_EsupportIPSWorkflow.verifyOverviewTabDetails_QuickLinks_3(driver);
			
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_10114114_AMER_ED_IPS_LEMC_SerializedOverviewQuicklinks_Esupport--------->\n  "+e);
		}
	}
}
