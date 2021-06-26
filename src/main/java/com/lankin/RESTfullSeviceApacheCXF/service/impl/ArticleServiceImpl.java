package com.lankin.RESTfullSeviceApacheCXF.service.impl;

import com.lankin.RESTfullSeviceApacheCXF.exception.ResourceNotFoundException;
import com.lankin.RESTfullSeviceApacheCXF.model.Article;
import com.lankin.RESTfullSeviceApacheCXF.repository.ArticleRepository;
import com.lankin.RESTfullSeviceApacheCXF.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
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
public class ArticleServiceImpl implements ArticleService {

    private ArticleRepository articleRepository;
    private ArticleService articleService;

//    /**
//     * @Autowired !!!!
//     * Starting with Spring 4.3, if a Class, which is configured as a Spring bean,
//     * has only one constructor, the @Autowired annotation can be omitted
//     * and Spring will use that constructor and inject all necessary dependencies
//     */
//    public ArticleServiceImpl(ArticleRepository articleRepository) {
//        this.articleRepository = articleRepository;
//    }

    /**
     * save new article in DB
     * @param article is new Entity
     * @return new Entity of article
     */
    @Override
    public Article saveArticle(Article article) {
        return articleRepository.save(article);
    }

    /**
     * find all articles
     * @return List of articles
     */
    @Override
    public List<Article> getAllArticles() {
        return articleRepository.findAll();
    }

    /**
     * find article by Entity id
     *
     * Description for Optional!
     * https://habr.com/ru/post/346782/ !!!!!!!!
     */
    @Override
    public Article getArticleById(long id) {

        return articleRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("article", "id", id));
    }

    /**
     * Update Entity
     * @param article it's new Entity to save bu
     * @param id like Entity id
     * @return new parameters in old Entity
     */
    @Override
    public Article updateArticle(Article article, long id) {
        //we need to check whether Article with given id is exist in DB or not
        Article existingArticle = articleRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("article", "id", id));
        //change parameters
        existingArticle.setAuthor(article.getAuthor());
        existingArticle.setBody(article.getBody());
        existingArticle.setTitle(article.getTitle());
        //save existing Article to DB
        articleRepository.save(existingArticle);

        return existingArticle;
    }

    /**
     * delete Entity from DB
     * @param id Entity
     */
    @Override
    public void deleteArticle(long id) {

        //we need to check whether Article with given id is exist in DB or not
        articleRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("article", "id", id));
        articleRepository.deleteById(id);
    }

    @Override
    public Response createArticle(Article article) {
        return Response.ok(articleService.saveArticle(article)).build();
    }

    @Override
    public List<Article> getCustomers() {
        return articleService.getAllArticles();
    }
}
