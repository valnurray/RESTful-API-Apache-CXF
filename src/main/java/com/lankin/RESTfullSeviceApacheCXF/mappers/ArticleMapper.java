package com.lankin.RESTfullSeviceApacheCXF.mappers;


import com.lankin.RESTfullSeviceApacheCXF.model.Article;
import com.lankin.RESTfullSeviceApacheCXF.service.models.request.ArticleRequest;
import com.lankin.RESTfullSeviceApacheCXF.service.models.response.ArticleResponse;

public interface ArticleMapper {

    ArticleResponse ArticleToArticleResponse (Article article);
    Article ArticleResponseToArticle (ArticleResponse articleResponse);

    ArticleRequest ArticleToArticleRequest (Article article);
    Article ArticleRequestToArticle (ArticleRequest articleRequest);

}
