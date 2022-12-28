package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_8876603_AMER_ED_Coveo_Story8084627_AllowUserToselectsingleproductforfilter_ESUPPORT extends BaseTest{
	@Test
	public void validate_TC_8876603_AMER_ED_Coveo_Story8084627_AllowUserToselectsingleproductforfilter_ESUPPORT() 
	{

		try
		{
			System.out.println("Starts TC_8876603_AMER_ED_Coveo_Story8084627_AllowUserToselectsingleproductforfilter_ESUPPORT");
			
			
			obj_EsupportCoveoWorkflow.ProductCategorySectionValidation(driver);
			
		}
		catch(Exception e){

			Assert.fail("Failed while executing test case TC_8876603_AMER_ED_Coveo_Story8084627_AllowUserToselectsingleproductforfilter_ESUPPORT--------->\n  "+e);

		}

	}
}
