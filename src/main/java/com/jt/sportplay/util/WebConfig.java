package com.jt.sportplay.util;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author BXO
 * @version 1.0
 * @description: TODO
 * @date 2023/3/20 15:46
 */

/*
* 全局配置跨域请求
* */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        /**
         * 1.访问路径
         * 2.请求来源
         * 3.请求方法
         * 4.允许携带
         * 5.最大时间
         * 6.表示允许的请求头，默认允许所有的请求头信息
         */
        registry.addMapping("/**")
                .allowedOriginPatterns("*")
                .allowedMethods("GET", "HEAD", "POST", "PUT", "DELETE", "OPTIONS")
                .allowCredentials(true)
                .maxAge(3600)
                .allowedHeaders("*");
    }

}