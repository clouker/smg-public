package org.clc.gateway.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.clc.gateway.handler.ValidateCodeHandler;

/**
 * 路由配置信息
 */
@Configuration
public class RouterFunctionConfiguration {
    private final ValidateCodeHandler validateCodeHandler;

    public RouterFunctionConfiguration(ValidateCodeHandler validateCodeHandler) {
        this.validateCodeHandler = validateCodeHandler;
    }

    @SuppressWarnings("rawtypes")
    @Bean
    public RouterFunction routerFunction() {
        return RouterFunctions.route(
                RequestPredicates.GET("/code").and(RequestPredicates.accept(MediaType.TEXT_PLAIN)),
                validateCodeHandler);
    }
}
