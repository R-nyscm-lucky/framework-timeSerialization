package com.newhood.framework.timeserialization.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import javax.annotation.Resource;
import java.nio.charset.Charset;
import java.util.List;


/**
 * Description  当前文件要放在启动类中，因为如果不放在启动类中，
 *              可能存在调用先后或者被其他继承重写文件可能ObjectMapper被修改.
 *
 * @author ZJW
 * @since 2020/8/3 20:15
 */
@Configuration
public class WebConfig extends WebMvcConfigurationSupport {

    @Resource
    ObjectMapper objectMapper;

    /**
     * 解决中文乱码问题
     */
    @Bean
    public HttpMessageConverter<String> responseBodyConverter() {
        return new StringHttpMessageConverter(Charset.forName("UTF-8"));
    }

    /**
     * 解决前后端localDateTime为时间戳问题
     */
    @Bean
    public HttpMessageConverter<Object> jacksonConverter() {
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setObjectMapper(objectMapper);
        return converter;
    }

    /**
     * 添加转换器
     */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        super.configureMessageConverters(converters);
        converters.add(jacksonConverter());
        converters.add(responseBodyConverter());
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations(
                "classpath:/static/");
        registry.addResourceHandler("swagger-ui.html").addResourceLocations(
                "classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations(
                "classpath:/META-INF/resources/webjars/");
        super.addResourceHandlers(registry);
    }
}
