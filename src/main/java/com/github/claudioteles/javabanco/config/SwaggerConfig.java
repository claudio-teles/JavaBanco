package com.github.claudioteles.javabanco.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
	public Docket pessoaApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.github.claudioteles.javabanco.restcontroller"))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(apiInfo());
	}

	@SuppressWarnings("deprecation")
	private ApiInfo apiInfo() {
		ApiInfo apiInfo = new ApiInfo(
				"Documentação Swagger para projeto Java Banco",
				"Api Rest para consulta de pessoas e contas bancárias cadastradas no HSQLDB", 
				"1.0.0", 
				"Termos de Uso", 
				"claudiotheles@gmail.com", 
				"GNU General Public License v3.0", 
				"https://github.com/claudio-teles/api-rest-pessoas/blob/master/LICENSE");
		return apiInfo;
	}

}
