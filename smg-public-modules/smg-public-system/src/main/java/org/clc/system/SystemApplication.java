package org.clc.system;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.clc.common.security.annotation.EnableCustomConfig;
import org.clc.common.security.annotation.EnableSmgFeignClients;
import org.clc.common.swagger.annotation.EnableCustomSwagger2;

/**
 * 系统模块
 */
@EnableCustomConfig
@EnableCustomSwagger2
@EnableSmgFeignClients
@SpringCloudApplication
public class SystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(SystemApplication.class, args);
    }
}
