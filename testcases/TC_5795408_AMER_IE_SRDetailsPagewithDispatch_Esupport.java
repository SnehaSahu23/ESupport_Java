package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_5795408_AMER_IE_SRDetailsPagewithDispatch_Esupport extends BaseTest 
{
	@Test
	public void validate_TC_5795408_AMER_IE_SRDetailsPagewithDispatch_Esupport() 
	{
		try
		{
			System.out.println("Starts TC_5795408_AMER_IE_SRDetailsPagewithDispatch_Esupport");
			obj_EsupportIncidentsWorkflow.navigateToSRPage(driver);		
			obj_EsupportIncidentsWorkflow.toEnter_ServiceTag(driver,TestNGCreator.TestData.get(Esupport.ActionOption.ordinal()),TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()),TestNGCreator.TestData.get(Esupport.Email.ordinal()));
			
			obj_EsupportIncidentsWorkflow.verifyServiceRequestActivity(driver);	
			obj_EsupportIncidentsWorkflow.verifyDispatchSection(driver);				
			obj_EsupportIncidentsWorkflow.clickDispatchSection(driver);
		}
		
		catch(Exception e)
		{
			Assert.fail("Failed while TC_5795408_AMER_IE_SRDetailsPagewithDispatch_Esupport--------->\n  "+e);
		}

	}
}
