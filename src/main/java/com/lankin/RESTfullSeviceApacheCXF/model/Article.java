package com.lankin.RESTfullSeviceApacheCXF.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

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
@Table(name = "article")
@XmlRootElement
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "title")
    @NotNull
    @Size(max = 120, message = "title must be less then 120 characters")
    private String title;

    @Column(name = "author")
    @NotNull
    @Size(max = 75, message = "author must be less then 75 characters")
    private String author;

    @Column(name = "body")
    @Size(max = 255, message
            = "body must be less then 255 characters")
    private String body;

}
