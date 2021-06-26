package com.lankin.RESTfullSeviceApacheCXF.service;

import com.lankin.RESTfullSeviceApacheCXF.model.Article;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/article")
public interface ArticleREST {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    Response createArticle(Article article);

    @GET
    @Produces("application/xml")
    List<Article> getArticles() ;

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    Article getArticle(@PathParam("id") long id);

//    public Article getArticle(@PathParam("id") String id) {
//        return dataService.getCustomerById(id);
//    }

}
