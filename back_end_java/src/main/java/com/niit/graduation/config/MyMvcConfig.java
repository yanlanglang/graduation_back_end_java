package com.niit.graduation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

/**
 * Explain:
 *      - 使用WebMvcConfigurerAdapter可以来扩展SpringMVC的功能
 *
 *
 * @author Yanlang
 * @date 2020/1/18
 */
@Configuration
public class MyMvcConfig {

    private final static String local_default_avatar_path = "file:/C:\\Users\\yanlang\\Desktop\\graduation\\avatar\\";
    private final static String local_custom_avatar_path = "file:/C:\\Users\\yanlang\\Desktop\\graduation\\article/";
    private final static String ssh_avatar_path = "file:/root/Career/Java/niit/avatars/";


    /**
     * 所有的WebMvcConfigurer组件都会一起 起作用
     * Bean-将这个WebMvcConfigurer组件注册在容器中
     * @return
     */
    @Bean
    public WebMvcConfigurer webMvcConfigurer(){
        WebMvcConfigurer webMvcConfigurer = new WebMvcConfigurer(){

            //注册视图
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {

            }

            /**
             * 添加一些虚拟路径的映射
             * @param registry
             */
            @Override
            public void addResourceHandlers(ResourceHandlerRegistry registry) {

                /*
                    创建一个虚拟路径/avatar/** , 即在<img src="/defaultAvatar/one.jpg"> 便可以直接引用图片
                    file:/本地图片的地址 , 这是物理地址
                 */

                //本地默认头像
                registry.addResourceHandler("/localAvatar/**").addResourceLocations(local_default_avatar_path);
                //本地上传的图片
                registry.addResourceHandler("/localUpload/**").addResourceLocations(local_custom_avatar_path);

                //远程默认头像
                registry.addResourceHandler("/sshDefaultAvatar/**").addResourceLocations(ssh_avatar_path);
                //远程自定义头像
                registry.addResourceHandler("/sshCustomAvatar/**").addResourceLocations(ssh_avatar_path);

            }

            /**
             * 注册拦截器
             * @param registry
             */
            @Override
            public void addInterceptors(InterceptorRegistry registry) {

            }

            /**
             * 解决跨域问题
             * @param registry
             */
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                // 设置允许跨域的路径
                registry.addMapping("/**")
                        // 设置允许跨域请求的域名
                        .allowedOrigins("*")
                        // 是否允许证书
                        .allowCredentials(true)
                        .allowedMethods("*")
                        .allowedHeaders("*")
                        .maxAge(3600);
            }
        };


        return webMvcConfigurer;

    }


}
