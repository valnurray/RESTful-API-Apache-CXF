package com.lankin.RESTfullSeviceApacheCXF.service;

import com.lankin.RESTfullSeviceApacheCXF.model.Article;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


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
@Api(value = "Hello resource Version 1", consumes = MediaType.APPLICATION_JSON,
                                         produces = MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface ArticleService {


    @POST
    @ApiOperation(value = "Gets Article resource By ID. Version 1 - (version in URL)")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Article create", response = Article.class),
            @ApiResponse(code = 404, message = "Error withe creating")
    })
    Response createArticle(Article article);



    @GET
    @ApiOperation(value = "Gets All Articles")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Get articles"),
            @ApiResponse(code = 404, message = "Articles not found")
    })
    List<Article> getArticles() ;

    @GET
    @Path("{id}")
    @ApiOperation(value = "Gets Article resource By ID. Version 1 - (version in URL)")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Article found", response = Article.class),
            @ApiResponse(code = 404, message = "Article not found")
    })
    Article getArticle(@PathParam("id") long id);


    @DELETE
    @ApiOperation(value = "Delete articles by id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Article deleted"),
            @ApiResponse(code = 404, message = "Article not found")
    })
    @Path("{id}")
    Response deleteArticleByID(@PathParam("id") long id);

    @PUT
    @Path("{id}")
    @ApiOperation(value = "Update articles by id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Article updated"),
            @ApiResponse(code = 404, message = "Article not found")
    })
    Response updateArticleByID(@PathParam("id") long id, Article article);


}
