package com.estsoft.springproject.filter;

import jakarta.servlet.Filter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {
    @Bean
    public FilterRegistrationBean<Filter> firstFilter() {
        FilterRegistrationBean<Filter> bean = new FilterRegistrationBean<>();

        bean.setFilter(new FirstFilter());
        bean.setOrder(1);
        bean.addUrlPatterns("/test");

        return bean;
    }

    @Bean
    public FilterRegistrationBean<Filter> secondFilter() {
        FilterRegistrationBean<Filter> bean = new FilterRegistrationBean<>();

        bean.setFilter(new SecondFilter());
        bean.setOrder(2);
        bean.addUrlPatterns("/test");

        return bean;
    }

}
