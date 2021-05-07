package com.niit.graduation.util;

/**
 * @Author Yan Lang
 * @Date 2020/11/11
 * explain: Judge工具包
 */
public class JudgeUtils {

    /**
     * Request Url
     */
    private static final String BASE_URL = "http://www.ns4a.com:3000/";
    public static final String SUBMISSIONS_URL = BASE_URL + "submissions";
    public static final String GET_TOKEN_URL = SUBMISSIONS_URL+ "?base64_encoded=false&wait=false";
    public static final String GET_INFO_URL = SUBMISSIONS_URL;

    /**
     * Request Url param
     */
    public static final String BASE64_ENCODED = "false";
    public static final String WAIT = "true";


    /**
     * Request Headers
     */
    public static final String CONTENT_TYPE = "application/json";


    /**
     * Request Body
     * language_id : number
     */
    public static final String PYTHON_ID = "71";
    public static final String JAVASCRIPT_ID = "63";
    public static final String PHP_ID = "68";

}
