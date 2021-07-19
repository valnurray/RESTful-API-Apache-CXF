package com.lankin.RESTfullSeviceApacheCXF;

import com.lankin.RESTfullSeviceApacheCXF.model.Article;
import com.lankin.RESTfullSeviceApacheCXF.model.Author;
import com.lankin.RESTfullSeviceApacheCXF.service.api.models.request.ArticleRequest;
import com.lankin.RESTfullSeviceApacheCXF.service.api.models.request.AuthorRequest;

import java.util.ArrayList;
import java.util.List;

public class MockData {


    public static Article getFirstArticle(){
        Article article = new Article();
        Article article2 = new Article();
        List<Article> articleList = new ArrayList<>();
        articleList.add(article);
        articleList.add(article2);

        Author author = new Author();
        author.setId(1L);
        author.setFirstName("Jonny");
        author.setLastName("Mnemonic");
        author.setDescription("some text");
//        author.setArticles(articleList);

        Article returnedArticle = new Article();
        returnedArticle.setId(1L);
        returnedArticle.setAuthor(author);
        returnedArticle.setTitle("Mad");
        returnedArticle.setBody("get mad");
        return returnedArticle;
    }

    public static Article getSecondArticle(){
        Article article = new Article();
        Article article2 = new Article();
        List<Article> articleList = new ArrayList<>();
        articleList.add(article);
        articleList.add(article2);

        Author author = new Author();
        author.setId(1L);
        author.setFirstName("Jonny");
        author.setLastName("Mnemonic");
        author.setDescription("some text");
        author.setArticles(articleList);

        Article returnedArticle = new Article();
        returnedArticle.setId(2L);
        returnedArticle.setAuthor(author);
        returnedArticle.setTitle("About soccer");
        returnedArticle.setBody("uefa");
        return returnedArticle;
    }

    public static ArticleRequest getFirstArticleRequest(){
        Article article = new Article();
        Article article2 = new Article();
        List<Article> articleList = new ArrayList<>();
        articleList.add(article);
        articleList.add(article2);

        Author author = new Author();
        author.setId(1L);
        author.setFirstName("Jonny");
        author.setLastName("Mnemonic");
        author.setDescription("some text");
        author.setArticles(articleList);

        ArticleRequest articleRequest = new ArticleRequest();
        articleRequest.setAuthor(author);
        articleRequest.setTitle("Relaxing");
        articleRequest.setBody("get cure from madness");
        return articleRequest;
    }

    public static Author getFirstAuthor(){
        Article article = new Article();
        Article article2 = new Article();
        List<Article> articleList = new ArrayList<>();
        articleList.add(article);
        articleList.add(article2);


        Author author = new Author();
        author.setId(1L);
        author.setFirstName("Jonny");
        author.setLastName("Mnemonic");
        author.setDescription("some text");
        author.setArticles(articleList);

        article.setId(1L);
        article.setAuthor(author);
        article.setTitle("Mad");
        article.setBody("get mad");

        article.setId(2L);
        article.setAuthor(author);
        article.setTitle("About soccer");
        article.setBody("uefa");

        return  author;
    }

    public static Author getSecondAuthor(){
        Article article = new Article();
        Article article2 = new Article();
        List<Article> articleList = new ArrayList<>();
        articleList.add(article);
        articleList.add(article2);


        Author author = new Author();
        author.setId(2L);
        author.setFirstName("Jonny");
        author.setLastName("Mnemonic");
        author.setDescription("some text");
        author.setArticles(articleList);

        article.setId(1L);
        article.setAuthor(author);
        article.setTitle("Mad");
        article.setBody("get mad");

        article.setId(2L);
        article.setAuthor(author);
        article.setTitle("About soccer");
        article.setBody("uefa");

        return  author;
    }

    public static AuthorRequest getFirstAuthorRequest(){
        Article article = new Article();
        Article article2 = new Article();
        List<Article> articleList = new ArrayList<>();
        articleList.add(article);
        articleList.add(article2);

        Author author = new Author();
        author.setId(1L);
        author.setFirstName("Jonny");
        author.setLastName("Mnemonic");
        author.setDescription("some text");
        author.setArticles(articleList);

        AuthorRequest authorRequest = new AuthorRequest();
        authorRequest.setFirstName(author.getFirstName());
        authorRequest.setLastName(author.getLastName());
        authorRequest.setDescription(author.getDescription());
        authorRequest.setArticles(author.getArticles());
        return authorRequest;
    }

}
