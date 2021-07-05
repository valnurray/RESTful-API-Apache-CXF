package com.lankin.RESTfullSeviceApacheCXF.service.models.request;


import com.lankin.RESTfullSeviceApacheCXF.model.Article;
import lombok.Data;

@Data
public class ArticleRequest {

    Article article;

    private long articleRequestId = article.getId();
    private String articleRequestTitle = article.getTitle();
    private String articleRequestAuthor = article.getAuthor();
    private String articleRequestBody = article.getBody();

//    public ArticleRequest(long articleRequestId, String articleRequestTitle, String articleRequestAuthor, String articleRequestBody){
//        this.articleRequestId = articleRequestId;
//        this.articleRequestTitle = articleRequestTitle;
//        this.articleRequestAuthor = articleRequestAuthor;
//        this.articleRequestBody = articleRequestBody;
//    }

}
