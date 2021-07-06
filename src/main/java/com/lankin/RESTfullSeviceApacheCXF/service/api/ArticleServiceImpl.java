package com.lankin.RESTfullSeviceApacheCXF.service.api;

import com.lankin.RESTfullSeviceApacheCXF.exception.ResourceNotFoundException;
import com.lankin.RESTfullSeviceApacheCXF.mappers.ArticleMapper;
import com.lankin.RESTfullSeviceApacheCXF.model.Article;
import com.lankin.RESTfullSeviceApacheCXF.repository.ArticleRepository;
import com.lankin.RESTfullSeviceApacheCXF.service.ArticleService;
import com.lankin.RESTfullSeviceApacheCXF.service.models.request.ArticleRequest;
import com.lankin.RESTfullSeviceApacheCXF.service.models.response.ArticleResponse;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.core.Response;
import java.util.List;


public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private ArticleMapper articleMapper;

//    @Override
//    public Response createArticle(Article article) {
//        articleRepository.save(article);
//        return Response.ok(article + "Article was created").build();
//    }

    @Override
    public ArticleResponse createArticleResponse(ArticleRequest articleRequest) {
        return articleMapper.ArticleToArticleResponse(articleRepository.save(articleMapper.ArticleRequestToArticle(articleRequest)));
    }


    @Override
    public List<Article> getArticles() {
        return articleRepository.findAll();

    }

    @Override
    public ArticleResponse getArticleResponse(long id) {
        return articleMapper.ArticleToArticleResponse(articleRepository.getById(id));
    }


//    @Override
//    public Article getArticle(long id) {
//        return articleRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
//    }

    @Override
    public ArticleResponse deleteArticleByID(long id) {
        articleRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
        return articleMapper.ArticleToArticleResponse(articleRepository.getById(id));
    }

//    @Override
//    public Response deleteArticleByID(long id) {
//        //we need to check whether Article with given id is exist in DB or not
//        articleRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
//        articleRepository.deleteById(id);
//        return Response.ok("Article with id - " + id + " was Deleted").build();
//    }

    @Override
    public ArticleResponse updateArticleByID(long id, ArticleRequest articleRequest) {
        //we need to check whether Article with given id is exist in DB or not
        ArticleRequest existingArticleRequest = articleMapper
                .ArticleToArticleRequest(articleRepository.findById(id).orElseThrow(ResourceNotFoundException::new));
        //change parameters
        articleRepository.save(articleMapper.ArticleRequestToArticle(articleRequest));
        return articleMapper.ArticleToArticleResponse(articleMapper.ArticleRequestToArticle(articleRequest));
    }

//    @Override
//    public Response updateArticleByID(long id, Article article) {
//        //we need to check whether Article with given id is exist in DB or not
//        Article existingArticle = articleRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
//        //change parameters
//        existingArticle.setAuthor(article.getAuthor());
//        existingArticle.setBody(article.getBody());
//        existingArticle.setTitle(article.getTitle());
//        //save existing Article to DB
//        articleRepository.save(existingArticle);
//        return Response.ok(article + "was updated").build();
//    }

}
