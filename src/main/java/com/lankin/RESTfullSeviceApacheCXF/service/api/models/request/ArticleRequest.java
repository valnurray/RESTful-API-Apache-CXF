package com.lankin.RESTfullSeviceApacheCXF.service.api.models.request;

import com.lankin.RESTfullSeviceApacheCXF.model.Author;
import lombok.Data;


@Data
public class ArticleRequest {

    private String title;

    private Author author;
//    private String author;

    private String body;

}
