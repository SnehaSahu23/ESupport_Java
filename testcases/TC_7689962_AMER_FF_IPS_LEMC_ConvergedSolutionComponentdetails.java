package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_7689962_AMER_FF_IPS_LEMC_ConvergedSolutionComponentdetails extends BaseTest
{
	@Test
	public void validate_TC_7689962_AMER_FF_IPS_LEMC_ConvergedSolutionComponentdetails() 
	{
		try
		{
			System.out.println("Starts TC_7689962_AMER_FF_IPS_LEMC_ConvergedSolutionComponentdetails");
			obj_EsupportIPSWorkflow.handleCookies(driver);

//			obj_EsupportIPSWorkflow.closeContactUsSlider(driver);

			obj_EsupportIncidentsWorkflow.clickSignIn(driver);
			obj_EsupportIPSWorkflow.clickSignInHereLink(driver);
			Thread.sleep(5000);
			
			obj_EsupportIPSWorkflow.searchServiceTag(driver, TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
			obj_EsupportIPSWorkflow.verifyHeroSectionSoftwareTaggedProduct_two(driver);
			obj_EsupportIPSWorkflow.VerifyTheLocationOfTheProduct(driver);
			obj_EsupportIPSWorkflow.verifyOverviewTabDetails_CountOfComponents(driver);		
			obj_EsupportIPSWorkflow.SortingColumnsOfComponenetDetails(driver);	
			obj_EsupportIPSWorkflow.validateSearchSectionOfComponentDetails(driver, TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()));	

		}
		catch(Exception e)
		{
			Assert.fail("Failed executing TC_7689962_AMER_FF_IPS_LEMC_ConvergedSolutionComponentdetails--------->\n  "+e);
		}
	}
}