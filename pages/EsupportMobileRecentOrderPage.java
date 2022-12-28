package com.dell.delta_uat_automation.esupport.pages;

import org.openqa.selenium.By;

import com.dell.delta_uat_automation.utility.CommonUtility;

public class EsupportMobileRecentOrderPage extends EsupportMobilePojo {
	public By recentOrdersLabel() throws Exception
	{

		return CommonUtility.getLocator_Mobile(RecentOrderPage_Data.get("RecentOrdersLabel"));
	}


	public By orderDate() throws Exception
	{

		return CommonUtility.getLocator_Mobile(RecentOrderPage_Data.get("OrderDate"));
	}

	public By dellPurchaseId() throws Exception
	{

		return CommonUtility.getLocator_Mobile(RecentOrderPage_Data.get("DellPurchaseId"));
	}

	public By orderStatus() throws Exception
	{

		return CommonUtility.getLocator_Mobile(RecentOrderPage_Data.get("OrderStatus"));
	}

	public By estimatedDelivery() throws Exception
	{

		return CommonUtility.getLocator_Mobile(RecentOrderPage_Data.get("EstimatedDelivery"));
	}

	public By description() throws Exception
	{

		return CommonUtility.getLocator_Mobile(RecentOrderPage_Data.get("Description"));
	}

	public By orderNumber() throws Exception
	{

		return CommonUtility.getLocator_Mobile(RecentOrderPage_Data.get("OrderNumber"));
	}
	//sneha
	public By PreOrderStatusLink() throws Exception {

		return CommonUtility.getLocator_Mobile(RecentOrderPage_Data.get("PreOrderStatusLink"));
	} 

	public By PreSelectAnAction() throws Exception {

		return CommonUtility.getLocator_Mobile(RecentOrderPage_Data.get("PreSelectAnAction"));
	} 

	public By PremierRecentOrdersTag() throws Exception {

		return CommonUtility.getLocator_Mobile(RecentOrderPage_Data.get("PremierRecentOrdersTag"));
	}

	public By PreSubmit() throws Exception {

		return CommonUtility.getLocator_Mobile(RecentOrderPage_Data.get("PreSubmit"));
	} 

	public By preSelectAnActionValues() throws Exception {

		return CommonUtility.getLocator_Mobile(RecentOrderPage_Data.get("PreSelectAnActionValues"));
	} 
	//pushpa
	public By premierOrderStatusLink() throws Exception
	{

		return CommonUtility.getLocator_Mobile(RecentOrderPage_Data.get("PremierOrderStatusLink"));
	}
	public By premierPopup() throws Exception
	{

		return CommonUtility.getLocator_Mobile(RecentOrderPage_Data.get("PremierPopup"));
	}
	//sujatha

	public By Columnordernumberclick() throws Exception {

		return CommonUtility.getLocator_Mobile(RecentOrderPage_Data.get("Columnordernumberclick"));
	}
	public By Puchasedetailsgheader() throws Exception {

		return CommonUtility.getLocator_Mobile(RecentOrderPage_Data.get("Puchasedetailsgheader"));
	}

	public By countrydefaultselection() throws Exception {

		return CommonUtility.getLocator_Mobile(RecentOrderPage_Data.get("Countrydefaultselection"));
	}
	public By customerdefaultselection() throws Exception {

		return CommonUtility.getLocator_Mobile(RecentOrderPage_Data.get("Customerdefaultselection"));
	}
	public By statusselection() throws Exception {

		return CommonUtility.getLocator_Mobile(RecentOrderPage_Data.get("Statusselection"));
	}

	//pushpa
	public By subscribeEmailAddress() throws Exception
	{

		return CommonUtility.getLocator_Mobile(RecentOrderPage_Data.get("SubscribeEmailAddress"));
	}

	public By subscribeLabel() throws Exception
	{

		return CommonUtility.getLocator_Mobile(RecentOrderPage_Data.get("SubscribeLabel"));
	}

	public By addEmailButton() throws Exception
	{

		return CommonUtility.getLocator_Mobile(RecentOrderPage_Data.get("AddEmailButton"));
	}

	public By subscribeSubmitButton() throws Exception
	{

		return CommonUtility.getLocator_Mobile(RecentOrderPage_Data.get("SubscribeSubmitButton"));
	}

