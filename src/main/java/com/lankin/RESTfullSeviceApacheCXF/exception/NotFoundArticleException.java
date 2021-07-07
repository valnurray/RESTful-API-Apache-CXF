package com.lankin.RESTfullSeviceApacheCXF.exception;

import com.lankin.RESTfullSeviceApacheCXF.constants.Constants;

import javax.ejb.ApplicationException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@ApplicationException
public class NotFoundArticleException extends WebApplicationException {

    @Override
    public Response getResponse() {
        return Response.status(Response.Status.NOT_FOUND).entity(Constants.MESSAGE_ARTICLE_NOT_FOUND).type(MediaType.APPLICATION_JSON).build();
    }
}
