package com.lankin.RESTfullSeviceApacheCXF.exception;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.lankin.RESTfullSeviceApacheCXF.constants.Constants;

//@Provider
public class ResourceNotFoundExceptionMapper {
//        implements ExceptionMapper<ResourceNotFoundException> {
//
//    @Override
//    public Response toResponse(ResourceNotFoundException e) {
////        return Response.serverError().entity(Constants.MESSAGE_ARTICLE_NOT_FOUND).type(MediaType.APPLICATION_JSON).build();
////        return Response.status(404).entity(Constants.MESSAGE_ARTICLE_NOT_FOUND + " " + e).type(MediaType.APPLICATION_JSON).build();
//        return Response.status(Response.Status.NOT_FOUND).entity(Constants.MESSAGE_ARTICLE_NOT_FOUND).build();
//    }
}