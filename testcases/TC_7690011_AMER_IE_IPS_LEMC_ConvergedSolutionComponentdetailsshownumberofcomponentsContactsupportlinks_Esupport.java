package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_7690011_AMER_IE_IPS_LEMC_ConvergedSolutionComponentdetailsshownumberofcomponentsContactsupportlinks_Esupport  extends BaseTest
{
	@Test
	public void validate_TC_7690011_AMER_IE_IPS_LEMC_ConvergedSolutionComponentdetailsshownumberofcomponentsContactsupportlinks_Esupport() 
	{
		try
		{
			System.out.println("Starts TC_7690011_AMER_IE_IPS_LEMC_ConvergedSolutionComponentdetailsshownumberofcomponentsContactsupportlinks_Esupport");

			obj_EsupportIncidentsWorkflow.clickSignIn(driver);
			obj_EsupportIPSWorkflow.clickSignInHereLink(driver);
			obj_EsupportIPSWorkflow.searchServiceTag(driver, TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
			obj_EsupportIPSWorkflow.verifyOverviewTabDetails_CountOfComponents(driver);
			obj_EsupportIPSWorkflow.verifyOverviewTabDetails_QuickLinks_2(driver);
			obj_EsupportIPSWorkflow.ContactTechnicalSection(driver);
			obj_EsupportIPSWorkflow.clickContactTechnicalSupportLink(driver);
			obj_EsupportIPSWorkflow.verifyOverviewTabDetails_MoreResources(driver);
			obj_EsupportIPSWorkflow.signOut(driver);	
		}
		catch(Exception e)
		{
			Assert.fail("Failed executing TC_7690011_AMER_IE_IPS_LEMC_ConvergedSolutionComponentdetailsshownumberofcomponentsContactsupportlinks_Esupport--------->\n  "+e);
		}
	}
}