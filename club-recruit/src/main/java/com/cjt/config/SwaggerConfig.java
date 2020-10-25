package com.cjt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;

@Configuration
public class SwaggerConfig {

    @Bean
    public Docket docket(){
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo())
                .groupName("陈金涛_后台")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.cjt.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    public ApiInfo apiInfo(){
        //作者信息
        Contact contact = new Contact("陈金涛","https://blog.csdn.net/KIMTOU","752160655@qq.com");

        return new ApiInfo("Kim的SwaggerApi日记",
                "Forever Young",
                "1.0",
                "https://blog.csdn.net/KIMTOU",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());
    }

}
