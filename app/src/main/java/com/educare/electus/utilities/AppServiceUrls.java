package com.educare.electus.utilities;

public class AppServiceUrls {
    public static final String BASE_URL="http://192.168.0.4:8095/";
    public static final String GET_CLIENTS_URLS=BASE_URL+"ElectusEduCare/getallclinets";
    public static final String GET_CLIENTS_SELECTION=BASE_URL+"ElectusEduCare/processClient?clientid=";
    public static String loginURL = AppServiceUrls.BASE_URL+"ElectusEduCare/checklogin?username=";
    public static String GETEXAMS_LIST=AppServiceUrls.BASE_URL+"ElectusEduCare/displaystudentexams?studentid=";
    //http://192.168.1.13:8095
    //ED-17-00017&keyDS=1
}
