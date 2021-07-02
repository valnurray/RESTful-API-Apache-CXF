package com.lankin.RESTfullSeviceApacheCXF.service.impl;


import com.lankin.RESTfullSeviceApacheCXF.exception.ResourceNotFoundException;
import com.lankin.RESTfullSeviceApacheCXF.model.Article;
import com.lankin.RESTfullSeviceApacheCXF.repository.ArticleRepository;
import com.lankin.RESTfullSeviceApacheCXF.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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
@Transactional
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleRepository articleRepository;


    @Override
    public Article saveArticle(Article article) {
        return articleRepository.save(article);
    }

    /**
     * find all articles
     *
     * @return List of articles
     */
    @Override
    public List<Article> getAllArticles() {
        return articleRepository.findAll();
    }

    /**
     * find article by Entity id
     * <p>
     * Description for Optional!
     * https://habr.com/ru/post/346782/ !!!!!!!!
     */
    @Override
    public Article getArticleById(long id) {
        /*
         * without lambda!
         */
//        Optional <Article> article = articleRepository.findById(id);
//        if(article.isPresent()){
//            return article.get();
//        }else {
//            throw new ResourceNotFoundException("article", "id", id);
//        }

        /*
         * with lambda
         */
        return articleRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

    /**
     * Update Entity
     *
     * @param article it's new Entity to save bu
     * @param id      like Entity id
     * @return new parameters in old Entity
     */
    @Override
    public Article updateArticle(Article article, long id) {
        //we need to check whether Article with given id is exist in DB or not
        Article existingArticle = articleRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
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
     *
     * @param id Entity
     */
    @Override
    public void deleteArticle(long id) {

        //we need to check whether Article with given id is exist in DB or not
        articleRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
        articleRepository.deleteById(id);
    }
}
