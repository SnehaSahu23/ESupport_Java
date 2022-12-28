package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_5781148_AMER_FF_ChangeProductlink_ESUPPORT extends BaseTest 
{
	@Test
	public void validate_TC_5781148_AMER_FF_ChangeProductlink_ESUPPORT() 
	{

		try
		{
			System.out.println("Starts TC_5781148_AMER_FF_ChangeProductlink_ESUPPORT");

			obj_EsupportIncidentsWorkflow.ToVerify_EnterServiceTagChangeProductLink(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
			obj_EsupportIncidentsWorkflow.ToVerify_EnterServiceTag(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));



		}
		catch(Exception e)
		{

			Assert.fail("Failed while TC_5781148_AMER_FF_ChangeProductlink_ESUPPORT--------->\n  "+e);

		}

	}
}
