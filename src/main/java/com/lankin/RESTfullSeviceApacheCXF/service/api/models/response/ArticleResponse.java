package com.lankin.RESTfullSeviceApacheCXF.service.api.models.response;

import com.lankin.RESTfullSeviceApacheCXF.model.Author;
import lombok.Data;
import javax.persistence.Id;

@Data
public class ArticleResponse {

    private long id;

    private String title;

    private Author author;
//    private String author;

    private String body;
}
