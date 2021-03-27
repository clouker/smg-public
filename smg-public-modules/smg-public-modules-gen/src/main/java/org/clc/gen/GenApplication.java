package org.clc.gen;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.clc.common.security.annotation.EnableCustomConfig;
import org.clc.common.security.annotation.EnableSmgFeignClients;
import org.clc.common.swagger.annotation.EnableCustomSwagger2;

/**
 * 代码生成
 */
@EnableCustomConfig
@EnableCustomSwagger2
@EnableSmgFeignClients
@SpringCloudApplication
public class GenApplication {
    public static void main(String[] args) {
        SpringApplication.run(GenApplication.class, args);
    }
}
