package com.lankin.RESTfullSeviceApacheCXF.service.impl;

import com.lankin.RESTfullSeviceApacheCXF.exception.NotFoundEntityException;
import com.lankin.RESTfullSeviceApacheCXF.mappers.AuthorMapper;
import com.lankin.RESTfullSeviceApacheCXF.model.Author;
import com.lankin.RESTfullSeviceApacheCXF.repository.AuthorRepository;
import com.lankin.RESTfullSeviceApacheCXF.service.api.AuthorService;
import com.lankin.RESTfullSeviceApacheCXF.service.api.models.request.AuthorRequest;
import com.lankin.RESTfullSeviceApacheCXF.service.api.models.response.AuthorResponse;
import lombok.Data;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.ws.rs.core.Response;
import java.util.List;

@Data
public class AuthorServiceImpl implements AuthorService {

    private static final Logger LOG = LogManager.getLogger(AuthorServiceImpl.class);

    private final AuthorRepository authorRepository;

    private final AuthorMapper authorMapper;

    /*@POST*/
    @Override
    public AuthorResponse createAuthorResponse(AuthorRequest authorRequest) {
        LOG.info("created AuthorResponse");
        return authorMapper.AuthorResponseToAuthor(authorRepository.save(
                authorMapper.AuthorToAAuthorRequest(authorRequest)
        ));
    }

    /*@GET*/
    @Override
    public List<AuthorResponse> getAuthorResponses() {
        LOG.info("get List<AuthorResponse>");
       return authorMapper.AuthorToAuthorResponse(authorRepository.findAll());
    }

    /*@GET*/
    @Override
    public AuthorResponse getAuthorResponse(long id) {
        LOG.info("get AuthorResponse by id: " + id);
        /* we need to check whether Article with given id is exist in DB or not */
        authorRepository.findById(id).orElseThrow(NotFoundEntityException::new);
        /*Getting*/
        return authorMapper.AuthorResponseToAuthor(authorRepository.findById(id).get());
    }


    /*@DELETE*/
    @Override
    public Response deleteAuthorByID(long id) {
        LOG.info("delete Response deleteAuthorByID by id: " + id);
        /* we need to check whether Article with given id is exist in DB or not */
        authorRepository.findById(id).orElseThrow(NotFoundEntityException::new);
        /*Deleting*/
        AuthorResponse authorResponse = authorMapper.AuthorResponseToAuthor(authorRepository.findById(id).get());
        authorRepository.deleteById(id);
        return Response.status(204).build();
    }
    /*@PUT*/
    @Override
    public AuthorResponse updateAuthorByID(long id, AuthorRequest authorRequest) {
        LOG.info("putAuthorResponse (update) by id: " + id);

        Author author = authorRepository.findById(id).orElseThrow(NotFoundEntityException::new);
        Author updatedAuthor = new Author();

        checkingFirstNameForNull(authorRequest, author, updatedAuthor);

        checkingLastNameForNull(authorRequest, author, updatedAuthor);

        checkingDescriptionForNull(authorRequest, author, updatedAuthor);

        checkingArticlesForNull(authorRequest, author, updatedAuthor);

        authorRequest = authorMapper.AuthorRequestToAuthor(updatedAuthor);
        updatedAuthor = authorMapper.updateAuthor(author, authorRequest);
        authorRepository.save(author);
        return authorMapper.AuthorResponseToAuthor(author);

    }

    private void checkingArticlesForNull(AuthorRequest authorRequest, Author author, Author updatedAuthor) {
        if(authorRequest.getArticles() != null){
            updatedAuthor.setArticles(authorRequest.getArticles());
        }else {
            updatedAuthor.setArticles(author.getArticles());
        }
    }

    private void checkingDescriptionForNull(AuthorRequest authorRequest, Author author, Author updatedAuthor) {
        if(authorRequest.getDescription() != null){
            updatedAuthor.setDescription(authorRequest.getDescription());
        }else{
            updatedAuthor.setDescription(author.getDescription());
        }
    }

    private void checkingLastNameForNull(AuthorRequest authorRequest, Author author, Author updatedAuthor) {
        if(authorRequest.getLastName() != null){
            updatedAuthor.setLastName(authorRequest.getLastName());
        }else{
            updatedAuthor.setLastName(author.getLastName());
        }
    }

    private void checkingFirstNameForNull(AuthorRequest authorRequest, Author author, Author updatedAuthor) {
        if(authorRequest.getFirstName() != null){
            updatedAuthor.setFirstName(authorRequest.getFirstName());
        }else{
            updatedAuthor.setFirstName(author.getFirstName());
        }
    }

}
