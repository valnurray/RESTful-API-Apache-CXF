package com.lankin.RESTfullSeviceApacheCXF.model;

import lombok.Data;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
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
//    @XmlElement
    private long id;

    @Column(name = "title", nullable = false)
//    @XmlElement
    private String title;

    @Column(name = "author", nullable = false)
//    @XmlElement
    private String author;

    @Column(name = "body")
//    @XmlElement
    private String body;
}
