package com.lankin.RESTfullSeviceApacheCXF.service.impl;

import com.lankin.RESTfullSeviceApacheCXF.mappers.ArticleMapper;
import com.lankin.RESTfullSeviceApacheCXF.model.Article;
import com.lankin.RESTfullSeviceApacheCXF.repository.ArticleRepository;
import com.lankin.RESTfullSeviceApacheCXF.service.api.ArticleService;
import com.lankin.RESTfullSeviceApacheCXF.service.api.models.request.ArticleRequest;
import com.lankin.RESTfullSeviceApacheCXF.service.api.models.response.ArticleResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

@SpringBootTest
class ArticleServiceImplTest {

    private ArticleService articleService;

    @MockBean
    private ArticleRepository articleRepository;

    private ArticleMapper articleMapper;

    @BeforeEach
    void setup(){
        articleMapper = Mappers.getMapper(ArticleMapper.class);
        articleService = new ArticleServiceImpl(articleRepository, articleMapper);
    }

    @Test
    void createArticleResponse() {
        // Setup our mock repository
        Article article = new Article();
        article.setId(1L);
        article.setAuthor("Jonny");
        article.setTitle("Mad");
        article.setBody("get mad");

        doReturn(article).when(articleRepository).save(any());

        // Execute the service call
        ArticleResponse articleResponse1 =  articleService.createArticleResponse(articleMapper.ArticleToArticleRequest(article));

        // Assert the response
        Assertions.assertNotNull(articleResponse1, "The saved widget should not be null");
        Assertions.assertEquals(1L,articleResponse1.getId(), "should be some");
    }

    @Test
    @DisplayName("Test findAll")
    void getArticleResponses() throws Exception {
        // Setup our mock repository
        ArticleResponse articleResponse1 = new ArticleResponse();
        articleResponse1.setId(1L);
        articleResponse1.setAuthor("Jonny");
        articleResponse1.setTitle("Mad");
        articleResponse1.setBody("died");

        ArticleResponse articleResponse2 = new ArticleResponse();
        articleResponse2.setId(2L);
        articleResponse2.setAuthor("Jonny2");
        articleResponse2.setTitle("Mad2");
        articleResponse2.setBody("died2");

        // Setup our mock repository
        Article article1 = new Article();
        article1.setId(1L);
        article1.setAuthor("Jonny");
        article1.setTitle("Mad");
        article1.setBody("died");

        Article article2 = new Article();
        article2.setId(2L);
        article2.setAuthor("Jonny2");
        article2.setTitle("Mad2");
        article2.setBody("died2");

        doReturn(Arrays.asList(article1, article2)).when(articleRepository).findAll();

        // Execute the service call
        List<ArticleResponse> articleList = articleService.getArticleResponses();

        // Assert the response
        Assertions.assertEquals(2, articleList.size(), "findAll should return 2 articles");
    }

    @Test
    @DisplayName("Test findById Success")
    public void testGetArticleResponseById() {

        // Setup our mock repository
        Article article = new Article();
        article.setId(1L);
        article.setAuthor("Jonny");
        article.setTitle("Mad");
        article.setBody("died");

        doReturn(Optional.of(article)).when(articleRepository).findById(1L);

        // Execute the service call
        Optional<Article> returnedArticle = articleRepository.findById(1L);

        // Assert the response
        Assertions.assertTrue(returnedArticle.isPresent(), "Article was not found");
        Assertions.assertSame(returnedArticle.get(), article, "The article returned was not the same as the mock");
    }

    @Test
    @DisplayName("Test findById Not Found")
    void testGetArticleResponseByIdNotFound() {
        // Setup our mock repository
        doReturn(Optional.empty()).when(articleRepository).findById(1L);

        // Execute the service call
        Optional<Article> returnedArticle = articleRepository.findById(1L);

        // Assert the response
        Assertions.assertFalse(returnedArticle.isPresent(), "Article should not be found");
    }

    @Test
    void deleteArticleByID() {
    }

    @Test
    void updateArticleByID() {
    }
}