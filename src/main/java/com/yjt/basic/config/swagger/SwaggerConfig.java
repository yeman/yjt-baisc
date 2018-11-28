package com.yjt.basic.config.swagger;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Description "TODO"
 * @Author :ym
 * @Date: 2018/11/26 15:11
 **/
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //为当前包路径
                .apis(RequestHandlerSelectors.basePackage("com.yjt.basic"))
                .paths(PathSelectors.any())
                .build();
    }
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                //页面标题
                .title("Swagger2 构建RESTful API")
                //创建人
                .contact(new Contact("luckym", "http://xxx.xxx.com", "luckym@gmail.com"))
                //版本号
                .version("1.0")
                //描述
                .description("API 描述")
                .build();
    }

    /*@Bean 分组
     public Docket deviceDocket() {
                 return new Docket(DocumentationType.SWAGGER_2)
                         .groupName("用户接口文档")
                         .select()
                         .paths(PathSelectors.any())
                         .apis(RequestHandlerSelectors.basePackage("com.yjt.basic.user.controller"))
                         .build();
    }*/

}