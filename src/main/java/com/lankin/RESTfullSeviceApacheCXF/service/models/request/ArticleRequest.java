package com.lankin.RESTfullSeviceApacheCXF.service.models.request;



import lombok.Data;
import javax.persistence.Id;


@Data
public class ArticleRequest {
//    @Id
//    private long id;

    private String title;

    private String author;

    private String body;

}
