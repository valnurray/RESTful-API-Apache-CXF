package com.lankin.RESTfullSeviceApacheCXF.service.impl;

import com.lankin.RESTfullSeviceApacheCXF.exception.NotFoundEntityException;
import com.lankin.RESTfullSeviceApacheCXF.mappers.ArticleMapper;
import com.lankin.RESTfullSeviceApacheCXF.model.Article;
import com.lankin.RESTfullSeviceApacheCXF.repository.ArticleRepository;
import com.lankin.RESTfullSeviceApacheCXF.service.api.ArticleService;
import com.lankin.RESTfullSeviceApacheCXF.service.api.models.request.ArticleRequest;
import com.lankin.RESTfullSeviceApacheCXF.service.api.models.response.ArticleResponse;
import lombok.Data;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.ws.rs.core.Response;
import java.util.List;

@Data
public class ArticleServiceImpl implements ArticleService {

    /**
     * Create log4j2 logger
     * */
    private static final Logger LOG = LogManager.getLogger(ArticleServiceImpl.class);

    private final ArticleRepository articleRepository;

    private final ArticleMapper articleMapper;

    /*@POST*/
    @Override
    public ArticleResponse createArticleResponse(ArticleRequest articleRequest) {
        LOG.info("created ArticleResponse");
        return articleMapper.ArticleToArticleResponse(articleRepository.save(
                articleMapper.ArticleRequestToArticle(articleRequest)));

    }

    /*@GET*/
    @Override
    public List<ArticleResponse> getArticleResponses() {
        LOG.info("get List<ArticleResponse");
        return articleMapper.ArticleToArticleResponse(articleRepository.findAll());
    }

    /*@GET*/
    @Override
    public ArticleResponse getArticleResponse(long id) {
        LOG.info("get ArticleResponse by id: " + id);
        /* we need to check whether Article with given id is exist in DB or not */
        articleRepository.findById(id).orElseThrow(NotFoundEntityException::new);
        /*Getting*/
        return articleMapper.ArticleToArticleResponse(articleRepository.findById(id).get());
    }

    /*@DELETE*/
    @Override
    public Response deleteArticleByID(long id) {
        LOG.info("delete Response by id: " +id);
        /* we need to check whether Article with given id is exist in DB or not */
        articleRepository.findById(id).orElseThrow(NotFoundEntityException::new);
        /*Deleting*/
        ArticleResponse articleResponse = articleMapper.ArticleToArticleResponse(articleRepository.findById(id).get());
        articleRepository.deleteById(id);
        return Response.status(204).build();
    }

    /*@PUT*/
    @Override
    public ArticleResponse updateArticleByID(long id, ArticleRequest articleRequest) {
        LOG.info("put Response by id:" + id + "(update)");
        /* we need to check whether Article with given id is exist in DB or not */
        Article article = articleRepository.findById(id).orElseThrow(NotFoundEntityException::new);

        Article updatedArticle = new Article();

        checkingTitleForNull(articleRequest, article, updatedArticle);

        checkingAuthorForNull(articleRequest, article, updatedArticle);

        checkingBodyForNull(articleRequest, article, updatedArticle);

        articleRequest = articleMapper.ArticleToArticleRequest(updatedArticle);
        updatedArticle = articleMapper.updateArt(article, articleRequest);
        articleRepository.save(article);
        return articleMapper.ArticleToArticleResponse(article);

    }

    private void checkingBodyForNull(ArticleRequest articleRequest, Article article, Article updatedArticle) {
        if(articleRequest.getBody() != null) {
            updatedArticle.setBody(articleRequest.getBody());
        }else {
            updatedArticle.setBody(article.getBody());
        }
    }

    private void checkingAuthorForNull(ArticleRequest articleRequest, Article article, Article updatedArticle) {
        if(articleRequest.getAuthor() != null){
            updatedArticle.setAuthor(articleRequest.getAuthor());
        }else {
            updatedArticle.setAuthor(article.getAuthor());
        }
    }

    private void checkingTitleForNull(ArticleRequest articleRequest, Article article, Article updatedArticle) {
        if(articleRequest.getTitle() != null) {
            updatedArticle.setTitle(articleRequest.getTitle());
        }else {
            updatedArticle.setTitle(article.getTitle());
        }
    }
}
