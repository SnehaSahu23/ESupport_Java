package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_6490582_AMER_ED_Capturing_Date_Time_DeltaProblemField_ESUPPORT extends BaseTest {

	@Test
	public void validate_TC_6490582_AMER_ED_Capturing_Date_Time_DeltaProblemField_ESUPPORT() 
	{

		try
		{
			System.out.println("Starts TC# 6490582_AMER_ED");  
			obj_EsupportErevenueWorkflow.ToClick_ContactUS(driver);
			obj_EsupportErevenueWorkflow.ToClick_ContactTechnicalSupport(driver);
			obj_EsupportErevenueWorkflow.ToVerify_EnterServiceTag(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
			obj_EsupportErevenueWorkflow.ToClick_IssueTypeMalwareInstalled(driver);
			obj_EsupportErevenueWorkflow.ToEnter_Betterservicecomment_TimeSlots(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()));
			obj_EsupportErevenueWorkflow.ToClick_CartCheckOut(driver);
			obj_EsupportErevenueWorkflow.ToEnter_Userinformation(driver);
			obj_EsupportErevenueWorkflow.ToClick_Usethisaddress(driver);
			obj_EsupportErevenueWorkflow.ToEnter_creditcarddetails(driver);




			Thread.sleep(50000);

		}
		catch(Exception e){

			Assert.fail("Failed while executing test case TC_6490582_AMER_ED_Capturing_Date_Time_DeltaProblemField_ESUPPORT--------->\n  "+e);

		}

	}
}