	public By subscribeSuccessMessage() throws Exception
	{

		return CommonUtility.getLocator_Mobile(RecentOrderPage_Data.get("SubscribeSuccessMessage"));
	}

	public By subscribeCloseButton() throws Exception
	{

		return CommonUtility.getLocator_Mobile(RecentOrderPage_Data.get("SubscribeCloseButton"));
	}

	public By errorMessage() throws Exception
	{

		return CommonUtility.getLocator_Mobile(RecentOrderPage_Data.get("ErrorMessage"));
	}

	public By emailErrorMessage() throws Exception
	{

		return CommonUtility.getLocator_Mobile(RecentOrderPage_Data.get("EmailErrorMessage"));
	}

	public By subscribeCancelButton() throws Exception
	{

		return CommonUtility.getLocator_Mobile(RecentOrderPage_Data.get("SubscribeCancelButton"));
	}
	public By premierStatusDropdown() throws Exception
	{

		return CommonUtility.getLocator_Mobile(RecentOrderPage_Data.get("PremierStatusDropdown"));
	}

	public By selectAllCheckbox() throws Exception
	{

		return CommonUtility.getLocator_Mobile(RecentOrderPage_Data.get("SelectAllCheckbox"));
	}

	public By premierSubmitButton() throws Exception
	{

		return CommonUtility.getLocator_Mobile(RecentOrderPage_Data.get("PremierSubmitButton"));
	}
	public By premierRecentOrdersLabel() throws Exception
	{

		return CommonUtility.getLocator_Mobile(RecentOrderPage_Data.get("PremierRecentOrdersLabel"));
	}

	public By selectActionDropDown() throws Exception
	{

		return CommonUtility.getLocator_Mobile(RecentOrderPage_Data.get("SelectActionDropDown"));
	} 
	//SNEHA
	public By AccountLink() throws Exception {

		return CommonUtility.getLocator_Mobile(RecentOrderPage_Data.get("AccountLink"));
	} 

	public By ViewandShareReportLink() throws Exception {

		return CommonUtility.getLocator_Mobile(RecentOrderPage_Data.get("ViewandShareReportLink"));
	} 

	public By PremierInvoicingReportLink() throws Exception {

		return CommonUtility.getLocator_Mobile(RecentOrderPage_Data.get("PremierInvoicingReportLink"));
	}

	public By InvoiceLink() throws Exception {

		return CommonUtility.getLocator_Mobile(RecentOrderPage_Data.get("InvoiceLink"));
	}

	public By InvoiceNumberTag() throws Exception {

		return CommonUtility.getLocator_Mobile(RecentOrderPage_Data.get("InvoiceNumberTag"));
	}

	public By FromDateClick() throws Exception {

		return CommonUtility.getLocator_Mobile(RecentOrderPage_Data.get("FromDateClick"));
	}

	public By ToDateClick() throws Exception {

		return CommonUtility.getLocator_Mobile(RecentOrderPage_Data.get("ToDateClick"));
	}

	public By SelectMonthClick() throws Exception {

		return CommonUtility.getLocator_Mobile(RecentOrderPage_Data.get("SelectMonthClick"));
	}

	public By SelectPrecedingMonth() throws Exception {

		return CommonUtility.getLocator_Mobile(RecentOrderPage_Data.get("SelectPrecedingMonth"));
	}

	public By FirstDateClick() throws Exception {

		return CommonUtility.getLocator_Mobile(RecentOrderPage_Data.get("FirstDateClick"));
	}

	public By LastDateClick() throws Exception {

		return CommonUtility.getLocator_Mobile(RecentOrderPage_Data.get("LastDateClick"));
	}


	public By NoRecord() throws Exception {

		return CommonUtility.getLocator_Mobile(RecentOrderPage_Data.get("NoRecord"));
	}

	//sujatha




	public By RecentOrdercolumnsheader() throws Exception {

		return CommonUtility.getLocator_Mobile(RecentOrderPage_Data.get("RecentOrdercolumnsheader"));
	}

	public By RecentOrdercolumnsheaderlinks() throws Exception {

		return CommonUtility.getLocator_Mobile(RecentOrderPage_Data.get("RecentOrdercolumnsheaderlinks"));
	}


