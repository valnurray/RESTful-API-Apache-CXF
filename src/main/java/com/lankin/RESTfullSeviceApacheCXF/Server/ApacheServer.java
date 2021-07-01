package com.lankin.RESTfullSeviceApacheCXF.Server;



import com.lankin.RESTfullSeviceApacheCXF.repository.ArticleRepository;
import com.lankin.RESTfullSeviceApacheCXF.service.ArticleService;
import com.lankin.RESTfullSeviceApacheCXF.service.impl.ArticleServiceImpl;
import io.swagger.annotations.SwaggerDefinition;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.swagger.Swagger2Feature;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import java.util.Arrays;

@Configuration
public class ApacheServer {
    private ArticleRepository articleRepository;
    private ArticleService articleService;

    private Bus bus;


    public org.apache.cxf.endpoint.Server rsServer() {

        JAXRSServerFactoryBean endpoint = new JAXRSServerFactoryBean();
        endpoint.setBus(bus);
        endpoint.setAddress("/");
        endpoint.setServiceBeans(Arrays.<Object>asList(
                new ArticleServiceImpl(articleRepository, articleService )));
        endpoint.setFeatures(Arrays.asList(new Swagger2Feature()));
        return endpoint.create();
    }



}
