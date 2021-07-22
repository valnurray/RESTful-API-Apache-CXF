package com.lankin.RESTfullSeviceApacheCXF.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.springframework.web.servlet.View;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;
import java.util.Objects;

@Data
@Entity
@Table(name = "author", schema = "lankin")
@XmlRootElement
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "author_id")
    private long id;

    @Column(name = "first_name")
    @NotNull
    @Size(max = 55, message = "firstName must be less then 55 characters")
    @JsonIgnore
    private String FirstName;

    @Column(name = "last_name")
    @NotNull
    @Size(max = 55, message = "lastName must be less then 55 characters")
    @JsonIgnore
    private String LastName;

    @Column(name = "description")
    @NotNull
    @Size(max = 255, message = "Description must be less then 120 characters")
    @JsonIgnore
    private String Description;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
//    @JsonBackReference
    @JsonIgnore
    private List<Article> articles;


}
