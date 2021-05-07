package com.niit.graduation.util;

import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Objects;

/**
 * @Author Yan Lang
 * @Date 2020/5/19
 * explain: 对图片进行相关操作的工具类
 */
public class PictureUtils {

    /**
     * MultipartFile 转 File
     *
     * @param file
     * @throws Exception
     */
    public static File multipartFileToFile(MultipartFile file) throws Exception {

        File toFile = null;
        if ("".equals(file) || file.getSize() <= 0) {
            file = null;
        } else {
            InputStream ins = null;
            ins = file.getInputStream();
            toFile = new File(Objects.requireNonNull(file.getOriginalFilename()));
            inputStreamToFile(ins, toFile);
            ins.close();
        }
        return toFile;
    }

    /**
     * 获取流文件
     * @param ins
     * @param file
     */
    private static void inputStreamToFile(InputStream ins, File file) {
        try {
            OutputStream os = new FileOutputStream(file);
            int bytesRead = 0;
            byte[] buffer = new byte[8192];
            while ((bytesRead = ins.read(buffer, 0, 8192)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
            os.close();
            ins.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 删除本地临时文件
     *
     * @param file
     */
    public static void deleteTempFile(File file) {
        if (file != null) {
            File del = new File(file.toURI());
            del.delete();
        }
    }


    /**
     * 将指定路径的图片 转换为 字节数组
     *
     * @param img 图片文件
     * @return 字节数组
     * @throws Exception
     */
    public static byte[] fileToByte(File img) throws Exception {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        byte[] bytes;
        try {
            BufferedImage bi = ImageIO.read(img);
            ImageIO.write(bi, "jpg", output);
            bytes = output.toByteArray();
            System.err.println("字节数组的长度---------------------------------->：" + bytes.length);
            return bytes;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            output.close();
        }

    }


    /**
     * 将 字节数组 转换为 指定路径下指定名称的图片
     *
     * @param bytes      数据库中存储的字节数组
     * @param avatarPath 头像类图片的地址
     * @param avatarName 图片名称 ---> 这里自己规定用 用户的email当图片名称
     * @throws Exception
     */
    public static void byteToFile(byte[] bytes, String avatarPath, String avatarName) throws Exception {
        ByteArrayInputStream input = new ByteArrayInputStream(bytes);
        try {
            BufferedImage bi = ImageIO.read(input);
            //可以是jpg, png, gif格式
            File file = new File(avatarPath + "\\" + avatarName + ".jpg");
            ImageIO.write(bi, "jpg", file);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            input.close();
        }

    }

}
