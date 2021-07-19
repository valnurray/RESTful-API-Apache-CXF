package com.lankin.RESTfullSeviceApacheCXF.service.impl;

import com.lankin.RESTfullSeviceApacheCXF.MockData;
import com.lankin.RESTfullSeviceApacheCXF.mappers.AuthorMapper;
import com.lankin.RESTfullSeviceApacheCXF.model.Author;
import com.lankin.RESTfullSeviceApacheCXF.repository.AuthorRepository;
import com.lankin.RESTfullSeviceApacheCXF.service.api.AuthorService;
import com.lankin.RESTfullSeviceApacheCXF.service.api.models.response.AuthorResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

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
    void createArticleResponse() {
        Author author = MockData.getFirstAuthor();

        doReturn(author).when(authorRepository).save(any());
        // Execute the service call
        AuthorResponse authorResponse1 =  authorService.createAuthorResponse(authorMapper.AuthorRequestToAuthor(author));

        // Assert the response
        Assertions.assertNotNull(authorResponse1, "The saved widget should not be null");
        Assertions.assertEquals(1L,authorResponse1.getId(), "should be some");
        org.assertj.core.api.Assertions.assertThat(author.getId()).isGreaterThan(0);
    }

}