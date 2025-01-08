package com.ll.chatAI.domain.article.repository;

import com.ll.chatAI.domain.article.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}
