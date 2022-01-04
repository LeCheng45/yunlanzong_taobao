package com.yunlan.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.File;

@Configuration
public class WebmvcConfig implements WebMvcConfigurer {

    @Value("${file-save-path}")
    private String dataPath;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //terrain指文件存放的绝对路径
        String terrain = dataPath.concat(File.separator);
        File file = new File(terrain);
        if (!file.exists()) {
            file.mkdirs();
        }
        registry.addResourceHandler("/img/**").addResourceLocations("file:"+terrain);
    }

//    @Override
//    public  void  addCorsMappings(CorsRegistry registry){
//        registry.addMapping("/**")
//                .allowedOrigins("*")
//                .allowedHeaders("*")
//                .allowedMethods("*")
//                .maxAge(30*1000);
//    }

}