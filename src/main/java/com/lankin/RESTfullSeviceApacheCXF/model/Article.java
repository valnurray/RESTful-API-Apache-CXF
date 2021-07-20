package com.lankin.RESTfullSeviceApacheCXF.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Objects;

/**
 * Class {@code Article} in package {@code com.lankin.RESTfullSeviceApacheCXF.model}
 *
 * Entity in DB
 *
 * @author Nikita Lankin
 * @version 1.0
 *
 */
@Data
@Entity
@Table(name = "article", schema = "lankin")
@XmlRootElement
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "title")
    @NotNull
    @Size(max = 120, message = "title must be less then 120 characters")
    private String title;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "author_id")
    @JsonManagedReference
    private Author author;

    @Column(name = "body")
    @Size(max = 255, message
            = "body must be less then 255 characters")
    private String body;

}