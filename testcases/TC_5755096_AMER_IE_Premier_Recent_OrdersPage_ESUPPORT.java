package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_5755096_AMER_IE_Premier_Recent_OrdersPage_ESUPPORT extends BaseTest
{
	@Test
	public void validate_TC_5755096_AMER_IE_Premier_Recent_OrdersPage_ESUPPORT() 
	{

		try
		{
			System.out.println("Starts TC# 5755096_AMER_IE");
			driver.get("https://www.dell.com/support/orders/us/en/19?");
			obj_EsupportOrderHomeWorkflow.premierLogin(driver,TestNGCreator.TestData.get(Esupport.Account.ordinal()));
//			obj_EsupportOrderHomeWorkflow.handlePremierPopup(driver);
			obj_EsupportOrderHomeWorkflow.launchURL(driver, "https://www.dell.com/support/orders/us/en/19?");
			driver.get(driver.getCurrentUrl());
			Thread.sleep(7000);
//			obj_EsupportOrderHomeWorkflow.handlePremierPopup(driver);
			obj_EsupportRecentOrderWorkflow.clickOrderStatusLink(driver);
			
			obj_EsupportRecentOrderWorkflow.PROrderHeader(driver);
			
			obj_EsupportOrderHomeWorkflow.handleCookies(driver);
			obj_EsupportRecentOrderWorkflow.selectTimeframe(driver, TestNGCreator.TestData.get(Esupport.TimeFrameSelected.ordinal()).split(";")[3]);
			obj_EsupportRecentOrderWorkflow.RecentOrdercolumns(driver);
			obj_EsupportRecentOrderWorkflow.CustomerNumberRecentOrder(driver);
			obj_EsupportRecentOrderWorkflow.StatusRecentOrder(driver);
			obj_EsupportRecentOrderWorkflow.timeFrameRecentOrder(driver);
			obj_EsupportRecentOrderWorkflow.SearchboxradioOrderPO(driver);
			obj_EsupportRecentOrderWorkflow.CalenderFromdateApplyReset(driver);
			obj_EsupportRecentOrderWorkflow.itemsPerpagedropdown(driver);
			obj_EsupportRecentOrderWorkflow.OptinsDPIDdisplayUS(driver);
			obj_EsupportRecentOrderWorkflow.SelectAnActionDropdown(driver);
			
			obj_EsupportRecentOrderWorkflow.Clickonanyorders(driver);
			//obj_EsupportOrderHomeWorkflow.handleCookies(driver);
			obj_EsupportRecentOrderWorkflow.PurchasedetailsHeader(driver);
			obj_EsupportRecentOrderWorkflow.selectTimeframe(driver, TestNGCreator.TestData.get(Esupport.TimeFrameSelected.ordinal()).split(";")[4]);
		//	obj_EsupportOrderHomeWorkflow.handleCookies(driver);
			obj_EsupportRecentOrderWorkflow.Orderdateandordernumbersortingbutton(driver);
			driver.navigate().refresh();
			obj_EsupportRecentOrderWorkflow.selectTimeframe(driver, TestNGCreator.TestData.get(Esupport.TimeFrameSelected.ordinal()).split(";")[4]);
			obj_EsupportRecentOrderWorkflow.Toclick_verifyPOnumber(driver);
		//	obj_EsupportOrderHomeWorkflow.handleCookies(driver);
			obj_EsupportRecentOrderWorkflow.Recentorderheader(driver);
			obj_EsupportRecentOrderWorkflow.SearchboxradioOrderPO(driver);
			obj_EsupportOrderHomeWorkflow.handleCookies(driver);
			obj_EsupportRecentOrderWorkflow.searchTo_SearchboxradioOrderPO(driver,TestNGCreator.TestData.get(Esupport.PONumber.ordinal()));
			obj_EsupportRecentOrderWorkflow.searchTo_SearchboxradioOrderPOReset(driver);
			obj_EsupportRecentOrderWorkflow.ToVerify_clickOptinsTaggle(driver);
			obj_EsupportRecentOrderWorkflow.ToVerify_selectedPoNumberinToggle(driver);
			obj_EsupportRecentOrderWorkflow.ToVerify_PQATLink(driver);
			obj_EsupportRecentOrderWorkflow.RecentorderheaderSerachform(driver);

			obj_EsupportRecentOrderWorkflow.ToVerify_Actionsddshippedanddelivered(driver,TestNGCreator.TestData.get(Esupport.StatusSelected.ordinal()).split(",")[0]);
			//obj_EsupportRecentOrderWorkflow.ToVerify_Actionsddshippedanddelivered(driver,TestNGCreator.TestData.get(Esupport.StatusSelected.ordinal()).split(",")[1]);
			obj_EsupportRecentOrderWorkflow.ToVerify_PackingslipforalldaysForPONumber(driver,TestNGCreator.TestData.get(Esupport.StatusSelected.ordinal()).split(",")[0],TestNGCreator.TestData.get(Esupport.PONumber.ordinal()).split(";")[0],TestNGCreator.TestData.get(Esupport.TimeFrameSelected.ordinal()).split(";")[4],TestNGCreator.TestData.get(Esupport.ActionsSelected.ordinal()).split(";")[0]);
			obj_EsupportRecentOrderWorkflow.ToVerify_PackingslipforalldaysForOrderNum(driver,TestNGCreator.TestData.get(Esupport.StatusSelected.ordinal()).split(",")[0],TestNGCreator.TestData.get(Esupport.OrderNumber.ordinal()).split(";")[0],TestNGCreator.TestData.get(Esupport.TimeFrameSelected.ordinal()).split(";")[4],TestNGCreator.TestData.get(Esupport.ActionsSelected.ordinal()).split(";")[1]);

			obj_EsupportRecentOrderWorkflow.ToVerify_PackingslipforalldaysForOrderNum(driver,TestNGCreator.TestData.get(Esupport.StatusSelected.ordinal()).split(",")[1],TestNGCreator.TestData.get(Esupport.OrderNumber.ordinal()).split(";")[1],TestNGCreator.TestData.get(Esupport.TimeFrameSelected.ordinal()).split(";")[4],TestNGCreator.TestData.get(Esupport.ActionsSelected.ordinal()).split(";")[2]);


			Thread.sleep(3000);
		}
		catch(Exception e){

			Assert.fail("Failed while executing test case TC_5755096_AMER_IE_Premier_Recent_OrdersPage_ESUPPORT--------->\n  "+e);

		}

	}
}
