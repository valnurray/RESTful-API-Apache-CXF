package com.lankin.RESTfullSeviceApacheCXF.service.api;

import com.lankin.RESTfullSeviceApacheCXF.model.Article;
import com.lankin.RESTfullSeviceApacheCXF.model.Author;
import com.lankin.RESTfullSeviceApacheCXF.service.api.models.request.ArticleRequest;
import com.lankin.RESTfullSeviceApacheCXF.service.api.models.request.AuthorRequest;
import com.lankin.RESTfullSeviceApacheCXF.service.api.models.response.ArticleResponse;
import com.lankin.RESTfullSeviceApacheCXF.service.api.models.response.AuthorResponse;
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

@Path("/author")
@Api(value = "/author") // Enables Swagger Documentation
public interface AuthorService {

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    AuthorResponse createAuthorResponse(AuthorRequest authorRequest);


    @GET
    @ApiOperation(value = "Find all Authors", response = Author.class)
    @Produces(MediaType.APPLICATION_JSON)
    List<AuthorResponse> getAuthorResponses() ;

    @GET
    @Path("{id}")
    @ApiOperation(value = "Find Authors by passed ID")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    AuthorResponse getAuthorResponse(@PathParam("id") long id);

    @DELETE
    @Path("{id}")
    @ApiOperation(value = "Deletes an exist Authors with passed ID")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    Response deleteAuthorByID(@PathParam("id") long id);

    @PUT
    @Path("{id}")
    @ApiOperation(value = "Updates an exist Authors with passed Article fields")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    AuthorResponse updateAuthorByID(@PathParam("id") long id, AuthorRequest authorRequest);

}