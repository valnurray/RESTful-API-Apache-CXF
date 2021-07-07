package com.lankin.RESTfullSeviceApacheCXF.model;


import lombok.Data;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

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

//    private static final long serialVersionUID = 7875622941513777868L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "author", nullable = false)
    private String author;

    @Column(name = "body")
    private String body;


}