	public By CustomerNumberDD() throws Exception {

		return CommonUtility.getLocator_Mobile(RecentOrderPage_Data.get("CustomerNumberDD"));
	}

	public By CustomerNumberDDoptions() throws Exception {

		return CommonUtility.getLocator_Mobile(RecentOrderPage_Data.get("CustomerNumberDDoptions"));
	}







	public By StatusDD() throws Exception {

		return CommonUtility.getLocator_Mobile(RecentOrderPage_Data.get("StatusDD"));
	}


	public By StatusDDoptions() throws Exception {

		return CommonUtility.getLocator_Mobile(RecentOrderPage_Data.get("StatusDDoptions"));
	}

	public By TimeFrameDDdefaultselection() throws Exception {

		return CommonUtility.getLocator_Mobile(RecentOrderPage_Data.get("TimeFrameDDdefaultselection"));
	}

	public By Searchtextbox() throws Exception {

		return CommonUtility.getLocator_Mobile(RecentOrderPage_Data.get("Searchtextbox"));
	}


	public By SearchtextboxOrderNumber() throws Exception {

		return CommonUtility.getLocator_Mobile(RecentOrderPage_Data.get("SearchtextboxOrderNumber"));
	}

	public By SearchtextboxPONumber() throws Exception {

		return CommonUtility.getLocator_Mobile(RecentOrderPage_Data.get("SearchtextboxPONumber"));
	}


	public By FromDatetext() throws Exception {

		return CommonUtility.getLocator_Mobile(RecentOrderPage_Data.get("FromDatetext"));
	}

	public By Fromdatecalender() throws Exception {

		return CommonUtility.getLocator_Mobile(RecentOrderPage_Data.get("Fromdatecalender"));
	}

	public By TODatetext() throws Exception {

		return CommonUtility.getLocator_Mobile(RecentOrderPage_Data.get("TODatetext"));
	}

	public By TOdatecalender() throws Exception {

		return CommonUtility.getLocator_Mobile(RecentOrderPage_Data.get("TOdatecalender"));
	}


	public By ApplyButton() throws Exception {

		return CommonUtility.getLocator_Mobile(RecentOrderPage_Data.get("ApplyButton"));
	}

	public By ResetButton() throws Exception {

		return CommonUtility.getLocator_Mobile(RecentOrderPage_Data.get("ResetButton"));
	}
	public By Itemsperpage() throws Exception {

		return CommonUtility.getLocator_Mobile(RecentOrderPage_Data.get("Itemsperpage"));
	}

	public By Itemsperpageoptions() throws Exception {

		return CommonUtility.getLocator_Mobile(RecentOrderPage_Data.get("Itemsperpageoptions"));
	}

	public By Optionstoggle() throws Exception {

		return CommonUtility.getLocator_Mobile(RecentOrderPage_Data.get("Optionstoggle"));
	}

	public By OptionstoggleDPID() throws Exception {

		return CommonUtility.getLocator_Mobile(RecentOrderPage_Data.get("OptionstoggleDPID"));
	}

	public By SelectanactionsDD() throws Exception {

		return CommonUtility.getLocator_Mobile(RecentOrderPage_Data.get("SelectanactionsDD"));
	}

	public By SelectanactionsDDoptions() throws Exception {

		return CommonUtility.getLocator_Mobile(RecentOrderPage_Data.get("SelectanactionsDDoptions"));
	}


	public By orderdatesortingbutton() throws Exception {

		return CommonUtility.getLocator_Mobile(RecentOrderPage_Data.get("orderdatesortingbutton"));
	}

	public By ordernumbersortingbutton() throws Exception {

		return CommonUtility.getLocator_Mobile(RecentOrderPage_Data.get("ordernumbersortingbutton"));
	}


	public By clickonPONumber() throws Exception {

		return CommonUtility.getLocator_Mobile(RecentOrderPage_Data.get("clickonPONumber"));
	}

	public By PONumbercolumnheader() throws Exception {

		return CommonUtility.getLocator_Mobile(RecentOrderPage_Data.get("PONumbercolumnheader"));
	}


