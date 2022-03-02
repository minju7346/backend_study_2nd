package com.backend.study.configuration;

import org.springframework.context.annotation.*;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

import com.backend.study.user.interceptor.UserInterceptor;
import com.backend.study.user.mapper.UserMapper;

import lombok.RequiredArgsConstructor;

@Configuration
@Import({MyBatisConfig.class})
@PropertySource("classpath:application.properties")
@EnableWebMvc
@ComponentScan({
        "com.backend.study.**.controller",
        "com.backend.study.**.service"
})

@RequiredArgsConstructor
public class AppConfig implements WebMvcConfigurer {

    private final UserMapper userMapper;

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(new StringHttpMessageConverter());
        converters.add(new MappingJackson2HttpMessageConverter());
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new UserInterceptor(userMapper));
    }
}
