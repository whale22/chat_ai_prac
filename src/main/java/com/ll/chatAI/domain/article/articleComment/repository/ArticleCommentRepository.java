package com.ll.chatAI.domain.article.articleComment.repository;

import com.ll.chatAI.domain.article.articleComment.entity.ArticleComment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ArticleCommentRepository extends JpaRepository<ArticleComment, Long> {
    Optional<ArticleComment> findById(Long id);

    List<ArticleComment> findByAuthor_id(long id);
}
