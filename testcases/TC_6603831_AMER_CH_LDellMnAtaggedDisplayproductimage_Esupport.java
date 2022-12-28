package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_6603831_AMER_CH_LDellMnAtaggedDisplayproductimage_Esupport extends BaseTest
{
	@Test
	public void validate_TC_6603831_AMER_CH_LDellMnAtaggedDisplayproductimage_Esupport() 
	{
		try
		{
			System.out.println("Starts TC_6603831_AMER_CH_LDellMnAtaggedDisplayproductimage_Esupport");

			obj_EsupportIPSWorkflow.searchServiceTag(driver, TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[0]);
			obj_EsupportIPSWorkflow.verifyProductImageHeroSection(driver);

			//Scenario 2: Un authenticated   L Dell M & N products  
			for(int i=1; i<=3;i++)
			{
				obj_EsupportIPSWorkflow.navigateToURL(driver);
				obj_EsupportIPSWorkflow.searchServiceTag(driver, TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[i]);
				obj_EsupportIPSWorkflow.verifyProductImageHeroSection(driver);
			}
			
			//Scenario 3: Authenticated  L Dell products
			obj_EsupportIPSWorkflow.navigateToURL(driver);
			obj_EsupportIPSWorkflow.clickSignIn(driver);	
			obj_EsupportIPSWorkflow.Emaillogin(driver,  TestNGCreator.TestData.get(Esupport.Username.ordinal()),  TestNGCreator.TestData.get(Esupport.Password.ordinal()));
			obj_EsupportIPSWorkflow.searchServiceTag(driver, TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[4]);
			obj_EsupportIPSWorkflow.verifyProductImageHeroSection(driver);
			
			//Scenario 4: Authenticated  L Dell m & a  products
			for(int i=1; i<=3;i++)
			{
				obj_EsupportIPSWorkflow.navigateToURL(driver);
				obj_EsupportIPSWorkflow.searchServiceTag(driver, TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()).split(";")[i]);
				obj_EsupportIPSWorkflow.verifyProductImageHeroSection(driver);
			}
		}
		catch(Exception e)
		{
			Assert.fail("Failed in TC_6603831_AMER_CH_LDellMnAtaggedDisplayproductimage_Esupport--------->\n  "+e);
		}
	}
}

