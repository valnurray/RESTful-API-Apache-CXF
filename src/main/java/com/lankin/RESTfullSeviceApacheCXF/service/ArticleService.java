package com.lankin.RESTfullSeviceApacheCXF.service;

import com.lankin.RESTfullSeviceApacheCXF.model.Article;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Class {@code ArticleService} in package {@code com.lankin.rest.service}
 * interface for Entity Service layer
 *
 * @author Nikita Lankin
 * @version 1.0
 *
 */
@Path("/article")
public interface ArticleService {

    Article saveArticle (Article article);
    List<Article> getAllArticles();
    Article getArticleById(long id);
    Article updateArticle(Article article, long id);
    void deleteArticle(long id);

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createArticle(Article article);

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Article> getCustomers() ;
}
