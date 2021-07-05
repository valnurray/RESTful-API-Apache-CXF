package com.lankin.RESTfullSeviceApacheCXF.service.models.request;


import com.lankin.RESTfullSeviceApacheCXF.model.Article;

public class ArticleRequest {
    Article article;

    public void ArticleSetId(long id){
        article.setId(id);
    }

    public void ArticleSetTitle(String title){
        article.setTitle(title);
    }

    public void ArticleSetBody(String body){
        article.setBody(body);
    }

    public void ArticleSetAuthor(String author){
        article.setAuthor(author);
    }



}
