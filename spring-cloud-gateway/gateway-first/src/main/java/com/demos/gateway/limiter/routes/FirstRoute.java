package com.demos.gateway.limiter.routes;

import com.demos.gateway.limiter.filters.RequestTimeFilter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author yinhaijun
 * @date: 2020/6/2
 */
@Configuration
public class FirstRoute {

    @Bean
    public RouteLocator firstRoutes(RouteLocatorBuilder builder){
        return builder.routes()
                .route(p -> p
                        .path("/get")
                        .filters(f -> f.addRequestHeader("Hello", "World"))
                        .uri("http://httpbin.org:80"))
                .route(p -> p.
                        path("/hystrix")
                        .filters(f -> f
                                .hystrix(config -> config
                                        .setName("mycmd")
                                        .setFallbackUri("forward:/fallback")))  //访问失败后请求/fallback路径
                        .uri("http://httpbin.org:8000"))    //一个不可访问的地址
                .build();
    }

    @Bean
    public RouteLocator customerRouteLocator(RouteLocatorBuilder builder){
        return builder.routes()
                .route(p -> p.
                        path("/customer/**")
                        .filters(f -> f.filter(new RequestTimeFilter())
                        .addResponseHeader("X-Response-Default-Foo", "Default-Bar"))
                        .uri("http://httpbin.org:80")
//                        .order(0)
//                        .id("customer_filter_router")
                )
                .build();
    }

}
