package com.ll.chatAI.domain.article.articleComment.service;

import com.ll.chatAI.domain.article.articleComment.entity.ArticleComment;
import com.ll.chatAI.domain.article.articleComment.repository.ArticleCommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleCommentService {
    private final ArticleCommentRepository articleCommentRepository;
    public List<ArticleComment> findByAuthorId(long l) {
        return articleCommentRepository.findByAuthor_id(l);
    }
}
