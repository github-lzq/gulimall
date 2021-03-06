package com.atguigu.gmall.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

/**
 * 解决cors跨域问题
 * 注册spring框架提供的过滤器
 */
@Configuration
public class GmallCorsConfiguration {
    @Bean
    public CorsWebFilter corsWebFilter(){
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.addAllowedOrigin("http://localhost:1000");//允许跨域的域名
        configuration.addAllowedOrigin("http://localhost:2000");//允许跨域的域名
        configuration.addAllowedMethod("*");//允许跨域的请求方法
        configuration.addAllowedHeader("*");//允许所有的头信息
        configuration.setAllowCredentials(true);//是否允许携带cookie
        //初始化nacos配置源
        UrlBasedCorsConfigurationSource  configurationSource = new UrlBasedCorsConfigurationSource();
       //允许所有请求走这个过滤器
        configurationSource.registerCorsConfiguration("/**",configuration);
       //初始化cors过滤器
        return new CorsWebFilter(configurationSource);
    }
}
