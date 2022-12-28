package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_7510740_AMER_CH_ServiceEvents_LEMC_serializedServiceEventstab_collapsefilters extends BaseTest
{
	@Test
	public void validate_TC_7510740_AMER_CH_ServiceEvents_LEMC_serializedServiceEventstab_collapsefilters() 
	{
		try
		{
			System.out.println("Starts TC_7510740_AMER_CH_ServiceEvents_LEMC_serializedServiceEventstab_collapsefilters");
			obj_EsupportServiceEventsWorkflow.handleCookies(driver);
			obj_EsupportIncidentsWorkflow.clickSignIn(driver);
			obj_EsupportIPSWorkflow.Emaillogin(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			obj_EsupportServiceEventsWorkflow.ClickSearchServiceTag(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
			obj_EsupportServiceEventsWorkflow.clickOnServiceEventsTab_LEMC(driver);
			obj_EsupportServiceEventsWorkflow.verifyEventTypesSETabLeftPanel_LEMC(driver);
			obj_EsupportServiceEventsWorkflow.ClickExpandIconNextToEachEventTypeAndValidateCollapseIconOnLeftPanel(driver);
			obj_EsupportServiceEventsWorkflow.ClickCollapseIconNextToEachEventTypeAndValidateExpandIconOnLeftPanel(driver);
			
			obj_EsupportServiceEventsWorkflow.ClickExpandAllOnLeftPanel(driver);
			
			obj_EsupportServiceEventsWorkflow.ValidateForCollapseAllButtonDisplaysAfterClickingOnExpandButton(driver);
			
			
			obj_EsupportServiceEventsWorkflow.ClickOnCollapseAllOnLeftPanel(driver);
	
			
			obj_EsupportServiceEventsWorkflow.ValidateForExpandAllButtonDisplaysAfterClickingOnCollapseAllButton(driver);
	
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_7510740_AMER_CH_ServiceEvents_LEMC_serializedServiceEventstab_collapsefilters--------->\n  "+e);
		}
	}
}
