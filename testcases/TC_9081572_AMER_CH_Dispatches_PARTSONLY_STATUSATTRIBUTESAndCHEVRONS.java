package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_9081572_AMER_CH_Dispatches_PARTSONLY_STATUSATTRIBUTESAndCHEVRONS extends BaseTest 
{
	@Test
	public void validate_TC_9081572_AMER_CH_Dispatches_PARTSONLY_STATUSATTRIBUTESAndCHEVRONS() 
	{

		try
		{
			System.out.println("Starts TC_9081572_AMER_CH_Dispatches_PARTSONLY_STATUSATTRIBUTESAndCHEVRONS");
			
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
			obj_EsupportIncidentsWorkflow.verifyWorkOrderTile(driver);
			obj_EsupportIncidentsWorkflow.verifyPartsOrderedSection(driver);
			obj_EsupportIncidentsWorkflow.verifyPartsShippedSection(driver);
			obj_EsupportIncidentsWorkflow.verifyPartsDeliveredSection(driver);
			obj_EsupportIncidentsWorkflow.verifyClosedSection(driver);
			Thread.sleep(3000);
			driver.get("http://www.dell.com/support/incidents-online/us/en/19/srsearch");
			obj_EsupportIncidentsWorkflow.selectSearchOption(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()), TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[1]);
			obj_EsupportIncidentsWorkflow.enterValidEmailAndVerifyHeader(driver, TestNGCreator.TestData.get(Esupport.Email.ordinal()).split(";")[2]);
			Thread.sleep(5000);
			obj_EsupportIncidentsWorkflow.verifyCancelledSection(driver);
			obj_EsupportIncidentsWorkflow.verifyCustomerInformation(driver);
		}
		catch(Exception e)
		{

			Assert.fail("Failed while TC_9081572_AMER_CH_Dispatches_PARTSONLY_STATUSATTRIBUTESAndCHEVRONS--------->\n  "+e);

		}

	}
}
