package rsch.proj.mtx.swagger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.any;

@EnableSwagger2
@SpringBootApplication
public class SwaggerApplication {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("Example").select()
				.apis(RequestHandlerSelectors.basePackage("rsch.proj.mtx.swagger"))
				.paths(any()).build().apiInfo(new ApiInfo("Example Services", "A set of services to provide data access to Example", "1.0.0", null, 
						new Contact("Tedy Darmawan", "https://github.com/tedydarmawan", "tedy.darmawan@gmail.com"), null, null));
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SwaggerApplication.class, args);
	}
}
