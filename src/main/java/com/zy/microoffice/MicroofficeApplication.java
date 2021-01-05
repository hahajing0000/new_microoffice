package com.zy.microoffice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@MapperScan("com.zy.microoffice.mapper")
@SpringBootApplication()
public class MicroofficeApplication  extends SpringBootServletInitializer{

    public static void main(String[] args) {
        SpringApplication.run(MicroofficeApplication.class, args);
    }

    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(MicroofficeApplication.class);
    }
}