	public By PONumbertoggleclicked() throws Exception {

		return CommonUtility.getLocator_Mobile(RecentOrderPage_Data.get("PONumbertoggleclicked"));
	}

	public By Estimateddeliverytoggleclicked() throws Exception {

		return CommonUtility.getLocator_Mobile(RecentOrderPage_Data.get("Estimateddeliverytoggleclicked"));
	}




	public By Searchiconpoordernumber() throws Exception {

		return CommonUtility.getLocator_Mobile(RecentOrderPage_Data.get("Searchiconpoordernumber"));
	}


	public By Searchiconponumberlink() throws Exception {

		return CommonUtility.getLocator_Mobile(RecentOrderPage_Data.get("Searchiconponumberlink"));
	}

	public By Toggledropdownverifytext() throws Exception {

		return CommonUtility.getLocator_Mobile(RecentOrderPage_Data.get("Toggledropdownverifytext"));
	}


	public By Toggledropdownverifytextoption() throws Exception {

		return CommonUtility.getLocator_Mobile(RecentOrderPage_Data.get("Toggledropdownverifytextoption"));
	}

	public By PONumbertoggleclickedtext() throws Exception {

		return CommonUtility.getLocator_Mobile(RecentOrderPage_Data.get("PONumbertoggleclickedtext"));
	}

	public By PQATTextdislayed() throws Exception {

		return CommonUtility.getLocator_Mobile(RecentOrderPage_Data.get("PQATTextdislayed"));
	}
	public By PQATTextdislayedsearchformlink() throws Exception {

		return CommonUtility.getLocator_Mobile(RecentOrderPage_Data.get("PQATTextdislayedsearchformlink"));
	}

	public By ShippedActionsDropdownclick() throws Exception {

		return CommonUtility.getLocator_Mobile(RecentOrderPage_Data.get("ShippedActionsDropdownclick"));
	}
	public By ShippedActionsDropdownclickoptions() throws Exception {

		return CommonUtility.getLocator_Mobile(RecentOrderPage_Data.get("ShippedActionsDropdownclickoptions"));
	}


	public By Statustoggleclicked() throws Exception {

		return CommonUtility.getLocator_Mobile(RecentOrderPage_Data.get("Statustoggleclicked"));
	}

	public By Descriptiontoggleclicked() throws Exception {

		return CommonUtility.getLocator_Mobile(RecentOrderPage_Data.get("Descriptiontoggleclicked"));
	}
	public By Actiontoggleclicked() throws Exception {

		return CommonUtility.getLocator_Mobile(RecentOrderPage_Data.get("Actiontoggleclicked"));
	}


	public By Returnmessage() throws Exception {

		return CommonUtility.getLocator_Mobile(RecentOrderPage_Data.get("Returnmessage"));
	}
	//sujatha



	public By PurchaseOrderpageActionheader() throws Exception {

		return CommonUtility.getLocator_Mobile(RecentOrderPage_Data.get("PurchaseOrderpageActionheader"));
	}

	public By Actionviewdifferentorder() throws Exception {

		return CommonUtility.getLocator_Mobile(RecentOrderPage_Data.get("Actionviewdifferentorder"));
	}

	public By Orderpagepermierorder() throws Exception {

		return CommonUtility.getLocator_Mobile(RecentOrderPage_Data.get("Orderpagepermierorder"));
	}

	public By Orderpagepermierordertext() throws Exception {

		return CommonUtility.getLocator_Mobile(RecentOrderPage_Data.get("Orderpagepermierordertext"));
	}
	public By Orderpageorder() throws Exception {

		return CommonUtility.getLocator_Mobile(RecentOrderPage_Data.get("Orderpageorder"));
	}

	public By Orderpageordertext() throws Exception {

		return CommonUtility.getLocator_Mobile(RecentOrderPage_Data.get("Orderpageordertext"));
	}

	public By LookByPremierOrder() throws Exception {

		return CommonUtility.getLocator_Mobile(RecentOrderPage_Data.get("LookByPremierOrder"));
	}

	public By LookByOrder() throws Exception {

		return CommonUtility.getLocator_Mobile(RecentOrderPage_Data.get("LookByOrder"));
	}


