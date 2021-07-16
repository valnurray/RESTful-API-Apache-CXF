package com.lankin.RESTfullSeviceApacheCXF.service.api.models.response;

import lombok.Data;
import javax.persistence.Id;

@Data
public class ArticleResponse {

    private long id;

    private String title;

    private String author;

    private String body;
}
