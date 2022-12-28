package com.dell.delta_uat_automation.esupport.pages;

import org.openqa.selenium.By;

import com.dell.delta_uat_automation.utility.CommonUtility;


public class EsupportOrderHomePage extends EsupportPojo{
	public By premierLogin() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("PremierLogin"));
	}
	public By delllogo() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("Delllogo"));
	}
	public By declinecookies() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("Declinecookies"));
		
	}
	public By AcceptCookies() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("AcceptCookies"));
	}
	public By userName() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("UserName"));
	}
	public By password() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("Password"));
	}
	public By signIn() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("SignIn"));
	}
	public By selectAccount() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("SelectAccount"));
	}
	public By selectAccountdrp() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("SelectAccountdrp"));
	}
	public By selectlist() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("Selectlist"));
	}
	public By accessPremier() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("AccessPremier"));
	}
	public By orderStatusLabel() throws Exception
	{

		return CommonUtility.getLocator(OrderHomePage_Data.get("OrderStatusLabel"));
	}

	public By orderStatusSearch() throws Exception
	{

		return CommonUtility.getLocator(OrderHomePage_Data.get("OrderStatusSearch"));
	}
	
	public By otherLookupOptions() throws Exception
	{

		return CommonUtility.getLocator(OrderHomePage_Data.get("OtherLookupOptions"));
	}
	
	public By orderSubmit() throws Exception
	{

		return CommonUtility.getLocator(OrderHomePage_Data.get("OrderSubmit"));
	}
	
	
	
	public By otherLookupOptionsLabel() throws Exception
	{

		return CommonUtility.getLocator(OrderHomePage_Data.get("OtherLookupOptionsLabel"));
	}

	public By searchOptionDropdown() throws Exception
	{

		return CommonUtility.getLocator(OrderHomePage_Data.get("SearchOptionDropdown"));
	}
	
	public By searchOptionList() throws Exception
	{

		return CommonUtility.getLocator(OrderHomePage_Data.get("SearchOptionList"));
	}
	public By customerNumberTextbox() throws Exception
	{

		return CommonUtility.getLocator(OrderHomePage_Data.get("CustomerNumberTextbox"));
	}
	public By lookUpByDropdown() throws Exception
	{

		return CommonUtility.getLocator(OrderHomePage_Data.get("LookUpByDropdown"));
	}
	
	public By verifyByDropdown() throws Exception
	{

		return CommonUtility.getLocator(OrderHomePage_Data.get("VerifyByDropdown"));
	}
	public By validateDropdown() throws Exception
	{

		return CommonUtility.getLocator(OrderHomePage_Data.get("ValidateDropdown"));
	}
	public By dpidTextbox() throws Exception
	{

		return CommonUtility.getLocator(OrderHomePage_Data.get("DpidTextbox"));
	}
	public By phoneTextbox() throws Exception
	{

		return CommonUtility.getLocator(OrderHomePage_Data.get("PhoneTextbox"));
	}
	public By submitButton() throws Exception
	{

		return CommonUtility.getLocator(OrderHomePage_Data.get("SubmitButton"));
	}
	public By firstName() throws Exception
	{

		return CommonUtility.getLocator(OrderHomePage_Data.get("FirstName"));
	}
	public By lastName() throws Exception
	{

		return CommonUtility.getLocator(OrderHomePage_Data.get("LastName"));
	}
	public By billingPhoneNumber() throws Exception
	{

		return CommonUtility.getLocator(OrderHomePage_Data.get("BillingPhoneNumber"));
	}
	public By postalCode() throws Exception
	{

		return CommonUtility.getLocator(OrderHomePage_Data.get("PostalCode"));
	}
	public By poNumber() throws Exception
	{

		return CommonUtility.getLocator(OrderHomePage_Data.get("PoNumber"));
	}
	public By Premierdifferentorder() throws Exception
	{

		return CommonUtility.getLocator(OrderHomePage_Data.get("Premierdifferentorder"));
	}
	
	public By acceptCookies() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("AcceptCookies"));
	}
	
