package com.lankin.RESTfullSeviceApacheCXF;

import com.lankin.RESTfullSeviceApacheCXF.model.Article;
import com.lankin.RESTfullSeviceApacheCXF.service.api.models.request.ArticleRequest;

public class MockData {
    public Article getFirstArticle(){
        Article article = new Article();
        article.setId(1L);
        article.setAuthor("Jonny");
        article.setTitle("Mad");
        article.setBody("get mad");
        return article;
    }

    public Article getSecondArticle(){
        Article article = new Article();
        article.setId(2L);
        article.setAuthor("Billy");
        article.setTitle("About soccer");
        article.setBody("uefa");
        return article;
    }

    public ArticleRequest getFirstArticleRequest(){
        ArticleRequest articleRequest = new ArticleRequest();
        articleRequest.setAuthor("Billy");
        articleRequest.setTitle("Relaxing");
        articleRequest.setBody("get cure from madness");
        return articleRequest;
    }


}
