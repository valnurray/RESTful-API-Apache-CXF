package com.lankin.RESTfullSeviceApacheCXF.configuration;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.lankin.RESTfullSeviceApacheCXF.mappers.ArticleMapper;
import com.lankin.RESTfullSeviceApacheCXF.repository.ArticleRepository;
import com.lankin.RESTfullSeviceApacheCXF.service.impl.ArticleServiceImpl;
import org.apache.cxf.Bus;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.swagger.Swagger2Feature;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class CxfConfig {

    @Autowired
    private Bus bus;

    @Bean
    public Server rsServer(ArticleRepository articleRepository, ArticleMapper articleMapper) {

        final JAXRSServerFactoryBean endpoint = new JAXRSServerFactoryBean();
        endpoint.setProvider(new JacksonJsonProvider());
        endpoint.setBus(bus);
        endpoint.setAddress("/");
        endpoint.setServiceBeans(Arrays.<Object>asList(articleServiceImpl(articleRepository, articleMapper)));
        endpoint.setFeatures(Arrays.asList(new Swagger2Feature()));
        return endpoint.create();
    }

    @Bean
    public ArticleServiceImpl articleServiceImpl(ArticleRepository articleRepository, ArticleMapper articleMapper){
        return new ArticleServiceImpl(articleRepository, articleMapper);
    }
    @Bean
    public ArticleMapper articleMapper(){
        return Mappers.getMapper(ArticleMapper.class);
    }

//    @Bean
//    public ArticleRepository articleRepositoryGet(){
//        return R
//    }

    /**
     * The default address of CXF RESTfull API is /services
     * this method change directory
     * http://localhost:8080/services
     * @return
     */
    @Bean
    public ServletRegistrationBean cxfServlet() {
        final ServletRegistrationBean servletRegistrationBean =
                new ServletRegistrationBean(new CXFServlet(), "/*");
        servletRegistrationBean.setLoadOnStartup(1);
        return servletRegistrationBean;
    }
}
