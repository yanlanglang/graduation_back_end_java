package com.niit.graduation.util;

/**
 * @Author Yan Lang
 * @Date 2021/4/20
 * explain:
 */
public class PathUtils {

    /**
     * 默认的头像地址
     * 本地：
     * 远程：
     */
    public final static String DEFAULT_AVATAR = "C:\\Users\\yanlang\\Desktop\\graduation\\avatar/avatar.jpg";



    /**
     * 自定义的头像地址
     * 本地： C:/Users/yanlang/Desktop/wbw/avatar/
     * 远程：root/Others/photos/wbw/avatar/
     */
    public static String defineAvatar = "C:\\Users\\yanlang\\Desktop\\graduation\\avatar/";
    /**
     * 自定义的头像地址 的映射路径
     * 本地: /localAvatar/
     * 远程：/sshAvatar/
     */
    public static String mapDefineAvatar = "/localAvatar/";



    /**
     * 自定义的上传的图片地址
     * 本地：C:/Users/yanlang/Desktop/wbw/picture/
     * 远程：root/Others/photos/wbw/picture/
     */
    public static String definePicture = "C:\\Users\\yanlang\\Desktop\\graduation\\article/";
    /**
     * 自定义的上传的图片地址 的映射路径
     * 本地：/localDownload/
     * 远程：/sshDownload/
     */
    public static String mapDefinePicture = "/localUpload/";



    /**
     * 获取完整的自定义头像地址
     * @param fileName
     * @return
     */
    public static String getAvatarPath (String fileName){
        return defineAvatar+fileName;
    }


    /**
     * 获取完整的自定义上传的图片地址
     * @param fileName
     * @return
     */
    public static String getPicturePath (String fileName){
        return definePicture+fileName;
    }

    /**
     * 获取映射后的头像地址
     * @param fileName
     * @return
     */
    public static String getMapAvatarPath(String fileName){
        return mapDefineAvatar+fileName;
    }

    /**
     * 获取映射后的图片地址
     * @param fileName
     * @return
     */
    public static String getMapPicturePath(String fileName){
        return mapDefinePicture+fileName;
    }

}
