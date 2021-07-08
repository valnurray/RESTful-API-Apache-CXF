package com.lankin.RESTfullSeviceApacheCXF.service.impl;

import com.lankin.RESTfullSeviceApacheCXF.exception.NotFoundArticleException;
import com.lankin.RESTfullSeviceApacheCXF.mappers.ArticleMapper;
import com.lankin.RESTfullSeviceApacheCXF.model.Article;
import com.lankin.RESTfullSeviceApacheCXF.repository.ArticleRepository;
import com.lankin.RESTfullSeviceApacheCXF.service.api.ArticleService;
import com.lankin.RESTfullSeviceApacheCXF.service.api.models.request.ArticleRequest;
import com.lankin.RESTfullSeviceApacheCXF.service.api.models.response.ArticleResponse;
import lombok.Data;
import java.util.List;

@Data
public class ArticleServiceImpl implements ArticleService {

    private final ArticleRepository articleRepository;

    private final ArticleMapper articleMapper;

    /*@POST*/
    @Override
    public ArticleResponse createArticleResponse(ArticleRequest articleRequest) {
        return articleMapper.ArticleToArticleResponse(articleRepository.save(
                articleMapper.ArticleRequestToArticle(articleRequest)));
    }

    /*@GET*/
    @Override
    public List<ArticleResponse> getArticleResponses() {
        return articleMapper.ArticleToArticleResponse(articleRepository.findAll());
    }

    /*@GET*/
    @Override
    public ArticleResponse getArticleResponse(long id) {
        /* we need to check whether Article with given id is exist in DB or not */
        articleRepository.findById(id).orElseThrow(NotFoundArticleException::new);
        /*Getting*/
        return articleMapper.ArticleToArticleResponse(articleRepository.findById(id).get());
    }

    /*@DELETE*/
    @Override
    public ArticleResponse deleteArticleByID(long id) {
        /* we need to check whether Article with given id is exist in DB or not */
        articleRepository.findById(id).orElseThrow(NotFoundArticleException::new);
        /*Deleting*/
        ArticleResponse articleResponse = articleMapper.ArticleToArticleResponse(articleRepository.findById(id).get());
        articleRepository.deleteById(id);
        return articleResponse;
    }

    /*@PUT*/
    @Override
    public ArticleResponse updateArticleByID(long id, ArticleRequest articleRequest) {
        /* we need to check whether Article with given id is exist in DB or not */
        Article article = articleRepository.findById(id).orElseThrow(NotFoundArticleException::new);
         articleMapper.updateArticleResponseFromArticleRequest(articleRequest, article);
         articleRepository.save(article);
        return articleMapper.ArticleToArticleResponse(article);
    }
}
