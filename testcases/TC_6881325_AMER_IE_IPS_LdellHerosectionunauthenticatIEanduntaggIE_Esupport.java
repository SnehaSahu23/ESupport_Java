package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_6881325_AMER_IE_IPS_LdellHerosectionunauthenticatIEanduntaggIE_Esupport extends BaseTest
{
	@Test
	public void validate_TC_6881325_AMER_IE_IPS_LdellHerosectionunauthenticatIEanduntaggIE_Esupport() 
	{
		try
		{
			System.out.println("Starts TC_6881325_AMER_IE_IPS_LdellHerosectionunauthenticatIEanduntaggIE_Esupport");


			obj_EsupportIPSWorkflow.clickBrowseAllProductsLink(driver);
			obj_EsupportIPSWorkflow.clickLaptopsLink(driver);
			obj_EsupportIPSWorkflow.clickLatitudeLink(driver);
			obj_EsupportIPSWorkflow.clickLatitudeSeries(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[0]);
			obj_EsupportIPSWorkflow.clickLatitudeSubProduct(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()).split(";")[1]);
			//obj_EsupportIPSWorkflow.clickLatitudeSubProduct(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal()));
			obj_EsupportIPSWorkflow.verifyProductImageHeroSection(driver);
			obj_EsupportIPSWorkflow.verifyEnterServiceTagLink(driver);
			obj_EsupportIPSWorkflow.verifyChangeProductLink(driver);
			obj_EsupportIPSWorkflow.clickEnterServiceTagLink(driver);
			obj_EsupportIPSWorkflow.clickEnterServiceTagPopupCloseButton(driver);
			obj_EsupportIPSWorkflow.clickEnterServiceTagLink(driver);			
			obj_EsupportIPSWorkflow.enterServiceTagModalPopup(driver, TestNGCreator.TestData.get(Esupport.ServiceTag.ordinal()));	
		}
		catch(Exception e)
		{
			Assert.fail("FailIE in TC_6881325_AMER_IE_IPS_LdellHerosectionunauthenticatIEanduntaggIE_Esupport--------->\n  "+e);
		}
	}
}
