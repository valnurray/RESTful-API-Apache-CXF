package com.lankin.RESTfullSeviceApacheCXF.repository;

import com.lankin.RESTfullSeviceApacheCXF.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Class {@code ArticleRepository} in package {@code com.lankin.RESTfullSeviceApacheCXF.repository}
 * Repository
 * SimpleRepository.class already have @Repository annotation and JpaRepository extends from it
 *
 * @author Nikita Lankin
 * @version 1.0
 *
 */
public interface ArticleRepository extends JpaRepository<Article, Long> {
}
