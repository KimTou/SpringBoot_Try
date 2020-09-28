package com.cjt;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author cjt
 */
@MapperScan(basePackages = "com.cjt.mapper")
@SpringBootApplication
public class WebmasterRecruitApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebmasterRecruitApplication.class, args);
    }

}
