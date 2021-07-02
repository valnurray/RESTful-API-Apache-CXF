package com.lankin.RESTfullSeviceApacheCXF.configuration;

import org.apache.cxf.feature.Feature;
import org.apache.cxf.jaxrs.swagger.Swagger2Feature;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeaturesConfig {

    @Value("${cxf.path}")
    private String basePath;

    @Bean("swagger2Feature")
    public Feature swagger2Feature() {
        Swagger2Feature result = new Swagger2Feature();
        result.setTitle("Spring Boot + CXF + Swagger Example");
        result.setDescription("Spring Boot + CXF + Swagger Example description");
        result.setBasePath(this.basePath);
        result.setVersion("v1");
        result.setContact("Orlando L Otero");
        result.setSchemes(new String[] { "http", "https" });
        result.setPrettyPrint(true);
        return result;
    }
}
