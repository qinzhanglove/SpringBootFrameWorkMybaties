package com.hrt.config;

import com.hrt.interceptor.AppSecurityInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebAppConfigureration extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AppSecurityInterceptor())
                .addPathPatterns("/hrt/**");
        super.addInterceptors(registry);
    }

}
