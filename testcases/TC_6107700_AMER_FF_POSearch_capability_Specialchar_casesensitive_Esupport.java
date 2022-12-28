package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_6107700_AMER_FF_POSearch_capability_Specialchar_casesensitive_Esupport extends BaseTest {
	@Test
	public void validate_TC_6107700_AMER_FF_POSearch_capability_Specialchar_casesensitive_Esupport() 
	{

		try
		{
			System.out.println("Starts TC# TC_6107700_AMER_FF_POSearch_capability_Specialchar_casesensitive_Esupport");
			driver.get("https://www.dell.com/support/orders/us/en/19?");
			String[] Ponumber=TestNGCreator.TestData.get(Esupport.PONumber.ordinal()).split(";");
			//  obj_EsupportOrderHomeWorkflow.premierLogin(driver,TestNGCreator.TestData.get(Esupport.Account.ordinal()));
			obj_EsupportOrderHomeWorkflow.premierLogin(driver,TestNGCreator.TestData.get(Esupport.Account.ordinal()));

			obj_EsupportOrderHomeWorkflow.launchURL(driver, "https://www.dell.com/support/orders/us/en/19?");
//			obj_EsupportOrderHomeWorkflow.handlePremierPopup(driver);
//			obj_EsupportRecentOrderWorkflow.clickOrderStatusLink(driver);
			obj_EsupportRecentOrderWorkflow.clickOnPonumberRadio(driver);
			obj_EsupportRecentOrderWorkflow.EnterPONumberwithspecialCharacters(driver,Ponumber[0]);
			obj_EsupportRecentOrderWorkflow.clickOnreset(driver);
			obj_EsupportRecentOrderWorkflow.EnterPONumberwithLowercase(driver,Ponumber[1]);




		}
		catch(Exception e){

			Assert.fail("Failed while executing test case TC_6107700_AMER_FF_POSearch_capability_Specialchar_casesensitive_Esupport--------->\n  "+e);

		}

	}

}
