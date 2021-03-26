package org.clc.job;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.clc.common.security.annotation.EnableCustomConfig;
import org.clc.common.security.annotation.EnableSmgFeignClients;
import org.clc.common.swagger.annotation.EnableCustomSwagger2;

/**
 * 定时任务
 */
@EnableCustomConfig
@EnableCustomSwagger2   
@EnableSmgFeignClients
@SpringCloudApplication
public class JobApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(JobApplication.class, args);
    }
}
