package com.niit.graduation.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by  yanLang on 2020/2/11
 * explain:
 */
public class Md5Utils {

    /**
     * MD5加密类
     * @param str 要加密的字符串
     * @return    加密后的字符串
     */
    public static String code(String str){
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(str.getBytes());
            byte[]byteDigest = md.digest();
            int i;
            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < byteDigest.length; offset++) {
                i = byteDigest[offset];
                if (i < 0) {
                    i += 256;
                }
                if (i < 16) {
                    buf.append("0");
                }
                buf.append(Integer.toHexString(i));
            }
            //32位加密
            return buf.toString();
            // 16位的加密
            //return buf.toString().substring(8, 24);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }

    }


    /**
     * 获取你加密后的密码
     * @param args
     */
    public static void main(String[] args) {
        //输出加密后的密码
        //code(你的密码)
        System.out.println(code("yl1999122"));
    }

}
