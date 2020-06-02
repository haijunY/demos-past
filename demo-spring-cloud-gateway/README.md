## spring-cloud-gateway
Spring Cloud Gateway是Spring Cloud官方推出的第二代网关框架，取代zuul网关。网关主要作用是路由转发、权限校验、限流控制。
### 入门
#### 一个简单的DEMO
创建一个项目gateway-first，添加Spring Cloud Gateway配置
```pom
       <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-gateway</artifactId>
        </dependency>
```
注意不用加starer-web配置，因为Spring Cloud gateway已经包含了start-web
写一个Route路由
```java
@Configuration
public class FirstRoute {

    @Bean
    public RouteLocator firstRoutes(RouteLocatorBuilder builder){
        return builder.routes()
                .route(p -> p
                        .path("/get")
                        .filters(f -> f.addRequestHeader("Hello", "World"))
                        .uri("http://httpbin.org:80"))
                .build();
    }

}
```
路由的含义是"/get"路径下的请求都会添加上请求头，并且转发到地址http://httpbin.org:80，
启动项目，浏览器打开http://localhost:1111/get，浏览器返回
```json
{
  "args": {}, 
  "headers": {
    "Accept": "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9", 
    "Accept-Encoding": "gzip, deflate, br", 
    "Accept-Language": "zh-CN,zh;q=0.9", 
    "Content-Length": "0", 
    "Cookie": "last-serviceName=service-hi; token=uuc_token:UUC_TOKEN_1d5b43335-19d9-4acc-980d-36e066110f25", 
    "Forwarded": "proto=http;host=\"localhost:1111\";for=\"0:0:0:0:0:0:0:1:64521\"", 
    "Hello": "World", 
    "Host": "httpbin.org", 
    "Sec-Fetch-Dest": "document", 
    "Sec-Fetch-Mode": "navigate", 
    "Sec-Fetch-Site": "none", 
    "Sec-Fetch-User": "?1", 
    "Upgrade-Insecure-Requests": "1", 
    "User-Agent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/83.0.4103.61 Safari/537.36", 
    "X-Amzn-Trace-Id": "Root=1-5ed60871-983f3ee03474c5c87c223d4c", 
    "X-Forwarded-Host": "localhost:1111"
  }, 
  "origin": "0:0:0:0:0:0:0:1, 116.227.75.54", 
  "url": "http://localhost:1111/get"
}
```
可见能正常访问目标地址，并且在请求头中添加了Hello:World
#### 使用Hystrix
路由当中可以直接使用Hystrix，首先引入jar包
```pom
        <!-- 断路器  -->
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-netflix-hystrix</artifactId>
        </dependency>
```
路由中添加如下代码
```java

                .route(p -> p.
                        path("/hystrix")
                        .filters(f -> f
                                .hystrix(config -> config
                                        .setName("mycmd")
                                        .setFallbackUri("forward:/fallback")))  //访问失败后请求/fallback路径
                        .uri("http://httpbin.org:8000"))    //一个不可访问的地址
                .build();
```
再写一个fallback的请求
```java
    @RequestMapping("/fallback")
    public Mono<String> fallback(){
        return Mono.just("fallback");
    }
```
浏览器访问http://localhost:1111/hystrix，由于路由的是一个不可访问的地址，则会触发断路器去调用fallback请求，结果返回
```text
fallback
```
### 工作流程
请看官网的一张图

![工作流程图](../images/SpringCloudGateway工作流程图.png)

客户端向Spring Cloud Gateway发出请求。如果Gateway Handler Mapping确定请求与路由匹配（这个时候就用到了predicate）,则将其发送到Gateway web Handler处理。Gateway web Hanlder处理请求时会经过一系列的过滤器链。
过滤器链被虚线划分的原因是过滤器链可以在发送代理请求之前或之后执行。先执行所有“pre”过滤器，然后进行代理请求。在发出代理请求之后，收到代理服务器的响应之后执行“post”过滤器。这跟zuul的处理过程很类似。
在执行所有“pre”过滤器时，往往进行了鉴权、限流、日志输出等功能，以及请求头的更改、协议的转换；转发之后收到响应之后，会执行所有的“post”过滤器，在这里可以响应数据进行修改，比如响应头、协议的转换等。
在上面的处理过程中，请求和路由进行匹配会用到predicate，它决定了一个请求走哪个路由
#### Predicate
介绍几种断言
##### Header Route Predicate Factory
这次我们直接使用配置的方式实现，新建一个工程gateway-two，引入gateway的包，加入配置
```yml
spring:
  cloud:
    gateway:
      routes:
        - id: s1
          uri: http://httpbin.org:80/get
          predicates:
            - Header=X-Request-Id, \d+
```
该配置表示，当请求的Header中有X-Request-Id的header名，且header值为数值时，请求会被路由到配置的uri，可以使用idea自带的REST Client工具给请求头添加值，可以测试效果
##### Cookie Route Predicate Factory
Cookie Route Predicate Factory需要两个名字参数，一个cookie的名字，一个值，可以为正则表达式，它用于匹配请求中，带有该名称的cookie和cookie能正则匹配的请求
我们新建一个配置文件application-s2.yml，修改application.yml中的active属性为s2，使s2文件生效，启动服务，然后在请求头中加入参数Cookie:name=forezp可看到效果
```yml
spring:
  cloud:
    gateway:
      routes:
        - id: s2
          uri: http://httpbin.org:80/get
          predicates:
            - Cookie=name, forezp
```
##### Host Route Predicate Factory
Host Route Predicate Factory需要一个参数即hostname，它可以使用.*等去匹配host。这个参数会匹配请求头中的host值，一致则请求正确转发,见配置application-host_route.yml
关于其它断言就不再一一列举了，用到的时候看官方文档
#### filter
predict决定了请求哪一个路由处理，在路由处理之前，需要经过“pre”类型的过滤器，处理返回响应之后，可以由“post”类型的过滤器处理
##### filter的作用和生命周期
由filter工作流程点，可以知道filter有着非常重要的作用，在“pre”类型的过滤器可以做参数校验、权限校验、流量监控、日志输出、协议转换等，在“post”类型的过滤器可以做响应内容、响应头的修改、日志的输出、流量监控等。