	public By LookByPremierOrderselect() throws Exception {

		return CommonUtility.getLocator_Mobile(RecentOrderPage_Data.get("LookByPremierOrderselect"));
	}

	public By LookByPremierOrderselectoptions() throws Exception {

		return CommonUtility.getLocator_Mobile(RecentOrderPage_Data.get("LookByPremierOrderselectoptions"));
	}

	public By LookByOrderselect() throws Exception {

		return CommonUtility.getLocator_Mobile(RecentOrderPage_Data.get("LookByOrderselect"));
	}

	public By LookByOrderselectoptions() throws Exception {

		return CommonUtility.getLocator_Mobile(RecentOrderPage_Data.get("LookByOrderselectoptions"));
	}



	public By LookByOtherserachoptions() throws Exception {

		return CommonUtility.getLocator_Mobile(RecentOrderPage_Data.get("LookByOtherserachoptions"));
	}
	public By LookByOtherserachoptionspopup() throws Exception {

		return CommonUtility.getLocator_Mobile(RecentOrderPage_Data.get("LookByOtherserachoptionspopup"));
	}


	public By LookByOtherserachoptionspopuptext() throws Exception {

		return CommonUtility.getLocator_Mobile(RecentOrderPage_Data.get("LookByOtherserachoptionspopuptext"));
	}



	public By LookByOtherserachSelect() throws Exception {

		return CommonUtility.getLocator_Mobile(RecentOrderPage_Data.get("LookByOtherserachSelect"));
	}
	public By LookByOtherserachSelectoptions() throws Exception {

		return CommonUtility.getLocator_Mobile(RecentOrderPage_Data.get("LookByOtherserachSelectoptions"));
	}

	public By OptionstoggleIRN() throws Exception {

		return CommonUtility.getLocator_Mobile(RecentOrderPage_Data.get("OptionstoggleIRN"));
	} 

	//sujata

	public By Noordersfind() throws Exception {

		return CommonUtility.getLocator_Mobile(RecentOrderPage_Data.get("Noordersfind"));
	} 
	public By Returnsfindmessage() throws Exception {

		return CommonUtility.getLocator_Mobile(RecentOrderPage_Data.get("Returnsfindmessage"));
	} 

	public By Returnsfindmessagecorrect() throws Exception {

		return CommonUtility.getLocator_Mobile(RecentOrderPage_Data.get("Returnsfindmessagecorrect"));
	} 

	//Sujata
	public By PONumberEnter() throws Exception {

		return CommonUtility.getLocator_Mobile(RecentOrderPage_Data.get("PONumberEnter"));
	} 
	public By PONumberEnterSubmitBtn() throws Exception {

		return CommonUtility.getLocator_Mobile(RecentOrderPage_Data.get("PONumberEnterSubmitBtn"));
	} 
	public By Errorpopupponumber() throws Exception {

		return CommonUtility.getLocator_Mobile(RecentOrderPage_Data.get("Errorpopupponumber"));
	} 
	public By RecentOrdersLabel() throws Exception {

		return CommonUtility.getLocator_Mobile(RecentOrderPage_Data.get("RecentOrdersLabel"));
	} 

	//sudha

	public By PONumberCheckbox() throws Exception
	{

		return CommonUtility.getLocator_Mobile(RecentOrderPage_Data.get("PONumberCheckbox"));
	}
	public By  PONumberSearchTextbox() throws Exception
	{

		return CommonUtility.getLocator_Mobile(RecentOrderPage_Data.get("PONumberSearchTextbox"));
	}

	public By  XCloseButton() throws Exception
	{

		return CommonUtility.getLocator_Mobile(RecentOrderPage_Data.get("XCloseButton"));
	}
	
	public By  ClickOnOrderNumberRadioButton() throws Exception
	{

		return CommonUtility.getLocator_Mobile(RecentOrderPage_Data.get("ClickOnOrderNumberRadioButton"));
	}
	public By  SelectPONumberOption() throws Exception
	{

		return CommonUtility.getLocator_Mobile(RecentOrderPage_Data.get("SelectPONumberOption"));
	}
	public By  HomeIconInOrdersPage() throws Exception
	{

		return CommonUtility.getLocator_Mobile(RecentOrderPage_Data.get("HomeIconInOrdersPage"));
	}
	
	
}