//Lavanya adding for PCF GOS oct 13th 2020
	
	public By SearchBoxInOrderStatusPage() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("SearchBoxInOrderStatusPage"));
	}
	public By OrderSupportHeader() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("OrderSupportHeader"));
	}
	
	public By FindMyOrderButton() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("FindMyOrderButton"));
	}
	public By OrderDetailsPageBreadScrumb() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("OrderDetailsPageBreadScrumb"));
	}
	public By OrderNumberDetailsPageHeader() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("OrderNumberDetailsPageHeader"));
	}
	public By ServiceTagSection() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("ServiceTagSection"));
	}
	public By SignInToAccountLinkValidation() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("SignInToAccountLinkValidation"));
	}
	public By ActionsHeaderSection() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("ActionsHeaderSection"));
	}
	public By ActionsSection() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("ActionsSection"));
	}
	public By CancelOrder() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("CancelOrder"));
	}
	public By CancelOrderText() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("CancelOrderText"));
	}
	public By BackToOrderLink() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("BackToOrderLink"));
	}
	public By CancelOrderHeader() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("CancelOrderHeader"));
	}
	public By CustomerNumberHeader() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("CustomerNumberHeader"));
	}
	public By CustomerNumberTextBoxInCancelOrder() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("CustomerNumberTextBoxInCancelOrder"));
	}
	public By CancelButtonInCancelOrder() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("CancelButtonInCancelOrder"));
	}
	public By SubmitButtonInCancelOrder() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("SubmitButtonInCancelOrder"));
	}
	public By ErrorMessageInForInvalidCustomerNumber() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("ErrorMessageInForInvalidCustomerNumber"));
	}
	public By ReturnOrderInActionSection() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("ReturnOrderInActionSection"));
	}
	public By ReturnOrderText() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("ReturnOrderText"));
	}
	public By ReturnOrderHeader() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("ReturnOrderHeader"));
	}
	public By ReturnImage() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("ReturnImage"));
	}
	public By ViewInvoiceinActionsSection() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("ViewInvoiceinActionsSection"));
	}
	public By ViewInvoiceText() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("ViewInvoiceText"));
	}
	public By ViewInvoiceHeader() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("ViewInvoiceHeader"));
	}
	public By ErrorMessageForInvalidCNEntryInViewInvoice() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("ErrorMessageForInvalidCNEntryInViewInvoice"));
	}
	public By ColumnNamesUnderOrderDetails() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("ColumnNamesUnderOrderDetails"));
	}
	public By OtherPriceDetailsUnderOrderDetails() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("OtherPriceDetailsUnderOrderDetails"));
	}
	public By OrderDateAndDPIDDetailsOnOrderDetailsPage() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("OrderDateAndDPIDDetailsOnOrderDetailsPage"));
	}
	public By OrderStatusDetails() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("OrderStatusDetails"));
	}
	public By DPIDNumberLink() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("DPIDNumberLink"));
	}
	public By DPIDName() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("DPIDName"));
	}
	public By OrderCollectionBreadScrumb() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("OrderCollectionBreadScrumb"));
	}
	public By SignInSectionHeaderOnOrderHomePage() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("SignInSectionHeaderOnOrderHomePage"));
	}
	public By MyAccountButton() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("MyAccountButton"));
	}
	public By SignIntoYourAccountHeadingInServiceTagSection() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("SignIntoYourAccountHeadingInServiceTagSection"));
	}
	public By DescriptionsUnderSignIn() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("DescriptionsUnderSignIn"));
	}
	public By SignInLink() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("SignInLink"));
	}
	public By OrText() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("OrText"));
	}
	public By CustomerNUmberHeaderInServiceTagSection() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("CustomerNUmberHeaderInServiceTagSection"));
	}
	public By TextBoxInServiceTagSection() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("TextBoxInServiceTagSection"));
	}
	public By CancelButtonInServiceTagSection() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("CancelButtonInServiceTagSection"));
	}
	public By SubmitButtonInServiceTagSection() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("SubmitButtonInServiceTagSection"));
	}
	public By AddressDetailsHeader() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("AddressDetailsHeader"));
	}
	public By TypeOfAddress() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("TypeOfAddress"));
	}
	public By EndUserAddressHeader() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("EndUserAddressHeader"));
	}
	public By FullAddressUnderDifferentAddressType() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("FullAddressUnderDifferentAddressType"));
	}
	public By ViewAnotherOrderUnderActions() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("ViewAnotherOrderUnderActions"));
	}
	public By DescriptionBeforeContactCustomerSupportButton() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("DescriptionBeforeContactCustomerSupportButton"));
	}
	public By ContactCustomerSupportButton() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("ContactCustomerSupportButton"));
	}
	public By DisabledButtonsUnderActions() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("DisabledButtonsUnderActions"));
	}
	public By ServiceTagDisplayedAfterEnteringCustNo() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("ServiceTagDisplayedAfterEnteringCustNo"));
	}
	public By ActiveButtonsUnderActions() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("ActiveButtonsUnderActions"));
	}
	public By ViewPackingSlipDisabled() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("ViewPackingSlipDisabled"));
	}
	public By ClickOnNotyetAssignedLink() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("ClickOnNotyetAssignedLink"));
	}
	public By HeaderOfOrderCollectionDPIDPage() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("HeaderOfOrderCollectionDPIDPage"));
	}
	public By PONumberHeader() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("PONumberHeader"));
	}
	public By CustomerNumberHeaderInOrderDetailsPage() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("CustomerNumberHeaderInOrderDetailsPage"));
	}
	public By ViewOrderDetailsButton() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("ViewOrderDetailsButton"));
	}
	public By ItemsQuantity() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("ItemsQuantity"));
	}
	public By OrderDelayMessage() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("OrderDelayMessage"));
	}
	public By RDDDateUnderMilestoneDelivered() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("RDDDateUnderMilestoneDelivered"));
	}
	public By ClickOnFirstOrderNumber() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("ClickOnFirstOrderNumber"));
	}
	public By ViewPackingSlip() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("ViewPackingSlip"));
	}
	public By OrderCardCount() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("OrderCardCount"));
	}
	public By PaginationSectionOnOrderHistory() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("PaginationSectionOnOrderHistory"));
	}
	public By DeliveryDetailsHeader() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("DeliveryDetailsHeader"));
	}
	public By RevisedShipDate() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("RevisedShipDate"));
	}
	public By Shipped() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("Shipped"));
	}
	public By EstimatedToArriveBy() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("EstimatedToArriveBy"));
	}
	
	public By RevisedDeliveryDate() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("RevisedDeliveryDate"));
	}
	public By Delivered() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("Delivered"));
	}
	public By DatesAvailableUnderEachDate() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("DatesAvailableUnderEachDate"));
	}
	public By EstimatedShipDate() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("EstimatedShipDate"));
	}
	public By OrderProgressiveBar() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("OrderProgressiveBar"));
	}
	public By OrderDetailsInCollectionView() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("OrderDetailsInCollectionView"));
	}
	public By PricingDetailsInCollectionView() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("PricingDetailsInCollectionView"));
	}
	public By ViewOrderDatailsButtonIncollectionView() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("ViewOrderDatailsButtonIncollectionView"));
	}
	public By ViewPackingSlipButtonOnFirstDisplayedOrderCard() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("ViewPackingSlipButtonOnFirstDisplayedOrderCard"));
	}
	public By ViewInvoiceButtonOnFirstDisplayedOrderCard() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("ViewInvoiceButtonOnFirstDisplayedOrderCard"));
	}
	public By OrderNumberDisplayedOnFirstDisplayedOrderCard() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("OrderNumberDisplayedOnFirstDisplayedOrderCard"));
	}
	public By DPIDNumberDisplayedOnFirstDisplayedOrderCard() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("DPIDNumberDisplayedOnFirstDisplayedOrderCard"));
	}
	public By DownloadRecordsButtonOnCollectionView() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("DownloadRecordsButtonOnCollectionView"));
	}
	public By PremierAccountButton() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("PremierAccountButton"));
	}
	public By PremierStoreNameRCIDHeading() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("PremierStoreNameRCIDHeading"));
	}
	public By DashBoardHeading() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("DashBoardHeading"));
	}
	public By ClearButtonOnDashboard() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("ClearButtonOnDashboard"));
	}
	public By UpdateResultsButtonOnDashBoard() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("UpdateResultsButtonOnDashBoard"));
	}
	public By TimeFrameHeading() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("TimeFrameHeading"));
	}
	public By AllTimeFrameOptions() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("AllTimeFrameOptions"));
	}
	public By DropdownValuesOfTimeFrame() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("DropdownValuesOfTimeFrame"));
	}
	public By GridUnderDashBoard() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("GridUnderDashBoard"));
	}
	public By ColumnNamesOfGridForPremier() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("ColumnNamesOfGridForPremier"));
	}
	public By OrderNumberTextBox() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("OrderNumberTextBox"));
	}
	public By PONumberTextBox() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("PONumberTextBox"));
	}
	public By DPIDSearchBox() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("DPIDSearchBox"));
	}
	public By CustomerNumberDropdownValue() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("CustomerNumberDropdownValue"));
	}
	public By OrderStatusDropdownValue() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("OrderStatusDropdownValue"));
	}
	public By ActivityDropdownValue() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("ActivityDropdownValue"));
	}
	public By StartDateFieldTextBox() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("StartDateFieldTextBox"));
	}
	public By EndDateFieldTextBox() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("EndDateFieldTextBox"));
	}
	public By AgreementIDTextBox() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("AgreementIDTextBox"));
	}
	public By FirstDisplayedOrderNumberFromGrid() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("FirstDisplayedOrderNumberFromGrid"));
	}
	public By FirstDisplayedPONUmberFromGrid() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("FirstDisplayedPONUmberFromGrid"));
	}
	public By ExportButton() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("ExportButton"));
	}
	public By ConfirmExportHeadingClickingOnExport() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("ConfirmExportHeadingClickingOnExport"));
	}
	public By PopUpBodyMessage() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("PopUpBodyMessage"));
	}
	public By CancelButton() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("CancelButton"));
	}
	public By ContinueButton() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("ContinueButton"));
	}
	public By XMarkOnPopUp() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("XMarkOnPopUp"));
	}
	public By SuccessMessageAfterClickingOnDownload() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("SuccessMessageAfterClickingOnDownload"));
	}
	public By TotalNumberOfOrdersInGrid() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("TotalNumberOfOrdersInGrid"));
	}
	public By DateSelectForCustomTimeFrame() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("DateSelectForCustomTimeFrame"));
	}
	public By OtherLookUpOptions() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("OtherLookUpOptions"));
	}
	public By LookUpHeader() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("LookUpHeader"));
	}
	public By CustomerNumberRadioButton() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("CustomerNumberRadioButton"));
	}
	public By EnterCustomerNumberHeading() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("EnterCustomerNumberHeading"));
	}
	public By CustomeNumberTextBox() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("CustomeNumberTextBox"));
	}
	public By VerifyByHeading() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("VerifyByHeading"));
	}
	public By VerifyByDropdownValues() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("VerifyByDropdownValues"));
	}
	public By EnterPoNumberHeading() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("EnterPoNumberHeading"));
	}
	public By PONumberTextBox1() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("PONumberTextBox1"));
	}
	public By ValidateByHeading() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("ValidateByHeading"));
	}
	public By ValidateByDropdownValues() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("ValidateByDropdownValues"));
	}
	public By EnterPostalCodeHeading() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("EnterPostalCodeHeading"));
	}
	public By PostalCodeTExtBox() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("PostalCodeTExtBox"));
	}
	public By CancelButonOnCustomerNumber() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("CancelButonOnCustomerNumber"));
	}
	public By FindMyOrderButtonOnCustomerNumber() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("FindMyOrderButtonOnCustomerNumber"));
	}
	public By NumberOfOrderCardsInCollectionView() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("NumberOfOrderCardsInCollectionView"));
	}
	public By PONumberOption() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("PONumberOption"));
	}
	public By EnterThePONumber() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("EnterThePONumber"));
	}
	public By EnterPONumberTExtBox() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("EnterPONumberTExtBox"));
	}
	public By VerifyByPOHeading() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("VerifyByPOHeading"));
	}
	public By DropdownValueForPONumber() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("DropdownValueForPONumber"));
	}
	public By EnterCustomerNumberHeadingForPONumber() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("EnterCustomerNumberHeadingForPONumber"));
	}
	public By CustomerNumberTextBox() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("CustomerNumberTextBox"));
	}
	public By FirstOrderNumberInGrid() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("FirstOrderNumberInGrid"));
	}
	public By OrderDetailsBreadScrumb() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("OrderDetailsBreadScrumb"));
	}
	public By PONUmberColumnValues() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("PONUmberColumnValues"));
	}
	public By OrderStatusInputTextBox() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("OrderStatusInputTextBox"));
	}
	public By StatusDisplayedInGrid() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("StatusDisplayedInGrid"));
	}
	public By OrderStatusHeading() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("OrderStatusHeading"));
	}
	public By CustomerNumberHeading() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("CustomerNumberHeading"));
	}
	public By FirstDisplayedExpandButton() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("FirstDisplayedExpandButton"));
	}
	public By CustomerNumberInExpandedView() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("CustomerNumberInExpandedView"));
	}
	public By FirstRowInGrid() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("FirstRowInGrid"));
	}
	public By OrderDateColumnName() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("OrderDateColumnName"));
	}
	public By FirstDisplayedOrderDateValue() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("FirstDisplayedOrderDateValue"));
	}
	public By BillingInformationUnderOtherLookUpOptions() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("BillingInformationUnderOtherLookUpOptions"));
	}
	public By EnterFirstNameHeading() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("EnterFirstNameHeading"));
	}
	public By EnterLastNameHeading() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("EnterLastNameHeading"));
	}
	public By EnterPhoneNumberHeading() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("EnterPhoneNumberHeading"));
	}
	public By EnterPostalCodeHeadingBilling() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("EnterPostalCodeHeadingBilling"));
	}
	public By EnterFirstNameTextBox() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("EnterFirstNameTextBox"));
	}
	public By EnterLastNameTextBox() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("EnterLastNameTextBox"));
	}
	public By EnterPhoneNumberTextBox() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("EnterPhoneNumberTextBox"));
	}
	public By EnterPostalCodeTextBox() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("EnterPostalCodeTextBox"));
	}
	public By ItemsPerPageInInvoicePage() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("ItemsPerPageInInvoicePage"));
	}
	public By InvoiceNumberHyperlinkInGrid() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("InvoiceNumberHyperlinkInGrid"));
	}
	public By InputTextBoxForInvoice() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("InputTextBoxForInvoice"));
	}
	public By ApplyButtonInInvoice() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("ApplyButtonInInvoice"));
	}
	public By ResetButton() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("ResetButton"));
	}
	public By SearchButtonInInvoicePage() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("SearchButtonInInvoicePage"));
	}
	public By FirstDisplayedDPIDinGrid() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("FirstDisplayedDPIDinGrid"));
	}
	public By ChangeAccountOrAccessGroup() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("ChangeAccountOrAccessGroup"));
	}
	public By SelectPremierAccountHeading() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("SelectPremierAccountHeading"));
	}
	public By GreenProgressBarInExpandedView() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("GreenProgressBarInExpandedView"));
	}
	public By CompletedStatusNameInProgressBar() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("CompletedStatusNameInProgressBar"));
	}
	public By PendingStatusNameInProgressBar() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("PendingStatusNameInProgressBar"));
	}
	public By OrderNumberInGrid() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("OrderNumberInGrid"));
	}
	public By PartnerAccountButton() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("PartnerAccountButton"));
	}
	public By PartnerNameAndIDDetails() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("PartnerNameAndIDDetails"));
	}
	public By DashBoardInPartnerView() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("DashBoardInPartnerView"));
	}
	public By GridInPartnerView() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("GridInPartnerView"));
	}
	public By DisplayedTotalAmountOf() throws Exception {

		return CommonUtility.getLocator(OrderHomePage_Data.get("DisplayedTotalAmountOf"));
	}
	
	public By CookiesTitle() throws Exception
	{
		return CommonUtility.getLocator(OrderHomePage_Data.get("CookiesTitle"));
	}
	public By EMcOrdersHEading() throws Exception
	{
		return CommonUtility.getLocator(OrderHomePage_Data.get("EMcOrdersHEading"));
	}
	public By ReloadButton() throws Exception
    {
          return CommonUtility.getLocator(OrderHomePage_Data.get("ReloadButton"));
    }
	public By DateSelectForCustomTimeFrameEnd() throws Exception
    {
          return CommonUtility.getLocator(OrderHomePage_Data.get("DateSelectForCustomTimeFrameEnd"));
    }
	
}