package com.blog.config;


import com.blog.models.PostType;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {



//    @Override
//    public void addFormatters(FormatterRegistry registry) {
//
//        registry.addConverter(new Converter<String, PostType>() {
//                @Override
//                public PostType convert(String s) {
//                    System.out.println("PostType convert(String s)");
//                    return PostType.valueOf(s.toUpperCase());
//                }
//        });
//    }
}
