package com.lankin.RESTfullSeviceApacheCXF.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lankin.RESTfullSeviceApacheCXF.model.Article;
import com.lankin.RESTfullSeviceApacheCXF.repository.ArticleRepository;
import com.lankin.RESTfullSeviceApacheCXF.service.api.ArticleService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@WebMvcTest(ArticleServiceImpl.class)
//@WebMvcTest
//@WebMvcTest(ArticleServiceImpl.class)
//@ContextConfiguration(classes = CxfConfig.class)
//@SpringBootTest(classes = {ArticleServiceImpl.class})
//@WebMvcTest
//@Configuration
//@EnableAutoConfiguration
//@ComponentScan
@SpringBootTest
class ArticleServiceImplTest {

    @Autowired
    private ArticleService articleService;

    @MockBean
    private ArticleRepository articleRepository;


    @Test
    void createArticleResponse() {
    }

    @Test
    void getArticleResponses() throws Exception {
//        Article article = new Article();
//        article.setId(1L);
//        article.setAuthor("Jonny");
//        article.setTitle("Mad");
//        article.setBody("died");
//
//        Article article2 = new Article();
//        article.setId(2L);
//        article.setAuthor("Jonny2");
//        article.setTitle("Mad2");
//        article.setBody("died2");
//
//        Article article3 = new Article();
//        article.setId(3L);
//        article.setAuthor("Jonny3");
//        article.setTitle("Mad3");
//        article.setBody("died3");
    }

    @Test
    @DisplayName("Test findById Success")
    void getArticleResponse() {

        // Setup our mock repository
        Article article = new Article();
        article.setId(1L);
        article.setAuthor("Jonny");
        article.setTitle("Mad");
        article.setBody("died");

        doReturn(Optional.of(article)).when(articleRepository).findById(1l);

        // Execute the service call
        Optional<Article> returnedArticle = articleRepository.findById(1l);

        // Assert the response
        Assertions.assertTrue(returnedArticle.isPresent(), "Article was not found");
        Assertions.assertSame(returnedArticle.get(), article, "The article returned was not the same as the mock");
    }

    @Test
    void deleteArticleByID() {
    }

    @Test
    void updateArticleByID() {
    }
}