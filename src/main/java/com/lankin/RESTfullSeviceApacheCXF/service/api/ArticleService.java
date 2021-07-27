package com.lankin.RESTfullSeviceApacheCXF.service.api;

import com.lankin.RESTfullSeviceApacheCXF.model.Article;
import com.lankin.RESTfullSeviceApacheCXF.service.api.models.request.ArticleRequest;
import com.lankin.RESTfullSeviceApacheCXF.service.api.models.response.ArticleResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;


@Path("/article")
@Api(value = "/article") // Enables Swagger Documentation
public interface ArticleService {


    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    ArticleResponse createArticleResponse(ArticleRequest articleRequest);


    @GET
    @ApiOperation(value = "Find all Articles", response = Article.class)
    @Produces(MediaType.APPLICATION_JSON)
    List<ArticleResponse> getArticleResponses();


    @GET
    @Path("{id}")
    @ApiOperation(value = "Find Article by passed ID")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    ArticleResponse getArticleResponse(@PathParam("id") long id);

    @DELETE
    @Path("{id}")
    @ApiOperation(value = "Deletes an exist Article with passed ID")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    Response deleteArticleByID(@PathParam("id") long id);

    @PUT
    @Path("{id}")
    @ApiOperation(value = "Updates an exist Article with passed Article fields")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    ArticleResponse updateArticleByID(@PathParam("id") long id, ArticleRequest articleRequest);

}

