package com.dell.delta_uat_automation.esupport.testcases;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;
public class TC_5775184_AMER_CH_Authentication_VerifyUnauthenticatedPage_ExternalLinks_Esupport extends BaseTest
{
	@Test
	public void validate_TC_5775184_AMER_CH_Authentication_VerifyUnauthenticatedPage_ExternalLinks_Esupport() 
	{

		try
		{
			System.out.println("Starts TC# _5775184_AMER_CH");

			obj_EsupportDDLWorkflow.ToVerify_DDLPage(driver);
			obj_EsupportDDLWorkflow.ToVerify_DDlClickablelinks(driver);
			obj_EsupportDDLWorkflow.ToVerify_ProductSupportpage(driver);
			obj_EsupportDDLWorkflow.ToVerify_TrailSoftwarepage(driver);
			obj_EsupportDDLWorkflow.ToVerify_OwnershipTransferLinkepage(driver);
			obj_EsupportDDLWorkflow.ToVerify_OrderSupportLinkepage(driver);


		}catch(Exception e)
		{
			Assert.fail("Failed while executing test case TC_5775184_AMER_CH_Authentication_VerifyUnauthenticatedPage_ExternalLinks_Esupport--------->\n  "+e);
		}
	}
}
