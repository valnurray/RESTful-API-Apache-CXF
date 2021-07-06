package com.lankin.RESTfullSeviceApacheCXF.mappers;


import com.lankin.RESTfullSeviceApacheCXF.model.Article;
import com.lankin.RESTfullSeviceApacheCXF.service.models.request.ArticleRequest;
import com.lankin.RESTfullSeviceApacheCXF.service.models.response.ArticleResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring")
public interface ArticleMapper {

    ArticleMapper INSTANCE = Mappers.getMapper( ArticleMapper.class );

    ArticleResponse ArticleToArticleResponse (Article article);
    Article ArticleResponseToArticle (ArticleResponse articleResponse);

    ArticleRequest ArticleToArticleRequest (Article article);
    Article ArticleRequestToArticle (ArticleRequest articleRequest);

    List<ArticleResponse> ArticleToArticleResponse(List<Article> all);
}
