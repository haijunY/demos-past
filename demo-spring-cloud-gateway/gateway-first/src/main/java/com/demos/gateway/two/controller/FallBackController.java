package com.demos.gateway.two.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @author yinhaijun
 * @date: 2020/6/2
 */
@RestController
public class FallBackController {

    @RequestMapping("/fallback")
    public Mono<String> fallback(){
        return Mono.just("fallback");
    }

}
