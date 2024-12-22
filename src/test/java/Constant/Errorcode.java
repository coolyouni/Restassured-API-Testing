package Constant;

import TestCases.Baseclass;
import io.restassured.http.Header;
import net.bytebuddy.utility.RandomString;

public final class Errorcode  extends Baseclass {
	
	  // Account fields error codes
	public static final int  FirstName = 101;
    public static final int LastName = 102;
	public static final int Email = 103;
	public static final int Phone = 104;
	public static final int Password = 105;
	public static final int ConfirmPassword = 106;
	public static final int ExternalUserNotRegistered = 107;
	public static final int  InvalidExternalProviderOrToken = 108;
	public static final int ExternalTokenNotSent = 109;
	public static final int UserAlreadyRegistered = 110;

    // Company fields error codes
	public static final int CompanyName = 111;
	public static final int  BusinessType = 112;
	public static final int  BusinessSector = 113;
	public static final int  OtherBusinessSector = 114;
	public static final int  CompanyStartDate = 115;
	public static final int  FirstFinancialYearEnd = 116;
	public static final int  IsVatRegistered = 117;
	public static final int  MaxLengthCompanyName = 135;
	public static final int  FirstFinantialYearEndTooEarly = 136;
	public static final int  IncorrectLogoType = 137;
	public static final int  FileSizeTooBig = 138;
	
    //Company Fields - Address Informations Error Codes
	public static final int  BuildingNumber = 1001;
	public static final int Street = 1002;
	public static final int  Town = 1003;
	public static final int  Region = 1004;
	public static final int  PostCode = 1005;
	public static final int CountryCode = 1006;

    // Address fields error codes
	public static final int NoUniqueOrganisation = 118;
	public static final int  NoUniqueCode = 119;
	public static final int NullId = 133;
	public static final int NullCompanyDetails = 134;

    // Registration fields error codes
	public static final int MaxLengthFirstName = 120;
	public static final int RequiredFirstName = 121;
	public static final int MaxLengthLastName = 122;
	public static final int RequiredLastName = 123;
	public static final int RequiredEmail = 124;
	public static final int NonUniqueEmail = 125;
	public static final int IncorrectEmail = 126;
	public static final int MaxLengthPhone = 127;
	public static final int  NonInDigit = 128;
	public static final int  PasswordRequired = 129;
	public static final int  DiffrentPasswords = 130;
	public static final int  MinLenghtPassword = 131;
	public static final int RequiredConfirmPassword = 132;

    // Create invoice error codes
	public static final int DocumentInvalidContact = 140;
	public static final int DocumentIssueDateRequired = 141;
	public static final int DocumentInvalidDates = 142;
	public static final int DocumentItemsRequired = 143;
	public static final int DocumentItemAccountInvalid = 144;
	public static final int DocumentItemDescriptionRequired = 145;
	public static final int  DocumentItemQuantityInvalid = 146;
	public static final int  DocumentItemCostInvalid = 147;
	public static final int  DocumentItemVatRateInvalid = 148;
	public static final int  DocumentLockDateAffected = 149;
	public static final int  DocumentDueDateRequired = 150;
	public static final int  DocementUnitCostEqualsToZero = 172;
	public static final int  DocumentItemTotalInvalid = 173;
	public static final int   DocumentInvalidPaidBy = 174;

    // Payment error codes
	public static final int  PaymentDateRequired = 151;
	public static final int  PaymentMethodInvalid = 152;
	public static final int  PaymentBankAccountInvalid = 153;
	public static final int   PaymentInvalidAmount = 154;
	public static final int  PaymentFeeInvalid = 155;
	public static final int  PaymentDocumentInvalid = 156;
	public static final int  PaymentDateInvalid = 157;
	public static final int   PaymentExludedFeeEqualsToZero = 158;

    // Mileage error codes
	public static final int  InvalidStaffId = 160;
	public static final int  InvalidVehicleId = 161;
	public static final int  InvalidVehicleEngineId = 162;
	public static final int  InvalidMileage = 163;
	public static final int  MilageDescriptionRequired = 164;

    // OCR Error codes
	public static final int  UnknownVatRate = 170;
	public static final int  UnsuccessfullImageProcessing = 171;

    // OTP Error codes
	public static final int OtpNotFound = 180;
	public static final int  OtpWrongCode = 181;
	public static final int OtpExpired = 182;
	public static final int  OtpBlacklisted = 183;
	public static final int  OtpMaxTriesReached = 184;

    // Settings Error codes
	public static final int UnableToChangeSetting = 190;

    //Chart of Account codes
	public static final int  AccountType = 191;
	public static final int  Code = 192;
	public static final int  ChartOfAccountName = 193;
	public static final int  Box = 194;

    //Image File Validation Errors
	public static final int  ImageProfileWidthTooLong = 2011;
	public static final int  ImageProfileHeightTooLong = 2012;
	public static final int  ImageProfileUnwantedRatio = 2013;

	public static final int  ImageCompanyWidthTooLong = 2021;
	public static final int ImageCompanyHeightTooLong = 2022;
	public static final int  ImageCompanyUnwantedRatio = 2023;

    // General error codes
	public static final int  BadRequest = 400;
	public static final int  LoginFailed = 401;
	public static final int  AccessDenied = 403;
	public static final int   NotFound = 404;
	public static final int  UnexpecetedError = 500;
	public static final int  IncorrectId = 600;
	public static final int  CompanyIdRequired = 601;
	public static final int  PleaseCheckEmail = 602;

	public static final int  TermsDaysInvalid = 700;
}
