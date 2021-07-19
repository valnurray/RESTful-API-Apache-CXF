package com.lankin.RESTfullSeviceApacheCXF.service.impl;

import com.lankin.RESTfullSeviceApacheCXF.MockData;
import com.lankin.RESTfullSeviceApacheCXF.exception.NotFoundEntityException;
import com.lankin.RESTfullSeviceApacheCXF.mappers.AuthorMapper;
import com.lankin.RESTfullSeviceApacheCXF.model.Author;
import com.lankin.RESTfullSeviceApacheCXF.repository.AuthorRepository;
import com.lankin.RESTfullSeviceApacheCXF.service.api.AuthorService;
import com.lankin.RESTfullSeviceApacheCXF.service.api.models.request.AuthorRequest;
import com.lankin.RESTfullSeviceApacheCXF.service.api.models.response.AuthorResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
class AuthorServiceImplTest {

    private AuthorService authorService;

    @MockBean
    private AuthorRepository authorRepository;

    private AuthorMapper authorMapper;

    @BeforeEach
    void setup() {
        authorMapper = Mappers.getMapper(AuthorMapper.class);
        authorService = new AuthorServiceImpl(authorRepository, authorMapper);
    }

    @Test
    void createAuthorResponse() {
        Author author = MockData.getFirstAuthor();

        doReturn(author).when(authorRepository).save(any());
        // Execute the service call
        AuthorResponse authorResponse1 =  authorService.createAuthorResponse(authorMapper.AuthorRequestToAuthor(author));

        // Assert the response
        Assertions.assertNotNull(authorResponse1, "The saved widget should not be null");
        Assertions.assertEquals(1L,authorResponse1.getId(), "should be some");
        org.assertj.core.api.Assertions.assertThat(author.getId()).isGreaterThan(0);
    }

    @Test
    @DisplayName("Test findAll")
    void getAuthorResponses() {
        // Setup our mock repository
        Author author1 = MockData.getFirstAuthor();
        Author author2 = MockData.getSecondAuthor();

        doReturn(Arrays.asList(author1, author2)).when(authorRepository).findAll();

        // Execute the service call
        List<AuthorResponse> authorResponseList = authorService.getAuthorResponses();

        // Assert the response
        Assertions.assertEquals(2, authorResponseList.size(), "findAll should return 2 articles");
    }

    @Test
    @DisplayName("Test findById Success")
    public void testGetAuthorResponseById() {

        // Setup our mock repository
        Author author = MockData.getFirstAuthor();
        doReturn(Optional.of(author)).when(authorRepository).findById(1L);

        AuthorResponse returnedResponse = authorService.getAuthorResponse(1L);
        Assertions.assertEquals(1L, returnedResponse.getId());
        Assertions.assertNotNull(returnedResponse, "Should not be null");

    }


    @Test
    @DisplayName("Test delete author by id")
    public void deleteAuthorByID() {
        // Setup our mock repository
        Author author = MockData.getFirstAuthor();
        when(authorRepository.findById(author.getId())).thenReturn(Optional.of(author));
        authorService.deleteAuthorByID(author.getId());
        verify(authorRepository).deleteById(author.getId());

    }

    @Test
    void updateAuthorByID() {
        // Setup our mock repository
        Author author = MockData.getFirstAuthor();
        AuthorRequest newAuthor = MockData.getFirstAuthorRequest();
        given(authorRepository.findById(author.getId())).willReturn(Optional.of(author));

        //update Repository
        authorService.updateAuthorByID(author.getId(), newAuthor);

        //Compare
        Assertions.assertTrue(newAuthor.getFirstName().equals(author.getFirstName()));
        Assertions.assertTrue(newAuthor.getLastName().equalsIgnoreCase(author.getLastName()));
        Assertions.assertTrue(newAuthor.getDescription().equalsIgnoreCase(author.getDescription()));
        Assertions.assertTrue(newAuthor.getArticles().equals(author.getArticles()));

        verify(authorRepository).findById(author.getId());

    }

    @Test
    @DisplayName("Test findById, update, delete with Exception")
    public void testGetAuthorByIdUpdateAuthorByIdDeleteAuthorByIdThrowException() {
//        // Setup our mock repository
        Author author = MockData.getFirstAuthor();

        Assertions.assertThrows(NotFoundEntityException.class,
                ()->{
                    authorService.getAuthorResponse(100000L);
                });
    }

}