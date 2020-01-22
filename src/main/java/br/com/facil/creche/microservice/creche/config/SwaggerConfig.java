package br.com.facil.creche.microservice.creche.config;

import br.com.facil.creche.microservice.creche.controller.CrecheController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.List;

@Configuration
@EnableSwagger2
@ComponentScan(basePackageClasses = {
        CrecheController.class
})
public class SwaggerConfig {

    public static final List<ResponseMessage> ERROR_500 = Arrays.asList(new ResponseMessageBuilder()
            .code(500)
            .message("An unexpected error occurred while processing the request")
            .responseModel(new ModelRef("Error"))
            .build());

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("br.com.facil.creche.microservice.creche"))
                .paths(PathSelectors.any())
                .build()
                .globalResponseMessage(RequestMethod.GET,
                        ERROR_500)
                .globalResponseMessage(RequestMethod.POST,
                        ERROR_500)
                .globalResponseMessage(RequestMethod.PUT,
                        ERROR_500)
                .globalResponseMessage(RequestMethod.DELETE,
                        ERROR_500)
                .genericModelSubstitutes(ResponseEntity.class)
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Creche microservice from Creche Facil Startup ")
                .description("Microservice responsible for maintain all creche operations")
                .version("1.0.0")
                .build();
    }
}
