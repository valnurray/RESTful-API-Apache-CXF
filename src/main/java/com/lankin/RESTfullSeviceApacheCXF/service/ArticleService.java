package com.lankin.RESTfullSeviceApacheCXF.service;


import com.lankin.RESTfullSeviceApacheCXF.model.Article;

import java.util.List;

/**
 * Class {@code ArticleService} in package {@code com.lankin.rest.service}
 * interface for Entity Service layer
 *
 * @author Nikita Lankin
 * @version 1.0
 *
 */
public interface ArticleService {

    Article saveArticle (Article article);
    List<Article> getAllArticles();
    Article getArticleById(long id);
    Article updateArticle(Article article, long id);
    void deleteArticle(long id);
}

