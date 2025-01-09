package com.ll.chatAI.domain.article.articleTag.service;

import com.ll.chatAI.domain.article.articleTag.entity.ArticleTag;
import com.ll.chatAI.domain.article.articleTag.repository.ArticleTagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleTagService {
    private final ArticleTagRepository articleTagRepository;
    public List<ArticleTag> findByAuthorId(long l) {
        return articleTagRepository.findByAuthor_id(l);
    }

    public List<ArticleTag> findByAuthorUsername(String user1) {
        return articleTagRepository.findByAuthor_author(user1);
    }
}
