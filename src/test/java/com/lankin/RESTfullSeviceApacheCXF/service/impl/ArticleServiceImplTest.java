package com.lankin.RESTfullSeviceApacheCXF.service.impl;

import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

@SpringBootTest
class ArticleServiceImplTest {
//
//    private ArticleService articleService;
//
//    @MockBean
//    private ArticleRepository articleRepository;
//
//    private ArticleMapper articleMapper;
//
//    @BeforeEach
//    void setup(){
//        articleMapper = Mappers.getMapper(ArticleMapper.class);
//        articleService = new ArticleServiceImpl(articleRepository, articleMapper);
//    }
//
//    @Test
//    void createArticleResponse() {
//        Article article = MockData.getFirstArticle();
//
//        doReturn(article).when(articleRepository).save(any());
//        // Execute the service call
//        ArticleResponse articleResponse1 =  articleService.createArticleResponse(articleMapper.ArticleToArticleRequest(article));
//
//        // Assert the response
//        Assertions.assertNotNull(articleResponse1, "The saved widget should not be null");
//        Assertions.assertEquals(1L,articleResponse1.getId(), "should be some");
//        org.assertj.core.api.Assertions.assertThat(article.getId()).isGreaterThan(0);
//    }
//
//    @Test
//    @DisplayName("Test findAll")
//    void getArticleResponses() {
//        // Setup our mock repository
//        Article article1 = MockData.getFirstArticle();
//        Article article2 = MockData.getSecondArticle();
//
//        doReturn(Arrays.asList(article1, article2)).when(articleRepository).findAll();
//
//        // Execute the service call
//        List<ArticleResponse> articleList = articleService.getArticleResponses();
//
//        // Assert the response
//        Assertions.assertEquals(2, articleList.size(), "findAll should return 2 articles");
//    }
//
//    @Test
//    @DisplayName("Test findById Success")
//    public void testGetArticleResponseById() {
//
//        // Setup our mock repository
//        Article article = MockData.getFirstArticle();
//        doReturn(Optional.of(article)).when(articleRepository).findById(1L);
//
//        ArticleResponse returnedResponse = articleService.getArticleResponse(1L);
//        Assertions.assertEquals(1L, returnedResponse.getId());
//        Assertions.assertNotNull(returnedResponse, "Should not be null");
//
//    }
//
//    @Test
//    @DisplayName("Test delete article by id")
//    public void deleteArticleByID() {
//        // Setup our mock repository
//        Article article = MockData.getFirstArticle();
//        when(articleRepository.findById(article.getId())).thenReturn(Optional.of(article));
//        articleService.deleteArticleByID(article.getId());
//        verify(articleRepository).deleteById(article.getId());
//
//    }
//
//    @Test
//    void updateArticleByID() {
//        // Setup our mock repository
//        Article article = MockData.getFirstArticle();
//        ArticleRequest newArticle = MockData.getFirstArticleRequest();
//        given(articleRepository.findById(article.getId())).willReturn(Optional.of(article));
//
//        //update Repository
//        articleService.updateArticleByID(article.getId(), newArticle);
//
//        //Compare
//        Assertions.assertTrue(newArticle.getAuthor().equalsIgnoreCase(article.getAuthor()));
//        Assertions.assertTrue(newArticle.getBody().equalsIgnoreCase(article.getBody()));
//        Assertions.assertTrue(newArticle.getTitle().equalsIgnoreCase(article.getTitle()));
//
//        verify(articleRepository).findById(article.getId());
//
//    }
//
//    @Test
//    @DisplayName("Test findById, update, delete with Exception")
//    public void testGetArticleByIdUpdateArticleByIdDeleteArticleByIdThrowException() {
////        // Setup our mock repository
//        Article article = MockData.getFirstArticle();
//
//        Assertions.assertThrows(NotFoundArticleException.class,
//                ()->{
//                    articleService.getArticleResponse(100000L);
//                });
//    }
}