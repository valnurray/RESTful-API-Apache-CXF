package com.lankin.RESTfullSeviceApacheCXF.service.impl;


import com.lankin.RESTfullSeviceApacheCXF.exception.ResourceNotFoundException;
import com.lankin.RESTfullSeviceApacheCXF.exception.ResourceNotFoundExceptionMapper;
import com.lankin.RESTfullSeviceApacheCXF.model.Article;
import com.lankin.RESTfullSeviceApacheCXF.repository.ArticleRepository;
import com.lankin.RESTfullSeviceApacheCXF.service.ArticleService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Class {@code ArticleServiceImpl} in package {@code com.lankin.rest.service.impl}
 * Service layer for Entity
 *
 * @author Nikita Lankin
 * @version 1.0
 *
 */
@Service
public class ArticleServiceImpl implements ArticleService{

    ArticleRepository articleRepository;
    ArticleService articleService;

    /**
     * @Autowired !!!!
     * Starting with Spring 4.3, if a Class, which is configured as a Spring bean,
     * has only one constructor, the @Autowired annotation can be omitted
     * and Spring will use that constructor and inject all necessary dependencies
     */
    @Autowired
    @Lazy
    public ArticleServiceImpl(ArticleRepository articleRepository, ArticleService articleService) {
        this.articleRepository = articleRepository;
        this.articleService = articleService;
    }


    @Override
    public Response createArticle(Article article) {
        articleRepository.save(article);
        return Response.ok(article + "Article was created").build();
    }

    @Override
    public List<Article> getArticles() {
        return articleRepository.findAll();
    }


    @Override
    public Article getArticle(long id) {
        return articleRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public Response deleteArticleByID(long id) {
        //we need to check whether Article with given id is exist in DB or not
        articleRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
        articleRepository.deleteById(id);
        return Response.ok("Article with id - " + id + " was Deleted").build();
    }

    @Override
    public Response updateArticleByID(long id, Article article) {
        //we need to check whether Article with given id is exist in DB or not
        Article existingArticle = articleRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
        //change parameters
        existingArticle.setAuthor(article.getAuthor());
        existingArticle.setBody(article.getBody());
        existingArticle.setTitle(article.getTitle());
        //save existing Article to DB
        articleRepository.save(existingArticle);
        return Response.ok(article + "was updated").build();
    }
}
