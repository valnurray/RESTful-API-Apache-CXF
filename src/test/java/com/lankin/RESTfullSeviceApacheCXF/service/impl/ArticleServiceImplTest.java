package com.lankin.RESTfullSeviceApacheCXF.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lankin.RESTfullSeviceApacheCXF.repository.ArticleRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(ArticleServiceImpl.class)
class ArticleServiceImplTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    ArticleRepository articleRepository;



    @BeforeEach
    void setUp (){
    }

    @Test
    void createArticleResponse() {
    }

    @Test
    void getArticleResponses() {

    }

    @Test
    void getArticleResponse() {

    }

    @Test
    void deleteArticleByID() {
    }

    @Test
    void updateArticleByID() {
    }
}