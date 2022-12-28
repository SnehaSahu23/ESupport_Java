package com.dell.delta_uat_automation.esupport.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dell.delta_uat_automation.utility.Esupport;
import com.dell.delta_uat_automation.utility.TestNGCreator;

public class TC_8594469_AMER_CH_GOS_ProductionAutomation_ESUPPORT extends BaseTest{
	@Test
	public void validate_TC_8594469_AMER_CH_GOS_ProductionAutomation_ESUPPORT() 
	{

		try
		{
			System.out.println("Starts TC_8594469_AMER_CH_GOS_ProductionAutomation_ESUPPORT");
			
			//Test case ID 5755096
			
			obj_EsupportOrderHomeWorkflow.premierLogin(driver,TestNGCreator.TestData.get(Esupport.Account.ordinal()));

			obj_EsupportOrderHomeWorkflow.launchURL(driver, "https://www.dell.com/support/orders/us/en/19?");

			obj_EsupportRecentOrderWorkflow.clickOrderStatusLink(driver);
			
			obj_EsupportRecentOrderWorkflow.PROrderHeader(driver);
			
			obj_EsupportRecentOrderWorkflow.selectTimeframe(driver, TestNGCreator.TestData.get(Esupport.TimeFrameSelected.ordinal()).split(";")[0]);
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
			
			obj_EsupportRecentOrderWorkflow.PurchasedetailsHeader(driver);
			obj_EsupportRecentOrderWorkflow.selectTimeframe(driver, TestNGCreator.TestData.get(Esupport.TimeFrameSelected.ordinal()).split(";")[0]);
		
			obj_EsupportRecentOrderWorkflow.Orderdateandordernumbersortingbutton(driver);
			driver.navigate().refresh();
			obj_EsupportRecentOrderWorkflow.selectTimeframe(driver, TestNGCreator.TestData.get(Esupport.TimeFrameSelected.ordinal()).split(";")[0]);
			obj_EsupportRecentOrderWorkflow.Toclick_verifyPOnumber(driver);
		
			obj_EsupportRecentOrderWorkflow.Recentorderheader(driver);
			obj_EsupportRecentOrderWorkflow.SearchboxradioOrderPO(driver);
			
			obj_EsupportRecentOrderWorkflow.searchTo_SearchboxradioOrderPO(driver,TestNGCreator.TestData.get(Esupport.PONumber.ordinal()));
			obj_EsupportRecentOrderWorkflow.searchTo_SearchboxradioOrderPOReset(driver);
			obj_EsupportRecentOrderWorkflow.ToVerify_clickOptinsTaggle(driver);
			obj_EsupportRecentOrderWorkflow.ToVerify_selectedPoNumberinToggle(driver);
			obj_EsupportRecentOrderWorkflow.ToVerify_PQATLink(driver);
			obj_EsupportRecentOrderWorkflow.RecentorderheaderSerachform(driver);

			obj_EsupportRecentOrderWorkflow.ToVerify_Actionsddshippedanddelivered(driver,TestNGCreator.TestData.get(Esupport.StatusSelected.ordinal()).split(",")[0]);
			obj_EsupportRecentOrderWorkflow.ToVerify_PackingslipforalldaysForPONumber(driver,TestNGCreator.TestData.get(Esupport.StatusSelected.ordinal()).split(",")[0],TestNGCreator.TestData.get(Esupport.PONumber.ordinal()).split(";")[0],TestNGCreator.TestData.get(Esupport.TimeFrameSelected.ordinal()).split(";")[5],TestNGCreator.TestData.get(Esupport.ActionsSelected.ordinal()).split(";")[0]);
			obj_EsupportRecentOrderWorkflow.ToVerify_PackingslipforalldaysForOrderNum(driver,TestNGCreator.TestData.get(Esupport.StatusSelected.ordinal()).split(",")[0],TestNGCreator.TestData.get(Esupport.OrderNumber.ordinal()).split(";")[0],TestNGCreator.TestData.get(Esupport.TimeFrameSelected.ordinal()).split(";")[5],TestNGCreator.TestData.get(Esupport.ActionsSelected.ordinal()).split(";")[1]);

			obj_EsupportRecentOrderWorkflow.ToVerify_PackingslipforalldaysForOrderNum(driver,TestNGCreator.TestData.get(Esupport.StatusSelected.ordinal()).split(",")[0],TestNGCreator.TestData.get(Esupport.OrderNumber.ordinal()).split(";")[0],TestNGCreator.TestData.get(Esupport.TimeFrameSelected.ordinal()).split(";")[5],TestNGCreator.TestData.get(Esupport.ActionsSelected.ordinal()).split(";")[2]);


			Thread.sleep(3000);
			
			//Test case ID 5755162
			
//			obj_EsupportOrderHomeWorkflow.premierLogin(driver,TestNGCreator.TestData.get(Esupport.Account.ordinal())); 
			
			obj_EsupportOrderHomeWorkflow.launchURL(driver, "https://www.dell.com/support/orders/us/en/19?");

			obj_EsupportRecentOrderWorkflow.selectTimeframe(driver, TestNGCreator.TestData.get(Esupport.TimeFrameSelected.ordinal()));
			obj_EsupportOrderHomeWorkflow.exportToExcel(driver);
			
			//Test case ID 5755229(do it from here)
//			obj_EsupportOrderHomeWorkflow.premierLogin(driver,TestNGCreator.TestData.get(Esupport.Account.ordinal())); 
			
			obj_EsupportOrderHomeWorkflow.launchURL(driver, "https://www.dell.com/support/orders/us/en/19?");

			
			obj_EsupportRecentOrderWorkflow.selectTimeframe(driver, TestNGCreator.TestData.get(Esupport.TimeFrameSelected.ordinal()));
			obj_EsupportRecentOrderWorkflow.premierActionDropdown(driver,TestNGCreator.TestData.get(Esupport.ActionOption.ordinal()));
			obj_EsupportRecentOrderWorkflow.handlePremierStatusDropdown(driver, TestNGCreator.TestData.get(Esupport.StatusOption.ordinal()));
			obj_EsupportRecentOrderWorkflow.handleCheckbox(driver,true);	
			obj_EsupportRecentOrderWorkflow.handleSubscribePopup(driver, true);
			System.out.println("****************************************");
			System.out.println("****************************************");
			obj_EsupportRecentOrderWorkflow.handleCheckbox(driver,false);
			obj_EsupportRecentOrderWorkflow.handleSubscribePopup(driver, false);
			Thread.sleep(6000);
			
			//Test case ID 6033890
			
//			obj_EsupportOrderHomeWorkflow.premierLogin(driver,TestNGCreator.TestData.get(Esupport.Account.ordinal()));

			obj_EsupportOrderHomeWorkflow.launchURL(driver, "https://www.dell.com/support/orders/us/en/19?");

			
			obj_EsupportRecentOrderWorkflow.PROrderHeader(driver);
			obj_EsupportOrderHomeWorkflow.handleCookies(driver);
			obj_EsupportRecentOrderWorkflow.RecentOrdercolumns(driver);
			obj_EsupportRecentOrderWorkflow.CustomerNumberRecentOrder(driver);
			obj_EsupportRecentOrderWorkflow.StatusRecentOrder(driver);
			obj_EsupportRecentOrderWorkflow.timeFrameRecentOrder(driver);
			obj_EsupportRecentOrderWorkflow.SearchboxradioOrderPO(driver);
			obj_EsupportRecentOrderWorkflow.CalenderFromdateApplyReset(driver);
			obj_EsupportRecentOrderWorkflow.itemsPerpagedropdown(driver);
			obj_EsupportRecentOrderWorkflow.OptinsIRNdisplayEMEA(driver);
			obj_EsupportRecentOrderWorkflow.SelectAnActionDropdown(driver);
			obj_EsupportRecentOrderWorkflow.Clickonanyorders(driver);
			obj_EsupportOrderHomeWorkflow.handleCookies(driver);
			obj_EsupportRecentOrderWorkflow.PurchasedetailsHeader(driver);
			obj_EsupportOrderHomeWorkflow.handleCookies(driver);
			obj_EsupportRecentOrderWorkflow.Orderdateandordernumbersortingbutton(driver);
			obj_EsupportRecentOrderWorkflow.Toclick_verifyPOnumber(driver);
			obj_EsupportOrderHomeWorkflow.handleCookies(driver);
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
			obj_EsupportRecentOrderWorkflow.ToVerify_PackingslipforalldaysForPONumber(driver,TestNGCreator.TestData.get(Esupport.StatusSelected.ordinal()).split(",")[0],TestNGCreator.TestData.get(Esupport.PONumber.ordinal()).split(";")[0],TestNGCreator.TestData.get(Esupport.TimeFrameSelected.ordinal()).split(";")[5],TestNGCreator.TestData.get(Esupport.ActionsSelected.ordinal()).split(";")[0]);
			obj_EsupportRecentOrderWorkflow.ToVerify_PackingslipforalldaysForOrderNum(driver,TestNGCreator.TestData.get(Esupport.StatusSelected.ordinal()).split(",")[0],TestNGCreator.TestData.get(Esupport.OrderNumber.ordinal()).split(";")[0],TestNGCreator.TestData.get(Esupport.TimeFrameSelected.ordinal()).split(";")[5],TestNGCreator.TestData.get(Esupport.ActionsSelected.ordinal()).split(";")[1]);

			obj_EsupportRecentOrderWorkflow.ToVerify_PackingslipforalldaysForOrderNum(driver,TestNGCreator.TestData.get(Esupport.StatusSelected.ordinal()).split(",")[0],TestNGCreator.TestData.get(Esupport.OrderNumber.ordinal()).split(";")[0],TestNGCreator.TestData.get(Esupport.TimeFrameSelected.ordinal()).split(";")[5],TestNGCreator.TestData.get(Esupport.ActionsSelected.ordinal()).split(";")[2]);


			Thread.sleep(3000);
			
			//Test case ID 6033943
			
//			obj_EsupportOrderHomeWorkflow.premierLogin(driver,TestNGCreator.TestData.get(Esupport.Account.ordinal()));
			obj_EsupportOrderHomeWorkflow.launchURL(driver, "https://www.dell.com/support/orders/us/en/19?");

			obj_EsupportRecentOrderWorkflow.selectTimeframe(driver, TestNGCreator.TestData.get(Esupport.TimeFrameSelected.ordinal()));
			obj_EsupportOrderHomeWorkflow.exportToExcel(driver);
			
			//Test case ID 6033951
			
//			obj_EsupportOrderHomeWorkflow.premierLogin(driver, TestNGCreator.TestData.get(Esupport.Account.ordinal()) );
			obj_EsupportOrderHomeWorkflow.launchURL(driver, "https://www.dell.com/support/orders/us/en/19?");

			obj_EsupportRecentOrderWorkflow.selectTimeframe(driver, TestNGCreator.TestData.get(Esupport.TimeFrameSelected.ordinal()));
			obj_EsupportRecentOrderWorkflow.premierActionDropdown(driver,TestNGCreator.TestData.get(Esupport.ActionOption.ordinal()));
			obj_EsupportRecentOrderWorkflow.handleCheckbox(driver,true);	
			obj_EsupportRecentOrderWorkflow.handleSubscribePopup(driver, true);
			obj_EsupportRecentOrderWorkflow.handleCheckbox(driver,false);
			obj_EsupportRecentOrderWorkflow.handleSubscribePopup(driver, false);
			Thread.sleep(6000);
			
			//Test case ID 5782755
			
//			 obj_EsupportOrderHomeWorkflow.premierLogin(driver,TestNGCreator.TestData.get(Esupport.Account.ordinal())); 
//			 obj_EsupportOrderHomeWorkflow.handleCookies(driver);
			 obj_EsupportOrderHomeWorkflow.launchURL(driver, "https://www.dell.com/support/orders/us/en/19?");
			 obj_EsupportRecentOrderWorkflow.clickOrderStatusLink_CHMASTORE(driver);
			 obj_EsupportOrderHomeWorkflow.handleCookies(driver);
			 obj_EsupportRecentOrderWorkflow.VerifyRecentOrdersPage(driver);
			 obj_EsupportRecentOrderWorkflow.Clickordernumber(driver,TestNGCreator.TestData.get(Esupport.TimeFrameSelected.ordinal()).split(";")[4]);
			 
			 
			//Test case ID 5781216
//			 obj_EsupportOrderHomeWorkflow.launchURL(driver, "https://www.dell.com/support/orders/us/en/19?");
//			 obj_EsupportOrderHomeWorkflow.premierLogin(driver,TestNGCreator.TestData.get(Esupport.Account.ordinal())); 
				
			 obj_EsupportOrderHomeWorkflow.launchURL(driver, "https://www.dell.com/support/orders/us/en/19?");

			 obj_EsupportRecentOrderWorkflow.PROrderHeader(driver);
			
			 obj_EsupportRecentOrderWorkflow.Clickonanyorders(driver);
			 obj_EsupportOrderHomeWorkflow.handleCookies(driver);
			 obj_EsupportRecentOrderWorkflow.TOVerify_PurchasedetailsHeader(driver);
			 obj_EsupportRecentOrderWorkflow.TOVerify_clickonPOActionslabelwithviewdifferentorder(driver);
			 
			//Test case ID 5782254
				
//	         obj_EsupportOrderHomeWorkflow.premierLogin(driver,TestNGCreator.TestData.get(Esupport.Account.ordinal()));
	         obj_EsupportOrderHomeWorkflow.launchURL(driver, "https://www.dell.com/support/orders/us/en/19/Invoice/List?c=us&l=en&s=gen");
				

	         obj_EsupportRecentOrderWorkflow.calendarVerification(driver);
	         
	       //Test case ID 6107708
				
//				obj_EsupportOrderHomeWorkflow.premierLogin(driver,TestNGCreator.TestData.get(Esupport.Account.ordinal()));

				obj_EsupportOrderHomeWorkflow.launchURL(driver, "https://www.dell.com/support/orders/us/en/19?");

				obj_EsupportRecentOrderWorkflow.PROrderHeader(driver);
				obj_EsupportOrderHomeWorkflow.handleCookies(driver);

				obj_EsupportRecentOrderWorkflow.ToVerify_PQATLink(driver);
				obj_EsupportRecentOrderWorkflow.TOverify_RecentorderheaderSerachform(driver,TestNGCreator.TestData.get(Esupport.PONumber.ordinal()).split(";")[0],TestNGCreator.TestData.get(Esupport.PONumber.ordinal()).split(";")[1]);

				
				
				
				//Test case ID 6107700
				
				String[] Ponumber=TestNGCreator.TestData.get(Esupport.PONumber.ordinal()).split(";");
				
//				obj_EsupportOrderHomeWorkflow.premierLogin(driver,TestNGCreator.TestData.get(Esupport.Account.ordinal()));

				obj_EsupportOrderHomeWorkflow.launchURL(driver, "https://www.dell.com/support/orders/us/en/19?");

				obj_EsupportRecentOrderWorkflow.clickOnPonumberRadio(driver);
				obj_EsupportRecentOrderWorkflow.EnterPONumberwithspecialCharacters(driver,Ponumber[0]);
				obj_EsupportRecentOrderWorkflow.clickOnreset(driver);
				obj_EsupportRecentOrderWorkflow.EnterPONumberwithLowercase(driver,Ponumber[1]);
				
				//Test case ID 6033966
				
//				obj_EsupportOrderHomeWorkflow.premierLogin(driver,TestNGCreator.TestData.get(Esupport.Account.ordinal()));
				obj_EsupportOrderHomeWorkflow.launchURL(driver, "https://www.dell.com/support/orders/us/en/19?");

				obj_EsupportRecentOrderWorkflow.PROrderHeader(driver);
				obj_EsupportOrderHomeWorkflow.handleCookies(driver);
				obj_EsupportRecentOrderWorkflow.RecentOrdercolumns(driver);
				obj_EsupportRecentOrderWorkflow.CustomerNumberRecentOrder(driver);
				obj_EsupportRecentOrderWorkflow.StatusRecentOrder(driver);
				obj_EsupportRecentOrderWorkflow.timeFrameRecentOrder(driver);
				obj_EsupportRecentOrderWorkflow.SearchboxradioOrderPO(driver);
				obj_EsupportRecentOrderWorkflow.CalenderFromdateApplyReset(driver);
				obj_EsupportRecentOrderWorkflow.itemsPerpagedropdown(driver);
				
				obj_EsupportRecentOrderWorkflow.OptinsIRNdisplayEMEA(driver);
				obj_EsupportRecentOrderWorkflow.SelectAnActionDropdown(driver);
				obj_EsupportRecentOrderWorkflow.Clickonanyorders(driver);
				obj_EsupportOrderHomeWorkflow.handleCookies(driver);
				obj_EsupportRecentOrderWorkflow.PurchasedetailsHeader(driver);
				obj_EsupportOrderHomeWorkflow.handleCookies(driver);
				obj_EsupportRecentOrderWorkflow.Orderdateandordernumbersortingbutton(driver);
				obj_EsupportRecentOrderWorkflow.Toclick_verifyPOnumber(driver);
				obj_EsupportOrderHomeWorkflow.handleCookies(driver);
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
				obj_EsupportRecentOrderWorkflow.ToVerify_Actionsddshippedanddelivered(driver,TestNGCreator.TestData.get(Esupport.StatusSelected.ordinal()).split(",")[1]);
				
				obj_EsupportRecentOrderWorkflow.ToVerify_PackingslipforalldaysForPONumber(driver,TestNGCreator.TestData.get(Esupport.StatusSelected.ordinal()).split(",")[0],TestNGCreator.TestData.get(Esupport.PONumber.ordinal()).split(";")[0],TestNGCreator.TestData.get(Esupport.TimeFrameSelected.ordinal()).split(";")[5],TestNGCreator.TestData.get(Esupport.ActionsSelected.ordinal()).split(";")[0]);
				obj_EsupportRecentOrderWorkflow.ToVerify_PackingslipforalldaysForOrderNum(driver,TestNGCreator.TestData.get(Esupport.StatusSelected.ordinal()).split(",")[0],TestNGCreator.TestData.get(Esupport.OrderNumber.ordinal()).split(";")[0],TestNGCreator.TestData.get(Esupport.TimeFrameSelected.ordinal()).split(";")[5],TestNGCreator.TestData.get(Esupport.ActionsSelected.ordinal()).split(";")[1]);

				obj_EsupportRecentOrderWorkflow.ToVerify_PackingslipforalldaysForOrderNum(driver,TestNGCreator.TestData.get(Esupport.StatusSelected.ordinal()).split(",")[0],TestNGCreator.TestData.get(Esupport.OrderNumber.ordinal()).split(";")[0],TestNGCreator.TestData.get(Esupport.TimeFrameSelected.ordinal()).split(";")[5],TestNGCreator.TestData.get(Esupport.ActionsSelected.ordinal()).split(";")[2]);

				Thread.sleep(3000);

				
				//Test case ID 6034039
				
//				obj_EsupportOrderHomeWorkflow.premierLogin(driver,TestNGCreator.TestData.get(Esupport.Account.ordinal())); 
				obj_EsupportOrderHomeWorkflow.launchURL(driver, "https://www.dell.com/support/orders/us/en/19?");
				obj_EsupportOrderHomeWorkflow.exportToExcel(driver);
				obj_EsupportProductionValidationsWorkflow.signOut(driver);
	         
			//Test case ID 5755260
			 obj_EsupportOrderHomeWorkflow.launchURL(driver, "https://www.dell.com/support/orders/us/en/19?");
			 obj_EsupportOrderHomeWorkflow.orderHomePage(driver);
			 obj_EsupportOrderHomeWorkflow.enterOrderNumber(driver, TestNGCreator.TestData.get(Esupport.OrderNumber.ordinal()));

				
			//Test case ID 5755292
			 obj_EsupportOrderHomeWorkflow.launchURL(driver, "https://www.dell.com/support/orders/us/en/19?");
			 obj_EsupportOrderHomeWorkflow.orderHomePage(driver);
			 obj_EsupportOrderHomeWorkflow.clickOnLookupOptions(driver);
			 obj_EsupportOrderHomeWorkflow.selectLookupOptions(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal())); 
			 obj_EsupportOrderHomeWorkflow.clickOnSubmit(driver);

			 obj_EsupportRecentOrderWorkflow.orderDetails(driver);  
			
			//Test case ID 5755309
			 obj_EsupportOrderHomeWorkflow.launchURL(driver, "https://www.dell.com/support/orders/us/en/19?");
			 obj_EsupportOrderHomeWorkflow.orderHomePage(driver);
			 obj_EsupportOrderHomeWorkflow.clickOnLookupOptions(driver);
			 obj_EsupportOrderHomeWorkflow.selectLookupOptions(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal())); 
			 obj_EsupportOrderHomeWorkflow.clickOnSubmit(driver);

