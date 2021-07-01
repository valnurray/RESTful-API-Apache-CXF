package com.lankin.RESTfullSeviceApacheCXF;

import com.fasterxml.jackson.core.util.JacksonFeature;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;

/*http://localhost:8080/v2/api-docs*/
/*http://localhost:8080/swagger-ui.html*/
@SpringBootApplication
//@EnableSwagger2

public class ResTfullSeviceApacheCxfApplication {

	public static void main(String[] args)
    {
		SpringApplication.run(ResTfullSeviceApacheCxfApplication.class, args);
	}

}
