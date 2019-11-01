package com.zc.base;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

/**
 * @author aaa
 * @Auther: zhangcan
 * @Date: 2019/2/21 17:48
 * @Description:
 */
@Configuration
@SpringBootApplication
public class SpringElasticsearchApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringElasticsearchApplication.class, args);
    }


}
