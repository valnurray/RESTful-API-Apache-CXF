package com.lankin.RESTfullSeviceApacheCXF.configuration;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.lankin.RESTfullSeviceApacheCXF.controller.ArticleController;
import org.apache.cxf.Bus;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.swagger.Swagger2Feature;
import org.apache.cxf.transport.servlet.CXFServlet;
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
    public Server rsServer() {
        final JAXRSServerFactoryBean endpoint = new JAXRSServerFactoryBean();
        endpoint.setProvider(new JacksonJsonProvider());
        endpoint.setBus(bus);
        endpoint.setAddress("/");
        endpoint.setServiceBeans(Arrays.<Object>asList(articleController()));
//        endpoint.setServiceBeans(Arrays.<Object>asList(new ArticleController()));
        endpoint.setFeatures(Arrays.asList(new Swagger2Feature()));
        return endpoint.create();
    }

    @Bean
    public ArticleController articleController() {
        return new ArticleController();
    }

    //	 The default address of CXF RESTfull API is /services to change the API
    // sub-directory from /services with /api or anything that you like

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
