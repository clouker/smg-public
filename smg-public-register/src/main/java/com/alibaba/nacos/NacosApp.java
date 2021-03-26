package com.alibaba.nacos;

import com.alibaba.nacos.config.ConfigConstants;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 源码运行，方便开发 生产建议从官网下载最新版配置运行
 */
@EnableScheduling
@SpringBootApplication
public class NacosApp {

	public static void main(String[] args) {
		System.setProperty(ConfigConstants.STANDALONE_MODE, "true");
		System.setProperty(ConfigConstants.AUTH_ENABLED, "false");
		System.setProperty(ConfigConstants.LOG_BASEDIR, "logs");
		SpringApplication.run(NacosApp.class, args);
	}

}
