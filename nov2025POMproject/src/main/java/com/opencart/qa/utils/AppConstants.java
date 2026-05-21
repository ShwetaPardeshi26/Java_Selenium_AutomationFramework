package com.opencart.qa.utils;

import java.util.Arrays;
import java.util.List;

public class AppConstants {

 public static final long SHORT_TIME_OUT=5;
 public static final long MEDIUM_TIME_OUT=10;
 public static final long LONG_TIME_OUT=15;
 
 public static final String LOGIN_PAGE_TITLE="Account Login";
 public static final String LOGIN_PAGE_URL="route=account/login";
 public static final String HOME_PAGE_TITLE="My Account";
 public static final List<String> HEADER_HOMEPAGE_LIST=Arrays.asList("My Account","My Orders","My Affiliate Account","Newsletter");
 public static final List<String> PRODUCT_RESULTPAGE_LIST=Arrays.asList("MacBook","MacBook Air","MacBook Pro");
 public static final String REGISTRATION_SUCCESS_MESSAGE="Your Account Has Been Created!";

 public static final String REGISTER__SHEET_NAME="register";
 
 
}
