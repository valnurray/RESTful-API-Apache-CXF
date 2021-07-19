package com.lankin.RESTfullSeviceApacheCXF.service.api.models.request;

import com.lankin.RESTfullSeviceApacheCXF.model.Article;
import lombok.Data;

import java.util.List;

@Data
public class AuthorRequest {

    private String FirstName;

    private String LastName;

    private String Description;

    private List<Article> articles;
}
