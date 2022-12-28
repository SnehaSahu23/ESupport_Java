package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_5775013_AMER_ED_EnterAServiceRequest_LEMCServiceRequest_Esupport extends BaseTest{
	
	@Test
	public void validate_TC_5775013_AMER_ED_EnterAServiceRequest_LEMCServiceRequest_Esupport(){
		
		try
		{
			System.out.println("Starting TC_5775013_AMER_ED_EnterAServiceRequest_LEMCServiceRequest_Esupport..."); 
			System.out.println("Integrated HomePage.");
			
            obj_EsupportIntegratedHomePageWorkflow.ToVerify_EnterLEMCSerialNumber(driver,TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));
            obj_EsupportIntegratedHomePageWorkflow.EmailloginEMCSerialnumber(driver,TestNGCreator.TestData.get(Esupport.Username.ordinal()),TestNGCreator.TestData.get(Esupport.Password.ordinal()));
            obj_EsupportIntegratedHomePageWorkflow.TOVerify_DellEMCProductSupportPage(driver);
               
			
		}catch(Exception e)
		{
			Assert.fail("Failed while executing test case TC_5775013_AMER_ED_EnterAServiceRequest_LEMCServiceRequest_Esupport--------->\n  "+e);
		}
		
	}
	
	

}
