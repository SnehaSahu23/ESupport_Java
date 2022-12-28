package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_5795613_AMER_ED_FindDifferentOrderLink_Esupport extends BaseTest {
	@Test
	public void validate_TC_5795613_AMER_ED_FindDifferentOrderLink_Esupport() 
	{

		try
		{
			System.out.println("Starts TC_5795613_AMER_ED_FindDifferentOrderLink_Esupport");
			obj_EsupportIncidentsWorkflow.ToVerify_ContanctOrderSupport(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
			obj_EsupportIncidentsWorkflow.search_OrderNumber(driver,TestNGCreator.TestData.get(Esupport.OrderNumber.ordinal()));
			obj_EsupportIncidentsWorkflow.verifyDifferentOrderLink(driver);

		}
		catch(Exception e)
		{

			Assert.fail("Failed while TC_5795613_AMER_ED_FindDifferentOrderLink_Esupport--------->\n  "+e);

		}

	}
}

