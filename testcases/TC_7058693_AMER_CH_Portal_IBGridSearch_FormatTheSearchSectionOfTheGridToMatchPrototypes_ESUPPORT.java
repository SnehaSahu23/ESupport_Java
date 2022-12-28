package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_7058693_AMER_CH_Portal_IBGridSearch_FormatTheSearchSectionOfTheGridToMatchPrototypes_ESUPPORT extends BaseTest
{
	@Test
	public void validate_TC_7058693_AMER_CH_Portal_IBGridSearch_FormatTheSearchSectionOfTheGridToMatchPrototypes_ESUPPORT() 
	{
		try
		{
			System.out.println("Starts TC_7058693_AMER_CH_Portal_IBGridSearch_FormatTheSearchSectionOfTheGridToMatchPrototypes_ESUPPORT");
				
			obj_EsupportPortalWorkflow.handleCookies(driver);
			obj_EsupportIPSWorkflow.Emaillogin(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			obj_EsupportPortalWorkflow.ValidateTabsInPortalView(driver);
			obj_EsupportPortalWorkflow.ClickOnInstallBaseTab(driver);
			
			obj_EsupportPortalWorkflow.ValidateGridColumnsWhenUserSelectedContractsFromLeftMenu(driver);
			
			obj_EsupportPortalWorkflow.VerifySearchBoxOnLeftLowerSideOfTheGrid(driver);
			
			obj_EsupportPortalWorkflow.VerifySearchBoxSearchingAnyCharacters(driver);
			
			
			
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_7058693_AMER_CH_Portal_IBGridSearch_FormatTheSearchSectionOfTheGridToMatchPrototypes_ESUPPORT--------->\n  "+e);
		}
	}
}