package com.lankin.RESTfullSeviceApacheCXF.service.models.response;



import lombok.Data;
import javax.persistence.Id;

@Data
public class ArticleResponse {

    @Id
    private long id;

    private String title;

    private String author;

    private String body;
}
