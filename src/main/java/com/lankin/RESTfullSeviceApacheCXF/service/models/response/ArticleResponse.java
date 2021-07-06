package com.lankin.RESTfullSeviceApacheCXF.service.models.response;



import lombok.Data;
import javax.persistence.Id;

@Data
public class ArticleResponse {

    private String title;

    private String author;

    private String body;
}
