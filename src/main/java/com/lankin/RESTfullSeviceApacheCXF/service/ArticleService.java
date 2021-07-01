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

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    Response createArticle(Article article);

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    List<Article> getArticles() ;

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    Article getArticle(@PathParam("id") long id);


    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    Response deleteArticleByID(@PathParam("id") long id);

    @PUT
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    Response updateArticleByID(@PathParam("id") long id, Article article);


}
