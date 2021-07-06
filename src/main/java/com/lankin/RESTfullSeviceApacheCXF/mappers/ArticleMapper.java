package com.lankin.RESTfullSeviceApacheCXF.mappers;


import com.lankin.RESTfullSeviceApacheCXF.model.Article;
import com.lankin.RESTfullSeviceApacheCXF.service.api.models.request.ArticleRequest;
import com.lankin.RESTfullSeviceApacheCXF.service.api.models.response.ArticleResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import java.util.List;


@Mapper(componentModel = "spring")
public interface ArticleMapper {

    ArticleMapper INSTANCE = Mappers.getMapper( ArticleMapper.class );

    ArticleResponse ArticleToArticleResponse (Article article);
    Article ArticleResponseToArticle (ArticleResponse articleResponse);

    ArticleRequest ArticleToArticleRequest (Article article);
    Article ArticleRequestToArticle (ArticleRequest articleRequest);

    List<ArticleResponse> ArticleToArticleResponse(List<Article> all);

    void updateArticleResponseFromArticleRequest(ArticleRequest articleRequest, @MappingTarget Article article);
}
