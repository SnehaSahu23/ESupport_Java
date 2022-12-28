package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_5836502_AMER_FF_SupportSearch_IntegratedUX_Up_FilterPagination_implementation_ESUPPORT extends BaseTest{
	@Test
	public void validate_TC_5836502_AMER_FF_SupportSearch_IntegratedUX_Up_FilterPagination_implementation_ESUPPORT() 
	{

		try
		{
			System.out.println("Starts TC# TC_5836502_AMER_FF_SupportSearch_IntegratedUX_Up_FilterPagination_implementation_ESUPPORT"); 
			obj_EsupportCoveoWorkflow.searchResultfornosound(driver,TestNGCreator.TestData.get(Esupport.SupportValue.ordinal()));
			obj_EsupportCoveoWorkflow.ToVerify_clickKnowledgebase(driver);
			obj_EsupportCoveoWorkflow.ToVerify_YourFilters(driver);
			obj_EsupportCoveoWorkflow.ToVerify_Paginationvalues(driver);
			obj_EsupportCoveoWorkflow.ToVerify_PaginationvaluesPerPage(driver);
			obj_EsupportCoveoWorkflow.ToVerify_PrevandNextbuttonicon(driver);
			obj_EsupportCoveoWorkflow.ToVerify_TablesdataHundred(driver,"100");
			obj_EsupportCoveoWorkflow.ToVerify_TablesdataFifty(driver,"50");
			obj_EsupportCoveoWorkflow.ToVerify_TablesdataTwentyfive(driver,"25");
			obj_EsupportCoveoWorkflow.ToVerify_Tablesdata(driver,"10");
			obj_EsupportCoveoWorkflow.ToVerify_ByRelevance(driver); 
			obj_EsupportCoveoWorkflow.ToVerify_Datefunctiondescending(driver,"Descending Order");
			obj_EsupportCoveoWorkflow.ToVerify_DatefunctionAscending(driver,"Ascending Order");


		}catch(Exception e)
		{
			Assert.fail("Failed while executing test case TC_5836502_AMER_FF_SupportSearch_IntegratedUX_Up_FilterPagination_implementation_ESUPPORT--------->\n  "+e);
		}
	}
}
