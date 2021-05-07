package com.niit.graduation.util;

/**
 * @Author Yan Lang
 * @Date 2021/4/11
 * explain:
 */
public class MathRandomUtils {

    private final static int DEFAULT_LENGTH = 6;


    /**
     * 指定长度
     * @param len 长度
     * @return 随机数
     */
    public static String getRandom(int len){
        int rs = 0;

        if (len==0){
            rs = (int) ((Math.random() * 9 + 1) * Math.pow(10, DEFAULT_LENGTH - 1));
        }else {
            rs = (int) ((Math.random() * 9 + 1) * Math.pow(10, len - 1));
        }

        return String.valueOf(rs);
    }

}
