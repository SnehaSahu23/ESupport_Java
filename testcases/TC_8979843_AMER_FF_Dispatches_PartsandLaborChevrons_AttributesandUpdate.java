package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_8979843_AMER_FF_Dispatches_PartsandLaborChevrons_AttributesandUpdate extends BaseTest 
{
	@Test
	public void validate_TC_8979843_AMER_FF_Dispatches_PartsandLaborChevrons_AttributesandUpdate() 
	{

		try
		{
			System.out.println("Starts TC_8979843_AMER_FF_Dispatches_PartsandLaborChevrons_AttributesandUpdate");
			
			driver.get("http://www.dell.com/support/incidents-online/us/en/19/srsearch");
			obj_EsupportIncidentsWorkflow.selectSearchOption(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()), TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[0]);
			obj_EsupportIncidentsWorkflow.verifySubmitButtonDisabled(driver);
			obj_EsupportIncidentsWorkflow.enterInvalidEmailAndVerifyMessage(driver, TestNGCreator.TestData.get(Esupport.Email.ordinal()).split(";")[0]);
			obj_EsupportIncidentsWorkflow.clickSearchButton(driver);
			obj_EsupportIncidentsWorkflow.enterValidEmailAndVerifyHeader(driver, TestNGCreator.TestData.get(Esupport.Email.ordinal()).split(";")[1]);
			obj_EsupportIncidentsWorkflow.verifySRPageDetails(driver);
			obj_EsupportIncidentsWorkflow.verifyProductDetails(driver);
			obj_EsupportIncidentsWorkflow.verifyServiceRequestDetails(driver);
			obj_EsupportIncidentsWorkflow.verifyServiceStatusDetails(driver);
			obj_EsupportIncidentsWorkflow.clickViewDetailsLinkSRPage(driver);
			obj_EsupportIncidentsWorkflow.clickShowMoreDetailsLinkSRPage(driver);
			obj_EsupportIncidentsWorkflow.verifyWorkOrderTile(driver);
			obj_EsupportIncidentsWorkflow.verifyPartsAndLaborPartsOrderedSection(driver);
			obj_EsupportIncidentsWorkflow.verifyPartsAndLaborServiceScheduledSection(driver);
			obj_EsupportIncidentsWorkflow.verifyPartsAndLaborPartsShippedSection(driver);
			obj_EsupportIncidentsWorkflow.verifyPartsAndLaborPartsDeliveredSection(driver);
			obj_EsupportIncidentsWorkflow.verifyPartsAndLaborTechnicianEnrouteSection(driver);
			obj_EsupportIncidentsWorkflow.verifyWorkInProgressSection(driver);
			Thread.sleep(3000);
			driver.get("http://www.dell.com/support/incidents-online/us/en/19/srsearch");
			obj_EsupportIncidentsWorkflow.selectSearchOption(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()), TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[1]);
			obj_EsupportIncidentsWorkflow.enterValidEmailAndVerifyHeader(driver, TestNGCreator.TestData.get(Esupport.Email.ordinal()).split(";")[2]);
			Thread.sleep(5000);
			obj_EsupportIncidentsWorkflow.verifyPartsAndLaborClosedSection(driver);
			obj_EsupportIncidentsWorkflow.verifyCustomerInformation(driver);
		}
		catch(Exception e)
		{

			Assert.fail("Failed while TC_8979843_AMER_FF_Dispatches_PartsandLaborChevrons_AttributesandUpdate--------->\n  "+e);

		}

	}
}