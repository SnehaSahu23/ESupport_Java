package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_5786129_AMER_ED_Testfor_FindAddProducts_ESUPPORT extends BaseTest {
	@Test
	public void validate_TC_5786129_AMER_ED_Testfor_FindAddProducts_ESUPPORT() 
	{

		try
		{
			System.out.println("Starts TC# 5786129_AMER_ED");
			//Thread.sleep(10000);
			obj_EsupportMPSWorkflow.MPSLogin(driver);
			obj_EsupportMPSWorkflow.ALLTabsMPSPage(driver);
			obj_EsupportMPSWorkflow.ClickonFindProducts(driver);
			obj_EsupportMPSWorkflow.ToSelect_Servicetag(driver);
			obj_EsupportMPSWorkflow.ToDeleteServiceTag_Productlink(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));

			obj_EsupportMPSWorkflow.ToEnterService_ClickFIndProducts(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
			obj_EsupportMPSWorkflow.ToVerifyViewProductLink(driver);

			obj_EsupportMPSWorkflow.ToVerifyServiceTag_inProductlink(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));

			//commented below as per Prakash's comments
//			obj_EsupportMPSWorkflow.clickOnFindAddProduct(driver);
//			obj_EsupportMPSWorkflow.selectCustomerNumber(driver);
//			obj_EsupportMPSWorkflow.TOselect_CustomerNumber(driver);
//			obj_EsupportMPSWorkflow.clickOnFindAddProduct(driver);
//			obj_EsupportMPSWorkflow.selectOrderNumber(driver);
//			obj_EsupportMPSWorkflow.TOselect_OrderNumber(driver);

			obj_EsupportMPSWorkflow.clickOnFindAddProduct(driver);

			obj_EsupportMPSWorkflow.TOVerify_ChooseFile(driver);





			Thread.sleep(3000);


		}
		catch(Exception e){

			Assert.fail("Failed while executing test case TC_5786129_AMER_ED_Testfor_FindAddProducts_ESUPPORT--------->\n  "+e);

		}

	}

}

