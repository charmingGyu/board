package com.goorm.articleservice.repository;

import com.goorm.articleservice.repository.entity.Article;
import jakarta.persistence.criteria.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
    Article save(Article article);

    Article findArticleByIdAndActivated(Long id, boolean activated);

    Page<Article> findAllByActivated(boolean activated, Pageable pageable);

    void deleteArticleById(Long id);
}