			 obj_EsupportRecentOrderWorkflow.orderDetails(driver);
				
			//Test case ID 5755323
			 obj_EsupportOrderHomeWorkflow.launchURL(driver, "https://www.dell.com/support/orders/us/en/19?");
			 obj_EsupportOrderHomeWorkflow.orderHomePage(driver);
			 obj_EsupportOrderHomeWorkflow.clickOnLookupOptions(driver);
			 obj_EsupportOrderHomeWorkflow.selectLookupOptions(driver,TestNGCreator.TestData.get(Esupport.SearchOption.ordinal())); 
			 obj_EsupportOrderHomeWorkflow.clickOnSubmit(driver);
			 obj_EsupportOrderHomeWorkflow.handleCookies(driver);
//			 obj_EsupportOrderHomeWorkflow.handleCaptcha(driver);
			 obj_EsupportOrderHomeWorkflow.handleCookies(driver);
			 obj_EsupportRecentOrderWorkflow.orderDetails(driver);
			
			
			 
			//Test case ID 5781258
			
			 obj_EsupportOrderHomeWorkflow.launchURL(driver, "https://www.dell.com/support/orders/us/en/19?");
			 obj_EsupportOrderHomeWorkflow.orderHomePage(driver);
	         obj_EsupportOrderHomeWorkflow.enterOrderNumber(driver, TestNGCreator.TestData.get(Esupport.OrderNumber.ordinal()));
	         obj_EsupportOrderHomeWorkflow.handleCookies(driver);
	         obj_EsupportOrderHomeWorkflow.handleCaptcha_PurchaseOrder(driver);
	         obj_EsupportRecentOrderWorkflow.TOVerify_PurchasedetailsHeader(driver);
			 obj_EsupportOrderHomeWorkflow.handleCookies(driver);
				
