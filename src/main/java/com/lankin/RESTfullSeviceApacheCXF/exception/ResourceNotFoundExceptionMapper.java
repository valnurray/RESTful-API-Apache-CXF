package com.lankin.RESTfullSeviceApacheCXF.exception;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.springframework.beans.factory.annotation.Value;

@Provider
public class ResourceNotFoundExceptionMapper implements ExceptionMapper<ResourceNotFoundException> {

    @Value("${message.ResourceNotFound}")
    String message;


    @Override
    public Response toResponse(ResourceNotFoundException e) {
        return Response.serverError().entity(message).type(MediaType.APPLICATION_JSON).build();
    }
}