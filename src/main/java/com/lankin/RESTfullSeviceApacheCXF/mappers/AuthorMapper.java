package com.lankin.RESTfullSeviceApacheCXF.mappers;

import com.lankin.RESTfullSeviceApacheCXF.model.Article;
import com.lankin.RESTfullSeviceApacheCXF.model.Author;
import com.lankin.RESTfullSeviceApacheCXF.service.api.models.request.ArticleRequest;
import com.lankin.RESTfullSeviceApacheCXF.service.api.models.request.AuthorRequest;
import com.lankin.RESTfullSeviceApacheCXF.service.api.models.response.ArticleResponse;
import com.lankin.RESTfullSeviceApacheCXF.service.api.models.response.AuthorResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AuthorMapper {

    AuthorMapper INSTANCE = Mappers.getMapper( AuthorMapper.class );

    AuthorResponse AuthorResponseToAuthor (Author author);
    Author AuthorToAuthorResponse (AuthorResponse authorResponse);

    List<AuthorResponse> AuthorToAuthorResponse(List<Author> all);


    AuthorRequest AuthorRequestToAuthor (Author author);
    Author AuthorToAAuthorRequest (AuthorRequest authorRequest);

    Author updateAuthor(@MappingTarget Author author, AuthorRequest authorRequest);
}
