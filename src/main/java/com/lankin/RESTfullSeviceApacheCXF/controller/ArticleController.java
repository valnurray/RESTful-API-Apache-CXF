package com.lankin.RESTfullSeviceApacheCXF.controller;


import com.lankin.RESTfullSeviceApacheCXF.model.Article;
import com.lankin.RESTfullSeviceApacheCXF.service.ArticleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;


@Path("/article")
@Api(value = "/article") // Enables Swagger Documentation
@Produces(MediaType.APPLICATION_JSON)
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response save(final Article article) {
        articleService.saveArticle(article);
        return Response.ok(article + "Article was created").build();
    }

    @GET
    @Path("/{id}")
    @ApiOperation(value = "Finds an exist user with passed ID")
    public Article findById(@PathParam("id") final long id) {
        return articleService.getArticleById(id);
    }

    @GET
    @ApiOperation(value = "Find all users", response = Article.class)
    public List<Article> findAll() {
        return articleService.getAllArticles();
    }

    @PUT
    @Path("/{id}")
    @ApiOperation(value = "Updates an exist user with passed user fields")
    public Response update(@PathParam("id") final long id,
                           final Article article) {
        articleService.updateArticle(article, id);
        return Response.ok(article + "was updated").build();
    }

    @DELETE
    @Path("/{id}")
    @ApiOperation(value = "Deletes an exist user with ID")
    public Response deleteById(@PathParam("id") final long id) {
        articleService.deleteArticle(id);
        return Response.ok("Article with id - " + id + " was Deleted").build();
    }


}

