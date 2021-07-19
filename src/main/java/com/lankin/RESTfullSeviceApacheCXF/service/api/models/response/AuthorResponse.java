package com.lankin.RESTfullSeviceApacheCXF.service.api.models.response;

import com.lankin.RESTfullSeviceApacheCXF.model.Article;
import lombok.Data;


import java.util.List;

@Data
public class AuthorResponse {

    private long id;

    private String FirstName;

    private String LastName;

    private String Description;

    private List<Article> articles;
}
