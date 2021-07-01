package com.ace.reslutswagger.common.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 描述：Swagger配置
 * Swagger2必须要有的配置：@EnableSwagger2 -启用Swagger
 * Swagger3必须要有的配置：@EnableOpenApi -启用Swagger，地址：http://127.0.0.1:8080/swagger-ui/
 * Swagger3集成第三方UI必须要有的配置：@EnableKnife4j -启用Swagger，并使用第三方UI（原UI依旧可使用），地址：http://localhost:8080/doc.html
 *
 * @author AceChen
 * @date 2021/5/28
 */
@Configuration
public class Swagger3Config {
    @Bean
    public OpenAPI springDocOpenApi(@Value("${springdoc.version}") String apiVersion) {
        return new OpenAPI()
                .components(new Components())
                .info(new Info().title("常用功能微服务接口文档")
                        .description("这是接口文档描述,下面是服务条款地址，最下面是许可证地址,你可以点[这里](http://www.ace.functions.com)进官网")
                        .termsOfService("http://swagger.io/terms/")
                        .version(apiVersion)
                        .license(new License().name("xx").url("http://www.xx.com")));
    }

}


