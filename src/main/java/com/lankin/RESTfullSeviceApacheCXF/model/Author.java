package com.lankin.RESTfullSeviceApacheCXF.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

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
    private String FirstName;

    @Column(name = "last_name")
    @NotNull
    @Size(max = 55, message = "lastName must be less then 55 characters")
    private String LastName;

    @Column(name = "description")
    @NotNull
    @Size(max = 255, message = "Description must be less then 120 characters")
    private String Description;

    @OneToMany(mappedBy = "author",/* cascade = CascadeType.ALL,*/fetch = FetchType.EAGER,orphanRemoval = true)
    @JsonBackReference
    private List<Article> articles;

}
