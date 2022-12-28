package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_6324359_AMER_ED_Softwarerepairofferwhenskipissueselection_Esupport extends BaseTest {

	@Test
	public void validate_TC_6324359_AMER_ED_Softwarerepairofferwhenskipissueselection_Esupport() 
	{

		try
		{
			System.out.println("Starts TC_6324359_AMER_ED_Softwarerepairofferwhenskipissueselection_Esupport");  
			obj_EsupportErevenueWorkflow.ToClick_ContactUS(driver);
			obj_EsupportErevenueWorkflow.ToClick_ContactTechnicalSupport(driver);
			obj_EsupportErevenueWorkflow.ToVerify_EnterServiceTag(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
			
			obj_EsupportErevenueWorkflow.clickSkipLink(driver);
			
			obj_EsupportErevenueWorkflow.displayContactOptionsList(driver);
			
			Thread.sleep(10000);
		}
		catch(Exception e)
		{
			Assert.fail("Failed while executing test case TC_6324359_AMER_ED_Softwarerepairofferwhenskipissueselection_Esupport--------->\n  "+e);

		}

	}
}


