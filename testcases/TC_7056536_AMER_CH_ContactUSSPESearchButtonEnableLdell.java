package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_7056536_AMER_CH_ContactUSSPESearchButtonEnableLdell extends BaseTest 
{
	@Test
	public void validate_TC_7056536_AMER_CH_ContactUSSPESearchButtonEnableLdell() 
	{
		try
		{
			System.out.println("Starts TC_7056536_AMER_CH_ContactUSSPESearchButtonEnableLdell");
			
			obj_EsupportIncidentsWorkflow.validateCtsHomePage(driver);	
			obj_EsupportIncidentsWorkflow.validateSearchButtonDisabled(driver);		
			obj_EsupportIncidentsWorkflow.enterDataSearchTextbox(driver, TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));			
		}
		
		catch(Exception e)
		{
			Assert.fail("Failed while executing TC_7056536_AMER_CH_ContactUSSPESearchButtonEnableLdell--------->\n  "+e);
		}

	}
}