	         obj_EsupportRecentOrderWorkflow.TOVerify_clickonotherlookupoptions(driver);
	            
			

				
			//Test case ID 5782402
			
	         obj_EsupportOrderHomeWorkflow.launchURL(driver, "https://www.dell.com/support/orders/us/en/19?");
	         obj_EsupportIPSWorkflow.clickSignIn(driver);
			 obj_EsupportIntegratedHomePageWorkflow.Emaillogin(driver,  TestNGCreator.TestData.get(Esupport.Username.ordinal()),  TestNGCreator.TestData.get(Esupport.Password.ordinal()));

			obj_EsupportRecentOrderWorkflow.ToVerify_notselectedPoNumberinToggle(driver);
			obj_EsupportRecentOrderWorkflow.PROrderHeader(driver);
			obj_EsupportOrderHomeWorkflow.handleCookies(driver);
			obj_EsupportRecentOrderWorkflow.RecentOrdercolumns(driver);

			obj_EsupportRecentOrderWorkflow.StatusRecentOrder(driver);
			obj_EsupportRecentOrderWorkflow.timeFrameRecentOrder(driver);

			
			obj_EsupportRecentOrderWorkflow.itemsPerpagedropdown(driver);
			obj_EsupportRecentOrderWorkflow.OptinsDPIDdisplayUS(driver);
			obj_EsupportRecentOrderWorkflow.SelectAnActionDropdown(driver);

			obj_EsupportRecentOrderWorkflow.ToVerify_notselectedPoNumberinToggle(driver);
			obj_EsupportRecentOrderWorkflow.Clickonanyorders(driver);
			obj_EsupportOrderHomeWorkflow.handleCookies(driver);
			obj_EsupportRecentOrderWorkflow.PurchasedetailsHeader(driver);
			obj_EsupportOrderHomeWorkflow.handleCookies(driver);


			obj_EsupportRecentOrderWorkflow.ToVerify_clickOptinsTaggle(driver);



			Thread.sleep(3000);
			
			
		}
		catch(Exception e){

			Assert.fail("Failed while executing test case TC_8594469_AMER_CH_GOS_ProductionAutomation_ESUPPORT--------->\n  "+e);

		}

	}

}
