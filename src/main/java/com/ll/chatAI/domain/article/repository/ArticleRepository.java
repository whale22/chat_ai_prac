package com.ll.chatAI.domain.article.repository;

import com.ll.chatAI.domain.article.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ArticleRepository extends JpaRepository<Article, Long> {
    Optional<Article> findById(Long id);
    List<Article> findByAuthor_id(long id);
}
