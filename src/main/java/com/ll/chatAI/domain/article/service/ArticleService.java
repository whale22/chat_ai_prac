package com.ll.chatAI.domain.article.service;

import com.ll.chatAI.domain.article.entity.Article;
import com.ll.chatAI.domain.article.repository.ArticleRepository;
import com.ll.chatAI.global.rsData.RsData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ArticleService {
    private final ArticleRepository articleRepository;
    public RsData<Article> write(long number, String title, String content) {
        Article article = Article.builder()
                .number(number)
                .title(title)
                .content(content)
                .build();

        articleRepository.save(article);

        return RsData.of("200", "글 작성에 성공했습니다.", article);
    }
}
