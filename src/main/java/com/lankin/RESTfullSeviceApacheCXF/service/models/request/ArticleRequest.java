package com.lankin.RESTfullSeviceApacheCXF.service.models.request;

import lombok.Data;

@Data
public class ArticleRequest {
    private long id;
    private String title;
    private String author;
    private String body;
}
