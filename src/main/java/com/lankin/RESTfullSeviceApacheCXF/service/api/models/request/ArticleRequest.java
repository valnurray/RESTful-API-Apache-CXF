package com.lankin.RESTfullSeviceApacheCXF.service.api.models.request;



import lombok.Data;


@Data
public class ArticleRequest {
//    @Id
//    private long id;

    private String title;

    private String author;

    private String body;

}
