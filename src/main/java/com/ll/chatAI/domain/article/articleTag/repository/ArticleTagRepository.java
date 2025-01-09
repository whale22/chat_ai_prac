package com.ll.chatAI.domain.article.articleTag.repository;

import com.ll.chatAI.domain.article.articleTag.entity.ArticleTag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ArticleTagRepository extends JpaRepository<ArticleTag, Long> {
    Optional<ArticleTag> findById(Long id);

    List<ArticleTag> findByAuthor_id(long l);

    List<ArticleTag> findByAuthor_author(String username);
}
