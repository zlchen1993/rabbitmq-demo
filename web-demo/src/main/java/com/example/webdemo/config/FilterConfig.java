package com.example.webdemo.config;

import org.apache.catalina.filters.RemoteIpFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author czl
 */
@Configuration
public class FilterConfig {
    @Bean
    public RemoteIpFilter remoteIpFilter(){
        return new RemoteIpFilter();
    }

    /**
     *  //过滤应用程序中所有资源,当前应用程序根下的所有文件包括多级子目录下的所有文件，注意这里*前有“/”
     *   registration.addUrlPatterns("/*");
     *   //过滤指定的类型文件资源, 当前应用程序根目录下的所有html文件，注意：*.html前没有“/”,否则错误
     *   registration.addUrlPatterns(".html");
     *   //过滤指定的目录下的所有文件,当前应用程序根目录下的folder_name子目录（可以是多级子目录）下所有文件
     *   registration.addUrlPatterns("/folder_name/*");
     *   //过滤指定文件
     *   registration.addUrlPatterns("/index.html");
     */
    @Bean
    public FilterRegistrationBean filterRegistrationBean(){
        FilterRegistrationBean registrationBean=new FilterRegistrationBean();
        registrationBean.setFilter(new MyFilter());
        registrationBean.addUrlPatterns("/*");
        registrationBean.addInitParameter("paramName","paramValue");
        registrationBean.setName("MyFilter");
        registrationBean.setOrder(1);
        return registrationBean;
    }

}
